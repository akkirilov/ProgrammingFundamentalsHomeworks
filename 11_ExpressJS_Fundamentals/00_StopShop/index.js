const http = require('http');
const frontHandler = require('./handlers/frontHandler').frontHandler;

const port = 3000;
const server = http.createServer(frontHandler);

if (server.listen(port)) {
	console.log('http server listening on port ' + port + '...');
} else {
	console.log('http server cannot start on port ' + port);
}