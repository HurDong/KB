package day_04;

public class Student extends Person{
	private String hakgwa;
	
	public Student() { // 부모 클래스의 기본 생성자를 호출 -> 기본 생성자를 꼭 만들어주자.
	}
	
	public Student(String hakgwa) {
		this.hakgwa = hakgwa;
	}

	public Student(String id, String name, String hakgwa) {
		super(id, name);
		this.hakgwa = hakgwa;
	}

	public String getHakgwa() {
		return hakgwa;
	}

	public void setHakgwa(String hakgwa) {
		this.hakgwa = hakgwa;
	}

	@Override
	public String toString() {
		return super.toString() + ", hakgwa = " + hakgwa;
	}

	
	
	
	
}
