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

// 04. Students, Courses, Grades
//students(['Peter Nikolov | PHP  | 5.50 | 8',
//	'Maria Ivanova | Java | 5.83 | 7',
//	'Ivan Petrov   | PHP  | 3.00 | 2',
//	'Ivan Petrov   | C#   | 3.00 | 2',
//	'Peter Nikolov | C#   | 5.50 | 8',
//	'Maria Ivanova | C#   | 5.83 | 7',
//	'Ivan Petrov   | C#   | 4.12 | 5',
//	'Ivan Petrov   | PHP  | 3.10 | 2',
//	'Peter Nikolov | Java | 6.00 | 9']);
students(['Milen Georgiev|PHP|2.02|2',
	'Ivan Petrov | C# Basics | 3.20 | 22',
	'Peter Nikolov | C# | 5.522 | 18',
	'Maria Kirova | C# Basics | 5.40 | 4.5',
	'Stanislav Peev | C# | 4.012 | 15',
	'Ivan Petrov |    PHP Basics     |     5.120 |6',
	'Ivan Goranov | SQL | 5.926 | 12',
	'Todor Kirov | Databases | 5.50 |0.0000',
	'Maria Ivanova | Java | 5.83 | 37',
	'Milena Ivanova |    C# |   1.823 | 4.5',
	'Stanislav Peev   |    C#|   4.122    |    15   ',
	'Kiril Petrov |PHP| 5.10 | 6',
	'Ivan Petrov|SQL|5.926|3',
	'Peter Nikolov   |    Java  |   5.9996    |    9   ',
	'Stefan Nikolov | Java | 4.00 | 9.5',
	'Ivan Goranov | SQL | 5.926 | 12.5',
	'Todor Kirov | Databases | 5.150 |0.0000',
	'Kiril Ivanov | Java | 5.083 | 327',
	'Diana Ivanova |    C# |   1.823 | 4',
	'Stanislav Peev   |    C#|   4.122    |    15   ',
	'Kiril Petrov |PHP| 5.10 | 6']);
function students(arr) {
	let res = {};
	for (let e of arr) {
		let [name, course, grade, visits] = e.split(/\s*\|\s*/).filter(x => x !== '');
		if (res[course]) {
			res[course]['avgGrade'].push(Number(grade));
			res[course]['avgVisits'].push(Number(visits));
			if (res[course]['students'].indexOf(name) < 0) {
				res[course]['students'].push(name);
			}
		} else {
			res[course] = {};
			res[course]['avgGrade'] = [Number(grade)];
			res[course]['avgVisits'] = [Number(visits)];
			res[course]['students'] = [name];
		}
	}
	let sortedCourses = {};
	let coursesKeys = Object.keys(res).sort();
	for (let ck of coursesKeys) {
		sortedCourses[ck] = {};
		sortedCourses[ck]['avgGrade'] = Number((res[ck]['avgGrade'].reduce((a, b) => a + b) / res[ck]['avgGrade'].length).toFixed(2).toString());
		sortedCourses[ck]['avgVisits'] = Number((res[ck]['avgVisits'].reduce((a, b) => a + b) / res[ck]['avgVisits'].length).toFixed(2).toString());
		sortedCourses[ck]['students'] = res[ck]['students'].sort();
	}
	console.log(JSON.stringify(sortedCourses).replace(',"undefined":{"avgGrade":null,"avgVisits":null,"students":[null]}', '')+'\n');
}
