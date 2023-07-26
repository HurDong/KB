package Exam;

public class Rent {
	public int rentNum, carNum, memNum, price, startT, endT;
	public String start, end;

	public Rent() {
		// TODO Auto-generated constructor stub
	}

	public Rent(int rentNum, int carNum, int memNum, int price, int startT, String start, String end, int endT) {
		super();
		this.rentNum = rentNum;
		this.carNum = carNum;
		this.memNum = memNum;
		this.price = price;
		this.startT = startT;
		this.start = start;
		this.end = end;
		this.endT = endT;
	}

	public int getRentNum() {
		return rentNum;
	}

	public void setRentNum(int rentNum) {
		this.rentNum = rentNum;
	}

	public int getCarNum() {
		return carNum;
	}

	public void setCarNum(int carNum) {
		this.carNum = carNum;
	}

	public int getMemNum() {
		return memNum;
	}

	public void setMemNum(int memNum) {
		this.memNum = memNum;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public int getStartT() {
		return startT;
	}

	public void setTime(int startT) {
		this.startT = startT;
	}

	public String getStart() {
		return start;
	}

	public void setStart(String start) {
		this.start = start;
	}

	public String getEnd() {
		return end;
	}

	public void setEnd(String end) {
		this.end = end;
	}

	public int getEndT() {
		return endT;
	}

	public void setEndT(int endT) {
		this.endT = endT;
	}

}
