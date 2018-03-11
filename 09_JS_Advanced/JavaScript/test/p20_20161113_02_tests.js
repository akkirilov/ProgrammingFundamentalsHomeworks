let expect = require("chai").expect;
let createList = require('../WebContent/20_OldExams/20161113_exam.js').createList;

describe('createList Tests', function() {
	let list;
	beforeEach(function() {
		list = createList();
    });
	it('add(); toString() => ', function() {
		list.add();
		expect(list.toString()).to.be.equal('')
	})
	it('add("str", 1, {a: 1, b:"str"}); toString() => str, 1, [object Object]', function() {
		list.add("str");
		list.add(1);
		list.add({a: 1, b:"str"});
		expect(list.toString()).to.be.equal('str, 1, [object Object]')
	})
	it('add("str"); toString() => str', function() {
		list.add("str");
		expect(list.toString()).to.be.equal('str')
	})
	it('add({a: 1, b:"str"}); toString() => [object Object]', function() {
		list.add({a: 1, b:"str"});
		expect(list.toString()).to.be.equal('[object Object]')
	})
	it('add("str", "str2"); toString() => str, str2', function() {
		list.add("str");
		list.add("str2");
		expect(list.toString()).to.be.equal('str, str2')
	})
	it('add("str", "str2", "str3"); swap(0,1); toString() => str2, str, str3', function() {
		list.add("str");
		list.add("str2");
		list.add("str3");
		list.swap(0, 1);
		expect(list.toString()).to.be.equal('str2, str, str3')
	})
	it('add(1); toString() => 1', function() {
		list.add(1);
		expect(list.toString()).to.be.equal('1')
	})
	it('add(1,2); toString() => 1, 2', function() {
		list.add(1);
		list.add(2);
		expect(list.toString()).to.be.equal('1, 2')
	})
	it('add(1,2,3); shiftLeft(); toString() => 2, 3, 1', function() {
		list.add(1);
		list.add(2);
		list.add(3);
		list.shiftLeft();
		expect(list.toString()).to.be.equal('2, 3, 1')
	})
	it('add(1,2,3); shiftRight(); toString() => 3, 1, 2', function() {
		list.add(1);
		list.add(2);
		list.add(3);
		list.shiftRight();
		expect(list.toString()).to.be.equal('3, 1, 2')
	})
	it('add(1,2,3); swap(0, 2); toString() => 3, 2, 1', function() {
		list.add(1);
		list.add(2);
		list.add(3);
		list.swap(0, 2);
		expect(list.toString()).to.be.equal('3, 2, 1')
	})
	it('add(1,2,3); swap(1, 1); toString() => false', function() {
		list.add(1);
		list.add(2);
		list.add(3);
		expect(list.swap(1, 1)).to.be.equal(false)
	})
	it('add(1,2,3); swap(1, 1); toString() => 1, 2, 3', function() {
		list.add(1);
		list.add(2);
		list.add(3);
		list.swap(1, 1);
		expect(list.toString()).to.be.equal('1, 2, 3')
	})
	it('add(1,2,3); swap(-1, 2); toString() => 1, 2, 3', function() {
		list.add(1);
		list.add(2);
		list.add(3);
		list.swap(-1, 2);
		expect(list.toString()).to.be.equal('1, 2, 3')
	})
	it('add(1,2,3); swap(1, 3); toString() => 1, 2, 3', function() {
		list.add(1);
		list.add(2);
		list.add(3);
		list.swap(1, 3);
		expect(list.toString()).to.be.equal('1, 2, 3')
	})
	it('add(1,2,3); swap("1", 2); toString() => 1, 2, 3', function() {
		list.add(1);
		list.add(2);
		list.add(3);
		list.swap("1", 2);
		expect(list.toString()).to.be.equal('1, 2, 3')
	})
	it('add(1,2,3); swap(1, "2"); toString() => 1, 2, 3', function() {
		list.add(1);
		list.add(2);
		list.add(3);
		list.swap(1, "2");
		expect(list.toString()).to.be.equal('1, 2, 3')
	})
	it('add(1,2,3); swap(0, 2) => true', function() {
		list.add(1);
		list.add(2);
		list.add(3);
		expect(list.swap(0, 2)).to.be.equal(true)
	})
	it('add(1,2,3); swap(2, 0) => true', function() {
		list.add(1);
		list.add(2);
		list.add(3);
		expect(list.swap(2, 0)).to.be.equal(true)
	})
	it('add(1,2,3); swap(-1, 2) => false', function() {
		list.add(1);
		list.add(2);
		list.add(3);
		expect(list.swap(-1, 2)).to.be.equal(false)
	})
	it('add(1,2,3); swap(5, 2) => false', function() {
		list.add(1);
		list.add(2);
		list.add(3);
		expect(list.swap(5, 2)).to.be.equal(false)
	})
	it('add(1,2,3); swap(0, 3) => false', function() {
		list.add(1);
		list.add(2);
		list.add(3);
		expect(list.swap(0, 3)).to.be.equal(false)
	})
	it('add(1,2,3); swap(0, -1) => false', function() {
		list.add(1);
		list.add(2);
		list.add(3);
		expect(list.swap(0, -1)).to.be.equal(false)
	})
	it('add(1,2,3); swap("0", "2") => false', function() {
		list.add(1);
		list.add(2);
		list.add(3);
		expect(list.swap("0", "2")).to.be.equal(false)
	})
	
})

