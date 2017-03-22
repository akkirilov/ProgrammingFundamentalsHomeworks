function solve(args){
    let arr = [];
    for(let line of args){
        let tokens = line.split(' -> ');
        let obj = {
            name:tokens[0],
            age:Number(tokens[1]),
            grade:Number(tokens[2]).toFixed(2)
        };
        arr.push(obj);
    }

    for(let line of arr){
        console.log(`Name: ${line.name}`);
        console.log(`Age: ${line.age}`);
        console.log(`Grade: ${line.grade}`);
    }
}

solve([
    'Pesho -> 13 -> 6.00',
    'Ivan -> 12 -> 5.57',
    'Toni -> 13 -> 4.90'
]);