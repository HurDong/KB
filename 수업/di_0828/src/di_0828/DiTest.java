package di_0828;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
//import org.springframework.context.support.GenericXmlApplicationContext;

import di_0828.config.AppContext;
import di_0828.config.AppContext2;
import di_0828.service.HelloService;

public class DiTest {
	public static void main(String[] args) {
		// 스프링은 서비스 클래스 등록후 검색, 사용
//		ApplicationContext context = new GenericXmlApplicationContext("classpath:beans.xml");
		ApplicationContext context = new AnnotationConfigApplicationContext(AppContext2.class);
		// id, name 속성 값 또는 메서드명
//		HelloService hs = (HelloService) context.getBean("hs");
		HelloService hs = context.getBean(HelloService.class);
		String hello = hs.hello();
		System.out.println(hello);
	}
}
