const categoryService = require('../services/categoryService');

function resolve(req, res, httpService) {
	if (req.url === "/category/add") {
		if (req.method === "GET") {
			let content = httpService.writeResponse(res, '/views/categories/add.html');
			if (content) {
				res.write(content);
				res.end();
			}
		} else if (req.method === "POST") {
			categoryService.addCategory(req, res);
		} else {
			return true;
		}
	} else {
		return true;
	}
}

module.exports = resolve;
