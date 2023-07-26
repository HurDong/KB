package day_04;

public class Emp extends Person{
	private String buseo;
	
	public Emp() {
	}
	
	public Emp(String id, String name, String buseo) {
		super(id,name);
		this.buseo = buseo;
	}

	public String getBuseo() {
		return buseo;
	}

	public void setBuseo(String buseo) {
		this.buseo = buseo;
	}

	@Override
	public String toString() {
		return super.toString() + ", buseo=" + buseo ;
	}
	
}
