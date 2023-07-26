package day_04;

public class ExtendsExam {
	public static void main(String[] args) {
		A a1 = new A();
		a1.i = 100;
		System.out.println(a1.i);
		B b1 = new B();
		b1.i = 200;
		b1.j = 300;
		System.out.println(a1.i);
	}

}

class A{
	int i;
}

class B extends A{
	int j;
	public void prn() {
		this.i = 500;
	}
}