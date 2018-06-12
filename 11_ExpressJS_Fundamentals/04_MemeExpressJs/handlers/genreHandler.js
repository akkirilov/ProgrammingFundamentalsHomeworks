const Genre = require('../models/Genre');
const defaultError = require('./errorHandler').getDefaultError;
const formidable = require('formidable');

function getAddGenre(req, res) {
	res.render('genres/addGenre', { pageTitle: 'Add genre'});
}

function postAddGenre(req, res) {
	let name = req.body.name;
	let genre = { name: req.body.name };
	Genre.find({name:genre.name}).then(function(g) {
		console.log(g);
		if(g.length > 0) {
			res.render('genres/addGenre', { pageTitle: 'Add genre', error: 'Genre with this name already exist!'});
			return;
		}
		Genre.create(genre).then(function(g) {
			res.redirect('/genres/viewAll');
		}).catch(defaultError);
	}).catch(defaultError);
}

function getViewAllGenres(req, res) {
	Genre.find().then(function(genres) {

		res.render('genres/viewAll', {genres, pageTitle: 'Genres'});
	}).catch(defaultError);
}

function getEditGenre(req, res) {
	Genre.findById(req.params.id).then(function(genre) {
		res.render('genres/editGenre', {genre, pageTitle: 'Edit genre'});
	}).catch(defaultError);
}

function postEditGenre(req, res) {
	Genre.findById(req.params.id).then(function(genre) {
		genre.name = req.body.name;		
		genre.save();
		res.redirect('/genres/viewAll');
	}).catch(defaultError);
}

module.exports = {
		getAddGenre,
		postAddGenre,
		getViewAllGenres,
		getEditGenre,
		postEditGenre
};