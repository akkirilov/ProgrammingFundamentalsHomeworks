const router = require('express').Router();
const Article = require('../models/Article');
const Version = require('../models/Version');

function getCreate(req, res) {
	if (!req.user) {
		req.session.message = 'Login!';
		return res.redirect('/users/login');
	}
	const message = req.session.message;
	req.session.message = '';
	let isAdmin = req.session.user.isAdmin;
	let username = req.session.user.email;
	let isLoggedIn = true;
	Article.find().then(function(articles) {
		articles = articles.sort(function(a, b) {
		    a = new Date(a.creationDate);
		    b = new Date(b.creationDate);
		    return a>b ? -1 : a<b ? 1 : 0;
		});
		latestArticle = articles.shift();
		res.render('articles/create', {
			latestArticle,
			username,
			message,
			isLoggedIn,
			isAdmin
		});
	});
}

function postCreate(req, res) {
	if (!req.user) {
		req.session.message = 'Login!';
		return res.redirect('/users/login');
	}
	const message = req.session.message;
	req.session.message = '';
	let isAdmin = req.session.user.isAdmin;
	let username = req.session.user.email;
	let isLoggedIn = true;
	const {
		title,
		content
	} = req.body;
	let article = {
			title,
	};
	Article.create(article).then(function(newArticle) {
		let version = {
				article: newArticle._id,
				author: req.user,
				content: content.replace('<', '&lt;').replace('>', '&gt;').replace(/(?:\r\n|\r|\n)/g, '<br><br>')
		};
		Version.create(version).then(function(newVersion) {
			newArticle.versions.push(newVersion._id);
			newArticle.save();
			req.session.message = "Article createted!";
			return res.redirect('/');
		}).catch(function(err) {
			console.log(err);
			return error(err.message);
		});
	}).catch(function(err) {
		console.log(err);
		return error(err.message);
	});
	
	function error(message) {
		req.session.formData = {
				title,
				content
		};
		req.session.message = message;
		return res.redirect('/articles/create');
	}
}

function getEdit(req, res) {
	let articleId = req.params.id;
	if (!req.user) {
		req.session.message = 'Login!';
		return res.redirect('/users/login');
	}
	let username = req.session.user.email;
	let isAdmin = req.session.user.isAdmin;
	let isLoggedIn = true;
	const message = req.session.message;
	req.session.message = '';
	Article.findById(articleId).populate('versions').then(function(article) {
		if (article.isLocked && !isAdmin) {
			req.session.message = "Article is locked!";
			return res.redirect('/articles/' + articleId);
		}
		let lastEdit = article.versions.sort(function(a, b) {
		    a = new Date(a.editDate);
		    b = new Date(b.editDate);
		    return a>b ? -1 : a<b ? 1 : 0;
		}).shift();
		article.content = lastEdit.content.replace(/<br><br>/g, "\r\n").replace(/\s{2,}/g, ' ');
		Article.find().populate('versions')
		.then(function(articles) {
			let latestArticle;
			articles = articles.sort(function(a, b) {
			    a = new Date(a.creationDate);
			    b = new Date(b.creationDate);
			    return a>b ? -1 : a<b ? 1 : 0;
			});
			latestArticle = articles.shift();
			return res.render('articles/edit', { username, latestArticle, isAdmin, isLoggedIn, message, article });
		}).catch(function(err) {
			console.log(err);
			req.session.message = err.message;
			return res.redirect('/error');
		});
	}).catch(function(err) {
		console.log(err);
		req.session.message = err.message;
		return res.redirect('/error');
	});
}

function getHistory(req, res) {
	let username = "anonymous";
	let articleId = req.params.id;
	let isAdmin = false;
	let isLoggedIn = false;
	if (req.user) {
		isLoggedIn = true;
		username = req.session.user.email
		isAdmin = req.session.user.isAdmin;
	}
	const message = req.session.message;
	req.session.message = '';
	Article.findById(articleId).then(function(article) {
		Article.find().populate('versions')
		.then(function(articles) {
			let latestArticle;
			articles = articles.sort(function(a, b) {
			    a = new Date(a.creationDate);
			    b = new Date(b.creationDate);
			    return a>b ? -1 : a<b ? 1 : 0;
			});
			latestArticle = articles.shift();
			Version.find({article:article._id}).populate('author').then(function(versions) {
				article.versions = versions.sort(function(a, b) {
				    a = new Date(a.editDate);
				    b = new Date(b.editDate);
				    return a>b ? -1 : a<b ? 1 : 0;
				});
				return res.render('articles/history', { username, latestArticle, isAdmin, isLoggedIn, message, article });
			})
		}).catch(function(err) {
			console.log(err);
			req.session.message = err.message;
			return res.redirect('/error');
		});
	}).catch(function(err) {
		console.log(err);
		req.session.message = err.message;
		return res.redirect('/error');
	});
}

function postEdit(req, res) {
	let articleId = req.params.id;
	if (!req.user) {
		req.session.message = 'Login!';
		return res.redirect('/users/login');
	}
	let username = req.session.user.email;
	let isAdmin = req.session.user.isAdmin;
	let isLoggedIn = true;
	const message = req.session.message;
	req.session.message = '';
	Article.findById(articleId).populate('versions').then(function(article) {
		if (article.isLocked && !isAdmin) {
			req.session.message = "Article is locked!";
			return res.redirect('/articles/' + articleId);
		}
		let version = {
				article: article._id,
				author: req.user,
				content: req.body.content.replace('<', '&lt;').replace('>', '&gt;').replace(/(?:\r\n|\r|\n)/g, '<br><br>'),
				editDate: Date.now()
			}
		Version.create(version).then(function(newVersion) {
			article.versions.push(newVersion);
			article.save();
			return res.redirect('/articles/' + articleId);
		}).catch(function(err) {
			console.log(err);
			req.session.message = err.message;
			return res.redirect('/error');
		});
	}).catch(function(err) {
		console.log(err);
		req.session.message = err.message;
		return res.redirect('/error');
	});
	
}

