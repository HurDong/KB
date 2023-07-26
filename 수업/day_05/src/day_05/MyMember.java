package day_05;

import java.util.Objects;

public class MyMember implements Comparable<MyMember>{
	
	private String name;
	private int age;
	
	public MyMember() {
		
	}
	
	public MyMember(String name, int age) {
		super();
		this.name = name;
		this.age = age;
	}



	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return "MyMember [name=" + name + ", age=" + age + "]";
	}

	@Override
	public int compareTo(MyMember o) {
		// 나이 기준 정렬
		return this.age - o.getAge(); // 음수 -> 내가 매개변수보다 앞 / 양수 -> 내가 매개변수보다 뒷 순서 
	}

	@Override
	public int hashCode() {
		return Objects.hash(age, name);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		MyMember other = (MyMember) obj;
		return age == other.age && Objects.equals(name, other.name);
	}
	
	
}
