let data;

$(() => {
	let list = $('#list');
    $.get('data.json')
    .then(function(res) {
    	data = res;
    	let context = {'title': 'Contacts', 'contacts': data};
    	$.get('templates/contactsList.hbs')
    	.then(function(res) {
			let template = Handlebars.compile(res);
			let html = template(context);
			list.append(html);
			let detailsTemplate;
			$.get('templates/contactDetails.hbs')
			.then(function(res) {
				detailsTemplate = Handlebars.compile(res);
				function viewDetails() {
					$('#list .content .contact').removeClass('active');
					let el = $(this);
					el.addClass('active');
					let id = el.attr('data-id');
					let htmlDetails = detailsTemplate(data[id]);
					$('#details').empty().append(htmlDetails);
				}
				list.find('.contact').on('click', viewDetails);
			}).catch(function(err) {
				$('#book').append(`<h2>${err.status}: ${err.statusText}</h2>`);
			});
		}).catch(function(err) {
			$('#book').append(`<h2>${err.status}: ${err.statusText}</h2>`);
		});
	}).catch(function(err) {
		$('#book').append(`FATAL ERROR: <h2>${err.status} - ${err.statusText}</h2>`);
	});
});



