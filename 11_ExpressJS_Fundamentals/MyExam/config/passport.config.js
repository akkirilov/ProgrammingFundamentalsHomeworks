const passport = require('passport');
const LocalPassport = require('passport-local');
const User = require('../models/User');
const encryption = require('../utilities/encryption');

function initialize() {
	passport.use(new LocalPassport((username, password, done) => {
		User.find({'email': username })
		.then(function(users) {
			if (users.length < 1) {
				return done(null, false);		
			}
			let user = users[0];
			if (encryption.generateHashedPassword(user.salt, password.toString()) === user.password) {
				return done(null, user._id);
			}
			return done(null, false);
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
			return done(null, user._id);
		});
	});
}

module.exports = initialize;
