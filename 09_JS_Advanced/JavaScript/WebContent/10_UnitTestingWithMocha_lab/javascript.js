// 01_Sub Sum
//console.log(subSum([ 1, 2, 3, 4, 5 ], -1, 3));
//console.log(subSum([ 1, 'dsd', 3, 4, 5 ], -1, 3));
function subSum(arr, startIndex, endIndex) {
	if (!(arr instanceof Array)) {
		return NaN;
	}
	if (startIndex < 0) {
		startIndex = 0;
	}
	if (endIndex >= arr.length) {
		endIndex = arr.length - 1;
	}
	let sum = 0;
	for (; startIndex <= endIndex; startIndex++) {
		sum += Number(arr[startIndex]);
	}
	return sum;
}

// 02. Playing Cards
//console.log(playingCards('10', 'H').toString());
//console.log(playingCards('1', 'H').toString());
//console.log(playingCards('10', 'HD').toString());
function playingCards(face, suit) {
	let validFaces = ['2', '3', '4', '5', '6', '7', '8', '9', '10', 'J', 'Q', 'K', 'A'];
	let validSuits = {'S': '\u2660', 'H': '\u2665', 'D': '\u2666', 'C': '\u2663'};
	function createCard(face, suit) {
		if (validFaces.indexOf(face) < 0) {
			throw new Error('Invalid face!');
		}
		if (!validSuits.hasOwnProperty(suit)) {
			throw new Error('Invalid suit!');
		}
		let card = {
				face,
				suit: validSuits[suit]
		}
		card.toString = () => {
			return '' + card.face + card.suit;
		}
		return card;
	}
	return createCard(face, suit);
}

// 03. Deck of Cards
//printDeckOfCards(['AS', '10D', 'KH', '2C']);
//printDeckOfCards(['AS', '100D', 'KH', '2C']);
function printDeckOfCards(arr) {
	let validFaces = ['2', '3', '4', '5', '6', '7', '8', '9', '10', 'J', 'Q', 'K', 'A'];
	let validSuits = {'S': '\u2660', 'H': '\u2665', 'D': '\u2666', 'C': '\u2663'};
	function createCard(face, suit) {
		if (validFaces.indexOf(face) < 0) {
			throw new Error('Invalid face!');
		}
		if (!validSuits.hasOwnProperty(suit)) {
			throw new Error('Invalid suit!');
		}
		let card = {
				face,
				suit: validSuits[suit]
		}
		card.toString = () => {
			return '' + card.face + card.suit;
		}
		return card;
	}
	let res = [];
	for (let i = 0, len = arr.length; i < len; i++) {
		let face = arr[i].substring(0, arr[i].length - 1);
		let suit = arr[i].substring(arr[i].length - 1);
		try {
			res.push(createCard(face, suit).toString());
		} catch (e) {
			console.log('Invalid card: ' + arr[i]);
		}
	}
	console.log(res.join(' '));
}

// Mocha tests

// 04. Sum of Numbers
function sum(arr) {
    let sum = 0;
    for (num of arr)
        sum += Number(num);
    return sum;
}

// 05. Check for Symmetry
function isSymmetric(arr) {
    if (!Array.isArray(arr))
        return false; // Non-arrays are non-symmetric
    let reversed = arr.slice(0).reverse(); // Clone and reverse
    let equal = (JSON.stringify(arr) == JSON.stringify(reversed));
    return equal;
}

// 06. RGB to Hex
//console.log(rgbToHexColor(255,254,255));
function rgbToHexColor(red, green, blue) {
    if (!Number.isInteger(red) || (red < 0) || (red > 255))
        return undefined; // Red value is invalid
    if (!Number.isInteger(green) || (green < 0) || (green > 255))
        return undefined; // Green value is invalid
    if (!Number.isInteger(blue) || (blue < 0) || (blue > 255))
        return undefined; // Blue value is invalid
    return "#" +
        ("0" + red.toString(16).toUpperCase()).slice(-2) +
        ("0" + green.toString(16).toUpperCase()).slice(-2) +
        ("0" + blue.toString(16).toUpperCase()).slice(-2);
}

// 07. Add / Subtract
function createCalculator() {
    let value = 0;
    return {
        add: function(num) { value += Number(num); },
        subtract: function(num) { value -= Number(num); },
        get: function() { return value; }
    }
}

module.exports = { sum, isSymmetric, rgbToHexColor, createCalculator };