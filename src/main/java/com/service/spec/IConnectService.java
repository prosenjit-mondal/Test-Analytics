package com.service.spec;

import java.util.List;

import com.model.BookVO;

public interface IConnectService {
	public List<BookVO> getAllBooks();
	public void populateContentWithAssignment(BookVO book) ;
}
