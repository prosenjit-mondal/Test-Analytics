package com.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.dao.spec.IGraphWriter;
import com.model.BookVO;
import com.service.spec.IGraphService;

@Service(value="gs")
public class GraphService implements IGraphService {

	@Autowired
	public IGraphWriter gw;
		
	public void migrateBook(BookVO book) {
		gw.saveBook(book);
	}

}
