package com.model;

import java.util.List;

public class AssignmentVO {
	private int assignmentId;
	private String assignmentTitle;
	private String assignmentType;



    private List<QuestionVO> questions;


	public int getAssignmentId() {
		return assignmentId;
	}
	public void setAssignmentId(int assignmentId) {
		this.assignmentId = assignmentId;
	}
	public String getAssignmentTitle() {
		return assignmentTitle;
	}
	public void setAssignmentTitle(String assignmentTitle) {
		this.assignmentTitle = assignmentTitle;
	}
	public String getAssignmentType() {
		return assignmentType;
	}
	public void setAssignmentType(String assignmentType) {
		this.assignmentType = assignmentType;
	}
    public List<QuestionVO> getQuestions() {
        return questions;
    }

    public void setQuestions(List<QuestionVO> questions) {
        this.questions = questions;
    }

	public String toString() {
		return "AssignmentVO [assignmentId=" + assignmentId + ", assignmentTitle=" + assignmentTitle + ", assignmentType=" + assignmentType + "]";
	}
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + assignmentId;
		result = prime * result + ((assignmentTitle == null) ? 0 : assignmentTitle.hashCode());
		result = prime * result + ((assignmentType == null) ? 0 : assignmentType.hashCode());
		return result;
	}
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		AssignmentVO other = (AssignmentVO) obj;
		if (assignmentId != other.assignmentId)
			return false;
		if (assignmentTitle == null) {
			if (other.assignmentTitle != null)
				return false;
		} else if (!assignmentTitle.equals(other.assignmentTitle))
			return false;
		if (assignmentType == null) {
			if (other.assignmentType != null)
				return false;
		} else if (!assignmentType.equals(other.assignmentType))
			return false;
		return true;
	}
}
