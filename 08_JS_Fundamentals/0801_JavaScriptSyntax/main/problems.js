//1. Sum 3 Numbers
function sumThreeNumbers(a, b, c) {
	console.log(a + b + c);
}

//2. Sum And VAT
function sumAndVAT(nums) {
	let sum = 0;
	for (var i = 0; i < nums.length; i++) {
		sum += nums[i];
	}
	console.log("sum = " + sum);
	console.log("VAT = " + (sum * 0.2));
	console.log("total = " + (sum * 1.2));
}

//3. Letter Occurences In String
function letterOccurencesInString(str, letter) {
	let count = 0;
	for (var i = 0; i < str.length; i++) {
		if (str[i] === letter) {
			count++;
		}
	}
	console.log(count);
}

//4. Filter By Age
function filterByAge(minAge, nameA, ageA, nameB,ageB) {
	let personA = {
			name:nameA,
			age:ageA
	}
	let personB = {
			name:nameB,
			age:ageB
	}
	if (personA.age >= minAge) {
		console.log(personA);
	}
	if (personB.age >= minAge) {
		console.log(personB);
	}
}

//5. String of Numbers 1..N
function stringOfNumbers(len) {
	let str = "";
	for (var i = 1; i <= len; i++) {
		str += i;
	}
	console.log(str);
}

//6. Figure Area
function figureArea(w, h, W, H) {
	let [s1, s2, s3] = [
		w * h, 
		W * H, 
		((w * h) +(W * H)) - (Math.min(H, h) * Math.min(W, w))
	];
	console.log(s3);
}

//7. Next Day
function nextDay(year, month, day) {
	let oneDay = 60 * 60 * 24 * 1000;
	let currDate = new Date(year, month - 1, day);
	let nextDate = new Date(currDate.getTime() + oneDay);
	let res = nextDate.getFullYear() + "-" + (nextDate.getMonth() + 1) + "-" + nextDate.getDate();
	console.log(res);
}

//8. Distance between Points
function distanceBetweenPoints(x1, y1, x2, y2) {
	let distance = Math.sqrt(Math.pow((x1 - x2), 2) + Math.pow((y1 - y2), 2));
	console.log(distance);
}

//sumThreeNumbers(1, 2, 3);
//sumAndVAT([1.20, 2.60, 3.50]);
//letterOccurencesInString("peshoto", "o");
//filterByAge(12, 'Ivan', 15, 'Asen', 9);
//stringOfNumbers(11);
//figureArea(2, 4, 5, 3);
//nextDay(2016, 2, 28);
//distanceBetweenPoints(2, 4, 5, 0);