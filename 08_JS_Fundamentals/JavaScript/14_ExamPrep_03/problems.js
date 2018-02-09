// 01. Spice Must Flow
//spiceMustFlow(['10'])
function spiceMustFlow(arr) {
	let num = Number(arr[0]);
	let days = 0;
	let total = 0;;
	while (num >= 100) {
		days++;
		total += num - 26;
		num -= 10;
	}
	if (days > 0) {
		total -= 26;
    }
	console.log(days);
	console.log(total);
}

// 02. Build a Wall
//buildWall([21, 25, 28]);
function buildWall(arr) {
	const oneConcreteYard = 195;
	const oneConcreteYardPesos = 1900;
	const maxHeight = 30;
	arr = arr.filter(x => x !== '').map(x => Number(x));
	let usedConcrete = [];
	let stillBuild = true;
	while (stillBuild) {
		stillBuild = false;
		let totalConcrete = 0;
		for (let i = 0; i < arr.length; i++) {
			if (arr[i] < maxHeight) {
				totalConcrete += oneConcreteYard;
				arr[i]++;
				stillBuild = true;
			}
		}
		if (stillBuild) {
			usedConcrete.push(totalConcrete);
		}
	}
	console.log(usedConcrete.join(', '));
	let totalPesos = usedConcrete.reduce((a, b) => a + b) * oneConcreteYardPesos;
	console.log(totalPesos + ' pesos');
}

// 03. Format Helper
//formatHelper(['Now lets test.all; the     3. 14     : functionality ! What about trimming "  Trim me please       "!']);
function formatHelper(arr) {
	let text = arr[0];
	console.log(text
	        .replace(/[ ]*([.,!?:;])[ ]*/g, (match, g1) => `${g1} `)
	        .replace(/\. (?=[0-9])/g, (match) => `.`)
	        .replace(/" *(.+?) *"/g, (match, g1) => `"${g1}"`)
	        .replace(/([.,!?:;]) (?=[.,!?:;])/g, (match, g1) => g1));
}

// 04. Airport
//airportsData([
//	"Airbus London 100 land",
//	"Airbus Paris 200 depart",
//	"Airbus Madrid 130 depart",
//	"Airbus Lisbon 403 depart",
//	"Airbus Moscow 505 depart",
//	"Airbus Sofia 16 depart"]);
function airportsData(arr) {
	let landeds = [];
	let departs = [];
	let towns = {};
	let i;
	for (let e of arr) {
		let [plane, town, passengers, action] = e.split(' ');
		if (action == 'land' && landeds.indexOf(plane) < 0) {
			landeds.push(plane);
			i = departs.indexOf(plane);
			if (i >= 0) {
				departs.splice(i, 1);
			}
			if (towns.hasOwnProperty(town)) {
				towns[town]['Arrivals'] += Number(passengers);
				towns[town]['Planes'].add(plane);
			} else {
				let tempSet = new Set();
				tempSet.add(plane);
				towns[town] = { Arrivals: Number(passengers), Departures: 0, Planes: tempSet};
			}
		} else if (action == 'depart' && landeds.indexOf(plane) >= 0) {
			i = landeds.indexOf(plane);
			landeds.splice(i, 1);
			departs.push(plane);
			if (towns.hasOwnProperty(town)) {
				towns[town]['Departures'] += Number(passengers);
				towns[town]['Planes'].add(plane);
			} else {
				let tempSet = new Set();
				tempSet.add(plane);
				towns[town] = { Arrivals: 0, Departures: Number(passengers), Planes: tempSet};
			}
		} 
	}
	console.log('Planes left:');
	landeds.sort((a, b) => a.localeCompare(b))
					.forEach(x => console.log('- ' + x));
	Object.keys(towns).sort((a, b) => {
						let res = towns[b]['Arrivals'] - towns[a]['Arrivals'];
						if (res == 0) {
							res = a.localeCompare(b);
						}
						return res;
					}).forEach(x => {
						console.log(x);
						console.log('Arrivals: ' + towns[x]['Arrivals']);
						console.log('Departures: ' + towns[x]['Departures']);
						console.log('Planes:');
						Array.from(towns[x]['Planes']).sort((a, b) => a.localeCompare(b))
							.forEach(x => console.log('-- ' + x));
					});
}

