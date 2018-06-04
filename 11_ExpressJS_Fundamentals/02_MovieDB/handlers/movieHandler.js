const movieService = require('../services/movieService');

function getAddMovie(req, res, data) {
	if (!data) {
		res.view('./views/addMovie.html');
	} else {
		console.log(data);
		let newData = [];
		if (data.error) {
			newData['id="replaceMe"'] = 'id="errBox"';
			newData['{{replaceMe}}'] = `<h2 id="errMsg">${data.error}</h2>`;
			newData['The title of the movie"'] = `The title of the movie" value="${data.movie.movieTitle}"`;
			newData['Year of release"'] = `Year of release" value="${data.movie.movieYear}"`;
			newData['Link to a poster"'] = `Link to a poster" value="${data.movie.moviePoster}"`;
			newData['</textarea>'] = `${data.movie.movieDescription}</textarea>`;
			res.view('./views/addMovie.html', 'text/html', newData);
		} else {
			newData['id="replaceMe"'] = 'id="succssesBox"';
			newData['{{replaceMe}}'] = `<h2 id="succssesMsg">Movie added</h2>`;
			res.view('./views/addMovie.html', 'text/html', newData);
		}
	}
}

function getMoviesAsHTML() {
	let newData = '';
	let movies = movieService.getAll();
	let counter = 0;
	for (let m of movies) {
		newData += `<div class="movie">
				<a href="/movies/${counter}"><img class="moviePoster" src="${m.moviePoster}" /></a>
				</div>`;
		counter++;
	}
	return newData;
}

module.exports = function (req, res) {
	const url = req.url;
	if (req.method === "GET") {
		if (url === '/viewAllMovies') {
			let newData = getMoviesAsHTML();
			let data = [];
			data['{{replaceMe}}'] = newData;
			res.view('./views/viewAll.html', 'text/html', data);
		} else if (url === '/addMovie') {
			getAddMovie(req, res);
		} else if (/^\/movies\/\d+$/g.test(url)) {
			let movie = movieService.findById(Number(url.split('/').pop()));
			let data = [];
			if (!movie) {
				data['<div class="container">'] = '<div id="errBox"><h2 id="errMsg">There are no such movie!</h2></div><div class="container">'				
				let newData = getMoviesAsHTML();
				data['{{replaceMe}}'] = newData;
				res.view('./views/viewAll.html', 'text/html', data);
			} else {
				data['{{replaceMe}}'] = `<div class="content">
					<img src="${movie.moviePoster}" alt="${movie.movieTitle}"/>
					<h3>Title ${movie.movieTitle}</h3>
					<h3>Year ${movie.movieYear}</h3>
					<p>${movie.movieDescription}</p>
					</div>​`;
				res.view('./views/details.html', 'text/html', data);
			}
		} else {
			return true;
		}
	} else if (req.method === "POST") {
		if (url === '/addMovie') {
			movieService.addMovie(req, res, getAddMovie);
		} else {
			return true;
		}
	} else {
		return true;
	}
}
