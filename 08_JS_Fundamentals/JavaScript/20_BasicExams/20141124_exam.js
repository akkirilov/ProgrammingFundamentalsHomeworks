// 01. Ewoks Fans
//ewoksFans(['22.03.2024',
//	'10.10.1954']);
function ewoksFans(arr) {
	arr = arr.filter(x => x !== '');
	let maxDate = new Date(2015, (1 - 1), (1));
	let minDate = new Date(1900, (1 - 1), (1));
	let separator = new Date(1973, (5 - 1), (25));
	let bigHater;
	let bigFan;
	for (let e of arr) {
		let[day, month, year] = e.split(/\s*\.\s*/).filter(x => x !== '').map(x => Number(x));
		let tempDate = new Date(year, (month - 1), (day));
		if (tempDate > minDate && tempDate < maxDate) {
			if (tempDate < separator && (!bigHater || bigHater > tempDate)) {
				bigHater = tempDate;
			} else if (tempDate > separator && (!bigFan || bigFan < tempDate)) {
				bigFan = tempDate;
			}
		}
	}
	if (!bigFan && !bigHater) {
		console.log('No result');
    }
	if (bigFan) {
		console.log('The biggest fan of ewoks was born on ' + bigFan.toDateString());
    }
	if (bigHater) {
		console.log('The biggest hater of ewoks was born on ' + bigHater.toDateString());
    }
}

// 02. Plus Remove
//plusRemove(['@s@a@p@una',
//	'p@@@@@@@@dna',
//	'@6@t@*@*ego',
//	'vdig*****ne6',
//	'li??^*^*']);
//plusRemove(['sos',
//	'oSo',
//	's0s']);
function plusRemove(arr) {
	arr = arr.filter(x => x !== '');
	let matrix = [];
	let res = [];
	let maxCol = 0;
	for (let e of arr) {
		matrix.push(e.split('').map(x => x.toLowerCase()));
		res.push(e.split(''));
		if (e.length > maxCol) {
			maxCol = e.length;
		}
	}
	for (let i in matrix) {
		while(matrix[i].length < maxCol) {
			matrix[i].push(' ');
		}
	}

	for (let r = 0; r < matrix.length - 2; r++) {
		for (let c = 1; c < matrix[r].length - 1; c++) {
			let temp = matrix[r][c];
			if (temp == matrix[r + 1][c - 1]
					&& temp == matrix[r + 1][c]
					&& temp == matrix[r + 1][c + 1]
					&& temp == matrix[r + 2][c]) {
				res[r][c] = ' ';
				res[r + 1][c - 1] = ' ';
				res[r + 1][c] = ' ';
				res[r + 1][c + 1] = ' ';
				res[r + 2][c] = ' ';
			}
		}
	}
	for (let e of res) {
		console.log(e.join('').split(' ').join(''));
	}
}

// 03. Link Strings
//linkStrings(['foo=%20foo&value=+val&foo+=5+%20+203',
//	'foo=poo%20&value=valley&dog=wow+',
//	'url=https://softuni.bg/trainings/coursesinstances/details/1070',
//	'https://softuni.bg/trainings.asp?trainer=nakov&course=oop&course=php']);
function linkStrings(arr) {
	arr = arr.filter(x => x !== '');
	for (let e of arr) {
		let res = {};
		let tokens = e.split(/\&/);
		for (let t of tokens) {
			let match;
			let pattern = /([^?]+)=([^?]+)/g;
			while (match = pattern.exec(t)) {
				let key = match[1]
					.replace(/[\+]+/g, ' ')
					.replace(/[\?]+/g, ' ')
					.replace(/\%20/g, ' ')
					.replace(/\s{2,}/g, ' ').trim();
				let value = match[2]
					.replace(/[\+]+/g, ' ')
					.replace(/[\?]+/g, ' ')
					.replace(/\%20/g, ' ')
					.replace(/\s{2,}/g, ' ').trim();
				if (res[key]) {
					res[key].push(value);
				} else {
					res[key] = [value];
				}
			}
		}
		printAsStringLine(res);
	}
	
	function printAsStringLine(obj) {
		let res = '';
    	for (let e in obj) {
    		res += e + '=[' + obj[e].join(', ') + ']';
		}
    	console.log(res);
    }
}

