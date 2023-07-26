package 리뷰;

public class AnnoymousExam {
	public static void main(String[] args) {
		A a = new A() {
			int j = 100;
		}; // 일회용 임시 자식클래스 만드는 법
	}
}

class A{
	public void p() {
		System.out.println("A");
	}
}

interface MySwim{
	void swimming();
}

class MysSwimImplement implements MySwim{
	@Override
	public void swimming() {
		System.out.println("자유형 수영~");
		// TODO Auto-generated method stub
		
	}
}
