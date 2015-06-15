package com.model;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by 146871 on 8/28/2014.
 */
public class BookVO {
    private String isbn;
    private String title;
    private List<AssignmentVO> assignments = new ArrayList<AssignmentVO>();
    private List<QuestionVO> questions = new ArrayList<QuestionVO>();

    public List<QuestionVO> getQuestions() {
        return questions;
    }

    public void setQuestions(List<QuestionVO> questions) {
        this.questions.addAll(questions);
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }



    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

	public List<AssignmentVO> getAssignments() {
		return assignments;
	}

	public void setAssignments(List<AssignmentVO> assignments) {
		this.assignments.addAll(assignments);
	}

	public void addAssignment(AssignmentVO assignment) {
		this.assignments.add(assignment);
	}
	
	public String toString() {
		return  "Isbn = "+isbn+ " title = "+title;
		
	}

}
