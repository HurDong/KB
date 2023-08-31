package mulcam.kb04.boot_0831.ifs;

import org.springframework.stereotype.Component;

@Component
public class AfternoonGreet implements Greet {
	@Override
	public String greeting() {
		return "Good Afternoon";
	}
}
