package b5430;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Deque;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine());

		StringBuilder sb = new StringBuilder();

		int T = Integer.parseInt(st.nextToken());

		for (int i = 0; i < T; i++) {
			st = new StringTokenizer(br.readLine());

			String s = st.nextToken();

			st = new StringTokenizer(br.readLine());

			int n = Integer.parseInt(st.nextToken());

			st = new StringTokenizer(br.readLine());

			String arr = st.nextToken();

			arr = arr.replace("[", "").replace("]", "");

			int[] num = new int[n];

			String[] temp = new String[n];

			temp = arr.split(",");

			Deque<Integer> queue = new LinkedList<Integer>();

			for (int j = 0; j < n; j++) {
				num[j] = Integer.parseInt(temp[j]);
				queue.add(num[j]);
			}
			System.out.println(queue);
		}
	}
}
