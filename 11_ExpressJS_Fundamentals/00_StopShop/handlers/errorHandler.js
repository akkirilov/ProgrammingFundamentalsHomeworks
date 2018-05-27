
function resolve(req, res, httpService) {
	httpService.writeResponse(res, '/views/error/error.html');
}

module.exports = resolve;