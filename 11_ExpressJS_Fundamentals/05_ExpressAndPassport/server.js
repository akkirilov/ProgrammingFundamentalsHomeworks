const port = 1331;
const express = require('express');
const handlebars = require('express-handlebars');
const cookieParser = require('cookie-parser');
const bodyParser = require('body-parser');
const session = require('express-session');
const passport = require('passport');
const config = require('./config/config');
const db = require('./config/database.config');

const authRouter = require('./handlers/authHandler');

require('./handlers/authHandler');
db(config['development']);

const app = express();
app.use(bodyParser.urlencoded({ extended: true }));
app.use(cookieParser());
app.use(session({ secret: 'neshto-taino!@#$%',
	resave: false,
	saveUninitialized: false }));
app.use(passport.initialize());
app.use(passport.session());

app.use('/auth', authRouter);

app.use(express.static(__dirname + '/public/'));
app.engine('.hbs', handlebars({
	extname: '.hbs',
	partialsDir: "views/partials"
}));
app.set('view engine', 'hbs');
app.set('views', __dirname + '/views');

app.listen(port, function() {
	console.log('Server listening on port ' + port + '...') 
});

function isAuthenticated(req, res, next) {
    if (req.user === undefined) {
        return res.redirect('/auth/login');
    }
    next();
}

app.get('/', (req, res) => {
    let username = 'anonymous';
    let isLogedIn = false;
    if (req.user) {
    	username = req.user;
    	isLogedIn = true;
	}
    const message = req.session.message;
    req.session.message = '';
    res.render('home/index', {
    	isLogedIn,
        message,
        username
    });
});

app.get('/private', isAuthenticated, (req, res) => {
    let username = req.user;
    let isLogedIn = true;
    const message = req.session.message;
    req.session.message = '';
    res.render('home/private', {
    	isLogedIn,
        message,
        username
    });
});


