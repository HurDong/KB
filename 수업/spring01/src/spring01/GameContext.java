package spring01;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class GameContext {
	@Bean
	public NumberGuess guess() {
		return new NumberGuess();
	}
}
