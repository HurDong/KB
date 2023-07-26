package day_0725;

import java.util.HashSet;

public class SetExam {
	public static void main(String[] args) {
		HashSet<String> hs = new HashSet<String>();
		hs.add("홍");
		hs.add("김");
		hs.add("박");
		hs.add("홍"); // 중복 저장
		System.out.println(hs);

		
	}
}
