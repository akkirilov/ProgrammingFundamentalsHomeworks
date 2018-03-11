// 01. Summary
function summary(selector) {
	$(selector).on('click', summarize);
	function summarize() {
		$('#content').parent().append(
						$('<div>')
						.attr('id', 'summary')
						.append($('<h2>')
								.text('Summary')
								)
						.append($('<p>')
								.text($('#content')
									.find('p')
									.find('strong')
									.toArray()
									.map(x => $(x).text())
									.join(''))
								)
						);
	}
}

// 02. Sorted List
// Tests in p20_20161031_02_tests.js
class SortedList {
    constructor() {
        this.list = [];
    }
    add(element) {
        this.list.push(element);
        this.sort();
    }
    remove(index) {
        this.vrfyRange(index);
        this.list.splice(index, 1);
    }
    get(index) {
        this.vrfyRange(index);
        return this.list[index];
    }
    vrfyRange(index) {
        if (this.list.length == 0) throw new Error("Collection is empty.");
        if (index < 0 || index >= this.list.length) throw new Error("Index was outside the bounds of the collection.");
    }
    sort() {
        this.list.sort((a, b) => a - b);
    }
    get size() {
        return this.list.length;
    }
}

// 03. Storm Watcher
let mr = (function () {
	let autoId = 0;
	class MeteorologicalReading {
		constructor(temperature, humidity, pressure, windSpeed) {
			this.id = autoId++;
			this.temperature = temperature;
			this.humidity = humidity;
			this.pressure = pressure;
			this.windSpeed = windSpeed;
		}
		
		toString() {
			let res = 
			'Reading ID: ' + this.id + '\n'
			+ 'Temperature: ' + this.temperature + '*C\n'
			+ 'Relative Humidity: ' + this.humidity + '%\n'
			+ 'Pressure: ' + this.pressure + 'hpa\n'
			+ 'Wind Speed: ' + this.windSpeed + 'm/s\n'
			+ 'Weather: ';
			let weather = 'Not stormy';
			if (this.temperature < 20
				&& this.windSpeed > 25
				&& (this.pressure < 700 || this.pressure > 900)) {
				weather = 'Stormy';
			}
			res += weather;
			return res;
		}
	}
	return MeteorologicalReading;
})();

// 04. Title Bar
class TitleBar {
	constructor(title) {
		this.title = title;
		this.links = [];
	}
	addLink(href, name) {
		this.links.push(`<a class="menu-link" href="${href}">${name}</a>`);
	}
	appendTo(selector) {
		$(selector)
		.append($('<header>')
		.addClass('header')
		.append($('<div>')
				.addClass("header-row")
				.append('<a class="button">&#9776;</a>')
				.append('<span class="title">' + this.title + '</span>')
			)
			.append($('<div>')
				.addClass("drawer")
				.append($('<nav>')
					.addClass('menu')
					.html(this.links.join('')
					)
				)
			)
		);
		$('div.drawer').css('display', 'none');
		$('a.button').on('click', function() {
			let el =  $('div.drawer');
			if (el.css('display') == 'block') {
				el.css('display', 'none');
			} else {
				el.css('display', 'block');
			}
		});
	}
}













module.exports = { SortedList }

