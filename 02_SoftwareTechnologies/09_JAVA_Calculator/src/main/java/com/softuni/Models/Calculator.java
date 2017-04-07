package com.softuni.Models;

public class Calculator {
    private int leftOperand;
    private String operator;
    private int rightOperand;

    public int getLeftOperand() {
        return leftOperand;
    }

    public void setLeftOperand(int leftOperand) {
        this.leftOperand = leftOperand;
    }

    public String getOperator() {
        return operator;
    }

    public void setOperator(String operator) {
        this.operator = operator;
    }

    public int getRightOperand() {
        return rightOperand;
    }

    public void setRightOperand(int rightOperand) {
        this.rightOperand = rightOperand;
    }

    public Calculator(int leftOperand, String operator, int rightOperand) {
        this.leftOperand = leftOperand;
        this.operator = operator;
        this.rightOperand = rightOperand;
    }

    public double calculate (){
           double result;
           switch (operator){
               case "+":
                   result = this.leftOperand + this.rightOperand;
                   break;
               case "-":
                   result = this.leftOperand - this.rightOperand;
                   break;
               case "*":
                   result = this.leftOperand * this.rightOperand;
                   break;
               case "/":
                   result = this.leftOperand / this.rightOperand;
                   break;
                   default:
                       result = 0;
                       break;
           }

           return result;
    }
}