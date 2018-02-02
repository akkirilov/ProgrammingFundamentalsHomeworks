// 01. Towns to JSON
function townsToJSON(arr) {
	let towns = [];
	let args = arr.shift().split(/\s*\|\s*/).filter(x => x !== '');
	for (let e of arr) {
		let tokens = e.split(/\s*\|\s*/).filter(x => x !== '');
		let obj = {};
		obj[args[0]] = tokens[0];
		obj[args[1]] = Number(tokens[1]);
		obj[args[2]] = Number(tokens[2]);
		towns.push(obj); }
	console.log(JSON.stringify(towns));
}

// 02. Score to HTML
function scoreToHTML(str) {
	let arr = JSON.parse(str);
	let keys = Object.keys(arr[0]);
	let res = '<table>\n  <tr>';
	for (let k of keys) {
		res += '<th>' + k + '</th>'; }
	res += '</tr>\n';
	for (let o of arr) {
		res += '  <tr>';
		for (let k of keys) {
			res += '<td>' + HTMLescape(o[k]) + '</td>'; }
		res += '</tr>\n'; }
	res += '</table>\n';
	console.log(res);

	function HTMLescape(str) {
		if (isNaN(parseFloat(str)) && !isFinite(str)) {
			let escSymbols = [];
			escSymbols['&'] = '&amp;';
			escSymbols['<'] = '&lt;';
			escSymbols['>'] = '&gt;';
			escSymbols['"'] = '&quot;';
			escSymbols["'"] = '&#39;';
			for (let e in escSymbols) {
				str = str.replace(new RegExp(e, 'g'), escSymbols[e]);
			}
		}
		return str;
	}
}

// 03. JSON to HTML Table
function JSONToHTML(str) {
	let arr = JSON.parse(str);
	let keys = Object.keys(arr[0]);
	let res = '<table>\n  <tr>';
	for (let k of keys) {
		res += '<th>' + k + '</th>'; }
	res += '</tr>\n';
	for (let o of arr) {
		res += '  <tr>';
		for (let k of keys) {
			res += '<td>' + HTMLescape(o[k]) + '</td>'; }
		res += '</tr>\n'; }
	res += '</table>\n';
	console.log(res);

	function HTMLescape(str) {
		if (isNaN(parseFloat(str)) && !isFinite(str)) {
			let escSymbols = [];
			escSymbols['&'] = '&amp;';
			escSymbols['<'] = '&lt;';
			escSymbols['>'] = '&gt;';
			escSymbols['"'] = '&quot;';
			escSymbols["'"] = '&#39;';
			for (let e in escSymbols) {
				str = str.replace(new RegExp(e, 'g'), escSymbols[e]);
			}
		}
		return str;
	}
}

// 04. Sum by Town
function sumByTown(arr) {
	let obj = {};
	for (let i = 0, len = arr.length; i < len - 1; i += 2) {
		if (obj.hasOwnProperty(arr[i])) {
			obj[arr[i]] += Number(arr[i + 1]);
		} else {
			obj[arr[i]] = Number(arr[i + 1]);
		}
	}
	console.log(JSON.stringify(obj));
}

// 05. Count Words in a Text
function countWordsInText(arr) {
	let words = arr.join(' ').split(/[^a-zA-Z0-9]+/)
		.filter(x => x !== '');
	let res = {};
	for (let e of words) {
		if (res[e]) {
			res[e] = res[e] + 1;
		} else {
			res[e] = 1;
		} }
	console.log(JSON.stringify(res));
}

// 06. Count Words with Maps
function countWordsWithMaps(arr) {
	let words = arr.join(' ')
		.split(/[^a-zA-Z0-9_]+/)
		.filter(x => x !== '')
		.map(x => x.toLowerCase());
	let res = new Map();
	for (let w of words) {
		if (res.has(w)) {
			res.set(w, res.get(w) + 1);
		} else {
			res.set(w, 1);
		} }
	Array.from(res.keys())
		.sort()
		.forEach(k => console.log("'" + k + "'" + ' -> ' + res.get(k) + ' times'));
}

