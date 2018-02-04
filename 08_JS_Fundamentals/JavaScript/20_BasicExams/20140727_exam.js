// 01. Build a Table
// buildTable([999999, 1000000]);
function buildTable(arr) {
	let [start, end] = [ arr[0], arr[1] ];
	let res = '<table>\n' +
		'<tr><th>Num</th><th>Square</th><th>Fib</th></tr>\n';
	for (let i = start; i <= end; i++) {
		res += '<tr><td>' + i + '</td>' + '<td>' + i * i + '</td>' + '<td>' + isFib(i) + '</td></tr>\n';
	}
	res += '</table>';
	console.log(res);

	function isFib(n) {
		if (n < 1) {
			return 'no';
		}
		let a = 1,
			b = 0,
			temp;
		while (a <= n) {
			temp = a;
			a = a + b;
			b = temp;
			if (b == n || a == n) {
				return 'yes';
			}
		}
		return 'no';
	}
}

// 02. Reveal Triangles
//revealTriangles(['dffdsgyefg', 'ffffeyeee', 'jbfffays', 'dagfffdsss', 'dfdfa', 'dadaaadddf', 'sdaaaaa', 'daaaaaaasf']);
function revealTriangles(arr) {
	let res = [];
	for (let e of arr) {
		res.push(e.split('')); }
	for (let r = 1; r < arr.length; r++) {
		let maxCol = Math.min(arr[r].length - 3, arr[r - 1].length - 2);
		for (let col = 0; col <= maxCol; col++) {
			let a = arr[r][col];
			let b = arr[r][col + 1];
			let c = arr[r][col + 2];
			let d = arr[r - 1][col + 1];
			if (a == b && b == c && c == d) {
				res[r][col] = '*';
				res[r][col + 1] = '*';
				res[r][col + 2] = '*';
				res[r - 1][col + 1] = '*';
			}
		}
	}
	for (let i = 0; i < res.length; i++) {
		console.log(res[i].join(''));
	}
}

// 03. Extract Hyperlinks
//extractHyperlinks(['<link href="theme.css" rel="stylesheet" />',
//	'<ul><li><a   href="/"  id="home">Home</a></li><li><a',
//	' class="selected" href=/courses>Courses</a>',
//	'</li><li><a href = ',
//	"'/forum' >Forum</a></li><li><a class=" + '"href"',
//	'onclick="go()" href= "#">Forum</a></li>',
//	'<li><a id="js" href =',
//	'"javascript:alert(' + "'hi yo')" + '" class="new">click</a></li>',
//	'<li><a id=' + "'nakov' href =",
//	'http://www.nakov.com class=' + "'new'>nak</a></li></ul>",
//	'<a href="#empty"></a>',
//	'<a id="href">href=' + "'fake'<img src='http://abv.bg/i.gif' ",
//	'alt=' + "'abv'/></a><a href=" + '"#">&lt;a href=' + "'hello'&gt;</a>",
//	'<!-- This code is commented:',
//	'<a href="#commented">commentex hyperlink</a> -->']);
function extractHyperlinks(arr) {
	let pattern = /<a\s+([^>]+)?href\s*=\s*('([^']*)'|"([^"]*)"|([^\s>]+))[^>]*>/g;
	let text = arr.join('\n');
	let match;
	while (match = pattern.exec(text)) {
		let hrefValue = match[3];
		if (hrefValue == undefined) {
			hrefValue = match[4];
		}
		if (hrefValue == undefined) {
			hrefValue = match[5];
		}
		console.log(hrefValue);
	}
}

// 04. Concerts
concerts([ 'ZZ Top | London | 2-Aug-2014 | Wembley Stadium',
	'Iron Maiden | London | 28-Jul-2014 | Wembley Stadium',
	'Metallica | Sofia | 11-Aug-2014 | Lokomotiv Stadium',
	'Helloween | Sofia | 1-Nov-2014 | Vassil Levski Stadium',
	'Iron Maiden | Sofia | 20-June-2015 | Vassil Levski Stadium',
	'Helloween | Sofia | 30-July-2015 | Vassil Levski Stadium',
	'Iron Maiden | Sofia | 26-Sep-2014 | Lokomotiv Stadium',
	'Helloween | London | 28-Jul-2014 | Wembley Stadium',
	'Twisted Sister | London | 30-Sep-2014 | Wembley Stadium',
	'Metallica | London | 03-Oct-2014 | Olympic Stadium',
	'Iron Maiden | Sofia | 11-Apr-2016 | Lokomotiv Stadium',
	'Iron Maiden | Buenos Aires | 03-Mar-2014 | River Plate Stadium' ]);
function concerts(arr) {
	let concerts = {};
	for (let e of arr) {
		let [band, town, date, venue] = e.split(/\s*\|\s*/).filter(x => x !== '');
		let temp = {};
		if (concerts[town]) {
			temp = concerts[town];
			if (temp[venue]) {
				if (temp[venue].indexOf(band) < 0) {
					temp[venue].push(band);
				}
			} else {
				temp[venue] = [band];
			}
			concerts[town] = temp;
		} else {
			temp[venue] = [band];
			concerts[town] = temp;
		} 
	}
	let sortedConcerts = {};
	let townKeys = Object.keys(concerts).sort((a, b) => a.localeCompare(b));
	for (let ck of townKeys) {
		sortedConcerts[ck] = {};
		let venueKeys = Object.keys(concerts[ck]).sort((a, b) => a.localeCompare(b));
		for (let vk of venueKeys) {
			if (concerts[ck][vk]) {
				sortedConcerts[ck][vk] = concerts[ck][vk].sort((a, b) => a.localeCompare(b)); 
			}
		} 
	}
	console.log(JSON.stringify(sortedConcerts).replace(',"undefined":{"undefined":[null]}', ''));
}
