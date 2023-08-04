package hospital.service;

import java.sql.SQLException;
import java.util.List;

import hospital.dao.DiagnosisDao;
import hospital.dao.DiagnosisDaoImpl;
import hospital.dto.DiagnosisDto;
import hospital.exception.DiagnosisException;
import hospital.exception.DuplicatedIdException;
import hospital.exception.RecordNotFoundException;

public class DiagnosisServiceImpl implements DiagnosisService {
	private DiagnosisDao diagnosisDao = new DiagnosisDaoImpl();

	@Override
	public boolean add(DiagnosisDto dto) throws DiagnosisException {
		try {
			diagnosisDao.add(dto);
		} catch (SQLException e) {
			throw new DiagnosisException(e.getMessage());
		} catch (DuplicatedIdException e) {

		}
		return true;
	}

	@Override
	public List<DiagnosisDto> list() throws DiagnosisException {
		List<DiagnosisDto> list = null;
		try {
			list = diagnosisDao.list();
		} catch (SQLException e) {
			e.printStackTrace();
			throw new DiagnosisException(e.getMessage());
		}
		return list;
	}

	@Override
	public DiagnosisDto read(int no) throws DiagnosisException, RecordNotFoundException {
		DiagnosisDto dto = null;
		try {
			dto = diagnosisDao.findById(no);
			if (dto == null) {
				throw new RecordNotFoundException();
			}
		} catch (SQLException e) {
			e.printStackTrace();
			throw new DiagnosisException(e.getMessage());
		}
		return dto;
	}

	@Override
	public boolean update(DiagnosisDto dto) throws DiagnosisException, RecordNotFoundException {
		try {
			diagnosisDao.update(dto);
		} catch (SQLException e) {
			throw new DiagnosisException(e.getMessage());
		}

		return true;
	}

	@Override
	public boolean delete(int no) throws DiagnosisException, RecordNotFoundException {
		try {
			DiagnosisDto dto = diagnosisDao.findById(no);
			if (dto == null)
				throw new RecordNotFoundException();
			diagnosisDao.delete(no);
		} catch (SQLException e) {
			throw new DiagnosisException(e.getMessage());
		}
		return true;
	}

	@Override
	public int count() throws DiagnosisException {
		int count = 0;
		try {
			count = diagnosisDao.count();
		} catch (SQLException e) {
			throw new DiagnosisException(e.getMessage());
		}
		return count;
	}

}
