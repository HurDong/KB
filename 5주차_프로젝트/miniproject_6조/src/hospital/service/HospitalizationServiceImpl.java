package hospital.service;

import java.sql.SQLException;
import java.util.List;

import hospital.dao.HospitalizationDao;
import hospital.dao.HospitalizationDaoImpl;
import hospital.dto.HospitalizationDto;
import hospital.exception.DuplicatedIdException;
import hospital.exception.HospitalizationException;
import hospital.exception.RecordNotFoundException;

public class HospitalizationServiceImpl implements HospitalizationService {
	private HospitalizationDao hospitalizationDao = new HospitalizationDaoImpl();

	@Override
	public boolean add(HospitalizationDto dto) throws HospitalizationException {
		try {
			hospitalizationDao.add(dto);
		} catch (SQLException e) {
			throw new HospitalizationException(e.getMessage());
		} catch (DuplicatedIdException e) {
		}
		return true;
	}

	@Override
	public List<HospitalizationDto> list() throws HospitalizationException {
		List<HospitalizationDto> list = null;
		try {
			list = hospitalizationDao.list();
		} catch (SQLException e) {
			e.printStackTrace();
			throw new HospitalizationException(e.getMessage());
		}
		return list;
	}

	@Override
	public HospitalizationDto read(int no) throws HospitalizationException, RecordNotFoundException {
		HospitalizationDto dto = null;
		try {
			dto = hospitalizationDao.findById(no);
			if (dto == null) {
				throw new RecordNotFoundException();
			}
		} catch (SQLException e) {
			e.printStackTrace();
			throw new HospitalizationException(e.getMessage());
		}

		return dto;
	}

	@Override
	public boolean update(HospitalizationDto dto) throws HospitalizationException, RecordNotFoundException {
		try {
			hospitalizationDao.update(dto);
		} catch (SQLException e) {
			throw new HospitalizationException(e.getMessage());
		}

		return true;
	}

	@Override
	public boolean delete(int no) throws HospitalizationException, RecordNotFoundException {
		try {
			HospitalizationDto dto = hospitalizationDao.findById(no);
			if (dto == null) {
				throw new RecordNotFoundException();
			}
			hospitalizationDao.delete(no);
		} catch (SQLException e) {
			throw new HospitalizationException(e.getMessage());
		}

		return true;
	}

	@Override
	public int count() throws HospitalizationException {
		int count = 0;
		try {
			count = hospitalizationDao.count();
		} catch (SQLException e) {
			throw new HospitalizationException(e.getMessage());
		}
		return count;
	}
}
