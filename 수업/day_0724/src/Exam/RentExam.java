package Exam;

import Service.RentService;

public class RentExam {

	public static void main(String[] args) {
		RentService rs = new RentService();
		Sedan s = new Sedan(1234, 10, 1990, 2000, "승용차", 5);
		Van v = new Van(2345, 11, 1991, 2001, "승합차", 6, 200);
		Bus b = new Bus(3456, 12, 1992, 2002, "버스", 7);
		Truck t = new Truck(4567, 13, 1993, 2003, "트럭", 8);
		rs.add(s);
		rs.add(v);
		rs.add(b);
		rs.add(t);
		rs.rent(100, 1234, 10, "2023-07-01", 7, "2023-07-07", 17);
		rs.rent(1000, 5678, 20, "2023-07-02", 7, "2023-07-05", 17);
		System.out.println(rs.getRentCount());
	}
}
