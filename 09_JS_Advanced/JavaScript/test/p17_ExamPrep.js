let expect = require("chai").expect;
let file = require('../WebContent/17_ExamPrep/javascript.js');
let StringBuilder = file.StringBuilder;

describe('StringBuilder tests', function() {
	let sb;
	beforeEach(function() {
		sb = new StringBuilder();
	});

	it('To has functions to its prototype', function() {
		expect(typeof sb.append === 'function').to.be.equal(true);
		expect(typeof sb.prepend === 'function').to.be.equal(true);
		expect(typeof sb.insertAt === 'function').to.be.equal(true);
		expect(typeof sb.remove === 'function').to.be.equal(true);
		expect(typeof sb.toString === 'function').to.be.equal(true);
		expect(typeof sb._stringArray === 'object').to.be.equal(true);
	});
	it('is Array', function() {
		sb.append('var');
		expect(sb._stringArray.length).to.be.equal(3);
	});
	it('Instantiated with a passed in string', function() {
		sb = new StringBuilder('var');
		expect(sb.toString()).to.be.equal('var');
	});
	it('Instantiated with undefined', function() {
		sb = new StringBuilder(undefined);
		expect(sb.toString()).to.be.equal('');
	});
	it('Tnstantiated without a passed in string', function() {
		expect(sb.toString()).to.be.equal('');
	});
	
	it('append("var"); sb._stringArray[1] => "a"', function() {
		sb.append("var");
		expect(sb._stringArray[1]).to.be.equal("a");
	});
	
	it('append("var", "bar"); toString() => varbar', function() {
		sb.append("var");
		sb.append("bar");
		expect(sb.toString()).to.be.equal('varbar');
	});
	it('append("var", ""); toString() => varbar', function() {
		sb.append("var");
		sb.append("");
		expect(sb.toString()).to.be.equal('var');
	});
	it('append("var", " ", "bar"); toString() => varbar', function() {
		sb.append("var");
		sb.append(" ");
		sb.append("bar");
		expect(sb.toString()).to.be.equal('var bar');
	});
	it('append("var", "bar"); toString() => varbar', function() {
		sb.append("var", "bar");
		expect(sb.toString()).to.be.equal('var');
	});

	it('is Array', function() {
		sb.prepend('var');
		expect(sb._stringArray.length).to.be.equal(3);
	});
	it('append("bar"); prepend("var"); toString() => varbar', function() {
		sb.append("bar");
		sb.prepend("var");
		expect(sb.toString()).to.be.equal('varbar');
	});
	it('append("bar"); prepend(" ", "var"); toString() => var bar', function() {
		sb.append("bar");
		sb.prepend(" ");
		sb.prepend("var");
		expect(sb.toString()).to.be.equal('var bar');
	});
	it('append("bar"); prepend("", "var"); toString() => varbar', function() {
		sb.append("bar");
		sb.prepend("");
		sb.prepend("var");
		expect(sb.toString()).to.be.equal('varbar');
	});
	it('append("bar"); prepend("var", "1"); toString() => varbar', function() {
		sb.append("bar");
		sb.prepend("var", "1");
		expect(sb.toString()).to.be.equal('varbar');
	});
	it('prepend("bar"); toString() => bar', function() {
		sb.prepend("bar");
		expect(sb.toString()).to.be.equal('bar');
	});
	
	it('append("var", "bar"); insertAt("1", 3); toString() => var1bar', function() {
		sb.append("var");
		sb.append("bar");
		sb.insertAt("1", 3);
		expect(sb.toString()).to.be.equal('var1bar');
	});
	it('append("var", "bar"); insertAt("1", -1); toString() => varba1r', function() {
		sb.append("var");
		sb.append("bar");
		sb.insertAt("1", -1);
		expect(sb.toString()).to.be.equal('varba1r');
	});
	it('append("var", "bar"); insertAt("1", 0); toString() => 1varbar', function() {
		sb.append("var");
		sb.append("bar");
		sb.insertAt("1", 0);
		expect(sb.toString()).to.be.equal('1varbar');
	});
	it('append("var", "bar"); insertAt("1", 6); toString() => varbar1', function() {
		sb.append("var");
		sb.append("bar");
		sb.insertAt("1", 6);
		expect(sb.toString()).to.be.equal('varbar1');
	});
	it('append("var", "bar"); remove(0, 3); toString() => bar', function() {
		sb.append("var");
		sb.append("bar");
		sb.remove(0, 3);
		expect(sb.toString()).to.be.equal('bar');
	});
	it('append("var", "bar"); remove(6, 3); toString() => varbar', function() {
		sb.append("var");
		sb.append("bar");
		sb.remove(6, 3);
		expect(sb.toString()).to.be.equal('varbar');
	});
	it('append("var", "bar"); remove(5, 1); toString() => varba', function() {
		sb.append("var");
		sb.append("bar");
		sb.remove(5, 1);
		expect(sb.toString()).to.be.equal('varba');
	});
	it('append("var", "bar"); remove(-1, 1); toString() => varba', function() {
		sb.append("var");
		sb.append("bar");
		sb.remove(-1, 1);
		expect(sb.toString()).to.be.equal('varba');
	});
	it('append("var", "bar"); remove(0, 6); toString() => ""', function() {
		sb.append("var");
		sb.append("bar");
		sb.remove(0, 6);
		expect(sb.toString()).to.be.equal('');
	});
	it('remove(0, 6); toString() => ""', function() {
		sb.remove(0, 6);
		expect(sb.toString()).to.be.equal('');
	});
	it('append("var", "bar"); remove(0); toString() => varbar', function() {
		sb.append("var");
		sb.append("bar");
		sb.remove(0);
		expect(sb.toString()).to.be.equal('varbar');
	});
	
	it('Instantiated with a passed in number => TypeError', function() {
		expect(() => { sb = new StringBuilder(1) }).to.throw(TypeError);
	});
	it('append(1) => TypeError', function() {
		sb.append("var");
		expect(() => { sb.append(1) }).to.throw(TypeError);
	});
	it('prepend(1) => TypeError', function() {
		sb.append("var");
		expect(() => { sb.prepend(1) }).to.throw(TypeError);
	});
	it('insertAt(1, 0); => TypeError', function() {
		sb.append("var");
		expect(() => { sb.insertAt(1, 0) }).to.throw(TypeError);
	});
	it('Instantiated with a passed in Array => TypeError', function() {
		expect(() => { sb = new StringBuilder([]) }).to.throw(TypeError);
	});
	it('append([]) => TypeError', function() {
		sb.append("var");
		expect(() => { sb.append([]) }).to.throw(TypeError);
	});
	it('prepend([]) => TypeError', function() {
		sb.append("var");
		expect(() => { sb.prepend([]) }).to.throw(TypeError);
	});
	it('insertAt([] 0); => TypeError', function() {
		sb.append("var");
		expect(() => { sb.insertAt([], 0) }).to.throw(TypeError);
	});
	it('Instantiated with a passed in Object => TypeError', function() {
		expect(() => { sb = new StringBuilder({}) }).to.throw(TypeError);
	});
	it('append({}) => TypeError', function() {
		sb.append("var");
		expect(() => { sb.append({}) }).to.throw(TypeError);
	});
	it('prepend({}) => TypeError', function() {
		sb.append("var");
		expect(() => { sb.prepend({}) }).to.throw(TypeError);
	});
	it('insertAt({}, 0); => TypeError', function() {
		sb.append("var");
		expect(() => { sb.insertAt({}, 0) }).to.throw(TypeError);
	});
	
	it('StringBuilder._vrfyParam(1); => TypeError', function() {
		sb.append("var");
		expect(() => { StringBuilder._vrfyParam(1) }).to.throw(TypeError);
	});
	it('StringBuilder._vrfyParam([]); => TypeError', function() {
		expect(() => { StringBuilder._vrfyParam([]) }).to.throw(TypeError);
	});
	it('StringBuilder._vrfyParam({}); => TypeError', function() {
		expect(() => { StringBuilder._vrfyParam({}) }).to.throw(TypeError);
	});
	
	it('StringBuilder._vrfyParam("var"); => !TypeError', function() {
		expect(() => { StringBuilder._vrfyParam("var") }).to.not.throw(TypeError);
	});
	
});
