const Article = require('../models/Article');

function getHome(req, res) {
	let isLoggedIn = false;
	let isAdmin = false;
	let username = 'anonymous';
	if (req.user) {
		isLoggedIn = true;
		isAdmin = req.session.user.isAdmin;
		username = req.session.user.email;
	}
	const message = req.session.message;
	req.session.message = '';
	Article.find().populate('versions')
	.then(function(articles) {
		let latestArticle;
		if (req.query.query) {
			articles = articles.filter(x => x.title.toLowerCase().includes(req.query.query.toLowerCase()));
		} else {
			articles = articles.sort(function(a, b) {
			    a = new Date(a.creationDate);
			    b = new Date(b.creationDate);
			    return a>b ? -1 : a<b ? 1 : 0;
			});
			latestArticle = articles.shift();
			let words = latestArticle.versions.pop().content.replace('<br><br>', '').split(/\s+/);
			if (words.length > 50) {
				words = words.slice(0, 50);
				latestArticle.shortContent = words.join(' ') + '...';
			} else {
				latestArticle.shortContent = words.join(' ');
			}
		}
		articles = articles.slice(0, 3);
		return res.render('home/home', { username, articles, latestArticle, message, isLoggedIn, isAdmin });
	}).catch(function(err) {
		console.log(err);
		req.session.message = err.message;
		return res.redirect('/error');
	});
}

module.exports = getHome;
