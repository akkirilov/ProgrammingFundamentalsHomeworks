
abstract class Melon {
    public weight : number;
    public melonSort : string;
    private elementIndex: number;
    protected elementType : string;

    constructor(weight : number, melonSort : string) {
        this.weight = weight;
        this.melonSort = melonSort;
        this.elementIndex = weight * melonSort.length;
    }
    
    
    get getElementIndex(){
        return this.elementIndex;
    }
    
    toString() {
        return `Element: ${this.elementType}\nSort: ${this.melonSort}\nElement Index: ${this.elementIndex}`;
    }
}

class WaterMelon extends Melon {
    constructor(weight : number, melonSort : string) {
    	super(weight, melonSort);
    	this.elementType = 'Water';
    }
}

class FireMelon extends Melon {
    constructor(weight : number, melonSort : string) {
        super(weight, melonSort);
        this.elementType = 'Fire';
    }
}

class EarthMelon extends Melon {
    constructor(weight : number, melonSort : string) {
        super(weight, melonSort);
        this.elementType = 'Earth';
    }
}

class AirMelon extends Melon {
    constructor(weight : number, melonSort : string) {
        super(weight, melonSort);
        this.elementType = 'Air';
    }
}

class Melolemonmelon extends Melon {
    private types : Array<string> = ['Fire', 'Earth', 'Air', 'Water'];
    constructor(weight : number, melonSort : string) {
        super(weight, melonSort);
        this.elementType = 'Water';
    }
    
    morph() {
        let type = this.types.shift();
        this.elementType = type;
        this.types.push(type);
    }
}
//
//let watermelon : WaterMelon = new WaterMelon(12.5, "Kingsize");
//console.log(watermelon.toString());
//
//let firemelon : FireMelon = new FireMelon(15, "KingFire");
//console.log(firemelon.toString());

let melolemonmelon : Melolemonmelon = new Melolemonmelon(15, "KingFire");
console.log(melolemonmelon.toString());
melolemonmelon.morph();
console.log(melolemonmelon.toString());
melolemonmelon.morph();
console.log(melolemonmelon.toString());
melolemonmelon.morph();
console.log(melolemonmelon.toString());
melolemonmelon.morph();
console.log(melolemonmelon.toString());
