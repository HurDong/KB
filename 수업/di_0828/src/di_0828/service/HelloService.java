package di_0828.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
public class HelloService {
	@Autowired
	@Qualifier("myLog")
	private MyLog myLog;

	public String hello() {
		myLog.log("100");
		return "æ»≥Á«œººø‰";
	}
}
