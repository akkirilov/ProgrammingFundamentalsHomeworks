const fs = require('fs');
const url = require('url');
const path = require('path');

const mimeTypes = {
	"js": "application/javascript",
	"json": "application/json",
	"css": "text/css",
	"png": "image/png",
	"jpeg": "image/jpeg",
	"ico": "image/x-icon",
	"txt": "text/plain",
	"html": "text/html"
};

function writeHeader(res, code, extension) {
	let type = mimeTypes[extension];
	if (!type) {
		type = "text/html";
	}
	res.writeHead(code, {
		'Content-Type' : type
	});
}

function notFound(res) {
	writeHeader(res, 404, "text/plain");
	res.end();
}

function createResponse(res, pathUrl) {
	let extention = pathUrl.split('.').pop();
	let filePath = path.normalize(path.join(__dirname, ("../" + pathUrl)));
	let code = 200;
	let readStream = fs.createReadStream(filePath);
	readStream.on('error', function(err) {
		filePath = path.normalize(path.join(__dirname, ('../views/error/error.html')));
		extention = "html";
		code = 404;
		let errReadStream = fs.createReadStream(filePath);
		writeHeader(res, code, extention);
		errReadStream.pipe(res);
	});
	writeHeader(res, code, extention);
	readStream.pipe(res);
}

module.exports = {
		createResponse
};