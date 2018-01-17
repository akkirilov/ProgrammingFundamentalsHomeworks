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

//sumThreeNumbers(1, 2, 3);
//sumAndVAT([1.20, 2.60, 3.50]);
//letterOccurencesInString("peshoto", "o");
filterByAge(12, 'Ivan', 15, 'Asen', 9);