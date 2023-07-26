package day_01;

public class SwitchExam {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// 가위바위보
		double d = Math.random();
		d *=3; // 0.0 ~ 2.999999
		int i = (int) d;
		if(i==0)	System.out.println("가위");
		else if(i==1) System.out.println("바위");
		else if(i==2) System.out.println("보");
		// 로또
		double lottoNum = Math.random();
		lottoNum = (lottoNum * 44) +1;
		int j = (int) lottoNum;
		System.out.println("로또번호는 " + j);
		// switch
		switch (i) {
		case 0:
			System.out.println("가위");
			break;
		case 1:
			System.out.println("바위");
			break;
		case 2:
			System.out.println("보");
			break;
		default:
			System.out.println("asfd");
			break;
		}
	}
	
}
