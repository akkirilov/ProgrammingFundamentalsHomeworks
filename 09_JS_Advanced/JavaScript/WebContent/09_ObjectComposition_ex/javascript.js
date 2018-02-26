// 01. Array extension

(function () {
// let extendArr = Object.create(new Array);
	Array.prototype.last = function() {
		return this[this.length - 1];
	} 
	Array.prototype.skip = function(n) {
		return this.slice(n, this.length); 
	};
	Array.prototype.take = function(n) {
		return this.slice(0, n); 
	};
	Array.prototype.sum = function() {
		return this.reduce((a, b) => a + b); 
	};
	Array.prototype.average = function() {
		return this.sum() / this.length;
	};
// let extendArr = [1,2,3,4,5,6,7]
// console.log(extendArr.last());
// console.log(extendArr.skip(1));
// console.log(extendArr.sum(1));
// console.log(extendArr.take(3));
// console.log(extendArr.skip(1));
// console.log(extendArr.sum());
// console.log(extendArr.average());
})()

// 02. Construction Crew
// let c = constructionCrew({ weight: 80,
// experience: 1,
// bloodAlcoholLevel: 0,
// handsShaking: true });
// console.log(c.weight);
function constructionCrew(obj) {
	if (!obj.handsShaking) {
		return obj;
	}
	obj.bloodAlcoholLevel += (obj.experience * (obj.weight * 0.1)); 
	obj.handsShaking = false;
	return obj;
}

// 03. Car Factory
//let c = carFactory({ model: 'Opel Vectra',
//	  power: 110,
//	  color: 'grey',
//	  carriage: 'coupe',
//	  wheelsize: 18 }
//);
//console.log(c);
function carFactory(obj) {
	let car = {};
	car.model = obj.model;
	car.engine = createEngine(obj.power);
	car.carriage = { type: obj.carriage, color: obj.color };
	wheel = obj.wheelsize;
	if (wheel % 2 === 0) {
		wheel--;
	}
	car.wheels = [wheel, wheel, wheel, wheel];
	function createEngine(power) {
		let engine = {};
		if (power <= 90) {
			engine.power = 90;
			engine.volume = 1800;
		} else if (power <= 120) {
			engine.power = 120;
			engine.volume = 2400;
		} else {
			engine.power = 200;
			engine.volume = 3500;
		}
		return engine;
	}
	return car;
}

// 04. Extensible Object
//let o = extensibleObject();
//let c = {name: 'Pesho', getName: () => this.name};
//o.extend(c);
//console.log(o);
//console.log(o.__proto__);
function extensibleObject() {
	let myObj = {
		__proto__: { },
		extend: function (obj) {
			for (let p in obj) {
				if (obj[p] instanceof Function) {
					this.__proto__[p] = obj[p];
				} else {
					this[p] = obj[p];
				}
			}
		}
	}
	return myObj;
}





