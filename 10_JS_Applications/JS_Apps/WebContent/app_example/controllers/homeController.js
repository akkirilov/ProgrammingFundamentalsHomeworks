let homeController = (function() {
	
	function getHome(ctx) {
		ctx.loggedIn = userService.isLoggedIn();
		ctx.username = userService.getUsername();
		
		ctx.loadPartials({
			header: 'templates/common/header.hbs',
			footer: 'templates/common/footer.hbs'
				
		}).then(function() {
			this.partial('templates/home/home.hbs');
		});
	}
	
	function getAbout(ctx) {
		ctx.loggedIn = userService.isLoggedIn();
		ctx.username = userService.getUsername();
		
		ctx.loadPartials({
			header: 'templates/common/header.hbs',
			footer: 'templates/common/footer.hbs'
				
		}).then(function() {
			this.partial('templates/about/about.hbs');
		});
	}
	
	return {
		getHome,
		getAbout
	}
	
})();