package workshopMe;

public class Member {
	private String memID, name, memPW, phoneNum;

	public Member() {
	}

	public Member(String memID, String name, String memPW, String phoneNum) {
		super();
		this.memID = memID;
		this.name = name;
		this.memPW = memPW;
		this.phoneNum = phoneNum;
	}

	public String getMemID() {
		return memID;
	}

	public void setMemID(String memID) {
		this.memID = memID;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPhoneNum() {
		return phoneNum;
	}

	public void setPhoneNum(String phoneNum) {
		this.phoneNum = phoneNum;
	}

	public String getMemPW() {
		return memPW;
	}

	public void setMemPW(String memPW) {
		this.memPW = memPW;
	}

}
