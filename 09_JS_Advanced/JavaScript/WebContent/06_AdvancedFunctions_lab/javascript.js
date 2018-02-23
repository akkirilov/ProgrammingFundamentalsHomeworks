// 01. Aggregates
//aggregates([2,3,10,5]);
function aggregates(arr) {
	function reducer(func) {
		return arr.reduce(func);
	}
	console.log('Sum = ' + reducer((a, b) => a + b));
	console.log('Min = ' + reducer((a, b) => Math.min(a, b)));
	console.log('Max = ' + reducer((a, b) => Math.max(a, b)));
	console.log('Product = ' + reducer((a, b) => a * b));
	console.log('Join = ' + reducer((a, b) => '' + a + b));
}

// 02. Currency Format
// currencyFormat();
function currencyFormat(func) {
	function currencyFormatter(separator, symbol, symbolFirst, value) {
	    let result = Math.trunc(value) + separator;
	    result += value.toFixed(2).substr(-2,2);
	    if (symbolFirst) {
	    	return symbol + ' ' + result;
	    } else {
	    	return result + ' ' + symbol;
	    }
	}
	
	function dollarFormatter(func) {
		return function(value) {
			return func(',', '$', true, value);
		}
	}
	
// let formatter = dollarFormatter(currencyFormatter);
// console.log(formatter(5412.5656));
	return dollarFormatter(func);
}

// 03. Command Processor
// commandProcessor(['append hello',
// 'append again',
// 'removeStart 3',
// 'removeEnd 4',
// 'print']);
function commandProcessor(commands) {
	let processor = (function() {
		let str = '';
		return {
			append: (s) => str += s,
			removeStart: (n) => str = str.substring(n),
			removeEnd: (n) => str = str.substring(0, str.length - n),
			print: () => console.log(str)
		}
	})();
	for (let ct of commands) {
		let [c, v] = ct.split(/\s+/);
		processor[c](v);
	}
}

// 04. Max Element
//maxElement([10, 20, 5]);
function maxElement(arr) {
// console.log(Math.max.apply(this, arr));
	return Math.max.apply(this, arr);
}

// 05. Next Article
function getArticleGenerator(arr) {
	return function() {
		if (arr.length > 0) {
			$('#content')
				.append($('<article>')
					.text(arr.shift())
				);
		}
	}
}
