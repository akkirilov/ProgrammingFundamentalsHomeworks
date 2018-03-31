// 01. Forecaster
function forecaster() {
	const SYMBOLS = {
			'Sunny': '&#x2600;',
			'Partly sunny': '&#x26C5',
			'Overcast': '&#x2601;',
			'Rain': '&#x2614;',
			'Degrees': '&#176;'
	};
	let forecast = $('#forecast');
	$('#submit').on('click', showData);
	function showData() {
		forecast.css('display', 'block');
		$.ajax({
			method: "GET",
			url: 'https://judgetests.firebaseio.com/locations.json'
		}).then(function(res) {
			let location = $('#location').val();
			let code;
			for (let r of res) {
				if (r !== null && r.name === location) {
					code = r.code; 
				}
			}
			if (code === undefined) {
				throw new Error();
			}
			$.ajax({
				method: "GET",
				url: 'https://judgetests.firebaseio.com/forecast/today/' + code + '.json'
			}).then(function(res) {
				$('#current')
					.append($(`<span class="condition symbol">${SYMBOLS[res.forecast.condition]}</span>`))
					.append($(`<span class="condition"></span>`)
						.append($(`<span class="forecast-data">${res.name}</span>`))
						.append($(`<span class="forecast-data">${res.forecast.low}${SYMBOLS['Degrees']}/${res.forecast.high}${SYMBOLS['Degrees']}</span>`))
						.append($(`<span class="forecast-data">${res.forecast.condition}</span>`))
					);
				$.ajax({
					method: "GET",
					url: 'https://judgetests.firebaseio.com/forecast/upcoming/' + code + '.json'
				}).then(function(res) {
					let upcoming = $('#upcoming');
					for (let r of res.forecast) {
						upcoming
							.append($(`<span class="upcoming"></span>`)
								.append($(`<span class="symbol">${SYMBOLS[r.condition]}</span>`))
								.append($(`<span class="forecast-data">${r.low}${SYMBOLS['Degrees']}/${r.high}${SYMBOLS['Degrees']}</span>`))
								.append($(`<span class="forecast-data">${r.condition}</span>`))
							);
					}
				});
			});
		}).catch(function(err) {
			forecast.append($(`<div>Error</div>`));
		});
	}
}

// 02. Fisher Game
function fisherGame() {
	const URL = 'https://baas.kinvey.com/appdata/kid_ByUU-dzqz/biggestCatches';
	const AUTH = btoa('guest' + ':' + 'guest');
	let catches = $('#catches');
	$('button.update').on('click', updateF);
	$('button.delete').on('click', deleteF);	
	$('button.load').on('click', loadF);
	$('button.add').on('click', addF);
	function updateF() {
		let capture = $(this).parent();
		let id = capture.attr('data-id');
		let postData = {};
		postData.angler = capture.find('.angler').val();
		postData.weight = Number(capture.find('.weight').val());
		postData.species = capture.find('.species').val();
		postData.location = capture.find('.location').val();
		postData.bait = capture.find('.bait').val();
		postData.captureTime = capture.find('.captureTime').val();
		$.ajax({
			method: "PUT",
			url: URL + '/' + id,
			data: JSON.stringify(postData),
			headers: { "Authorization": "Basic " + AUTH, "Content-type": "application/json" }
		}).then(function(res) {

		});
	}
	function deleteF() {
		let capture = $(this).parent(); 
		let id = capture.attr('data-id');
		$.ajax({
			method: "DELETE",
			url: URL + '/' + id,
			headers: { "Authorization": "Basic " + AUTH }
		}).then(function(res) {
			capture.remove();
		});
	}
	function loadF() {
		$.ajax({
			method: "GET",
			url: URL,
			headers: { "Authorization": "Basic " + AUTH }
		}).then(function(res) {
			catches.empty();
			for (let r of res) {
				catches.append($(`<div class="catch" data-id="${r._id}">
		            <label>Angler</label>
		            <input type="text" class="angler" value="${r.angler}"/>
		            <label>Weight</label>
		            <input type="number" class="weight" value="${r.weight}"/>
		            <label>Species</label>
		            <input type="text" class="species" value="${r.species}"/>
		            <label>Location</label>
		            <input type="text" class="location" value="${r.location}"/>
		            <label>Bait</label>
		            <input type="text" class="bait" value="${r.bait}"/>
		            <label>Capture Time</label>
		            <input type="number" class="captureTime" value="${r.captureTime}"/>
					</div>`)
						.append($('<button class="update">Update</button>').on('click', updateF))
						.append($('<button class="delete">Delete</button>').on('click', deleteF))
					);
			}
		}).catch(function(reason) {
			console.log(reason);
		});
	}
	function addF() {
		let capture = $(this).parent();
		let postData = {};
		postData.angler = capture.find('.angler').val();
		postData.weight = Number(capture.find('.weight').val());
		postData.species = capture.find('.species').val();
		postData.location = capture.find('.location').val();
		postData.bait = capture.find('.bait').val();
		postData.captureTime = Number(capture.find('.captureTime').val());
		$.ajax({
			method: "POST",
			url: URL,
			data: JSON.stringify(postData),
			headers: { "Authorization": "Basic " + AUTH, "Content-type": "application/json" }
		}).then(function(res) {
			catches.append($(`<div class="catch" data-id="${res._id}">
		            <label>Angler</label>
		            <input type="text" class="angler" value="${res.angler}"/>
		            <label>Weight</label>
		            <input type="number" class="weight" value="${res.weight}"/>
		            <label>Species</label>
		            <input type="text" class="species" value="${res.species}"/>
		            <label>Location</label>
		            <input type="text" class="location" value="${res.location}"/>
		            <label>Bait</label>
		            <input type="text" class="bait" value="${res.bait}"/>
		            <label>Capture Time</label>
		            <input type="number" class="captureTime" value="${res.captureTime}"/>
					</div>`)
						.append($('<button class="update">Update</button>').on('click', updateF))
						.append($('<button class="delete">Delete</button>').on('click', deleteF))
					);
		});
	}
}

