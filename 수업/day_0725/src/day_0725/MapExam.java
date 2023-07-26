package day_0725;

import java.util.HashMap;

public class MapExam {
	public static class Score {
		private int math, eng;

		public Score(int math, int eng) {
			// TODO Auto-generated constructor stub
			this.math = math;
			this.eng = eng;
		}

		HashMap<Integer, Integer> sc = new HashMap<Integer, Integer>();

	}

	public static void main(String[] args) {
		HashMap<Integer, Integer> sc = new HashMap<Integer, Integer>();
		HashMap<String, HashMap> hm = new HashMap<String, HashMap>();
		sc.put(89, 90);
		hm.put("홍", sc);
		System.out.println(hm);

	}
}
