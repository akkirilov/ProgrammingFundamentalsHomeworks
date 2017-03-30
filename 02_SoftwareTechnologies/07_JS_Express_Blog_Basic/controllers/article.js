const Article = require('mongoose').model('Article');

module.exports = {
    createGet:(req, res) => {
        res.render('article/create')
    },

    createPost:(req, res) => {
        let createArgs = req.body;
        let errorMsg = '';
        if(!req.isAuthenticated()) {
            errorMsg = 'Login first!';
        } else if(!createArgs.title) {
            errorMsg = 'Enter title!';
        } else if(!createArgs.content) {
            errorMsg = 'Enter content!';
        }

        if(errorMsg) {
            res.render('article/create', {error: errorMsg});
            return;
        }

        createArgs.author = req.user.id;
        Article.create(createArgs).then(article => {
            req.user.articles.push(article.id);
            req.user.save(err => {
                if(err) {
                    res.redirect('/', {error: err.message})
                } else {
                    res.redirect('/');
                }
            })
        })
    },

    detailsGet: (req, res) => {
        let id = req.params.id;

        Article.findById(id).then(article => {
            res.render('article/details', article);
        })
    }
};