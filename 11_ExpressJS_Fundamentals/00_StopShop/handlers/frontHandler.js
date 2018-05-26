const httpService = require('../services/httpService');

const homeHandler = require('./homeHandler');
const staticHandler = require('./staticHandler');
const errorHandler = require('./errorHandler');

const handlers = [
	homeHandler,
	staticHandler,
	errorHandler
];

function frontHandler(req, res) {
	for (let h of handlers) {
		if (h(req, res, httpService) != true) {
			break;
		}
	}
}

module.exports = {frontHandler};