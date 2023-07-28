package workshop;

// 대여(대여번호, 회원id, 대여할물건관리번호, 대여년월일, 대여시분, 반납년월일, 반납시분)
public class MyRent {
	int 대여번호;
	String 회원id;
	int 대여물건관리번호;
	String 대여년월일;
	int 대여시, 대여분;
	String 반납년월일;
	int 반납시, 반납분;
	
	public MyRent() {
	}

	public MyRent(int 대여번호, String 회원id, int 대여물건관리번호, String 대여년월일, int 대여시, int 대여분, String 반납년월일, int 반납시, int 반납분) {
		super();
		this.대여번호 = 대여번호;
		this.회원id = 회원id;
		this.대여물건관리번호 = 대여물건관리번호;
		this.대여년월일 = 대여년월일;
		this.대여시 = 대여시;
		this.대여분 = 대여분;
		this.반납년월일 = 반납년월일;
		this.반납시 = 반납시;
		this.반납분 = 반납분;
	}

	public int get대여번호() {
		return 대여번호;
	}

	public void set대여번호(int 대여번호) {
		this.대여번호 = 대여번호;
	}

	public String get회원id() {
		return 회원id;
	}

	public void set회원id(String 회원id) {
		this.회원id = 회원id;
	}

	public int get대여물건관리번호() {
		return 대여물건관리번호;
	}

	public void set대여물건관리번호(int 대여물건관리번호) {
		this.대여물건관리번호 = 대여물건관리번호;
	}

	public String get대여년월일() {
		return 대여년월일;
	}

	public void set대여년월일(String 대여년월일) {
		this.대여년월일 = 대여년월일;
	}

	public int get대여시() {
		return 대여시;
	}

	public void set대여시(int 대여시) {
		this.대여시 = 대여시;
	}

	public int get대여분() {
		return 대여분;
	}

	public void set대여분(int 대여분) {
		this.대여분 = 대여분;
	}

	public String get반납년월일() {
		return 반납년월일;
	}

	public void set반납년월일(String 반납년월일) {
		this.반납년월일 = 반납년월일;
	}

	public int get반납시() {
		return 반납시;
	}

	public void set반납시(int 반납시) {
		this.반납시 = 반납시;
	}

	public int get반납분() {
		return 반납분;
	}

	public void set반납분(int 반납분) {
		this.반납분 = 반납분;
	}

	@Override
	public String toString() {
		return "대여번호=" + 대여번호 + ", 회원id=" + 회원id + ", 대여물건관리번호=" + 대여물건관리번호 + ", 대여년월일=" + 대여년월일 + ", 대여시="
				+ 대여시 + ", 대여분=" + 대여분 + ", 반납년월일=" + 반납년월일 + ", 반납시=" + 반납시 + ", 반납분=" + 반납분 ;
	}
	
}
