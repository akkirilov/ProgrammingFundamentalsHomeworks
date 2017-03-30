const mongoose = require('mongoose').model('Article');
const Article = mongoose.model('Article');
require('./../models/User');
require('./../models/Article');

module.exports = {
    indexGet:(req, res) => {
        Article.find({}).limit(6).populate('author').then(articles => {
            res.render('home/index', {articles: articles});
        })
    }
};