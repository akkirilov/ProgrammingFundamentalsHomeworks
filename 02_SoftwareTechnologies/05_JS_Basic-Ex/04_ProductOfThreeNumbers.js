function solve(args){
    args = args.map(Number);

    let result = 1;
    for(let num of args) {
        result *= num;
    }

    if (result >= 0){
        console.log('Positive');
    } else {
        console.log('Negative');
    }
}

solve([
    '5',
    '-2',
    '-5'
]);