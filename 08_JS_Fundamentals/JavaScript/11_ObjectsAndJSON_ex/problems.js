// 01. Heroic Inventory
function heroicInventory(arr) {
	let heros = [];
	for (let e of arr) {
		let tokens = e.split(/\s*\/\s*/);
		let tempObj = {
			name: tokens[0],
			level:Number(tokens[1]),
			items:tokens[2] ? tokens[2].split(/,\s*/) : []
		}
		heros.push(tempObj);
	}
	console.log(JSON.stringify(heros));
}

// 02. JSON's Table
function JSONtable(arr) {
	let objs = [];
	for (let e of arr) {
		objs.push(JSON.parse(e));
	}
	let res = '<table>\n';
	for (let e of objs) {
		res += '\t<tr>\n';
		let keys = Object.keys(e);
		for (let k of keys) {
			res += '\t\t<td>' + e[k] + '</td>\n';
		}
		res += '\t<tr>\n';
	}
	res += '</table>\n';
	console.log(res);
}

// 03. Cappy Juice
function cappyJuice(arr) {
	let juices = [];
	for (let e of arr) {
		let tokens = e.split(/\s*=>\s*/);
		if (juices[tokens[0]]) {
			if (juices[tokens[0]] < 1000) {
				let temp = juices[tokens[0]];
				delete juices[tokens[0]];
				juices[tokens[0]] = temp;
			}
			juices[tokens[0]] += Number(tokens[1]);
		} else {
			juices[tokens[0]] = Number(tokens[1]);
		}
	}
	for (let j in juices) {
		if (juices[j] >= 1000) {
			console.log(j + ' => ' + Math.floor(juices[j] / 1000));
		}
	}
}

// 04. Store Catalogue
function storeCatalogue(arr) {
	let catalogue = new Map();
	for (let e of arr) {
		let tokens = e.split(/\s*:\s*/);
		let firstLetter = tokens[0][0];
		let tempCatalogue = new Map();
		if (catalogue.has(firstLetter)) {
			tempCatalogue = catalogue.get(firstLetter);
		}
		tempCatalogue.set(tokens[0], Number(tokens[1]));
		catalogue.set(firstLetter, tempCatalogue);
	}
	let catalogueKeys = Array.from(catalogue.keys()).sort();
	for (let c of catalogueKeys) {
		console.log(c);
		let productKeys = Array.from(catalogue.get(c).keys()).sort();
		for (let p of productKeys) {
			console.log('  ' + p + ': ' + catalogue.get(c).get(p));
		}
	}
}

//heroicInventory(['Isacc / 25','Derek / 12 / BarrelVest, DestructionSword','Hes / 1 / Desolator, Sentinel, Antara']);
//JSONtable(['{"name":"Pesho","position":"Promenliva","salary":100000}','{"name":"Teo","position":"Lecturer","salary":1000}',
//		'{"name":"Georgi","position":"Lecturer","salary":1000}']);
//cappyJuice(['Orange => 2000','Peach => 1432','Banana => 450','Peach => 600','Strawberry => 549']);
//storeCatalogue(['Appricot : 20.4','Fridge : 1500','TV : 1499','Deodorant : 10','Boiler : 300',
//		'Apple : 1.25','Anti-Bug Spray : 15','T-Shirt : 10']);


