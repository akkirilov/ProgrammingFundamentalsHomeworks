const passport = require('passport');
const LocalPassport = require('passport-local');
const User = require('../models/User');
const crypto = require('../utils/crypto');

function initialize() {
	passport.use(new LocalPassport((username, password, done) => {
		User.find({'username': username })
		.then(function(users) {
			if (users.length < 1) {
				return done(null, false);		
			}
			let user = users[0];
			if (crypto.generateHashedPassword(user.salt, password.toString()) === user.password) {
				return done(null, user._id);
			}
			return done(null, false);
		});
	}));

	passport.serializeUser((user, done) => {
		if (user){
			
//			return done(null, user._id, user._username, user.role);
			return done(null, user._id);
		}
	});

	passport.deserializeUser((id, done) => {
		User.findById(id).then(function(user) {
			if(!user) {
				return done(null, false)
			}
			return done(null, user._id);
		});
	});
}


function isAuthenticated(req, res, next) {
	if (req.user === undefined) {
		return res.redirect('/auth/login');
	}
	next();
}

function isAdmin(req, res, next) {
	isAuthenticated(req, res, next);
	if (req.session.user.role !== 'admin') {
		req.session.message = "You don`t have permission!";
		return res.redirect('/');
	}
	next();
}

module.exports = {
		initialize,
		isAuthenticated,
		isAdmin
}
