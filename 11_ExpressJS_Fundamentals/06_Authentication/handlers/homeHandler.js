const router = require('express').Router();
const passport = require('passport');

function getHome(req, res) {
    let isLoggedIn = false;
    let isAdmin = false;
    if (req.user) {
    	isLoggedIn = true;
    	if (req.session.user.role === 'admin') {
    		isAdmin = true;
    		req._id
		}
	}
    const message = req.session.message;
    req.session.message = '';
    res.render('home/index', {
    	isLoggedIn,
    	isAdmin,
    	userId : req.user,
        message
    });
}

module.exports = {
		getHome
};