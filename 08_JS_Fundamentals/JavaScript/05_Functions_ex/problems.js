// 01. Inside Volume
function insideTheBox(arr) {
	let xMin = 0;
	let yMin = 0;
	let zMin = 0;
	let xMax = 50;
	let yMax = 80;
	let zMax = 50;

	for (let i = 0; i < arr.length - 2; i += 3) {
		let x = arr[i];
		let y = arr[i + 1];
		let z = arr[i + 2];
		if (x >= xMin && x <= xMax && y >= yMin && y <= yMax && z >= zMin && z <= zMax) {
			console.log("inside");
		} else {
			console.log("outside");
		}
	}
}

// 02. Road Radar
function roadRadar(arr) {
	let speed = arr[0];
	let zone = arr[1];
	let limit = getLimit(zone);
	let diff = speed - limit;
	if (diff > 0) {
		if (diff <= 20) {
			console.log("speeding");
		} else if (diff <= 40) {
			console.log("excessive speeding");
		} else {
			console.log("reckless driving");
		}
	}

	function getLimit(zone) {
		switch (zone) {
		case 'city':
			return 50;
			break;
		case 'residential':
			return 20;
			break;
		case 'motorway':
			return 130;
			break;
		case 'interstate':
			return 90;
			break;
		default:
			break;
		}
	}
}

// 03. Template Format
function templateFormat(arr) {
	let res = '<?xml version="1.0" encoding="UTF-8"?>\n<quiz>\n';
	for (let i = 0; i < arr.length - 1; i += 2) {
		let q = arr[i];
		let a = arr[i + 1];
		res += '  <question>\n    ' + q + '\n  </question>\n';
		res += '  <answer>\n    ' + a + '\n  </answer>\n';
	}
	res += '</quiz>';
	console.log(res);
}

// 04. Cooking by Numbers
function cookingByNumbers(arr) {
	let num = arr.shift();
	for (let i = 0; i < arr.length; i++) {
		num = perform(num, arr[i]);
		console.log(num);
	}
	
	function perform(num, operation) {
		switch (operation) {
		case 'chop':
			return num / 2;
		case 'dice':
			return Math.sqrt(num);
		case 'spice':
			return ++num;
		case 'bake':
			return num * 3;
		case 'fillet':
			return num * 0.8;
		default:
			break;
		}
	}
}

// 05. Modify Average
function modifyAverage(num) {
	let avg = countDigitAvarage(num);
	while (avg <= 5) {
		num += '9';
		avg = countDigitAvarage(num);
	}
	console.log(num);
	
	function countDigitAvarage(num) {
		let sum = 0;
		num = String(num);
		for (let i = 0; i < num.length; i++) {
			sum += Number(num[i]);
		}
		return sum / num.length;
    }
}

// 06. Validity Checker
function validityChecker(arr) {
	let xA = arr[0]; 
	let yA = arr[1];
	let xB = arr[2];
	let yB = arr[3];
	
	console.log(isValid(xA, yA, 0, 0));
	console.log(isValid(xB, yB, 0, 0));
	console.log(isValid(xA, yA, xB, yB));
	
	function isValid(xA, yA, xB, yB) {
		let res = Math.sqrt(Math.pow((xA - xB), 2) + Math.pow((yA - yB), 2));
		let msg = `{${xA}, ${yA}} to {${xB}, ${yB}} is `;
		if (res === Math.floor(res)) {
			msg +='valid';
		} else {
			msg += 'invalid';
		}
		return msg;
	}
}

//07. Treasure Locator
function treasureLocator(arr) {
	let tuvaluXa = 1;
	let tuvaluYa = 3;
	let tuvaluXb = 3;
	let tuvaluYb = 1;
	let tongaXa = 0;
	let tongaYa = 8;
	let tongaXb = 2;
	let tongaYb = 6;
	let samoaXa = 5;
	let samoaYa = 6;
	let samoaXb = 7;
	let samoaYb = 3;
	let tokelauXa = 8;
	let tokelauYa = 1;
	let tokelauXb = 9;
	let tokelauYb = 0;
	let cookXa = 4;
	let cookYa = 8;
	let cookXb = 9;
	let cookYb = 7;
	
	for (var i = 0; i < arr.length - 1; i+=2) {
		checkPoint(arr[i], arr[i + 1]);
	}
	
	function checkPoint(x, y) {
		if (x >= tuvaluXa && x <= tuvaluXb && y <= tuvaluYa && y >= tuvaluYb) {
			console.log("Tuvalu");
		} else if (x >= tongaXa && x <= tongaXb && y <= tongaYa && y >= tongaYb) {
			console.log("Tonga");
		} else if (x >= samoaXa && x <= samoaXb && y <= samoaYa && y >= samoaYb) {
			console.log("Samoa");
		} else if (x >= tokelauXa && x <= tokelauXb && y <= tokelauYa && y >= tokelauYb) {
			console.log("Tokelau");
		} else if (x >= cookXa && x <= cookXb && y <= cookYa && y >= cookYb) {
			console.log("Cook");
		} else {
			console.log("On the bottom of the ocean");
		}
	}
}

// 08. Trip Length
function tripLength() {
	
}


//insideTheBox([13.1, 50, 31.5, 50, 80, 50, -5, 18, 43]);
//roadRadar([21, 'residential']);
//templateFormat([ 'a', 'b' ]);
//cookingByNumbers([9, 'dice', 'spice', 'chop', 'bake', 'fillet']);
//modifyAverage('101');
//validityChecker([3, 0, 0, 4]);
treasureLocator([4, 2, 1.5, 6.5, 1, 3]);
