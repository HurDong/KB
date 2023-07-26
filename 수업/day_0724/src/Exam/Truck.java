package Exam;

public class Truck extends Car {
	public int weight;

	public Truck(int carNum, int price, int year, int gas, String carType, int weight) {
		// TODO Auto-generated constructor stub
		super(carNum, price, year, gas, carType);
		this.weight = weight;
	}
}
