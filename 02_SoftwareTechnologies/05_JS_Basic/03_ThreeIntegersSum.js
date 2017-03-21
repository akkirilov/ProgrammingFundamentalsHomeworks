function solve(args){
    let nums = args[0].split(' ').map(Number);
    let num1 = nums[0];
    let num2 = nums[1];
    let num3 = nums[2];
    let first = "N";
    let res = "o";

    if (num1 == num2 + num3){
        if (num2 <= num3){
            first = `${num2} + ${num3} `;
        }
        else {
            first = `${num3} + ${num2} `;
        }
        res =  `= ${num1}`;
    }
    else if (num2 == num1 + num3){
        if (num1 <= num3){
            first = `${num1} + ${num3} `;
        }
        else {
            first = `${num3} + ${num1} `;
        }
        res =  `= ${num2}`;
    }
    else if (num3 == num2 + num1){
        if (num2 <= num1){
            first = `${num2} + ${num1} `;
        }
        else {
            first = `${num1} + ${num2} `;
        }
        res =  `= ${num3}`;
    }

    console.log(first + res);
}

solve();