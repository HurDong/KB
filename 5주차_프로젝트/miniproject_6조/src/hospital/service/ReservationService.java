package hospital.service;

import java.util.List;

import hospital.dto.ReservationDto;
import hospital.exception.RecordNotFoundException;
import hospital.exception.ReservationException;

public interface ReservationService {
	// 예약 등록
	public boolean add(ReservationDto dto) throws ReservationException;

	// 예약 목록
	public List<ReservationDto> list() throws ReservationException; // 서버오류

	// 예약정보 상세보기
	public ReservationDto read(int no) throws ReservationException, RecordNotFoundException;

	// 예약정보 수정
	public boolean update(ReservationDto dto) throws ReservationException, RecordNotFoundException;

	// 예약정보 삭제
	public boolean delete(int no) throws ReservationException, RecordNotFoundException;

	// 예약수
	public int count() throws ReservationException;
}
