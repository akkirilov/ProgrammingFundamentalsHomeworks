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


//insideTheBox([13.1, 50, 31.5, 50, 80, 50, -5, 18, 43]);
//roadRadar([21, 'residential']);
//templateFormat([ 'a', 'b' ]);
//cookingByNumbers([9, 'dice', 'spice', 'chop', 'bake', 'fillet']);
//modifyAverage('101');


