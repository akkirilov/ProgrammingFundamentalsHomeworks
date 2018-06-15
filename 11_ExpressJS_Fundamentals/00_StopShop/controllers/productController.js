const router = require('express').Router();
const Product = require('../models/Product');
const Category = require('../models/Category');
const User = require('../models/User');
const formidable = require('formidable');
const shortid = require('shortid');
const fs = require('fs');
const path = require('path');
const pathPrefix = path.normalize(path.join(__dirname, "../"));
const staticDir = 'static';
const imageDir = '/images/products/';

function getAll(req, res) {
	if (!req.user) {
		req.session.message = 'You are not legged in!';
		return res.redirect('/users/login');
	}
	const message = req.session.message;
	req.session.message = '';
	let isLoggedIn = true;
	let isAdmin = req.session.user.isAdmin;
	if (!isAdmin) {
		req.session.message = "You don't have permission!";
		return res.redirect('/');
	}
	Product.find().populate('category')
	.then(function(products) {
		for (let p of products) {
			p.isCreatorOrAdmin = (p.creator.toString() === req.user.toString() || isAdmin);
			p.awolledToBuy = (p.creator.toString() !== req.user.toString());
		}
		return res.render('products/all', { products, message, isLoggedIn, isAdmin });
	}).catch(function(err) {
		console.log(err);
		return res.render('error/error');
	});
}

function getFindByCategory(req, res) {
	const categoryId = req.params.id;
	let isLoggedIn = false;
	let isAdmin = false;
	if (req.user) {
		isLoggedIn = true;
		isAdmin = req.session.user.isAdmin;
	}
	const message = req.session.message;
	req.session.message = '';
	Product.find({category: categoryId}).populate('category')
	.then(function(products) {
		if (isLoggedIn) {
			for (let p of products) {
				p.isCreatorOrAdmin = (p.creator.toString() === req.user.toString() || isAdmin);
			}
		}
		return res.render('home/home', { products, message, isLoggedIn, isAdmin });
	}).catch(function(err) {
		console.log(err);
		req.session.message = 'There are no category with such id!';
		return res.redirect('/');
	});
}

function getAddProduct(req, res) {
	if (!req.user) {
		req.session.message = 'You are not legged in!';
		return res.redirect('/users/login');
	}
	const message = req.session.message;
	req.session.message = '';
	let isLoggedIn = true;
	let isAdmin = req.session.user.isAdmin;
	Category.find().then(function(categories) {
		res.render('products/addProduct', { categories, message, isLoggedIn, isAdmin });
	}).catch(function(err) {
		console.log(err);
		res.render('error/error');
	});
}

function postAddProduct(req, res) {
	if (!req.user) {
		req.session.message = 'You are not legged in!';
		return res.redirect('/users/login');
	}
	let form = new formidable.IncomingForm();
    form.parse(req, function (err, fields, files) {
    	let filename;
    	let product = { 
    			name: fields.name,
    			description: fields.description,
    			price: fields.price,
    			category: fields.category,
    			creator: req.user,
    			isBought: false
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
    	Category.findById(fields.category).then(function(c) {
    		Product.create(product)
        	.then(function(p) {
        		c.products.push(p._id);
    			c.save();
    			User.findById(req.user).then(function(u) {
					u.createdProducts.push(p._id);
					u.save();
					req.session.message = 'Product added successfully!';
	    			res.redirect('/');
				});
    		}).catch(function(err) {
    			console.log(err);
    			res.render('error/error');
    		});
		}).catch(function(err) {
			console.log(err);
			req.session.message = 'There are no such category!';
			return res.redirect('/');
		});
    });
}

function getBuyProduct(req, res) {
	if (!req.user) {
		req.session.message = 'You are not legged in!';
		return res.redirect('/users/login');
	}
	const message = req.session.message;
	req.session.message = '';
	let isLoggedIn = true;
	let isAdmin = req.session.user.isAdmin;
	let productId = req.params.id;
	Product.findById(productId).then(function(product) {
		if (req.user.toString() === product._id.toString()) {
			req.session.message = "You can't buy products, that is your!";
			return res.redirect('/');
		}
		res.render('products/buyProduct', { product, message, isLoggedIn, isAdmin });
	}).catch(function(err) {
		console.log(err);
		req.session.message = 'There are no such product!';
		return res.redirect('/');
	});
}

function postBuyProduct(req, res) {
	if (!req.user) {
		req.session.message = 'You are not legged in!';
		return res.redirect('/users/login');
	}
	let productId = req.params.id;
	Product.findById(productId).then(function(product) {
		if (product.isBought) {
			req.session.message = "Product is already bought!";
			return res.redirect('/');
		}
		if (req.user.toString() === product._id.toString()) {
			req.session.message = "You can't buy products, that is your!";
			return res.redirect('/');
		}
		product.isBought = true;
		product.buyer = req.user;
		product.save();
		User.findById(req.user).then(function(u) {
			u.boughtProducts.push(product._id);
			u.save();
			req.session.message = `You successfully bought ${product.name}!`;
			return res.redirect('/');
		});
	}).catch(function(err) {
		console.log(err);
		req.session.message = 'There are no such product!';
		return res.redirect('/');
	});
}

function getEditProduct(req, res) {
	if (!req.user) {
		req.session.message = 'You are not legged in!';
		return res.redirect('/users/login');
	}
	const message = req.session.message;
	req.session.message = '';
	let isLoggedIn = true;
	let isAdmin = req.session.user.isAdmin;
	let productId = req.params.id;
	Product.findById(productId).then(function(product) {
		if (!isAdmin && product.creator.toString() !== req.user.toString()) {
			req.session.message = "You don't have permission!";
			return res.redirect('/');
		}
		if (product.isBought) {
			req.session.message = "Product is already bought!";
			return res.redirect('/');
		}
		Category.find().then(function(categories) {
			for (let c of categories) {
				if (c._id.toString() == product.category.toString()) {
					c.isSelected = true;
				} else {
					c.isSelected = false;
				}
			}
			return res.render('products/editProduct', { product, categories, message, isLoggedIn, isAdmin });
		}).catch(function(err) {
			console.log(err);
			res.render('error/error');
		});
	}).catch(function(err) {
		console.log(err);
		req.session.message = 'There are no such product!';
		return res.redirect('/');
	});
}

function postEditProduct(req, res) {
	if (!req.user) {
		req.session.message = 'You are not legged in!';
		return res.redirect('/users/login');
	}
	const message = req.session.message;
	req.session.message = '';
	let isLoggedIn = true;
	let isAdmin = req.session.user.isAdmin;
	let productId = req.params.id;
	Product.findById(productId).then(function(p) {
		if (!isAdmin && p.creator.toString() !== req.user.toString()) {
			req.session.message = "You don't have permission!";
			return res.redirect('/');
		}
		if (p.isBought) {
			req.session.message = "This product is already bought!";
			return res.redirect('/');
		}
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
	            		return res.render('error/error');
	            	}
	            });
			}
	    	
	    	if (fields.category.toString() !== p.category.toString()) {
	    		Category.findById(p.category).then(function(c) {
	    			c.products = c.products.filter(x => x._id.toString() != p._id.toString());
					c.save();
				}).catch(function(err) {
					console.log(err);
					return res.render('error/error');
				});
	    		
	    		p.category = fields.category;
	    		Category.findById(p.category).then(function(c) {
					c.products.push(p._id);
					c.save();
				}).catch(function(err) {
					console.log(err);
					return res.render('error/error');
				});
			}
	    	p.save();
	    	req.session.message = `You successfully edit ${p.name}!`;
	    	res.redirect('/');
	    });
	}).catch(function(err) {
		console.log(err);
		req.session.message = 'There are no such product!';
		return res.redirect('/');
	});
}

