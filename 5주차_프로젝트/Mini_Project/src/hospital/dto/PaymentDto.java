package hospital.dto;

import java.util.Date;

/** 결제,수납정보 */
public class PaymentDto {
	private int payId; // 결제
	private int pId; // 환자
	private Date paymentDate;
	private int paymentAmount;

	public PaymentDto() {
	}

	public PaymentDto(int payId, int pId, Date paymentDate, int paymentAmount) {
		super();
		this.payId = payId;
		this.pId = pId;
		this.paymentDate = paymentDate;
		this.paymentAmount = paymentAmount;
	}

	public int getPayId() {
		return payId;
	}

	public void setPayId(int payId) {
		this.payId = payId;
	}

	public int getpId() {
		return pId;
	}

	public void setpId(int pId) {
		this.pId = pId;
	}

	public Date getPaymentDate() {
		return paymentDate;
	}

	public void setPaymentDate(Date paymentDate) {
		this.paymentDate = paymentDate;
	}

	public int getPaymentAmount() {
		return paymentAmount;
	}

	public void setPaymentAmount(int paymentAmount) {
		this.paymentAmount = paymentAmount;
	}

	@Override
	public String toString() {
		return "payId=" + payId + ", pId=" + pId + ", paymentDate=" + paymentDate + ", paymentAmount=" + paymentAmount;
	}

}
