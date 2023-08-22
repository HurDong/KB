package com.itskb.myapp.calculator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class InterestCalculatorService {

    @Autowired
    private InterestCalculator loanInterestCalculator;

    @Autowired
    private InterestCalculator savingInterestCalculator;

    public double calculateLoanInterest(int amount) {
        return loanInterestCalculator.calculate(amount);
    }

    public double calculateSavingInterest(int amount) {
        return savingInterestCalculator.calculate(amount);
    }
}
