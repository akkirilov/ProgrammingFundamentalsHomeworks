// 01. Split a String with a Delimiter
function splitString(str, delimiter) {
	str.split(delimiter)
		.filter(x => x !== '')
		.forEach(x => console.log(x));
}

// 02. Repeat a String N Times
function repeatString(str, n) {
	console.log(str.repeat(n));
}

// 03. Starts With
function stringStartsWith(str, startSubstr) {
	console.log(str.startsWith(startSubstr));
}

// 04. Ends With
function stringEndsWith(str, startSubstr) {
	console.log(str.endsWith(startSubstr));
}

// 05. Capitalize the Words
function capitalizeWords(str) {
	console.log(str.split(/\s+/g)
				.map(w => w[0]
				.toUpperCase() + w.substr(1).toLowerCase())
				.join(' '));
}

// 06. Capture the Numbers
function captureNumbers(arr) {
	let res = [];
	let pattern = /\d+/g;
	let match;
	for(let s of arr) {
		while (match = pattern.exec(s)) {
			res.push(match);
		}
	}
	console.log(res.join(' '));
}

// 07. Find Variable Names in Sentences
function findVariableNames(str) {
	let res = [];
	let pattern = /\b_{1,1}([a-zA-Z0-9]+)\b/g;
	let match;
	while (match = pattern.exec(str)) {
		res.push(match[1]);
	}
	console.log(res.join(','));
}

// 08. Word Occurences
function wordOccurences(str, word) {
	let regex = new RegExp('\\b' + word + '\\b', 'gi');
	if (regex.test(str)) {
		console.log(str.match(regex).length);
    } else {
    	console.log(0);
    }
}

// 09. Extract Links
function extractLinks(str) {
	let pattern = /(www)\.([a-zA-Z0-9-]+)(\.[a-z]+)+/g;
	let match;
	while (match = pattern.exec(str)) {
		console.log(match[0]);
	}
}

// 10. Secret Data
function secretData(arr) {
	let clientPattern = /\*[A-Z][A-Za-z]*(?=\s|\t|$)/g;
	let phonePattern = /\+[0-9-]{10,10}(?=\s|\t|$)/g;
	let idPattern = /\![a-zA-Z0-9]+(?=\s|\t|$)/g;
	let basesPattern = /_[a-zA-Z0-9]+(?=\s|\t|$)/g;
	
	for(let s of arr) {
		s = s.replace(clientPattern, (m) => '|'.repeat(m.length));
		s = s.replace(phonePattern, (m) => '|'.repeat(m.length));
		s = s.replace(idPattern, (m) => '|'.repeat(m.length));
		s = s.replace(basesPattern, (m) => '|'.repeat(m.length));
		console.log(s);
	}
}

//splitString('One-Two-Three---Four-Five -', '-');
//repeatString('asdf', 4);
//stringStartsWith('asad', 'A');
//stringEndsWith('asad', 'd');
//capitalizeWords('Capitalize theSE worDs');
//captureNumbers(['123a456', '789b987', '654c321', '0']);
//findVariableNames('__invalidVariable _evenMoreInvalidVariable_ _validVariable');
//wordOccurences('How do you plan on achieving that? How? How can you even think of that?', 'how');
//extractLinks('www.web-stars.com  www.internet.com www.webspiders101.com www.sentinel.-ko');
//secretData(['Agent *Ivankov  Agent *Ivankov was in. it was +555-49-796 subject !2491a23BVB34Q and returning to Base _Aurora21']);
