// 01. Array extension

(function () {
// let extendArr = Object.create(new Array);
	Array.prototype.last = function() {
		return this[this.length - 1];
	} 
	Array.prototype.skip = function(n) {
		return this.slice(n, this.length); 
	};
	Array.prototype.take = function(n) {
		return this.slice(0, n); 
	};
	Array.prototype.sum = function() {
		return this.reduce((a, b) => a + b); 
	};
	Array.prototype.average = function() {
		return this.sum() / this.length;
	};
// let extendArr = [1,2,3,4,5,6,7]
// console.log(extendArr.last());
// console.log(extendArr.skip(1));
// console.log(extendArr.sum(1));
// console.log(extendArr.take(3));
// console.log(extendArr.skip(1));
// console.log(extendArr.sum());
// console.log(extendArr.average());
})()

// 02. Construction Crew
// let c = constructionCrew({ weight: 80,
// experience: 1,
// bloodAlcoholLevel: 0,
// handsShaking: true });
// console.log(c.weight);
function constructionCrew(obj) {
	if (!obj.handsShaking) {
		return obj;
	}
	obj.bloodAlcoholLevel += (obj.experience * (obj.weight * 0.1)); 
	obj.handsShaking = false;
	return obj;
}

// 03. Car Factory
// let c = carFactory({ model: 'Opel Vectra',
// power: 110,
// color: 'grey',
// carriage: 'coupe',
// wheelsize: 18 }
// );
// console.log(c);
function carFactory(obj) {
	let car = {};
	car.model = obj.model;
	car.engine = createEngine(obj.power);
	car.carriage = { type: obj.carriage, color: obj.color };
	wheel = obj.wheelsize;
	if (wheel % 2 === 0) {
		wheel--;
	}
	car.wheels = [wheel, wheel, wheel, wheel];
	function createEngine(power) {
		let engine = {};
		if (power <= 90) {
			engine.power = 90;
			engine.volume = 1800;
		} else if (power <= 120) {
			engine.power = 120;
			engine.volume = 2400;
		} else {
			engine.power = 200;
			engine.volume = 3500;
		}
		return engine;
	}
	return car;
}

// 04. Extensible Object
// let o = extensibleObject();
// let c = {name: 'Pesho', getName: () => this.name};
// o.extend(c);
// console.log(o);
// console.log(o.__proto__);
function extensibleObject() {
	let myObj = {
		__proto__: { },
		extend: function (obj) {
			for (let p in obj) {
				if (obj[p] instanceof Function) {
					this.__proto__[p] = obj[p];
				} else {
					this[p] = obj[p];
				}
			}
		}
	}
	return myObj;
}

// 05. String extension
// let s = 'the quick brown fox jumps over the lazy';
// console.log(s.truncate(10));
(function() {
	String.prototype.ensureStart = function (s) {
		if (!this.startsWith(s)) {
			return new String(s + this).toString();
		}
		return this.toString();
	};
	String.prototype.ensureEnd = function (s) {
		if (!this.endsWith(s)) {
			return new String(this + s).toString();
		}
		return this.toString();
	};
	String.prototype.isEmpty = function () {
		return (this.length === 0);
	};
	String.prototype.truncate = function (n) {
		if (n >= this.toString().length) {
			return this.toString();
		} else {
			let tokens = this.toString().split(/\s+/);
			if (tokens.length > 1) {
				let i = 0;
				let res = tokens[i];
				while (res.length + 3 <= n && i < tokens.length - 1) {
					i++;
					res += (' ' + tokens[i]);
				}
				
				return res.slice(0, (res.length - tokens[i].length - 1)) + '...';
			} else {
				return str.slice(0, n - 3) + '...';
			}
		}
	};
	String.format = function() {
		let arr = [];
		for (let e in arguments) {
			arr.push(arguments[e]);
		}
		let str = arr.shift();
		let pattern = /(\{(\d+)\})/g;
		let match;
		while (match = pattern.exec(str)) {
			let i = Number(match[2]);
			if (arr[i] !== undefined) {
				str = str.replace(match[1], arr[i]);
			}
		}
		return str;
	}
})();

