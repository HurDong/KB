package day_04;

public class InterfaceExam {
	public static void main(String[] args) {
		// 수영동호회 구성
		// 수영 가능한 사람만 모음
		// 수영하기() 메서드가 있는 객체를 정의
		PersonSwim p1 = new PersonSwim("100", "홍길동");
		Swimmable[] sma = new Swimmable[100]; // 특정 객체의 기능만 사용하기 위해.
		sma[0] = p1;
		sma[0].swim(); 
	}
}

interface Swimmable{ // interface는 주로 형용사로 작명
	public void swim();
	
}

class PersonSwim extends Person implements Swimmable{ // interface에 존재하는 모든 메서드를 구현해야함.
	
	public PersonSwim(String id, String name) {
		super(id,name);
	}
	
	@Override
	public void swim() {
		System.out.println("사람. 페트병으로 수영");
		
	}
	
}