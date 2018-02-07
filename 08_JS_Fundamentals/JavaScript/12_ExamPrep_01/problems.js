// 01. The Hungry Programmer
//theHungryProgrammer(['fries', 'fish', 'beer', 'chicken', 'beer', 'eggs'],
//		['Add spaghetti', 'Shift 0 1', 'Consume 1 4', 'End']);
function theHungryProgrammer(meals, commands) {
	let count = 0;
	for (let c of commands) {
		c = c.split(/\s+/);
		if (c[0] === 'End') {
			break;
		}
		switch (c[0]) {
		case 'Serve':
			if (meals.length > 0) {
				console.log(meals.pop() + ' served!');
			}
			break;
		case 'Eat':
			if (meals.length > 0) {
				console.log(meals.shift() + ' eaten');
				count++;
			}
			break;
		case 'Consume':
			let start = Number(c[1]);
			let end = Number(c[2]);
			if (c.length === 3 && start >= 0 && end < meals.length) {
				console.log('Burp!');
				meals.splice(start, end - start + 1);
				count += end - start + 1;
			}
			break;
		case 'Shift':
			let first = Number(c[1]);
			let second = Number(c[2]);
			if (c.length === 3 && first != second && first >= 0 && first < meals.length && second >= 0 && second < meals.length) {
				let temp = meals[first];
				meals[first] = meals[second];
				meals[second] = temp;
			}
			break;
		case 'Add':
			if (c.length === 2 && c[1] !== '' && c[1] !== ' ') {
				meals.unshift(c[1]);
			}
			break;
		default:
			break;
		} }
	if (meals.length > 0) {
		console.log('Meals left: ' + meals.join(', '));
	} else {
		console.log('The food is gone');
	}
	console.log('Meals eaten: ' + count);
}

// 02. Expedition
//expedition([[1, 1, 0, 1],
//	 [0, 1, 1, 0],
//	 [0, 0, 1, 0],
//	 [1, 0, 1, 0]],
//	[[0, 0, 1, 0, 1],
//	 [1, 0, 0, 1, 1],
//	 [1, 0, 1, 1, 1],
//	 [1, 0, 1, 0, 1]],
//	[[0, 0],
//	 [2, 1],
//	 [1, 0]],
//	[2, 0]);
function expedition(map, secondaryMap, coordinates, starCoordinates) {
	for (let c of coordinates) {
		let row = c[0];
		let sRowEnd = secondaryMap.length;
		let sColEnd = secondaryMap[0].length;
		let sRow = 0;
		for (; row < c[0] + sRowEnd; row++, sRow++) {
			if (row == map.length) {
				break;
			}
			let col = c[1];
			let sCol = 0;
			for (; col < c[1] + sColEnd; col++, sCol++) {
				if (col == map[row].length) {
					break;
				}
				if (secondaryMap[sRow][sCol] == 1) {
					if (map[row][col] == 1) {
						map[row][col] = 0;
					} else {
						map[row][col] = 1;
					}
				}
			}
		} }
	let end;
	let row = starCoordinates[0];
	let col = starCoordinates[1];
	let steps = 1;
	while (true) {
		let canMove = false;
		if (end !== 'Bottom' && row > 0 && map[row - 1][col] == 0) {
			row--;
			canMove = true;
			steps++;
			end = 'Top';
		} else if (end !== 'Top' && row < map.length - 1 && map[row + 1][col] == 0) {
			row++;
			canMove = true;
			steps++;
			end = 'Bottom';
		} else if (end !== 'Right' && col > 0 && map[row][col - 1] == 0) {
			col--;
			canMove = true;
			steps++;
			end = 'Left';
		} else if (end !== 'Left' && col < map[row].length - 1 && map[row][col + 1] == 0) {
			col++;
			canMove = true;
			steps++;
			end = 'Right';
		}
		if (!canMove) {
			if (row == 0 || row == map.length - 1 || col == 0 || col == map[0].length) {
				console.log(steps);
				console.log(end);
			} else {
				console.log(steps);
				let quadrant = 0;
				if (row < (map.length / 2) && col < (map[0].length / 2)) {
					quadrant = 2;
				} else if (row < (map.length / 2) && col >= (map[0].length / 2)) {
					quadrant = 1;
				} else if (row >= (map.length / 2) && col >= (map[0].length / 2)) {
					quadrant = 4;
				} else if (row >= (map.length / 2) && col < (map[0].length / 2)) {
					quadrant = 3;
				}
				console.log('Dead end ' + quadrant);
			}
			break;
		}
	}
}

