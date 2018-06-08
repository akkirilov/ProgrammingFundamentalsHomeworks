const httpService = require('../services/httpService');

const homeHandler = require('./homeHandler');
const staticHandler = require('./staticHandler');
const errorHandler = require('./errorHandler');
const prooductHandler = require('./productHandler');
const categoryHandler = require('./categoryHandler');

const handlers = [
	homeHandler,
	staticHandler,
	prooductHandler,
	categoryHandler,
	errorHandler
];

function frontHandler(req, res) {
	console.log(req.url);
	for (let h of handlers) {
		if (h(req, res, httpService) != true) {
			break;
		}
	}
}

module.exports = {
		frontHandler
};