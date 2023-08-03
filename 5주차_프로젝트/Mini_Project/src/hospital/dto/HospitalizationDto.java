package hospital.dto;

import java.util.Date;

/** 입원정보 */
public class HospitalizationDto {
	private int hId;
	private int pId;
	private int doctorId; // 직원정보 = 의사
	private String roomNumber; // 입원실
	private Date addmissionDate; //
	private Date dischargeDate;

	public HospitalizationDto() {
	}

	public HospitalizationDto(int hId, int pId, int doctorId, String roomNumber, Date addmissionDate,
			Date dischargeDate) {
		super();
		this.hId = hId;
		this.pId = pId;
		this.doctorId = doctorId;
		this.roomNumber = roomNumber;
		this.addmissionDate = addmissionDate;
		this.dischargeDate = dischargeDate;
	}

	public int gethId() {
		return hId;
	}

	public void sethId(int hId) {
		this.hId = hId;
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

	public String getRoomNumber() {
		return roomNumber;
	}

	public void setRoomNumber(String roomNumber) {
		this.roomNumber = roomNumber;
	}

	public Date getAddmissionDate() {
		return addmissionDate;
	}

	public void setAddmissionDate(Date addmissionDate) {
		this.addmissionDate = addmissionDate;
	}

	public Date getDischargeDate() {
		return dischargeDate;
	}

	public void setDischargeDate(Date dischargeDate) {
		this.dischargeDate = dischargeDate;
	}

	@Override
	public String toString() {
		return "hId=" + hId + ", pId=" + pId + ", doctorId=" + doctorId + ", roomNumber=" + roomNumber
				+ ", addmissionDate=" + addmissionDate + ", dischargeDate=" + dischargeDate;
	}
}
