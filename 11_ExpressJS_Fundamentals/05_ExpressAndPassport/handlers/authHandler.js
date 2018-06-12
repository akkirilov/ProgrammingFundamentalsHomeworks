const router = require('express').Router();
const passport = require('passport');
const LocalPassport = require('passport-local');
const crypto = require('../utils/crypto');

const User = require('../models/User');

passport.use(new LocalPassport((username, password, done) => {
	User.find({'username': username })
	.then(function(users) {
		if (users.length < 1) {
			return done(null, false);		
		}
		let user = users[0];
		if (crypto.generateHashedPassword(user.salt, password.toString()) === user.password) {
			return done(null, user);
		}
	});
}));

passport.serializeUser((user, done) => {
	if (user){
		return done(null, user._id);
	}
});

passport.deserializeUser((id, done) => {
	User.findById(id).then(function(user) {
		if(!user) {
			return done(null, false)
		}
		return done(null, user.username);
	});
});

router.get('/login', (req, res) => {
    const message = req.session.message;
    req.session.message = '';
    res.render('users/login', {
        message,
        inputData: req.session.inputData
    });
});

router.post('/login', passport.authenticate('local'), (req, res) => {
    req.session.message = "Login successful";
    res.redirect('/');
});

router.get('/register', (req, res) => {
    const message = req.session.message;
    req.session.message = '';
    res.render('users/register', {
        message,
        inputData: req.session.inputData
    });
});

router.post('/register', (req, res) => {
    const {
        username,
        password,
        repeat
    } = req.body;
    if (password !== repeat) {
        return error("Passwords don't match");
    }

    User.find({username}).then(function(targetUser) {
    	if (targetUser.length > 0) {
    		return error("Username taken!");
		}
    	const salt = crypto.generateSalt();
        const hashedPass = crypto.generateHashedPassword(salt, password);
        const user = {
            username,
            salt,
            password: hashedPass
        };
    	User.create(user).then(function(newUser) {
        	req.login(newUser, err => {
                if (err) {
                    return error("Something went wrong");
                }
                req.session.message = "Registration successful";
                return res.redirect('/');
            });
    	});
	});
   
    function error(message) {
        req.session.inputData = {
            username,
            password,
            repeat
        };
        req.session.message = message;
        return res.redirect('/auth/register');
    }
});

router.get('/logout', (req, res) => {
	req.logout();
		req.session.destroy(function (err) {
		return res.redirect('/');
	 });
});

module.exports = router;