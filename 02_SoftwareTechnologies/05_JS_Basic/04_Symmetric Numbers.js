function solve(args){
    let num = Number(args[0]);
    let result = "";
    for (let i = 1; i <= num; i++){
        if(i < 10){
            result += `${i} `;
        }
        else {
            let isSimetric = true;
            let temp = `${i}`;
            for(let j = 0; j < temp.length / 2; j++){
                if (temp[j] != temp[temp.length - 1 - j]){
                    isSimetric = false;
                    break;
                }
            }

            if(isSimetric){
                result += `${i} `;
            }
        }
    }

    console.log(result);
}

solve();