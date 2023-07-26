package Quiz;

import java.util.Scanner;

public class kb1반_알고리즘3번_허동민 {
	static int[] distance;
	static int n;
	static int m;
	static int length;
	static int large;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		m = sc.nextInt();
		distance = new int[n];
		for (int i = 0; i < n; i++) {
			distance[i] = sc.nextInt();
		}
		length = 0;
		large = 0;
		backTracking(0, 0, 0); // 몇번실행했는지와 현재위치와 그전위치에서의 길이를 인자로 넘김
		System.out.println(large);
	}

	private static void backTracking(int num, int idx, int before) {
		if (num == m || idx == n - 1) { // 시간이 다 지났거나 도착을 했으면 재귀 끝
			if (length >= large) { // large보다 현재 길이가 더길면 해당길이를 large로
				large = length;
				length = before; // 호출함수의 length값을 호출함수하기전 length값으로 변경
				return;
			}
		} else {
			for (int i = 0; i < 2; i++) {
				if (i == 0) {
					int temp = length; // before 인자에 넘기기 위해 temp 변수사용
					length = length + distance[idx + 1]; // 한칸이동이므로 현재위치+거리
					backTracking(num + 1, idx + 1, temp);
				} else {
					if (idx < n - 2) {
						int temp = length;
						length = length / 2 + distance[idx + 2]; // 두칸이동이므로 현재위치 반 + 거리
						backTracking(num + 1, idx + 2, temp);
					} else if (idx == n - 2) {
						int temp = length;
						length = length + distance[idx + 1]; // n-2번째일경우 한칸만이동
						backTracking(num + 1, idx + 1, temp);
					}

				}
			}

		}

	}
}
