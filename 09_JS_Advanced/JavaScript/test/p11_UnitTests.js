let jsdom = require('jsdom-global')();
let $ = require('jquery');
let expect = require('chai').expect;
let file = require('../WebContent/11_UnitTestingWithMocha_ex/javascript.js');
let isOddOrEven = file.isOddOrEven;
let lookupChar = file.lookupChar;
let mathEnforcer = file.mathEnforcer();
let targetHTML;
let sharedObject = file.sharedObject();
let nuke = file.nuke;

describe('isOddOrEven', function() {
	it('isOddOrEven("aaa") => odd', function() {
		expect(isOddOrEven('aaa')).to.be.equal('odd');
	})
	it('isOddOrEven("aaaa") => even', function() {
		expect(isOddOrEven('aaaa')).to.be.equal('even');
	})
	it('isOddOrEven(1) => undefined', function() {
		expect(isOddOrEven(1)).to.be.equal(undefined);
	})
	it('isOddOrEven([1,2]) => undefined', function() {
		expect(isOddOrEven([ 1, 2 ])).to.be.equal(undefined);
	})
	it('isOddOrEven({prop: "someProp"}) => undefined', function() {
		expect(isOddOrEven({
			prop : "someProp"
		})).to.be.equal(undefined);
	})
})

describe('lookupChar', function() {
	it('lookupChar("aaa", 1) => a', function() {
		expect(lookupChar('aaa', 1)).to.be.equal('a');
	})
	it('lookupChar("a aa", 1) => " "', function() {
		expect(lookupChar('a aa', 1)).to.be.equal(' ');
	})
	it('lookupChar("asdf", 0) => a', function() {
		expect(lookupChar("asdf", 0)).to.be.equal('a');
	})
	it('lookupChar("asdf", 3) => f', function() {
		expect(lookupChar("asdf", 3)).to.be.equal('f');
	})
	it('lookupChar(1, 1) => undefined', function() {
		expect(lookupChar(1, 1)).to.be.equal(undefined);
	})
	it('lookupChar([], 1) => undefined', function() {
		expect(lookupChar([], 1)).to.be.equal(undefined);
	})
	it('lookupChar({}, 1) => undefined', function() {
		expect(lookupChar({}, 1)).to.be.equal(undefined);
	})
	it('lookupChar("aaa", "sa") => undefined', function() {
		expect(lookupChar('aaa', "sa")).to.be.equal(undefined);
	})
	it('lookupChar("aaa", []) => undefined', function() {
		expect(lookupChar('aaa', [])).to.be.equal(undefined);
	})
	it('lookupChar("aaa", {}) => undefined', function() {
		expect(lookupChar('aaa', {})).to.be.equal(undefined);
	})
	it('lookupChar("asdf", 3.1) => undefined', function() {
		expect(lookupChar("asdf", 3.1)).to.be.equal(undefined);
	})
	it('lookupChar("", 0) => Incorrect index', function() {
		expect(lookupChar('', 0)).to.be.equal('Incorrect index');
	})
	it('lookupChar("asdf", -1) => Incorrect index', function() {
		expect(lookupChar("asdf", -1)).to.be.equal('Incorrect index');
	})
	it('lookupChar("asdf", 4) => Incorrect index', function() {
		expect(lookupChar("asdf", 4)).to.be.equal('Incorrect index');
	})
	it('lookupChar("aaa") => undefined', function() {
		expect(lookupChar('aaa')).to.be.equal(undefined);
	})
	it('lookupChar(1) => undefined', function() {
		expect(lookupChar(1)).to.be.equal(undefined);
	})
})

