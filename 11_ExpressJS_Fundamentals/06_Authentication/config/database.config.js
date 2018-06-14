const mongoose = require('mongoose');
mongoose.Promise = global.Promise;

const fs = require('fs');
const path = require('path');
const User = require('../models/User');
const Car = require('../models/Car');

module.exports = function(config) {
	mongoose.connect(config.connectionString);
	let db = mongoose.connection;
	db.once('open', function(err) {
		if (err) {
			console.log(err);
			return;
		}
		User.find().then(function(users) {
			if (users.length < 1) {
				let data = require('../infrastructure/initialData.js');
				User.create(data.users).then(function(newUsers) {
					console.log('Users initalized...');
					Car.create(data.cars).then(function(newCars) {
						console.log('Cars initalized...');
						console.log('Database ready...');
					});
				});
			} else {
				console.log('Database ready...');
			}
		});
	});
};
