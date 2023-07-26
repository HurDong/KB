package b7562;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
	static int len;
	static int targetX;
	static int targetY;
	static boolean[] visited;
	static List<Integer> ans;
	static ArrayList<Integer>[] A;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int n = Integer.parseInt(st.nextToken());

		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			len = Integer.parseInt(st.nextToken());
			st = new StringTokenizer(br.readLine());
			int nowX = Integer.parseInt(st.nextToken());
			int nowY = Integer.parseInt(st.nextToken());
			st = new StringTokenizer(br.readLine());
			targetX = Integer.parseInt(st.nextToken());
			targetY = Integer.parseInt(st.nextToken());
			A = new ArrayList[len + 1];
			ans = new ArrayList<>();
			for (int j = 1; j <= len; j++) {
				A[j] = new ArrayList<Integer>();
			}

			findKnight(nowX, nowY, 0);

		}
	}

	private static void findKnight(int x, int y, int n) {
		if (x == targetX && y == targetY) {
			System.out.println(n);
		}
	}
}
