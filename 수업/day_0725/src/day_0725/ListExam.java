package day_0725;

import java.util.ArrayList;

public class ListExam {
	public static void main(String[] args) {
		ArrayList<String> arr = new ArrayList<String>();
		arr.add("홍");
		arr.add("김");
		arr.add("박");
		arr.add(0,"최");
		System.out.println(arr);
		arr.set(0, "정");
		System.out.println(arr);
		System.out.println(arr.get(0));
		arr.remove(0);
		System.out.println(arr);
		arr.remove("김");
		System.out.println(arr);
	}
}
