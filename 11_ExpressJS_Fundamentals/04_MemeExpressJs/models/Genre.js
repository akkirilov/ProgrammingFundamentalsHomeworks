const mongoose = require('mongoose');

const schema = mongoose.Schema({
	name: { type: mongoose.Schema.Types.String },
	memes: [{ type: mongoose.Schema.Types.ObjectId, ref: 'Meme' }]
});

module.exports = mongoose.model('Genre', schema);