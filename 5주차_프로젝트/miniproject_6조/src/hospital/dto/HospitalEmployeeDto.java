package hospital.dto;

/** 직원정보 */
public class HospitalEmployeeDto {
	private int eId; // 직원 id
	private int dId; // 부서 id
	private String name;
	private int empCode; // 직원코드 1:의사, 2:간호사, 3.행정직원
	private String phoneNumber;

	public HospitalEmployeeDto() {
	}

	public HospitalEmployeeDto(int eId, int dId, String name, int empCode, String phoneNumber) {
		super();
		this.eId = eId;
		this.dId = dId;
		this.name = name;
		this.empCode = empCode;
		this.phoneNumber = phoneNumber;
	}

	public int geteId() {
		return eId;
	}

	public void seteId(int eId) {
		this.eId = eId;
	}

	public int getdId() {
		return dId;
	}

	public void setdId(int dId) {
		this.dId = dId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getEmpCode() {
		return empCode;
	}

	public void setEmpCode(int empCode) {
		this.empCode = empCode;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	@Override
	public String toString() {
		return "eId=" + eId + ", dId=" + dId + ", name=" + name + ", empCode=" + empCode + ", phoneNumber="
				+ phoneNumber;
	}

}
