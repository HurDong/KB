package Service;

import java.util.ArrayList;

import Exam.*;

public class RentService {
	static int i = 1;
	private ArrayList<Car> cars = new ArrayList<Car>();
	private ArrayList<Mem> mems = new ArrayList<Mem>();
	private ArrayList<Rent> rents = new ArrayList<Rent>();

	public void add(Car c) {
		cars.add(c);
	}

	public void add(Mem m) {
		mems.add(m);
	}

	public void add(Rent r) {
		rents.add(r);
	}

	public void rent(int memNum, int carNum, int price, String start, int startT, String end, int endT) {
		Rent r = new Rent(i++, carNum, memNum, price, startT, start, end, endT);
		rents.add(r);
	}

	public int getRentCount() {
		return rents.size();
	}
}
