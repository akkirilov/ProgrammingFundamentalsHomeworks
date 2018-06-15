				const User = require('../models/User');
				const encryption = require('../utilities/encryption');
const mongoose = require('mongoose');
mongoose.Promise = global.Promise;

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
				const salt = encryption.generateSalt();
				const hashedPass = encryption.generateHashedPassword(salt, 'aaa'); 
				const admin = {
						firstName: 'Admin',
						lastName: 'Adminov',
						age: 100,
						gender: 'Male',
						roles: ['admin'],
						username: 'admin',
						salt,
						password: hashedPass
				}
				User.create(admin).then(function(users) {
					console.log("Admin 'admin' created with pass 'aaa'");
				});
			}
		});
		console.log('DataBase ready ...');
	});
}
