package day_04;

import java.util.Arrays;

public class CompareExam {
	public static void main(String[] args) {
		
		MyMember[] mems = new MyMember[3]; // 생성된 MyMember 객체는 0개, MyMember 객체를 저장할 배열 객체만 생성.
		int count = 0; // 객체를 저장할 위치 -> 객체 저장 갯수
		mems[count++] = new MyMember("김길동",35); // 객체배열과 그를 참조하는 객체는 모두 Heap 영역에 생성, mems는 stack에 생성.
		mems[count++] = new MyMember("홍길동",33);
		mems[count++] = new MyMember("박길동",30);
		Arrays.sort(mems);
		for (int i = 0; i < count; i++) {
			System.out.println(mems[i].toString());
		}
	}
}
