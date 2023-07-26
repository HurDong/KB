package day_02;

public class ArrayExam {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] arr;
		arr = new int[3];
		arr[0] = 100;
		arr[1] = 200;
		arr[2] = 300;
		for (int i = 0; i < arr.length; i++) {
			System.out.println(arr[i]);
		}
		// 변수 선언할 때 배열 대입
		int[] arr2 = {100,200,300};
		
		// arr2 = {100,200,300}; 오류 -> 변수 초기화시에만 사용할 수 있는 구문
		for (int i = 0; i < arr2.length; i++) {
			System.out.println(arr2[i]);
		}
		
		// Heap 공간에 배열을 만들음 
		int[] arr3 = new int[] {100,200,300};
		
		// arr3 = new int[] {100,200,300}; 가능
		for (int i = 0; i < arr3.length; i++) {
			System.out.println(arr3[i]);
		}
		
		String s = "kim"; // -> method(static) 영역 생성
						  // new String("kim") -> 원래 이렇게 사용(Heap 공간에 생성) , new -> Heap 공간
		int i = 50;		  // stack 영역 생성 -> 기본 type
		System.out.println(arr3.length);
		
	}
}