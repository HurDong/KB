package day_03;

/* 클래스의 4자기 스타일 
 * 1. VO, DTO : Value Object, Data Transfer Object -> 데이터 저장용
 * 2. Manager, DAO : VO에 대한 관리 기능(CRUD->Create Read Update Delete)
 * 3. UI : 입출력 인터페이스(CUI,GUI,Web UI)
 * 4. IO : 데이터 입출력
*/

// public은 파일명과 클래스명이 동일해야함. 하나의 소스파일에는 하나의 public 클래스만 존재 가능.
public class Person {
	private String name; // 필드 // 객체 생성 시 객체 영역에 생성
 	private int age;
	
	// 기본 생성자 생성 -> ctrl + space 첫줄
	public Person(String name, int age) {
		this.name = name; // 가장 가까운 block내에 선언된 것으로 사용 -> this(현재객체)를 사용하여 구분
		this.age = age;   // 파란색 -> 필드(맴버변수) , 갈색 -> 매개변수
	}
	// 생성자 오버로딩의 규칙 1. 이름동일 2. 매개변수 다름(타입또는 순서,갯수가 달라야함/매개변수 이름은 무관함)
	public Person() {
	}
	
	
	// 다른 생성자 호출은 생성자 내부 첫째줄에서밖에 호출을 못한다.
	public Person(int age, String name) {
		this(name,age); // 16줄에 있는 생성자 호출, this(age,name)일 경우에는 재귀 -> 무한 루프
	}
	
	/** Person 클래스내에 존재하는 모든 필드 변수값을 출력한다. */
	public void printInfo() {
		System.out.println("이름 : " + this.name + " , 나이 : " + this.age);
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	
}
