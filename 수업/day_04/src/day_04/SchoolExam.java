package day_04;

public class SchoolExam {
	public static void main(String[] args) {
		// 학교내 인원관리
		// 관리대상 - 학생, 교수, 직원
		// 학생 - 학번, 이름, 전공 / 교수 - 교번, 이름, 연구실 / 직원 - 사번, 이름, 부서
		// class Person{id,name}
		// class Student extends Person{hakgwa}
		// class Teacher extends Person{yeongusil}
		// class Emp extends Person{buseo}
		Person p = new Person("100","홍길동");
		System.out.println(p);
		
		Student st = new Student("200","김길동","컴퓨터공학");
		System.out.println(st);
		
		Emp e = new Emp("300","박길동","개발");
		System.out.println(e);

		Person[] pa = new Person[100]; // 자동 형변환 -> 편리한 관리 / 자식 클래스가 부모 클래스 타입으로 변환이 됨.
		pa[0] = st;
		pa[1] = e;
		pa[2] = p;
		
		//학교 인원 관리 기능
		SchoolService ss = new SchoolService();
		ss.add(st);
		ss.add(e);
		
		System.out.println(st instanceof Student);

		if(p instanceof Student) {
			Student st2 = (Student)p; // 다운 캐스팅
			System.out.println("학생입니다.");
		} else System.out.println("학생이 아닙니다.");
		
	}
}
