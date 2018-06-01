let products = [];
let count = 1;

let productsDB = {};
productsDB.getAll = function() {
	return products;
};
productsDB.addProduct = function(product) {
	count++;
	products.push(product);
};
productsDB.findByName = function(name) {
	for (let p of products) {
		if (p.name === name) {
			return p;
		}
	}
};
productsDB.findAllByName = function(n) {
	return products.filter(x => x.name.toLowerCase().includes(n.toLowerCase()));
};

module.exports = productsDB;
