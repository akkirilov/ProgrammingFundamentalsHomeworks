function solve(args){
    let key = args.pop();
    let arr = [];
    for (let line of args) {
        let tokens = line.split(' ');
        arr[tokens[0]] = tokens[1];
    }

    if (arr[key] != undefined){
        console.log(arr[key]);
    } else {
        console.log('None');
    }
}

solve([
    'key value',
    'key eulav',
    'test tset',
    'key'
]);