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

module.exports = {
		getViewAllMemes,
		getAddMeme,
		postAddMeme,
		getMemeDetails,
		getMemeSearch
};
