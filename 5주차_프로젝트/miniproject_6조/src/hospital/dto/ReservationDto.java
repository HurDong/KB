package hospital.dto;

import java.sql.Date;

/** 예약정보 */
public class ReservationDto {
	private int rId; // 예약
	private int pId; // 환자
	private int doctorId; // 직원정보 = 의사
	private Date reservationDate;
	private String reservationTime;

	public ReservationDto() {
	}

	public ReservationDto(int rId, int pId, int doctorId, Date reservationDate, String reservationTime) {
		super();
		this.rId = rId;
		this.pId = pId;
		this.doctorId = doctorId;
		this.reservationDate = reservationDate;
		this.reservationTime = reservationTime;
	}

	public int getrId() {
		return rId;
	}

	public void setrId(int rId) {
		this.rId = rId;
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

	public Date getReservationDate() {
		return reservationDate;
	}

	public void setReservationDate(Date reservationDate) {
		this.reservationDate = reservationDate;
	}

	public String getReservationTime() {
		return reservationTime;
	}

	public void setReservationTime(String reservationTime) {
		this.reservationTime = reservationTime;
	}

	@Override
	public String toString() {
		return "rId=" + rId + ", pId=" + pId + ", doctorId=" + doctorId + ", reservationDate=" + reservationDate
				+ ", reservationTime=" + reservationTime;
	}

}