function getDeleteProduct(req, res) {
	if (!req.user) {
		req.session.message = 'You are not legged in!';
		return res.redirect('/users/login');
	}
	const message = req.session.message;
	req.session.message = '';
	let isLoggedIn = true;
	let isAdmin = req.session.user.isAdmin;
	let productId = req.params.id;
	Product.findById(productId).then(function(product) {
		return res.render('products/deleteProduct', { product, message, isLoggedIn, isAdmin });
	}).catch(function(err) {
		console.log(err);
		req.session.message = 'There are no such product!';
		return res.redirect('/');
	});
}

function postDeleteProduct(req, res) {
	if (!req.user) {
		req.session.message = 'You are not legged in!';
		return res.redirect('/users/login');
	}
	let productId = req.params.id;
	let isAdmin = req.session.user.isAdmin;
	Product.findById(productId).then(function(product) {
		if (!isAdmin && product.creator.toString() !== req.user.toString()) {
			req.session.message = "You don't have permission!";
			return res.redirect('/');
		}
		Product.findByIdAndRemove(productId).then(function(p) {
			Category.findById(p.category).then(function(c) {
				c.products = c.products.filter(x => x._id.toString() != productId);
				c.save();
				User.findById(p.creator).then(function(user) {
					user.createdProducts = user.createdProducts.filter(x => x._id.toString() != p._id.toString());
					user.save();
					if (!p.image.endsWith('/default.jpeg')) {
						fs.unlink(pathPrefix + staticDir + p.image, function() {
							console.log("Delete image " + p.image);
						});
					}
					User.findById(p.buyer).then(function(buyer) {
						buyer.boughtProducts = buyer.boughtProducts.filter(x => x._id.toString() != p._id.toString());
						buyer.save();
						req.session.message = `You successfully delete ${p.name}!`;
						res.redirect('/');
					});
				}).catch(function(err) {
					console.log(err);
					return res.render('error/error');
				});
			}).catch(function(err) {
				console.log(err);
				return res.render('error/error');
			});
		}).catch(function(err) {
			console.log(err);
			return res.render('error/error');
		});
	}).catch(function(err) {
		console.log(err);
		req.session.message = 'There are no such product!';
		return res.redirect('/');
	});
}

router.get('/all', getAll);
router.get('/findByCategory/:id', getFindByCategory);
router.get('/add', getAddProduct);
router.post('/add', postAddProduct);
router.get('/buy/:id', getBuyProduct);
router.post('/buy/:id', postBuyProduct);
router.get('/edit/:id', getEditProduct);
router.post('/edit/:id', postEditProduct);
router.get('/delete/:id', getDeleteProduct);
router.post('/delete/:id', postDeleteProduct);

module.exports = router;
