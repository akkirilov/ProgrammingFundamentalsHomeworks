function solve(args){
    let arr = [];
    for (let line of args) {
        let tokens = line.split(' ');
        let command = tokens[0];
        let param = Number(tokens[1]);

        switch (command){
            case 'add':
                arr.push(param);
                break;
            case 'remove':
                if (arr.length > param) {
                    arr.splice(param, 1);
                };
                break;
        }
    }

    for (let n of arr){
        console.log(n);
    }
}

solve([
    'add 3',
    'add 5',
    'remove 1',
    'add 2'
]);