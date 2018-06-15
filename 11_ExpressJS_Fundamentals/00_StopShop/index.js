require('./config/passport.config')();
const app = require('./config/exppress.config');
const config = require('./config/config');
const database = require('./config/database.config');
database(config['development']);

const homeController = require('./controllers/homeController');
const productController = require('./controllers/productController');
const categoryController = require('./controllers/categoryController');
const userController = require('./controllers/userController');
const errorHandler = require('./controllers/errorHandler');

app.get('/', homeController);
app.get('/index.html', homeController);
app.use('/products', productController);
app.use('/categories', categoryController);
app.use('/users', userController);

app.get('/*', errorConroller);
