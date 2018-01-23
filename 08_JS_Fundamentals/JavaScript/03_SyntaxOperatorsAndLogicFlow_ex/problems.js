// 01. Hello JavaScript!
function helloJavaScript(name) {
	console.log(`Hello, ${name}, I am JavaScript!`);
}

// 02. Area and Perimeter
function areaAndPerimeter(sideA, sideB) {
	let area = sideA * sideB;
	let perimeter = (sideA * 2) + (sideB * 2);
	console.log(area);
	console.log(perimeter);
}

// 03. Distance over Time
function distanceOverTime(params) {
	let firstSpeed = params[0];
	let secondSpeed = params[1];
	let time = params[2];
	let firstDistance = firstSpeed * time;
	let secondDistance = secondSpeed * time;
	let distance = Math.abs(firstDistance - secondDistance) / (3600 / 1000);
	console.log(distance);
}

// 04. Distance in 3D
function distanceiIn3D(params) {
	let xA = params[0];
	let yA = params[1];
	let zA = params[2];
	let xB = params[3];
	let yB = params[4];
	let zB = params[5];
	let distance = Math.sqrt(Math.pow((xA - xB), 2) + Math.pow((yA - yB), 2) + Math.pow((zA - zB), 2));
	console.log(distance);
}

// 05. Grads to Degrees
function gradsToDegrees(grads) {
	grads = grads % 400;
	if (grads < 0) {
		grads = 400 - Math.abs(grads);
	}
	console.log(grads * 0.9);
}

// 06. Compound Interest
function compoundInterest(params) {
	let principalSum = params[0];
	let interestRate = params[1];
	let compoundingPeriod = params[2];
	let totalTimespan = params[3];
	let frequency = 12 / compoundingPeriod;
	let totalAccumulatedValue = principalSum
	* (Math.pow(1 + (interestRate / (100 * frequency)), (frequency * totalTimespan)));
	console.log(totalAccumulatedValue.toFixed(2));
}

// 07. Rounding
function rounding(params) {
	let number = params[0];
	let precision = params[1];
	if (precision > 15) {
		precision = 15;
	}
	number = Number(number).toFixed(precision);
	console.log(Number(number));
}

// 08. Imperial Units
function imperialUnits(inches) {
	let foots = Math.floor(inches / 12);
	inches = inches % 12;
	console.log(`${foots}'-${inches}"`);
}

// 09. Now Playing
function nowPlaying(params) {
	let trackName = params[0];
	let artistName = params[1];
	let duration = params[2];
	console.log(`Now Playing: ${artistName} - ${trackName} [${duration}]`);
}

// 10. Compose Tag
function composeTag(params) {
	let fileLocation = params[0];
	let alternateText = params[1];
	console.log(`<img src="${fileLocation}" alt="${alternateText}">`);
}

// 11. Binary to Decimal
function binaryToDecimal(binary) {
	var digit = Number.parseInt(binary, 2);
	console.log(digit);
}

// 12. Assign Properties
function assignProperties(params) {
	let object = {};
	object[params[0]] = params[1];
	object[params[2]] = params[3];
	object[params[4]] = params[5];
	console.log(object);
}

// 13. Last Month
function lastMonth(params) {
	let month = params[1];
	let year = params[2];
	let currDate = new Date(year + "-" + month + "-1");
	let lastMonthLastDate = new Date(currDate.getTime() - (60 * 60 * 24));
	console.log(lastMonthLastDate.getDate());
}

// 14. Biggest of 3 Numbers
function biggestOfThreeNumbers(params) {
	let biggestNum = Number.MIN_SAFE_INTEGER;
	for (let i = 0; i < params.length; i++) {
		if (params[i] > biggestNum) {
			biggestNum = params[i];
		}
	}
	console.log(biggestNum);
}

// 15. Point in Rectangle
function isPointInRectangle(params) {
	let x = params[0];
	let y = params[1];
	let xMin = params[2];
	let xMax = params[3];
	let yMin = params[4];
	let yMax = params[5];

	if (x >= xMin && x <= xMax && y >= yMin && y <= yMax) {
		console.log("inside");
	} else {
		console.log("outside");
	}
}

// 16. Odd Numbers 1 to N
function oddNumsToN(num) {
	for (let i = 1; i <= num; i += 2) {
		console.log(i);
	}
}

// 17. Triangle of Dollars
function triangleOfDollars(count) {
	let spChar = '$';
	for (let i = 1; i <= count; i++) {
		console.log(Array(i + 1).join(spChar));
	}

}

