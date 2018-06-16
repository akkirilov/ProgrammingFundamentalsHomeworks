const config = require('./config/config');
require('./config/passport.config')();
require('./config/database.config')(config['development']);
const app = require('./config/exppress.config')(config['development']);

const homeController = require('./controllers/homeController');
const userController = require('./controllers/userController');
const errorController = require('./controllers/errorController');

app.get('/', homeController);
app.get('/index.html', homeController);

app.use('/users', userController);


app.get('/*', errorController);
