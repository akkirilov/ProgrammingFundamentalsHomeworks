// 01. Balloons
function balloons() {
	class Balloon {
		constructor(color, gasWeight) {
			this.color = color;
			this.gasWeight = gasWeight;
		}
	}
	
	class PartyBalloon extends Balloon {
		constructor(color, gasWeight, ribbonColor, ribbonLength) {
			super(color, gasWeight);
			this.ribbon = { color: ribbonColor, length: ribbonLength }
		}
		
		get ribbon() {
			return this._ribbon;
		}
		set ribbon(ribbon) {
			this._ribbon = ribbon;
		}
	}
	
	class BirthdayBalloon extends PartyBalloon {
		constructor(color, gasWeight, ribbonColor, ribbonLength, text) {
			super(color, gasWeight, ribbonColor, ribbonLength);
			this.text = text;
		}
		
		get text() {
			return this._text;
		}
		set text(text) {
			this._text = text;
		}
	}
	
	return { Balloon, PartyBalloon, BirthdayBalloon }
}
// let module01 = balloons();
// let b = new module01.Balloon('red', 5);
// let pb = new module01.PartyBalloon('red', 5, 'blue', 10);
// let bb = new module01.BirthdayBalloon('red', 5, 'blue', 10, '!!!HB!!!');
// console.log(b);
// console.log(pb.ribbon.color);
// console.log(bb.ribbon.color);

// 02. People
function people() {
	class Employee {
		constructor(name, age) {
			if (this.constructor.name === 'Employee') {
				throw new TypeError('Cannot instantiate directly.');
			}
			this.name = name;
			this.age = age;
			this.salary = 0;
			this.tasks = [];
		}
		
		work() {
			let task = this.tasks.shift();
			console.log(this.name + task);
			this.tasks.push(task);
		}
		collectSalary() {
			console.log(this.name + ' received ' + this.getSalary() + ' this month.');
		}
		getSalary() {
			return this.salary;
		}
	}
	
	class Junior extends Employee {
		constructor(name, age) {
			super(name, age);
			this.tasks.push(' is working on a simple task.');
		}
	}
	
	class Senior extends Employee {
		constructor(name, age) {
			super(name, age);
			this.tasks.push(' is working on a complicated task.');
			this.tasks.push(' is taking time off work.');
			this.tasks.push(' is supervising junior workers.');
		}
	}
	
	class Manager extends Employee {
		constructor(name, age) {
			super(name, age);
			this.dividend = 0;
			this.tasks.push(' scheduled a meeting.');
			this.tasks.push(' is preparing a quarterly report.');
		}
		
		getSalary() {
			return this.salary + this.dividend;
		}
	}
	
	return { Employee, Junior, Senior, Manager }
}
// let module02 = people();
// let m = new module02.Manager('Manager', 102);
// console.log(m.hasOwnProperty('salary'));
// m.salary = 3000;
// m.collectSalary();
// m.dividend = 500;
// m.collectSalary();
// console.log(m);

// 03. Posts
function posts() {
	class Post {
		constructor(title, content) {
			this.title = title;
			this.content = content;
		}
		
		toString() {
			return 'Post: ' + this.title
					+ '\nContent: ' + this.content;
		}
	}
	
	class SocialMediaPost extends Post {
		constructor(title, content, likes, dislikes) {
			super(title, content);
			this.likes = likes;
			this.dislikes = dislikes;
			this.comments = [];
		}
		
		addComment(comment) {
			this.comments.push(comment);
		}
		toString() {
			let res = super.toString()
					+ '\nRating: ' + (this.likes - this.dislikes);
			if (this.comments.length > 0) {
				res += '\nComments:\n';
				res += (this.comments.map(x => ' * ' + x).join('\n'));
			}
			return res;
		}		
	}
	
	class BlogPost extends Post {
		constructor(title, content, views) {
			super(title, content);
			this.views = views;
		}
		
		view() {
			this.views++;
			return this;
		}
		toString() {
			return super.toString()
				+ '\nViews: ' + this.views;
		}
	}
	
	return { Post, SocialMediaPost, BlogPost }
}
// let module03 = posts();
// let smc = new module03.SocialMediaPost('t', 'c', 51,50)
// smc.addComment('sasas');
// smc.addComment('sadsdsdssd');
// console.log(smc.toString());

// 04. Elemelons
function elemelons() {
	class Melon {
		constructor(weight, melonSort) {
			if (this.constructor.name === 'Melon') {
				throw new Error('Abstract class cannot be instantiated directly');
			}
			this.weight = weight;
			this.melonSort = melonSort;
			this.elementIndex = 0;
		}
		
		get elementIndex() {
			return this.weight * this.melonSort.length;
		}
		set elementIndex(elementIndex) {
			return this._elementIndex = elementIndex;
		}
		
		toString() {
			return 'Sort: ' + this.melonSort + '\nElement Index: ' + this.elementIndex;
		}
	}
	class Watermelon extends Melon {
		constructor(weight, melonSort) {
			super(weight, melonSort);
		}
		toString() {
			return 'Element: Water\n' + super.toString();
		}
	}
	class Firemelon extends Melon {
		constructor(weight, melonSort) {
			super(weight, melonSort);
		}
		toString() {
			return 'Element: Fire\n' + super.toString();
		}
	}
	class Earthmelon extends Melon {
		constructor(weight, melonSort) {
			super(weight, melonSort);
		}
		toString() {
			return 'Element: Earth\n' + super.toString();
		}
	}
	class Airmelon extends Melon {
		constructor(weight, melonSort) {
			super(weight, melonSort);
		}
		toString() {
			return 'Element: Air\n' + super.toString();
		}
	}
	
	class Melolemonmelon extends Watermelon {
		constructor(weight, melonSort) {
			super(weight, melonSort);
			this.element = 'Water';
			this.elements = ['Fire', 'Earth', 'Air', 'Water'];
		}
		
		morph() {
			let next = this.elements.shift();
			this.elements.push(next);
			this.element = next;
		}
		
		toString() {
			return super.toString().replace(/Element: [A-Z][a-z]+/, ('Element: ' + this.element));
		}
	}
	
	return { Melon, Watermelon, Firemelon, Earthmelon, Airmelon, Melolemonmelon };
}
// let module04 = elemelons();
// let m = new module04.Melolemonmelon(10, 's');
// console.log(m.toString());
// m.morph();
// console.log(m.toString());
// m.morph();
// console.log(m.toString());

