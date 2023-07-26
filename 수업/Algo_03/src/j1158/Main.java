package j1158;

import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int[] arr= new int[n];
		for(int i=0;i<n;i++)
		{
			arr[i] = sc.nextInt();
		}
		
		insertionSort(n,arr);
		
	}

	private static void insertionSort(int n, int[] arr) {
		for(int i=1;i<n;i++)
		{
			for(int j=0;j<i;j++)
			{
				if(arr[i] < arr[j]) swap(i,j,arr);
			}
			for(int k =0;k<n;k++) System.out.print(arr[k] + " ");
			System.out.println();
		}
	}

	private static void swap(int i, int j, int[] arr) {
		int temp = arr[j];
		arr[j] = arr[i];
		arr[i] = temp;
	}
}
