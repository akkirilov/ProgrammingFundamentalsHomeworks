function solve(args){
    let obj = {};
    for(let line of args){
        let tokens = line.split(' -> ');
        if(Number(tokens[1])){
            obj[tokens[0]] = Number(tokens[1]);
        } else {
            obj[tokens[0]] = tokens[1];
        }
    }

    obj = JSON.stringify(obj);
    console.log(obj);
}

solve([
    'name -> Angel',
    'surname -> Georgiev',
    'age -> 20',
    'grade -> 6.00',
    'date -> 23/05/1995',
    'town -> Sofia'
]);