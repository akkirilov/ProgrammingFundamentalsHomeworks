const Meme = require('../models/Meme');
const Genre = require('../models/Genre');
const defaultError = require('./errorHandler').getDefaultError;
const fs = require('fs');
const shortid = require('shortid');
const formidable = require('formidable');
const path = require('path');
const pathPrefix = path.normalize(path.join(__dirname, "../"));
const staticDir = 'public';
const imageDir = '/images/memeStorage/';

function getViewAllMemes(req, res) {
	Meme.find().then(function(memes) {
		memes = memes.sort((a, b) => {
			return b.dateStamp - a.dateStamp
	    });
		res.render('memes/viewAll', {memes, pageTitle: 'Memes'});
	}).catch(defaultError);
}

function getAddMeme(req, res) {
	Genre.find().then(function(genres) {
		res.render('memes/addMeme', {genres, pageTitle: 'Add Meme'});
	}).catch(defaultError);
}

function postAddMeme(req, res) {
	let form = new formidable.IncomingForm();
	form.parse(req, function (err, fields, files) {
		Genre.findById(fields.genre).then(function(genre) {
			if (!genre.name) {
				res.redirect('/memes/add');
        		return;
			}
			let meme = {
					title: fields.title,
					description: fields.description,
					privacy: fields.privacy,
					genre: fields.genre
			};
			if (files.memeSrc.name !== '') {
				let filename = shortid.generate() + '.' + files.memeSrc.type.split('/').pop();
				let tempPath = files.memeSrc.path;
		      	let newPath = pathPrefix + staticDir + imageDir + filename;
		        fs.rename(tempPath, newPath, function (err) {
		        	if (err) {
		        		res.render('error/error');
		        		console.log(err);
		        	}
		        });
		        meme.memeSrc = imageDir + filename;
			} else {
				meme.memeSrc = imageDir + 'default.jpeg';
			}
			Meme.create(meme).then(function(m) {
				genre.memes.push(m._id);
				genre.save();
				res.redirect('/memes/details/' + m._id);
			}).catch(defaultError);
		}).catch(defaultError);
	});
}

function getMemeDetails(req, res) {
	let id = req.params.id;
	Meme.findById(id).populate('genre').then(function(meme) {
		res.render('memes/memeDetails', {meme, pageTitle: 'Meme details'});
	}).catch(defaultError);
}

function getMemeSearch(req, res) {
	let searched = req.query.title;
	Meme.find().then(function(memes) {
		memes = memes
		.filter(x => x.title.toString().toLowerCase().includes(searched))
		.sort((a, b) => {
			return b.dateStamp - a.dateStamp
	    });
		res.render('memes/viewAll', {memes, pageTitle: 'Search results'});
	}).catch(defaultError);
}

function getViewByGenre(req, res) {
	let searched = req.params.genreId;
	Meme.find({'genre': req.params.genreId}).then(function(memes) {
		memes = memes
		.filter(x => x.genre.toString() == searched)
		.sort((a, b) => {
			return b.dateStamp - a.dateStamp
	    });
		res.render('memes/viewAll', {memes, pageTitle: 'Memes by genre'});
	}).catch(defaultError);
}

function getEditMeme(req, res) {
	Genre.find().then(function(genres) {
		Meme.findById(req.params.id).then(function(meme) {
			if (!meme) {
	    		res.render('error/error');
	    		return;
	    	}
			for (let g of genres) {
				if (g._id.toString() === meme.genre.toString()) {
					g.selected = true;
				} else {
					g.selected = false;
				}
			}
			res.render('memes/editMeme', {meme, genres, pageTitle: 'Edit Meme'});
		}).catch(defaultError);
	}).catch(defaultError);
	
}

function postEditMeme(req, res) {
	Meme.findById(req.params.id).then(function(meme) {
		let form = new formidable.IncomingForm();
		form.parse(req, function (err, fields, files) {
			meme.title = fields.title;
			meme.description = fields.description;
			if (fields.privacy === 'on') {
				meme.privacy = true;
			} else {
				meme.privacy = false;
			}
			
			let isGenreChanged = meme.genre.toString() !== fields.genre.toString();
			if (isGenreChanged) {
				Genre.findById(meme.genre).then(function(g) {
					g.memes = g.memes.filter(x => x.toString() != meme._id.toString());
					g.save();
				});
				meme.genre = fields.genre;
			}

			Genre.findById(fields.genre).then(function(genre) {
				if (files.memeSrc.name !== '') {
		    		if (!meme.memeSrc.endsWith('/default.jpeg')) {
		    			fs.unlink(pathPrefix + staticDir + meme.memeSrc);
					}
					let filename = shortid.generate() + '.' + files.memeSrc.type.split('/').pop();
					let tempPath = files.memeSrc.path;
			      	let newPath = pathPrefix + staticDir + imageDir + filename;
			        fs.rename(tempPath, newPath, function (err) {
			        	if (err) {
			        		res.render('error/error');
			        		console.log(err);
			        	}
			        });
			        meme.memeSrc = imageDir + filename;
				} 
				if (isGenreChanged) {
					genre.memes.push(meme._id);
					genre.save();
				}
				meme.save();
				res.redirect('/memes/details/' + meme._id);
			}).catch(defaultError);
		});
	}).catch(defaultError);
}

function getDeleteMeme(req, res) {
	Meme.findById(req.params.id).then(function(meme) {
		if (!meme) {
    		res.render('error/error');
    		return;
    	}
		res.render('memes/deleteMeme', {meme, pageTitle: 'Delete Meme'});
	}).catch(defaultError);
}

function postDeleteMeme(req, res) {
	Meme.findByIdAndRemove({'_id': req.params.id}).then(function(meme) {
		Genre.findById(meme.genre.toString()).then(function(genre) {
			genre.memes = genre.memes.filter(x => x.toString() != meme._id.toString());
			genre.save();
		});
		res.redirect('/memes/viewAll');
	});
}

module.exports = {
		getViewAllMemes,
		getAddMeme,
		postAddMeme,
		getMemeDetails,
		getMemeSearch,
		getViewByGenre,
		getEditMeme,
		postEditMeme,
		getDeleteMeme,
		postDeleteMeme
};
