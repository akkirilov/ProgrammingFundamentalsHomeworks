const port = 3000;
const express = require('express');
const handlebars = require('express-handlebars');
const bodyParser = require('body-parser');
const cookieParser = require('cookie-parser');
const session = require('express-session');
const passport = require('passport');
const path = require('path');
const rootPath = path.normalize(path.join(__dirname, '../'));

function initialize(config) {
	const app = express();
	app.use(bodyParser.urlencoded({extended: true}));
	app.use(cookieParser());
	app.use(session({ 
		secret: config.secret,
		resave: false,
		saveUninitialized: false 
	}));
	app.use(passport.initialize());
	app.use(passport.session());
	app.use(express.static(config.rootPath + '/static/'));
	app.engine('.hbs', handlebars({
		extname: '.hbs',
		partialsDir: "views/partials"
	}));
	app.set('view engine', 'hbs');
	app.set('views', config.rootPath + '/views');

	app.listen(config.port, function() {
		console.log('Server listening on port ' + config.port + '...') 
	});
	return app;
}

module.exports = initialize;