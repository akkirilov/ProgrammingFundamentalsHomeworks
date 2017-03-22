function solve(args){
    let num = Number(args[0]);
    for(; num >= 1; num--) {
        console.log(num);
    }
}

solve([
    '5',
    '-2',
    '-5'
]);