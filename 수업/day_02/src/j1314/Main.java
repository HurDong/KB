package j1314;

import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		char[][] arr = new char [n][n];
		int size = n *n;
		
		for(int i=0;i<n;i++) {
			for(int j=0;j<n;j++) {
				if(i%2==0) {
					int temp = 65 + (n*i + j)%26;
					arr[j][i] = (char) temp;					
				} else {
					int temp = 65 + (n*i + n - j - 1)%26;
					arr[j][i] = (char) temp;
				}
				
			}
		}
		for(int k=0;k<n;k++) {
			for(int l=0;l<n;l++) {
				System.out.print(arr[k][l]+" ");
			}
			System.out.println();
		}
	}
}
