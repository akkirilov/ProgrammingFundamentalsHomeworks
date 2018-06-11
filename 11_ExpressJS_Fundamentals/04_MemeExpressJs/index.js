const port = 3003;
const handlebars = require('express-handlebars');
const bodyParser = require('body-parser');
const express = require('express');
const app = express();

const config = require('./config/config');
const database = require('./config/database.config');

const homeHandler = require('./handlers/homeHandler');
const memeHandler = require('./handlers/memeHandler');
const genreHandler = require('./handlers/genreHandler');
const errorHandler = require('./handlers/errorHandler');

database(config['development']);

app.use(bodyParser.urlencoded({extended: true}));

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
app.get('/memes/viewAll', memeHandler.getViewAllMemes);
app.get('/memes/add', memeHandler.getAddMeme);
app.post('/memes/add', memeHandler.postAddMeme);
app.get('/memes/search', memeHandler.getMemeSearch);
app.get('/memes/details/:id', memeHandler.getMemeDetails);

app.get('/genres/add', genreHandler.getAddGenre);
app.post('/genres/add', genreHandler.postAddGenre);

app.get('/*', errorHandler.get404);

