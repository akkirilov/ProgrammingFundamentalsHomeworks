const fs = require('fs');

module.exports = function (req, res) {
	const url = req.url;
	if (req.method === "GET") {
		if (url === '/' || url === '/index.html') {
			res.view('./views/home.html')
		} else {
			return true;
		}
	} else if (req.method === "POST") {
		return true;
	} else {
		return true;
	}
}
