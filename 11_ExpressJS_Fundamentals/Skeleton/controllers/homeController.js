//const Product = require('../models/Product');

function getHome(req, res) {
	let isLoggedIn = false;
	let isAdmin = false;
	if (req.user) {
		isLoggedIn = true;
		isAdmin = req.session.user.isAdmin;
	}
	const message = req.session.message;
	req.session.message = '';
	return res.render('home/home', { message, isLoggedIn, isAdmin });
//	Product.find({'isBought':false}).populate('category')
//	.then(function(products) {
//		if (req.query.query) {
//			products = products.filter(x => x.name.toLowerCase().includes(req.query.query.toLowerCase()));
//		}
//			for (let p of products) {
//				if (isLoggedIn) {
//					p.isCreatorOrAdmin = (p.creator.toString() === req.user.toString() || isAdmin);
//					p.awolledToBuy = (p.creator.toString() !== req.user.toString());
//				} else {
//					p.awolledToBuy = true;
//				}
//			}
//		return res.render('home/home', { products, message, isLoggedIn, isAdmin });
//	}).catch(function(err) {
//		console.log(err);
//		req.session.message = err.message;
//		return res.redirect('/error');
//	});
}

module.exports = getHome;
