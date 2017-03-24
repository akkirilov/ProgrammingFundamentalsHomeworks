const Calculator = require('./../models/calculator');

module.exports = {
    indexGet: (req, res) => {
        res.render('home/index');
    },
    indexPost: (req, res) => {
        let calculatorParameters = req.body['calculator'];

        let calculator = new Calculator;
        calculator.leftOperand = Number(calculatorParameters.leftOperand);
        calculator.rightOperand = Number(calculatorParameters.rightOperand);
        calculator.operator = calculatorParameters.operator;
        let result = calculator.calculate();

        res.render('home/index', {'calculator':calculator, 'result':result});
    }
};