package Quiz;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class kb1반_알고리즘2번_허동민 {
	static int[] dx = { 0, 1, 0, -1 };
	static int[] dy = { 1, 0, -1, 0 };
	static boolean[][] visited;
	static int[][] A;
	static int n, m;
	static int day;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		m = sc.nextInt();
		n = sc.nextInt();
		A = new int[n][m];
		visited = new boolean[n][m];
		for (int i = 0; i < n; i++) {
			String line = sc.next();
			for (int j = 0; j < m - 1; j++) {
				A[i][j] = Integer.parseInt(line.substring(j, j + 1));
			}
		}

		int x = (sc.nextInt()) - 1;
		int y = (sc.nextInt()) - 1;
		day = 0;
		int student = 0;
		bfs(x, y);
		System.out.println(day + 3);
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++)
				if (visited[i][j] == false && A[i][j] == 1) {
					student++;
				}
		}
		System.out.println(student);
//		for (int i = 0; i < n; i++) {
//			for (int j = 0; j < m; j++) {
//				if (visited[i][j] == false && A[i][j] == 1)
//					System.out.print("2");
//				else if (visited[i][j] == false)
//					System.out.print("0");
//				else
//					System.out.print("1");
//			}
//			System.out.println();
//		}
//		System.out.println();
//		for(int i=0;i<n;i++)
//		{
//			for(int j=0;j<m;j++) {
//				System.out.print(A[i][j]);
//			}
//			System.out.println();
//		}
	}

	private static void bfs(int x, int y) {
		Queue<int[]> queue = new LinkedList<>();
		queue.offer(new int[] { y, x });
		visited[y][x] = true;
		while (!queue.isEmpty()) {
			int now[] = queue.poll();
			for (int i = 0; i < 4; i++) {
				int a = now[0] + dx[i];
				int b = now[1] + dy[i];
				if (a >= 0 && b >= 0 && a < n && b < m) {
					if (A[b][a] != 0 && visited[b][a] == false) {
						System.out.println(a+","+b);
						visited[b][a] = true;
						A[b][a] = A[now[1]][now[0]] + 1;
						queue.add(new int[] { y, x });
						day++;
					}
				}
			}
		}
	}
}
