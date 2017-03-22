function solve(args){
    args = args.map(Number).sort((a, b) => b - a);
    let count = Math.min(args.length, 3);

    for (let i = 0; i < count; i++){
        console.log(args[i]);
    }
}

solve([
    10, 20
]);