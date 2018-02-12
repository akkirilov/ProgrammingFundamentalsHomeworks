problem03('<p>Some random text</p><svg><cat><text>How do you rate our food? [Food - General]</text></cat><cat><g><val>1</val>0</g><g><val>2</val>1</g><g><val>3</val>3</g><g><val>4</val>10</g><g><val>5</val>7</g></cat></svg><p>Some more random text</p>');
function problem03(text) {
	text = text.replace(/\n+/g, '');
	text = text.replace(/\t+/g, '');
	if (!(/<svg>/g.exec(text)) || !(/<\/svg>/g.exec(text))) {
		console.log('No survey found');
		return;
	}
	let svgPattern = /<svg><cat><text>.*\[(.+)\].*<\/text><\/cat>\s*<cat>(.*)<\/cat><\/svg>/g;
	let match;
	if (!(match = svgPattern.exec(text))) {
		console.log('Invalid format');
		return;
	}
	let valPattern = /<g><val>([1-9]|10)<\/val>(\d+)<\/g>/g;
	let valMatch;
	let total = 0;
	let count = 0;
	let foundAtLeastOne = false;
	while (valMatch = valPattern.exec(text)) {
		let val = Number(valMatch[1]);
		let c = Number(valMatch[2])
		total += (val * c);
		count += Number(c);
		foundAtLeastOne = true;
	}
	if (foundAtLeastOne) {
		console.log(match[1].trim() + ': ' + Number((total / count).toFixed(2).toString()));
	} else {
		console.log('Invalid format');
	}
}
