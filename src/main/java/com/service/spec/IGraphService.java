package com.service.spec;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import com.dao.spec.IGraphWriter;
import com.model.BookVO;

public interface IGraphService {	
	@Transactional
	public void migrateBook(BookVO book);
}
