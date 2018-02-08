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

// 03. XML Messenger
//XMLMessenger('<message to="Bob" from="Alice" timestamp="1497254092">Hey man, whats up?</message>');
//XMLMessenger('<message from="John Doe" to="Alice">Not much, just chillin. How about you?</message>');
//XMLMessenger('<message from="MasterBlaster" to="TheAnimal" color="#FF340B">FWD: Funny stuff</message>');
function XMLMessenger(msg) {
	let match;
	let message;
	let attributes;
	let attributeFormatPattern = /[^a-zA-Z0-9.<>=\s"]+/;
	let formatPattern = /(^<\s*message.+>)([^<>]+)<\/message>$/g;
	if (!(match = formatPattern.exec(msg)) || attributeFormatPattern.test(match[1])) {
    	console.log('Invalid message format');
    	return;
    } else {
    	message = match[2].split(/\n/g).filter(x => x !== '');
    }
	let hasSender = false;
	let hasRecipient = false;
	let error = false;
	let sender;
	let recipient;
	let attributePattern = /\b([a-zA-Z]{2,4})="([a-zA-Z0-9\s\.]+)"/g;
	while (match = attributePattern.exec(msg)) {
		if (match[1] == 'to' && !hasRecipient) {
			recipient = match[2];
			hasRecipient = true;
		} else if (match[1] == 'from' && !hasSender) {
			sender = match[2];
			hasSender = true;
		} else if (match[1] == 'from' && hasSender) {
			error = true;
			break;
		} else if (match[1] == 'to' && hasRecipient) {
			error = true;
			break;
		}
	}
	if (error || !hasSender || !hasRecipient) {
		console.log('Missing attributes');
    	return;
    }
	console.log('<article>');
	console.log('  <div>From: <span class="sender">' + sender + '</span></div>');
	console.log('  <div>To: <span class="recipient">' + recipient + '</span></div>');
	console.log('  <div>');
	for (let line of message) {
		console.log('    <p>' + line + '</p>');
	}
	console.log('  </div>');
	console.log('</article>');
}

// 04. Galactic Elections
elections([ { system: 'Tau',     candidate: 'Flying Shrimp', votes: 150 },
	  { system: 'Tau',     candidate: 'Space Cow',     votes: 100 },
	  { system: 'Theta',   candidate: 'Space Cow',     votes: 10 },
	  { system: 'Sigma',   candidate: 'Space Cow',     votes: 200 },
	  { system: 'Sigma',   candidate: 'Flying Shrimp', votes: 75 },
	  { system: 'Omicron', candidate: 'Flying Shrimp', votes: 50 },
	  { system: 'Omicron', candidate: 'Octocat',       votes: 75 } ]);
function elections(arr) {
	let systems = {};
	for (s in arr) {
		let system = arr[s]['system'];
		let candidate = arr[s]['candidate'];
		let votes = arr[s]['votes'];
		if (systems.hasOwnProperty(system)) {
			if (systems[system].hasOwnProperty(candidate)) {
				systems[system][candidate] += votes;
			} else {
				systems[system][candidate] = votes;
			}
		} else {
			systems[system] = {};
			systems[system][candidate] = votes;
		}
	}
	for (let s in systems) {
		let winner = Object.keys(systems[s]).sort((a, b) => systems[s][b] - systems[s][a])[0];
		let sum = systems[s][winner];
		for (let v in systems[s]) {
			if (v != winner) {
				sum += systems[s][v];
			}
		}
		systems[s]['winner'] = winner;
		systems[s]['winnerVotes'] = sum;
	}

	let sortedSystems = {};
	let systemsKeys = Object.keys(systems).sort((a, b) => systems[b]['winnerVotes'] - systems[a]['winnerVotes']);
	for (let s of systemsKeys) {
		sortedSystems[s] = systems[s];
	}
	console.log(sortedSystems);

}

