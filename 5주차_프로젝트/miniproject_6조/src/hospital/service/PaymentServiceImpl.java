package hospital.service;

import java.sql.SQLException;
import java.util.List;

import hospital.dao.PaymentDao;
import hospital.dao.PaymentDaoImpl;
import hospital.dto.PaymentDto;
import hospital.exception.DuplicatedIdException;
import hospital.exception.PaymentException;
import hospital.exception.RecordNotFoundException;

public class PaymentServiceImpl implements PaymentService {
	private PaymentDao paymentDao = new PaymentDaoImpl();

	@Override
	public boolean add(PaymentDto dto) throws PaymentException {
		try {
			paymentDao.add(dto);
		} catch (SQLException e) {
			throw new PaymentException(e.getMessage());
		} catch (DuplicatedIdException e) {
		}
		return true;
	}

	@Override
	public List<PaymentDto> list() throws PaymentException {
		List<PaymentDto> list = null;
		try {
			list = paymentDao.list();
		} catch (SQLException e) {
			e.printStackTrace();
			throw new PaymentException(e.getMessage());
		}
		return list;
	}

	@Override
	public PaymentDto read(int no) throws PaymentException, RecordNotFoundException {
		PaymentDto dto = null;
		try {
			dto = paymentDao.findById(no);
			if (dto == null) {
				throw new RecordNotFoundException();
			}
		} catch (SQLException e) {
			e.printStackTrace();
			throw new PaymentException(e.getMessage());
		}

		return dto;
	}

	@Override
	public boolean update(PaymentDto dto) throws PaymentException, RecordNotFoundException {
		try {
			paymentDao.update(dto);
		} catch (SQLException e) {
			throw new PaymentException(e.getMessage());
		}

		return true;
	}

	@Override
	public boolean delete(int no) throws PaymentException, RecordNotFoundException {
		try {
			PaymentDto dto = paymentDao.findById(no);
			if (dto == null) {
				throw new RecordNotFoundException();
			}
			paymentDao.delete(no);
		} catch (SQLException e) {
			throw new PaymentException(e.getMessage());
		}

		return true;
	}

	@Override
	public int count() throws PaymentException {
		int count = 0;
		try {
			count = paymentDao.count();
		} catch (SQLException e) {
			throw new PaymentException(e.getMessage());
		}
		return count;
	}

}
