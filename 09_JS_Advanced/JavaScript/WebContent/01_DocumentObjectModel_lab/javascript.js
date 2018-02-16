function calc() {
	let num1 = Number(document.getElementById('num1').value);
	let num2 = Number(document.getElementById('num2').value);
	document.getElementById('sum').value = num1 + num2;
}

function showText() {
	document.getElementById('text').style.display = 'inline';
	document.getElementById('more').style.display = 'none';
}

function extractText() {
	let liArr = document.getElementsByTagName('li');
	let res = '';
	for (let e of liArr) {
		res += e.textContent + '\n';
	}
	document.getElementById('result').textContent = res;
}

function colorize() {
	let trArr = document.getElementsByTagName('tr');
	for (let i = 1; i < trArr.length; i += 2) {
		trArr[i].style.backgroundColor = 'Teal';
	}
}

function countdown(sec) {
	let minutes = Math.trunc(Number(sec) / 60);
	let seconds = Math.trunc(Number(sec) % 60);
	document.getElementById('time').value = minutes + ':' + ('0' + seconds).slice(-2);
	setInterval(() => {
		sec--;
		minutes = Math.trunc(Number(sec) / 60);
		seconds = Math.trunc(Number(sec) % 60);
		document.getElementById('time').value = minutes + ':' + ('0' + seconds).slice(-2);
	}, 1000);
}

function extract(id) {
	let text = document.getElementById(id).textContent;
	let res = [];
	let match;
	let pattern = /\((.+)\)/g;
	while (match = pattern.exec(text)) {
		res.push(match[1]);
	}
	return res.join('; ');
}

function sum() {
	let tdArr = document.getElementsByTagName('td');
	let sum = 0;
	for (let i = 1; i < tdArr.length - 2; i += 2) {
		sum += Number(tdArr[i].textContent);
	}
	tdArr[tdArr.length - 1].textContent = sum;
}

