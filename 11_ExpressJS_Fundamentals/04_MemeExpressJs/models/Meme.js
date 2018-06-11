const mongoose = require('mongoose');

const schema = mongoose.Schema({
	title: { type: mongoose.Schema.Types.String },
	memeSrc: { type: mongoose.Schema.Types.String, default: '/images/memeStorage/default.jpeg' },
    description: { type: mongoose.Schema.Types.String },
    privacy: { type: mongoose.Schema.Types.Boolean, default: false },
    genre: { type: mongoose.Schema.Types.ObjectId, ref: 'Genre' },
    dateStamp: { type: mongoose.Schema.Types.Date, default: Date.now }
});

schema.path('description').validate(function(descr) {
	if (this.description == '') {
		this.description = 'No description';
	}
});

module.exports = mongoose.model('Meme', schema);
