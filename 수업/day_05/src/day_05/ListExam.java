package day_05;

import java.util.ArrayList;

public class ListExam {
	public static void main(String[] args) {
		// 회원 이름을 관리
		ArrayList<String> names = new ArrayList<String>();
		names.add("홍길동"); // 0
		names.add("김길동"); // 1
		names.add("박길동"); // 2
		System.out.println(names);
		names.add(1,"박길동"); // 1 에 추가, 뒤 값들 1씩 뒤로
		System.out.println(names);
		String r = names.remove(2); // remove 함수는 삭제하면서 String을 반환
		System.out.println(names);
		names.clear(); // 전체 삭제
		System.out.println(names);
		
		
	}
}
