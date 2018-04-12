$(document).on({
    ajaxStart: function() { $("#loadingBox").show() },
    ajaxStop: function() { $("#loadingBox").hide() }
});
$(() => {
	console.log($('#main'))
    const app = Sammy('#main', function () {
    	
    	this.use('Handlebars', 'hbs');

    	this.get('index.html', homeController.getHome);
    	this.get('#/home', homeController.getHome);
    	this.get('#/about', homeController.getAbout);
    	
    	this.get('#/login', userController.getLogin);
    	this.post('#/login', userController.postLogin);
    	
    	this.get('#/logout', userController.getLogout);
    	
    	this.get('#/register', userController.getRegister);
    	this.post('#/register', userController.postRegister);
    	
    	this.get('#/catalog', teamController.getTeamCatalog);
    	this.get('#/catalog/:id', teamController.getTeamDetails);
    	this.get('#/edit/:id', teamController.getEditTeam);
    	this.post('#/edit/:id', teamController.postEditTeam);
    	
    	this.get('#/create', teamController.getCreateTeam);
    	this.post('#/create', teamController.postCreateTeam);
    	
    	
    });

    app.run();
});