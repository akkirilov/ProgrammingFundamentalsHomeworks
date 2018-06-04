const http = require('http');
const frontHandler = require('./handlers/frontHandler');
const port = 3000;

http.createServer(frontHandler)
.listen(port);

console.log('Server running at http://127.0.0.1:' + port);
