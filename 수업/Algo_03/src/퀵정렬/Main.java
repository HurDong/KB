package 퀵정렬;

import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("배열을 나눕니다.");
		int nx = sc.nextInt();
		int[] x = new int[nx];

		for (int i = 0; i < x.length; i++) {
			System.out.print("x[" + i + "]: ");
			x[i] = sc.nextInt();
		}
		quickSort(x, 0, nx - 1);
		System.out.println("---QuickSort---");
		for (int i = 0; i < nx; i++) {
			System.out.print("x[" + i + "]: " + x[i]);
			System.out.println();
		}

	}

	private static void quickSort(int[] a, int left, int right) {
		int pl = left;
		int pr = right;
		int x = a[(pl + pr) / 2];
		do {
			while (a[pl] < x)
				pl++;
			while (a[pr] > x)
				pr--;
			if (pl <= pr)
				swap(a, pl++, pr--);

		} while (pl <= pr);
		if (left < pr)
			quickSort(a, left, pr);
		if (pl < right)
			quickSort(a, pl, right);
	}

	private static void swap(int[] a, int i, int j) {
		int t = a[i];
		a[i] = a[j];
		a[j] = t;
	}
}
