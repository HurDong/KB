package day_01;

public class WhileExam {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int count = 1;
		while(count<=5) {
			count++;
			if(count==2) continue;
			if(count==3) break;
			System.out.println(count);
		}
		System.out.println("End");
	}
}
