let itemController = (function() {
	
	function getCatalog(ctx) {
		let isLoggedIn = userService.isLoggedIn();
		if (!isLoggedIn) {
			ctx.redirect('#/home');
		}
		ctx.isLoggedIn = isLoggedIn;
		ctx.username = userService.getUsername();
		
		itemService.getAllSortedByDate()
		.then(function(data) {
			ctx.data = data;

			ctx.loadPartials({
				header: 'templates/common/header.hbs',
				footer: 'templates/common/footer.hbs'
					
			}).then(function() {
				this.partial('templates/');
			});
		}).catch(function(err) {
			infoService.handleAjaxError(err);
		});
	}
	
	function getMy(ctx) {
		let isLoggedIn = userService.isLoggedIn();
		if (!isLoggedIn) {
			ctx.redirect('#/home');
		}
		ctx.isLoggedIn = isLoggedIn;
		ctx.username = userService.getUsername();
		
		let userId = userService.getUserId();
		itemService.getByCreatorId(userId)
		.then(function(data) {
			ctx.data = data;

			ctx.loadPartials({
				header: 'templates/common/header.hbs',
				footer: 'templates/common/footer.hbs'
					
			}).then(function() {
				this.partial('templates/');
			});
		}).catch(function(err) {
			infoService.handleAjaxError(err);
		});
	}
	
	function getCreate(ctx) {
		let isLoggedIn = userService.isLoggedIn();
		if (!isLoggedIn) {
			ctx.redirect('#/home');
		}
		ctx.isLoggedIn = isLoggedIn;
		ctx.username = userService.getUsername();
		
		ctx.loadPartials({
			header: 'templates/common/header.hbs',
			footer: 'templates/common/footer.hbs'
				
		}).then(function() {
			this.partial('templates/');
		});
	}
	
	function postCreate(ctx) {
		if (!userService.isLoggedIn()) {
			ctx.redirect('#/home');
		}
		
		itemService.create(params)
		.then(function(res) {
			ctx.redirect('#/items');
			infoService.showInfo('Created!');
		}).catch(function(err) {
			infoService.handleAjaxError(err);
		});
	}
	
	function getEdit(ctx) {
		let isLoggedIn = userService.isLoggedIn();
		if (!isLoggedIn) {
			ctx.redirect('#/home');
		}
		ctx.isLoggedIn = isLoggedIn;
		ctx.username = userService.getUsername();
		
		let id = ctx.params.id;
		itemService.getById(id)
		.then(function(data) {
			ctx._id = data[0]._id;
			
			ctx.loadPartials({
				header: 'templates/common/header.hbs',
				footer: 'templates/common/footer.hbs'
					
			}).then(function() {
				this.partial('templates/');
			});
		}).catch(function(err) {
			infoService.handleAjaxError(err);
		});
	}
	
	function postEdit(ctx) {
		if (!userService.isLoggedIn()) {
			ctx.redirect('#/home');
		}
		
		itemService.editById(id, params)
		.then(function(res) {
			ctx.redirect('#/items');
			infoService.showInfo('Edited!');
		}).catch(function(err) {
			infoService.handleAjaxError(err);
		});
	}
	
	function getDelete(ctx) {
		if (!userService.isLoggedIn()) {
			ctx.redirect('#/home');
		}
		
		let id = ctx.params.id;
		itemService.deleteById(id)
		.then(function(res) {
			ctx.redirect('#/items');
			infoService.showInfo('Deleted!');
		}).catch(function(err) {
			infoService.handleAjaxError(err);
		});
	}
	
	function getDetails(ctx) {
		let isLoggedIn = userService.isLoggedIn();
		if (!isLoggedIn) {
			ctx.redirect('#/home');
		}
		ctx.isLoggedIn = isLoggedIn;
		ctx.username = userService.getUsername();
		
		let id = ctx.params.id;
		itemService.getDetails(id)
		.then(function(data) {
			ctx._id = data[0]._id;
			
			ctx.loadPartials({
				header: 'templates/common/header.hbs',
				footer: 'templates/common/footer.hbs'
					
			}).then(function() {
				this.partial('templates/');
			});
		}).catch(function(err) {
			infoService.handleAjaxError(err);
		});
	}
	
	return {
		getCatalog,
		getMy,
		getCreate,
		postCreate,
		getEdit,
		postEdit,
		getDelete,
		getDetails
	}
	
})();