// 04. User Module
//userModule(['level^courses',
//	'{"id":0,"firstname":"Hristiqn","lastname":"Petrov","town":"Sofia","role":"student","grades":["4.06","5.17"],"level":5,"certificate":false}',
//	'{"id":1,"firstname":"Angel","lastname":"Petrov","town":"Sofia","role":"trainer","courses":["Java","JS OOP"],"lecturesPerDay":6}',
//	'{"id":2,"firstname":"Gergana","lastname":"Nakov","town":"Sliven","role":"trainer","courses":["Java","JS OOP","SDA"],"lecturesPerDay":5}',
//	'{"id":3,"firstname":"Angel","lastname":"Nakova","town":"Burgas","role":"trainer","courses":["Database","JS OOP","JS","C#","iOS","HTML/CSS"],"lecturesPerDay":6}',
//	'{"id":4,"firstname":"Petq","lastname":"Nakova","town":"Petrich","role":"student","grades":["5.14"],"level":4,"certificate":true}',
//	'{"id":5,"firstname":"Julieta","lastname":"Petrov","town":"Svishtov","role":"trainer","courses":["iOS","OOP","JS","C#","Java"],"lecturesPerDay":6}',
//	'{"id":6,"firstname":"Ivan","lastname":"Ivanov","town":"Stara Zagora","role":"student","grades":["5.28","2.15","4.25","4.95"],"level":2,"certificate":true}',
//	'{"id":7,"firstname":"Gergana","lastname":"Daskalov","town":"Sofia","role":"trainer","courses":["PHP","ASP.NET","SDA"],"lecturesPerDay":5}',
//	'{"id":8,"firstname":"Qvor","lastname":"Dimitrov","town":"Sevlievo","role":"student","grades":["4.30","3.14","4.09","4.08","2.25"],"level":5,"certificate":true}',
//	'{"id":9,"firstname":"Petq","lastname":"Nakov","town":"Gabrovo","role":"trainer","courses":["JS Apps","Java","JS","iOS","SDA","HTML/CSS"],"lecturesPerDay":9}',
//	'{"id":10,"firstname":"Bobi","lastname":"Nakov","town":"Gabrovo","role":"student","grades":["3.80"],"level":1,"certificate":false}']);
function userModule(arr) {
	arr = arr.filter(x => x !== '');
	let criteria = arr.shift();
	let students = [];
	let trainers = [];
	let firstCriteria = 'firstname';
	let secondCriteria = 'lastname';
	if (criteria == 'level^courses') {
		firstCriteria = 'level';
		secondCriteria = 'id';
    }
	for (let e of arr) {
		let temp = JSON.parse(e);
		if (temp['role'] == 'student') {
			students.push(temp);
		} else {
			trainers.push(temp);
		}
	}
	let res = {};

	students = students.sort((a, b) => {
				let res;
				if (isNaN(a[firstCriteria])) {
					res = a[firstCriteria].localeCompare(b[firstCriteria]);
					if (res == 0) {
						res = a[secondCriteria].localeCompare(b[secondCriteria]);
					}
				} else {
					res = (a[firstCriteria] - b[firstCriteria]);
					if (res == 0) {
						res = (a[secondCriteria] - b[secondCriteria]);
					}
				}
				return res;
			});
	for (let s of students) {
		let cert = s['certificate'];
		s['averageGrade'] = (s['grades'].map(x => Number(x)).reduce((a, b) => a + b) / s['grades'].length).toFixed(2).toString();
		delete s['town'];
		delete s['role'];
		delete s['grades'];
		delete s['level'];
		delete s['certificate'];
		s['certificate'] = cert;
	}
	res['students'] = students;
	trainers = trainers.sort((a, b) => {
					let res = a['courses'].length - b['courses'].length;
					if (res == 0) {
						res = a['lecturesPerDay'] - b['lecturesPerDay'];
					}
					return res;
				});
	for (let t of trainers) {
		delete t['town'];
		delete t['role'];
	}
	res['trainers'] = trainers;
	console.log(JSON.stringify(res));
}

