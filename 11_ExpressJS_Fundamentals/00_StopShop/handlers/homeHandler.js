
function resolve(req, res, httpService) {
	if (req.url === "/" || req.url === "/index.html") {
		if (req.method === "GET") {
			httpService.createResponse(res, '/views/home/index.html');
		} else {
			return true;
		}
	} else {
		return true;
	}
}

module.exports = resolve;
