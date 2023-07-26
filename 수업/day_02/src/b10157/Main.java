package b10157;

import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int c = sc.nextInt();
		int r = sc.nextInt();
		int num = sc.nextInt();
		int tmpc = c, tmpr = r;
		int countc=1, countr=1;
		while(num>=0) {
			// 위로 가는 경우
			if(tmpr>=num) {
				countr=num;
				break;
			} else {
				num=num-tmpr;
				tmpc--;
				countr++;
			}
			// 오른쪽으로 가는 경우
			if(tmpc>=num) {
				countc=num;
				break;
			} else {				
				num=num-tmpc;
				countc++;
				tmpr--;
			}
			// 아래로 가는 경우
			if(tmpr>=num) {
				countr=tmpr-num;
				break;
			}
			
		}
		System.out.println(countc);
		System.out.println(countr);
		
//		int c = sc.nextInt();
//		int tmpc = c;
//		int r = sc.nextInt();
//		int tmpr = r;
//		int[][] arr = new int[c][r];
//		int count=1;
//		while(tmpc<0&&tmpr<0) {
//			// 위로 가는 경우 2a+2b-4
//			for(int i=0;i<tmpr;i++) {
//				arr[tmpr-i-1][tmpc-1]=count++;
//			}
//			// 오른쪽으로 가는 경우
//			for (int j=0;j<tmpc;j++) {
//				arr[tmpr-1][tmpc-1+j]
//			}
//		}
//		
//		for(int i=0;i<c;i++) {
//			for(int j=0;j<r;j++) {
//				System.out.print(arr[i][j] + " ");
//			}
//			System.out.println();
//		}
	}
}
