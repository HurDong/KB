package spring02aop;

import org.springframework.stereotype.Component;

@Component
public class SimpleCalcImpl implements SimpleCalc {

	@Override
	public int plus(int i, int j) {
		return i + j;
	}

	@Override
	public int minus(int i, int j) {
		return i - j;
	}

}
