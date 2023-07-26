package 숫자맞추기;

import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int num = (int) (Math.random()*100 +1);
		while(true) {
			System.out.println("1~100사이 숫자를 입력하세요.");
			int input = sc.nextInt();
			if(num==input) {
				System.out.println("정답");
				break;
			}
			else if(num<input) System.out.println("내려주세요");
			else if(num>input) System.out.println("올려주세요");
		}
	}
}
