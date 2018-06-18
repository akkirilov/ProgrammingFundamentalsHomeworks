const mongoose = require('mongoose');

const versionSchema = mongoose.Schema({
	article: { type: mongoose.Schema.Types.ObjectId, ref: 'Article' },
	author:  { type: mongoose.Schema.Types.ObjectId, ref: 'User' },
    content:     { type: mongoose.Schema.Types.String },
    editDate: { type: mongoose.Schema.Types.Date, default: Date.now }
});

let Version = mongoose.model('Version', versionSchema);

module.exports = Version;
