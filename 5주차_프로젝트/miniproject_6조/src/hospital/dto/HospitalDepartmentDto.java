package hospital.dto;

/** 부서정보 */
public class HospitalDepartmentDto {
	private int dId;
	private String departmentName;
	private int mangerId;

	public HospitalDepartmentDto() {
	}

	public int getdId() {
		return dId;
	}

	public void setdId(int dId) {
		this.dId = dId;
	}

	public String getDepartmentName() {
		return departmentName;
	}

	public void setDepartmentName(String departmentName) {
		this.departmentName = departmentName;
	}

	public int getMangerId() {
		return mangerId;
	}

	public void setMangerId(int mangerId) {
		this.mangerId = mangerId;
	}

	public HospitalDepartmentDto(int dId, String departmentName, int mangerId) {
		super();
		this.dId = dId;
		this.departmentName = departmentName;
		this.mangerId = mangerId;
	}

	@Override
	public String toString() {
		return "dId=" + dId + ", departmentName=" + departmentName + ", mangerId=" + mangerId;
	}

}
