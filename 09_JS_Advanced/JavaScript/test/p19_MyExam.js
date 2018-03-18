let expect = require("chai").expect;
let file = require('../WebContent/19_MyExam/javascript.js');
let PaymentPackage = file.PaymentPackage;

describe('MyExam Tests', function() {
	let pp;
	beforeEach(function() {
		pp = new PaymentPackage('TEST', 50);
	});
	
	it('Has all functions', function() {
        expect(PaymentPackage.prototype.hasOwnProperty('name')).to.equal(true);
        expect(PaymentPackage.prototype.hasOwnProperty('value')).to.equal(true);
        expect(PaymentPackage.prototype.hasOwnProperty('VAT')).to.equal(true);
        expect(PaymentPackage.prototype.hasOwnProperty('active')).to.equal(true);
        expect(PaymentPackage.prototype.hasOwnProperty('toString')).to.equal(true);
	});
	it('check name type', function() {
		expect(typeof pp.name).to.be.equal('string');
	});
	it('check value type', function() {
		expect(typeof pp.value).to.be.equal('number');
	});
	it('check VAT type', function() {
		expect(typeof pp.VAT).to.be.equal('number');
	});
	it('check active type', function() {
		expect(typeof pp.active).to.be.equal('boolean');
	});
	
	it('get name tests', function() {
		expect(pp.name).to.be.equal('TEST');
	});
	it('set name tests', function() {
		pp.name = 'newTest';
		expect(pp.name).to.be.equal('newTest');
	});
	it('get value tests', function() {
		expect(pp.value).to.be.equal(50);
	});
	it('set value tests', function() {
		pp.value = 100;
		expect(pp.value).to.be.equal(100);
	});
	it('set value tests', function() {
		pp.value = 0;
		expect(pp.value).to.be.equal(0);
	});
	it('set value tests', function() {
		pp.value = 10.10;
		expect(pp.value).to.be.equal(10.10);
	});
	it('get VAT tests', function() {
		expect(pp.VAT).to.be.equal(20);
	});
	it('set VAT tests', function() {
		pp.VAT = 15;
		expect(pp.VAT).to.be.equal(15);
	});
	it('set VAT tests', function() {
		pp.VAT = 15.5;
		expect(pp.VAT).to.be.equal(15.5);
	});
	it('get active tests', function() {
		expect(pp.active).to.be.equal(true);
	});
	it('set active tests', function() {
		pp.active = false;
		expect(pp.active).to.be.equal(false);
	});
	
	it('toString()', function() {
		pp = new PaymentPackage('TEST555', 50);
		expect(pp.toString()).to.be.equal('Package: TEST555\n- Value (excl. VAT): 50\n- Value (VAT 20%): 60');
	});
	it('toString()', function() {
		expect(pp.toString()).to.be.equal('Package: TEST\n- Value (excl. VAT): 50\n- Value (VAT 20%): 60');
	});
	it('toString() with changed params', function() {
		pp.name = 'newTest';
		pp.value = 80;
		pp.VAT = 15;
		expect(pp.toString()).to.be.equal('Package: newTest\n- Value (excl. VAT): 80\n- Value (VAT 15%): 92');
	});
	it('toString() with changed params', function() {
		pp.name = 'newTest';
		pp.value = 80.6;
		pp.VAT = 15.5;
		expect(pp.toString()).to.be.equal('Package: newTest\n- Value (excl. VAT): 80.6\n- Value (VAT 15.5%): 93.09299999999999');
	});
	it('toString() with (inactive)', function() {
		pp.active = false;
		expect(pp.toString()).to.be.equal('Package: TEST (inactive)\n- Value (excl. VAT): 50\n- Value (VAT 20%): 60');
	});
	
	it('set name = "" => Error', function() {
		expect(() => { pp.name = '' }).to.throw(Error);
	});
	it('set name = [] => Error', function() {
		expect(() => { pp.name = [] }).to.throw(Error);
	});
	it('set name = undefined => Error', function() {
		expect(() => { pp.name = undefined }).to.throw(Error);
	});
	it('set name = null => Error', function() {
		expect(() => { pp.name = null }).to.throw(Error);
	});
	it('set name = 55 => Error', function() {
		expect(() => { pp.name = 55 }).to.throw(Error);
	});
	
	it('set value = "" => Error', function() {
		expect(() => { pp.value = '' }).to.throw(Error);
	});
	it('set value = "str" => Error', function() {
		expect(() => { pp.value = 'str' }).to.throw(Error);
	});
	it('set value = [] => Error', function() {
		expect(() => { pp.value = [] }).to.throw(Error);
	});
	it('set value = undefined => Error', function() {
		expect(() => { pp.value = undefined }).to.throw(Error);
	});
	it('set value = null => Error', function() {
		expect(() => { pp.value = null }).to.throw(Error);
	});
	it('set value = -55 => Error', function() {
		expect(() => { pp.value = -55 }).to.throw(Error);
	});
	
	it('set VAT = "" => Error', function() {
		expect(() => { pp.VAT = '' }).to.throw(Error);
	});
	it('set VAT = "str" => Error', function() {
		expect(() => { pp.VAT = 'str' }).to.throw(Error);
	});
	it('set VAT = [] => Error', function() {
		expect(() => { pp.VAT = [] }).to.throw(Error);
	});
	it('set VAT = undefined => Error', function() {
		expect(() => { pp.VAT = undefined }).to.throw(Error);
	});
	it('set VAT = null => Error', function() {
		expect(() => { pp.VAT = null }).to.throw(Error);
	});
	it('set VAT = -55 => Error', function() {
		expect(() => { pp.VAT = -55 }).to.throw(Error);
	});

	it('set active = "" => Error', function() {
		expect(() => { pp.active = '' }).to.throw(Error);
	});
	it('set active = "str" => Error', function() {
		expect(() => { pp.active = 'str' }).to.throw(Error);
	});
	it('set active = [] => Error', function() {
		expect(() => { pp.active = [] }).to.throw(Error);
	});
	it('set active = undefined => Error', function() {
		expect(() => { pp.active = undefined }).to.throw(Error);
	});
	it('set active = null => Error', function() {
		expect(() => { pp.active = null }).to.throw(Error);
	});
	it('set active = 55 => Error', function() {
		expect(() => { pp.active = 55 }).to.throw(Error);
	});
	
	it('initialize with no params', function() {
		expect(() => { pp = new PaymentPackage() }).to.throw(Error);
	});
	it('initialize with empty name', function() {
		expect(() => { pp = new PaymentPackage("", 50) }).to.throw(Error);
	}); 
	it('initialize with number name', function() {
		expect(() => { pp = new PaymentPackage(50, 50) }).to.throw(Error);
	});
	it('initialize with str value', function() {
		expect(() => { pp = new PaymentPackage("newTest", "50") }).to.throw(Error);
	}); 
	it('initialize with negative value', function() {
		expect(() => { pp = new PaymentPackage("newTest", -50) }).to.throw(Error);
	});
	
});