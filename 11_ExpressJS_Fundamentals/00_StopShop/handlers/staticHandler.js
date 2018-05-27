
function resolve(req, res, httpService) {
	if (req.url.startsWith("/static/") && req.method === "GET") {
		httpService.writeResponse(res, req.url);
	} else {
		return true;
	}
}

module.exports = resolve;