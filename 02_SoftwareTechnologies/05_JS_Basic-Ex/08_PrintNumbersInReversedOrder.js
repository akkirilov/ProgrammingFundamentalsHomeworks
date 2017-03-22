function solve(args){
    args = args.map(Number).reverse();
    for (let num of args){
        console.log(num);
    }
}

solve([
    '5',
    '2',
    '12',
    '28',
    '25',
    '265',
    '15'
]);