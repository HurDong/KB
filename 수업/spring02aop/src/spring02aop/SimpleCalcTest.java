package spring02aop;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class SimpleCalcTest {
	public static void main(String[] args) {
		ApplicationContext context = new AnnotationConfigApplicationContext(SimpleContext.class);
		SimpleCalc sc = context.getBean(SimpleCalc.class);
		System.out.println(sc.plus(2, 3));
		System.out.println(sc.minus(2, 3));
	}
}
