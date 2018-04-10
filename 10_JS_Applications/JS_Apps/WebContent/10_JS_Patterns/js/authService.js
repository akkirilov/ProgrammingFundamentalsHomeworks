let authService = (function () {
	
	function isAuth() {
		return sessionStorage.getItem('username') !== null;
	}
	
	function saveSession(userData) {
		sessionStorage.setItem('username', userData.username);
		sessionStorage.setItem('userId', userData._id);
		sessionStorage.setItem('authtoken', userData._kmd.authtoken);
	}
	
	function login(username, password) {
		let data = { username, password };
		return remote.post('user', 'login', 'basic', data);
	}
	
	function register(username, password) {
		let data = { username, password };
		return remote.post('user', '', 'basic', data);
	}
	
	function logout(data) {
		return remote.post('user', '_logout', 'kinvey');
	}
	
	return {
		isAuth,
		login,
		logout,
		register,
		saveSession
	}
})();
