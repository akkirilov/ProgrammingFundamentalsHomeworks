// 01. Data Class
class Request {
	constructor(method, uri, version, message, response, fulfilled = false) {
		this.method = method;
		this.uri = uri;
		this.version = version;
		this.message = message
		this.response = response;
		this.fulfilled = fulfilled;
	}
}

// 02. Tickets
//console.log(ticketManager(['Philadelphia|94.20|available',
//    'New York City|95.99|available',
//    'New York City|95.99|sold',
//    'Boston|126.20|departed'],
//	'destination'));
//console.log(ticketManager(['Philadelphia|94.20|available',
//    'New York City|95.99|available',
//    'New York City|95.99|sold',
//    'Boston|126.20|departed'],
//'price'));
function ticketManager(arr, criteria) {
	class Ticket {
		constructor(destination, price, status) {
			this.destination = destination;
			this.price = Number(price);
			this.status = status;
		}
	} 
	return arr.map(x => {
		let[destination, price, status] = x.split(/\s*\|\s*/);
		return new Ticket(destination, price, status);
	}).sort((a, b) => { 
		if (isNaN(a[criteria])) {
			return a[criteria].localeCompare(b[criteria]);
		}
		return a[criteria] - b[criteria]; 
	});
}

// 03. Unity
class Rat {
	constructor(name) {
		this.name = name;
		this.unitedRats = [];
	}
	
	getRats() {
		return this.unitedRats;
	}
	unite(rat) {
		if (rat instanceof Rat) {
			this.unitedRats.push(rat);
		}
	}
	toString() {
		return this.name + '\n' + this.unitedRats.map(x => '##' + x.name).join('\n');
	}
}
//let r1 = new Rat('rat');
//let r2 = new Rat('rat2');
//let r3 = new Rat('rat3');
//r1.unite(r2);
//r1.unite(r3);
//console.log(r1.toString());

// 04. Length Limit
class Stringer {
	constructor(str, length) {
		this.innerString = str;
		this.innerLength = length;
	}
	
	get innerString() {
		return this._innerString;
	}
	set innerString(str) {
		this._innerString = str;
	}
	get innerLength() {
		return this._innerLength;
	}
	set innerLength(length) {
		if (length < 0) {
			this._innerLength = 0;
		} else {
			this._innerLength = length;
		}
	}
	
	increase(length) {
		this.innerLength = this.innerLength + length;
	}
	decrease(length) {
		this.innerLength = this.innerLength - length;
	}
	toString() {
		let res = this.innerString;
		if (this.innerLength < res.length) {
			res = this.innerString.substr(0, this.innerLength) + '...';
		}
		return res;
	}
}
//let s = new Stringer("asdfgh", 3);
//console.log(s.toString());

// 05. Extensible Class
let Extensible = (function() {
	let id = 0;
	class Extensible {
		constructor() {
			this.id = id++;
		}
		extend(obj) {
			for (let k in obj) {
				if (obj[k] instanceof Function) {
					Object.getPrototypeOf(this)[k] = obj[k];
//					this.__proto__[k] = obj[k];
				} else {
					this[k] = obj[k];
				}
			}
		}
	}
	return Extensible;
})()
//let template = {
//	  extensionMethod: function () { return 'called by id:' + this.id; },
//	  extensionProperty: 'someString'
//	};
//let obj0 = new Extensible();
//let obj1 = new Extensible();
//console.log(obj0);
//console.log(obj1);
//obj0.extend(template);
//console.log(obj0);
//console.log(obj0.__proto__);
//console.log(template.extensionMethod.call(obj1));

// 06. Sorted List
class SortedList {
	constructor() {
		this.list = [];
		this.size = this.list.length;
	}
	add(val) {
		this.list.push(val);
		this.sort();
	}
	remove(i) {
		if (i < 0 || i >= this.size) {
			return;
		}
		this.list.splice(i, 1);
		this.sort();
	}
	get(i) {
		if (i < 0 || i >= this.size) {
			return;
		}
		return this.list[i];
	}
	sort() {
		this.list = this.list.sort((a, b) => a - b);
		this.size = this.list.length;
	}
}
//let myList = new SortedList();
//for (let i = 0; i < 10; i++) {
//    myList.add(i);
//}
//myList.remove(9);
//console.log(myList.size  + ' = 9');
//let expectedArray = [0, 1, 2, 3, 4, 5, 6, 7, 8];
//for (let i = 0; i < expectedArray.length; i++) {
//	console.log(myList.get(i) == expectedArray[i]);
//}
//console.log(myList);

