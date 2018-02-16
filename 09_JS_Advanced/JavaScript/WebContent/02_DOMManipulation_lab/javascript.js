function addItem() {
	let newLi = document.createElement('li');
	let newItemText = document.getElementById('newItemText');
	newLi.textContent = newItemText.value;
	document.getElementById('items').appendChild(newLi);
	newItemText.value = '';
}

function addItem() {
	let newLi = document.createElement('li');
	let newItemText = document.getElementById('newText');
	newLi.innerHTML = newItemText.value + ' <a href = "#">[Delete]</a>';
	newLi.addEventListener('click', removeItem);
	document.getElementById('items').appendChild(newLi);
	newItemText.value = '';
	function removeItem(event) {
		event.target.parentNode.parentNode.removeChild(event.target.parentNode);
	}
}

function deleteByEmail() {
	let email = document.getElementsByName('email')[0].value.trim();
	let tdArr = document.getElementsByTagName('td');
	let res = 'Not found.';
	for (let i = 1; i < tdArr.length; i += 2) {
		if (tdArr[i].textContent === email) {
			tdArr[i].parentNode.parentNode.removeChild(tdArr[i].parentNode);
			res = 'Deleted.';
			break;
		}
	}
	document.getElementById('result').textContent = res;
}

function stopwatch() {
	let timer;
	let seconds = 0;
	let startBtn = document.getElementById('startBtn');
	let stopBtn = document.getElementById('stopBtn');
	startBtn.addEventListener('click', startStopwatch);
	stopBtn.addEventListener('click', stopStopwatch);
	function startStopwatch() {
		stopBtn.disabled = false;
		startBtn.disabled = true;
		document.getElementById('time').textContent = ('0' + Math.trunc(seconds / 60)).slice(-2) 
		+ ':' + ('0' + seconds % 60).slice(-2);
		timer = setInterval(()=>{
			seconds++;
			document.getElementById('time').textContent = ('0' + Math.trunc(seconds / 60)).slice(-2) 
				+ ':' + ('0' + seconds % 60).slice(-2);
			}, 1000);
	}
	function stopStopwatch() {
		clearInterval(timer);
		seconds = 0;
		stopBtn.disabled = true;
		startBtn.disabled = false;
	}
}

function attachGradientEvents() {
	let box = document.getElementById('gradient-box');
	box.addEventListener('mousemove', (e) => {
		let res = e.offsetX;
		document.getElementById('result').textContent = Math.trunc((res / (e.target.clientWidth - 1)) * 100) + '%';
	});
	box.addEventListener('mouseleave', () => {
		document.getElementById('result').textContent = '';
	});
}

function focus() {
	let inputArr = document.getElementsByTagName('input');
	for (let e of inputArr) {
		let parent = e.parentNode;
		e.addEventListener('focus', function(e) {
			parent.setAttribute('class', 'focused');
		});
		e.addEventListener('blur', function(e) {
			parent.classList.remove('focused');
		});
	}
}

function validate() {
	let emailBox = document.getElementById('email');
	let pattern = /^[\w\-.]+@[a-z]+(\.[a-z]+)+$/;
	emailBox.addEventListener('change', function(e) {
		if (pattern.test(emailBox.value)) {
			emailBox.removeAttribute('class');
		} else {
			emailBox.classList.add('error');
		}
	});
}

