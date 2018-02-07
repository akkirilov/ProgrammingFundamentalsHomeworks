// 01. The Pyramid of King Djoser
//pyramids(11, 1);
function pyramids(base, increment) {
	let stone = 0, marble = 0, lapis = 0, gold = 0, steps = 0;
	while (base > 0) {
		steps++;
		if ((base - 2) <= 0) {
			gold += (base * base);
			break;
		}
		let currStones = 0;
		if (base > 2) {
			let innerBase = (base - 2);
			currStones = (innerBase * innerBase);
			stone += currStones;
		}
		if (steps !== 0 && steps % 5 === 0) {
			lapis += (base * base) - currStones;
		} else {
			marble += (base * base) - currStones;
		}
		base -= 2;
	}
	console.log('Stone required: ' + Math.ceil(stone * increment));
	console.log('Marble required: ' + Math.ceil(marble * increment));
	console.log('Lapis Lazuli required: ' + Math.ceil(lapis * increment));
	console.log('Gold required: ' + Math.ceil(gold * increment));
	console.log('Final pyramid height: ' + Math.floor(steps * increment));
}

// 02. Jan's Notation
//notations([5,3,4,'*','-']);
//notations([31,2,'+', 11,'/']);
//notations([-1, 1, '+', 101, '*', 18,'+',3,'/']);
function notations(arr){
	if (arr.length <= 1) {
		console.log('Error: not enough operands!');
		return;
	}
	let res = 0;
	let first = arr[0];
	let second;
	let error = false;
	let i = 2;
	while (arr.length > 1) {
		if (i < arr.length) {
			if (isNaN(arr[i]) || arr[i] == '*') {
					let temp = calculate(arr[i - 2], arr[i - 1], arr[i]);
					arr.splice(i - 2, 3, temp);
					i = 2; 
					continue;
			} else if (!isNaN(arr[i]) && i == arr[arr.length - 1]) {
				console.log('Error: too many operands!');
				error = true;
				break;
			} else if (isNaN(arr[i]) && i == arr[arr.length - 1]) {
				console.log('Error: not enough operands!');
				error = true;
				break;
			}
			i++;
		} else {
			if (isNaN(arr[arr.length - 1])) {
				console.log('Error: not enough operands!');
				error = true;
				break;
			} else {
				console.log('Error: too many operands!');
				error = true;
				break;
			}
		}
	}
	if (!error) {
		console.log(arr[0]);
    }

	function calculate(first, second, operator) {
    	switch (operator) {
			case '+': return first + second;
			case '-': return first - second;
			case '*': return first * second;
			case '/': return first / second;
		}
    }
}

