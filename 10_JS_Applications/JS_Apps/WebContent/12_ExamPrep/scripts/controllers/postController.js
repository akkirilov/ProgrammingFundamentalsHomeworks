let postController = (function() {
	
	const URL_PATTERN = /^(https|http):\/\/.+/; 
	
	function getPosts(ctx) {
		let isLoggedIn = userController.isLoggedIn();
		ctx.isLoggedIn = isLoggedIn;
		if (!isLoggedIn) {
			ctx.redirect('#/home');
		}
		ctx.username = userController.getUsername();
		requestService.get('appdata', 'posts/?query={}&sort={"_kmd.ect": -1}', 'Kinvey')
		.then(function(posts) {
			let i = 1;
			for (let x of posts) {
				x['isAuthor'] = x._acl.creator === userController.getUserId();
				x['submitedInfo'] = dateUtil.calcTime(x._kmd.ect);
				x['ind'] = i++;
			}
			ctx.posts = posts;
			ctx.hasPosts = (posts.length > 0);
			ctx.loadPartials({
				header: 'templates/common/header.hbs',
				footer: 'templates/common/footer.hbs',
				nav: 'templates/nav/nav.hbs',
				allPosts: 'templates/posts/allPosts.hbs',
				postList: 'templates/posts/postList.hbs',
				submitedInfo: 'templates/posts/submitedInfo.hbs',
				postControlls: 'templates/posts/postControlls.hbs',
				postAuthorsControlls: 'templates/posts/postAuthorsControlls.hbs'
			}).then(function() {
				this.partial('templates/welcome/welcomePage.hbs');
			});
		}).catch(function(err) {
			infoService.handleAjaxError(err);
		});
	}
	
	function getMyPosts(ctx) {
		let isLoggedIn = userController.isLoggedIn();
		ctx.isLoggedIn = isLoggedIn;
		if (!isLoggedIn) {
			ctx.redirect('#/home');
		}
		ctx.username = userController.getUsername();
		requestService.get('appdata', 'posts/?query={"_acl.creator": "'+userController.getUserId()+'"}&sort={"_kmd.ect": -1}', 'Kinvey')
		.then(function(posts) {
			let i = 1;
			for (let x of posts) {
				x['isAuthor'] = x._acl.creator === userController.getUserId();
				x['submitedInfo'] = dateUtil.calcTime(x._kmd.ect);
				x['ind'] = i++;
			}
			ctx.posts = posts;
			ctx.hasPosts = (posts.length > 0);
			ctx.loadPartials({
				header: 'templates/common/header.hbs',
				footer: 'templates/common/footer.hbs',
				nav: 'templates/nav/nav.hbs',
				allPosts: 'templates/posts/allPosts.hbs',
				postList: 'templates/posts/postList.hbs',
				submitedInfo: 'templates/posts/submitedInfo.hbs',
				postControlls: 'templates/posts/postControlls.hbs',
				postAuthorsControlls: 'templates/posts/postAuthorsControlls.hbs'
			}).then(function() {
				this.partial('templates/posts/myPosts.hbs');
			});
		}).catch(function(err) {
			infoService.handleAjaxError(err);
		});
	}
	
	function getCreatePost(ctx) {
		let isLoggedIn = userController.isLoggedIn();
		ctx.isLoggedIn = isLoggedIn;
		if (!isLoggedIn) {
			ctx.redirect('#/home');
		}
		ctx.username = userController.getUsername();
		ctx.loadPartials({
			header: 'templates/common/header.hbs',
			footer: 'templates/common/footer.hbs',
			nav: 'templates/nav/nav.hbs'
		}).then(function() {
			this.partial('templates/posts/submitPage.hbs');
		});
	}
	
	function postCreatePost(ctx) {
		let isLoggedIn = userController.isLoggedIn();
		ctx.isLoggedIn = isLoggedIn;
		if (!isLoggedIn) {
			ctx.redirect('#/home');
		}
		let url = ctx.params.url;
		if (!(URL_PATTERN.test(url))) {
			infoService.showError('URL must start with http or https!');
			return;
		}
		let imageUrl = ctx.params.image;
		if (!(URL_PATTERN.test(imageUrl))) {
			infoService.showError('Image URL must start with http or https!');
			return;
		}
		let title = ctx.params.title;
		if (title.length < 1) {
			infoService.showError('Title can not be empty!');
			return;
		}
		let data = {
			"author": userController.getUsername(),
			"url": url,
			"imageUrl": imageUrl,
			"title": title,
			"description": ctx.params.comment
		}
		requestService.post('appdata', 'posts', 'Kinvey', data)
		.then(function(res) {
			ctx.redirect('#/posts');
			infoService.showInfo('Post created successfully!');
		}).catch(function(err) {
			infoService.handleAjaxError(err);
		});
	}
	
	function getEditPost(ctx) {
		let isLoggedIn = userController.isLoggedIn();
		ctx.isLoggedIn = isLoggedIn;
		if (!isLoggedIn) {
			ctx.redirect('#/home');
		}
		ctx.username = userController.getUsername();
		let id = ctx.params.id;
		requestService.get('appdata', 'posts/?query={"_id": "'+id+'"}')
		.then(function(post) {
			console.log(post);
			ctx._id = post[0]._id;
			ctx.url = post[0].url;
			ctx.title = post[0].title;
			ctx.imageUrl = post[0].imageUrl;
			ctx.description = post[0].description;
			ctx.loadPartials({
				header: 'templates/common/header.hbs',
				footer: 'templates/common/footer.hbs',
				nav: 'templates/nav/nav.hbs'
			}).then(function() {
				this.partial('templates/posts/editPost.hbs');
			});
		}).catch(function(err) {
			infoService.handleAjaxError(err);
		});
	}
	
	function postEditPost(ctx) {
		let isLoggedIn = userController.isLoggedIn();
		ctx.isLoggedIn = isLoggedIn;
		if (!isLoggedIn) {
			ctx.redirect('#/home');
		}
		let url = ctx.params.url;
		if (!(URL_PATTERN.test(url))) {
			infoService.showError('URL must start with http or https!');
			return;
		}
		let id = ctx.params.id;
		let imageUrl = ctx.params.image;
		if (!(URL_PATTERN.test(imageUrl))) {
			infoService.showError('Image URL must start with http or https!');
			return;
		}
		let title = ctx.params.title;
		if (title.length < 1) {
			infoService.showError('Title can not be empty!');
			return;
		}
		let data = {
			"author": userController.getUsername(),
			"url": url,
			"imageUrl": imageUrl,
			"title": title,
			"description": ctx.params.description
		}
		requestService.update('appdata', 'posts/' + id, 'Kinvey', data)
		.then(function(res) {
			ctx.redirect('#/posts');
			infoService.showInfo('Post edited successfully!');
		}).catch(function(err) {
			infoService.handleAjaxError(err);
		});
	}
	
	function getDeletePost(ctx) {
		let isLoggedIn = userController.isLoggedIn();
		ctx.isLoggedIn = isLoggedIn;
		if (!isLoggedIn) {
			ctx.redirect('#/home');
		}
		let id = ctx.params.id;
		requestService.remove('appdata', 'posts/' + id, 'Kinvey')
		.then(function(res) {
			ctx.redirect('#/posts');
			infoService.showInfo('Post deleted!');
		}).catch(function(err) {
			infoService.handleAjaxError(err);
		});
	}
	
	function getPostDetails(ctx) {
		let isLoggedIn = userController.isLoggedIn();
		ctx.isLoggedIn = isLoggedIn;
		if (!isLoggedIn) {
			ctx.redirect('#/home');
		}
		ctx.username = userController.getUsername();
		let id = ctx.params.id;
		requestService.get('appdata', 'posts/?query={"_id": "'+id+'"}')
		.then(function(post) {
			console.log(post);
			ctx._id = post[0]._id;
			ctx.url = post[0].url;
			ctx.isAuthor = (post[0].author === userController.getUsername());
			ctx.submitedInfo = dateUtil.calcTime(post[0]._kmd.ect);
			ctx.author = post[0].author;
			ctx.title = post[0].title;
			ctx.imageUrl = post[0].imageUrl;
			ctx.description = post[0].description;
			ctx.hasDescription = (post[0].description.length > 0);
			requestService.get('appdata', 'comments/?query={"postId": "'+id+'"}')
			.then(function(comments) {
				for (let c of comments) {
					c['isCommentAuthor'] = c._acl.creator === userController.getUserId();
					c['submitInfo'] = dateUtil.calcTime(c._kmd.ect);
				}
				ctx.hasComments = (comments.length > 0);
				ctx.comments = comments;
				ctx.loadPartials({
					header: 'templates/common/header.hbs',
					footer: 'templates/common/footer.hbs',
					nav: 'templates/nav/nav.hbs',
					submitedInfo: 'templates/posts/submitedInfo.hbs',
					postAuthorsControlls: 'templates/posts/postAuthorsControlls.hbs'
				}).then(function() {
					this.partial('templates/posts/postDetails.hbs');
				});
			}).catch(function(err) {
				infoService.handleAjaxError(err);
			});
			
		}).catch(function(err) {
			infoService.handleAjaxError(err);
		});
	}
	
	return {
		getPosts,
		getMyPosts,
		getCreatePost,
		postCreatePost,
		getEditPost,
		postEditPost,
		getDeletePost,
		getPostDetails
	}
})();
