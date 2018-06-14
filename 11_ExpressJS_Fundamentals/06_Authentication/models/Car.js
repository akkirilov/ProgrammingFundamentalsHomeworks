const mongoose = require('mongoose');

const schema = mongoose.Schema({
	make: { type: mongoose.Schema.Types.String },
	model: { type: mongoose.Schema.Types.String },
	color: { type: mongoose.Schema.Types.String },
	imageUrl: { type: mongoose.Schema.Types.String },
	rented : { type: mongoose.Schema.Types.Number }
});

module.exports = mongoose.model('Car', schema);
