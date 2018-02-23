// 01. Sort Array
//sortArray([14, 7, 17, 6, 8], 'asc');
//sortArray([14, 7, 17, 6, 8], 'desc');
function sortArray(arr, arg) {
	function sort(func) {
		return arr.sort(func);
	}
	if (arg === 'asc') {
		return sort((a, b) => a - b);
	} else {
		return sort((a, b) => b - a);
	}
}

// 02. Argument Info
// argumentInfo({ name: 'bob'}, 3.333, 9.999);
function argumentInfo() {
	let summary = {};
	for (let a of arguments) {
		let type = typeof a;
		console.log(type + ': ' + a);
		if (summary[type]) {
			summary[type]++;
		} else {
			summary[type] = 1; 
		}
	}
	let types = [];
	for (let e in summary) {
		types.push([e, summary[e]]);
	}
	types.sort((a, b) => b[1] - a[1]).forEach(x => console.log(x[0] + ' = ' + x[1]));
}

// 03. Functional Sum
function functionalSum(startNum) {
	let sum = startNum;
	function add(n) {
		sum += Number(n);
		return add;
	}
	add.toString = function (){
		return sum;
	}
	return add;
}

// 04. Personal BMI
//console.log(personalBMI('Honey Boo Boo', 9, 57, 137));
function personalBMI(name, age, weight, height) {
	return (function () {
		let personalInfo = {
			age, 
			weight, 
			height
		}
		let bmi = Math.round(personalInfo.weight / ((personalInfo.height / 100) * (personalInfo.height / 100)));
		function getStatus(bmi) {
			if (bmi < 18.5) { 
				return 'underweight';
			} else if (bmi < 25) {
				return 'normal';
			} else if (bmi < 30) {
				return 'overweight';
			} else {
				return 'obese';
			}
		}
		let p = {
			name,
			personalInfo: personalInfo,
			BMI: bmi,
			status: getStatus(bmi)
		}
		if (p.status === 'obese') {
			p.recommendation = 'admission required';
		}
		return p;
	})();
}

// 05. Vector Math
//let r = vectorMath();
//console.log(r.dot([2, 3], [2, -1]))
function vectorMath() {
	return (function() {
		return {
			add: (v1, v2) => [(v1[0] + v2[0]), (v1[1] + v2[1])],
			multiply: (v1, m) => [(v1[0] * m), (v1[1] * m)],
			length: (v) => Math.sqrt((v[0] * v[0]) + (v[1] * v[1])),
			dot: (v1, v2) => ((v1[0] * v2[0]) + (v1[1] * v2[1])),
			cross: (v1, v2) => ((v1[0] * v2[1]) - (v1[1] * v2[0]))
		}
	})();
}

// 06. Breakfast Robot
//let r = breakfastRobot();
//console.log(r('restock flavour 50'))
//console.log(r('prepare coke 4'))
//console.log(r('report'))
function breakfastRobot() {
	return (function() {
		let elements = {
			protein: 0,
			carbohydrate: 0,
			fat: 0,
			flavour: 0
		}
		function checkAvailabillity(arr) {
			let res = 'Success';
			for (let i = 0; i < arr.length - 1; i += 2) {
				if (elements[arr[i]] < arr[i + 1]) {
					res = `Error: not enough ${arr[i]} in stock`;
					break;
				}
			}
			return res;
		}
		function prepareBreakfast(el, q) {
			q = Number(q);
			let res;
			switch (el) {
			case 'apple':
				res = checkAvailabillity(['carbohydrate', 1 * q, 'flavour', 2 * q]);
				if (res === 'Success') {
					elements.carbohydrate -= 1 * q;
					elements.flavour -= 2 * q;
				}
				return res;
			case 'coke':
				res = checkAvailabillity(['carbohydrate', 10 * q, 'flavour', 20 * q]);
				if (res === 'Success') {
					elements.carbohydrate -= 10 * q;
					elements.flavour -= 20 * q;
				}
				return res;
			case 'burger':
				res = checkAvailabillity(['carbohydrate', 5 * q, 'fat', 7 * q, 'flavour', 3 * q]);
				if (res === 'Success') {
					elements.carbohydrate -= 5 * q;
					elements.fat -= 7 * q;
					elements.flavour -= 3 * q;
				}
				return res;
			case 'omelet':
				res = checkAvailabillity(['protein', 5 * q, 'fat', 1 * q, 'flavour', 1 * q]);
				if (res === 'Success') {
					elements.protein -= 5 * q;
					elements.fat -= 1 * q;
					elements.flavour -= 1 * q;
				}
				return res;
			case 'cheverme':
				res = checkAvailabillity(['protein', 10 * q, 'carbohydrate', 10 * q, 'fat', 10 * q, 'flavour', 10 * q]);
				if (res === 'Success') {
					elements.protein -= 10 * q;
					elements.carbohydrate -= 10 * q;
					elements.fat -= 10 * q;
					elements.flavour -= 10 * q;
				}
				return res;
			default:
				return res;
			}
		}
		let robotCommands = {
			restock: (el, q) => {elements[el] += Number(q); return 'Success'},
			prepare: (el, q) => {return prepareBreakfast(el, q)},
			report: () => `protein=${elements.protein} carbohydrate=${elements.carbohydrate} fat=${elements.fat} flavour=${elements.flavour}`
		}
		return function(tokens) {
			let [c, el, q] = tokens.split(' ');
			return robotCommands[c](el, q)
		}
		
	})()
}

// 07. Monkey Patcher
//let forumPost = {
//		id: '1234',
//	    author: 'author name',
//	    content: 'these fields are irrelevant',
//	    upvotes: 4,
//	    downvotes: 5
//	};
//monkeyPatcher.call(forumPost, 'upvote');
//monkeyPatcher.call(forumPost, 'downvote');
//monkeyPatcher.call(forumPost, 'upvote');
//for (let i = 0; i < 38; i++) {
//	monkeyPatcher.call(forumPost, 'upvote');
//}
//monkeyPatcher.call(forumPost, 'downvote');
//forumPost.upvotes = 132;
//forumPost.downvotes = 68;
//forumPost.upvotes = 133;
//console.log(monkeyPatcher.call(forumPost, 'score'));
function monkeyPatcher(arg) {
	let commands = {
			upvote: () => this.upvotes++,
			downvote: () => this.downvotes++,
			score: () => {
				let status;
				let upvotes = this.upvotes;
				let downvotes = this.downvotes;
				let balance = upvotes - downvotes;
				let total = upvotes + downvotes;
				if (total > 10 && (upvotes / total) * 100 > 66) {
					status = 'hot';
				} else if (balance >= 0 && (upvotes > 100 || downvotes > 100)) {
					status = 'controversial';
				} else if (total < 10 || balance === 0) {
					status = 'new';
				} else if (balance < 0) {
					status = 'unpopular';
				} 
				if ((upvotes + downvotes) > 50) {
					let n = Math.ceil(Math.max(upvotes, downvotes) * 0.25);
					upvotes += n;
					downvotes += n;
				}
				return [upvotes, downvotes, balance, status];
			}
		}
	return commands[arg]();
}

// 08. Euclids Algorithm
//console.log(euclidsAlgorithm(6, 3));
function euclidsAlgorithm(n1, n2) {
	let divisor = 1;
	let length = Math.min(n1, n2);
	for (let i = 1; i <= length; i++) {
		if ((n1 % i) === 0 && 0 === (n2 % i)) {
			divisor = i;
		}
	}
	return divisor;
}

