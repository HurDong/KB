package EX4;

public class LoginDto {
	private String member_id, login_date, login_time, logout_date, logout_time;

	public LoginDto() {
	}

	public LoginDto(String member_id, String login_date, String login_time, String logout_date, String logout_time) {
		super();
		this.member_id = member_id;
		this.login_date = login_date;
		this.login_time = login_time;
		this.logout_date = logout_date;
		this.logout_time = logout_time;
	}

	public String getMember_id() {
		return member_id;
	}

	public void setMember_id(String member_id) {
		this.member_id = member_id;
	}

	public String getLogin_date() {
		return login_date;
	}

	public void setLogin_date(String login_date) {
		this.login_date = login_date;
	}

	public String getLogin_time() {
		return login_time;
	}

	public void setLogin_time(String login_time) {
		this.login_time = login_time;
	}

	public String getLogout_date() {
		return logout_date;
	}

	public void setLogout_date(String logout_date) {
		this.logout_date = logout_date;
	}

	public String getLogout_time() {
		return logout_time;
	}

	public void setLogout_time(String logout_time) {
		this.logout_time = logout_time;
	}

	@Override
	public String toString() {
		return "LoginDto [member_id=" + member_id + ", login_date=" + login_date + ", login_time=" + login_time
				+ ", logout_date=" + logout_date + ", logout_time=" + logout_time + "]";
	}

}
