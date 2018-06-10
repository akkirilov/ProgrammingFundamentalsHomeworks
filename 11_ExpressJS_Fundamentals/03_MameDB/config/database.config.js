const mongoose = require('mongoose');
mongoose.Promise = global.Promise;

function load(config) {
	return new Promise ((res,rej)=>{
	    console.log('DB loading...')
	    mongoose.connect(config.connectionString);
	    let db = mongoose.connection;
	    db.once('open', function(err) {
	      	if (err) {
	      		console.log(err);
				return;
	      	}
	      	console.log('DataBase ready ...');
	    });
	
//	    require('../models/Meme');
	    
	    res();
	});
}

module.exports = load;