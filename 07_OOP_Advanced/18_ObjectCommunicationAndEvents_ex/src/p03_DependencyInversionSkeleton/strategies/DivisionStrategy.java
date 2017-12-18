package p03_DependencyInversionSkeleton.strategies;

import p03_DependencyInversionSkeleton.contracts.Strategy;

public class DivisionStrategy implements Strategy {

	@Override
	public int doOperation(int numOne, int numTwo) {
		return numOne / numTwo;
	}
    
}
