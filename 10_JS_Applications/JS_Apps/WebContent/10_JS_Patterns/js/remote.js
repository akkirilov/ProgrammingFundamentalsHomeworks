let remote = (function() {
	let BASE_URL = 'https://baas.kinvey.com';
	let APP_KEY = 'kid_Skow-UciM';
	let APP_SECRET = '9568e9e03d524ebbbebabfe55a0ac3f7';
	
	function makeAuth(auth) {
		if (auth.toLowerCase() === 'basic') {
			return 'Basic ' + btoa(APP_KEY + ':' + APP_SECRET); 
		} else {
			return 'Kinvey ' + sessionStorage.getItem('authtoken');
		}
	}
	
	function makeRequest(method, module, endPoint, auth) {
		return {
			method: method,
			url: `${BASE_URL}/${module}/${APP_KEY}/${endPoint}`,
			headers: { Authorization: makeAuth(auth) }
		};
	}
	
	function get(module, endPoint, auth) {
		return $.ajax(makeRequest('GET', module, endPoint, auth));
	}
	
	function post(module, endPoint, auth, data) {
		let obj = makeRequest('POST', module, endPoint, auth)
		if (data) {
			obj.data = data;
		}
		return $.ajax(obj);
	}
	
	function update(module, endPoint, auth, data) {
		let obj = makeRequest('PUT', module, endPoint, auth)
		obj.data = data;
		return $.ajax(obj);
	}
	
	function remove(module, endPoint, auth) {
		return $.ajax(makeRequest('DELETE', module, endPoint, auth));
	}
	
	return {
		get, 
		post, 
		update, 
		remove
	}
})();