var __extends = (this && this.__extends) || (function () {
    var extendStatics = Object.setPrototypeOf ||
        ({ __proto__: [] } instanceof Array && function (d, b) { d.__proto__ = b; }) ||
        function (d, b) { for (var p in b) if (b.hasOwnProperty(p)) d[p] = b[p]; };
    return function (d, b) {
        extendStatics(d, b);
        function __() { this.constructor = d; }
        d.prototype = b === null ? Object.create(b) : (__.prototype = b.prototype, new __());
    };
})();
var Employee = (function () {
    function Employee(name, age) {
        this.name = name;
        this.age = age;
        this.salary = 0;
        this.tasks = [];
    }
    Employee.prototype.work = function () {
        var task = this.tasks.shift();
        console.log(this.name + task);
        this.tasks.push(task);
    };
    Employee.prototype.getSalary = function () {
        return this.salary;
    };
    Employee.prototype.collectSalary = function () {
        console.log(this.name + " received " + this.getSalary() + " this month.");
    };
    return Employee;
}());
var Junior = (function (_super) {
    __extends(Junior, _super);
    function Junior(name, age) {
        var _this = _super.call(this, name, age) || this;
        _this.tasks.push(' is working on a simple task.');
        return _this;
    }
    return Junior;
}(Employee));
var Senior = (function (_super) {
    __extends(Senior, _super);
    function Senior(name, age) {
        var _this = _super.call(this, name, age) || this;
        _this.tasks.push(' is working on a complicated task.');
        _this.tasks.push(' is taking time off work.');
        _this.tasks.push(' is supervising junior workers.');
        return _this;
    }
    return Senior;
}(Employee));
var Manager = (function (_super) {
    __extends(Manager, _super);
    function Manager(name, age) {
        var _this = _super.call(this, name, age) || this;
        _this.divident = 1000;
        _this.tasks.push(' scheduled a meeting.');
        _this.tasks.push(' is preparing a quarterly report.');
        return _this;
    }
    Manager.prototype.getSalary = function () {
        return this.salary + this.divident;
    };
    return Manager;
}(Employee));
var junior = new Junior('SuperJunior', 18);
junior.work();
junior.work();
junior.collectSalary();
var senior = new Senior('SuperSenior', 50);
senior.work();
senior.work();
senior.work();
senior.collectSalary();
var manager = new Manager('SuperManager', 100);
manager.work();
manager.work();
manager.work();
manager.collectSalary();
