package spring01;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MemberContext {

	@Bean
	public MemberDao memberDao() {
		return new MemberDaoImpl();
	}

	@Bean
	public MemberService memberService() {
		return new MemberService();
	}
}
