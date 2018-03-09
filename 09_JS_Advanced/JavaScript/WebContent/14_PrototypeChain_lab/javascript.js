// 01. Person and Teacher
function personAndTeacher() {
	class Person {
		constructor(name, email) {
			this.name = name;
			this.email = email;
		}
	}
	
	class Teacher extends Person {
		constructor(name, email, subject) {
			super(name, email);
			this.subject = subject;
		}
	}
	
	return { Person, Teacher }
}

// 02. Inheriting toString
function inheritingToString() {
	class Person {
		constructor(name, email) {
			this.name = name;
			this.email = email;
		}
		
		toString() {
			return `${this.constructor.name} (name: ${this.name}, email: ${this.email})`;
		}
	}
	
	class Teacher extends Person {
		constructor(name, email, subject) {
			super(name, email);
			this.subject = subject;
		}
		
		toString() {
			return super.toString().slice(0, -1) + ', subject: ' + this.subject + ')';
		}
	}
	
	class Student extends Person {
		constructor(name, email, course) {
			super(name, email);
			this.course = course;
		}
		
		toString() {
			return super.toString().slice(0, -1) + ', course: ' + this.course + ')';
		}
	}
	
	return { Person, Teacher, Student }
}
//let module02 = inheritingToString();
//let p = new module02.Person('Pesho', 'valid@email.va', 'JS');
//let t = new module02.Teacher('Pesho', 'valid@email.va', 'JS');
//let s = new module02.Student('Pesho', 'valid@email.va', 'JS');
//console.log(p.toString());
//console.log(t.toString());
//console.log(s.toString());

// 03. Extending Prototype
function extendingPrototype(clazz) {
	function toSpeciesString() {
		return `I am a ${this.species}. ${this.toString()}`;
	}
	clazz.prototype.species = 'Human';
	clazz.prototype.toSpeciesString = toSpeciesString;
}
//let module02 = inheritingToString();
//let p = new module02.Person('Pesho', 'valid@email.va', 'JS');
//let t = new module02.Teacher('Pesho', 'valid@email.va', 'JS');
//extendingPrototype(module02.Teacher);
//console.log(t.toSpeciesString());

// 04. Class Hierarchy
function figureClasses() {
	class Figure {
		constructor() {
			if (this.constructor.name === "Figure") {
				throw new TypeError("Cannot construct Abstract instances directly!");
			}
		}
		
		get area() {
			return undefined;
		}
		
		toString() {
			return this.constructor.name + ' - ';
		}
	}
	
	class Circle extends Figure {
		constructor(radius) {
			super();
			this.radius = radius;
		}

		get area() {
			return Math.PI * this.radius * this.radius;
		}
		
		toString() {
			return super.toString() + 'radius: ' + this.radius;
		}
	}
	
	class Rectangle extends Figure {
		constructor(width, height) {
			super();
			this.width = width;
			this.height = height;
		}

		get area() {
			return this.width * this.height;
		}
		
		toString() {
			return super.toString() + 'width: ' + this.width + ', height: ' + this.height;
		}
	}
	
	return { Figure, Circle, Rectangle }
}
//let module04 = figureClasses();
//let r = new module04.Rectangle(5, 5);
//let c = new module04.Circle(5, 5);
//console.log(r.toString());
//console.log(c.toString());
//let f = new module04.Figure(); // throw TypeError