// 07. Population in Towns
function populationInTowns(arr) {
	let res = new Map();
	for (let e of arr) {
		let [town, population] = e.split(/\s*<->\s*/);
		if (res.has(town)) {
			res.set(town, res.get(town) + Number(population));
		} else {
			res.set(town, Number(population));
		} }
	res.forEach((v, k) => console.log(k + " : " + v));
}

// 08. City Markets
function cityMarkets(arr) {
	let towns = new Map();
	for (let e of arr) {
		let [town, product, value] = e.split(/\s*->\s*/);
		let total = value.split(/\s*:\s*/).reduce((a,b) => a * b);
		if (towns.has(town)) {
			if (towns.get(town).has(product)) {
				towns.get(town).set(product, town.get(town).get(product) + total);
			} else {
				towns.get(town).set(product, total);
			}
		} else {
			let newMap = new Map();
			newMap.set(product, total);
			towns.set(town, newMap);
		} 
	}
	for (let [k, v] of towns) {
		console.log('Town - ' + k);
		for (let [pk, pv] of v) {
			console.log('$$$' + pk + ' : ' + pv);
		}
	}
}

// 09. Lowest Prices in Cities
function lowestPricesInCities(arr) {
	let products = new Map();
	for (let e of arr) {
		let [town, product, price] = e.split(/\s*\|\s*/);
		let tempMap = new Map();
		if (products.has(product)) {
			tempMap = products.get(product);
		} 
		tempMap.set(town, Number(price));
		products.set(product, tempMap);
	}
	for (let [k, v] of products) {
		let keys = Array.from(v.keys()).sort((k1, k2) => v.get(k1) - v.get(k2));
		for (let e of keys) {
			console.log(k + ' -> ' + v.get(e) + ' (' + e + ')');
			break;
		}
	}
}

// 10. Extract Unique Words
function extractUniqueWords(arr) {
	console.log(Array.from(new Set(arr.join(' ')
					.split(/[^a-zA-Z0-9]+/)
					.filter(x => x !== '')
					.map(x => x.toLowerCase())))
				.join(', '));
}

//townsToJSON(['| Town | Latitude | Longitude |','| Sofia | 42.696552 | 23.32601 |','| Beijing | 39.913818 | 116.363625 |']);
//scoreToHTML('[{"name":"Pesho & Kiro","score":479.5},{"name":"Gosho","score":205}]');
//JSONToHTML('[{"Name":"Tomatoes & Chips","Price":2.35},{"Name":"J&B Chocolate","Price":0.96}]');
//sumByTown(['Sofia','20','Varna','3','Sofia','5','Varna','4']);
//countWordsInText(["Far too slow, you're far too slow."]);
//countWordsWithMaps(["Far too slow, you're far too slow."]);
//populationInTowns(['Sofia <-> 1200000','Montana <-> 20000','New York <-> 10000000','Washington <-> 2345000','Las Vegas <-> 1000000', 'Sofia <-> 1200000']);
//cityMarkets([ 'Sofia -> Laptops HP -> 200 : 2000', 'Sofia -> Raspberry -> 200000 : 1500', 'Sofia -> Audi Q7 -> 200 : 100000',
//		'Montana -> Portokals -> 200000 : 1', 'Montana -> Qgodas -> 20000 : 0.2', 'Montana -> Chereshas -> 1000 : 0.3' ]);
//lowestPricesInCities(['Sample Town | Sample Product | 1000','Sample Town | Orange | 2','Sample Town | Peach | 1',
//		'Sofia | Orange | 3','Sofia | Peach | 2','New York | Sample Product | 1000.1','New York | Burger | 10']);
//extractUniqueWords(["Lorem ipsum dolor sit amet, consectetur adipiscing elit. Pellentesque quis hendrerit dui." +
//		"Quisque fringilla est urna, vitae efficitur urna vestibulum fringilla." +
//		"Vestibulum dolor diam, dignissim quis varius non, fermentum non felis. " +
//		"Vestibulum ultrices ex massa, sit amet faucibus nunc aliquam ut. " +
//		"Morbi in ipsum varius, pharetra diam vel, mattis arcu. " +
//		"Integer ac turpis commodo, varius nulla sed, elementum lectus. " +
//		"Vivamus turpis dui, malesuada ac turpis dapibus, congue egestas metus."]);