// 07. Instance Validation
class AccountValidator {
	constructor(clientId, email, firstName, lastName) {
		this.clientId = clientId;
		this.email = email;
		this.firstName = firstName;
		this.lastName = lastName;
	}
	set clientId(clientId) {
		if (!(/^[0-9]{6,6}$/.test(clientId))) {
			throw new TypeError('Client ID must be a 6-digit number');
		}
		this._clientId = clientId;
	}
	get clientId() {
		return this._clientId;
	}
	set email(email) {
		if (!(/^[a-zA-Z0-9]+@[a-zA-Z0-9]+\.[a-zA-Z0-9.]+$/.test(email))) {
			throw new TypeError('Invalid e-mail');
		}
		this._email = email;
	}
	get email() {
		return this._email;
	}
	set firstName(firstName) {
		if (firstName.length < 3 || firstName.length > 20) {
			throw new TypeError('First name must be between 3 and 20 characters long');
		}
		if (!(/^[a-zA-Z]+$/.test(firstName))) {
			throw new TypeError('First name must contain only Latin characters');
		}
		this._firstName = firstName;
	}
	get firstName() {
		return this._firstName;
	}
	set lastName(lastName) {
		if (lastName.length < 3 || lastName.length > 20) {
			throw new TypeError('Last name must be between 3 and 20 characters long');
		}
		if (!(/^[a-zA-Z]+$/.test(lastName))) {
			throw new TypeError('Last name must contain only Latin characters');
		}
		this._lastName = lastName;
	}
	get lastName() {
		return this._lastName;
	}
}
//new AccountValidator('4454454', 'ivan@some.com', 'Ivan', 'Ptrov')
//new AccountValidator('445444', 'ivan@some.com', 'Петкан', 'Ptrov')
//new AccountValidator('445444', 'ivan', 'Ivan', 'Ptrov')
//new AccountValidator('445444', 'ivan@some.com', 'Iv', 'Ptrov')
//new AccountValidator('445444', 'ivan@some.com', 'Ivan', 'Pt4rov')

// 08. View Model
class TextboxView {
	constructor(selector, pattern) {
		this._invalidSymbols = pattern;
		this._elements = $(selector);
		this._value = $(this._elements[0]).val();
		this.onInput();
	}
	
	get elements() {
		return this._elements;
	}
	get value() {
		return this._value;
	}
	set value(value) {
		this._value = value;
		$(this.elements).val(this.value);
	}
	
	onInput() {
		this.elements.on('input', (e) => {
			this.value = $(e.target).val();	
		})
	}
	isValid() {
		return !this._invalidSymbols.test(this.value);
	}
}

// 09. Custom Form
let result = (function() {
	class Textbox {
		constructor(selector, pattern) {
			this._invalidSymbols = pattern;
			this._elements = $(selector);
			this._value = $(this._elements[0]).val();
			this.onInput();
		}
		
		get elements() {
			return this._elements;
		}
		get value() {
			return this._value;
		}
		set value(value) {
			this._value = value;
			$(this.elements).val(this.value);
		}
		
		onInput() {
			this.elements.on('input', (e) => {
				this.value = $(e.target).val();	
			})
		}
		isValid() {
			return !this._invalidSymbols.test(this.value);
		}
	}
	class Form {
		constructor() {
			this._element = $('<div>').addClass('form');
			this.textboxes = arguments;
		}
		set textboxes(args) {
			for (let a of args) {
				if (!a instanceof Textbox) {
					throw new Error('The element is not Textbox!');
				}
			}
			this._textboxes = args;
			for (let t of this._textboxes) {
				for (let e of t.elements) {
					this._element.append($(e));
				}
			}
		}
		get textboxes() {
			return this._textboxes;
		}
		attach(selector) {
			$(selector).append(this._element);
		}
		submit() {
			let allValid = true;
			for (let tb of this.textboxes) {
				if (tb.isValid()) {
					for (let e of tb.elements) {
						$(e).css('border', '2px solid green');
					}
				} else {
					for (let e of tb.elements) {
						$(e).css('border', '2px solid red');
					}
					allValid = false;
				}
			}
			return allValid;
		}
	}
	return { 
		Textbox, 
		Form 
		};
})();

