package di_0828.service;

import org.springframework.stereotype.Component;

@Component
public class MyFileLog {
	public void log(String string) {
		System.out.println("���� ȭ��: " + string);
	}
}
