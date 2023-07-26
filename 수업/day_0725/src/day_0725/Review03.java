package day_0725;

public class Review03 {
	// static void() 와 void() -> 오류
	final int i = 100;
	static int j = 200;

	public Review03() {
		//this.i = 300;
	}

	public static void main(String[] args) {
		Review03 r = new Review03();
		System.out.println(r.i);
		System.out.println(Review03.j);
		System.out.println(Math.PI);
	}

}
