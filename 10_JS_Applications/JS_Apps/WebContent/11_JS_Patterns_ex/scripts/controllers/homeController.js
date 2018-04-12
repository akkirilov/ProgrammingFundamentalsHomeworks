let homeController = (function() {
	
	function getHome(ctx) {
		ctx.loggedIn = userController.isLoggedIn();
		ctx.hasTeam = !(userController.hasNoTeam());
		ctx.username = userController.getUsername();
		ctx.loadPartials({
			header: 'templates/common/header.hbs',
			footer: 'templates/common/footer.hbs',
		}).then(function() {
			this.partial('templates/home/home.hbs');
		});
	}
	
	function getAbout(ctx) {
		ctx.loggedIn = userController.isLoggedIn();
		ctx.hasTeam = userController.hasUserTeam();
		ctx.username = userController.getUsername();
		ctx.loadPartials({
			header: 'templates/common/header.hbs',
			footer: 'templates/common/footer.hbs',
		}).then(function() {
			this.partial('templates/about/about.hbs');
		});
	}
	
	return {
		getHome,
		getAbout
	}
})();