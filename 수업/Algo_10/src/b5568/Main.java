package b5568;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int[] card;
	static int[] whole;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int n = Integer.parseInt(st.nextToken());
		st = new StringTokenizer(br.readLine());
		int k = Integer.parseInt(st.nextToken());
		card = new int[n];
		whole = new int[999999];
		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			card[i] = Integer.parseInt(st.nextToken());
		}

		// backTracking();

	}
}
