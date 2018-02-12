problem02([
	  "5 7 3 28 32",
	  "41 12 49 30 33",
	  "3 16 20 42 12",
	  "2 20 10 39 14",
	  "7 34 4 27 24",
	],
	[ 
	  "smog 11", "gale 3", 
	  "breeze 1", "smog 2"
	]);
function problem02(arr, commands) {
	arr = arr.filter(x => x != '');
	let matrix = [];
	for (let i = 0, len = arr.length; i < len; i++) {
		matrix.push(arr[i].split(' ').map(x => Number(x)));
	}
	for (let c of commands) {
		let tokens = c.split(' ');
		if (tokens[0] == 'breeze') {
			let row = Number(tokens[1]);
			for (let c = 0, len = matrix[row].length; c < len; c++) {
				if ((matrix[row][c] - 15) < 0) {
					matrix[row][c] = 0;
				} else {
					matrix[row][c] -= 15;
				}
			}
		} else if (tokens[0] == 'gale') {
			let col = Number(tokens[1]);
			for (let r = 0, len = matrix.length; r < len; r++) {
				if ((matrix[r][col] - 20) < 0) {
					matrix[r][col] = 0;
				} else {
					matrix[r][col] -= 20;
				}
			}
		} else if (tokens[0] == 'smog') {
			let num = Number(tokens[1]);
			for (let r = 0; r < matrix.length; r++) {
				for (let c = 0; c < matrix[r].length; c++) {
					if (matrix[r][c] + num < 0) {
						matrix[r][c] = 0;
					} else {
						matrix[r][c] += num;
					}
				}
			}
		}
	}
	let pollutedAreas = [];
	for (let r = 0; r < matrix.length; r++) {
		for (let c = 0; c < matrix[r].length; c++) {
			if (matrix[r][c] >= 50) {
				pollutedAreas.push('[' + r + '-' + c + ']');
			} 
		}
	}
	if (pollutedAreas.length > 0) {
		console.log('Polluted areas: ' + pollutedAreas.join(', '));
	} else {
		console.log('No polluted areas');
	}
}
