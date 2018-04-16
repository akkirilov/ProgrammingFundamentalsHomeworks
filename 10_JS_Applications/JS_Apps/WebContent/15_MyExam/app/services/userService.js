let userService = (function() {
	
	const MODULE = 'user';
	const AUTH_BASIC = 'basic';
	const AUTH_KINVEY = 'kinvey';
	const LOGIN_ENDPOINT = 'login';
	const LOGOUT_ENDPOINT = '_logout';
	const REGISTER_ENDPOINT = '';
	
    function saveSession(userInfo) {
        sessionStorage.setItem('authtoken', userInfo._kmd.authtoken);
        sessionStorage.setItem('userId', userInfo._id);
        sessionStorage.setItem('username', userInfo.username);
    }
	
	function isLoggedIn() {
		return sessionStorage.getItem('authtoken') !== null;
	}
	
	function getUsername() {
		if (!isLoggedIn()) {
			return undefined;
		}
		return sessionStorage.getItem('username');
	}
	
	function getUserId() {
		if (!isLoggedIn()) {
			return undefined;
		}
		return sessionStorage.getItem('userId');
	}
	
	function getAuthToken() {
		if (!isLoggedIn()) {
			return undefined;
		}
		return sessionStorage.getItem('authtoken');
	}

    function login(username, password) {
        let data = {
            username,
            password
        };
        return requestService.post(MODULE, LOGIN_ENDPOINT, AUTH_BASIC, data);
    }

    function register(username, password) {
        let data = {
            username,
            password
        };
        return requestService.post(MODULE, REGISTER_ENDPOINT, AUTH_BASIC, data);
    }

    function logout() {
        let data = {
            authtoken: getAuthToken()
        };
        return requestService.post(MODULE, LOGOUT_ENDPOINT, AUTH_KINVEY, data);
    }

    return {
		isLoggedIn,
		getAuthToken,
		getUsername,
		getUserId,
        login,
        register,
        logout,
        saveSession
    }
    
})();