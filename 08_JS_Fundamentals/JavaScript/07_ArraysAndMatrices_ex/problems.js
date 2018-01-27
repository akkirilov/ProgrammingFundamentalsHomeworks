// 01. Print Array with Given Delimiter
function printArrayWithGivenDelimiter(arr) {
	let delimiter = arr.pop();
	console.log(arr.join(delimiter));
}

// 02. Print every N-th Element from an Array
function printEveryNthElement(arr) {
	let n = arr.pop();
	arr.forEach((x, i) => {
		if (i % n === 0) {
			console.log(x);
		}
	});
}

// 03. Add and Remove Elements
function addAndRemoveElements(arr) {
	let res = [1];
	for (let i = 1, l = arr.length; i <= l; i++) {
		switch (arr[i]) {
		case 'add':
			res.push(i + 1);
			break;
		case 'remove':
			res.pop();
			break;
		default:
			break;
		}
	}
	if (res.length < 1) {
		console.log('Empty');
	} else {
		res.forEach(x => console.log(x));
	}
}

// 04. Rotate Array
function rotateArray(arr) {
	let n = arr.pop();
	for (let i = 0, l = n % arr.length; i < l; i++) {
		let temp = arr.pop(arr[0]);
		arr.unshift(temp);
	}
	console.log(arr.join(' '));
}

// 05. Extract Increasing Subsequence from Array
function extractIncreasingSubsequenceFromArray(arr) {
	let max = arr[0];
	arr.filter((x, i) => {
		if (i === 0 || arr[i] >= max){
			console.log(arr[i]);
			max = arr[i];
		}
	});
}

// 06. Sort Array
function sortArray(arr) {
	arr = arr.sort((a, b) => {
		if (a.length === b.length) {
			return a > b;
		} else {
			return a.length > b.length;
		}
	}).forEach(x => console.log(x));
}

// 07. Magic Matrices
function magicMatrices(matrix) {
	let rowSum = 0;
	let colSumArr = [];
	for (let r = 0, rl = matrix.length; r < rl; r++) {
		let currRowSum = 0;
		for (let c = 0, cl = matrix[r].length; c < cl; c++) {
			currRowSum += matrix[r][c];
			colSumArr[c] = colSumArr.length <= c ? matrix[r][c] : colSumArr[c]+= matrix[r][c];
		}
		if (r === 0) {
			rowSum = currRowSum;
		} else if (rowSum !== currRowSum) {
			console.log(false);
			return;
		}
	}
	for (let i = 0, l = colSumArr.length; i < l; i++) {
		if (colSumArr[i] !== rowSum) {
			console.log(false);
			return;
		}
	}
	console.log(true);
}

// 08. Spiral Matrix
function spiralMatrix(rows, cols) {
	let startRow = 0;
	let endRow = rows - 1;
	let startCol = 0;
	let endCol = cols - 1;
	
	let res = [];
	for(let i = 0; i < rows; i++) {
	    res[i] = [];
	}
	
	let val = 1;
	let counter = 0;
	while (counter < rows * cols) {
		for (let i = startCol; i <= endCol; i++) {
			res[startRow][i] = val++;
			counter++;
		}
		startRow++;
		for (let i = startRow; i <= endRow; i++) {
			res[i][endCol] = val++;
			counter++;
		}
		endCol--;
		for (let i = endCol; i >= startCol; i--) {
			res[endRow][i] = val++;
			counter++;
		}
		endRow--;
		for (let i = endRow; i >= startRow; i--) {
			res[i][startCol] = val++;
			counter++;
		}
		startCol++;
	}
	
	for (let r = 0; r < rows; r++) {
		console.log(res[r].join(' '));
	}
}

// printArrayWithGivenDelimiter([1,2,3,4,5,':']);
// printEveryNthElement([0, 1, 2, 3, 4, 5, 3]);
// addAndRemoveElements(['add', 'add', 'add', 'add']);
// rotateArray(['a', 'b', 'c', 'd', 2]);
// extractIncreasingSubsequenceFromArray([1, 3, 8, 4, 10, 12, 3, 2, 24]);
// sortArray(['Isacc', 'Theodor', 'Jack', 'Harrison', 'George']);
// magicMatrices([[1,2,3], [3,1,2], [2,3,1]]);
// spiralMatrix(5, 5);

