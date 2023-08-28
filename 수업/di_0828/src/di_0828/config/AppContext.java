package di_0828.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import di_0828.service.HelloService;

@Configuration
public class AppContext {
	@Bean
	public HelloService hs() {
		return new HelloService();
	}
}
