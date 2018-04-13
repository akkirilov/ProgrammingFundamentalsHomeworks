$(document).on({
    ajaxStart: function() { $("#loadingBox").show() },
    ajaxStop: function() { $("#loadingBox").hide() }
});
$(() => {
	console.log($('#container'))
    const app = Sammy('#container', function () {
    	
    	this.use('Handlebars', 'hbs');

    	this.get('index.html', homeController.getHome);
    	this.get('#/home', homeController.getHome);
    	
    	this.post('#/register', userController.postRegister);
    	this.post('#/login', userController.postLogin);
    	this.get('#/logout', userController.getLogout);
    	
    	this.get('#/posts', postController.getPosts);
    	this.get('#/myPosts', postController.getMyPosts);
    	
    	this.get('#/submit', postController.getCreatePost);
    	this.post('#/submit', postController.postCreatePost);
    	
    	this.get('#/edit/:id', postController.getEditPost);
    	this.post('#/edit/:id', postController.postEditPost);
    	
    	this.get('#/delete/:id', postController.getDeletePost);
    	
    	this.get('#/details/:id', postController.getPostDetails);
    	
    	this.post('#/addComment/:id', commentController.addComment);
    	this.get('#/deleteComment/:id', commentController.deleteComment);
    	
    });

    app.run();
});