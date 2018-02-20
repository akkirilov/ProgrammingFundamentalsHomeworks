function increment(idAsStr) {
	$(idAsStr)
			.append($('<textarea>')
				.addClass('counter')
				.val(0)
				.attr('disabled', true))
			.append($('<button>')
					.addClass('btn')
					.attr('id', 'incrementBtn')
					.text('Increment')
					.on('click', incrementNumber))
			.append($('<button>')
					.addClass('btn')
					.attr('id', 'addBtn')
					.text('Add')
					.on('click', addNumber))
			.append($('<ul>')
					.addClass('results'));
	
	function addNumber() {
		$('ul.results')
				.append($('<li>')
					.text($('textarea.counter').val()));
	}
	
	function incrementNumber() {
		let el = $('textarea.counter');
		el.val(Number(el.val()) + 1);
	}
}

function timer() {
    let interval;
    let isPaused = true;
    $('#start-timer').on('click', start);
    $('#stop-timer').on('click', pause);
    
    function start() {
    	if (!isPaused) {
			return;
		}
    	isPaused = false;
    	interval = setInterval(function() {
    		let secondsSpan = $('#seconds');
    		let minutesSpan = $('#minutes');
    		let hoursSpan = $('#hours');
    		let seconds = Number(secondsSpan.text());
    		let minutes = Number(minutesSpan.text());
    		let hours = Number(hoursSpan.text());
    		seconds++;
    		if (seconds === 60) {
    			minutes++;
    			seconds = 0;
			}
    		if (minutes === 60) {
    			hours++;
    			minutes = 0;
			}
    		secondsSpan.text(('0' + seconds).slice(-2));
    		minutesSpan.text(('0' + minutes).slice(-2));
    		hoursSpan.text(('0' + hours).slice(-2));
    	}, 1000);
	}
    
    function pause() {
    	clearInterval(interval);
    	isPaused = true;
	}
}

function createBook(selector, title, author, isbn) {
	let bookGenerator = (function () {
		let id = 1;
		return function (selector, title, author, isbn) {
			$(selector)
				.append($('<div>')
					.addClass('book' + id)
					.append($('<p>')
						.addClass('title')
						.text(title))
					.append($('<p>')
						.addClass('author')
						.text(author))
					.append($('<p>')
						.addClass('isbn')
						.text(isbn))
					.append($('<button>')
						.text('Select')
						.on('click', select))
					.append($('<button>')
						.text('Deselect')
						.on('click', deselect))
				);
			return id++;
		}
	})();
	
	bookGenerator(selector, title, author, isbn);
	
	function select() {
		$(this).parent().css('border', '2px solid blue');
	}
	
	function deselect() {
		$(this).parent().css('border', 'none');
	}
}

function validate() {
	$('#submit').on('click', isValid);
	$('#company').on('change', showCompanyInfo);
	
	function isValid(e) {
		e.preventDefault();
		let error = false;
		let username = $('#username');
		if (!(/^[a-zA-Z0-9]{3,20}$/g).test(username.val())) {
			username.css('border-color', 'red');
			error = true;
		} else {
			username.css('border-color', '');
		}
		let email = $('#email');
		if (!(/^.*@.*\..*$/g).test(email.val())) {
			email.css('border-color', 'red');
			error = true;
		} else {
			email.css('border-color', '');
		}
		let passPattern = /^[a-zA-Z0-9_]{5,15}$/;
		let password = $('#password');
		if (!passPattern.test(password.val())) {
			password.css('border-color', 'red');
			error = true;
		} else {
			password.css('border-color', '');
		}
		let confirmPassword = $('#confirm-password');
		if (confirmPassword.val() !== password.val() || !passPattern.test(confirmPassword.val())) {
			password.css('border-color', 'red');
			confirmPassword.css('border-color', 'red');
			error = true;
		} else {
			confirmPassword.css('border-color', '');
		}
		if ($('#company').prop('checked') === true) {
			let companyNumber = $('#companyNumber');
			if (Number(companyNumber.val()) < 1000 || Number(companyNumber.val()) > 9999) {
				companyNumber.css('border-color', 'red');
				error = true;
			} else {
				companyNumber.css('border-color', '');
			}
		}
		if (!error) {
			$('#valid').css('display', 'block');
		} else {
			$('#valid').css('display', 'none');
		}
	}
	
	function showCompanyInfo() {
		if ($('#company').prop('checked') === true) {
			$('#companyInfo').css('display', 'block');
		} else {
			$('#companyInfo').css('display', 'none');
		}
	}
}

