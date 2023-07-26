package day_01;

public class Variables_01 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int v;
		v = 30;
		int x = 50;
		int abc = 100;
		int g = 65;
		System.out.println( Integer.toBinaryString(g));
		int i2 = 0xf;
		System.out.println( i2 ); 
		char c1 = '가';
		char c2 = '나';
		System.out.println(c1<c2);
		System.out.println(c1);
		int ci1 = c1;
		System.out.println(ci1);
		ci1++;
		System.out.println((char)ci1);
		boolean b1 = true;
		String s1 = "abc";
		byte bt1 = 100;
		int it1 = bt1;
		bt1 = (byte) it1;
		System.out.println(bt1);
		byte b22 = 10 + 20;
		b22 = (byte) (b22+1);
		System.out.println(b22);
	}

}
