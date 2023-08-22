package spring01;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppContext {
	@Autowired
	private MyLog log;
	
	@Bean
	public MyCalc mc() {
		MyCalc mc = new MyCalc();
		mc.setLog(log);
		return mc;
	}

	@Bean
	public HelloServiceEn hello1() {
		return new HelloServiceEn();
	}

	public static void main(String[] args) {

	}
}
