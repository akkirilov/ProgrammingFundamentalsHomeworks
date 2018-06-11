const mongoose = require('mongoose');
mongoose.Promise = global.Promise;

module.exports = function(config) {
	mongoose.connect(config.connectionString);
	let db = mongoose.connection;
	db.once('open', function(err) {
		if (err) {
			console.log(err);
			return;
		}
		console.log('DataBase ready ...');
	});
}
