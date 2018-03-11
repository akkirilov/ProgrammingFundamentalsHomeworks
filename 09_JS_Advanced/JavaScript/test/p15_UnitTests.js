let expect = require("chai").expect;
let assert = require("chai").assert;
let file = require('../WebContent/15_PrototypeChain_ex/javascript.js');
let Console = file.Console;
describe('Console tests', function() {
	it('writeLine("just a string") => just a string', function() {
		expect(Console.writeLine("just a string")).to.be.equal('just a string');
	})
	it('writeLine("just {0} string", "a") => just a string', function() {
		expect(Console.writeLine("just {0} string", "a")).to.be.equal('just a string');
	})
	it('writeLine("just {0} {1}{2}", "a", "string", "!") => just a string', function() {
		expect(Console.writeLine("just {0} {1}{2}", "a", "string", "!")).to.be.equal('just a string!');
	})
	it('writeLine() => {"prop":"prop","prop1":2}', function() {
		expect(Console.writeLine({prop: "prop", prop1: 2})).to.be.equal(JSON.stringify({prop: "prop", prop1: 2}));
	})
	it('writeLine([]) => []', function() {
		expect(Console.writeLine([])).to.be.equal('[]');
	})
	it('writeLine(1) => undefined', function() {
		expect(Console.writeLine(1)).to.be.equal(undefined);
	})
	it('writeLine(1.5) => undefined', function() {
		expect(Console.writeLine(1.5)).to.be.equal(undefined);
	})
	it('writeLine("just {0} {1}", "a") => RangeError', function() {
		assert.throws(function () { Console.writeLine("just {0} {1}", "a") }, RangeError, "Incorrect amount of parameters given!");
	})
	it('writeLine("just {0} {2}", "a", "string") => RangeError', function() {
		assert.throws(function () { Console.writeLine("just {0} {2}", "a", "string") }, RangeError, "Incorrect placeholders given!");
	})
	it('writeLine("just {0} ", "a", "string") => RangeError', function() {
		assert.throws(function () { Console.writeLine("just {0} ", "a", "string") }, RangeError, "Incorrect amount of parameters given!");
	})
	it('writeLine("just {15} ", "a", "string", "!") => RangeError', function() {
		assert.throws(function () { Console.writeLine("just {15} ", "a", "string", "!") }, RangeError, "Incorrect amount of parameters given!");
	})
	it('writeLine(1, "a", "string") => TypeError', function() {
		assert.throws(function () { Console.writeLine(1, "a", "string") }, TypeError, "No string format given!");
	})
	it('writeLine() => TypeError', function() {
		assert.throws(function () { Console.writeLine() }, TypeError, "No string format given!");
	})
})
