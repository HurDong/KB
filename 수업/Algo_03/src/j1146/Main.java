package j1146;

import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int[] arr = new int[n];
		for(int i =0;i<n;i++)
		{
			arr[i] = sc.nextInt();
		}
		
		selectionSort(n,arr);
		
	}

	private static void selectionSort(int n, int[] arr) {
		for(int i=0;i<n-1;i++)
		{
			int min = arr[i];
			int idxMin = i;
			for(int j=i+1;j<n;j++)
			{
				if(arr[j]<min)
				{
					min = arr[j];
					idxMin = j;
				}
				
			}
			swap(i,idxMin,arr);
			for(int k=0;k<n;k++)
			{
				System.out.print(arr[k] + " ");
			}
			System.out.println();
		}
	}

	private static void swap(int i, int j, int[] arr) {
		int temp = arr[i];
		arr[i] = arr[j];
		arr[j] = temp;		
	}
}
