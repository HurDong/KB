package hospital.service;

import java.sql.SQLException;
import java.util.List;

import hospital.dao.PatientDao;
import hospital.dao.PatientDaoImpl;
import hospital.dto.PatientDto;
import hospital.exception.DuplicatedIdException;
import hospital.exception.PatientException;
import hospital.exception.RecordNotFoundException;

public class PatientServiceImpl implements PatientService {
	private PatientDao patientDao = new PatientDaoImpl();

	@Override
	public boolean add(PatientDto dto) throws PatientException {
		try {
			patientDao.add(dto);
		} catch (SQLException e) {
			throw new PatientException(e.getMessage());
		} catch (DuplicatedIdException e) {
		}
		return true;
	}

	@Override
	public List<PatientDto> list() throws PatientException {
		List<PatientDto> list = null;
		try {
			list = patientDao.list();
		} catch (SQLException e) {
			e.printStackTrace();
			throw new PatientException(e.getMessage());
		}
		return list;
	}

	@Override
	public PatientDto read(int no) throws PatientException, RecordNotFoundException {
		PatientDto dto = null;
		try {
			dto = patientDao.findById(no);
			if (dto == null) {
				throw new RecordNotFoundException();
			}
		} catch (SQLException e) {
			e.printStackTrace();
			throw new PatientException(e.getMessage());
		}

		return dto;
	}

	@Override
	public boolean update(PatientDto dto) throws PatientException, RecordNotFoundException {
		try {
			patientDao.update(dto);
		} catch (SQLException e) {
			throw new PatientException(e.getMessage());
		}

		return true;
	}

	@Override
	public boolean delete(int no) throws PatientException, RecordNotFoundException {
		try {
			PatientDto dto = patientDao.findById(no);
			if (dto == null) {
				throw new RecordNotFoundException();
			}
			patientDao.delete(no);
		} catch (SQLException e) {
			throw new PatientException(e.getMessage());
		}

		return true;
	}

	@Override
	public int count() throws PatientException {
		int count = 0;
		try {
			count = patientDao.count();
		} catch (SQLException e) {
			throw new PatientException(e.getMessage());
		}
		return count;
	}

}
