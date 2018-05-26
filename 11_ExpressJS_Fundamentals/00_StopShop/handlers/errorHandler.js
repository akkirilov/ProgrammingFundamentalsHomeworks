
function resolve(req, res, httpService) {
	httpService.createResponse(res, '/views/error/error.html');
}

module.exports = resolve;