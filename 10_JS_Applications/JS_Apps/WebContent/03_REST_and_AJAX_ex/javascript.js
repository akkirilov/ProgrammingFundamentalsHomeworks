// 01. Bus Stop
function getInfo() {
	let ul = $('#buses')
	ul.empty();
	$.ajax({
		method: 'GET',
		url: 'https://judgetests.firebaseio.com/businfo/' + $('#stopId').val() + '.json',
		success: showData,
		error: showError
	});
	
	function showData(res) {
		$('#stopName').text(res.name);
		for (let bus in res.buses) {
			ul.append($(`<li>Bus ${bus} arrives in ${res.buses[bus]} minutes</li>`));
		}
	}
	
	function showError(res) {
		$('#stopName').text('Error');
	}
	
}

// 02. Bus Schedule
function busSchedule() {
	const URL = 'https://judgetests.firebaseio.com/schedule/';
	let infoSpan = $('#info span');
	let departStop = 'Depot';
	let nextStopId = 'depot';
	
	function swapButtons() {
		let arriveBtn = $('#arrive');
		let departBtn = $('#depart');
		if (arriveBtn.prop('disabled') === true) {
			arriveBtn.prop('disabled', false);
			departBtn.prop('disabled', true);
		} else {
			arriveBtn.prop('disabled', true);
			departBtn.prop('disabled', false);
		}
	}
	
	function handleError() {
		infoSpan.text('Error');
	}
	
    function depart() {
    	$.ajax({
			method: "GET",
			url: URL + nextStopId + ".json",
			success: function (res) {
				nextStopId = res.next;
				departStop = res.name;
				infoSpan.text('Next stop ' + departStop);
			},
			error: handleError
		});
    	swapButtons();
	}
	
    function arrive() {
    	infoSpan.text('Arriving at ' + departStop);
    	swapButtons();
	}
    
	return {
      depart,
      arrive
    };
}

// 03. Messenger
function attachMessengerEvents() {
	let messages = $('#messages');
	function handleError() {
		messages.text('Error');
	}
	$('#refresh').on('click', function() {
		$.ajax({
			method: "GET",
			url: "https://messenger-a3e05.firebaseio.com/messenger.json",
			success: function (res) {
				let allMessages = '';
				for (let m in res) {
					allMessages += res[m].author + ': ' + res[m].content + '\n';
				}
				messages.text(allMessages);
			},
			error: handleError
		});
	});
	$('#submit').on('click', function() {
		let authorBox = $('#author');
		let contentBox = $('#content');
		$.ajax({
			method: "POST",
			url: "https://messenger-a3e05.firebaseio.com/messenger.json",
			data: JSON.stringify({author: authorBox.val(), content: contentBox.val(), timestamp: Date.now()}),
			success: function (res) {
				messages.text(messages.text() + authorBox.val() + ': ' + contentBox.val() + '\n');
				authorBox.val('');
				contentBox.val('');
			},
			error: handleError
		});
	});
}

// 04. Phonebook
function attachPhonebookEvents() {
	const URL = "https://phonebook-nakov.firebaseio.com/phonebook";
	let name = $('#person').val();
	let phone = $('#phone').val();
	
	$('#btnLoad').on('click', function() {
		$.ajax({
			method: "GET",
			url: URL + ".json",
			success: displayPhones,
			error: handleError
		});
	});
	
	$('#btnCreate').on('click', function() {
		$('#person').val('');
		$('#phone').val('');
		$.ajax({
			method: "POST",
			url: URL + ".json",
			data: JSON.stringify({name, phone}),
			success: createPhone,
			error: handleError
		});
	});
	
	function createPhone(res) {
		appendContact(res.person, name, name);
	}
	
	function displayPhones(res) {
		$('#phonebook').empty();
		for (let r in res) {
			if (res[r] != null) {
				appendContact(r, res[r].person, res[r].phone);
			}
		}
	}
	
	function appendContact(id, name, phone) {
		let li = $(`<li>${name} ${phone} </li>`);
		li.append($(`<button>[Delete]</button>`).on('click', function(e) {
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