describe('mathEnforcer', function() {
	describe('addFive', function() {
		it('enforcer.addFive(7) => 12', function() {
			expect(mathEnforcer.addFive(7)).to.be.equal(12);
		})
		it('enforcer.addFive(-7) => 12', function() {
			expect(mathEnforcer.addFive(-7)).to.be.equal(-2);
		})
		it('enforcer.addFive(7.5) => 12.5', function() {
			expect(mathEnforcer.addFive(7.5)).to.be.equal(12.5);
		})
		it('enforcer.addFive("a") => undefined', function() {
			expect(mathEnforcer.addFive("a")).to.be.equal(undefined);
		})
		it('enforcer.addFive([]) => undefined', function() {
			expect(mathEnforcer.addFive([])).to.be.equal(undefined);
		})
		it('enforcer.addFive({}) => undefined', function() {
			expect(mathEnforcer.addFive({})).to.be.equal(undefined);
		})
		it('enforcer.addFive() => undefined', function() {
			expect(mathEnforcer.addFive()).to.be.equal(undefined);
		})
	})
	describe('subtractTen', function() {
		it('enforcer.subtractTen(12) => 2', function() {
			expect(mathEnforcer.subtractTen(12)).to.be.equal(2);
		})
		it('enforcer.subtractTen(2) => -8', function() {
			expect(mathEnforcer.subtractTen(2)).to.be.equal(-8);
		})
		it('enforcer.subtractTen(-2) => -8', function() {
			expect(mathEnforcer.subtractTen(-2)).to.be.equal(-12);
		})
		it('enforcer.subtractTen(12.5) => 2.5', function() {
			expect(mathEnforcer.subtractTen(12.5)).to.be.equal(2.5);
		})
		it('enforcer.subtractTen("a") => undefined', function() {
			expect(mathEnforcer.subtractTen("a")).to.be.equal(undefined);
		})
		it('enforcer.subtractTen([]) => undefined', function() {
			expect(mathEnforcer.subtractTen([])).to.be.equal(undefined);
		})
		it('enforcer.subtractTen({}) => undefined', function() {
			expect(mathEnforcer.subtractTen({})).to.be.equal(undefined);
		})
		it('enforcer.subtractTen() => undefined', function() {
			expect(mathEnforcer.subtractTen()).to.be.equal(undefined);
		})
	})
	describe('sum', function() {
		it('enforcer.sum(12, 2) => 14', function() {
			expect(mathEnforcer.sum(12, 2)).to.be.equal(14);
		})
		it('enforcer.sum(-12, 2) => 10', function() {
			expect(mathEnforcer.sum(-12, 2)).to.be.equal(-10);
		})
		it('enforcer.sum(-12, -2) => -14', function() {
			expect(mathEnforcer.sum(-12, -2)).to.be.equal(-14);
		})
		it('enforcer.sum(12.2, 2.3) => 14.5', function() {
			expect(mathEnforcer.sum(12.2, 2.3)).to.be.equal(14.5);
		})
		it('enforcer.sum("a", 2) => undefined', function() {
			expect(mathEnforcer.sum("a", 2)).to.be.equal(undefined);
		})
		it('enforcer.sum(1, "s") => undefined', function() {
			expect(mathEnforcer.sum(1, "s")).to.be.equal(undefined);
		})
		it('enforcer.sum("a", "s") => undefined', function() {
			expect(mathEnforcer.sum("a", "s")).to.be.equal(undefined);
		})
		it('enforcer.sum(1) => undefined', function() {
			expect(mathEnforcer.sum(1)).to.be.equal(undefined);
		})
		it('enforcer.sum() => undefined', function() {
			expect(mathEnforcer.sum()).to.be.equal(undefined);
		})
	})
})

