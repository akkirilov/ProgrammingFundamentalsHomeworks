const mongoose = require('mongoose');

const schema = mongoose.Schema({
	username: { type: mongoose.Schema.Types.String },
	password: { type: mongoose.Schema.Types.String },
	role: { type: mongoose.Schema.Types.String },
	salt: { type: mongoose.Schema.Types.String },
	rentedCars: [{ type: mongoose.Schema.Types.ObjectId, ref: 'Car' }],
	imageUrl: { type: mongoose.Schema.Types.String }
});

module.exports = mongoose.model('User', schema);
