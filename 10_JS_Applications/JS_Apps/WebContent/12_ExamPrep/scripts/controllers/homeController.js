let homeController = (function() {
	
	function getHome(ctx) {
		let isLoggedIn = userController.isLoggedIn();
		ctx.isLoggedIn = isLoggedIn;
		if (isLoggedIn) {
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
		} else {
			ctx.loadPartials({
				header: 'templates/common/header.hbs',
				footer: 'templates/common/footer.hbs',
				nav: 'templates/nav/nav.hbs',
				about:'templates/about/about.hbs',
				loginForm: 'templates/login/loginForm.hbs',
				registerForm: 'templates/register/registerForm.hbs'
			}).then(function() {
				this.partial('templates/welcome/welcomePage.hbs');
			});
		}
		
	}
	
	return {
		getHome
	}
})();