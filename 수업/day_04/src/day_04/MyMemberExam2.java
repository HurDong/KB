package day_04;

public class MyMemberExam2 {
	public static void main(String[] args) {
		MyMemberService ms = new MyMemberService();
		
		// 회원 등록		
		MyMember mm = new MyMember("홍길동",33);
		ms.add(mm);
		mm = new MyMember("김길동",35);
		ms.add(mm);
		mm = new MyMember("박길동",30);
		ms.add(mm);
		
		System.out.println("저장갯수 = " + ms.getCount());
		
		//  목록 출력
		ms.printAll();
		
		// 회원 검색 - 김길동의 참조값을 반환 | 순서번호를 반환
		// 검색의 성공 | 실패 -> 성공 : 양수, 실패 : -1
		// 				 -> 성공 : true, 실패 : false
		//				 -> 성공 : 참조값, 실패 : null -> 검색기능으로 적합
		MyMember findMem = ms.searchByName("김길동");
		if(findMem == null) System.out.println("Not Found");
		else System.out.println("Found : " + findMem);
		
		// 회원 수정 - 김길동의 나이를 1증가
		boolean b = ms.update("김길동",1);
		if(b) System.out.println("Success");
		else System.out.println("Fail");
		
		findMem = ms.searchByName("김길동");		
		if(findMem == null) System.out.println("Not Found");
		else System.out.println("Found : " + findMem);
		
	}
}
