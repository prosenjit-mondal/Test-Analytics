package com.dao;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataRetrievalFailureException;
import org.springframework.data.neo4j.support.Neo4jTemplate;
import org.springframework.stereotype.Repository;

//import com.common.Logger;
import com.dao.spec.IGraphWriter;
import com.graphmodel.Assignment;
import com.graphmodel.AssignmentQuestion;
import com.graphmodel.Book;
import com.graphmodel.BookQuestion;
import com.graphmodel.Question;
import com.model.AssignmentVO;
import com.model.BookVO;
import com.model.QuestionVO;

@Repository(value="gw")
public class GraphWriter implements IGraphWriter {
    
	private org.slf4j.Logger logger = LoggerFactory.getLogger(Logger.class);
	@Autowired Neo4jTemplate neoTemplate;
	
	@Override
	public void saveAssignment(Assignment assignment) {
		// TODO Auto-generated method stub
		logger.debug("Saving assignment...");
		neoTemplate.save(assignment);
	}

	@Override
	public void saveBook(BookVO bookVO) {
		// TODO Auto-generated method stub
		try {
			Book book = new Book(bookVO.getIsbn(), bookVO.getTitle());			
			neoTemplate.save(book);
			logger.debug("Saved Book :"+book);
			Iterable<AssignmentVO> assignments = bookVO.getAssignments();
			for (AssignmentVO ast : assignments) {
				Assignment ast1 = new Assignment (ast.getAssignmentId(), ast.getAssignmentTitle(), ast.getAssignmentType());
				saveAssignment(ast1);
				Iterable<QuestionVO> questions = ast.getQuestions();				
				for (QuestionVO question : questions) {				
					Question retrievedQuestion = null;
					try {
					    retrievedQuestion = neoTemplate.findOne(Long.parseLong(question.getNativeAlaID())
							                     , Question.class);
					    logger.debug ("1 Node Question="+retrievedQuestion);
					}   catch (DataRetrievalFailureException nfe) {						
						retrievedQuestion = new Question (question.getNativeAlaID(), question.getActivityItemtitle(),
							                       question.getWeight());
						logger.debug("2 Node Question ######## ="+retrievedQuestion);
						saveQuestion(retrievedQuestion);
					}				
					neoTemplate.createRelationshipBetween(book,retrievedQuestion,
							BookQuestion.class, "HAS",false);
					neoTemplate.createRelationshipBetween(ast1,retrievedQuestion,
							AssignmentQuestion.class,"CONTAINS",false);
				}
				
				logger.debug("value of assignmentat "+ast1);
			}		
			logger.debug("Book which is saving using Neo4J tempalate " +book);
			neoTemplate.save(book);
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}
	
	@Override
	public void saveQuestion(Question question) {
		// TODO Auto-generated method stub
		logger.debug("Saved question..."+question);
		neoTemplate.save(question);
	}	
}
