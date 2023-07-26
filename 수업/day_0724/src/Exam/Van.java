package Exam;

public class Van extends Car {
	public int num, weight;

	public Van(int carNum, int price, int year, int gas, String carType, int num, int weight) {
		// TODO Auto-generated constructor stub
		super(carNum, price, year, gas, carType);
		this.num = num;
		this.weight = weight;
	}
}
