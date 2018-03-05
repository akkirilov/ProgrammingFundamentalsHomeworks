let expect = require("chai").expect;
let file = require('../WebContent/10_UnitTestingWithMocha_lab/javascript.js');
let sum = file.sum;
let isSymmetric = file.isSymmetric;
let rgbToHexColor = file.rgbToHexColor;
let createCalculator = file.createCalculator;

describe('sum tests', function() {
	it('sum([1,2,3]) should return 6', function() {
		expect(sum([1,2,3])).to.be.equal(6);
	})
	it('sum([]) should return 0', function() {
		expect(sum([])).to.be.equal(0);
	})
	it('sum([-1,-2,3]) should return 0', function() {
		expect(sum([-1,-2,3])).to.be.equal(0);
	})
	it('sum([-1,-2,3, "str"]) should return NaN', function() {
		expect(sum([-1,-2,3, 'str'])).to.be.NaN;
	})
	it('sum([1.5, 2, 1.1]) should return 4.6', function() {
		expect(sum([1.5, 2, 1.1])).to.be.equal(4.6);
	})
})

describe('isSymmetric tests', function() {
	it('isSymmetric([]) => true', function() {
		expect(isSymmetric([])).to.be.equal(true);
	})
	it('isSymmetric([5]) => true', function() {
		expect(isSymmetric([5])).to.be.equal(true);
	})
	it('isSymmetric([5,"hi",{a:5},new Date(),{a:5},"hi",5]) => true', function() {
		expect(isSymmetric([5,"hi",{a:5},new Date(),{a:5},"hi",5])).to.be.equal(true);
	})
	it('isSymmetric([1,2,3,2,1]) => true', function() {
		expect(isSymmetric([1,2,3,2,1])).to.be.equal(true);
	})
	it('isSymmetric(["a","b","a"]) => true', function() {
		expect(isSymmetric(["a","b","a"])).to.be.equal(true);
	})
	it('isSymmetric([1.1,2,3,2,1.1]) => true', function() {
		expect(isSymmetric([1.1,2,3,2,1.1])).to.be.equal(true);
	})
	it('isSymmetric([1,2,3,2,1,4]) => false', function() {
		expect(isSymmetric([1,2,3,2,1,4])).to.be.equal(false);
	})
	it('isSymmetric(["a","b","c"]) => false', function() {
		expect(isSymmetric(["a","b","c"])).to.be.equal(false);
	})
	it('isSymmetric([1.1,2,3,2,1.2]) => false', function() {
		expect(isSymmetric([1.1,2,3,2,1.2])).to.be.equal(false);
	})
	it('isSymmetric("str") => false', function() {
		expect(isSymmetric("str")).to.be.equal(false);
	})
	it('isSymmetric(1,2,1) => false', function() {
		expect(isSymmetric(1,2,1)).to.be.equal(false);
	})
})

describe('rgbToHexColor tests', function() {
	it('rgbToHexColor(15,54,78) => #0F364E', function() {
		expect(rgbToHexColor(15,54,78)).to.be.equal('#0F364E');
	})
	it('rgbToHexColor(0,0,0) => #000000', function() {
		expect(rgbToHexColor(0,0,0)).to.be.equal('#000000');
	})
	it('rgbToHexColor(255,255,255) => #FFFFFF', function() {
		expect(rgbToHexColor(255,255,255)).to.be.equal('#FFFFFF');
	})
	it('rgbToHexColor(15,54,78,45) => #0F364E', function() {
		expect(rgbToHexColor(15,54,78,45)).to.be.equal('#0F364E');
	})
	it('rgbToHexColor(15,54,300) => undefined', function() {
		expect(rgbToHexColor(15,54,300)).to.be.equal(undefined);
	})
	it('rgbToHexColor(15,54,256) => undefined', function() {
		expect(rgbToHexColor(15,54,256)).to.be.equal(undefined);
	})
	it('rgbToHexColor(-15,54,30) => undefined', function() {
		expect(rgbToHexColor(-15,54,30)).to.be.equal(undefined);
	})
	it('rgbToHexColor(-15) => undefined', function() {
		expect(rgbToHexColor(-15)).to.be.equal(undefined);
	})
	it('rgbToHexColor(15,54) => undefined', function() {
		expect(rgbToHexColor(15,54)).to.be.equal(undefined);
	})
	it('rgbToHexColor(15) => undefined', function() {
		expect(rgbToHexColor(15)).to.be.equal(undefined);
	})
	it('rgbToHexColor(15,54,"str") => undefined', function() {
		expect(rgbToHexColor(15,54,"str")).to.be.equal(undefined);
	})
	it('rgbToHexColor("1","2","3") => undefined', function() {
		expect(rgbToHexColor("1","2","3")).to.be.equal(undefined);
	})
	it('rgbToHexColor("str") => undefined', function() {
		expect(rgbToHexColor("str")).to.be.equal(undefined);
	})
	it('rgbToHexColor([],[],[]) => undefined', function() {
		expect(rgbToHexColor([],[],[])).to.be.equal(undefined);
	})
	it('rgbToHexColor({},{},{}) => undefined', function() {
		expect(rgbToHexColor({},{},{})).to.be.equal(undefined);
	})
	it('rgbToHexColor() => undefined', function() {
		expect(rgbToHexColor()).to.be.equal(undefined);
	})
})

describe('createCalculator tests', function() {
	let calc;
	beforeEach(function() {
		calc = createCalculator();
	})
	it('calc 5 + 6 = 11', function() {
		calc.add(5);
		calc.add(6);
		expect(calc.get()).to.be.equal(11);
	})
	it('calc 5 + 6 - 2 = 9', function() {
		calc.add(5);
		calc.add(6);
		calc.subtract(2);
		expect(calc.get()).to.be.equal(9);
	})
	it('calc 5.2 + 6.3 - 2.1 = 9.4', function() {
		calc.add(5.2);
		calc.add(6.3);
		calc.subtract(2.1);
		expect(calc.get()).to.be.equal(9.4);
	})
	it('calc "a" + "s" = NaN', function() {
		calc.add("a");
		calc.add("s");
		expect(calc.get()).to.be.NaN;
	})
	it('calc 2 + 2 + "s" = NaN', function() {
		calc.add(2);
		calc.add(2);
		calc.add("s");
		expect(calc.get()).to.be.NaN;
	})
	it('calc 2 + [2] = 4', function() {
		calc.add(2);
		calc.add([2]);
		expect(calc.get()).to.be.equal(4);
	})
	it('calc 2 + [2, 2] = NaN', function() {
		calc.add(2);
		calc.add([2, 2]);
		expect(calc.get()).to.be.NaN;
	})
	it('calc 2 + {} = NaN', function() {
		calc.add(2);
		calc.add({});
		expect(calc.get()).to.be.NaN;
	})
	it('calc -1 - 5 = -6', function() {
		calc.add(-1);
		calc.add(-5);
		expect(calc.get()).to.be.equal(-6);
	})
	
})
