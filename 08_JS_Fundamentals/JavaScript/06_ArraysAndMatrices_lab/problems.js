// 01. Sum First Last
function sumFirstLast(arr) {
	return Number(arr[0]) + Number(arr[arr.length - 1]);
}

// 02. Even Position Elements
function evenPositionElements(arr) {
	return arr.filter((x, i) => i % 2 === 0).join(' ');
}

// 03. Negative / Positive Numbers
function negativeOrPositiveNumbers(arr) {
	res = [];
	for (var i = 0; i < arr.length; i++) {
		if (arr[i] < 0) {
			res.unshift(arr[i]);
		} else {
			res.push(arr[i]);
		}
	}
	return res;
}

// 04. First and Last K Numbers
function firstAndLastKNumbers(arr) {
	let k = arr.shift();
	console.log(arr.slice(0, k).join(' ') + '\n' 
			+ arr.slice(arr.length - k).join(' '));
}

// 05. Last K Numbers Sequence
function lastKNumbersSequence(n, k) {
	let res = [1];
	for (var i = 1; i < n; i++) {
		res.push(res.slice(Math.max(0, i - k), Math.max(i, res.length - k))
				.reduce((a, b) => a + b));
	}
	console.log(res.join(" "));
}

// 6. Process Odd Numbers
function processOddNumbers(arr) {
	console.log(arr
			.filter((x, i) => i % 2 !== 0)
			.map(x => x * 2)
			.reverse()
			.join(' '));
}

// 07. Smallest Two Numbers
function smallestTwoNumbers(arr) {
	console.log(arr.sort((a, b) => a - b)
				.slice(0, Math.min(arr.length, 2))
				.join(' '));
	
}

// 08. Biggest Element
function biggestElement(matrix) {
	let max = Number.NEGATIVE_INFINITY;
	matrix.forEach(x => x.forEach(y => {
			if (y > max) {
				max = y
			}
		}));
	console.log(max);
}

// 09. Diagonal Sums
function diagonalSums(matrix) {
	let firstDiagonal = 0;
	let secondDiagonal = 0;
	for (let r = 0; r < matrix.length; r++) {
		for (let c = 0; c < matrix[r].length; c++) {
			if (r === c) {
				firstDiagonal += matrix[r][c];
			}
			if (r === matrix[r].length - c - 1) {
				secondDiagonal += matrix[r][c];
			}
		}
	}
	console.log(firstDiagonal + ' ' + secondDiagonal);
}

// 10. Equal Neighbors
function equalNeighbors(matrix) {
	let counter = 0;
	for (let r = 0, rl = matrix.length; r < rl; r++) {
		for (let c = 0, cl = matrix[r].length; c < cl; c++) {
			if (r < rl - 1 && matrix[r][c] === matrix[r + 1][c]) {
				counter++;
			}
			if (c < cl - 1 && matrix[r][c] === matrix[r][c + 1]) {
				counter++;
			}
		}
	}
	console.log(counter);
}

// console.log(sumFirstLast([1,2,3,4]));
// console.log(evenPositionElements([0,1,2,3,4,5,6]));
// console.log(negativeOrPositiveNumbers([1,2,-5,3,-6,0]));
// firstAndLastKNumbers([2,1,2,3]);
// lastKNumbersSequence(6, 3);
// processOddNumbers([2, 3, 5, 7, 9, 55]);
// smallestTwoNumbers([30, 15, 50, 5]);
// biggestElement([[20, 50, 10], [8, 33, 145]]);
// diagonalSums([[20, 40], [10, 60]]);
// equalNeighbors([[2, 2, 5, 7, 4], [4, 0, 5, 3, 4], [2, 5, 5, 4, 2]]);
