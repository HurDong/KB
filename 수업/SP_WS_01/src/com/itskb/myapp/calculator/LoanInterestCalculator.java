package com.itskb.myapp.calculator;

public class LoanInterestCalculator implements InterestCalculator {
	public static final double rate = 0.0525;

	@Override
	public double calculate(int amount) {
		double interest = amount * rate;
		System.out.println("LoanInterestCalculator - calculate()");
		System.out.println("Amount : " + amount + " loanInterest is " + interest);
		return interest;
	}

}
