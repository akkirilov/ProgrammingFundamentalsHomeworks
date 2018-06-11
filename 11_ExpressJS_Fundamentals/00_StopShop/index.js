const port = 3000;
const handlebars = require('express-handlebars');
const bodyParser = require('body-parser');
const express = require('express');
const app = express();

const config = require('./config/config');
const database = require('./config/database.config');

const homeHandler = require('./handlers/homeHandler');
const prooductHandler = require('./handlers/productHandler');
const categoryHandler = require('./handlers/categoryHandler');
const errorHandler = require('./handlers/errorHandler');


database(config['development']);

app.use(bodyParser.urlencoded({extended: true}));

app.use(express.static(__dirname + '/static/'));

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

app.get('/products/add', prooductHandler.getAddProduct);
app.post('/products/add', prooductHandler.postAddProduct);
app.get('/products/buy/:id', prooductHandler.getBuyProduct);
app.post('/products/buy/:id', prooductHandler.postBuyProduct);
app.get('/products/edit/:id', prooductHandler.getEditProduct);
app.post('/products/edit/:id', prooductHandler.postEditProduct);
app.get('/products/delete/:id', prooductHandler.getDeleteProduct);
app.post('/products/delete/:id', prooductHandler.postDeleteProduct);

app.get('/categories/add', categoryHandler.getAddCategory);
app.post('/categories/add', categoryHandler.postAddCategory);



app.get('/*', errorHandler.get404);

