package hospital.service;

import java.sql.SQLException;
import java.util.List;

import hospital.dao.ReservationDao;
import hospital.dao.ReservationDaoImpl;
import hospital.dto.ReservationDto;
import hospital.exception.DuplicatedIdException;
import hospital.exception.RecordNotFoundException;
import hospital.exception.ReservationException;

public class ReservationServiceImpl implements ReservationService {
	private ReservationDao reservationDao = new ReservationDaoImpl();

	@Override
	public boolean add(ReservationDto dto) throws ReservationException {
		try {
			reservationDao.add(dto);
		} catch (SQLException e) {
			throw new ReservationException(e.getMessage());
		} catch (DuplicatedIdException e) {
		}
		return true;
	}

	@Override
	public List<ReservationDto> list() throws ReservationException {
		List<ReservationDto> list = null;
		try {
			list = reservationDao.list();
		} catch (SQLException e) {
			e.printStackTrace();
			throw new ReservationException(e.getMessage());
		}
		return list;
	}

	@Override
	public ReservationDto read(int no) throws ReservationException, RecordNotFoundException {
		ReservationDto dto = null;
		try {
			dto = reservationDao.findById(no);
			if (dto == null) {
				throw new RecordNotFoundException();
			}
		} catch (SQLException e) {
			e.printStackTrace();
			throw new ReservationException(e.getMessage());
		}

		return dto;
	}

	@Override
	public boolean update(ReservationDto dto) throws ReservationException, RecordNotFoundException {
		try {
			reservationDao.update(dto);
		} catch (SQLException e) {
			throw new ReservationException(e.getMessage());
		}
		return true;
	}

	@Override
	public boolean delete(int no) throws ReservationException, RecordNotFoundException {
		try {
			ReservationDto dto = reservationDao.findById(no);
			if (dto == null) {
				throw new RecordNotFoundException();
			}
			reservationDao.delete(no);
		} catch (SQLException e) {
			throw new ReservationException(e.getMessage());
		}

		return true;
	}

	@Override
	public int count() throws ReservationException {
		int count = 0;
		try {
			count = reservationDao.count();
		} catch (SQLException e) {
			throw new ReservationException(e.getMessage());
		}
		return count;
	}
}
