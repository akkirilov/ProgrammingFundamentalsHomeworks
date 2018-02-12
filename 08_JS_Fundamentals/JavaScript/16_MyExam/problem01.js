problem01([100, 200, 300]);
function problem01(arr) {
	arr = arr.filter(x => x != '').map(x => Number(x));
	let totalMoney = 0;
	let firstBC;
	let totalBC;
	let boughtBC = false;
	for (let i = 0, len = arr.length; i < len; i++) {
		if (i !== 0 && (i + 1) % 3 == 0) {
			totalMoney += (arr[i] * 0.7) * 67.51;
		} else {
			totalMoney += arr[i] * 67.51;
		}
		if (!boughtBC && totalMoney > 11949.16) {
			firstBC = i + 1;
			boughtBC = true;
		}
	}
	totalBC = Math.floor(totalMoney / 11949.16);
	console.log('Bought bitcoins: ' + totalBC);
	if (boughtBC) {
		console.log('Day of the first purchased bitcoin: ' + firstBC);
	}
	console.log('Left money: ' + (totalMoney - (totalBC * 11949.16)).toFixed(2) + ' lv.');
}
//Nrof1244