const qs = require('querystring');
const products = require('../config/database');

function addProduct(req, res) {
	let reqBody = '';
	req.on('data', function(data) {
		reqBody += data;
	});
	req.on('end', function() {
		let code = 200;
		let post = qs.parse(reqBody);
		let entity = products.addProduct(post);
		if (!entity) {
			
		}
		console.log(req.headers.host);
		res.writeHead(302, {
			'Location': 'http://' + req.headers.host + '/'
		});
		res.end();
	});
}

module.exports = {
	addProduct	
};