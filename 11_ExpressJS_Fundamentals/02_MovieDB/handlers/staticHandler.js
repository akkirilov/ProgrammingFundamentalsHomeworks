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

module.exports = function (req, res) {
	if (req.method === "GET") {
		if (req.url.startsWith("/public/") || req.url === "/favicon.ico") {
			res.view('.' + req.url, mimeTypes[req.url.split('.').pop()]);
		} else {
			return true;
		}
	} else {
		return true;
	}
};