const http = require('http');
const url = require('url');
const handlers = require('./handlers/handlerBlender');
const config = require('./config/config');
const db = require('./config/database.config');
const port = 2323;

db(config['development']).then(function() {
	console.log('DB ready ...')
	http
    	.createServer(function(req, res) {
    		console.log(req.method + ' - ' + url.parse(req.url).pathname);
    		for (let handler of handlers) {
    			req.pathname = url.parse(req.url).pathname;
    			req.params = url.parse(req.url, true).query;
    			if (handler(req, res) !== true) {
    				break;
    			}
    		}
    	})
    	.listen(port);
    	console.log('Server listening on port ' + port + '...');
}).catch(function() {
    console.log('Failed to load DB')
});
