package hospital.service;

import java.sql.SQLException;
import java.util.List;

import hospital.dao.DepartmentDao;
import hospital.dao.DepartmentDaoImpl;
import hospital.dto.HospitalDepartmentDto;
import hospital.exception.DepartmentException;
import hospital.exception.DuplicatedIdException;
import hospital.exception.RecordNotFoundException;

public class DepartmentServiceImpl implements DepartmentService {
	private DepartmentDao departmentDao = new DepartmentDaoImpl();

	@Override
	public boolean add(HospitalDepartmentDto dto) throws DepartmentException {
		try {
			departmentDao.add(dto);
		} catch (SQLException e) {
			throw new DepartmentException(e.getMessage());
		} catch (DuplicatedIdException e) {
		}
		return true;
	}

	@Override
	public List<HospitalDepartmentDto> list() throws DepartmentException {
		List<HospitalDepartmentDto> list = null;
		try {
			list = departmentDao.list();
		} catch (SQLException e) {
			e.printStackTrace();
			throw new DepartmentException(e.getMessage());
		}
		return list;
	}

	@Override
	public HospitalDepartmentDto read(int no) throws DepartmentException, RecordNotFoundException {
		HospitalDepartmentDto dto;
		try {
			dto = departmentDao.findById(no);
			if (dto == null) {
				throw new RecordNotFoundException();
			}
		} catch (SQLException e) {
			e.printStackTrace();
			throw new DepartmentException(e.getMessage());
		}
		return dto;
	}

	@Override
	public boolean update(HospitalDepartmentDto dto) throws DepartmentException, RecordNotFoundException {
		try {
			departmentDao.update(dto);
		} catch (SQLException e) {
			e.printStackTrace();
			throw new DepartmentException(e.getMessage());
		}
		return true;
	}

	@Override
	public boolean delete(int no) throws DepartmentException, RecordNotFoundException {
		try {
			HospitalDepartmentDto dto = departmentDao.findById(no);
			if (dto == null) {// 해당번호가 없음
				throw new RecordNotFoundException();
			}
			departmentDao.delete(no);
		} catch (SQLException e) {
			throw new DepartmentException(e.getMessage());
		}
		return true;
	}

	@Override
	public int count() throws DepartmentException {
		int count = 0;
		try {
			count = departmentDao.count();
		} catch (SQLException e) {
			throw new DepartmentException(e.getMessage());
		}
		return count;
	}

}
