const BASE_URL = 'https://baas.kinvey.com/'
const APP_KEY = 'kid_S1pXmP69z'
const APP_SECRET = '64b417ca8a264ca99fbe89c02e27ddec'
const AUTH_HEADERS = {'Authorization': "Basic " + btoa(APP_KEY + ":" + APP_SECRET)}
const BOOKS_PER_PAGE = 10

function loginUser() {
	let username = $('#formLogin input[name=username]').val();
	let password = $('#formLogin input[name=passwd]').val();
	let postData = {username, password};
	$.ajax({
		method: "POST",
		url: BASE_URL + 'user/' + APP_KEY + '/login',
		headers: AUTH_HEADERS,
		data: postData
	}).then(function(res) {
		signInUser(res, 'Login successful.');
	}).catch(function(err) {
		handleAjaxError(err);
	});
}

function registerUser() {
	let username = $('#formRegister input[name=username]').val();
	let password = $('#formRegister input[name=passwd]').val();
	let postData = {username, password};
	$.ajax({
		method: "POST",
		url: BASE_URL + 'user/' + APP_KEY + '/',
		headers: AUTH_HEADERS,
		data: postData
	}).then(function(res) {
		signInUser(res, 'Registration successful.');
	}).catch(function(err) {
		handleAjaxError(err);
	});
}

function listBooks() {
	showView('viewBooks');
	$.ajax({
		method: "GET",
		url: BASE_URL + 'appdata/' + APP_KEY + '/books',
		headers: {'Authorization': "Kinvey " + sessionStorage.getItem('authToken')},
	}).then(function(res) {
		displayPaginationAndBooks(res.reverse());
	}).catch(function(err) {
		handleAjaxError(err);
	});
}

function createBook() {
    let author = $('#formCreateBook input[name=author]').val();
    let title = $('#formCreateBook input[name=title]').val();
    let description = $('#formCreateBook textarea[name=description]').val();
    let postData = {author, title, description};
    $.ajax({
		method: "POST",
		url: BASE_URL + 'appdata/' + APP_KEY + '/books',
		headers: {'Authorization': "Kinvey " + sessionStorage.getItem('authToken')},
		data: postData
	}).then(function(res) {
		listBooks();
		showInfo('Book created.');
	}).catch(function(err) {
		handleAjaxError(err);
	});
}

function deleteBook(book) {
    let id = book._id;
    $.ajax({
	    	method: "DELETE",
	    	url: BASE_URL + 'appdata/' + APP_KEY + '/books/' + id,
	    	headers: {'Authorization': "Kinvey " + sessionStorage.getItem('authToken')}
	    }).then(function(res) {
	    	listBooks();
	    	showInfo('Book deleted.');
	    }).catch(function(err) {
	    	handleAjaxError(err);
	    });
}

function loadBookForEdit(book) {
	showView('viewEditBook');
	$('#formEditBook input[name=id]').val(book._id);
	$('#formEditBook input[name=author]').val(book.author);
    $('#formEditBook input[name=title]').val(book.title);
    $('#formEditBook textarea[name=description]').text(book.description);
}

function editBook() {
	let id = $('#formEditBook input[name=id]').val();
	let author = $('#formEditBook input[name=author]').val();
    let title = $('#formEditBook input[name=title]').val();
    let description = $('#formEditBook textarea[name=description]').val();
    let postData = {author, title, description};
	$.ajax({
	    	method: "PUT",
	    	url: BASE_URL + 'appdata/' + APP_KEY + '/books/' + id,
	    	headers: {'Authorization': "Kinvey " + sessionStorage.getItem('authToken')},
	    	data: postData
	    }).then(function(res) {
	    	listBooks();
	    	showInfo('Book edited.');
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
	showHomeView();
	showHideMenuLinks();
	$('#loggedInUser').text('');
    showInfo('Logout successful.');
}

function signInUser(res, message) {
	saveAuthInSession(res);
	showHomeView();
	showHideMenuLinks();
	showInfo(message);
}

function displayPaginationAndBooks(books) {
    let pagination = $('#pagination-demo')
    if(pagination.data("twbs-pagination")){
        pagination.twbsPagination('destroy')
    }
    pagination.twbsPagination({
        totalPages: Math.ceil(books.length / BOOKS_PER_PAGE),
        visiblePages: 5,
        next: 'Next',
        prev: 'Prev',
        onPageClick: function (event, page) {
            $('#books table tr:not(:first-child)').each((i, e) => e.remove());
            let startBook = (page - 1) * BOOKS_PER_PAGE
            let endBook = Math.min(startBook + BOOKS_PER_PAGE, books.length)
            $(`a:contains(${page})`).addClass('active')
            for (let i = startBook; i < endBook; i++) {
            	let tr = $('<tr>')
    			.append(`<td>${books[i].title}</td><td>${books[i].author}</td><td>${books[i].description}</td>`);
    			if (books[i]._acl.creator === sessionStorage.getItem("userId")) {
					tr
					.append($('<td>')
						.append(
							$('<a>')
							.attr('href', '#')
							.text('[Delete]')
							.on('click', function() {
								deleteBook(books[i]);
							})
						).append($('<a>')
			    			.attr('href', '#')
			    	   		.text('[Edit]')
			    	   		.on('click', function() {
			    	   			loadBookForEdit(books[i]);
			    			})
			   	    	)
			   	    );
				} else {
					tr.append($('<td>'));
				}
            	$('#books table').append(tr);
            }
        }
    })
}

function handleAjaxError(response) {
    let errorMsg = JSON.stringify(response)
    if (response.readyState === 0)
        errorMsg = "Cannot connect due to network error."
    if (response.responseJSON && response.responseJSON.description)
        errorMsg = response.responseJSON.description
    showError(errorMsg)
}