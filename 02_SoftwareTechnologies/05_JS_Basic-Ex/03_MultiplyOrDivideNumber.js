function solve(args){
    let n = Number(args[0]);
    let x = Number(args[1]);

    if (x >= n){
        console.log(x * n);
    } else {
        console.log(n / x);
    }
}

solve([
    '5',
    '2'
]);