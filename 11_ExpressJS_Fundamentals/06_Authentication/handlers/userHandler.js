const router = require('express').Router();
const User = require('../models/User');

function getProfile(req, res) {
	if (req.user) {
		
	    User.findById(req.params.id).populate('rentedCars').then(function(user) {
		    let isLoggedIn = true;
		    let isAdmin = false;
		    if (user.role === 'admin') {
	    		isAdmin = true;
			}
		    let rentedCars = user.rentedCars;
		    const message = req.session.message;
		    req.session.message = '';
		    res.render('users/profile', {
		    	isLoggedIn,
		    	isAdmin,
		        message,
		        username: req.session.user.username,
		        userId : req.user,
		        rentedCars
		    });
		}).catch(function(err) {
			console.log(err);
			res.redirect('/error404');
		});
	} else {
		res.redirect('/auth/login');
	}
}

router.get('/profile/:id', getProfile);

module.exports = router;