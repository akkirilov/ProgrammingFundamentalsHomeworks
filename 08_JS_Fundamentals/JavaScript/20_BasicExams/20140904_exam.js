// 01. Keep The Change
//keepTheChange([ 1230.83, 'drunk' ]);
function keepTheChange(arr) {
	let [bill, mood] = arr;
	let tip;
	switch (mood) {
	case 'happy':
		tip = (bill / 100 * 10).toFixed(2);
		break;
	case 'married':
		tip = (bill / 100 * 0.05).toFixed(2);
		break;
	case 'drunk':
		tip = (bill / 100 * 15);
		tip = Math.pow(tip, Number(tip.toString()[0])).toFixed(2);
		break;
	default:
		tip = (bill / 100 * 5).toFixed(2);
		break;
	}
	console.log(tip);
}

// 02. The Numbers
//theNumbers(['5tffwj(//*7837xzc2---34rlxXP%$".']);
function theNumbers(arr) {
	console.log(arr[0].split(/[^\d]+/)
			.filter(x => x !== '')
			.map(x => Number(x).toString(16).toUpperCase())
			.map(x => {
				while(x.length < 4) {
					x = '0' + x;
				}
				return '0x' + x;
			}).join('-'));
}

// 03. To The Stars
//toTheStars(['Sirius 3 7',
//	'Alpha-Centauri 7 5',
//	'Gamma-Cygni 10 10',
//	'8 1',
//	'6']);
//toTheStars(['Terra-Nova 16 2',
//	'Perseus 2.6 4.8',
//	'Virgo 1.6 7',
//	'2 5',
//	'4']);
function toTheStars(arr) {
	arr = arr.filter(x => x !== '');
	let turns = Number(arr.pop());
	let [x, y] = arr.pop().split(/\s+/).filter(x => x !== '').map(x => Number(x));
	let normandy = {x: x, y: y};
	let stars = [];
	for (let e of arr) {
		let tokens = e.split(/\s+/).filter(x => x !== '');
		stars.push({ name:tokens[0].toLowerCase(), x: Number(tokens[1]), y: Number(tokens[2]) });
	}
	let res = '';
	stars = stars.filter(s => (Math.abs(s.x - normandy.x) < 2) && (s.y - 1 <= turns + normandy.y));
	for (let i = 0; i <= turns; i++) {
		res += isAroundStar(normandy, stars) + '\n';
		normandy.y = normandy.y + 1;
	}
	console.log(res);

	function isAroundStar(normandy, stars) {
    	for (let s of stars) {
    		if (Math.abs(s.y - normandy.y) <= 1) {
    			return s.name;
    		}
		}
    	return 'space';
    }
}

// 04. Cloud Manager
//cloudManager(['sentinel .exe 15MB',
//	'zoomIt .msi 3MB',
//	'skype .exe 45MB',
//	'trojanStopper .bat 23MB',
//	'kindleInstaller .exe 120MB',
//	'setup .msi 33.4MB',
//	'winBlock .bat 1MB'])
function cloudManager(arr) {
	arr = arr.filter(x => x !== '');
	let files = {};
	for (let e of arr) {
		let [name, extension, memory] = e.split(/\s+/).filter(x => x !== '');
		if (files[extension]) {
			files[extension]['files'].push(name);
			files[extension]['memory'] = files[extension]['memory'] + Number(memory.replace(/MB/, ''));
		} else {
			files[extension] = {};
			files[extension]['files'] = [name];
			files[extension]['memory'] = Number(memory.replace(/MB/, ''));
		}
	}
	let sortedFiles = {};
	let filesKeys = Object.keys(files).sort();
	for (let fk of filesKeys) {
		sortedFiles[fk] = {};
		sortedFiles[fk]['files'] = files[fk]['files'].sort();
		sortedFiles[fk]['memory'] = files[fk]['memory'].toFixed(2);
	}
	console.log(JSON.stringify(sortedFiles));
}

