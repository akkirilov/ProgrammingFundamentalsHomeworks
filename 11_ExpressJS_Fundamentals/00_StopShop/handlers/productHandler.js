const productService = require('../services/productService');


function resolve(req, res, httpService) {
	if (req.url === "/product/add") {
		if (req.method === "GET") {
			let content = httpService.createResponse(res, '/views/products/add.html');
			productService.getAddProduct(content, res);
		} else if (req.method === "POST") {
			productService.addProduct(req, res);
		} else {
			return true;
		}
	} else {
		return true;
	}
}

module.exports = resolve;