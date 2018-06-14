function get404(req, res) {
	res.render('error/error');
}

function get404(req, res) {
	res.render('error/error');
}

function getDefaultError(err) {
	console.log(err);
	res.status(404);
}

module.exports = {
		get404,
		getDefaultError
};