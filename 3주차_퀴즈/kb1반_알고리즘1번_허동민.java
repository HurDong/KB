package Quiz;

import java.util.ArrayList;
import java.util.Scanner;

public class kb1반_알고리즘1번_허동민 {
	static ArrayList<Integer>[] A;
	static boolean visited[];
	static int count;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int r = sc.nextInt();
		A = new ArrayList[n + 1];
		visited = new boolean[n + 1];
		count = 0;
		for (int i = 1; i <= n; i++) {
			A[i] = new ArrayList<Integer>(); // 인접 리스트 초기화
		}
		for (int i = 0; i < r; i++) {
			int s = sc.nextInt();
			int e = sc.nextInt();
			A[s].add(e); // 양방향 에지이므로 두개 추가
			A[e].add(s);
		}

		dfs(1); // 철수(1)에 대한 dfs 실시
		System.out.println(count);
	}

	private static void dfs(int v) {
		if (visited[v]) { // 이미 방문한 노드이면 return하여 함수끝.
			return;
		}
		visited[v] = true; // 방문하였으므로 true로 값 변환
		for (int i : A[v]) {
			if (visited[i] == false) { // 방문하지않은 노드이므로 count를 증가하면서 해당 노드에 대한 dfs실시
				count++;
				dfs(i);
			}
		}
	}

}
