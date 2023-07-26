package 재귀리뷰;

import java.util.Scanner;

public class 경우의수3_조합 { // 숫자는 한번씩만 사용 가능, 3개의 숫자중 2개의 숫자만을 사용.

	static int[] arr;
	static int[] result;
	static int n;
	static int m;
	static boolean[] visited; // 사용 여부 저장

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		n = sc.nextInt(); // 추출의 갯수
		arr = new int[n];
		for (int i = 0; i < n; i++) {
			arr[i] = i;
		}
		m = sc.nextInt();
		result = new int[m];// 답 저장
		visited = new boolean[m];
		recur(0);
	}

	private static void recur(int depth) {
		if (depth == n) { // 종료조건
			print();
			return;
		}
		// 처리코드(깊이의 숫자위치에 i값을 저장)
		for (int i = 0; i < m; i++) {
			// arr[o]숫자가 미사용인 경우에만 사용
			if (visited[i] == false) {
				result[depth] = arr[i]; // 깊이 자리에 i 번째 숫 자저장
				visited[i] = true;
				recur(depth + 1); // 깊이 증가후 재귀호출
				visited[i] = false;
			}
		}
	}

	private static void print() {
		for (int i : result) {
			System.out.print(i);// 가로로 붙여서 출력
		}
		System.out.println();
	}
}
