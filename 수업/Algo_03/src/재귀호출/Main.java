package 재귀호출;

import java.util.Scanner;

public class Main {
	@SuppressWarnings("resource")
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.print("숫자 : ");
		int n = sc.nextInt();
		int ans = factorial(n);
		System.out.println("팩토리얼 : " + ans);
	}


	private static int factorial(int n) {
		if(n==0) return 1; // 종료 조건 
		else
		{
			return n*factorial(n-1);
		}
	}
}
