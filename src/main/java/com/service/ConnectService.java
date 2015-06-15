package com.service;

import java.util.LinkedList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dao.spec.IConnectRelationalDataReader;
import com.model.BookVO;
import com.service.spec.IConnectService;

@Service(value="cs")
public class ConnectService implements IConnectService{

	@Autowired
	IConnectRelationalDataReader crd;
	
	@Override
	public List<BookVO> getAllBooks() {
		List<BookVO> books = new LinkedList<BookVO>();
		books = crd.getBooks();		
		
		return books;
	}

	public void setDataReader(IConnectRelationalDataReader dataReader) {
		this.crd = dataReader;
	}

	@Override
	public void populateContentWithAssignment(BookVO book) {
		crd.populateAssignmentWithContent(book);
	}
}
