let userController = (function() {
	
	const USERNAME_PATTERN = /^[a-zA-Z]{3,}$/;
	const PASSWORD_PATTERN = /^[a-zA-Z0-9]{6,}$/;
	
	function isLoggedIn() {
		return sessionStorage.getItem('username') !== null;
	}
	
	function getUsername() {
		return sessionStorage.getItem('username');
	}
	
	function getUserId() {
		return sessionStorage.getItem('userId');
	}
	
	function getAuthToken() {
		return sessionStorage.getItem('authtoken');
	}
	
	function postLogin(ctx) {
		if (isLoggedIn()) {
			ctx.redirect('#/posts');
			return;
		}
		let username = ctx.params.username;
		console.log(!(usernamePattern.test(username)));
		if (!(USERNAME_PATTERN.test(username))) {
			infoService.showError('A username should be at least 3 characters long and should contain only english alphabet letters!');
			return;
		}
		let password = ctx.params.password;
		if (!(PASSWORD_PATTERN.test(password))) {
			infoService.showError('Password should be at least 6 characters long and should contain only english alphabet letters and digits!');
			return;
		}
		authService.login(username, password)
		.then(function(res) {
			authService.saveSession(res);
			ctx.redirect('#/posts');
			infoService.showInfo('Login success!');
		}).catch(function(err) {
			infoService.handleAjaxError(err);
		});
	}
	
	function postRegister(ctx) {
		if (isLoggedIn()) {
			ctx.redirect('#/posts');
			return;
		}
		let username = ctx.params.username;
		if (!(USERNAME_PATTERN.test(username))) {
			infoService.showError('A username should be at least 3 characters long and should contain only english alphabet letters!');
			return;
		}
		let password = ctx.params.password;
		if (!(PASSWORD_PATTERN.test(password))) {
			infoService.showError('Password should be at least 6 characters long and should contain only english alphabet letters and digits!');
			return;
		}
		let repeatPass = ctx.params.repeatPass;
		if (password !== repeatPass) {
			infoService.showError('Confirmed password is different!');
			return;
		}
		authService.register(username, password)
		.then(function(res) {
			authService.login(username, password).then(function() {
				authService.saveSession(res);
				ctx.redirect('#/posts');
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
		isLoggedIn,
		getAuthToken,
		getUsername,
		getUserId,
		postLogin,
		postRegister,
		getLogout
	}
})();
