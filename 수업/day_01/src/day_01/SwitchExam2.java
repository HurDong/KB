package day_01;

public class SwitchExam2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int month = (int)(Math.random()*11+1);
		switch(month) {
		case 2:
			System.out.println("28일");
			break;
		case 4:
		case 6:
		case 9:
		case 11:
			System.out.println("30일");
			break;
		default:
			System.out.println("31일");
			break;
		}
	}
	

}
