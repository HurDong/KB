package j2750;

import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		long k = sc.nextInt();
		long n = sc.nextInt();
		long m = sc.nextInt();
		long ans = 0;
		ans = (k*n) - m;
		if(ans<0) {
			ans = 0;
			System.out.println(ans);
		}
		else System.out.println(ans);
	}
}
