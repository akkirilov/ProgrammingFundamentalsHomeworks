const qs = require('querystring');
const fs = require('fs');
const products = require('../config/database');
const multiparty = require('multiparty');
const shortid = require('shortid');

function addProduct(req, res) {
	let product = {};
	let form = new multiparty.Form;
	form.on('part', function(part) {
		if (part.filename) {
			let dataString = '';
			part.setEncoding('binary');
			part.on('data', function(data) {
				dataString += data;
			});
			part.on('end', function() {
				let fileName = shortid.generate();
				let filePath = '/static/images/products/' + fileName + '.jpg';
				product.image = filePath;
				fs.writeFile(`.${filePath}`, dataString, {encoding: 'ascii'}, function(err) {
					console.log(err);
					return;
				});
			});
		} else {
			part.setEncoding('utf-8');
			let field = '';
			part.on('data', function(data) {
				field += data;
			});
			part.on('end', function() {
				product[part.name] = field;
			});
		}
	});
	form.on('close', function() {
		products.addProduct(product);
		res.writeHead(302, {
			'Location': 'http://' + req.headers.host + '/'
		});
		res.end();
	});
	form.parse(req);
//	let reqBody = '';
//	req.on('data', function(data) {
//		reqBody += data;
//	});
//	req.on('end', function() {
//		let code = 200;
//		let post = qs.parse(reqBody);
//		let entity = products.addProduct(post);
//		if (!entity) {
//			
//		}
//		
//	});
}

module.exports = {
	addProduct	
};