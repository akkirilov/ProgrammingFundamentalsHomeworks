// 01. Add / Remove Towns
function attachEvents() {
	$('#btnDelete').on('click', function() {
		$('#towns option:selected').remove();
	});
	$('#btnAdd').on('click', function() {
		let newItem = $('#newItem');
		if (newItem.val() == '') {
			return;
		}
		$('#towns').append($('<option>').text(newItem.val()));
		newItem.val('');
	});
}

// 02. Add / Swap / Shift Left / Right in List
//Tests in p20_20161113_02_tests.js
function createList() {
    let data = [];
    return {
        add: function (item) {
            data.push(item)
        },
        shiftLeft: function () {
            if (data.length > 1) {
                let first = data.shift();
                data.push(first);
            }
        },
        shiftRight: function () {
            if (data.length > 1) {
                let last = data.pop();
                data.unshift(last);
            }
        },
        swap: function (index1, index2) {
            if (!Number.isInteger(index1) || index1 < 0 || index1 >= data.length ||
                !Number.isInteger(index2) || index2 < 0 || index2 >= data.length ||
                index1 === index2) {
                return false;
            }
            let temp = data[index1];
            data[index1] = data[index2];
            data[index2] = temp;
            return true;
        },
        toString: function () {
            return data.join(", ");
        }
    };
}

// 03. Mail Box
class MailBox {
	constructor() {
		this.messages = [];
	}
	get messageCount() {
		return this.messages.length;
	}
	addMessage(subject, text) {
		this.messages.push({subject: subject, text: text});
		return this;
	}
	deleteAllMessages() {
		this.messages = [];
	}
	findBySubject(substr) {
		return this.messages.filter(x => x.subject.includes(substr));
	}
	toString() {
		if (this.messages.length === 0) {
			return '* (empty mailbox)';
		}
		return this.messages.map(x => '* [' + x.subject + '] ' + x.text).join('\n');
	}
}

// 04. Cards
function cardDeckBuilder(selector) {
	let validFaces = ['2', '3', '4', '5', '6', '7', '8', '9', '10', 'J', 'Q', 'K', 'A'];
	let validSuits = {C: '\u2663', S: '\u2660', D: '\u2666', H: '\u2665'}
	let el = $(selector);
	function createCard(face, suit) {
		if (validFaces.indexOf(face) < 0 || validSuits[suit] === undefined) {
			return undefined;
		}
		return face + ' ' + validSuits[suit];
	}
	function reverseOrder() {
		let cards = el.children('.card');
		el.append(cards.get().reverse());
	}
	return {
		addCard: function (face, suit) {
			let card = createCard(face, suit);
			if (card !== undefined) {
				let newCard = $('<div>').addClass('card').text(card);
				newCard.on('click', reverseOrder);
				el.append(newCard);
			}
		}
	}
}

module.exports = { createList };