// 03. Create "Books" REST Service
// Kinvey app

// 04. Students
function initStudents() {
	const URL = 'https://baas.kinvey.com/appdata/kid_ByUU-dzqz/students';
	const AUTH = btoa('guest' + ':' + 'guest');
	
	let content = $('#main');
	let createDiv = $('#createDiv');
	let resultDiv = $('#resDiv');
	let tableBody = $('#resultsBody');
	
	refreshStudents();
	
	$('#showRes').on('click', showResults);
	function showResults() {
		clearContent();
		resultDiv.css('display', 'block');
	}
	
	$('#refreshStudentBtn').on('click', refreshStudents);
	function refreshStudents() {
		tableBody.empty();
		$.ajax({
			method: "GET",
			url: URL,
			headers: { "Authorization": "Basic " + AUTH }
		}).then(function(res) {
			res.sort((a, b) => a.id - b.id);
			for (let r of res) {
				attachRow(r);
			}
		});
	}
	
	$('#showCreate').on('click', showCreate);
	function showCreate() {
		clearContent();
		createDiv.css('display', 'block');
	}
	
	$('#createBtn').on('click', create);
	function create() {
		let id = $('#idstudent');
		let firstName = $('#firstName');
		let lastName = $('#lastName');
		let facultyNumber = $('#facultyNumber');
		let grade = $('#grade');
		let postData = {
				id: Number(id.val()),
				firstName: firstName.val(), 
				lastName: lastName.val(), 
				facultyNumber: facultyNumber.val(), 
				grade: Number(grade.val())
			};
		$.ajax({
			method: "POST",
			url: URL,
			data: JSON.stringify(postData),
			headers: { "Authorization": "Basic " + AUTH, "Content-type": "application/json" }
		}).then(function(res) {
			id.val('');
			firstName.val('');
			lastName.val('');
			facultyNumber.val('');
			grade.val('');
			attachRow(res);
			showResults();
		});
	}
	
	function attachRow(data) {
		tableBody.append($(`<tr><td>${data.id}</td><td>${data.firstName}</td><td>${data.lastName}</td><td>${data.facultyNumber}</td><td>${data.grade}</td></tr>`));
	}
	
	function clearContent() {
		content.children().css('display', 'none');
	}
	
}

