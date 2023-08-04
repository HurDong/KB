package hospital.service;

import java.sql.SQLException;
import java.util.List;

import hospital.dao.EmployeeDao;
import hospital.dao.EmployeeDaoImpl;
import hospital.dto.HospitalEmployeeDto;
import hospital.exception.DuplicatedIdException;
import hospital.exception.EmployeeException;
import hospital.exception.RecordNotFoundException;

public class EmployeeServiceImpl implements EmployeeService {

	private EmployeeDao employeeDao = new EmployeeDaoImpl();

	@Override
	public boolean add(HospitalEmployeeDto dto) throws EmployeeException {
		try {
			employeeDao.add(dto);
		} catch (SQLException e) {
			throw new EmployeeException(e.getMessage());
		} catch (DuplicatedIdException e) {
		}
		return true;
	}

	@Override
	public List<HospitalEmployeeDto> list() throws EmployeeException {
		List<HospitalEmployeeDto> list = null;

		try {
			list = employeeDao.list();
		} catch (SQLException e) {
			e.printStackTrace();
			throw new EmployeeException(e.getMessage());
		}
		return list;
	}

	@Override
	public HospitalEmployeeDto read(int no) throws EmployeeException, RecordNotFoundException {
		HospitalEmployeeDto dto = null;
		try {
			dto = employeeDao.findById(no);
		} catch (SQLException e) {
			e.printStackTrace();
			throw new EmployeeException(e.getMessage());
		}
		return dto;
	}

	@Override
	public boolean update(HospitalEmployeeDto dto) throws EmployeeException, RecordNotFoundException {
		try {
			employeeDao.update(dto);
		} catch (SQLException e) {
			e.printStackTrace();
			throw new EmployeeException(e.getMessage());
		}
		return true;
	}

	@Override
	public boolean delete(int no) throws EmployeeException, RecordNotFoundException {
		try {
			HospitalEmployeeDto dto = employeeDao.findById(no);
			if (dto == null) {
				throw new RecordNotFoundException();
			}
			employeeDao.delete(no);
		} catch (SQLException e) {
			throw new EmployeeException(e.getMessage());
		}
		return true;
	}

	@Override
	public int count() throws EmployeeException {
		int count = 0;
		try {
			count = employeeDao.count();
		} catch (SQLException e) {
			throw new EmployeeException(e.getMessage());
		}
		return count;
	}

}
