// 01.Daggers and Swords
//daggersAndSwords(['17.8',
//	'19.4',
//	'13',
//	'55.8',
//	'126.96541651',
//	'3']);
function daggersAndSwords(arr) {
	arr = arr.map(x => Math.floor(Number(x)))
		.filter(x => x !== '' && x !== undefined && x > 10 );
	console.log('<table border="1">\n' +
			'<thead>\n' +
			'<tr><th colspan="3">Blades</th></tr>\n' +
			'<tr><th>Length [cm]</th><th>Type</th><th>Application</th></tr>\n' +
			'</thead>\n' +
			'<tbody>');
	for (let e of arr) {
		console.log('<tr><td>' + e + '</td><td>' + checkType(e) + '</td><td>' + checkIndex(e) + '</td></tr>');

	}
	console.log('</tbody>\n' +
			'</table>');
	
	function checkType(len) {
    	if (len > 40) {
    		return 'sword';
		} 
    	return 'dagger';
    }
	
	function checkIndex(len) {
		len = len % 5;
    	switch (len) {
		case 1 || 6:
			return 'blade';
		case 2 || 7:
			return 'quite a blade';
		case 3 || 8:
			return 'pants-scraper';
		case 4 || 9:
			return 'frog-butcher';
		case 0:
			return '*rap-poker';
    	}
    }
}

// 02.X-Removal
//xRemoval(['puoUdai',
//	'miU',
//	'ausupirina',
//	'8n8i8',
//	'm8o8a',
//	'8l8o860',
//	'M8i8',
//	'8e8!8?!']);
function xRemoval(arr) {
	arr = arr.filter(x => x !== '').map(x => x.split(''));
	let matrix = [];
	let maxCol = 0;
	for (let e of arr) {
		matrix.push(e.map(x => x.toLowerCase()));
		if (e.length > maxCol) {
			maxCol = e.length;
		}
	}
	for (let r = 0; r < matrix.length - 2; r++) {
		while (matrix[r].length < maxCol) {
			matrix[r].push(' ');
		}
	}
	for (let r = 0; r < matrix.length - 2; r++) {
		for (let c = 0; c < maxCol - 2; c++) {
			if (matrix[r][c] != ' '
				&& matrix[r][c] == matrix[r][c + 2]
				&& matrix[r][c] == matrix[r + 1][c + 1]
				&& matrix[r][c] == matrix[r + 2][c]
				&& matrix[r][c] == matrix[r + 2][c + 2]) {
				arr[r][c] = ' ';
				arr[r][c + 2] = ' ';
				arr[r + 1][c + 1] = ' ';
				arr[r + 2][c] = ' ';
				arr[r + 2][c + 2] = ' ';
			}
		}
	}

	let toPrint = '';
	for (let e of arr) {
		toPrint += e.filter(x => x !== ' ').join('') + '\n';
	}
	console.log(toPrint);
}

// 03.Query Mess
//queryMess(['foo=%20foo&value=+val&foo+=5+%20+203',
//	'foo=poo%20&value=valley&dog=wow+',
//	'url=https://softuni.bg/trainings/coursesinstances/details/1070',
//	'https://softuni.bg/trainings.asp?trainer=nakov&course=oop&course=php']);
//queryMess(['http://lotr.wikia.com/wiki/Elves?find=elf&elves=amarie%20%20%20%20nimrodel&elves=gil-galad+galadriel&mortal=harry%20potter&elven=legolas&mortal=he-who-must-not-be-named+&mortal=boromir&immortal=spirit&mortal=bilbo+beggins&evil=sauron&answer%20of%20everything++++=42',
//	'https://www.google.bg/search?q=whitespace&oq=whitespace&aqs=chrome.0.0l6.1165j0j7&sourceid=chrome&es_sm=93&ie=UTF-8',
//	'numbers=20&symbols=#%*^(^(']);
function queryMess(arr) {
	arr = arr.filter(x => x !== '');
	for (let e of arr) {
		let res = {};
		let pairs = e.split('&').filter(x => x !== '');
		for (let p of pairs) {
			let match;
			let pattern = /\?*([^\?]+)=([^&]+)/g;
			while (match = pattern.exec(p)) {
				let tokens = match[0].split('=');
				let key = match[1]
					.replace(/[\+]+/g, ' ')
					.replace(/%20/g, ' ')
					.replace(/[\?]+/g, ' ')
					.replace(/\s{2,}/g, ' ').trim();
				let value = match[2]
					.replace(/[\+]+/g, ' ')
					.replace(/%20/g, ' ')
					.replace(/[\?]+/g, ' ')
					.replace(/\s{2,}/g, ' ').trim();
				if (res[key]) {
					res[key].push(value);
				} else {
					res[key] = [value];
				}
			}
		}
		console.log(stringify(res));
	}

	function stringify(arr) {
    	let res = '';
    	for (let i in arr) {
    		res += i + '=[' + arr[i].join(', ') + ']';
		}
    	return res;
    }
}

// 04.Vladko's Notebook
//vladkoNotebook(['purple|age|99',
//	'red|age|44',
//	'blue|win|pesho',
//	'blue|win|mariya',
//	'purple|loss|Kiko',
//	'purple|loss|Kiko',
//	'purple|loss|Kiko',
//	'purple|loss|Yana',
//	'purple|loss|Yana',
//	'purple|loss|Manov',
//	'purple|loss|Manov',
//	'red|name|gosho',
//	'blue|win|Vladko',
//	'purple|loss|Yana',
//	'purple|name|VladoKaramfilov',
//	'blue|age|21',
//	'blue|loss|Pesho']);
function vladkoNotebook(arr) {
	arr = arr.filter(x => x !== '');
	let notebook = {};
	for (let e of arr) {
		let [color, action, arg] = e.split(/\s*\|\s*/).filter(x => x !== '');
		let temp = {win: 1, loss: 1, opponents:[]};
		if (notebook[color]) {
			temp = notebook[color];
		}
		if (action == 'loss' || action == 'win') {
			temp[action] += 1;
			temp['opponents'].push(arg);
		} else {
			temp[action] = arg;
		}
		notebook[color] = temp;
	}
	let notebookKeys = Object.keys(notebook).sort();
	let notebookSorted = {};
	for (let nk of notebookKeys) {
		if (!notebook[nk]['name'] || !notebook[nk]['age']) {
			continue;
		}
		notebookSorted[nk] = {};
		notebookSorted[nk]['age'] = notebook[nk]['age'];
		notebookSorted[nk]['name'] = notebook[nk]['name'];
		notebookSorted[nk]['opponents'] = notebook[nk]['opponents'].sort();
		notebookSorted[nk]['rank'] = (notebook[nk]['win'] / notebook[nk]['loss']).toFixed(2).toString();
	}
	console.log(JSON.stringify(notebookSorted));
}

