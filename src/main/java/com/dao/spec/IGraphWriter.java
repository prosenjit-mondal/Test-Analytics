package com.dao.spec;

import com.graphmodel.Assignment;
import com.graphmodel.Question;
import com.model.AssignmentVO;
import com.model.BookVO;
import com.model.QuestionVO;

public interface IGraphWriter {
    public void saveBook(BookVO book);
    
    public void saveQuestion(Question question);
    
    public void saveAssignment(Assignment assignment);   
       
}
