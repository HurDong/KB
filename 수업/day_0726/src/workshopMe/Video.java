package workshopMe;

public class Video extends Library {
	private String pro;

	public Video() {
	}

	public Video(int manageNum, String title, int price, String pro, int amount) {
		super(manageNum, title, price, amount);
		this.pro = pro;
	}

	public String getPro() {
		return pro;
	}

	public void setPro(String pro) {
		this.pro = pro;
	}

}
