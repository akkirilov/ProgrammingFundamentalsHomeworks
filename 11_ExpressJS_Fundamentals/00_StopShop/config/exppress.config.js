const port = 3000;
const express = require('express');
const handlebars = require('express-handlebars');
const bodyParser = require('body-parser');
const cookieParser = require('cookie-parser');
const session = require('express-session');
const passport = require('passport');
const path = require('path');
const rootPath = path.normalize(path.join(__dirname, '../'));

const app = express();

app.use(bodyParser.urlencoded({extended: true}));
app.use(cookieParser());
app.use(session({ secret: 'neshto-taino!@#$%',
	resave: false,
	saveUninitialized: false 
}));
app.use(passport.initialize());
app.use(passport.session());
app.use(express.static(rootPath + '/static/'));
app.engine('.hbs', handlebars({
	extname: '.hbs',
	partialsDir: "views/partials"
}));
app.set('view engine', 'hbs');
app.set('views', rootPath + '/views');

app.listen(port, function() {
	console.log('Server listening on port ' + port + '...') 
});

module.exports = app;