package spring02;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class SpringTest01 {

	public static void main(String[] args) {
		ApplicationContext context = new ClassPathXmlApplicationContext("beans.xml");
		HelloService hs = (HelloService) context.getBean("hs");
		System.out.println(hs.hello());
		HelloService hs2 = (HelloService) context.getBean("hsen");
		System.out.println(hs2.hello());
	}

}
