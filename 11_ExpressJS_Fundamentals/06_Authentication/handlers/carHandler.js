const router = require('express').Router();
const Car = require('../models/Car');
const User = require('../models/User');

function getAll(req, res) {
    Car.find().then(function(cars) {
        let isLoggedIn = false;
        let isAdmin = false;
        if (req.user) {
        	isLoggedIn = true;
        	if (req.session.user.role === 'admin') {
        		isAdmin = true;
        		for (let c of cars) {
					c.isAdmin = true;
				}
    		}
    	}
    	const message = req.session.message;
        req.session.message = '';
        res.render('cars/all', {
        	isLoggedIn,
        	isAdmin,
            message,
            cars,
	        userId : req.user
        });
	});
    
}

function getRent(req, res) {
	if (!req.user) {
		req.session.message = 'You need to be logged in to rent a car!';
		res.redirect('/auth/login');
		return;
	}
	Car.findById(req.params.id).then(function(car) {
		if (car && car.make) {
			User.findById(req.user).then(function(user) {
				user.rentedCars.push(car._id);
				user.save();
				car.rented = Number(car.rented) + 1;
				car.save();
				req.session.message = `${car.make} ${car.model} rented!`;
				res.redirect('/users/profile/' + req.user);
			});
		}
	}).catch(function(err) {
		console.log(err);
		res.render('error/error', { message: 'No such car for renting!' });
	});
	
}

function getCreate(req, res) {
	if (!req.session.user || req.session.user.role !== 'admin') {
		req.session.message = "You don't have permission!";
		res.redirect('/');
		return;
	}
	let isLoggedIn = true;
    let isAdmin = true;
    const message = req.session.message;
    req.session.message = '';
    res.render('cars/create', {
    	isLoggedIn,
    	isAdmin,
    	userId : req.user,
        message
    });
}

function postCreate(req, res) {
	if (!req.session.user || req.session.user.role !== 'admin') {
		req.session.message = "You don't have permission!";
		res.redirect('/');
		return;
	}
	const {
        make,
        model,
        color,
        imageUrl
    } = req.body;
    let car = {
            make,
            model,
            color,
            imageUrl,
            rented: 0
        };
    Car.create(car).then(function(newCar) {
    	let message = req.session.message;
    	req.session.message = `${newCar.make} ${newCar.model} created!`;
    	res.redirect('/');
	}).catch(function(err) {
		console.log(err);
		res.render('error/error');
	});
}

function getEdit(req, res) {
	if (!req.session.user || req.session.user.role !== 'admin') {
		req.session.message = "You don't have permission!";
		res.redirect('/');
		return;
	}
	Car.findById(req.params.id).then(function(car) {
		let isLoggedIn = true;
	    let isAdmin = true;
	    const message = req.session.message;
	    req.session.message = '';
	    res.render('cars/edit', {
	    	isLoggedIn,
	    	isAdmin,
	        message,
	        userId : req.user,
	        car
	    });
	}).catch(function(err) {
		console.log(err);
		res.render('error/error');
	});
}

function postEdit(req, res) {
	if (!req.session.user || req.session.user.role !== 'admin') {
		req.session.message = "You don't have permission!";
		res.redirect('/');
		return;
	}
	Car.findById(req.params.id).then(function(car) {
		car.make = req.body.make;
		car.color = req.body.color;
		car.model = req.body.model;
		car.imageUrl = req.body.imageUrl;
		car.save();
		req.session.message = `${car.make} ${car.model} edited!`
	    res.redirect('/');
	}).catch(function(err) {
		console.log(err);
		res.render('error/error');
	});
}

function getDelete(req, res) {
	if (!req.session.user || req.session.user.role !== 'admin') {
		req.session.message = "You don't have permission!";
		res.redirect('/');
		return;
	}
	Car.findById(req.params.id).then(function(car) {
		let isLoggedIn = true;
	    let isAdmin = true;
	    const message = req.session.message;
	    req.session.message = '';
	    res.render('cars/delete', {
	    	isLoggedIn,
	    	isAdmin,
	    	userId : req.user,
	        message,
	        car
	    });
	}).catch(function(err) {
		console.log(err);
		res.render('error/error');
	});
}

function postDelete(req, res) {
	if (!req.session.user || req.session.user.role !== 'admin') {
		req.session.message = "You don't have permission!";
		res.redirect('/');
		return;
	}
	Car.findByIdAndDelete(req.params.id).then(function(car) {
		req.session.message = `${car.make} ${car.model} deleted!`
	    res.redirect('/');
	}).catch(function(err) {
		console.log(err);
		res.render('error/error');
	});
}

router.get('/all', getAll);
router.get('/create', getCreate);
router.post('/create', postCreate);
router.get('/rent/:id', getRent);
router.get('/edit/:id', getEdit);
router.post('/edit/:id', postEdit);
router.get('/delete/:id', getDelete);
router.post('/delete/:id', postDelete);

module.exports = router;
