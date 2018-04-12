let userController = (function() {
	
	function isLoggedIn() {
		return sessionStorage.getItem('username') !== null;
	}
	
	function getUsername() {
		return sessionStorage.getItem('username');
	}
	
	function getUserId() {
		return sessionStorage.getItem('userId');
	}
	
	function getTeamId() {
		return sessionStorage.getItem('teamId');
	}
	
	function hasUserTeam() {
		return sessionStorage.getItem('teamId') !== null;
	}
	
	function hasNoTeam() {
		return sessionStorage.getItem('teamId') == 'undefined';
	}
	
	function registerInTeam(teamId) {
		let username = getUsername();
		let _id = getUserId();
		let endPoint = _id;
		let data = { username, _id, teamId};
		return requester.update('user', endPoint, 'Kinvey', data);
	}
	
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
		auth.login(username, password)
		.then(function(res) {
			auth.saveSession(res);
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
		auth.register(username, password)
		.then(function(res) {
			auth.login(username, password).then(function() {
				auth.saveSession(res);
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
		auth.logout()
		.then(function(res) {
			sessionStorage.clear();
			infoService.showInfo('Logout success!');
			ctx.redirect('#/home');
		}).catch(function(err) {
			infoService.handleAjaxError(err);
		});
	}
	
	return {
		isLoggedIn,
		hasUserTeam,
		hasNoTeam,
		registerInTeam,
		getUsername,
		getUserId,
		getTeamId,
		getLogin,
		postLogin,
		getRegister,
		postRegister,
		getLogout
	}
})();
