const Genre = require('../models/Genre');
const defaultError = require('./errorHandler').getDefaultError;

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
			res.redirect('/');
		}).catch(defaultError);
	}).catch(defaultError);
}

module.exports = {
		getAddGenre,
		postAddGenre
};