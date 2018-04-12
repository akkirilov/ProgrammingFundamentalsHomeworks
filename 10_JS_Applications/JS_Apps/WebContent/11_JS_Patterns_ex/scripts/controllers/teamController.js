let teamController = (function() {
	
	function getTeamCatalog(ctx) {
		if (!userController.isLoggedIn()) {
			ctx.redirect('#/login');
			return;
		}
		ctx.hasNoTeam = userController.hasNoTeam();
		ctx.loggedIn = userController.isLoggedIn();
		ctx.username = userController.getUsername();
		requester.get('appdata', 'teams', 'Kinvey')
		.then(function(res) {
			ctx.teams = res;
			ctx.hasTeam = userController.hasUserTeam();
			ctx.loadPartials({
				header: 'templates/common/header.hbs',
				team: 'templates/catalog/team.hbs',
				footer: 'templates/common/footer.hbs',
			}).then(function() {
				this.partial('templates/catalog/teamCatalog.hbs');
			});
		}).catch(function(err) {
			infoService.handleAjaxError(err);
		});
	}
	
	function getTeamDetails(ctx) {
		if (!userController.isLoggedIn()) {
			ctx.redirect('#/login');
			return;
		}
		ctx.hasNoTeam = userController.hasNoTeam();
		ctx.loggedIn = userController.isLoggedIn();
		ctx.username = userController.getUsername();
		let id = ctx.params.id.substr(1);
		let endPoint = `teams?query={"_id":"${id}"}`;
		requester.get('appdata', endPoint, 'Kinvey')
		.then(function(teamDetails) {
			ctx.name = teamDetails[0].name;
			ctx.comment = teamDetails[0].comment;
			ctx.teamId = id;
			ctx.isAuthor = teamDetails[0]._acl.creator === userController.getUserId();
			endPoint = `?query={"teamId":"${id}"}`;
			requester.get('user', endPoint, 'Kinvey')
			.then(function(members) {
				let userId = userController.getUserId();
				ctx.members = members;
				ctx.isOnTeam = members.filter(e => e._id === userId).length > 0;
				ctx.loadPartials({
					header: 'templates/common/header.hbs',
					teamControls: 'templates/catalog/teamControls.hbs',
					teamMember: 'templates/catalog/teamMember.hbs',
					footer: 'templates/common/footer.hbs',
				}).then(function() {
					this.partial('templates/catalog/details.hbs');
				});
			}).catch(function(err) {
				infoService.handleAjaxError(err);
			});
		}).catch(function(err) {
			infoService.handleAjaxError(err);
		});
	}
	
	function getCreateTeam(ctx) {
		if (!(userController.isLoggedIn())) {
			ctx.redirect('#/login');
			return;
		}
		ctx.username = userController.getUsername();
		ctx.loggedIn = userController.isLoggedIn();
		ctx.loadPartials({
			header: 'templates/common/header.hbs',
			createForm: 'templates/create/createForm.hbs',
			footer: 'templates/common/footer.hbs',
		}).then(function() {
			this.partial('templates/create/createPage.hbs');
		});
	}
	
	function postCreateTeam(ctx) {
		if (!(userController.isLoggedIn())) {
			ctx.redirect('#/login');
			return;
		}
		let name = ctx.params.name;
		let comment = ctx.params.comment;
		let data = { name, comment }; 
		requester.post('appdata', 'teams', 'Kinvey', data)
		.then(function(res) {
			let id = res._id;
			userController.registerInTeam(id)
			.then(function(res) {
				auth.saveSession(res);
				ctx.redirect('#/catalog/:' + id);
			}).catch(function(err) {
				infoService.handleAjaxError(err);
			});
		}).catch(function(err) {
			infoService.handleAjaxError(err);
		});
	}
	
	function getJoinTeam(ctx) {
		if (!(userController.isLoggedIn())) {
			ctx.redirect('#/login');
			return;
		}
		let id = ctx.params.id.substr(1);
		userController.registerInTeam(id)
		.then(function(res) {
			sessionStorage.setItem('teamId', id);
			ctx.redirect('#/catalog/:' + id);
		});
		
	}
	
	function getEditTeam(ctx) {
		if (!(userController.isLoggedIn())) {
			ctx.redirect('#/login');
			return;
		}
		ctx.username = userController.getUsername();
		ctx.loggedIn = userController.isLoggedIn();
		let id = ctx.params.id.substr(1);
		let endPoint = `teams?query={"_id":"${id}"}`;
		requester.get('appdata', endPoint, 'Kinvey')
		.then(function(teamDetails) {
			ctx.name = teamDetails[0].name;
			ctx.comment = teamDetails[0].comment;
			ctx.teamId = id;
			ctx.loadPartials({
				header: 'templates/common/header.hbs',
				editForm: 'templates/edit/editForm.hbs',
				footer: 'templates/common/footer.hbs',
			}).then(function() {
				this.partial('templates/edit/editPage.hbs');
			});
		}).catch(function(err) {
			infoService.handleAjaxError(err);
		});
	}
	
	function postEditTeam(ctx) {
		if (!(userController.isLoggedIn())) {
			ctx.redirect('#/login');
			return;
		}
		let id = ctx.params.id.substr(1);
		let name = ctx.params.name;
		let comment = ctx.params.comment;
		let data = { name, comment }; 
		let endPoint = 'teams/' + id;
		requester.update('appdata', endPoint, 'Kinvey', data)
		.then(function(res) {
			ctx.redirect('#/catalog/:' + id);
		}).catch(function(err) {
			infoService.handleAjaxError(err);
		});
	}
	
	function getLeaveTeam(ctx) {
		if (!(userController.isLoggedIn())) {
			ctx.redirect('#/login');
			return;
		}
		
		let id = 'undefined';
		userController.registerInTeam(id)
		.then(function(res) {
			sessionStorage.setItem('teamId', id);
			ctx.redirect('#/home');
		});
	}
	
	return {
		getTeamCatalog,
		getTeamDetails,
		getCreateTeam,
		postCreateTeam,
		getJoinTeam,
		getLeaveTeam,
		getEditTeam,
		postEditTeam
	}
})()