package hospital.service;

import java.util.List;

import hospital.dto.PaymentDto;
import hospital.exception.PaymentException;
import hospital.exception.RecordNotFoundException;

public interface PaymentService {
	// 수납 등록
	public boolean add(PaymentDto dto) throws PaymentException;

	// 수납 목록
	public List<PaymentDto> list() throws PaymentException;

	// 수납정보 상세보기
	public PaymentDto read(int no) throws PaymentException, RecordNotFoundException;

	// 수납정보 수정
	public boolean update(PaymentDto dto) throws PaymentException, RecordNotFoundException;

	// 수납정보 삭제
	public boolean delete(int no) throws PaymentException, RecordNotFoundException;

	// 수납수
	public int count() throws PaymentException;
}
