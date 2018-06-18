const mongoose = require('mongoose');

const articleSchema = mongoose.Schema({
	title : { type: mongoose.Schema.Types.String, required: true },
	isLocked: { type: mongoose.Schema.Types.Boolean, required: true, default: false },
	creationDate: { type: mongoose.Schema.Types.Date, default: Date.now },
	versions: [{ type: mongoose.Schema.Types.ObjectId, ref: 'Version' }]
});

let Article = mongoose.model('Article', articleSchema);

module.exports = Article;
