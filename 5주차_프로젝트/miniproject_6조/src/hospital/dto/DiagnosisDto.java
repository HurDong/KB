package hospital.dto;

import java.sql.Date;

public class DiagnosisDto {
	private int diaId;
	private int pId;
	private int doctorId;
	private Date diagnosisDate;
	private String diagnosisContents;

	public DiagnosisDto() {
	}

	public DiagnosisDto(int diaId, int pId, int doctorId, Date diagnosisDate, String diagnosisContents) {
		super();
		this.diaId = diaId;
		this.pId = pId;
		this.doctorId = doctorId;
		this.diagnosisDate = diagnosisDate;
		this.diagnosisContents = diagnosisContents;
	}

	public int getDiaId() {
		return diaId;
	}

	public void setDiaId(int diaId) {
		this.diaId = diaId;
	}

	public int getpId() {
		return pId;
	}

	public void setpId(int pId) {
		this.pId = pId;
	}

	public int getDoctorId() {
		return doctorId;
	}

	public void setDoctorId(int doctorId) {
		this.doctorId = doctorId;
	}

	public Date getDiagnosisDate() {
		return diagnosisDate;
	}

	public void setDiagnosisDate(Date diagnosisDate) {
		this.diagnosisDate = diagnosisDate;
	}

	public String getDiagnosisContents() {
		return diagnosisContents;
	}

	public void setDiagnosisContents(String diagnosisContents) {
		this.diagnosisContents = diagnosisContents;
	}

	@Override
	public String toString() {
		return "diaId=" + diaId + ", pId=" + pId + ", doctorId=" + doctorId + ", diagnosisDate=" + diagnosisDate
				+ ", diagnosisContents=" + diagnosisContents;
	}

}
