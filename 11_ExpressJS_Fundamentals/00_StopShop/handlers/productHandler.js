const Product = require('../models/Product');
const Category = require('../models/Category');
const formidable = require('formidable');
const shortid = require('shortid');
const fs = require('fs');
const path = require('path');
const pathPrefix = path.normalize(path.join(__dirname, "../"));
const staticDir = 'static';
const imageDir = '/images/products/';

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

function getBuyProduct(req, res) {
	let productId = req.params.id;
	Product.findById(productId).then(function(product) {
		res.render('products/buyProduct', { product });
	}).catch(function(err) {
		console.log(err);
		res.render('error/error');
	});
}

function postBuyProduct(req, res) {
	let productId = req.params.id;
	Product.findById(productId).then(function(product) {
		product.isBought = true;
		product.save();
		res.redirect('/');
	}).catch(function(err) {
		console.log(err);
		res.render('error/error');
	});
}

function getEditProduct(req, res) {
	let productId = req.params.id;
	Product.findById(productId).then(function(product) {
		Category.find().then(function(categories) {
			for (let c of categories) {
				if (c._id.toString() == product.category.toString()) {
					c.isSelected = true;
				} else {
					c.isSelected = false;
				}
			}
			res.render('products/editProduct', { product, categories });
		}).catch(function(err) {
			console.log(err);
			res.render('error/error');
		});
	}).catch(function(err) {
		console.log(err);
		res.render('error/error');
	});
}

function postEditProduct(req, res) {
	let productId = req.params.id;
	Product.findById(productId).then(function(p) {
		let form = new formidable.IncomingForm();
	    form.parse(req, function (err, fields, files) {
	    	let filename;
	    	p.name = fields.name;
	    	p.description = fields.description;
	    	p.price = fields.price;
	    	
	    	if (files.image.name !== '') {
	    		if (!p.image.endsWith('/default.jpeg')) {
	    			fs.unlink(pathPrefix + staticDir + p.image);
				}
	       	 	filename = shortid.generate() + '.' + files.image.type.split('/').pop();
	       	 	p.image = imageDir + filename;
	       	 	let tempPath = files.image.path;
	       	 	let newPath = pathPrefix + staticDir + imageDir + filename;
	            fs.rename(tempPath, newPath, function (err) {
	            	if (err) {
	            		console.log(err);
	            		res.render('error/error');
	            	}
	            });
			}
	    	
	    	if (fields.category.toString() !== p.category.toString()) {
	    		Category.findById(p.category).then(function(c) {
	    			c.products = c.products.filter(x => x._id.toString() != p._id.toString());
					c.save();
				}).catch(function(err) {
					console.log(err);
					res.render('error/error');
				});
	    		
	    		p.category = fields.category;
	    		Category.findById(p.category).then(function(c) {
					c.products.push(p._id);
					c.save();
				}).catch(function(err) {
					console.log(err);
					res.render('error/error');
				});
			}
	    	p.save();
	    	res.redirect('/');
	    });
	}).catch(function(err) {
		console.log(err);
		res.render('error/error');
	});
}

function getDeleteProduct(req, res) {
	let productId = req.params.id;
	Product.findById(productId).then(function(product) {
		res.render('products/deleteProduct', { product });
	}).catch(function(err) {
		console.log(err);
		res.render('error/error');
	});
}

function postDeleteProduct(req, res) {
	let productId = req.params.id;
	Product.findByIdAndRemove(productId).then(function(p) {
		Category.findById(p.category).then(function(c) {
			c.products = c.products.filter(x => x._id.toString() != productId);
			c.save();
		}).catch(function(err) {
			console.log(err);
			res.render('error/error');
		});
		if (!p.image.endsWith('/default.jpeg')) {
			fs.unlink(pathPrefix + staticDir + p.image, function() {
				console.log("Delete image " + p.image);
			});
		}
	}).catch(function(err) {
		console.log(err);
		res.render('error/error');
	});
	res.redirect('/');
}

module.exports = {
		getAddProduct,
		postAddProduct,
		getBuyProduct,
		postBuyProduct,
		getEditProduct,
		postEditProduct,
		getDeleteProduct,
		postDeleteProduct
};
