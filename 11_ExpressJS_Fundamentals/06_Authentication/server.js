const port = 1331;
const express = require('express');
const handlebars = require('express-handlebars');
const cookieParser = require('cookie-parser');
const bodyParser = require('body-parser');
const session = require('express-session');
const passport = require('passport');
const config = require('./config/config');
const db = require('./config/database.config');

const auth = require('./config/auth');
auth.initialize();

const homeHandler = require('./handlers/homeHandler');
const errorHandler = require('./handlers/errorHandler');

const userRouter = require('./handlers/userHandler');
const authRouter = require('./handlers/authHandler');
const carRouter = require('./handlers/carHandler');

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

app.get('/', homeHandler.getHome);
app.use('/auth', authRouter);
app.use('/cars', carRouter);
app.use('/users', userRouter);


app.get('/*', errorHandler.get404);
