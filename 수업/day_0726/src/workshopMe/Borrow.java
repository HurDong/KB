package workshopMe;

public class Borrow {
	private int borrowNum, manageNum, borrowMD, borrowHM, returnYMD, returnHM;
	private String memId;

	public Borrow() {
	}

	public Borrow(int borrowNum, int manageNum, int borrowMD, int borrowHM, int returnYMD, int returnHM, String memId) {
		super();
		this.borrowNum = borrowNum;
		this.manageNum = manageNum;
		this.borrowMD = borrowMD;
		this.borrowHM = borrowHM;
		this.returnYMD = returnYMD;
		this.returnHM = returnHM;
		this.memId = memId;
	}

	public int getBorrowNum() {
		return borrowNum;
	}

	public void setBorrowNum(int borrowNum) {
		this.borrowNum = borrowNum;
	}

	public int getManageNum() {
		return manageNum;
	}

	public void setManageNum(int manageNum) {
		this.manageNum = manageNum;
	}

	public int getBorrowMD() {
		return borrowMD;
	}

	public void setBorrowMD(int borrowMD) {
		this.borrowMD = borrowMD;
	}

	public int getBorrowHM() {
		return borrowHM;
	}

	public void setBorrowHM(int borrowHM) {
		this.borrowHM = borrowHM;
	}

	public int getReturnYMD() {
		return returnYMD;
	}

	public void setReturnYMD(int returnYMD) {
		this.returnYMD = returnYMD;
	}

	public int getReturnHM() {
		return returnHM;
	}

	public void setReturnHM(int returnHM) {
		this.returnHM = returnHM;
	}

	public String getMemId() {
		return memId;
	}

	public void setMemId(String memId) {
		this.memId = memId;
	}

}
