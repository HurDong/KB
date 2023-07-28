package workshopMe;

public class CD extends Library {
	private String singer;

	public CD() {
	}

	public CD(int manageNum, String title, int price, String singer, int amount) {
		super(manageNum, title, price, amount);
		this.singer = singer;
	}

	public String getSinger() {
		return singer;
	}

	public void setSinger(String singer) {
		this.singer = singer;
	}

}
