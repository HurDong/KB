package spring02.dao;

import org.springframework.stereotype.Repository;

import spring02.dto.BookDto;

@Repository
public class BookDao {

	public void insert(BookDto dto) {
		System.out.println("BookDao.insert !!");
	}

}