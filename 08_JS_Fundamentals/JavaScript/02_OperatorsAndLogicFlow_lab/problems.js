//1. Multiply Numbers
function multiplyNumbers(a, b) {
	return (a * b);
}

// 2. Boxes and Bottles
function boxesAndBottles(bottles, boxCapacity) {
	let boxes = bottles / boxCapacity;
	if (bottles % boxCapacity !== 0) {
		boxes = Math.floor(boxes) + 1;
	}
	console.log(boxes);
}

// 3. Leap Year
function leapYear(year) {
	let res = "no";
	if ((year % 4 === 0 && year % 100 !== 0) || year % 400 === 0) {
		res = "yes";
	}
	console.log(res);
}

// 4. Circle Area
function circleArea(radius) {
	let res = Math.PI * radius * radius;
	console.log(res);
	console.log(res.toFixed(2));
}

// 5. Triangle Area
function triangleArea(a, b, c) {
	let sp = (a + b + c) / 2;
	let area = Math.sqrt(sp * (sp - a) * (sp - b) * (sp - c));
	return area;
}

// 6. Cone
function cone(radius, height) {
	let s = Math.sqrt(radius * radius + height * height);
	let volume = Math.PI * radius * radius * height / 3;
	let area = Math.PI * radius * (radius + s);
	console.log("volume = " + volume);
	console.log("area = " + area);
}

// 7. Odd / Even
function oddOrEven(num) {
	let res = "invalid";
	if (num % 2 === 0) {
		res = "even";
	} else if (Math.abs(num % 2) === 1) {
		res = "odd";
	}
	console.log(res);
}

// 8. Fruit or Vegetable
function fruitOrVegetable(name) {
	switch (name) {
	case "banana":
	case "apple":
	case "kiwi":
	case "cherry":
	case "lemon":
	case "grapes":
	case "peach":
		console.log("fruit");
		break;
	case "tomato":
	case "cucumber":
	case "pepper":
	case "onion":
	case "garlic":
	case "parsley":
		console.log("vegetable");
		break;
	default:
		console.log("unknown");
		break;
	}
}

// 9. Colorful Numbers
function colorfulNumbers(len) {
	let res = "<ul>\n";
	let color;
	for (var i = 1; i <= len; i++) {
		if (i % 2 === 0) {
			color = "blue";
		} else {
			color = "green";
		}
		res += `  <li><span style='color:${color}'>${i}</span></li>\n`;
	}
	res += "</ul>";
	return res;
}

// 10. Chessboard
function chessboard(len) {
	let res = `<div class="chessboard">\n`;
	let color;
	for (var r = 1; r <= len; r++) {
		res += "  <div>\n";
		if (r % 2 === 0) {
			color = "white";
		} else {
			color = "black";
		}
		for (var c = 1; c <= len; c++) {
			res += `   <span class="${color}"></span>\n`;
			if (color === "black") {
				color = "white";
			} else {
				color = "black";
			}
		}
		res += "  </div>\n";
	}
	res += "</div>";
	return res;
}

// 11. Binary Logarithm
function binaryLogarithm(nums) {
	for (let x of nums) {
		console.log(Math.log2(x));
	}
}

// 12. Prime Number Checker
function primeNumberChecker(num) {
	if (num < 2) {
		return false;
	}
	let length = Math.sqrt(num);
	for (var i = 2; i <= length; i++) {
		if (num % i === 0) {
			return false;
		}
	}
	return true;
}

// console.log(multiplyNumbers(2, 3));
// boxesAndBottles(14, 7);
// leapYear(2000);
// circleArea(5);
// console.log(triangleArea(2, 3.5, 4));
// cone(3, 5);
// oddOrEven(6.2);
// fruitOrVegetable("parsley");
// console.log(colorfulNumbers(10));
// console.log(chessboard(3));
// binaryLogarithm([1024, 1048576, 256, 1, 2]);
// console.log(primeNumberChecker(2));
