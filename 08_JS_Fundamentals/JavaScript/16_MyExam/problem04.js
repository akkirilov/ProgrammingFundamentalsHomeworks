problem04([ { kingdom: "Maiden Way", general: "Merek", army: 5000 },
	  { kingdom: "Stonegate", general: "Ulric", army: 4900 },
	  { kingdom: "Stonegate", general: "Doran", army: 70000 },
	  { kingdom: "YorkenShire", general: "Quinn", army: 0 },
	  { kingdom: "YorkenShire", general: "Quinn", army: 2000 },
	  { kingdom: "Maiden Way", general: "Berinon", army: 100000 } ],
	[ ["YorkenShire", "Quinn", "Stonegate", "Ulric"],
	  ["Stonegate", "Ulric", "Stonegate", "Doran"],
	  ["Stonegate", "Doran", "Maiden Way", "Merek"],
	  ["Stonegate", "Ulric", "Maiden Way", "Merek"],
	  ["Maiden Way", "Berinon", "Stonegate", "Ulric"] ]);
function problem04(data, attacks) {
	let generals = {};
	let kingdoms = {};
	for (let e of data) {
		if (kingdoms.hasOwnProperty(e['kingdom'])) {
			if (kingdoms[e['kingdom']].hasOwnProperty(e['general'])) {
				kingdoms[e['kingdom']][e['general']]['army'] += Number(e['army']);
			} else {
				kingdoms[e['kingdom']][e['general']] = {army: Number(e['army']), wins: 0, losses: 0};
			}
		} else {
			kingdoms[e['kingdom']] = {};
			kingdoms[e['kingdom']][e['general']] = {army: Number(e['army']), wins: 0, losses: 0};
			kingdoms[e['kingdom']]['totalWins'] = 0;
			kingdoms[e['kingdom']]['totalLosses'] = 0;
		}
	}
	for (let a of attacks) {
		let[attackingKingdom, attackingGeneral, defendingKingdom, defendingGeneral] = a;
		if (attackingKingdom == defendingKingdom) {
			continue;
		}
		let res = kingdoms[attackingKingdom][attackingGeneral]['army'] - kingdoms[defendingKingdom][defendingGeneral]['army'];
		if (res > 0) {
			kingdoms[defendingKingdom][defendingGeneral]['army'] = Math.floor(kingdoms[defendingKingdom][defendingGeneral]['army'] * 0.9);
			kingdoms[attackingKingdom][attackingGeneral]['army'] = Math.floor(kingdoms[attackingKingdom][attackingGeneral]['army'] * 1.1); 
			kingdoms[defendingKingdom][defendingGeneral]['losses']++;
			kingdoms[attackingKingdom][attackingGeneral]['wins']++;
			kingdoms[defendingKingdom]['totalLosses']++;
			kingdoms[attackingKingdom]['totalWins']++
		} else if (res < 0) {
			kingdoms[attackingKingdom][attackingGeneral]['army'] = Math.floor(kingdoms[attackingKingdom][attackingGeneral]['army'] * 0.9);		
			kingdoms[defendingKingdom][defendingGeneral]['army'] = Math.floor(kingdoms[defendingKingdom][defendingGeneral]['army'] * 1.1);
			kingdoms[attackingKingdom][attackingGeneral]['losses']++;
			kingdoms[defendingKingdom][defendingGeneral]['wins']++;
			kingdoms[attackingKingdom]['totalLosses']++;
			kingdoms[defendingKingdom]['totalWins']++
		}
	}
	let winner = Object.keys(kingdoms).sort((a, b) => {
				let res = kingdoms[b]['totalWins'] - kingdoms[a]['totalWins'];
				if (res == 0) {
					res = kingdoms[a]['totalLosses'] - kingdoms[b]['totalLosses'];
				}
				if (res == 0) {
					res = a.localeCompare(b);
				}
				return res;
			})[0];
	console.log('Winner: ' + winner);
	delete kingdoms[winner]['totalLosses'];
	delete kingdoms[winner]['totalWins'];
	let sortedGenerals = Object.keys(kingdoms[winner]).sort((a, b) => {
		let res = kingdoms[winner][b]['army'] - kingdoms[winner][a]['army'];
		return res;
	});
	for (let g of sortedGenerals) {
		console.log('/\\general: ' + g);
		console.log('---army: ' + kingdoms[winner][g]['army']);
		console.log('---wins: ' + kingdoms[winner][g]['wins']);
		console.log('---losses: ' + kingdoms[winner][g]['losses']);
	}
}
