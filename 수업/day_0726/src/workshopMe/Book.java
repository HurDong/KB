package workshopMe;

public class Book extends Library {
	private String pub;

	public Book() {
	}

	public Book(int manageNum, String title, int price, String pub, int amount) {
		super(manageNum, title, price, amount);
		this.pub = pub;
	}

	public String getPub() {
		return pub;
	}

	public void setPub(String pub) {
		this.pub = pub;
	}

}
