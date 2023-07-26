package day_05;

import java.util.HashSet;
import java.util.Set;

public class SetExam {
	public static void main(String[] args) {
		Set<String> hs = new HashSet<String>();		
		박태환선수 bt = new 박태환선수();
		
		수영선수 s1;
		s1 = bt;
		
		야구선수 b1;
		b1 = bt;
		
		// 객체의 형변환
		s1.swimming();
		// s1.공던지기(); X
		b1.공던지기();
		// b1.swimming(); X
		bt.swimming();
		bt.공던지기();
	}
}

interface 수영선수{
	public void swimming();
}

interface 야구선수{
	public void 공던지기();
}

class 박태환선수 implements 수영선수, 야구선수{
	public void swimming() {
		System.out.println("수영하기");
	}
	public void 공던지기() {
		System.out.println("공던지기");
	}
}

//class implements 야구선수{
//	public void 공던지기() {
//		
//	}
//}
