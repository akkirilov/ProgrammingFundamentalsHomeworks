const fs = require('fs');
const url = require('url');
const path = require('path');

function writeHeader(res, code, type) {
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

function createResponse(res, fileSource, type) {
	let filePath = path.normalize(path.join(__dirname, ("../" + fileSource)));
	fs.readFile(filePath, function(error, data) {
		if (error) {
			notFound(res);
		} else {
			writeHeader(res, 200, type);
			res.write(data);
			res.end();
		}
	});
}


module.exports = {
		createResponse
};