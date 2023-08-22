package spring01;

public class NumberGuess {
	private int com_num = new java.util.Random().nextInt(100) + 1;
	
	public String checkNumber(int num) {
		if (com_num == num) {
			return "정답";
		}
		if (com_num < num) {
			return "내려주세요";
		} else {
			return "올려주세요";
		}
	}

}
