package j1001;

import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		int num=0, leg=0, dog=0, bird=0;
		Scanner sc = new Scanner(System.in);
		while(true) {
			num = sc.nextInt();
			leg = sc.nextInt();
			if(num==0&&leg==0) break;
			else if(num>1000||leg>4000) {
				System.out.println("INPUT ERROR");
				continue;
			}
			// dog + bird = num, 4*dog + 2*bird = leg -> 2*dog = leg - 2*num
			dog = (leg - 2*num)/2;
			bird = num - dog;
			if(dog<0||bird<0||(leg-2*num)%2!=0) System.out.println("0");
			else System.out.println(dog + " " + bird);
		}
	}
}
