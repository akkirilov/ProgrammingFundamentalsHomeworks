const fs = require('fs');
const qs = require('querystring');
const moviePath = './db/dataBase.json';
let movies;

function getAll() {
	if (!fs.existsSync(moviePath)) {
		fs.writeFileSync(moviePath, '[]');
		return [];
	}
	movies = JSON.parse(fs.readFileSync(moviePath).toString());
	return movies;
}

function addMovie(req, res, callback) {
	let reqBody = '';
	req.on('data', function(data) {
		reqBody += data;
	});
	req.on('end', function() {
		let movie = qs.parse(reqBody);
		if (movie.movieTitle.length < 1) {
			callback(req, res, {movie, error: 'Movie title is required!'});
			return;
		} else if (movie.movieYear.length < 1) {
			callback(req, res, {movie, error: 'Movie year is required!'});
			return;
		} else if (isNaN(Number(movie.movieYear))) {
			callback(req, res, {movie, error: 'Movie year require number!'});
			return;
		} else if (movie.movieYear < 1880) {
			callback(req, res, {movie, error: 'There are no movies before 1880!'});
			return;
		} else if (movie.movieYear > new Date().getFullYear()) {
			callback(req, res, {movie, error: 'There may be no movies in the future!'});
			return;
		} else if (movie.moviePoster.length < 1) {
			callback(req, res, {movie, error: 'Movie poster is required!'});
			return;
		} else if (movie.movieDescription.length < 1) {
			callback(req, res, {movie, error: 'Movie description is required!'});
			return;
		} else {
			if (!movies) {
				movies = getAll();
			}
			movies.push(movie);
			fs.writeFileSync(moviePath, JSON.stringify(movies));
			callback(req, res, {movie});
		}
	});
}

function findById(id) {
	if (!movies) {
		movies = getAll();
	}
	return movies[id];
}

module.exports = {
		getAll,
		addMovie,
		findById
}
