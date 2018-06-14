const router = require('express').Router();
const passport = require('passport');
const crypto = require('../utils/crypto');
const User = require('../models/User');

router.get('/login', (req, res) => {
	if (req.user) {
		res.redirect('/');
		return;
	}
    const message = req.session.message;
    req.session.message = '';
    res.render('users/login', {
    	'isAdmin':false,
    	'isLoggedIn': false,
        message
    });
});

router.post('/login', passport.authenticate('local'), (req, res) => {
	if (req.user) {
		User.findById(req.user).then(function(user) {
			req.session.user = {};
			req.session.user.username = user.username;
			req.session.user.role = user.role;
			req.session.user._id = user._id;
			req.session.message = "Login successful";
		    res.redirect('/');
		});
	}
});

router.get('/register', (req, res) => {
	if (req.user) {
		res.redirect('/');
		return;
	}
    const message = req.session.message;
    req.session.message = '';
    res.render('users/register', {
        message,
        'isAdmin':false,
    	'isLoggedIn': false
    });
});

router.post('/register', (req, res) => {
	if (req.user) {
		res.redirect('/');
		return;
	}
    const {
        username,
        password
    } = req.body;

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
    		req.session.user = {};
			req.session.user.username = user.username;
			req.session.user.role = user.role;
			req.session.user._id = user._id;
			req.session.message = "Registration successful";
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