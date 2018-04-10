$(document).on({
    ajaxStart: function() { $("#loadingBox").show() },
    ajaxStop: function() { $("#loadingBox").hide() }
});
$(() => {

	let app = Sammy('#main', function() {

		this.use('Handlebars', 'hbs');
		
		this.get('index.html', (ctx) => {
			if (!authService.isAuth()) {
				ctx.redirect('#/login');
				return;
			}
			ctx.isAuth = authService.isAuth();
			ctx.username = sessionStorage.getItem('username');
			ctx.loadPartials({
				nav: './templates/nav.hbs',
				header: './templates/header.hbs',
				footer: './templates/footer.hbs',
			}).then(function() {
				this.partial('./templates/home.hbs');
			});
		});
		
		this.get('#/login', (ctx) => {
			if (authService.isAuth()) {
				ctx.redirect('#/contacts');
				return;
			}
			ctx.username = 'Anonimous';
			ctx.isAuth = authService.isAuth();
			ctx.loadPartials({
				nav: './templates/nav.hbs',
				header: './templates/header.hbs',
				footer: './templates/footer.hbs',
			}).then(function() {
				this.partial('./templates/login.hbs');
			});
		});
		
		this.post('#/login', (ctx) => {
			if (authService.isAuth()) {
				ctx.redirect('#/contacts');
				return;
			}
			let username = ctx.params.username;
			let password = ctx.params.password;
			authService.login(username, password)
			.then(function(res) {
				authService.saveSession(res);
				infoService.showInfo('Login success!');
				ctx.redirect('#/contacts');
			}).catch(function(err) {
				infoService.handleAjaxError(err);
			});
		});
		
		this.get('#/register', (ctx) => {
			let username = 'Anonimous';
			if (authService.isAuth()) {
				ctx.redirect('#/contacts');
				return;
			}
			ctx.username = 'Anonimous';
			ctx.isAuth = authService.isAuth();
			ctx.loadPartials({
				nav: './templates/nav.hbs',
				header: './templates/header.hbs',
				footer: './templates/footer.hbs',
			}).then(function() {
				this.partial('./templates/register.hbs');
			});
		});
		
		this.post('#/register', (ctx) => {
			if (authService.isAuth()) {
				this.redirect('#contacts');
			}
			let username = ctx.params.username;
			let password = ctx.params.password;
			let passwordConfirm = ctx.params.passwordConfirm;

			if (password !== passwordConfirm) {
				infoService.showError('Confirmed password is different!');
				return;
			}
			authService.register(username, password)
			.then(function(res) {
				authService.saveSession(res);
				infoService.showInfo('Register success!');
				ctx.redirect('#/contacts');
			}).catch(function(err) {
				infoService.handleAjaxError(err);
			});
		});
		
		this.get('#/logout', (ctx) => {
			if (!authService.isAuth()) {
				ctx.redirect('#/login');
				return;
			}
			authService.logout()
			.then(function(res) {
				sessionStorage.clear();
				infoService.showInfo('Logout success!');
				ctx.redirect('#/login');
			}).catch(function(err) {
				infoService.handleAjaxError(err);
			});
		});
		
		this.get('#/contacts', (ctx) => {
			if (!authService.isAuth()) {
				ctx.redirect('#/login');
				return;
			}
			$.get('./data.json')
			.then(function(contacts){
				function viewDetails() {
					$('#list .content .contact').removeClass('active');
					let el = $(this);
					el.addClass('active');
					let id = el.attr('data-id');
					let htmlDetails = `
					    <h1>Details</h1>
					    <div class="content">
					        <div class="info">
					            <div class="col">
					                <span class="avatar">&#9787;</span>
					            </div>
					            <div class="col">
					                <span class="name">${contacts[id].firstName}</span>
					                <span class="name">${contacts[id].lastName}</span>
					            </div>
					        </div>
					        <div class="info">
					            <span class="info-line">&phone; ${contacts[id].phone}</span>
					            <span class="info-line">&#9993; ${contacts[id].email}</span>
					        </div>
					    </div>`;
					$('#details').empty().append(htmlDetails);
				}
				ctx.contacts = contacts;
				ctx.isAuth = authService.isAuth();
				ctx.username = sessionStorage.getItem('username');
				ctx.loadPartials({
					nav: './templates/nav.hbs',
					header: './templates/header.hbs',
					footer: './templates/footer.hbs',
					contactDetails: './templates/contactDetails.hbs'
				}).then(function() {
					this.partial('./templates/contactList.hbs').then(function() {
						$('#list').find('.contact').on('click', viewDetails)
					});
					
				});
			}).catch(function(err) {
				infoService.handleAjaxError(err);
			});
		});
		
	});
	
	app.run();
});

