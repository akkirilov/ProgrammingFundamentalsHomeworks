let userController = (function() {
	
	function login(ctx) {
		if (userService.isLoggedIn()) {
			ctx.redirect('#/activeReceipt');
			return;
		}
		
		let username = ctx.params["username-login"];
		let password = ctx.params["password-login"];
		if (username.length < 5) {
			infoService.showError('A username should be at least 5 characters long.');
			return;
		}
		if (password.length === 0) {
			infoService.showError('Password should not be empty.');
			return;
		}
		userService.login(username, password)
		.then(function(res) {
			userService.saveSession(res);
			ctx.redirect('#/activeReceipt');
			infoService.showInfo('Login successful.');
		}).catch(function(err) {
			infoService.handleAjaxError(err);
		});
	}
	
	function register(ctx) {
		if (userService.isLoggedIn()) {
			ctx.redirect('#/home');
			return;
		}
		let username = ctx.params["username-register"];
		let password = ctx.params["password-register"];
		let repeatPassword = ctx.params["password-register-check"];
		if (username.length < 5) {
			infoService.showError('A username should be at least 5 characters long.');
			return;
		}
		if (password.length === 0) {
			infoService.showError('Password should not be empty.');
			return;
		}
		if (password !== repeatPassword) {
			infoService.showError('Repeated password is different.');
			return;
		}
		
		userService.register(username, password)
		.then(function(res) {
			userService.login(username, password).then(function() {
				userService.saveSession(res);
				ctx.redirect('#/activeReceipt');
				infoService.showInfo('User registration successful.');
			}).catch(function(err) {
				infoService.handleAjaxError(err);
			});
		}).catch(function(err) {
			infoService.handleAjaxError(err);
		});
	}
	
	function logout(ctx) {
		if (!userService.isLoggedIn()) {
			ctx.redirect('#/home');
			return;
		}
		userService.logout()
		.then(function(res) {
			sessionStorage.clear();
			infoService.showInfo('Logout success!');
			ctx.redirect('#/home');
		}).catch(function(err) {
			infoService.handleAjaxError(err);
		});
	}
	
	return {
		login,
		register,
		logout
	}
})();
