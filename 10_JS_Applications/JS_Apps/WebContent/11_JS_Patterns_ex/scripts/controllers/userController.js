let userController = (function() {
	
	function isLoggedIn() {
		return sessionStorage.getItem('ussername') !== null;
	}
	
	function getUsername() {
		return sessionStorage.getItem('username');
	}
	
	function getLogin(ctx) {

	}
	
	function postLogin() {

	}
	
	function getRegister(ctx) {

	}
	
	function postRegister() {

	}
	
	return {
		isLoggedIn,
		getLogin,
		postLogin,
		getRegister,
		postRegister
	}
})();
