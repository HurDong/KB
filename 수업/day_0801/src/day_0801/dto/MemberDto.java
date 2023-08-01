package day_0801.dto;

public class MemberDto {
	private String id, name, passwd, status;

	public MemberDto() {
	}

	public MemberDto(String id, String name, String passwd, String status) {
		super();
		this.id = id;
		this.name = name;
		this.passwd = passwd;
		this.status = status;
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

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	@Override
	public String toString() {
		return "id=" + id + ", name=" + name + ", passwd=" + passwd + ", status=" + status;
	}

}
