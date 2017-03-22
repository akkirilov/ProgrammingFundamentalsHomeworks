function solve(args){
    let key = args.pop();
    let arr = [];
    for (let line of args) {
        let tokens = line.split(' ');
        if (key === tokens[0]){
            arr.push(tokens[1]);
        }
    }

    if (arr.length > 0){
        for (let line of arr) {
            console.log(line);
        }
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