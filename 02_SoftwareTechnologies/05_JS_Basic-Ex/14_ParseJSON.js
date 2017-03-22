function solve(args){
    let arr = [];
    for(let line of args){
        arr.push(JSON.parse(line));
    }

    for(let line of arr){
        console.log(`Name: ${line.name}`);
        console.log(`Age: ${line.age}`);
        console.log(`Date: ${line.date}`);
    }
}

solve([
    '{"name":"Gosho","age":10,"date":"19/06/2005"}',
    '{"name":"Tosho","age":11,"date":"04/04/2005"}'
]);