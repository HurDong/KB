package day_05;

import java.util.ArrayList;

public class WrapExam {
	public static void main(String[] args) {
		int i = 5;
		Integer ii = i; // 숫자 5 가 객체화, 컴파일러가 자동으로 new Integer(i); 해줌. -> auto boxing
		String ss = ii.toString(); // int -> string
		String ss2 = "200";
		int k = Integer.parseInt(ss2);
		
		int j = ii; // 언박싱 
		
		
		ArrayList<Integer> list = new ArrayList<Integer>();
		list.add(i);
		
	}
}