function domSearch(selector, isCaseSensitive) {
	$(selector)
		.addClass('items-controls')
			.append($('<div>')
			.addClass('add-controls')
				.append($('<label>')
				.text('Enter text:')
					.append($('<input>'))
				).append($('<a>')
				.addClass('button')
				.prop('href', '#')
				.on('click', addToList)
				.text('Add')
				)
			).append($('<div>')
			.addClass('search-controls')
				.append($('<label>')
				.text('Search:')
					.append($('<input>')
					.on('change', search))
				)
			).append($('<div>')
			.addClass('result-controls')
				.append($('<ul>')
				.addClass('items-list'))
			);
			
	function addToList() {
		let el = $('.add-controls input');
		$('.items-list')
				.append($('<li>')
				.addClass('list-item')
					.append($('<a>')
					.addClass('button')
					.text('X')
					.prop('href', '#')
					.on('click', deleteItem))
				.append('<strong>' + el.val() + '</strong>'));
		el.val('');
	}

	function deleteItem() {
		$(this).parent().remove();
	}
	
	function search(e) {
		let val = $(this).val();
		if (!isCaseSensitive) {
			val = val.toLowerCase();
		} else if (val === '') {
			('.list-item').css('display', 'block');
			return;
		}
		$('.list-item').css('display', 'block').each((i, x) => {
			let el = x.textContent.substr(1);
			if (!isCaseSensitive) {
				el = el.toLowerCase();
			}
			if (!el.includes(val)) {
				$(x).css('display', 'none');
			}
		});
	}
}

function calendar(arr) {
	let monthNames = ["January", "February", "March", "April", "May", "June",
		  "July", "August", "September", "October", "November", "December"];
	let dayNames = ['Mon', 'Tue', 'Wed', 'Thu', 'Fri', 'Sat', 'Sun'];
	let theDate = new Date();
	theDate.setFullYear(arr[2], (arr[1] - 1), arr[0]);
	$('#content')
		.append($('<table>')
		.append($('<caption>')
		.text(monthNames[arr[1] - 1] + ' ' + theDate.getFullYear())));
	let table = $('#content table');
	let tr = $('<tr>');
	let i = 0;
	while (i < 7) {
		tr.append($('<th>').text(dayNames[i]));
		i++;
	}
	table.append(tr);
	let firstDay = new Date();
	firstDay.setFullYear(arr[2], (arr[1] - 1), 1);
	firstDay = firstDay.getDay();
	if (firstDay == 0) {
		firstDay = 7;
	}
	let lastDay = new Date()
	lastDay.setFullYear(arr[2], (arr[1]), 0);
	lastDay = lastDay.getDate();
	tr = $('<tr>');
	i = 1;
	while (i < firstDay) {
		tr.append($('<td>'));
		i++;
	}
	let curDate = 0;
	while (curDate < lastDay) {
		curDate++;
		tr.append($('<td>').text(curDate));
		if (i % 7 === 0) {
			table.append(tr);
			tr = $('<tr>');
		}
		i++;
	}
	if ((i - 1) % 7 !== 0) {
		let endCell = Math.ceil((firstDay + lastDay) / 7) * 7;
		while (i <= endCell) {
			tr.append($('<td>'));
			i++;
			if (i % 7 === 0) {
				table.append(tr);
			}
		}
	}
	
	$('#content table td').each((i, e) => {
		if(e.textContent == arr[0].toString()) {
			$(e).addClass('today');
		}
	});
}

