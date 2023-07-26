package day_04;

public class SchoolService {
	private Person[] parr = new Person[100];
	private int pCount = 0;
	
	public void add(Person p) {
		parr[pCount++] = p;
	}	
	
	
}
