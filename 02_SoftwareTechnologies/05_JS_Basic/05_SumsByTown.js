function solve(args){

    let result = {};
    for (let i = 0; i < args.length; i++){
        let current = JSON.parse(args[i]);
        if(result[current.town] || result[current.town] === 0){
            result[current.town] += current.income;
        } else {
            result[current.town] = current.income;
        }
    }

    let towns = Object.keys(result).sort();
    for (let i = 0; i < args.length; i++){
        if(`${towns[i]}` != `undefined`) {
            console.log(`${towns[i]}` + ` -> ` + `${result[towns[i]]}`);
        }
    }
}

solve();