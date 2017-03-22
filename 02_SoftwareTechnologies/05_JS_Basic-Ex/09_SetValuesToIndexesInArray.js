function solve(args){
    let length = Number(args[0]);
    args.splice(0,1);

    let arr = [];
    for (let line of args) {
        let tokens = line.split(' - ').map(Number);
        arr[tokens[0]] = tokens[1];
    }

    for (let i = 0; i < length; i++){
        if(arr[i]=== undefined){
            console.log(0);
        } else {
            console.log(arr[i]);
        }
    }
}

solve([
    '5',
    '2 - 2',
    '1 - 1',
    '4 - 4'
]);