// 06. Sorted List
//let myList = sortedList();
//for (let i = 0; i < 10; i++) {
//    myList.add(i);
//}
//myList.remove(9);
//console.log(myList.size); // 9
//let expectedArray = [0,1,2,3,4,5,6,7,8];
//for (let i = 0; i < expectedArray.length; i++) {
//	if (myList.get(i) !== expectedArray[i]) {
//		console.log("Element wasn't removed");
//	}
//}
function sortedList() {
	let list = [];
	function sortAsc() {
		list.sort((a, b) => a - b);
	}
	return {
		add: function(el) {
			list.push(el);
			sortAsc();
			this.size++;
		},
		remove: function(index) {
			if (list[index] !== undefined) {
				list.splice(index, 1);
				this.size--;
			}
		},
		get: function(index) {
			return list[index];
		},
		size: list.length
	};
}

// 07. DOM Highlighter
function highlighter(selector) {
	let targetElement = $(selector);
	let deepestElement = targetElement;
	let maxDepth = 0;
	
	findDeepestElement(0, targetElement);
	highlightParents(maxDepth, deepestElement);
	
	function findDeepestElement(depth, currentElement) {
		if (depth > maxDepth) {
			maxDepth = depth;
			deepestElement = currentElement;
		}
		let children = currentElement.children();
		for (let c of children) {
			findDeepestElement(depth + 1, $(c));
		}
	}
	
	function highlightParents(depth, child) {
		if (depth < 0) {
			return;
		}
		child.addClass('highlight');
		highlightParents(depth - 1, $(child.parent()))
	}
}

// 08. Bug Tracker
function bugTracker() {
	let id = 0;
	let bugs = new Map();
	let reportNode;
	function print() {
		if (reportNode == undefined) {
			return;
		}
		reportNode.html('');
		let bugsKeys = Array.from(bugs.keys());
		for (let b of bugsKeys) {
			reportNode
				.append($('<div>')
					.attr('id', 'report_' + bugs.get(b).ID)
					.addClass('report')
					.append($('<div>')
						.addClass('body')
						.append($('<p>')
								.text(bugs.get(b).description)
						)
					).append($('<div>')
						.addClass('title')
						.append($('<span>')
							.addClass('author')
							.text('Submitted by: ' + bugs.get(b).author)
						).append($('<span>')
							.addClass('status')
							.text(bugs.get(b).status + ' | ' + bugs.get(b).severity)
					)
				)
			)
		}
	}
	return {
		report: function() {
			let bug = {
					ID: id++,
					author: '',
					description: '', 
					reproducible: false, 
					severity: 0,
					status: 'Open'
				};
			if (arguments.length > 0) {
				bug.author = arguments[0];
				bug.description = arguments[1];
				bug.reproducible = arguments[2];
				bug.severity = arguments[3];
			}
			bugs.set(bug.ID, bug);
			this.sort();
		},
		setStatus: function(id, newStatus) {
			if (bugs.has(id)) {
				
			}
			bugs.get(id).status = newStatus;
			$('#report_' + id + ' .status').text(newStatus + ' | ' + bugs.get(id).severity);
		},
		remove: function(id) {
			bugs.delete(id);
			this.sort();
		},
		sort: function(method) {
			let bugsKeys = Array.from(bugs.keys()).sort((a, b) => bugs.get(a).ID - bugs.get(b).ID);
			if (method === 'author') {
				bugsKeys = Array.from(bugs.keys()).sort((a, b) => bugs.get(a).author.localeCompare(bugs.get(b).author));
			} else if (method === 'severity') {
				bugsKeys = Array.from(bugs.keys()).sort((a, b) => bugs.get(a).severity - bugs.get(b).severity);
			}
			let sortedBugs = new Map();
			for (let k of bugsKeys) {
				sortedBugs.set(k, bugs.get(k));
			}
			bugs = sortedBugs;
			print();
		},
		output: function(selector) {
			reportNode = $(selector);
			this.sort();
		}
	}
}

