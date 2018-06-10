const Category = require('../models/Category');

function getAddCategory(req, res){
	res.render('categories/addCategory');
}

function postAddCategory(req, res){
	let category = {
			name: req.body.name
	};
	Category.find({name: category.name}).then(function(data) {
		if (data.length > 0) {
			res.render('categories/addCategory', { error: 'Category with the same name alredy exists!' });
		} else {
			Category.create(category).then(function() {
				res.redirect('/');
			}).catch(function(err) {
				console.log(err);
				res.render('error/error');
			});
		}
	}).catch(function(err) {
		console.log(err);
		res.render('error/error');
	});
}

module.exports = {
		getAddCategory,
		postAddCategory
};
