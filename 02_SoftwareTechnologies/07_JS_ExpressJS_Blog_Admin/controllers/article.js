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
    },

    editGet: (req, res) => {
        let id = req.params.id;
        Article.findById(id).then(article => {
            res.render('article/edit', article);
        })
    },

    editPost: (req, res) => {
        let id = req.params.id;
        let editArgs = req.body;
        let errorMsg = '';
        if(!req.isAuthenticated()) {
            errorMsg = 'Login first!';
        } else if(!editArgs.title) {
            errorMsg = 'Enter title!';
        } else if(!editArgs.content) {
            errorMsg = 'Enter content!';
        }

        if(errorMsg) {
            editArgs.error=errorMsg;
            //res.status(301).redirect(`/article/details/${id}`);
            res.redirect(`/article/details/${id}`);
            return;
        }

        Article.update({_id:id}, {$set: {title: editArgs.title, content: editArgs.content}}).then(article => {
            res.redirect(`/article/details/${id}`);
        });
    },

    deleteGet: (req, res) => {
        if(!req.user) {
            res.redirect(`/`);
            return;
        }

        let id = req.params.id;
        Article.findById(id).then(article => {
            res.render(`article/delete`, article);
        })
    },

    deletePost: (req, res) => {
        let id = req.params.id;
        let deleteArgs = req.body;
        if(!req.isAuthenticated()) {
            res.redirect(`/article/details/${id}`, {error: errorMsg});
        }

        Article.findOneAndRemove({_id:id}).populate('author').then(article => {
            let author = article.author;
            let index = author.articles.indexOf(article.id);

            if(index < 0){
                let errorMsg = 'Article was not found for that user!';
                res.render('article/delete', {error: errorMsg});
            } else {
                author.articles.splice(index, 1);
                author.save().then((user) => {
                    res.redirect('/');
                });
            }
        });
    }
};