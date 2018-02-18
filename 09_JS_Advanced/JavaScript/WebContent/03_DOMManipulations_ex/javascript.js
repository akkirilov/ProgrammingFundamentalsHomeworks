function subtract() {
	let num1 = Number(document.getElementById('firstNumber').value);
	let num2 = Number(document.getElementById('secondNumber').value);
	document.getElementById('result').textContent = num1 - num2;
}

function addItem() {
	let valueInput = document.getElementById('newItemValue');
	let textInput = document.getElementById('newItemText');
	let newOption = document.createElement('option');
	newOption.value = valueInput.value;
	newOption.textContent = textInput.value;
	valueInput.value = '';
	textInput.value = '';
	document.getElementById('menu').appendChild(newOption);
}

function toggle() {
	let btn = document.getElementsByClassName('button')[0];
	let more = document.getElementById('extra');
	if (more.style.display === 'block') {
		btn.textContent = 'More';
		more.style.display = 'none';
	} else {
		btn.textContent = 'Less';
		more.style.display = 'block';
	}
}

function create(arr) {
	let mainDiv = document.getElementById('content');
	for (let e of arr) {
		let p = document.createElement('p');
		p.textContent = e;
		p.style.display = 'none';
		let div = document.createElement('div');
		div.appendChild(p);
		div.addEventListener('click', show);
		mainDiv.appendChild(div);
	}
	function show(e) {
		if (e.target.lastChild.style.display === 'block') {
			e.target.lastChild.style.display = 'none';
		} else {
			e.target.lastChild.style.display = 'block';
		}
	}
}

function notify(str) {
	let div = document.getElementById('notification');
	div.textContent = str;
	div.style.display = 'block';
	setTimeout(disapear, 2000);
	function disapear(e) {
		div.style.display = 'none';
		div.textContent = '';
	}
}

function attachEventsListeners() {
	document.querySelector('#daysBtn').addEventListener('click', convertFromDays);
	document.querySelector('#hoursBtn').addEventListener('click', convertFromHours);
	document.querySelector('#minutesBtn').addEventListener('click', convertFromMinutes);
	document.querySelector('#secondsBtn').addEventListener('click', convertFromSeconds);
	function convertFromDays() {
		let days = Number(document.querySelector('#days').value);
		document.querySelector('#hours').value = days * 24;
		document.querySelector('#minutes').value = days * 24 * 60;
		document.querySelector('#seconds').value = days * 24 * 60 * 60; 
	}
	function convertFromHours() {
		let hours = Number(document.querySelector('#hours').value);
		document.querySelector('#days').value = hours / 24;
		document.querySelector('#minutes').value = hours * 60;
		document.querySelector('#seconds').value = hours * 60 * 60;
	}
	function convertFromMinutes() {
		let minutes = Number(document.querySelector('#minutes').value);
		document.querySelector('#days').value = minutes / 60 / 24;
		document.querySelector('#hours').value = minutes / 60;
		document.querySelector('#seconds').value = minutes * 60;
	}
	function convertFromSeconds() {
		let seconds = Number(document.querySelector('#seconds').value);
		document.querySelector('#days').value = seconds / 60 / 60 / 24;
		document.querySelector('#hours').value = seconds / 60 / 60;
		document.querySelector('#minutes').value = seconds / 60;
	}
}

function attachEventsListenersDistanceConvertor() {
	document.querySelector('#convert').addEventListener('click', convert);
	function convert() {
		let value = Number(document.querySelector('#inputDistance').value);
		let inputType = document.querySelector('#inputUnits').value;
		switch (inputType) {
			case 'km': value *= 1000;break;
			case 'cm': value /= 100;break;
			case 'mm': value /= 1000;break;
			case 'mi': value *= 1609.34;break;
			case 'yrd': value *= 0.9144;break;
			case 'ft': value *= 0.3048;break;
			case 'in': value *= 0.0254;break;
			default:break;
		}
		let outputType = document.querySelector('#outputUnits').value;
		switch (outputType) {
			case 'km': value /= 1000;break;
			case 'cm': value *= 100;break;
			case 'mm': value *= 1000;break;
			case 'mi': value /= 1609.34;break;
			case 'yrd': value /= 0.9144;break;
			case 'ft': value /= 0.3048;break;
			case 'in': value /= 0.0254;break;
			default:break;
		}
		document.querySelector('#outputDistance').value = value;
	}
}

