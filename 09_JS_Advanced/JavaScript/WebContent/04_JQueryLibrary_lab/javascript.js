function extractText() {
    let res = $('ul > li').toArray().map(x => $(x).text()).join(', ');
    $('#result').text(res);
}

function search() {
	let myQuery = $('#searchText').val();
	let counter = 0;
	$('ul > li').each(function (i, e) {
		if (e.textContent.includes(myQuery)) {
			$(e).css('font-weight', 'bold');
			counter++;
		} else {
			$(e).css('font-weight', '');
		}
	})
	$('#result').text(counter + ' matches found.');
}

function initializeTable() {
	$('#createLink').on('click', createCountry);
	addCountry('Bulgaria', 'Sofia');
	addCountry('Germany', 'Berlin');
	addCountry('Russia', 'Moscow');
	fixLinks();
	
	function addCountry(country, capital) {
		$('#countriesTable').append($('<tr>')
				.append($('<td>').text(country))
				.append($('<td>').text(capital))
				.append($('<td>')
						.append($('<a>').attr("href", "#").text('[Up]').on('click', rowUp))
						.append(' ')
						.append($('<a>').attr("href", "#").text('[Down]').on('click', rowDown))
						.append(' ')
						.append($('<a>').attr("href", "#").text('[Delete]').on('click', rowDelete))
						)
				);
		fixLinks();
	}
	
	function createCountry() {
		let country = $('#newCountryText');
		let capital = $('#newCapitalText');
		addCountry(country.val(), capital.val());
		country.val('');
		capital.val('');
	}
	
	function rowUp() {
		let row = $(this).parent().parent();
		row.fadeOut(function() {
			row.insertBefore(row.prev());
			row.fadeIn();
			fixLinks();
		});
	}
	
	function rowDown() {
		let row = $(this).parent().parent();
		row.fadeOut(function() {
			row.insertAfter(row.next());
			row.fadeIn();
			fixLinks();
		});
	}
	
	function rowDelete() {
		let row = $(this).parent().parent();
		row.fadeOut(function() {
			row.remove();
			fixLinks();
		});
	}
	
	function fixLinks() {
		$('#countriesTable tr td a').css('display', 'inline');
		$('#countriesTable tr:eq(2) td a:first-child').css('display', 'none');
		$('#countriesTable tr:last-child td a:eq(1)').css('display', 'none');
	}
}

function attachEvents() {
	$('.button').on('click', select);
	
	function select() {
		$('.button').removeClass('selected');
		$(this).addClass('selected');
	}
}

function attachEventsTowns() {
	$('#items li').on('click', select);
	$('#showTownsButton').on('click', showSelectedTowns);
	
	function select() {
		let el = $(this);
		if (el.attr('data-selected')) {
			el.removeAttr('data-selected');
			el.css('background-color', '');
		} else {
			el.attr('data-selected', 'true');
			el.css('background-color', '#DDD');
		}
	}
	
	function showSelectedTowns() {
		$('#selectedTowns').text($('#items li[data-selected=true]').toArray().map(x => $(x).text()).join(', '));
	}
}

