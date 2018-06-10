const Product = require('../models/Product');

function getHome(req, res) {
	Product.find({})
	.then(function(products) {
		if (req.query.query) {
			products = products.filter(x => x.name.toLowerCase().includes(req.query.query.toLowerCase()));
		}
		res.render('home/home', { products });
	}).catch(function(err) {
		console.log(err);
		res.render('error/error');
	});
}

module.exports = {
		getHome
};
