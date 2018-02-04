// 01. Prices Trends
//pricesTrends([36.333, 36.5, 37.019, 35.4, 35, 35.001, 36.225]);
function pricesTrends(arr) {
	arr = arr.filter(x => x !== '').map(x => Number(x));
	let res = '<table>\n<tr><th>Price</th><th>Trend</th></tr>\n';
	let last = arr[0];
	for (let e of arr) {
		res += '<tr><td>' + e.toFixed(2) + '</td><td><img src="' + getTrend(last, e) + '"/></td></td>\n';
		last = e;
	}
	res += '</table>';
	console.log(res);

	function getTrend(last, current) {
		let trend = current.toFixed(2) - last.toFixed(2);
    	if (trend == 0) {
    		return 'fixed.png';
    	} else if (trend > 0) {
    		return 'up.png';
    	} else {
    		return 'down.png';
    	}
    }
}

// 02. Tetris Figures
//tetrisFigures(['--o--o-', '--oo-oo', 'ooo-oo-', '-ooooo-', '---oo--']);
function tetrisFigures(arr) {
	let res = {"I":0,"L":0,"J":0,"O":0,"Z":0,"S":0,"T":0};
	let field = [];
	for (let e of arr) {
		field.push(e.split(''));
	}
	res["I"] = checkI(field);
	res["L"] = checkL(field);
	res["J"] = checkJ(field);
	res["O"] = checkO(field);
	res["Z"] = checkZ(field);
	res["S"] = checkS(field);
	res["T"] = checkT(field);
	console.log(JSON.stringify(res));
	
	function checkI(field) {
		let res = 0;
		for (let r = 0; r <= field.length - 4; r++) {
			for (let c = 0; c < field[r].length; c++) {
				if (field[r][c] == 'o'
					&& field[r + 1][c] == 'o'
					&& field[r + 2][c] == 'o'
					&& field[r + 3][c] == 'o') {
					res++;
				}
			}
		}
		return res;
	}
	function checkL(field) {
		let res = 0;
		for (let r = 0; r <= field.length - 3; r++) {
			for (let c = 0; c < field[r].length - 1; c++) {
				if (field[r][c] == 'o'
					&& field[r + 1][c] == 'o'
					&& field[r + 2][c] == 'o'
					&& field[r + 2][c + 1] == 'o') {
					res++;
				}
			}
		}
		return res;
	}
	function checkJ(field) {
		let res = 0;
		for (let r = 0; r <= field.length - 3; r++) {
			for (let c = 1; c < field[r].length; c++) {
				if (field[r][c] == 'o'
					&& field[r + 1][c] == 'o'
					&& field[r + 2][c] == 'o'
					&& field[r + 2][c - 1] == 'o') {
					res++;
				}
			}
		}
		return res;
	}
	function checkO(field) {
		let res = 0;
		for (let r = 0; r <= field.length - 2; r++) {
			for (let c = 0; c < field[r].length - 1; c++) {
				if (field[r][c] == 'o'
					&& field[r][c + 1] == 'o'
					&& field[r + 1][c] == 'o'
					&& field[r + 1][c + 1] == 'o') {
					res++;
				}
			}
		}
		return res;
	}
	function checkZ(field) {
		let res = 0;
		for (let r = 0; r <= field.length - 2; r++) {
			for (let c = 0; c < field[r].length - 2; c++) {
				if (field[r][c] == 'o'
					&& field[r][c + 1] == 'o'
					&& field[r + 1][c + 1] == 'o'
					&& field[r + 1][c + 2] == 'o') {
					res++;
				}
			}
		}
		return res;
	}
	function checkS(field) {
		let res = 0;
		for (let r = 0; r <= field.length - 2; r++) {
			for (let c = 1; c < field[r].length - 1; c++) {
				if (field[r][c] == 'o'
					&& field[r][c + 1] == 'o'
					&& field[r + 1][c] == 'o'
					&& field[r + 1][c - 1] == 'o') {
					res++;
				}
			}
		}
		return res;
	}
	function checkT(field) {
		let res = 0;
		for (let r = 0; r <= field.length - 2; r++) {
			for (let c = 0; c < field[r].length - 2; c++) {
				if (field[r][c] == 'o'
					&& field[r][c + 1] == 'o'
					&& field[r][c + 2] == 'o'
					&& field[r + 1][c + 1] == 'o') {
					res++;
				}
			}
		}
		return res;
	}
}

// 03. Biggest Table Row
//biggestTableRow(['<table>',
//'<tr><th>Town</th><th>Store1</th><th>Store2</th><th>Store3</th></tr>',
//'<tr><td>Sofia</td><td>26.2</td><td>8.20</td><td>-</td></tr>',
//'<tr><td>Varna</td><td>11.2</td><td>18.00</td><td>36.10</td></tr>',
//'<tr><td>Plovdiv</td><td>17.2</td><td>12.3</td><td>6.4</td></tr>',
//'<tr><td>Bourgas</td><td>-</td><td>24.3</td><td>-</td></tr>',
//'</table>']);
function biggestTableRow(arr) {
	let lines = [];
	let maxSum = Number.NEGATIVE_INFINITY;
	for (let e of arr) {
		let pattern = /.+<td>\s*([\d\.-]+)\s*<\/td>\s*<td>\s*([\d\.-]+)\s*<\/td>\s*<td>\s*([\d\.-]+).+/g;
		let match = pattern.exec(e);
		if (!match) {
			continue;
		}
		let sum = 0;
		let nums = [];
		for (let m = 1; m < match.length; m++) {
			let tempNumber = Number(match[m]);
			if (!Number.isNaN(tempNumber)) {
				sum += tempNumber;
				nums.push(match[m]);
			}
		}
		if (nums.length > 0 && !lines[sum]) {
			lines[sum] = nums;
			if (sum > maxSum) {
				maxSum = sum;
			}
		}
	}
	if (maxSum == Number.NEGATIVE_INFINITY) {
		console.log('no data');
    } else {
    	console.log(maxSum + ' = ' + lines[maxSum].join(' + '));
    }
}
