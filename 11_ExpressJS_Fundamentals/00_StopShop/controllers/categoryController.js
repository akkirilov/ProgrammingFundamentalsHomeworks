const router = require('express').Router();
const Category = require('../models/Category');
const User = require('../models/User');

function getAddCategory(req, res){
	if (!req.user) {
		req.session.message = 'You are not legged in!';
		return res.redirect('/users/login');
	}
	let isLoggedIn = true;
	let isAdmin = req.session.user.isAdmin;
	const message = req.session.message;
	req.session.message = '';
	res.render('categories/addCategory', {
		message,
		isLoggedIn,
		isAdmin
	});
}

function postAddCategory(req, res){
	if (!req.user) {
		req.session.message = 'You are not legged in!';
		return res.redirect('/users/login');
	}
	let isLoggedIn = true;
	let isAdmin = req.session.user.isAdmin;
	let category = {
			name: req.body.name,
			creator: req.user
	};
	Category.find({name: category.name}).then(function(data) {
		if (data.length > 0) {
			req.session.message = 'Category already exists!';
			return res.redirect('/categories/addCategory');
		}
		Category.create(category).then(function(c) {
			User.findById(req.user).then(function(user) {
				user.createdCategories.push(c._id);
				user.save();
				req.session.message = 'Category created!';
				return res.redirect('/');
			});
		}).catch(function(err) {
			console.log(err);
			res.render('error/error');
		});
	}).catch(function(err) {
		console.log(err);
		res.render('error/error');
	});
}

router.get('/add', getAddCategory);
router.post('/add', postAddCategory);


module.exports = router;
