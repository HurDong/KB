package Exam;

public class Car {
	public int carNum, price, year, gas;
	public String carType;
	public Car() {
		// TODO Auto-generated constructor stub
	}
	public Car(int carNum, int price, int year, 
			int gas, String carType) {
		super();
		this.carNum = carNum;
		this.price = price;
		this.year = year;
		this.gas = gas;
		this.carType = carType;
	}
	public int getCarNum() {
		return carNum;
	}
	public void setCarNum(int carNum) {
		this.carNum = carNum;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public int getYear() {
		return year;
	}
	public void setYear(int year) {
		this.year = year;
	}
	public int getGas() {
		return gas;
	}
	public void setGas(int gas) {
		this.gas = gas;
	}
	public String getCarType() {
		return carType;
	}
	public void setCarType(String carType) {
		this.carType = carType;
	}
	
	
}
