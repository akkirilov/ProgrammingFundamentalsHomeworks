$(() => {
    const app = Sammy('#main', function () {
    	
    	this.use('Handlebars', 'hbs');

    	this.get('#/index.html', homeController.getHome);
//    	this.get('#/about', homeController.getAbout);
//    	
//    	this.get('#/login', userController.getLogin);
//    	this.post('#/login', userController.postLogin);
//    	
//    	this.get('#/register', userController.getRegister);
//    	this.post('#/register', userController.postRegister);
    	
    	
    });

    app.run();
});