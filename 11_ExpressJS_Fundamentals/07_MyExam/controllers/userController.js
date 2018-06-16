const User = require('../models/User');
const router = require('express').Router();
const passport = require('passport');
const encryption = require('../utilities/encryption');

function getLogin(req, res) {
	if (req.user) {
		req.session.message = 'You are already logged in!';
		return res.redirect('/');
	}
	const message = req.session.message;
	req.session.message = '';
	let isAdmin = false;
	let isLoggedIn = false;
	res.render('users/login', {
		message,
		isLoggedIn,
		isAdmin
	});
}

function postLogin(req, res) {
	if (req.user) {
		User.findById(req.user).then(function(user) {
			req.session.user = {};
			req.session.user.username = user.username;
			req.session.user.isAdmin = user.isAdmin();
			req.session.message = "Login successful!";
			return res.redirect('/');
		});
	} else {
		req.session.message = "There are problem during login!";
		return res.redirect('/error');
	}
}

function getRegister(req, res) {
	if (req.user) {
		req.session.message = 'You are already logged in!';
		return res.redirect('/');
	}
	const message = req.session.message;
	req.session.message = '';
	let isAdmin = false;
	let isLoggedIn = false;
	let formData = req.session.formData;
	delete req.session.formData;
	res.render('users/register', {
		message,
		isLoggedIn,
		isAdmin,
		formData
	});
}

function postRegister(req, res) {
	if (req.user) {
		req.session.message = 'You are already logged in!';
		return res.redirect('/');
	}
	const {
		username,
		password,
		passwordRepeat,
		gender,
		age,
		firstName,
		lastName
	} = req.body;
	if (password !==  passwordRepeat) {
		return error("Passwords not match!");
	}
	User.find({username}).then(function(targetUser) {
		if (targetUser.length > 0) {
			return error("Username is already taken!");
		}
		const salt = encryption.generateSalt();
		const hashedPass = encryption.generateHashedPassword(salt, password);
		const user = {
				username,
				salt,
				password: hashedPass,
				gender,
				age: Number(age),
				firstName,
				lastName,
				roles: ['user']
		};
		User.create(user).then(function(newUser) {
			req.session.user = {};
			req.session.user.username = newUser.username;
			req.session.user.isAdmin = false;
			req.session.message = "Registration successful!";
			req.login(newUser, err => {
				if (err) {
					return error("Something went wrong!");
				}
				req.session.message = "Registration successful!";
				return res.redirect('/');
			});
		}).catch(function(err) {
			console.log(err);
			return error(err.message);
		});
	});

	function error(message) {
		req.session.formData = {
				username,
				password,
				passwordRepeat:'',
				gender,
				age,
				firstName,
				lastName
		};
		req.session.message = message;
		return res.redirect('/users/register');
	}
}

function getLogout(req, res) {
	req.logout();
	req.session.destroy(function (err) {
		return res.redirect('/');
	});
}

router.get('/login', getLogin);
router.post('/login', passport.authenticate('local'), postLogin);
router.get('/register', getRegister);
router.post('/register', postRegister);
router.get('/logout', getLogout);

module.exports = router;