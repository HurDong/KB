package hospital.dto;

/** 환자정보 */
public class PatientDto {
	private int pId;
	private String name;
	private String birth;
	private String gender;
	private String phoneNumber;
	private String address;

	public PatientDto() {
	}

	public PatientDto(int pId, String name, String birth, String gender, String phoneNumber, String address) {
		super();
		this.pId = pId;
		this.name = name;
		this.birth = birth;
		this.gender = gender;
		this.phoneNumber = phoneNumber;
		this.address = address;
	}

	public int getpId() {
		return pId;
	}

	public void setpId(int pId) {
		this.pId = pId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getBirth() {
		return birth;
	}

	public void setBirth(String birth) {
		this.birth = birth;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	@Override
	public String toString() {
		return "pId=" + pId + ", name=" + name + ", birth=" + birth + ", gender=" + gender + ", phoneNumber="
				+ phoneNumber + ", address=" + address;
	}
}
