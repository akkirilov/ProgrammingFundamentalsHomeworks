// 01. Triangle of Stars
function triangleOfStars(n) {
	for (let i = 1; i <= n; i++) {
		printNStars(i);
	}
	for (let i = n - 1; i > 0; i--) {
		printNStars(i);
	}

	function printNStars(count) {
		console.log('*'.repeat(count));
	}
}

// 02. Square of Stars
function squareOfStars(n) {
	for (let i = 0; i < n; i++) {
		printNStars(n);
	}

	function printNStars(count) {
		console.log('* '.repeat(count));
	}
}

// 03. Palindrome
function isPalindrome(word) {
	let length = String(word).length / 2;
	for (let i = 0; i < length; i++) {
		if (word[i] !== word[word.length - 1 - i]) {
			return false;
		}
	}
	return true;
}

// 04. Day of Week
function dayOfWeek(day) {
	let days = [ 'Monday', 'Tuesday', 'Wednesday', 'Thursday', 'Friday', 'Saturday', 'Sunday' ];
	let index = days.indexOf(day);
	return index > -1 ? index + 1 : 'error';
}

// 05. Functional Calculator
function calculator(a, b, operator) {
	switch (operator) {
	case '+':
		console.log(a + b);
		break;
	case '-':
		console.log(a - b);
		break;
	case '*':
		console.log(a * b);
		break;
	case '/':
		console.log(a / b);
		break;
	default:
		break;
	}
}

// 06. Aggregate Elements
function aggregateElements(arr) {
	aggregate(arr, 0, (a, b) => a + b);
	aggregate(arr, 0, (a, b) => a + 1 / b);
	aggregate(arr, '', (a, b) => a + b);
	function aggregate(arr, initVal, func) {
		let val = initVal;
		for (let i = 0; i < arr.length; i++) {
			val = func(val, arr[i]);
		}
		console.log(val);
	}
}

// 07. Words Uppercase
function upperCaseWords(str) {
	let words = str.split(/\W+/g).filter(w => w != '');
	let res = words.join(", ");
	console.log(res.toUpperCase());
}

//triangleOfStars(5);
//squareOfStars(5);
//console.log(isPalindrome("aabaa"));
//console.log(dayOfWeek('Friday'));
//calculator(1, 2, '+');
//aggregateElements([1, 2, 3]);
//upperCaseWords("Hi, how are you?");

