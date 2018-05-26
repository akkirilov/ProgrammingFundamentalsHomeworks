
function resolve(req, res, httpService) {
	if (req.url.startsWith("/static/css")) {
		if (req.method === "GET") {
			httpService.createResponse(res, req.url, "text/css");
		} else {
			return true;
		}
	} else if (req.url.startsWith("/static/js")) {
		if (req.method === "GET") {
			httpService.createResponse(res, req.url, "application/javascript");
		} else {
			return true;
		}
	} else if (req.url === "/favicon.ico") {
		if (req.method === "GET") {
			httpService.createResponse(res, req.url, "image/x-icon");
		} else {
			return true;
		}
	} else {
		return true;
	}
}

module.exports = resolve;