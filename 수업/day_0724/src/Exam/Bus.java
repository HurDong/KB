package Exam;

public class Bus extends Car {
	public int num;

	public Bus(int carNum, int price, int year, int gas, String carType, int num) {
		// TODO Auto-generated constructor stub
		super(carNum, price, year, gas, carType);
		this.num = num;
	}
}
