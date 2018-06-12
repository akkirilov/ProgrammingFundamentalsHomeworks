const mongoose = require('mongoose');

const schema = mongoose.Schema({
	username: { type: mongoose.Schema.Types.String, required: true },
	salt: { type: mongoose.Schema.Types.String, required: true },
	password: { type: mongoose.Schema.Types.String, required: true }
});

module.exports = mongoose.model('User', schema);
