package com.itskb.myapp.calculator;

public class SavingInterestCalculator implements InterestCalculator {
	private static final double rate = 0.0334;

	@Override
	public double calculate(int amount) {
		double interest = amount * rate;
		System.out.println("SavingInterestCalculator - calculate()");
		System.out.println("Amount : " + amount + " savingInterest is " + interest);
		return interest;
	}

}
