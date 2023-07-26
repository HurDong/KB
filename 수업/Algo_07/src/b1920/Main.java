package b1920;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

	static int[] num;
	static int n;
	static int m;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		n = Integer.parseInt(st.nextToken());
		num = new int[n];
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < n; i++) {
			num[i] = Integer.parseInt(st.nextToken());

		}

		Arrays.sort(num);

		st = new StringTokenizer(br.readLine());
		m = Integer.parseInt(st.nextToken());
		int[] target = new int[m];
		st = new StringTokenizer(br.readLine());

		for (int i = 0; i < m; i++) {
			target[i] = Integer.parseInt(st.nextToken());
		}

		for (int i = 0; i < m; i++) {
			System.out.println(find(target[i], 0, n - 1));
		}
	}

	private static int find(int targetNum, int left, int right) {

		int pl = left;
		int pr = right;

		if (targetNum < num[pl] || targetNum > num[pr])
			return 0;

		int pivot = (pl + pr) / 2;
		int pivotValue = num[pivot];
		
		if (targetNum < pivotValue) {
			pr = pivot;
			find(targetNum,pl,pr);
		} else if (targetNum > pivotValue) {
			pl = pivot;
			find(targetNum,pl,pr);
		} else {
			return 1;
		}

		return 0;
	}
}
