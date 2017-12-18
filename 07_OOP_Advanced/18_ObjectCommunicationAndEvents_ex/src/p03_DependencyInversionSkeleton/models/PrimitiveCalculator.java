package p03_DependencyInversionSkeleton.models;

import p03_DependencyInversionSkeleton.contracts.Strategy;

public class PrimitiveCalculator {

    private Strategy strategy;

    public PrimitiveCalculator() {  }

    public void changeStrategy(Strategy strategy){
        this.strategy = strategy;
    }

    public int performCalculation(int numOne,int numTwo) {
        return this.strategy.doOperation(numOne, numTwo);
    }
    
}
