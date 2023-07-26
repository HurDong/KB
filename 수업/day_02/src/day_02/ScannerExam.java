package day_02;

import java.util.Scanner;

public class ScannerExam {
	public static void main(String[] args) {
		System.out.print("이름을 입력하세요 : ");
		Scanner sc = new Scanner(System.in);
//		sc.next(); // next : 공백문자를 기준으로 분리 String
//		sc.nextInt(); // nextInt : 숫자 한개씩 추출 int
//		sc.nextLine(); // nextLine : 한줄씩 추출 String
		String name = sc.next();
		System.out.println("이름 : " + name);
		System.out.print("태어난 해를 4자리로 입력하세요(예 : 1990) ");
		int year = sc.nextInt();
		System.out.println("태어난 해 : " + year);
		int age = 2023 - year;
		System.out.println("나이 : " + age);
	}
}
