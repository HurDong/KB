package spring02;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import spring02.dao.BookDao;
import spring02.dto.BookDto;

@Service
public class BookService {
	@Autowired
	BookDao dao;

	public BookService() {
	}

//	xml을 통한 설정시만 필요
//	BookService(BookDao dao) {// 생성자 주입
//		this.dao = dao;
//	}
//
//	public void setDao(BookDao dao) {// setter주입
//		this.dao = dao;
//	}

	public void add(BookDto dto) {
		dao.insert(dto);
	}

}