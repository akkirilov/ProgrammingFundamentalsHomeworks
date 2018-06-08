const port = 3000;

const http = require('http');
const frontHandler = require('./handlers/frontHandler').frontHandler;
const config = require('./config/config');
const database = require('./config/database.config');
database(config['development']);

const server = http.createServer(frontHandler);
if (server.listen(port)) {
	console.log('http server listening on port ' + port + '...');
} else {
	console.log('http server cannot start on port ' + port);
}

//const mongoose = require('mongoose');
//mongoose.connect('mongodb://localhost:27017/m')
//const tSchema = mongoose.Schema({
//		name: {type: mongoose.Schema.Types.String}, 
//		age: {type: mongoose.Schema.Types.String} 
//	});
//let M = mongoose.model('M', tSchema);
//
////let s = new M({name:'Pesho'})
////s.save();
//
//M.create({name:'Pesho'}).then(function(m) {
//	M.find().then(function(res) {
//		for (let r of res) {
//			console.log(r.name);
//		}
//	})
//	console.log(m);
//})