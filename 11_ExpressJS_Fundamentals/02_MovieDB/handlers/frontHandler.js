const fs = require('fs');
const path = require('path');

const movieHandler = require('./movieHandler');
const homeHandler = require('./homeHandler');
const errorHandler = require('./errorHandler');
const staticHandler = require('./staticHandler');

const handlers = [
	homeHandler,
	staticHandler,
	movieHandler,
	errorHandler
];

function frontHandler(req, res) {
	res.view = (pathUrl, contentType, replaceData) => {
		let code = 200;
		let filePath = path.normalize(path.join(__dirname, ("../" + pathUrl)));
		let file = fs.readFileSync(filePath);
		
		if (replaceData != undefined) {
			file = file.toString();
			for (let key in replaceData) {
				file = file.replace(key, replaceData[key]);
			}
		}
		
		if (pathUrl.endsWith('/error.html')) {
			code = 404;
		}
		if (!contentType) {
			contentType = 'text/html';
		}
		
		res.writeHead(code, {
			'Content-Type': contentType
		});
		
		res.write(file);
		res.end();
	}
	
	for (let h of handlers) {
		if (h(req, res) != true) {
			break;
		}
	}
}

module.exports = frontHandler;
