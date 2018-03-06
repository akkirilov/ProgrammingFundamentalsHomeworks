// 01. Request Validator
//requestValidator({
//    method: 'GET',
//    uri: 'svn.publ=c.catalog',
//    version: 'HTTP/1.1',
//    message: ''
//});
function requestValidator(req) {
	let validPosts = ['GET','POST','DELETE','CONNECT'];
	let validVersions = ['HTTP/0.9','HTTP/1.0','HTTP/1.1','HTTP/2.0'];
	let error = 'Invalid request header: Invalid ';
	if (!req.hasOwnProperty('method')) {
		throw new Error(error + 'Method');
	}
	if (validPosts.indexOf(req.method) < 0) {
		throw new Error(error + 'Method');
	}
	if (!req.hasOwnProperty('uri')) {
		throw new Error(error + 'URI');
	}
	if (req.uri == '') {
		throw new Error(error + 'URI');
	}
	if (!(/^[a-z0-9.]+$/.test(req.uri)) 
			&& req.uri != '*') {
		throw new Error(error + 'URI');
	}
	if (!req.hasOwnProperty('version')) {
		throw new Error(error + 'Version');
	}
	if (validVersions.indexOf(req.version) < 0) {
		throw new Error(error + 'Version');
	}
	if (!req.hasOwnProperty('message')) {
		throw new Error(error + 'Message');
	}
	if (req.message.includes('<')) {
		throw new Error(error + 'Message');
	}
	if (req.message.includes('>')) {
		throw new Error(error + 'Message');
	}
	if (req.message.includes('\\')) {
		throw new Error(error + 'Message');
	}
	if (req.message.includes('&')) {
		throw new Error(error + 'Message');
	}
	if (req.message.includes('\'')) {
		throw new Error(error + 'Message');
	}
	if (req.message.includes('"')) {
		throw new Error(error + 'Message');
	}
	return req;
}

// 02. Even Or Odd
//console.log(isOddOrEven('aaa'));
function isOddOrEven(string) {
    if (typeof(string) !== 'string') {
        return undefined;
    }
    if (string.length % 2 === 0) {
        return "even";
    }
    return "odd";
}

// 03. Char Lookup
//console.log(lookupChar(' asdf', 0));
function lookupChar(string, index) {
    if (typeof(string) !== 'string' || !Number.isInteger(index)) {
        return undefined;
    }
    if (string.length <= index || index < 0) {
        return "Incorrect index";
    }
    return string.charAt(index);
}

// 04. Math Enforcer
function mathEnforcer() {
	return {
	    addFive: function (num) {
	        if (typeof(num) !== 'number') {
	            return undefined;
	        }
	        return num + 5;
	    },
	    subtractTen: function (num) {
	        if (typeof(num) !== 'number') {
	            return undefined;
	        }
	        return num - 10;
	    },
	    sum: function (num1, num2) {
	        if (typeof(num1) !== 'number' || typeof(num2) !== 'number') {
	            return undefined;
	        }
	        return num1 + num2;
	    }
	};
}

let $ = require('jquery');

// 05. Shared Object
function sharedObject() {
	return {
	    name: null,
	    income: null,
	    changeName: function (name) {
	        if (name.length === 0) {
	            return;
	        }
	        this.name = name;
	        let newName = $('#name');
	        newName.val(this.name);
	    },
	    changeIncome: function (income) {
	        if (!Number.isInteger(income) || income <= 0) {
	            return;
	        }
	        this.income = income;
	        let newIncome = $('#income');
	        newIncome.val(this.income);
	    },
	    updateName: function () {
	        let newName = $('#name').val();
	        if (newName.length === 0) {
	            return;
	        }
	        this.name = newName;
	    },
	    updateIncome: function () {
	        let newIncome = $('#income').val();
	        if (isNaN(newIncome) || !Number.isInteger(Number(newIncome)) || Number(newIncome) <= 0) {
	            return;
	        }
	        this.income = Number(newIncome);
	    }
	}
}

// 06. ArmageDOM
function nuke(selector1, selector2) {
    if (selector1 === selector2) return;
    $(selector1).filter(selector2).remove();
}

module.exports = { isOddOrEven, lookupChar, mathEnforcer, sharedObject, nuke };








