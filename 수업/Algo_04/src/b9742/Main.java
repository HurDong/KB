package b9742;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static char[] arr;
	static String[] result;
	static char[] tempChar;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		String temp = st.nextToken();
		arr = temp.toCharArray();
		result = new String[arr.length];
		temp = st.nextToken();
		int index = Integer.parseInt(temp);
		int size = 1;
		for(int i=1;i<=arr.length;i++) {
			size = size * i;
		}
		tempChar = new char[size];
		recur(0);
		System.out.println(result[index]);
		for(int i =0;i<size;i++) System.out.println(result[i]);
	}

	private static void recur(int depth) {
		if (depth == arr.length) { // 종료조건
			print();
			return;
		}
		// 처리코드(깊이의 숫자위치에 i값을 저장)
		for (int i = 0; i < arr.length; i++) {
			for(int j=0;j<arr.length;j++) tempChar[j] = arr[j];
			result[depth] = String.valueOf(tempChar);
			recur(depth + 1);
		}
	}

	private static void print() {
		for (String i : result) {
			System.out.print(i);
		}
		System.out.println();
	}

}
