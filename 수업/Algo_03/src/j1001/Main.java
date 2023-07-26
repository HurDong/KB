package j1001;

import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		while(true)
		{
			int num = sc.nextInt();
			int leg = sc.nextInt();
			if(num ==0 && leg == 0) break;
			calcAnimals(num,leg);
		}
	}

	private static void calcAnimals(int num, int leg) {
		if(num>1000 || leg>4000) System.out.println("INPUT ERROR!");
		else if(((leg-2*num)/2) < 0  || (2*num - leg/2) < 0 || (leg-2*num)%2==1 || leg%2 ==1) System.out.println("0");
		else
		{
			System.out.println(((leg-2*num)/2) + " " + (2*num-(leg/2))) ;
		}
	}
}

// 4x + 2y = leg 
// 2x + 2y = 2*num -> 2x = leg - 2num -> x = (leg-2*num)/2 , y = 2*num - leg/2 