package day_05;

public class StringExam2 {
	public static void main(String[] args) {
		String s = "홍길동";
		String s2 = "멀티캠퍼스";
		System.out.println(s.length()); // 문자열 길이
		System.out.println(s.charAt(1)); // 문자 단위로 추출
		System.out.println(s2.indexOf("캠퍼스")); // s2 String안에서 "캠퍼스"라는 문자가 몇번째인지 , 없으면 -1
		System.out.println(s.startsWith("홍")); // 특정 문자로 시작하는가? bool
		System.out.println(s.endsWith(".pdf")); // 특정 문자로 끝나는가? bool
		
		String s3 = "10,20,30";
		String[] split = s3.split(",");
		for (int i = 0; i < split.length; i++) {
			System.out.println(split[i]);			
		}
		
		String s4 = "abcd";
		String s5 = s4.toUpperCase(); // 모든 문자 대문자로 , lower -> 소문자로		
		System.out.println(s4 == s5); // String은 불변객체, 한번 만들어진 후  내부값 변경 불가.
									  // 문자열 변경 메서드 실행 결과로 새로운 문자열을 반환한다.
		
		
		
	}
}
