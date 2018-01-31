// 1. Print Letters
function printLetters(str) {
	for (let i in str) {
		console.log(`str[${i}] -> ${str[i]}`);
	}
}

// 2. Concatenate Reversed
function concatenateReversed(arr) {
	let res = arr.join('')
		.split('')
		.reverse()
		.join('');
	console.log(res);
}

// 3. Count Occurrences
function countOccurrences(target, str) {
	let counter = 0;
	let index = str.indexOf(target);
	while (index > -1) {
		counter++;
		index = str.indexOf(target, index + 1);
	}
	console.log(counter);
}

// 4. Extract Text
function extractText(str) {
	let res = [];
	let startIndex = str.indexOf('(');
	while (startIndex > -1) {
		let endIndex = str.indexOf(')', startIndex);
		if (endIndex < 0) {
			break;
		}
		res.push(str.substring(startIndex + 1, endIndex));
		startIndex = str.indexOf('(', endIndex + 1);
	}
	console.log(res.join(', '));
}

// 5. Aggregate Table
function aggregateTable(arr) {
	let cities = [];
	let sum = 0;
	for (let ell of arr) {
		let tokens = ell.split("|").map(x => x.trim()).filter(x => '' !== String(x));
		cities.push(tokens[0]);
		sum += Number(tokens[1]); }
	console.log(cities.join(', '));
	console.log(sum);
}

// 6. Restaurant Bill
function restaurantBill(arr) {
	let purchased = arr.map(x => x.match(/[^(\d+)|(\d+\.\d+)]+/)).filter(x => x !== null);
	let sum = arr.map(x => Number(x.match(/\d+\.\d+|\d+/))).reduce((a, b) => a + b);
	console.log('You purchased ' + purchased.join(', ') + ' for a total sum of ' + sum);
}

// 07. Usernames
function usernames(arr) {
	let users = [];
	for (let e of arr) {
		let tokens = e.split(/\@/);
		users.push(tokens[0] + '.' + tokens[1].split(/\./).map(x => x[0]).join('')); }
	console.log(users.join(', '));
}

// 08. Censorship
function censorship(str, arr) {
	for (let e of arr) {
		str = str.replace(new RegExp(e, 'g'), '-'.repeat(e.length)); }
	console.log(str);
}

// 09. Escaping
function escaping(arr) {
	let escSymbols = [];
	escSymbols['&'] = '&amp;';
	escSymbols['<'] = '&lt;';
	escSymbols['>'] = '&gt;';
	escSymbols['"'] = '&quot;';

	let res = '<ul>\n';

	for (let e of arr) {
		for (let l in escSymbols) {
			e = e.replace(new RegExp(l, 'g'), escSymbols[l]);
		}
		res += '  <li>' + e + '</li>\n'; }
	res += '</ul>'
	console.log(res);
}

// 10. Match All Words
function matchAllWords(str) {
	let res = str.match(/[\w\d]+/g).join('|');
	console.log(res);
}

// 11. Email Validation
function emailValidation(mail) {
	let pattern = /^[a-zA-Z0-9]+\@[a-z]+\.[a-z]+$/g;
	if (mail.match(pattern)) {
		console.log('Valid');
	} else {
		console.log('Invalid');
	}
}

// 12. Expression Split
function expressionSplit(code) {
	let pattern = /\s+|\.|;|,|\(|\)/g;
	let res = code.split(pattern).filter(x => String(x) != '');
	for (let e of res) {
		console.log(e); }
}

// 13. Match the Dates
function matchTheDates(str) {
	let res = [];
	let match;
	let pattern = /\b([0-9]{1,2})-([A-Z][a-z]{2})-([0-9]{4})\b/g;
	for (let s of str) {
		while (match = pattern.exec(s)) {
			res.push(`${match[0]} (Day: ${match[1]}, Month: ${match[2]}, Year: ${match[3]})`);
		} }
	console.log(res.join("\n"));
}