// 18. Movie Prices
function moviePrices(params) {
	let title = String(params[0]).toLowerCase();
	let day = String(params[1]).toLowerCase();
	let res = "error";

	if (title === "the godfather") {
		switch (day) {
		case "monday":
			res = 12;
			break;
		case "tuesday":
			res = 10;
			break;
		case "wednesday":
			res = 15;
			break;
		case "thursday":
			res = 12.50;
			break;
		case "friday":
			res = 15;
			break;
		case "saturday":
			res = 25;
			break;
		case "sunday":
			res = 30;
			break;
		default:
			break;
		}
	} else if (title === "schindler's list") {
		switch (day) {
		case "monday":
		case "tuesday":
		case "wednesday":
		case "thursday":
		case "friday":
			res = 8.50;
			break;
		case "saturday":
		case "sunday":
			res = 15;
			break;
		default:
			break;
		}
	} else if (title === "casablanca") {
		switch (day) {
		case "monday":
		case "tuesday":
		case "wednesday":
		case "thursday":
		case "friday":
			res = 8;
			break;
		case "saturday":
		case "sunday":
			res = 10;
			break;
		default:
			break;
		}
	} else if (title === "the wizard of oz") {
		switch (day) {
		case "monday":
		case "tuesday":
		case "wednesday":
		case "thursday":
		case "friday":
			res = 10;
			break;
		case "saturday":
		case "sunday":
			res = 15;
			break;
		default:
			break;
		}
	}

	console.log(res);
}

// 19. Quadratic Equation
function quadraticEquation(a, b, c) {
	let d = (b * b) - (4 * a * c);
	if (d === 0) {
		console.log(-b / (2 * a));
	} else if (d > 0) {
		let x1 = (-b + Math.sqrt(d)) / (2 * a);
		let x2 = (-b - Math.sqrt(d)) / (2 * a);
		console.log(Math.min(x1, x2));
		console.log(Math.max(x1, x2));
	} else {
		console.log("No");
	}
}

// 20. Multiplication Table
function multiplicationTable(count) {
	let res = '<table border="1">\n';
	for (let row = 0; row <= count; row++) {
		res += '  <tr>';
		for (let col = 0; col <= count; col++) {
			if (col === 0) {
				if (row === 0) {
					res += '<th>x</th>';
				} else {
					res += '<th>' + row + '</th>';
				}
			} else {
				if (row === 0) {
					res += '<th>' + col + '</th>'
				} else {
					res += '<td>' + (row * col) + '</td>';
				}
			}
		}
		res += '</tr>\n';
	}
	res += '</table>';
	console.log(res);
}

// 21. Figure of 4 Squares
function figuresOfFourSquares(n) {
	let rows = n;
	if (rows % 2 === 0) {
		rows--;
	}
	let middleRow = Math.floor(rows / 2);
	let timesToRepeat = n - 2;
	for (let row = 0; row < rows; row++) {
		if (row == 0 || row == middleRow || row == rows - 1) {
			console.log('+' + '-'.repeat(timesToRepeat) + '+' + '-'.repeat(timesToRepeat) + '+');
		} else {
			console.log('|' + ' '.repeat(timesToRepeat) + '|' + ' '.repeat(timesToRepeat) + '|');
		}
	}
}

//helloJavaScript("Pesho");
//areaAndPerimeter(2.5, 3.14);
//distanceOverTime([0, 60, 3600]);
//distanceiIn3D([1, 1, 0, 5, 4, 0]);
//gradsToDegrees(-50);
//compoundInterest([1500, 4.3, 3, 6]);
//rounding([ 3.1415926535897932384626433832795, 2 ]);
//imperialUnits(55);
//nowPlaying(['Number One', 'Nelly', '4:09']);
//composeTag(['smiley.gif', 'Smiley Face']);
//binaryToDecimal('11110000');
//assignProperties(['name', 'Pesho', 'age', '23', 'gender', 'male']);
//lastMonth([17, 3, 2002]);
//biggestOfThreeNumbers([-20, -30, -10]);
//isPointInRectangle([8, -1, 2, 12, -3, 3]);
//oddNumsToN(5);
//triangleOfDollars(5);
//moviePrices(['The Godfather', 'Friday']);
//quadraticEquation(6, 11, -35);
//multiplicationTable(5);
//figuresOfFourSquares(4);
