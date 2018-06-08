const qs = require('querystring');
const fs = require('fs');
const Product = require('../models/Product');
const Category = require('../models/Category');
const multiparty = require('multiparty');
const shortid = require('shortid');

function getAddProduct(content, res) {
	if (content) {
		Category.find({}).then(function(data) {
			let newContent = '<select class="input-field" name="category">';
			for (let c of data) {
				newContent += `<option value="${c._id}">${c.name}</option>`;
//				console.log(c.name);
			}
			newContent += '</select>';
			res.write(content.replace('{{replace}}', newContent));
			res.end();
		});
	} else {
		res.end();
	}
}

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
		Product.create(product).then(function(p) {
			Category.findById(p.category).then(function(c) {
				c.products.push(p._id);
				c.save();
			})
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
	addProduct,
	getAddProduct
};