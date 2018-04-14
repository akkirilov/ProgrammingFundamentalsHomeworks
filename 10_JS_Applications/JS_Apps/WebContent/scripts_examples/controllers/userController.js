let userController = (function() {

	function getLogin(ctx) {
		if (isLoggedIn()) {
			ctx.redirect('#/home');
			return;
		}
		ctx.loggedIn = userController.isLoggedIn();
		ctx.hasTeam = userController.hasUserTeam();
		ctx.loadPartials({
			header: 'templates/common/header.hbs',
			loginForm: 'templates/login/loginForm.hbs',
			footer: 'templates/common/footer.hbs',
		}).then(function() {
			this.partial('templates/login/loginPage.hbs');
		});
	}
	
	function postLogin(ctx) {
		if (isLoggedIn()) {
			ctx.redirect('#/home');
			return;
		}
		ctx.loggedIn = userController.isLoggedIn();
		ctx.hasTeam = userController.hasUserTeam();
		let username = ctx.params.username;
		let password = ctx.params.password;
		authService.login(username, password)
		.then(function(res) {
			authService.saveSession(res);
			ctx.redirect('#/home');
			infoService.showInfo('Login success!');
		}).catch(function(err) {
			infoService.handleAjaxError(err);
		});
	}
	
	function getRegister(ctx) {
		if (isLoggedIn()) {
			ctx.redirect('#/home');
			return;
		}
		ctx.loggedIn = userController.isLoggedIn();
		ctx.hasTeam = userController.hasUserTeam();
		ctx.loadPartials({
			header: 'templates/common/header.hbs',
			registerForm: 'templates/register/registerForm.hbs',
			footer: 'templates/common/footer.hbs',
		});
	}
	
	function postRegister(ctx) {
		if (isLoggedIn()) {
			ctx.redirect('#/home');
			return;
		}
		let username = ctx.params.username;
		let password = ctx.params.password;
		let repeatPassword = ctx.params.repeatPassword;

		if (password !== repeatPassword) {
			infoService.showError('Confirmed password is different!');
			return;
		}
		ctx.loggedIn = userController.isLoggedIn();
		ctx.hasTeam = userController.hasUserTeam();
		authService.register(username, password)
		.then(function(res) {
			authService.login(username, password).then(function() {
				authService.saveSession(res);
				ctx.redirect('#/home');
				infoService.showInfo('Register success!');
			}).catch(function(err) {
				infoService.handleAjaxError(err);
			});
		}).catch(function(err) {
			infoService.handleAjaxError(err);
		});
	}
	
	function getLogout(ctx) {
		if (!isLoggedIn()) {
			ctx.redirect('#/home');
			return;
		}
		ctx.loggedIn = userController.isLoggedIn();
		ctx.hasTeam = userController.hasUserTeam();
		authService.logout()
		.then(function(res) {
			sessionStorage.clear();
			infoService.showInfo('Logout success!');
			ctx.redirect('#/home');
		}).catch(function(err) {
			infoService.handleAjaxError(err);
		});
	}
	
	return {
		getLogin,
		postLogin,
		getRegister,
		postRegister,
		getLogout
	}
})();