// 03. Lost
//lost('4ds',
//'eaSt 19,432567noRt north east 53,123456north 43,3213454dsNot all those who wander are lost.4dsnorth 47,874532');
function lost(messageSeparator, message) {
	let messagePattern = new RegExp(messageSeparator + '(.+)' + messageSeparator, 'gi');
	let match = messagePattern.exec(message);
	let msg = match[1];
	let msgParts = message.split(match[0]);
	let north = '';
	let east = '';
	let northPattern = /(north)([^,]+),([^,(north)|(east)]+)/gi;
	let eastPattern = /([^,]+),([^,(north)|(east)]+)/gi;
	let pattern = /(north|east)\D*(\d{2})[^\,]*\D*(,{1})\D*(\d{6})/gi;
	for (let e of msgParts) {
		while (match = pattern.exec(e)) {
			if (match[1].toLowerCase() == 'north') {
				north = match[2] + '.' + match[4] + ' N';
			} else if (match[1].toLowerCase() == 'east') {
				east = match[2] + '.' + match[4] + ' E';
			}
		} }
	console.log(north);
	console.log(east);
	console.log('Message: ' + msg);
}

// 04. Rest House
//restHouse([ { number: '101A', type: 'double-bedded' },
//{ number: '104', type: 'triple' },
//{ number: '101B', type: 'double-bedded' },
//{ number: '102', type: 'triple' } ],
//[ { first: { name: 'Sushi & Chicken', gender: 'female', age: 15 }, 
//  second: { name: 'Salisa Debelisa', gender: 'female', age: 25 } },
//{ first: { name: 'Daenerys Targaryen', gender: 'female', age: 20 }, 
//  second: { name: 'Jeko Snejev', gender: 'male', age: 18 } },
//{ first: { name: 'Pesho Goshov', gender: 'male', age: 20 }, 
//  second: { name: 'Gosho Peshov', gender: 'male', age: 18 } },    
//{ first: { name: 'Conor McGregor', gender: 'male', age: 29 }, 
//  second: { name: 'Floyd Mayweather', gender: 'male', age: 40 } } ]);
function restHouse(rooms, guests) {
	let fillDouble = false;
	let counter = 0;
	let total = 0;
	for (let gc of guests) {
		total += 2;
		if (gc.first.gender !== gc.second.gender && !fillDouble) {
			fillDouble = true;
			for (let r of rooms) {
				if (r.type === 'double-bedded') {
					if (!r['guests']) {
						r['guests'] = [ gc.first, gc.second ];
						fillDouble = false;
						counter += 2;
						break;
					}
				} 
			}
		} else {
			for (let r of rooms) {
				if (r.type === 'triple') {
					if (r['guests'] && r['guests'].length < 3 && r['gender'] == gc.first.gender) {
						r['guests'].push(gc.first);
						counter++;
						break;
					} else if (!r['guests']) {
						r['guests'] = [ gc.first ];
						r['gender'] = gc.first.gender;
						counter++;
						break;
					}
				} 
			}
			for (let r of rooms) {
				if (r.type === 'triple') {
					if (r['guests'] && r['guests'].length < 3 && r['gender'] == gc.second.gender) {
						r['guests'].push(gc.second);
						counter++;
						break;
					} else if (!r['guests']) {
						r['guests'] = [ gc.second ];
						r['gender'] = gc.second.gender;
						counter++;
						break;
					}
				} 
			}
		} 
	}
	let roomsKeys = Object.keys(rooms.sort((a, b) => a.number.localeCompare(b.number)));
	for (let k of roomsKeys) {
		let guests = 0;
		let emptyBeds = 0;
		console.log('Room number: ' + rooms[k]['number']);
		if (rooms[k]['guests']) {
			rooms[k]['guests'].sort((a, b) => a.name > b.name).forEach(x => {
				console.log('--Guest Name: ' + x['name']);
				console.log('--Guest Age: ' + x['age']);
			});
			guests = rooms[k]['guests'].length;
			if (rooms[k]['type'] === 'triple' && guests < 3) {
				emptyBeds = 3 - guests;
			} else if (rooms[k]['type'] === 'double-bedded' && guests === 0) {
				emptyBeds = 2;
			}
			console.log('Empty beds in the room: ' + emptyBeds);
		} else {
			console.log('Empty beds in the room: ' + (rooms[k]['type'] === 'triple' ? 3 : 2));
		}
	}
	console.log('Guests moved to the tea house: ' + (total - counter));
}
