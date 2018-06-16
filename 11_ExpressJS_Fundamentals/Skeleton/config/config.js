const path = require('path');

module.exports = {
	development: { 
		connectionString: 'mongodb://localhost:27017/ExamDB', 
		port: 3000, 
		rootPath: path.normalize(path.join(__dirname, '../')),
		secret: 'neshto-taino!@#$%'
	},
	production: { 
		connectionString: 'mongodb://localhost:27017/ExamDB', 
		port: 3000, 
		rootPath: path.normalize(path.join(__dirname, '../')),
		secret: 'neshto-taino!@#$%' }
};
