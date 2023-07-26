package day_04;

import java.util.Iterator;

public class MyMemberExam {
	public static void main(String[] args) {
		
		// 회원 정보 관리 - 1. 등록 2. 검색 3. 수정 4. 삭제 (CRUD)
		// 회원 : 이름, 나이		
		// MyMember m1 = new MyMember("홍길동",33);
		// System.out.println(m1); -> 객체의 주소값이 넘어가면 자동으로 toString() 호출이 됨.
		// System.out.println(m1.toString());
		MyMember[] mems = new MyMember[300]; // 생성된 MyMember 객체는 0개, MyMember 객체를 저장할 배열 객체만 생성.
		int count = 0; // 객체를 저장할 위치 -> 객체 저장 갯수
		mems[count++] = new MyMember("김길동",35); // 객체배열과 그를 참조하는 객체는 모두 Heap 영역에 생성, mems는 stack에 생성.
		mems[count++] = new MyMember("홍길동",33);
		mems[count++] = new MyMember("박길동",30); // 여기서 총 생성된 객체는 총 4개 (객체배열 1개 + 객체 3개)
		
		// 목록 출력
		System.out.println("*** 회원 목록 ***");
		for (int i = 0; i < count; i++) { // mems.length가 아닌 count로 하는게 나음.
			System.out.println(mems[i]);
		}
		System.out.println();
		
		// 회원 검색
		System.out.println("*** 회원 검색 ***");
		String findName = "김길동";
		int targetIndex = -1; // 찾은 회원의 위치
		for (int i = 0; i < count; i++) {
			if(mems[i].getName() == findName) targetIndex = i;
		}
		if (targetIndex == -1 ) System.out.println(findName +"님을 찾지 못했습니다.");
		else System.out.println(findName + "님을 찾았습니다. " +  mems[targetIndex]);
		System.out.println();
		
		// 회원 수정 - 김길동의 나이를 1 증가.
		System.out.println("*** 회원 수정 ***");
		findName = "김길동";
		targetIndex = -1;
		for (int i = 0; i < count; i++) {
			if(findName == mems[i].getName()) targetIndex = i;
		}
		if(targetIndex == -1) System.out.println(findName +"님을 찾지 못했습니다.");
		else {
			System.out.println(findName + "님을 찾았습니다.  " + mems[targetIndex]);
			int age = mems[targetIndex].getAge();
			mems[targetIndex].setAge(age+1);
			System.out.println(findName + "님을 수정했습니다. " + mems[targetIndex]);
		}
		System.out.println();
		
		// 목록 출력
				System.out.println("*** 회원 목록 ***");
				for (int i = 0; i < count; i++) { // mems.length가 아닌 count로 하는게 나음.
					System.out.println(mems[i]);
				}
				System.out.println();
				
		// 회원 삭제 - 김길동 회원 삭제
		System.out.println("*** 회원 삭제 ***");
		findName = "홍길동";
		targetIndex = -1;
		for (int i = 0; i < count; i++) {
			if(findName == mems[i].getName()) targetIndex = i;
		}
		if(targetIndex == -1) System.out.println(findName +"님을 찾지 못했습니다." );
		else {
			System.out.println(findName + "님을 찾았습니다. " + mems[targetIndex]);
			for (int i = 0; i < count-targetIndex; i++) {
				mems[targetIndex+i] = mems[targetIndex+i+1];
			}
			count--;
			System.out.println(findName + "님을 삭제했습니다.");
		}
		System.out.println();
		
		// 목록 출력
		System.out.println("*** 회원 목록 ***");
		for (int i = 0; i < count; i++) { // mems.length가 아닌 count로 하는게 나음.
			System.out.println(mems[i]);
		}
		System.out.println();
	}
}
