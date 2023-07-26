package day_03;

public class PersonExam {
	public static void main(String[] args) {
		Person p1 = new Person(); // 지역 변수 -> method 코드 실행할 때 stack내에 생성, method 종료시 사라짐.
		p1.printInfo();
		System.out.println(p1.getAge());
		
		Person p2 = new Person("박길동",35);
		p2.printInfo();
		
		Person p3 = new Person(36,"강길동");
		p3.printInfo();
		
	}
}
