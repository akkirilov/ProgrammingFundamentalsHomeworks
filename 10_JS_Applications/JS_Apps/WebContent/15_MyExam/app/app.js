$(document).on({
    ajaxStart: function() { $("#loadingBox").show() },
    ajaxStop: function() { $("#loadingBox").hide() }
});
$(() => {
    const app = Sammy('#container', function () {
    	
    	this.use('Handlebars', 'hbs');

    	this.get('index.html', homeController.getHome);
    	this.get('#/home', homeController.getHome);
    	
    	this.post('#/register', userController.register);
    	this.post('#/login', userController.login);
    	this.get('#/logout', userController.logout);
    	
    	this.get('#/activeReceipt', receiptController.getActiveReceipt);
    	
    	this.post('#/addProduct/:receiptId', productController.addProduct);
    	this.get('#/removeProduct/:productId', productController.deleteProduct);
    	
    	this.post('#/checkout/:receiptId', receiptController.checkoutReceipt);
    	this.get('#/myReceipts', receiptController.getMyReceipts);
    	
    	this.get('#/details/:receiptId', receiptController.getDetails);
    	
    });

    app.run();
});