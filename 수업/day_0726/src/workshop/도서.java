package workshop;

public class 도서 extends MyItem{

	private String publisher;

	public 도서(int itemNo, String title, int price, String publisher, int quantity) {
		super(itemNo, title, price, quantity);
		this.publisher = publisher;
	}

}
