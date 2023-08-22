package com.itskb.myapp.calculator;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan(basePackages = "com.itskb.myapp.calculator")
public class CalcultorContext {

	@Bean
	public InterestCalculator loanInterestCalculator() {
		return new LoanInterestCalculator();
	}

	@Bean
	public InterestCalculator savingInterestCalculator() {
		return new SavingInterestCalculator();
	}
}
