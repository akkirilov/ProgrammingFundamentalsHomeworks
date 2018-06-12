const mongoose = require('mongoose');
mongoose.Promise = global.Promise;

const fs = require('fs');
const path = require('path');
const Meme = require('../models/Meme');
const Genre = require('../models/Genre');

module.exports = function(config) {
	mongoose.connect(config.connectionString);
	let db = mongoose.connection;
	db.once('open', function(err) {
		if (err) {
			console.log(err);
			return;
		}
		Meme.find().then(function(memes) {
			if(!memes || memes.length < 1) {
				console.log('Initialize Database...');
				Genre.find().then(function(genres) {
					if(genres.length < 1) {
						fs.readFile(path.normalize(path.join(__dirname, '../db/genresDefaultDB.json')), function(err, jsonGenres) {
							Genre.collection.insertMany(JSON.parse(jsonGenres), function(err, newGenres) {
								let genresIds = newGenres.insertedIds;
								fs.readFile(path.normalize(path.join(__dirname, '../db/memesDefaultDB.json')), function(err, jsonMemes) {
									jsonMemes = JSON.parse(jsonMemes);
									for (let m of jsonMemes) {
										let tempRandom = (Math.floor(Math.random() * Object.keys(genresIds).length));
										let tempGenreId = genresIds[tempRandom];
										m.genre = tempGenreId;
										Meme.create(m).then(function(newMeme) {
											Genre.findById(tempGenreId).then(function(usedGenre) {
												usedGenre.memes.push(newMeme._id);
												usedGenre.save();
											});
											console.log('New meme inserted...');
										});
									}
								});
								console.log('New genres inserted...');
							});
						});
					} else {
						let defaultId = genres[0]._id;
						fs.readFile(path.normalize(path.join(__dirname, '../db/memesDefaultDB.json')), function(err, jsonMemes) {
							jsonMemes = JSON.parse(jsonMemes);
							for (let m of jsonMemes) {
								m.genre = defaultId;
								Meme.create(m).then(function(newMeme) {
									Genre.findById(defaultId).then(function(defaultGenre) {
										defaultGenre.memes.push(newMeme._id);
										defaultGenre.save();
									});
									console.log('New meme inserted...');
								});
							}
						});
						console.log('DataBase ready ...');
					}
				});
			} else {
				console.log('DataBase ready ...');
			}
		});
	});
}
