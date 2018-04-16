let homeController = (function() {
	
	function getHome(ctx) {
		let isLoggedIn = userService.isLoggedIn();
		if (!isLoggedIn) {
			ctx.redirect('#/home');
		}
		ctx.isLoggedIn = isLoggedIn;
		ctx.username = userService.getUsername();
		if (isLoggedIn) {
			ctx.redirect('#/activeReceipt');
		} else {
			ctx.loadPartials({
				header: 'templates/common/header.hbs',
				footer: 'templates/common/footer.hbs',
				loginForm: 'templates/users/loginForm.hbs',
				registerForm: 'templates/users/registerForm.hbs',
				authPage: 'templates/users/authPage.hbs'
					
			}).then(function() {
				this.partial('templates/welcome/welcomePage.hbs');
			});
		}
	}
	
	return {
		getHome
	}
	
})();