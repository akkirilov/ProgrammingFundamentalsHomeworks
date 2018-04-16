let requestService = (function() {
	
    const BASE_URL = "https://baas.kinvey.com/";
    const APP_KEY = "kid_rJ4pmAl2M";
    const APP_SECRET = "dc2cd473db524536b68a8b4dccaf82b4";

    function makeAuth(type) {
    	if (type.toLowerCase() === 'basic') {
    		return 'Basic ' + btoa(APP_KEY + ':' + APP_SECRET);
		} else {
			return 'Kinvey ' + sessionStorage.getItem('authtoken');
		}
    }

    function makeRequest(method, module, endpoint, auth) {
        return req = {
            method,
            url: BASE_URL + module + '/' + APP_KEY + '/' + endpoint,
            headers: {
                'Authorization': makeAuth(auth)
            }
        };
    }

    function get (module, endpoint, auth) {
        return $.ajax(makeRequest('GET', module, endpoint, auth));
    }

    function post (module, endpoint, auth, data) {
        let req = makeRequest('POST', module, endpoint, auth);
        req.data = data;
        return $.ajax(req);
    }

    function update (module, endpoint, auth, data) {
        let req = makeRequest('PUT', module, endpoint, auth);
        req.data = data;
        return $.ajax(req);
    }

    function remove (module, endpoint, auth) {
        return $.ajax(makeRequest('DELETE', module, endpoint, auth));
    }

    return {
        get,
        post,
        update,
        remove
    }
    
})();