const fs = require('fs');
const productsPath = './db/products.json';
let products = {};
let productsData;

products.getAll = function() {
	if (!fs.existsSync(productsPath)) {
		fs.writeFileSync(productsPath, '[]');
		return [];
	}
	productsData = JSON.parse(fs.readFileSync(productsPath).toString());
	return productsData;
};
products.addProduct = function(product) {
	if (!productsData) {
		products.getAll();
	}
	productsData.push(product);
	fs.writeFileSync(productsPath, JSON.stringify(productsData));
};
products.findByName = function(name) {
	if (!productsData) {
		products.getAll();
	}
	for (let p of productsData) {
		if (p.name === name) {
			return p;
		}
	}
};
products.findAllByName = function(n) {
	if (!productsData) {
		products.getAll();
	}
	return productsData.filter(x => x.name.toLowerCase().includes(n.toLowerCase()));
};

module.exports = products;
