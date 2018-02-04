// 01. Double Rakiya Numbers
//doubleRakiyaNumbers([999999910,1000000000]);
function doubleRakiyaNumbers(arr) {
	let [start, end] = [ arr[0], arr[1] ];
	console.log('<ul>');
	for (let i = start; i <= end; i++) {
		if (isRakiyaNumber(i)) {
			console.log("<li><span class='rakiya'>" + i + "</span><a href=\"view.php?id=" + i + ">View</a></li>");
		} else {
			console.log("<li><span class='num'>" + i + "</span></li>");
		}

	}
	console.log('</ul>');
	
	function isRakiyaNumber(num) {
    	let numStr = String(num);
    	if (numStr.length < 4) {
    		return false;
    	}
    	for (let i = 0; i < numStr.length - 1; i++) {
    		for (let j = i + 2; j < numStr.length - 1; j++) {
    			if ((numStr[i] + numStr[i + 1]) == (numStr[j] + numStr[j + 1])) {
    				return true;
    			}
    		}
		}
		return false;
    }
}

// 02. String Matrix Rotation
//stringMatrixRotation(['Rotate(720)',
//	'js',
//	'exam']);
function stringMatrixRotation(arr) {
	let degree = Number(arr.shift().replace(/Rotate\(|\)/g, '')) % 360;
	let rotate = degree;
	if (degree == 0) {
		for (let i = 0; i < arr.length; i++) {
			console.log(arr[i]);
		}
    }
	let arrMaxRowLength = 0;
	for (let i = 0; i < arr.length; i++) {
		if (arr[i].length > arrMaxRowLength) {
			arrMaxRowLength = arr[i].length;
		}
	}

	let res = [];
	for (let i = 0; i < arr.length; i++) {
		res.push(arr[i].split(''));
		while (res[i].length < arrMaxRowLength) {
			res[i].push('');
		}
	}
	let maxR = 0;
	let maxC = res.length;
	if (degree == 180) {
		maxR = res.length;
		maxC = 0;
		for (let mr = 0; mr < res.length; mr++) {
			if (res[mr].length > maxC) {
				maxC = res[mr].length;
			}
		}
    } else {
    	for (let mr = 0; mr < res.length; mr++) {
			if (res[mr].length > maxR) {
				maxR = res[mr].length;
			}
		}
    }
	let out = [];
	for(let s = 0; s < maxR; s++) {
		out[s] = new Array(maxC);
	}
	if (degree == 90) {
		for (let r = 0; r < maxR; r++) {
			for (let c = 0; c < maxC; c++) {
				if (res[maxC - 1 - c][r]) {
					out[r][c] = res[maxC - 1 - c][r];
				} else {
					out[r][c] = ' ';
				}
			}
		}
    } else if (degree == 180) {
    	for (let r = 0; r < maxR; r++) {
			for (let c = 0; c < maxC; c++) {
				if (res[res.length - 1 - r][res[res.length - 1 - r].length - 1 - c]) {
					out[r][c] = res[res.length - 1 - r][res[res.length - 1 - r].length - 1 - c];
				} else {
					out[r][c] = ' ';
				}
			}
		}
    } else if (degree == 270) {
    	for (let r = 0; r < maxR; r++) {
			for (let c = 0; c < maxC; c++) {
				if (res[c][res[c].length - 1 - r]) {
					out[r][c] = res[c][res[c].length - 1 - r];
				} else {
					out[r][c] = ' ';
				}
			}
		}
    } 
	for (let i = 0; i < out.length; i++) {
		console.log(out[i].join(''));
	}
}

// 03. Sort Table
//sortTable(['<table>',
//	'<tr><th>Product</th><th>Price</th><th>Votes</th></tr>',
//	'<tr><td>Vodka Finlandia 1 l</td><td>19.35</td><td>+12</td></tr>',
//	'<tr><td>Ariana Radler 0.5 l</td><td>1.19</td><td>+33</td></tr>',
//	'<tr><td>Laptop HP 250 G2</td><td>629</td><td>+1</td></tr>',
//	'<tr><td>Kamenitza Grapefruit 1 l</td><td>1.85</td><td>+7</td></tr>',
//	'<tr><td>Ariana Grapefruit 1.5 l</td><td>1.85</td><td>+7</td></tr>',
//	'<tr><td>Coffee Davidoff 250 gr.</td><td>11.99</td><td>+11</td></tr>',
//	'</table>']);
function sortTable(arr) {
	console.log(arr.shift());
	console.log(arr.shift());
	let endLine = arr.pop();
	
	let res = [];
	for (let e of arr) {
		let pattern = /<td>.*?<\/td><td>(.*?)<\/td>/g;
		let match = pattern.exec(e);
		let tPrice = Number(match[1]);
		res.push({ data:e, price:tPrice });
	}
	res.sort((a, b) => {
			let res = a.price - b.price;
			if (res == 0) {
				res = a.data.localeCompare(b.data);
			}
			return res;
		}).forEach(x => console.log(x.data));
	console.log(endLine);
}

// 04. Soccer Results
soccerResults(['Germany / Argentina: 1-0',
	'Brazil / Netherlands: 0-3',
	'Netherlands / Argentina: 0-0',
	'Brazil / Germany: 1-7',
	'Argentina / Belgium: 1-0',
	'Netherlands / Costa Rica: 0-0',
	'France / Germany: 0-1',
	'Brazil / Colombia: 2-1']);
function soccerResults(arr) {
	let teams = {};
	for (let e of arr) {
		let pattern = /\s*([a-zA-Z0-9]+)\s*\/\s*([a-zA-Z0-9\s]+)s*\:\s*(\d+)s*-\s*(\d+)/g;
		let match = pattern.exec(e);
		let tempTeams = [];
		tempTeams[match[1]] = { goalsScored:Number(match[3]), goalsConceded:Number(match[4]), matchesPlayedWith:[match[2]] };
		tempTeams[match[2]] = { goalsScored:Number(match[4]), goalsConceded:Number(match[3]), matchesPlayedWith:[match[1]] };
		for (let t in tempTeams) {
			if (teams[t]) {
				teams[t]['goalsScored'] += tempTeams[t]['goalsScored'];
				teams[t]['goalsConceded'] += tempTeams[t]['goalsConceded'];
				if (teams[t]['matchesPlayedWith'].indexOf(tempTeams[t]['matchesPlayedWith'][0]) < 0) {
					teams[t]['matchesPlayedWith'].push(tempTeams[t]['matchesPlayedWith'][0]);
				}
			} else {
				teams[t] = tempTeams[t];
			}
		}
	}
	let orderedTeams = {};
	let teamsKeys = Object.keys(teams).sort();
	for (let tc of teamsKeys) {
		orderedTeams[tc] = teams[tc];
		orderedTeams[tc]['matchesPlayedWith'] = teams[tc]['matchesPlayedWith'].sort();
	}
	console.log(JSON.stringify(orderedTeams));
}