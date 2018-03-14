let expect = require("chai").expect;
let file = require('../WebContent/16_ExamPrep/javascript.js');
let Sumator = file.Sumator;

describe('Sumator tests', function() {
	let sumator;
	beforeEach(function() {
		sumator = new Sumator();
	});
	
	it('Is initialized', function() {
		expect(sumator !== undefined).to.be.equal(true);
	})
	it('To has functions to its prototype', function() {
		expect(typeof sumator.add === 'function').to.be.equal(true);
		expect(typeof sumator.sumNums === 'function').to.be.equal(true);
		expect(typeof sumator.removeByFilter === 'function').to.be.equal(true);
		expect(typeof sumator.toString === 'function').to.be.equal(true);
	})
	
	it('toString() => (empty)', function() {
		expect(sumator.toString()).to.be.equal('(empty)');
	})
	it('add(1, 2); toString() => 1, 2', function() {
		sumator.add(1);
		sumator.add(2);
		expect(sumator.toString()).to.be.equal('1, 2');
	})
	it('add(1, 2, {}, "str"); toString() => 1, 2, [object Object], str', function() {
		sumator.add(1);
		sumator.add(2);
		sumator.add({});
		sumator.add("str");
		expect(sumator.toString()).to.be.equal('1, 2, [object Object], "str"');
	})
	it('add("str", "str2"); toString() => str, str2', function() {
		sumator.add("str");
		sumator.add("str2");
		expect(sumator.toString()).to.be.equal("str, str2");
	})
	it('add("str", 2); toString() => str, 2', function() {
		sumator.add("str");
		sumator.add(2);
		expect(sumator.toString()).to.be.equal('str, 2');
	})
	
	it('add(1, 2, 3); sumNums() => 6', function() {
		sumator.add(1);
		sumator.add(2);
		sumator.add(3);
		expect(sumator.sumNums()).to.be.equal(6);
	})
	it('add(1, 2, "str", 3, "{}"); sumNums() => 6', function() {
		sumator.add(1);
		sumator.add(2);
		sumator.add("str");
		sumator.add(3);
		sumator.add({});
		expect(sumator.sumNums()).to.be.equal(6);
	})
	it('add("str", "str2", "str3"); sumNums() => 0', function() {
		sumator.add("str");
		sumator.add("str2");
		sumator.add("str3");
		expect(sumator.sumNums()).to.be.equal(0);
	})
	
	it('add(1, 2, 3, 4); removeByFilter((x) => x % 2 === 0) => 1, 3', function() {
		sumator.add(1);
		sumator.add(2);
		sumator.add(3);
		sumator.add(4);
		sumator.removeByFilter((x) => x % 2 === 0);
		expect(sumator.toString()).to.be.equal('1, 3');
	})
	it('add("str", "str2", "str3"); removeByFilter((x) => x.length === 3) => str', function() {
		sumator.add("str");
		sumator.add("str2");
		sumator.add("str3");
		sumator.removeByFilter((x) => x.length === 4);
		expect(sumator.toString()).to.be.equal("str");
	})
	it('add(1, 2, 3, "str", "str2"); removeByFilter((x) => typeof x === string) => 1, 2, 3', function() {
		sumator.add(1);
		sumator.add(2);
		sumator.add(3);
		sumator.add("str");
		sumator.add("str2");
		sumator.removeByFilter((x) => typeof x === 'string');
		expect(sumator.toString()).to.be.equal("1, 2, 3");
	})
	it('add(1, 2, 3, "str", "str2", {}); removeByFilter((x) => typeof x === string) => 1, 2, 3', function() {
		sumator.add(1);
		sumator.add(2);
		sumator.add(3);
		sumator.add("str");
		sumator.add("str2");
		sumator.add({});
		sumator.removeByFilter((x) => typeof x === 'string');
		expect(sumator.toString()).to.be.equal("1, 2, 3, [object Object]");
	})
	it('add(1, 2, 3); removeByFilter((x) => typeof x === string) => 1, 2, 3', function() {
		sumator.add(1);
		sumator.add(2);
		sumator.add(3);
		sumator.removeByFilter((x) => typeof x === 'string');
		expect(sumator.toString()).to.be.equal("1, 2, 3");
	})
	it('add(1, 2, 3); removeByFilter((x) => typeof x === number) => (empty)', function() {
		sumator.add(1);
		sumator.add(2);
		sumator.add(3);
		sumator.removeByFilter((x) => typeof x === 'number');
		expect(sumator.toString()).to.be.equal("(empty)");
	})
	it('add(1, 2, 3); removeByFilter(undefined) => TypeError', function() {
		sumator.add(1);
		sumator.add(2);
		sumator.add(3);
		expect(() => sumator.removeByFilter(undefined)).to.throw();
	})
});
