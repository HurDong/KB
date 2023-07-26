package Exam;

public class CorpMem extends Mem {
	public int regNum;

	public CorpMem(int memNum, int phoneNum, String memType, String memName, int regNum) {
		super(memNum, phoneNum, memType, memName);
		this.regNum = regNum;
	}

}
