package spring01;

import java.util.Scanner;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.ApplicationContext;

public class 숫자맞추기게임 {
	public static void main(String[] args) {
		ApplicationContext context = new AnnotationConfigApplicationContext(GameContext.class);
		NumberGuess ng = context.getBean(NumberGuess.class);
		Scanner sc = new Scanner(System.in);
		while (true) {
			System.out.println("1~100사이의 숫자를 입력: ");
			int num = sc.nextInt();
			String result = ng.checkNumber(num);
			System.out.println(result);
			if (result.equals("정답"))
				break;
		}
	}
}
