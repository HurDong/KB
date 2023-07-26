package day_02;

public class ArrayExam3 {
	public static void main(String[] args) {
		int[] oldArr = {10,20,30};
		int[] newArr = new int[5];
		System.arraycopy(oldArr,0,newArr,0,3);
		for (int i : newArr) {
			System.out.println(i);
		}
	}
}
