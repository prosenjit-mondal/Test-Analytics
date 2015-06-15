package com.dao;

import java.sql.ResultSet;
//import com.common.Logger;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import com.dao.spec.IConnectRelationalDataReader;
import com.model.AssignmentVO;
import com.model.BookVO;
import com.model.QuestionVO;

@Repository(value="crd")
public class ConnectRelationalDataReader implements IConnectRelationalDataReader {

	//private static Logger logger = Logger.getInstance(ConnectRelationalDataReader.class);
	private org.slf4j.Logger logger = LoggerFactory.getLogger(Logger.class);
	@Autowired    
    private NamedParameterJdbcTemplate template;
	private static final String ISBN_QUERY = "SELECT DISTINCT ISBN FROM BOOK_INFO";

	private static final String ASSIGNMENT_QUESTION_QUERY = " SELECT DISTINCT co.isbn,ass.assignment_id,ass.title Assignment_Title,"
			+ "ass.assignment_type, ai.NATIVE_ALA_ID, ai.title, ai.weight FROM Assignment ass,"
			+ "section_assignment_xref sx, section s, Course co, activity act, activity_item ai "
			+ "WHERE co.course_id =s.course_id AND s.section_id  =sx.section_id AND ass.assignment_id  =sx.assignment_id "
			+ "AND co.isbn   = '##' AND ass.assignment_type IN('ASSESMENT') and sx.assignment_id = act.assignment_id "
			+ "and act.activity_id = ai.activity_id ";

    @Override
    public List<BookVO> getBooks() {
        final List<BookVO> myList = new ArrayList<BookVO>();
        try {
        	template.query(ISBN_QUERY, new RowMapper<BookVO>() {
        		@Override  
        	    public BookVO mapRow(ResultSet rs, int rownumber) throws SQLException {  
        			BookVO book = new BookVO();  
        			book.setIsbn(rs.getString(1));
        			book.setTitle(rs.getString(1));
        			myList.add(book);
        	        return book;  
        	    }  
        	});        	
        	
        } catch (DataAccessException e) {
        	logger.error ("some problem " + e.getMessage() + ISBN_QUERY);
            
        }
        return myList;
    }

    @Override
    public void populateAssignmentWithContent(BookVO book) {        
        final Map<AssignmentVO, List<QuestionVO>> mapDe = new HashMap<AssignmentVO, List<QuestionVO>>();                
        try {           
        	String query  = ASSIGNMENT_QUESTION_QUERY.replaceAll("##",book.getIsbn());
        	logger.debug("ASSIGNMENT_QUESTION_QUERY is:"+query);
        	template.query(query, new RowMapper<AssignmentVO>() {
            
            @Override  
        	public AssignmentVO mapRow(ResultSet rs, int rownumber) throws SQLException { 
            	
            	AssignmentVO assignmentVO = new AssignmentVO();
                QuestionVO questionVO = new QuestionVO();

                assignmentVO.setAssignmentId(rs.getInt("ASSIGNMENT_ID"));
                assignmentVO.setAssignmentTitle(rs.getString("Assignment_Title"));
                assignmentVO.setAssignmentType(rs.getString("ASSIGNMENT_TYPE"));
                questionVO.setActivityItemtitle(rs.getString("TITLE"));                
                questionVO.setNativeAlaID(rs.getString("NATIVE_AlA_ID"));                
                questionVO.setWeight(rs.getFloat("WEIGHT"));
              
                if (mapDe.containsKey(assignmentVO)) {
                    mapDe.get(assignmentVO).add(questionVO);
                }   else {                    
                	List<QuestionVO> list = new ArrayList<QuestionVO>();
                	list.add(questionVO);
                	mapDe.put(assignmentVO, list);
                }
                return assignmentVO;
              }            
            });
            
            for (AssignmentVO ast : mapDe.keySet()) {
            	ast.setQuestions(mapDe.get(ast));
            	book.addAssignment(ast);
            	}            
            logger.debug("value of Book is:"+book);
        } catch (DataAccessException e) {
        	logger.error("some problem " + e.getMessage() + ASSIGNMENT_QUESTION_QUERY);
           
        }
    }

	public void setTemplate(NamedParameterJdbcTemplate template) {
		this.template = template;
	}
}