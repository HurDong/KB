package spring02aop;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class AopTest {
	public static void main(String[] args) {
		ApplicationContext context = new AnnotationConfigApplicationContext(AopContext.class);
		Calc calc = context.getBean(Calc.class);
		System.out.println("calc이름: " + calc.getClass());
		long fi = calc.factorial(10);
		System.out.println(fi);
	}
}
