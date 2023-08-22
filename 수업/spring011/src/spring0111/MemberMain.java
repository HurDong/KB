package spring0111;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class MemberMain {
	public static void main(String[] args) {
		ApplicationContext context = new AnnotationConfigApplicationContext(MemberContext.class);
		MemberService ms = context.getBean(MemberService.class);
		ms.login("id","passwd");
	}
}
