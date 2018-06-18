const User = require('../models/User');
const Article = require('../models/Article');
const Version = require('../models/Version');
const data = require('./dbImport');

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
				User.create(data.users).then(function(newUsers) {
					for (let a of data.articles) {
						let content = a.content;
						delete a.content;
						Article.create(a).then(function(newArticle) {
							Version.create({
								article: newArticle._id,
								author: newUsers[0]._id,
								content: content,
								editDate: newArticle.creationDate
							}).then(function(newVersion) {
								newArticle.versions.push(newVersion._id);
								newArticle.save();
							});
						});
					}
				});
				console.log('CREATE ADMIN: admin@admin.com with password: aaa');
				console.log('CREATE USER: user@user.com with password: aaa');
				console.log('CREATE ARTICLES: test articles created');
				console.log('DataBase ready ...');
			} else {
				console.log('DataBase ready ...');
			}
		});
	});
}
