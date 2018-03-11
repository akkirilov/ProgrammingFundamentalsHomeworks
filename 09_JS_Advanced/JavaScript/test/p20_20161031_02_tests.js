let expect = require("chai").expect;
let SortedList = require('../WebContent/20_OldExams/20161031_exam.js').SortedList;

describe('SortedList Tests', function() {
	let list;
	beforeEach(function() {
		list = new SortedList();
    });
	
	it("should have all of the functions in it's prototype", function() {
        expect(SortedList.prototype.hasOwnProperty('add')).to.equal(true, "Function add() was not found.");
        expect(SortedList.prototype.hasOwnProperty('remove')).to.equal(true, "Function remove() was not found.");
        expect(SortedList.prototype.hasOwnProperty('get')).to.equal(true, "Function get() was not found.");
    });

    it("should have size property getter", function() {
        expect(SortedList.prototype.hasOwnProperty('size')).to.equal(true, "Property size was not found.");
        expect(typeof list.size).to.not.equal('function', "Property size should not be a function.");
    });
	
	it('size => 0', function() {
		expect(list.size).to.be.equal(0);
	});
	
	it('get(0) => Error', function() {
		expect(() => { list.get(0) }).to.throw(Error);
	});
	
	it('remove(0) => Error', function() {
		expect(() => { list.remove(0) }).to.throw(Error);
	});
	
	it('get(-1) => Error', function() {
		expect(() => { list.get(-1) }).to.throw(Error);
	});
	
	it('remove(-1) => Error', function() {
		expect(() => { list.remove(-1) }).to.throw(Error);
	});
	
	it('add(1); get(0) => 1', function() {
		list.add(1);
		expect(list.get(0)).to.be.equal(1);
	});
	
	it('add(1); remove(0) => !Error', function() {
		list.add(1);
		expect(() => { list.remove(0) }).to.not.throw(Error);
	});
	
	it('add(1); get(1) => Error', function() {
		list.add(1);
		expect(() => { list.get(1) }).to.throw(Error);
	});
	
	it('add(1); remove(1) => Error', function() {
		list.add(1);
		expect(() => { list.remove(1) }).to.throw(Error);
	});
	
	it('add(1); get(-1) => Error', function() {
		list.add(1);
		expect(() => { list.get(-1) }).to.throw(Error);
	});
	
	it('add(1); remove(-1) => Error', function() {
		list.add(1);
		expect(() => { list.remove(-1) }).to.throw(Error);
	});
	
	it('add(2, -1, 1); get(0) => -1', function() {
		list.add(2);
		list.add(-1);
		list.add(1);
		expect(list.get(0)).to.be.equal(-1);
	});
	it('add(2.2, -1.5, 1.1); get(0) => -1.5', function() {
		list.add(2.2);
		list.add(-1.5);
		list.add(1.1);
		expect(list.get(0)).to.be.equal(-1.5);
	});
	
	it('add(1); size => 1', function() {
		list.add(1);
		expect(list.size).to.be.equal(1);
	});
	
	it('add(1,2,3.5); size => 3', function() {
		list.add(1);
		list.add(2);
		list.add(3.5);
		expect(list.size).to.be.equal(3);
	});
	it('add(3,2,1); get(2) => 3', function() {
		list.add(1);
		list.add(2);
		list.add(3);
		expect(list.get(2)).to.be.equal(3);
	});
	it('add(3,2,1); remove(0); get(1) => 3', function() {
		list.add(1);
		list.add(2);
		list.add(3);
		list.remove(0);
		expect(list.get(1)).to.be.equal(3);
	});
	it('add(3,2,1); remove(0,0); get(1) => 3', function() {
		list.add(1);
		list.add(2);
		list.add(3);
		list.remove(0);
		list.remove(0);
		expect(list.get(0)).to.be.equal(3);
	});
	it('add(3,2,1); remove(0,0,0); size => 0', function() {
		list.add(1);
		list.add(2);
		list.add(3);
		list.remove(0);
		list.remove(0);
		list.remove(0);
		expect(list.size).to.be.equal(0);
	});

	it('add(3,2,1); get(0) => 1', function() {
		list.add(1);
		list.add(2);
		list.add(3);
		expect(list.get(0)).to.be.equal(1);
	});
	it('add(3,2,1); remove(0); get(0) => 2', function() {
		list.add(1);
		list.add(2);
		list.add(3);
		list.remove(0);
		expect(list.get(0)).to.be.equal(2);
	});

})

