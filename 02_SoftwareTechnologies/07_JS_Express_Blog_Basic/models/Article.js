const mongoose = require('mongoose');

let articleSchema = mongoose.Schema({
    title: {type: String, required: true},
    content: {type: String, required: true},
    date: {type: Date, default: Date.now()},
    author: {type: mongoose.Schema.Types.ObjectId, required: true, ref: 'User'}
});

const Article = mongoose.model('Article', articleSchema);

module.exports = Article;