describe('sharedObject', function() {
	document.body.innerHTML = '<div id="wrapper">'
		+'<input type="text" id="name">'
		+'<input type="text" id="income"></div>';
	
	describe('start values', function() {
		it('sharedObject.name => null', function() {
			expect(sharedObject.name).to.be.null;
		})
		it('sharedObject.income => null', function() {
			expect(sharedObject.income).to.be.null;
		})
	})
	describe('changeName', function() {
		it('sharedObject.changeName("") => null', function() {
			sharedObject.changeName("");
			expect(sharedObject.name).to.be.null;
		})
		it('name.val() =>  ""', function() {
			expect($('#name').val()).to.be.equal('');
		})
		it('sharedObject.changeName("name") => name', function() {
			sharedObject.changeName("name");
			expect(sharedObject.name).to.be.equal('name');
		})
		it('name.val() => name', function() {
			sharedObject.changeName("name");
			expect($('#name').val()).to.be.equal('name');
		})
	})
	describe('changeIncome', function() {
		it('sharedObject.changeIncome(0) => null', function() {
			sharedObject.changeIncome(0);
			expect(sharedObject.income).to.be.null;
		})
		it('sharedObject.changeIncome("str") => null', function() {
			sharedObject.changeIncome("str");
			expect(sharedObject.income).to.be.null;
		})
		it('sharedObject.changeIncome(1.5) => null', function() {
			sharedObject.changeIncome(1.5);
			expect(sharedObject.income).to.be.null;
		})
		it('sharedObject.changeIncome(-1) => null', function() {
			sharedObject.changeIncome(-1);
			expect(sharedObject.income).to.be.null;
		})
		it('income.val() => ""', function() {
			expect($('#income').val()).to.be.equal('');
		})
		it('sharedObject.changeIncome(1) => 1', function() {
			sharedObject.changeIncome(1);
			expect(sharedObject.income).to.be.equal(1);
		})
		it('income.val() => 1', function() {
			sharedObject.changeIncome(1);
			expect($('#income').val()).to.be.equal('1');
		})
	})
	describe('updateName', function() {
		it('sharedObject.updateName() => val("name")', function() {
			$('#name').val('name');
			sharedObject.updateName();
			expect(sharedObject.name).to.be.equal('name');
		})
		it('sharedObject.updateName() => val("")', function() {
			$('#name').val('name');
			sharedObject.updateName();
			$('#name').val('');
			sharedObject.updateName();
			expect(sharedObject.name).to.be.equal('name');
		})
	})
	describe('updateIncome', function() {
		it('sharedObject.updateIncome() => val("str")', function() {
			$('#income').val(2);
			sharedObject.updateIncome();
			$('#income').val("str");
			sharedObject.updateIncome();
			expect(sharedObject.income + '').to.be.equal('2');
		})
		it('sharedObject.updateIncome() => val(0)', function() {
			$('#income').val(2);
			sharedObject.updateIncome();
			$('#income').val(0);
			sharedObject.updateIncome();
			expect(sharedObject.income + '').to.be.equal('2');
		})
		it('sharedObject.updateIncome() => val(-2)', function() {
			$('#income').val(2);
			sharedObject.updateIncome();
			$('#income').val(-2);
			sharedObject.updateIncome();
			expect(sharedObject.income + '').to.be.equal('2');
		})
		it('sharedObject.updateIncome() => val(2.5)', function() {
			$('#income').val(2);
			sharedObject.updateIncome();
			$('#income').val(2.5);
			sharedObject.updateIncome();
			expect(sharedObject.income + '').to.be.equal('2');
		})
		it('sharedObject.updateIncome() => val(2)', function() {
			$('#income').val(2);
			sharedObject.updateIncome();
			expect(sharedObject.income + '').to.be.equal('2');
		})
	})
})

describe('ArmageDOM tests', function() {
	beforeEach(function() {
		document.body.innerHTML = 
		'<div id="target">'
		    +'<div class="nested target">'
	        	+'<p>This is some text+</p>'
	        +'</div>'
	        +'<div class="target">'
	        	+'<p>Empty div+</p>'
	        +'</div>'
	        +'<div class="inside">'
	        	+'<span class="nested">Some more text+</span>'
	        	+'<span class="target">Some more text+</span>'
	        +'</div>'
	    +'</div>';
		targetHTML = $('#target');
	});
	it('nuke(".inside", ".unreal") not changed', function() {
		let selector1 = $('.inside');
		let selector2 = $('.unreal');
		let oldHtml = targetHTML.html();
		nuke(selector1, selector2);
		expect(targetHTML.html()).to.be.equal(oldHtml);
	})
	it('nuke(".unreal", ".inside") not changed', function() {
		let selector1 = $('.unreal');
		let selector2 = $('.inside');
		let oldHtml = targetHTML.html();
		nuke(selector1, selector2);
		expect(targetHTML.html()).to.be.equal(oldHtml);
	})
	it('nuke(".target", ".target") not changed', function() {
		let selector1 = $('.target');
		let oldHtml = targetHTML.html();
		nuke(selector1, selector1);
		expect(targetHTML.html()).to.be.equal(oldHtml);
	})
	it('nuke(".nested", ".inside") not changed', function() {
		let selector1 = $('.nested');
		let selector2 = $('.inside');
		let oldHtml = targetHTML.html();
		nuke(selector1, selector2);
		expect(targetHTML.html()).to.be.equal(oldHtml);
	})
	it('nuke(".nested", ".target") changed', function() {
		let selector1 = $('.nested');
		let selector2 = $('.target');
		let oldHtml = targetHTML.html();
		nuke(selector1, selector2);
		expect(targetHTML.html()).to.not.equal(oldHtml);
	})
})
