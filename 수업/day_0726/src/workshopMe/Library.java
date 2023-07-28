package workshopMe;

public class Library {
	private int manageNum, price, amount;
	private String title;

	public Library() {
	}

	public Library(int manageNum, String title, int price, int amount) {
		super();
		this.manageNum = manageNum;
		this.title = title;
		this.price = price;
		this.amount = amount;
	}

	public int getManageNum() {
		return manageNum;
	}

	public void setManageNum(int manageNum) {
		this.manageNum = manageNum;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public int getAmount() {
		return amount;
	}

	public void setAmount(int amount) {
		this.amount = amount;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

}
