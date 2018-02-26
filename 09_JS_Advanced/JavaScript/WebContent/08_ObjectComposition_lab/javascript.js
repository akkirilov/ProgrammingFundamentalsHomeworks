// 01. Order Rectangles
//console.log(orderRectangles([[1,20],[20,1],[5,3],[5,3]]));
function orderRectangles(matrix) {
	let rectangles = [];
	for (let i = 0; i < matrix.length; i++) {
		rectangles.push({
			width: Number(matrix[i][0]),
			height: Number(matrix[i][1]),
			area: function() { 
				return this.width * this.height 
			},
			compareTo: function(other) {
				let diff = other.area() - this.area();
				if (diff === 0) {
					return other.width - this.width;
				} else {
					return diff;
				}
			} 
		});
	}
	rectangles.sort((a, b) => a.compareTo(b))
	return rectangles;
}

// 02. Fibonacci
//fibonacci();
function fibonacci() {
	let fibonator = (function() {
		let a = 0;
		let b = 1;
		return function() {
			let c = a + b;
			a = b;
			b = c;
			return a;
		}
	})();
	let res = [];
//	for (let i = 0; i < 5; i++) {
//		res.push(fibonator());
//	}
//	console.log(res);
	return fibonator;
}

// 03. List Processor
//listProcessor(['add hello', 'add again', 'remove hello', 'add again', 'print']);
function listProcessor(commands) {
	let processor = (function() {
		let list = [];
		return {
			add: function(str) {
				list.push(str);
			},
			remove: function (str) {
				list = list.filter(x => x !== str);
			},
			print: function() {
				console.log(list.toString());
			}
		};
	})();
	for (let command of commands) {
		let [c, v] = command.split(/\s+/);
		processor[c](v);
	}
}

// 04. Object Inheritance
//objectInheritance(['create c1',
//	'create c2 inherit c1',
//	'set c1 color red',
//	'set c2 model new',
//	'print c1',
//	'print c2']);
function objectInheritance(commands) {
	let processor = (function () {
		let cars = {};
		function createCar(name) {
			let car = { name };
			car.toString = function() {
				let res = [];
				for (let k in this) {
					if (k !== 'toString' && k !== 'name') {
						res.push(k + ':' + this[k]);
					}
				}
				return res.join(', ');
			}
			return car;
		}
		return {
			create: function (name, action, father) {
				let car;
				if (!action) {
					car = createCar(name);
				} else {
					car = Object.create(cars[father]);
					car['name'] = name;
				}
				cars[name] = car;
			},
			set: function(name, key, value) {
				cars[name][key] = value;
			},
			print: function(name) {
				console.log(cars[name].toString());
			}
		};
	})();
	for (let command of commands) {
		let [c, name, key, value] = command.split(/\s+/);
		processor[c](name, key, value);
	}
}

// 05. Sum
function sumProcessor() {
	let s1 = 0;
	let s2 = 0; 
	let res = 0;
	return {
		init: function(selector1, selector2, selector3) {
			s1 = $(selector1);
			s2 = $(selector2);
			res = $(selector3);
			$('#sumButton').on('click', this.add);
			$('#subtractButton').on('click', this.subtract);
		},
		add: function() {
			if (s1.val() != '' && s2.val() !== '') {
				res.val(Number(s1.val()) + Number(s2.val()));
			}
		},
		subtract: function() {
			if (s1.val() != '' && s2.val() !== '') {
				res.val(Number(s1.val()) - Number(s2.val()));
			}
		}
	}
}