// 14. Employee Data
function employeeData(arr) {
	let pattern = /^([A-Z][a-zA-Z]*) - ([1-9][0-9]*) - ([a-zA-Z0-9- ]+)$/;
	let match;
	for (let e of arr) {
		match = pattern.exec(e)
		if (match) {
			let res = `Name: ${match[1]}\n` +
				`Position: ${match[3]}\n` +
				`Salary: ${match[2]}`;
			console.log(res); 
		}
	}
}

// 15. Form Filler
function formFiller(userName, mail, phone, forms) {
	let userNamePattern = /<\![a-zA-Z]+\!>/g;
	let mailNamePattern = /<@[a-zA-Z]+@>/g;
	let phoneNamePattern = /<\+[a-zA-Z]+\+>/g;
	for (let f of forms) {
		f = f.replace(userNamePattern, userName);
		f = f.replace(mailNamePattern, mail);
		f = f.replace(phoneNamePattern, phone);
		console.log(f);
	}
}

// 16. Match Multiplication
function matchMultiplication(str) {
	let pattern = /(-?\d+)\s*\*\s*(-?\d+(\.\d+)?)/g;
	str = str.replace(pattern, (match, num1, num2) => Number(num1) * Number(num2));
	console.log(str);
}

//printLetters('Hello, World!');
//concatenateReversed(['I', 'am', 'student']);
//countOccurrences('ma', 'Marine mammal training is the training and caring for ' +
//		'marine life such as, dolphins, killer whales, sea lions, walruses, ' +
//		'and other marine mammals. It is also a duty of the trainer to do mental ' +
//		'and physical exercises to keep the animal healthy and happy.');
//extractText('Rakiya (Bulgarian brandy) is self-made liquor (alcoholic drink)');
//aggregateTable(['| Sofia           | 300.2', '| Veliko Tarnovo  | 500', '| Yambol          | 275']);
//restaurantBill(['Beer Zagorka', '2.65', 'Tripe soup', '7.80','Lasagna', '5.69']);
//usernames(['peshoo@gmail.com', 'todor_43@mail.dir.bg', 'foo@bar.com']);
//censorship('David Ruben Piqtoukun (born 1950) is an Inuit artist from Paulatuk, Northwest ' +
//		'Territories. His output includes sculpture and prints; the sculptural work is innovative in ' +
//		'its use of mixed media. His materials and imagery bring together modern and traditional Inuit ' +
//		'stylistic elements in a personal vision. An example of this is his work "The Passage of Time" (1999), ' +
//		'which portrays a shaman in the form of a salmon moving through a hole in a hand. While shamanic ' +
//		'imagery is common in much of Inuit art, the hand in this work is sheet metal, not a traditional ' +
//		'material such as walrus ivory, caribou antler or soapstone. Ruben\'s brother, Abraham Apakark Anghik ' +
//		'Ruben, is also a sculptor. Fellow Inuit artist Floyd Kuptana learned sculpting techniques as an apprentice ' +
//		'to David Ruben.', ['Inuit']);
//escaping(['<b>unescaped text</b>', 'normal text']);
//matchAllWords('_(Underscores) are also word characters');
//emailValidation('val56id@e.mas3il.bg')
//expressionSplit('let sum = 4 * 4,b = "wow";');
//matchTheDates(['I am born on 30-Dec-1994.', 'This is not date: 512-Jan-1996.', 'My father is born on the 29-Jul-1955.']);
//employeeData(['Isacc - 1000 - CEO', 'Ivan - 500 - Employee', 'Peter - 500 - Employee']);
//formFiller('Pesho', 'pesho@softuni.bg', '90-60-90', ['Hello, <!username!>!',
//		'Welcome to your Personal profile.',
//		'Here you can modify your profile freely.',
//		'Your current username is: <!fdsfs!>. Would you like to change that? (Y/N)',
//		'Your current email is: <@DasEmail@>. Would you like to change that? (Y/N)',
//		'Your current phone number is: <+number+>. Would you like to change that? (Y/N)' ]);
//matchMultiplication('My bill: 2*2.50 (beer); 2* 1.20 (kepab); -2  * 0.5 (deposit).');

