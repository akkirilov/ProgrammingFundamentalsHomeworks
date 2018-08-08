
abstract class Employee {
    name: string;
    age: number;
    salary: number;
    tasks: Array<string>;

	constructor(name: string, age: number) {
		this.name = name;
		this.age = age;
		this.salary = 0;
		this.tasks = [];
	}
	
	work() {
	    let task = this.tasks.shift();
	    console.log(this.name + task);
	    this.tasks.push(task);
	}
	
	getSalary() {
	    return this.salary;
	}
	
	collectSalary() {
        console.log(`${this.name} received ${this.getSalary()} this month.`);
    }
}

class Junior extends Employee {
    constructor(name: string, age: number) {
        super(name, age);
        this.tasks.push(' is working on a simple task.');
    }
}

class Senior extends Employee {
    constructor(name: string, age: number) {
        super(name, age);
        this.tasks.push(' is working on a complicated task.');
        this.tasks.push(' is taking time off work.');
        this.tasks.push(' is supervising junior workers.');
    }
}

class Manager extends Employee {
    divident : number;

    constructor(name: string, age: number) {
        super(name, age);
        this.divident = 1000;
        this.tasks.push(' scheduled a meeting.');
        this.tasks.push(' is preparing a quarterly report.');
    }
    
    getSalary() {
        return this.salary + this.divident;
    }
}

let junior = new Junior('SuperJunior', 18);
junior.work();
junior.work();
junior.collectSalary();

let senior = new Senior('SuperSenior', 50);
senior.work();
senior.work();
senior.work();
senior.collectSalary();

let manager = new Manager('SuperManager', 100);
manager.work();
manager.work();
manager.work();
manager.collectSalary();
