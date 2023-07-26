package Libraray;

public class CDShare extends Share {
	public int price;

	public CDShare() {
		// TODO Auto-generated constructor stub
	}

	public CDShare(String name, int regNum, String genre, int price) {
		super(name, regNum, genre);
		this.price = price;
	}

}
