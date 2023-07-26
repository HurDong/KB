package day_02;

public class ArrayExam2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int i = 5;
		int[] arr = {10,20,30}; // 배열 상수 -> 초기화용 변수선언시에만 사용가능 / arr = {5,7} 오류
		int[][] arr2 = {{80,90,96},{76,88}};
		System.out.println(arr2);
		System.out.println(arr2[0]);
		System.out.println(arr2[1]);
		System.out.println(arr2[0].length);
		System.out.println(arr2[1].length);
		System.out.println(arr2[0][0]);
		int[][] arr3 = new int[][] {
			new int[]{80,90,96},
			new int[]{76,88}
		};
		// 첫 부분만 확정, 뒷부분은 나중에
		int[][] arr4 = new int[2][];
		arr4[0] = new int[3];
		arr4[1] = new int[2];
		arr4[0][0] = 80;
		arr4[0][1] = 90;
		arr4[0][2] = 96;
		arr4[1][0] = 76;
		arr4[1][1] = 88;
		
	}

}
