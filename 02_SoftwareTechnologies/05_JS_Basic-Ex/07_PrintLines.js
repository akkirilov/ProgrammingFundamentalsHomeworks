function solve(args){
    for(let line of args) {
        if(line === 'Stop'){
            break;
        }
        console.log(line);
    }
}

solve([
    'Line 1',
    'Line 2',
    'Line 3',
    'Stop',
    'Line 4',
    'Line 5'
]);