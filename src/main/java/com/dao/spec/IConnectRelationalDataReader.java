package com.dao.spec;

import java.util.List;

import javax.sql.DataSource;

import com.model.BookVO;

public interface IConnectRelationalDataReader {
    public DataSource dataSource = null;
    public List<BookVO> getBooks();
	public void populateAssignmentWithContent(BookVO book);
}
