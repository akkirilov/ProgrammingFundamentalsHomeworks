const db = require('../config/database');
const qs = require('querystring');

function resolve(req, res, httpService) {
	if (req.url === "/" || req.url === "/index.html") {
		if (req.method === "GET") {
			let content = httpService.createResponse(res, '/views/home/index.html');
			if (content) {
				let newContent = '';
				let products = db.getAll();
				for (let p of products) {
					newContent += `
						<div class="product-card">
						<img class="product-img" src="${p.image}">
						<h2>${p.name}</h2>
						<p>${p.description}</p>
						</div>`;
				}
				res.write(content.replace('{{content}}', newContent));
				res.end();
			}
		} else {
			return true;
		}
	} else if (req.url.startsWith("/?query=") || req.url === "/index.html?query=") {
		let content = httpService.createResponse(res, '/views/home/index.html');
		if (content) {
			let name = req.url.replace("\/?query=", "");
			let newContent = '';
			let products = db.findAllByName(name);
			for (let p of products) {
				newContent += `
					<div class="product-card">
					<img class="product-img" src="${p.image}">
					<h2>${p.name}</h2>
					<p>${p.description}</p>
					</div>`;
			}
			res.writeHead(200, {
				"Content-Type": "text/html"
			});
			res.write(content.replace('{{content}}', newContent));
			res.end();
		} else {
			return true;
		}
	} else {
		return true;
	}
}

module.exports = resolve;