// 05. C# Console
class Console {

	static get placeholder() {
		return /{\d+}/g;
	}

	static writeLine() {
		let message = arguments[0];
		if (arguments.length === 1) {
			if (typeof (message) === 'object') {
				message = JSON.stringify(message);
				return message;
			}
			else if (typeof(message) === 'string') {
				return message;
			}
		} else {
			if (typeof (message) !== 'string') {
				throw new TypeError("No string format given!");
			} else {
				let tokens = message.match(this.placeholder).sort(function (a, b) {
					a = Number(a.substring(1, a.length - 1));
					b = Number(b.substring(1, b.length - 1));
					return a - b;
				});
				if (tokens.length !== (arguments.length - 1)) {
					throw new RangeError("Incorrect amount of parameters given!");
				} else {
					for (let i = 0; i < tokens.length; i++) {
						let number = Number(tokens[i].substring(1, tokens[i].length - 1));
						if (number !== i) {
							throw new RangeError("Incorrect placeholders given!");
						}
						else {
							message = message.replace(tokens[i], arguments[i + 1]);
						}
					}
					return message;
				}
			}
		}
	}
};
module.exports = { Console };

// 06. Computer
function computer() {
	class Keyboard  {
		constructor(manufacturer, responseTime) {
			this.manufacturer = manufacturer;
			this.responseTime = responseTime;
		}
	}
	class Monitor {
		constructor(manufacturer, width, height) {
			this.manufacturer = manufacturer;
			this.width = width;
			this.height = height;
		}
	}
	class Battery  {
		constructor(manufacturer, expectedLife) {
			this.manufacturer = manufacturer;
			this.expectedLife = expectedLife;
		}
	}
	class Computer {
		constructor(manufacturer, processorSpeed, ram, hardDiskSpace) {
			if (this.constructor.name === "Computer") {
				throw new Error('Abstract class cannot be instantiated directly');
			}
			this.manufacturer = manufacturer;
			this.processorSpeed = processorSpeed;
			this.ram = ram;
			this.hardDiskSpace = hardDiskSpace;
		}
	}
	class Laptop extends Computer {
		constructor(manufacturer, processorSpeed, ram, hardDiskSpace, weight, color, battery) {
			super(manufacturer, processorSpeed, ram, hardDiskSpace);
			this.weight = weight;
			this.color = color;
			this.battery = battery;
		}
		get battery() {
			return this._battery;
		}
		set battery(battery) {
			if (!(battery instanceof Battery)) {
				throw new TypeError('battery not instance of Battery class');
			}
			this._battery = battery;
		}
	}
	class Desktop extends Computer {
		constructor(manufacturer, processorSpeed, ram, hardDiskSpace, keyboard, monitor) {
			super(manufacturer, processorSpeed, ram, hardDiskSpace);
			this.keyboard = keyboard;
			this.monitor = monitor;
		}
		get keyboard() {
			return this._keyboard;
		}
		set keyboard(keyboard) {
			if (!(keyboard instanceof Keyboard)) {
				throw new TypeError('keyboard not instance of Keyboard class');
			}
			this._keyboard = keyboard;
		}
		get monitor() {
			return this._monitor;
		}
		set monitor(monitor) {
			if (!(monitor instanceof Monitor)) {
				throw new TypeError('monitor not instance of Monitor class');
			}
			this._monitor = monitor;
		}
	}
	return { Keyboard, Monitor, Battery, Computer, Laptop, Desktop };
}

// 07. Mixins
function createMixins() {
	function computerQualityMixin(clazz) {
		clazz.prototype.getQuality = function() {
			return ((this.processorSpeed + this.ram + this.hardDiskSpace) / 3);
		}
		clazz.prototype.isFast = function() {
			if (this.processorSpeed > (this.ram / 4)) {
				return true
			}
			return false;
		}
		clazz.prototype.isRoomy = function() {
			if (this.hardDiskSpace > Math.floor(this.ram * this.processorSpeed)) {
				return true
			}
			return false;
		}
	}
	function styleMixin(clazz) {
		clazz.prototype.isFullSet = function() {
			if (this.manufacturer === this.keyboard.manufacturer
				&& this.manufacturer === this.monitor.manufacturer) {
				return true
			}
			return false;
		}
		clazz.prototype.isClassy = function() {
			if (this.battery.expectedLife >= 3 
				&& (this.color === 'Silver' || this.color === 'Black')
				&& this.weight < 3) {
				return true
			}
			return false;
		}
	}
    return {
        computerQualityMixin,
        styleMixin
    }
}

