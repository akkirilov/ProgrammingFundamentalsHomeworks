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
    	
    	
    });

    app.run();
});