function getAll(req, res) {
	let isLoggedIn = false;
	let isAdmin = false;
	let username = 'anonimous';
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
		articles = articles.sort(function(a, b) {
		    a = new Date(a.creationDate);
		    b = new Date(b.creationDate);
		    return a>b ? -1 : a<b ? 1 : 0;
		});
		latestArticle = articles[0];
		articles = articles.sort(function(a, b){
				if(a.title < b.title) return -1;
				if(a.title > b.title) return 1;
		    	return 0;
			});
		return res.render('articles/all', { username, articles, latestArticle, message, isLoggedIn, isAdmin });
	}).catch(function(err) {
		console.log(err);
		req.session.message = err.message;
		return res.redirect('/error');
	});
}

function getLock(req, res) {
	let articleId = req.params.id;
	let isAdmin = false;
	if (req.user) {
		isAdmin = req.session.user.isAdmin;
	} else {
		req.session.message = 'Login!';
		return res.redirect('/users/login');
	}
	if (!isAdmin) {
		req.session.message = "You don't have permission!";
		return res.redirect('/articles/' + articleId);
	} else {
		Article.findById(articleId).then(function(article) {
			if (article.isLocked) {
				req.session.message = "Article is already locked!";
				return res.redirect('/articles/' + articleId);
			} else {
				article.isLocked = true;
				article.save();
				req.session.message = "Article is locked!";
				return res.redirect('/articles/' + articleId);
			}
		}).catch(function(err) {
			console.log(err);
			req.session.message = err.message;
			return res.redirect('/error');
		});
	}
}

function getUnlock(req, res) {
	let articleId = req.params.id;
	let isAdmin = false;
	if (req.user) {
		isAdmin = req.session.user.isAdmin;
	} else {
		req.session.message = 'Login!';
		return res.redirect('/users/login');
	}
	if (!isAdmin) {
		req.session.message = "You don't have permission!";
		return res.redirect('/articles/' + articleId);
	} else {
		Article.findById(articleId).then(function(article) {
			if (!article.isLocked) {
				req.session.message = "Article is already unlocked!";
				return res.redirect('/articles/' + articleId);
			} else {
				article.isLocked = false;
				article.save();
				req.session.message = "Article is unlocked!";
				return res.redirect('/articles/' + articleId);
			}
		}).catch(function(err) {
			console.log(err);
			req.session.message = err.message;
			return res.redirect('/error');
		});
	}
}

function getArticle(req, res) {
	let articleId = req.params.id;
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
		articles = articles.sort(function(a, b) {
		    a = new Date(a.creationDate);
		    b = new Date(b.creationDate);
		    return a>b ? -1 : a<b ? 1 : 0;
		});
		latestArticle = articles.shift();
		Article.findById(articleId).populate('versions').then(function(article) {
			let lastEdit = article.versions.sort(function(a, b) {
			    a = new Date(a.editDate);
			    b = new Date(b.editDate);
			    return a>b ? -1 : a<b ? 1 : 0;
			}).shift();
			article.content = lastEdit.content;
			return res.render('articles/article', { username, article, latestArticle, message, isLoggedIn, isAdmin });
		}).catch(function(err) {
			console.log(err);
			req.session.message = err.message;
			return res.redirect('/error');
		});
	}).catch(function(err) {
		console.log(err);
		req.session.message = err.message;
		return res.redirect('/error');
	});
}

function getArticleVersion(req, res) {
	let versionId = req.params.id;
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
	Version.findById(versionId).populate('article').then(function(version) {
		Article.find().populate('versions')
		.then(function(articles) {
			let latestArticle;
			articles = articles.sort(function(a, b) {
			    a = new Date(a.creationDate);
			    b = new Date(b.creationDate);
			    return a>b ? -1 : a<b ? 1 : 0;
			});
			latestArticle = articles.shift();
			let article = version.article;
			article.content = version.content;
			return res.render('articles/article', { username, article, latestArticle, message, isLoggedIn, isAdmin });
		}).catch(function(err) {
			console.log(err);
			req.session.message = err.message;
			return res.redirect('/error');
		});
	})
}

function getSearch(req, res) {
	let query = req.query.query;
	let isLoggedIn = false;
	let isAdmin = false;
	let username = 'anonimous';
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
		articles = articles.sort(function(a, b) {
		    a = new Date(a.creationDate);
		    b = new Date(b.creationDate);
		    return a>b ? -1 : a<b ? 1 : 0;
		});
		latestArticle = articles[0];
		articles = articles.filter(x => x.title.toString().toLowerCase().includes(query.toLowerCase())).sort(function(a, b){
				if(a.title < b.title) return -1;
				if(a.title > b.title) return 1;
		    	return 0;
			});
		return res.render('articles/search', { query, username, articles, latestArticle, message, isLoggedIn, isAdmin });
	}).catch(function(err) {
		console.log(err);
		req.session.message = err.message;
		return res.redirect('/error');
	});
}

router.get('/create', getCreate);
router.post('/create', postCreate);
router.get('/edit/:id', getEdit);
router.get('/history/:id', getHistory);
router.post('/edit/:id', postEdit);
router.get('/lock/:id', getLock);
router.get('/unlock/:id', getUnlock);
router.get('/all', getAll);
router.get('/search', getSearch);
router.get('/:id', getArticle);
router.get('/version/:id', getArticleVersion);

module.exports = router;