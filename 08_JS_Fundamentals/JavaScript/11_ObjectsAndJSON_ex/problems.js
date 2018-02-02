//01. Heroic Inventory
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

// 05. Auto-Engineering Company
function autoEngineeringCompany(arr) {
	let cars = new Map();
	for (let e of arr) {
		let [brand, model, count] = e.split(/\s*\|\s*/);
		let tempMap = new Map();
		if (cars.has(brand)) {
			tempMap = cars.get(brand);
			if (cars.get(brand).has(model)) {
				tempMap.set(model, cars.get(brand).get(model) + Number(count));
			} else {
				tempMap.set(model, Number(count));
			}
		} else {
			tempMap.set(model, Number(count));
		}
		cars.set(brand, tempMap);
	}
	for (let [k, v] of cars) {
		console.log(k);
		for (let [mc, mv] of v) {
			console.log('###' + mc + ' -> ' + mv);
		}
	}
}

// 06. System Components
function systemComponents(arr) {
	let systemsData = new Map();
	for (let e of arr) {
		let [system, component, subComponent] = e.split(/\s*\|\s*/);
		if (systemsData.has(system)) {
	        if (systemsData.get(system).has(component)) {
	        	systemsData.get(system).get(component).push(subComponent);
            } else {
            	let tempArr = [];
            	tempArr.push(subComponent);
            	systemsData.get(system).set(component, tempArr);
            }
        } else {
        	let tempMap = new Map();
        	let tempArr = [];
        	tempArr.push(subComponent);
        	tempMap.set(component, tempArr);
        	systemsData.set(system, tempMap);
        }
	}
	let systemsKeys = Array.from(systemsData.keys())
			.sort((a, b) => {
				let res = systemsData.get(b).size - systemsData.get(a).size;
				if (res == 0) {
	                res = a.localeCompare(b);
                }
				return res;
			})
	for (let k of systemsKeys) {
		console.log(k);
		let componentsKeys = Array.from(systemsData.get(k).keys())
				.sort((a, b) => systemsData.get(k).get(b).length -
						 systemsData.get(k).get(a).length)
		for (let ck of componentsKeys) {
			console.log('|||' + ck);
			systemsData.get(k).get(ck).forEach(x => console.log('||||||' + x));
		}
	}
} 

// 07. Usernames
function usernames(arr) {
	Array.from(new Set(arr.sort((a, b) => {
		let res = a.length - b.length;
		if (res == 0) {
	        res = a.localeCompare(b);
        }
		return res;
	}))).forEach(x => console.log(x));
}

// 08. Unique Sequences
function uniqueSequences(data) {
    let arrays = new Map;
    for (let line of data) {
        let array = JSON.parse(line).map(Number).sort((a, b) => b - a);
        let toStore = `[${array.join(', ')}]`;
        if (!arrays.has(toStore)) {
            arrays.set(toStore, array.length);
        }
    }
    console.log([...arrays.keys()].sort((a, b) => arrays.get(a) -arrays.get(b)).join('\n'));
}

// heroicInventory(['Isacc / 25','Derek / 12 / BarrelVest,
// DestructionSword','Hes / 1 / Desolator, Sentinel, Antara']);
// JSONtable(['{"name":"Pesho","position":"Promenliva","salary":100000}','{"name":"Teo","position":"Lecturer","salary":1000}',
// '{"name":"Georgi","position":"Lecturer","salary":1000}']);
// cappyJuice(['Orange => 2000','Peach => 1432','Banana => 450','Peach =>
// 600','Strawberry => 549']);
// storeCatalogue(['Appricot : 20.4','Fridge : 1500','TV : 1499','Deodorant :
// 10','Boiler : 300',
// 'Apple : 1.25','Anti-Bug Spray : 15','T-Shirt : 10']);
// autoEngineeringCompany(['Audi | Q7 | 1000',
// 'Audi | Q6 | 100',
// 'BMW | X5 | 1000',
// 'BMW | X6 | 100',
// 'Citroen | C4 | 123',
// 'Volga | GAZ-24 | 1000000',
// 'Lada | Niva | 1000000',
// 'Lada | Jigula | 1000000',
// 'Citroen | C4 | 22',
// 'Citroen | C5 | 10']);
// systemComponents(['SULS | Main Site | Home Page',
// 'SULS | Main Site | Login Page',
// 'SULS | Main Site | Register Page',
// 'SULS | Judge Site | Login Page',
// 'SULS | Judge Site | Submittion Page',
// 'Lambda | CoreA | A23',
// 'SULS | Digital Site | Login Page',
// 'Lambda | CoreB | B24',
// 'Lambda | CoreA | A24',
// 'Lambda | CoreA | A25',
// 'Lambda | CoreC | C4',
// 'Indice | Session | Default Storage',
// 'Indice | Session | Default Security']);
// usernames(['Ashton','Kutcher','Ariel','Lilly','Keyden','Aizen','Billy','Braston']);
// uniqueSequences(['[7.14, 7.180, 7.339, 80.099]',
// '[7.339, 80.0990, 7.140000, 7.18]',
// '[7.339, 7.180, 7.14, 80.099]']);
