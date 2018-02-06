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
		}
	}
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
		}
	}
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
