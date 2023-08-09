package b2485;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine());

		int n = Integer.parseInt(st.nextToken());

		int[] tree = new int[n];
		int[] dif = new int[n - 1];

		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			tree[i] = Integer.parseInt(st.nextToken());
		}

		for (int i = 0; i < n - 1; i++) {
			dif[i] = tree[i + 1] - tree[i];
		}

		findGCD(dif);

	}

	private static void findGCD(int[] dif) {
		int idx = 2;
		int result = 1;
		Arrays.sort(dif);
		while (dif[0] >= idx) {
			int count = 0;
			for (int i = 0; i < dif.length; i++) {
				if (dif[i] % idx == 0) {
					count++;
				} else {
					idx++;
					break;
				}
				if (count == dif.length - 1) {
					result = result * idx;
					for (int j = 0; j < dif.length; j++) {
						dif[j] = dif[j] / idx;
					}
				}
			}
		}
		int ans = 0;

		for (int i = 0; i < dif.length; i++) {
			ans = ans + dif[i] - 1;
		}
		System.out.println(ans);
    }
}
