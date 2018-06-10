const Product = require('../models/Product');
const Category = require('../models/Category');
const formidable = require('formidable');
const shortid = require('shortid');
const fs = require('fs');
const path = require('path');
const pathPrefix = path.normalize(path.join(__dirname, "../"));
const staticDir = 'static/';
const imageDir = 'images/products/';

function getAddProduct(req, res) {
	Category.find().then(function(categories) {
		res.render('products/addProduct', { categories });
	}).catch(function(err) {
		console.log(err);
		res.render('error/error');
	});
}

function postAddProduct(req, res) {
	let form = new formidable.IncomingForm();
    form.parse(req, function (err, fields, files) {
    	let filename;
    	
    	let product = { 
    			name: fields.name,
    			description: fields.description,
    			price: fields.price,
    			category: fields.category
    	};
    	
    	if (files.image.name !== '') {
       	 	filename = shortid.generate() + '.' + files.image.type.split('/').pop();

       	 	let tempPath = files.image.path;
       	 	let newPath = pathPrefix + staticDir + imageDir + filename;
            fs.rename(tempPath, newPath, function (err) {
            	if (err) {
            		res.render('error/error');
            		console.log(err);
            	}
            });
		}
    	
    	if (filename) {
    		product.image = imageDir + filename;
    	} else {
    		product.image = imageDir + 'default.jpeg';
    	}
    	
    	Product.create(product)
    	.then(function(p) {
    		Category.findById(p.category).then(function(c) {
				c.products.push(p._id);
				c.save();
				res.redirect('/');
			}).catch(function(err) {
				console.log(err);
				res.render('error/error');
			});
		}).catch(function(err) {
			console.log(err);
			res.render('error/error');
		});
    });
}

module.exports = {
		getAddProduct,
		postAddProduct
};
