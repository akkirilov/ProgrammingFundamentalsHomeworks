let userService = (() => {
	
    function saveSession(userInfo) {
        let userAuth = userInfo._kmd.authtoken;
        sessionStorage.setItem('authtoken', userAuth);
        let userId = userInfo._id;
        sessionStorage.setItem('userId', userId);
        let username = userInfo.username;
        sessionStorage.setItem('username', username);
    }
    
	
	function isLoggedIn() {
		return sessionStorage.getItem('username') !== null;
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
        let userData = {
            username,
            password
        };

        return requestService.post('user', 'login', 'basic', userData);
    }

    function register(username, password, repeatPassword) {
        let userData = {
            username,
            password
        };

        return requestService.post('user', '', 'basic', userData);
    }

    function logout() {
        let logoutData = {
            authtoken: sessionStorage.getItem('authtoken')
        };

        return requestService.post('user', '_logout', 'kinvey', logoutData);
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
})()