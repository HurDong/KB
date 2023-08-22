package com.itskb.myapp.calculator;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Test {
	public static void main(String[] args) {
		ApplicationContext context = new AnnotationConfigApplicationContext(CalcultorContext.class);
		InterestCalculatorService service = context.getBean(InterestCalculatorService.class);
		double loanInterest = service.calculateLoanInterest(100000000);
		double savingInterest = service.calculateSavingInterest(100000000);
	}
}
