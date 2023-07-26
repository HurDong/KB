package Exam;

public class Mem {
	public int memNum, phoneNum;
	public String memType, memName;
	public Mem() {
		// TODO Auto-generated constructor stub
	}
	public Mem(int memNum, int phoneNum, String memType, String memName) {
		super();
		this.memNum = memNum;
		this.phoneNum = phoneNum;
		this.memType = memType;
		this.memName = memName;
	}
	public int getMemNum() {
		return memNum;
	}
	public void setMemNum(int memNum) {
		this.memNum = memNum;
	}
	public int getPhoneNum() {
		return phoneNum;
	}
	public void setPhoneNum(int phoneNum) {
		this.phoneNum = phoneNum;
	}
	public String getMemType() {
		return memType;
	}
	public void setMemType(String memType) {
		this.memType = memType;
	}
	public String getMemName() {
		return memName;
	}
	public void setMemName(String memName) {
		this.memName = memName;
	}
	
}
