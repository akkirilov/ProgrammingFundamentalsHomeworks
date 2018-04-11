let homeController = (function() {
	
	function getHome(ctx) {
		ctx.loggedIn = userController.isLoggedIn();
		ctx.hasTeam = userController.hasUserTeam();
		ctx.loadPartials({
			header: '../../templates/common/header.hbs',
			footer: '../../templates/common/footer.hbs',
		}).then(function() {
			this.partial('../../templates/home/home.hbs');
		})
	}
	
	function getAbout(ctx) {

	}
	
	return {
		getHome,
		getAbout
	}
})();