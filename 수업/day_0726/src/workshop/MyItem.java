package workshop;

public class MyItem {

	private int itemNo;
	private String title;
	private int price;
	private int quantity;

	public MyItem() {
	}
	public MyItem(int itemNo, String title, int price, int quantity) {
		this.itemNo = itemNo;
		this.title = title;
		this.price = price;
		this.quantity = quantity;
	}
	public int getItemNo() {
		return itemNo;
	}
	public void setItemNo(int itemNo) {
		this.itemNo = itemNo;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	@Override
	public String toString() {
		return "itemNo=" + itemNo + ", title=" + title + ", price=" + price + ", quantity=" + quantity ;
	}

}
