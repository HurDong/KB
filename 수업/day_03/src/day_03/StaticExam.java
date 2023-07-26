package day_03;

public class StaticExam {
//	static int age=0;
	public static void main(String[] args) {
		// new StaticExam().age = 100;
		int age =0;
		age = 100;
		test1(age);
		System.out.println(age);
	}
	
	// main이 static이므로 static 메서드만 사용가능 ★
	public static int test1(int age) {
		age=+100;
		return age;
	}
}
