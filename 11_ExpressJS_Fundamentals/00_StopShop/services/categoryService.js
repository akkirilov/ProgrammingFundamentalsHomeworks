const Category = require('../models/Category');
const multiparty = require('multiparty');

function addCategory(req, res) {
	let category = {};
	let form = new multiparty.Form;
	form.on('part', function(part) {
		part.setEncoding('utf-8');
		let field = '';
		part.on('data', function(data) {
			field += data;
		});
		part.on('end', function() {
			category[part.name] = field;
		});
	});
	form.on('close', function() {
		Category.create(category).then(function(c) {
			res.writeHead(302, {
				'Location': 'http://' + req.headers.host + '/'
			});
			res.end();
		}).catch(function(err) {
			console.log(err);
			res.end();
		});
	});
	form.parse(req);
}

module.exports = {
		addCategory
};