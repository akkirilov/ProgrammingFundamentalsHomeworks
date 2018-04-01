const BASE_URL = 'https://baas.kinvey.com/';
const APP_KEY = 'kid_rJBIFIR5G';
const APP_SECRET = '9e4d6bf957ba4fb4b63e0769e61ed1e2';
const AUTH_HEADERS = {'Authorization': "Basic " + btoa(APP_KEY + ":" + APP_SECRET)};

function loginUser() {
	let usernameInput = $('#formLogin input[name=username]');
	let passwordInput = $('#formLogin input[name=passwd]');
	let username = usernameInput.val();
	let password = passwordInput.val();
	let postData = {username, password};
	$.ajax({
		method: "POST",
		url: BASE_URL + 'user/' + APP_KEY + '/login',
		headers: AUTH_HEADERS,
		data: postData
	}).then(function(res) {
		usernameInput.val('');
		passwordInput.val('');
		signInUser(res, 'Login successful.');
	}).catch(function(err) {
		handleAjaxError(err);
	});
}

function saveAuthInSession(userInfo) {
	sessionStorage.setItem("username", userInfo.username);
	sessionStorage.setItem("userId", userInfo._id);
	sessionStorage.setItem("authToken", userInfo._kmd.authtoken);
}

function logoutUser() {
	sessionStorage.removeItem('username');
	sessionStorage.removeItem('userId');
	sessionStorage.removeItem('authToken');
	$('#loggedInUser').text('');
	showView('viewHome');
	showHideMenuLinks();
    showInfo('Logout successful.');
}

function registerUser() {
	let usernameInput = $('#formLogin input[name=username]');
	let passwordInput = $('#formLogin input[name=passwd]');
	let username = usernameInput.val();
	let password = passwordInput.val();
	let postData = {username, password};
	$.ajax({
		method: "POST",
		url: BASE_URL + 'user/' + APP_KEY + '/',
		headers: AUTH_HEADERS,
		data: postData
	}).then(function(res) {
		usernameInput.val('');
		passwordInput.val('');
		signInUser(res, 'Registration successful.');
	}).catch(function(err) {
		handleAjaxError(err);
	});
}

function signInUser(res, message) {
	saveAuthInSession(res);
	showView('viewHome');
	showHideMenuLinks();
	showInfo(message);
}

function listAds() {
	showView('viewAds');
	$('#ads table tr:not(:first-child)').each((i, e) => e.remove());
	$.ajax({
		method: "GET",
		url: BASE_URL + 'appdata/' + APP_KEY + '/ads',
		headers: {'Authorization': "Kinvey " + sessionStorage.getItem('authToken')},
	}).then(function(res) {
		displayAds(res.reverse());
	}).catch(function(err) {
		handleAjaxError(err);
	});
}

function displayAds(ads) {
	for (let i = 0; i < ads.length; i++) {
		let tr = $('<tr>')
		.append(`<td>${ads[i].title}</td><td>${ads[i].publisher}</td><td>${ads[i].description}</td><td>${ads[i].price}</td><td>${ads[i].datePublished}</td>`);
		if (ads[i]._acl.creator === sessionStorage.getItem("userId")) {
			tr
			.append($('<td>')
					.append($('<a>')
			    	.attr('href', '#')
			    	.text('[Edit]')
			    	.on('click', function() {
			    		loadAdForEdit(ads[i]);
			    	})
			   	).append(
					$('<a>')
					.attr('href', '#')
					.text('[Delete]')
					.on('click', function() {
						deleteAd(ads[i]);
					})
				)
	   	    );
		}
		$('#ads table').append(tr);
	}
}

function createAd() {
    let title = $('#formCreateAd input[name=title]').val();
    let description = $('#formCreateAd textarea[name=description]').val();
    let datePublished = $('#formCreateAd input[name=datePublished]').val();
    let price = Number($('#formCreateAd input[name=price]').val());
    let publisher = sessionStorage.getItem('username');
    let postData = {price, title, description, datePublished, publisher};
    $.ajax({
		method: "POST",
		url: BASE_URL + 'appdata/' + APP_KEY + '/ads',
		headers: {'Authorization': "Kinvey " + sessionStorage.getItem('authToken')},
		data: postData
	}).then(function(res) {
		listAds();
		showInfo('Book created.');
	}).catch(function(err) {
		handleAjaxError(err);
	});
}

function deleteAd(ad) {
    let id = ad._id;
    $.ajax({
	    	method: "DELETE",
	    	url: BASE_URL + 'appdata/' + APP_KEY + '/ads/' + id,
	    	headers: {'Authorization': "Kinvey " + sessionStorage.getItem('authToken')}
	    }).then(function(res) {
	    	listAds();
	    	showInfo('Ad deleted.');
	    }).catch(function(err) {
	    	handleAjaxError(err);
	    });
}

function loadAdForEdit(ad) {
	showView('viewEditAd');
	$('#formEditAd input[name=publisher]').val(ad.publisher);
	$('#formEditAd input[name=id]').val(ad._id);
	$('#formEditAd input[name=price]').val(ad.price);
    $('#formEditAd input[name=title]').val(ad.title);
    $('#formEditAd input[name=datePublished]').val(ad.datePublished);
    $('#formEditAd textarea[name=description]').text(ad.description);
}

function editAd() {
	let publisher = $('#formEditAd input[name=publisher]').val();
	let id = $('#formEditAd input[name=id]').val();
    let title = $('#formEditAd input[name=title]').val();
    let description = $('#formEditAd textarea[name=description]').val();
    let datePublished = $('#formEditAd input[name=datePublished]').val();
    let price = Number($('#formEditAd input[name=price]').val());
    let postData = {price, title, description, datePublished, publisher};
	$.ajax({
	    	method: "PUT",
	    	url: BASE_URL + 'appdata/' + APP_KEY + '/ads/' + id,
	    	headers: {'Authorization': "Kinvey " + sessionStorage.getItem('authToken')},
	    	data: postData
	    }).then(function(res) {
	    	listAds();
	    	showInfo('Ad edited.');
	    }).catch(function(err) {
	    	handleAjaxError(err);
	    });
}

function handleAjaxError(response) {
    let errorMsg = JSON.stringify(response)
    if (response.readyState === 0)
        errorMsg = "Cannot connect due to network error."
    if (response.responseJSON && response.responseJSON.description)
        errorMsg = response.responseJSON.description
    showError(errorMsg)
}

