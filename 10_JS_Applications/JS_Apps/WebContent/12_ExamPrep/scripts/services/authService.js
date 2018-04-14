let authService = (() => {
	
	const MODULE = 'user';
	
    function saveSession(userInfo) {
        let userAuth = userInfo._kmd.authtoken;
        sessionStorage.setItem('authtoken', userAuth);
        let userId = userInfo._id;
        sessionStorage.setItem('userId', userId);
        let username = userInfo.username;
        sessionStorage.setItem('username', username);
    }

    function login(username, password) {
        let userData = {
            username,
            password
        };
        return requestService.post(MODULE, 'login', 'basic', userData);
    }

    function register(username, password, repeatPassword) {
        let userData = {
            username,
            password
        };
        return requestService.post(MODULE, '', 'basic', userData);
    }

    function logout() {
        let logoutData = {
            "authtoken": "sessionStorage.getItem('authtoken')"
        };

        return requestService.post(MODULE, '_logout', 'kinvey', logoutData);
    }

    return {
        login,
        register,
        logout,
        saveSession
    }
})()