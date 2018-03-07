// 01. Rectangle Class
class Rectangle {
	constructor(width, height, color) {
		this.width = width;
		this.height = height;
		this.color = color;
	}
	
	calcArea() {
		return this.width * this.height;
	}
}
//let rect = new Rectangle(10,10,'blue');
//console.log(rect);
//console.log(rect.calcArea());

// 02. Person Class
class Person {
	constructor(firstName, lastName, age, email) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.age = age;
		this.email = email;	
	}
	toString() {
		return `${this.firstName} ${this.lastName} (age: ${this.age}, email: ${this.email})`;
	}
}
//let person = new Person('Maria', 'Petrova', 22, 'mp@mp.mp');
//console.log(person + '');

// 03. Get Persons
//console.log(getPersons().join('\n'));
function getPersons() {
	class Person {
		constructor(firstName, lastName, age, email) {
			this.firstName = firstName;
			this.lastName = lastName;
			this.age = age;
			this.email = email;	
		}
		toString() {
			return `${this.firstName} ${this.lastName} (age: ${this.age}, email: ${this.email})`;
		}
	}
	
	return [
		new Person('Maria', 'Petrova', 22, 'mp@yahoo.com'),
		new Person('SoftUni'),
		new Person('Stephan', 'Nikolov', 25),
		new Person('Peter', 'Kolev', 24, 'ptr@gmail.com'),
		];
}

// 04. Circle
class Circle {
	constructor(radius) {
		this.radius = radius;
	}
	
	get radius() {
		return this._radius;
	}
	set radius(radius) {
		if (radius < 0) {
			throw new RangeError('Radius must be posive number!');
		}
		this._radius = radius;
	}
	get diameter() {
		return this.radius * 2;
	}
	set diameter(diameter) {
		this.radius = diameter / 2;
	}
	
	get area() {
		return Math.PI * this.radius * this.radius;
	}
}
//let c1 = new Circle(5);
//console.log(c1.radius);
//console.log(c1.diameter);
//console.log(c1.area);
//c1.diameter = 20
//console.log(c1.radius);
//console.log(c1.diameter);
//console.log(c1.area);

// 05. Point Distance
class Point {
	constructor(x, y) {
		this.x = x;
		this.y = y;
	}

	get x() {
		return this._x;
	}
	set x(x) {
		this._x = x;
	}
	get y() {
		return this._y;
	}
	set y(y) {
		this._y = y;
	}
	
	static distance(p1, p2) {
		let dx = p1.x - p2.x;
		let dy = p1.y - p2.y;
		return Math.sqrt((dx * dx) + (dy * dy));
	}
}
//let p1 = new Point(5, 10);
//let p2 = new Point(-5, -10);
//console.log(Point.distance(p1, p2));

// 06. Cards
let myModule = (function() {
	let validFaces = ['2', '3', '4', '5', '6', '7', '8', '9', '10', 'J', 'Q', 'K', 'A'];
	let validSuits = {'SPADES': '\u2660', 'HEARTS': '\u2665', 'DIAMONDS': '\u2666', 'CLUBS': '\u2663'};
	
	class Card {
		constructor(face, suit) {
			this.face = face;
			this.suit = suit;
		}
		get face() {
			return this._face;
		}
		set face(face) {
			if (!validFaces.includes(face)) {
				throw new Error('Invalid face: ' + face);
			}
			this._face = face;
		}
		get suit() {
			return this._suit;
		}
		set suit(suit) {
			if (!Object.keys(validSuits).map(x => validSuits[x]).includes(suit)) {
				throw new Error('Invalid suit: ' + suit);
			}
			this._suit = suit;
		}
	}
	
	return { 
		Card: Card, 
		Suits: validSuits 
	};
})()
//let Suits = myModule.Suits;
//let Card = myModule.Card;
//console.log(new Card('2', Suits.CLUBS));
//// Should throw Error
//console.log(new Card('1', Suits.CLUBS));

