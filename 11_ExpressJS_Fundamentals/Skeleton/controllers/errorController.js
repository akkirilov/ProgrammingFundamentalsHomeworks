function getError(req, res) {
	let isLoggedIn = false;
	let isAdmin = false;
	if (req.user) {
		isLoggedIn = true;
		isAdmin = req.session.user.isAdmin;
	}
	const message = req.session.message;
	req.session.message = '';
	res.render('error/error', { message, isLoggedIn, isAdmin });
}

module.exports = getError;
