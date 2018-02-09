// 01. Arithmephile
//arithmephile([ 18,42,19,36,1,-297,38,100,9,-249,-170,-18,-208,-11,-87,-90,-286,-27 ]);
function arithmephile(arr) {
	arr = arr.filter(x => x !== '').map(x => Number(x));
	let max = Number.NEGATIVE_INFINITY;
	for (let i = 0; i < arr.length - 1; i++) {
		if (arr[i] > 0 && arr[i] < 10) {
			let end = Math.min(arr.length, i + arr[i] + 1);
			let temp = 1;
			for (let j = i + 1; j < end; j++) {
				temp *= arr[j];
			}
			if (temp > max) {
				max = temp;
			}
		}
	}
	console.log(max);
}

// 02. Rosetta Stone
//rosettaStone([ '1',
//	'1 3 13',
//	'12 22 14 13 25 0 4 24 23',
//	'18 24 2 25 22 0 0 11 18',
//	'8 25 6 26 8 23 13 4 14',
//	'14 3 14 10 6 1 6 16 14',
//	'11 12 2 10 24 2 13 24 0']);
function rosettaStone(arr) {
	arr = arr.filter(x => x !== '');
	let n = Number(arr.shift());
	let template = [];
	for (let i = 0; i < n; i++) {
		template.push(arr.shift().split(' ').map(x => Number(x)));
	}
	let matrix = [];
	for (let i = 0; i < arr.length; i++) {
		matrix.push(arr[i].split(' ').map(x => Number(x)));
	}
	for (let r = 0; r < matrix.length; r+=n) {
		for (let c = 0; c < matrix[r].length; c+=template[0].length) {
			let rt = 0;
			for (let i = r; i < Math.min(r + n, matrix.length); i++) {
				let ct = 0;
				for (let j = c; j < Math.min(c + template[rt].length, matrix[r].length); j++) {
					matrix[i][j] += template[rt][ct];
					ct++
				}
				rt++
			}
		}
	}
	let res = '';
	for (let r = 0; r < matrix.length; r++) {
		for (let c = 0; c < matrix[r].length; c++) {
			matrix[r][c] = String.fromCharCode((matrix[r][c] % 27) + 64);
		}
		res += matrix[r].join('').replace(/@/g, ' ');
	}
	console.log(res);
}

// 03. Spy Master
//spyMaster(['specialKey',
//	'In this text the specialKey HELLOWORLD! is correct, but',
//	'the following specialKey $HelloWorl#d and spEcIaLKEy HOLLOWO%RLD1 are not, while',
//	'SpeCIaLkeY   SOM%%ETH$IN and SPECIALKEY ##$$##$$ are!']);
function spyMaster(arr) {
	let key = arr.shift();
	let pattern = new RegExp('(^|\\s+)(' + key + ')([ ]+)' + '([A-Z!%$#]{8,})(?= |$|,|\\.)', 'gi');
	for (let i = 0; i < arr.length; i++) {
		console.log(arr[i].replace(pattern, replacer));
	}
	
	function replacer(match, group1, group2, group3, group4){
		for (let i = 0; i < group4.length; i++) {
    		if (group4[i].match(/[a-z]/g)) {
    			return group1 + group2 + group3 + group4;
    		}
		}
		group4 = group4.replace(/!/g,'1')
            .replace(/%/g, '2')
            .replace(/\#/g,'3')
            .replace(/\$/g,'4')
            .replace(/[A-Z]/g,x=>x.toLowerCase());
        return group1 + group2 + group3 + group4;
    }
}

// 04. Radical Marketing
//radicalMarketing(['A',
//	'B',
//	'C',
//	'D',
//	'A-B',
//	'B-A',
//	'C-A',
//	'D-A']);
function radicalMarketing(arr) {
	let peoples = {};
	for (let i = 0; i < arr.length; i++) {
		let tokens = arr[i].split(/\s*-\s*/g);
		if (tokens.length == 1) {
			if (!peoples.hasOwnProperty(tokens[0])) {
				peoples[tokens[0]] = {subscribers: [], fowolls: 0};
			}
		} else if (tokens.length == 2) {
			let p1 = tokens[0];
			let p2 = tokens[1];
			if (!peoples.hasOwnProperty(p1) 
					|| !peoples.hasOwnProperty(p2)
					|| peoples[p2]['subscribers'].includes(p1)) {
				continue;
			} else {
				peoples[p2]['subscribers'].push(p1);
				peoples[p1]['fowolls']++;
			}
		}
	}
	let winner = Object.keys(peoples).sort((a, b) => {
		let res = peoples[b]['subscribers'].length - peoples[a]['subscribers'].length;
		if (res == 0) {
			res = peoples[b]['fowolls'] - peoples[a]['fowolls'];
		}
		return res;
	})[0];
	console.log(winner);
	for (let i = 0; i < peoples[winner]['subscribers'].length; i++) {
		console.log((i + 1) + '. ' + peoples[winner]['subscribers'][i]);
	}
}



