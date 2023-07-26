package j1856;

import java.util.Scanner;

public class Main {
	public static void main(String[] args) {	
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int m = sc.nextInt();
		int[][] arr = new int[n][m];
		int count=1;
		for(int i=0;i<n;i++) {
			for(int j=0;j<m;j++) {
				if(i%2==0) arr[i][j] = count++;
				else arr[i][m-j-1] = count++;
			}
		}
		for(int k=0;k<n;k++) {
			for(int l=0;l<m;l++) {
				System.out.print(arr[k][l] + " ");
			}
			System.out.println();
		}
		
	}
}