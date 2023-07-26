package day_05;

import java.util.Arrays;

public class CompareExam {
	public static void main(String[] args) {
		MyMember[] mems = new MyMember[4]; //  꽉 채워야 정렬시 오류가 안남.
		int count = 0;
		mems[count++] = new MyMember("홍길동",33);
		mems[count++] = new MyMember("김길동",35);
		mems[count++] = new MyMember("박길동",30);
		mems[count++] = new MyMember("홍길동",33);
		
		System.out.println("*** 정렬 전 ***");
		for (int i = 0; i < mems.length; i++) {
			System.out.println(mems[i]);
		}
		
		// 배열 정렬은 Arrays.sort(배열);
		Arrays.sort(mems, new NameComparator());
		
		System.out.println("\n*** 정렬 후 ***");
		for (int i = 0; i < mems.length; i++) {
			System.out.println(mems[i]);
		}
		
		System.out.println("\nmems[0]==mems[1] : " + (mems[0]==mems[1]));
		System.out.println("mems[0].equals(mems[1]) : " + (mems[0].equals(mems[1])));
	}
}
