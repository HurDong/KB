package spring02aop;

import org.springframework.stereotype.Component;

@Component
public class CalcImpl implements Calc {

	@Override
	public long factorial(long num) {
		long result = -1;
		for (long i = 1; i <= num; i++) {
			result *= i;
		}
		return result;
	}

}
