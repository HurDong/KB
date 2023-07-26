package j1157;

import java.util.Scanner;

public class Main {
	private static void swap(int[] arr, int i, int j) {
		int temp = arr[i];
		arr[i] = arr[j];
		arr[j] = temp;
	}
	private static void bubbleSort(int n, int[] arr) {
		for(int i = 0; i < n-1; i++)
		{
			for(int j = 0; j < n-1 ; j++)
			{
//				System.out.println("("+i+","+j+") 단계");
				if(arr[j] > arr[j+1])
				{
//					System.out.println(arr[j] + " 와 " + arr[j+1] + " 가 바뀌었습니다.");
					swap(arr,j,j+1);
					
				}
				
			}
			for(int k =0;k<n;k++)
			{
				System.out.print(arr[k] + " ");
			}
			System.out.println();
		}
	}
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
//		System.out.println("*********\n버블 정렬 전\n*********");
		
//		System.out.print("N 값 : ");
		int n= sc.nextInt();
		int[] arr = new int[n];
		
		for(int i =0;i<n;i++)
		{	
//			System.out.print("arr[" + i + "] : ");
			arr[i] = sc.nextInt();
		}
		
		bubbleSort(n,arr);
		
//		System.out.println("*********\n버블 정렬 후\n*********");
		
		for(int i=0;i<n;i++)
		{
//			System.out.println("arr[" + i + "] : " + arr[i]);
		}
		
		
	}

	

	
}
