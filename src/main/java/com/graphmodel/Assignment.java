package com.graphmodel;

import java.util.HashSet;
import java.util.Set;

import org.neo4j.graphdb.Direction;
import org.springframework.data.annotation.TypeAlias;
import org.springframework.data.neo4j.annotation.GraphId;
import org.springframework.data.neo4j.annotation.Indexed;
import org.springframework.data.neo4j.annotation.NodeEntity;
import org.springframework.data.neo4j.annotation.RelatedTo;

@NodeEntity
@TypeAlias("Assignment")
public class Assignment {
	@GraphId
	Long nodeId;
	@Indexed (unique=true, indexName="assignment")
	int assignmentId;
	String assignmentTitle;
	String assignmentType;
	@RelatedTo(type = "CONTAINS", direction = Direction.OUTGOING, elementClass = Assignment.class)
	private Set<AssignmentQuestion> questions = new HashSet<AssignmentQuestion>();
	public Assignment(){};
	public Assignment(int assignmentId,String assignmentTitle,
					  String assignmentType){
		this.assignmentId=assignmentId;
		this.assignmentTitle=assignmentTitle;
		this.assignmentType=assignmentType;
	}
	
	public void addContentToAssignment(Question question) {
		questions.add(new AssignmentQuestion(question,this,"CONTAINS"));
	}

	public boolean isContain(Question question) {
		return questions.contains(question);
	}

}
