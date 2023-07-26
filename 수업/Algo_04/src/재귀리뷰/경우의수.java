package 재귀리뷰;

public class 경우의수 {
	static int[] arr; // 원소
	static int n; // 답의 길이
	static int[] result; // 답 저장 배열

	public static void main(String[] args) {
		// 원소 {1,2,3} 에 대한 모든 숫자 조합
		arr = new int[] { 1, 2, 3 }; // 반복할 숫자
		n = 3; // 출력할 숫자 조합 길이
		result = new int[n]; // 정답 저장할 배열
		recur(0); // 깊이 0 전달

	}

	private static void recur(int depth) {
		// 종료 조건
		if (depth == n) { // 깊이와 답길이가 동일 -> 답 출력
			printResult();
			return;
		}
		// 처리코드 (result에 숫자 누적)
		for (int i = 0; i < n; i++) {
			result[depth] = arr[i]; // 깊이 자리에 i번째 숫자 저장
			recur(depth + 1); // 깊이 증가후 재귀 호출
		}
	}

	// 답 출력
	private static void printResult() {
		for (int i : result) // result에서 순서대로 출력
		{
			System.out.print(i); // 붙여서 출력
		}
		System.out.println(); // 줄바꿈
	}
}
