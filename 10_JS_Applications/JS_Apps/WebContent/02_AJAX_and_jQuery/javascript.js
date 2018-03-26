// 01. XHR
function loadRepos() {
	let xhr = new XMLHttpRequest();
	xhr.onreadystatechange = function() {
		if (this.readyState == 4 && this.status == 200) {
			$('#res').append(this.responseText);
		}
	}
	xhr.open('GET', "https://api.github.com/users/testnakov/repos", true);
	xhr.send();
}

// 02. AJAX Load
function loadTitle() {
	$('#text').load("text.html");
}

// 03. Github Repos
function loadRepos() {
	let username = $('#username').val();
	$.ajax({
		method: "GET",
		url: "https://api.github.com/users/" + username + "/repos",
		success: displayRepos,
		error: displayError
		});
	
	function displayRepos(res) {
		let el = $('#repos');
		el.empty();
		for (let r in res) {
			el.append($(`<li><a href="${res[r].html_url}">${res[r].full_name}</a></li>`));
		}
	}
	
	function displayError(res) {
		$('#repos').empty().append(`<li>Error</li>`);
	}

}

// 04. Phonebook
function initPhonebook() {
	const URL = "https://phonebook-fdc55f.firebaseio.com/phones";
	let name = $('#person');
	let phone = $('#phone');
	
	$('#btnLoad').on('click', function() {
		$.ajax({
			method: "GET",
			url: URL + ".json",
			success: displayPhones,
			error: handleError
		});
	});
	$('#btnCreate').on('click', function() {
		$.ajax({
			method: "POST",
			url: URL + ".json",
			data: JSON.stringify({name:name.val(), phone:phone.val()}),
			success: createPhone,
			error: handleError
		});
	});
	
	function createPhone(res) {
		appendContact(res.name, name.val(), phone.val());
		name.val('');
		phone.val('');
	}
	
	function displayPhones(res) {
		$('#phonebook').empty();
		for (let r in res) {
			if (res[r] != null) {
				appendContact(r, res[r].name, res[r].phone);
			}
		}
	}
	
	function appendContact(id, name, phone) {
		let li = $(`<li>${name} ${phone} </li>`);
		li.append($(`<a href="#">[Delete]</a>`).on('click', function(e) {
			$.ajax({
				method: "DELETE",
				url: URL + "/" + id + ".json",
				success: () => $(e.target).parent().remove(),
				error: handleError
			});
		}));
		$('#phonebook').append(li);
	}
	
	function handleError(res) {
		console.log(res.statusText);
	}
	
}

