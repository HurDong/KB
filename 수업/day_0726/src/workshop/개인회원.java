package workshop;

public class 개인회원 {

	private String id;
	private String name;
	private String passwd;
	private String tel;

	public 개인회원() {
	}
	public 개인회원(String id, String name, String passwd, String tel ) {
		this.id = id;
		this.name = name;
		this.passwd = passwd;
		this.tel = tel;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPasswd() {
		return passwd;
	}
	public void setPasswd(String passwd) {
		this.passwd = passwd;
	}
	public String getTel() {
		return tel;
	}
	public void setTel(String tel) {
		this.tel = tel;
	}
	@Override
	public String toString() {
		return "id=" + id + ", name=" + name + ", passwd=" + passwd + ", tel=" + tel ;
	}

}
