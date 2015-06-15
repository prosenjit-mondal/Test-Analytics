package com.graphmodel;

import org.springframework.data.neo4j.annotation.EndNode;
import org.springframework.data.neo4j.annotation.GraphId;
import org.springframework.data.neo4j.annotation.RelationshipEntity;
import org.springframework.data.neo4j.annotation.StartNode;

@RelationshipEntity(type="CONTAINS")
public class AssignmentQuestion {
    @GraphId Long id; 
	@StartNode Assignment assignment;
    @EndNode Question question;
	String relation;
	public AssignmentQuestion() {}
	public AssignmentQuestion( 
			Question question2,Assignment assignment2, String role) {
		this.assignment = assignment2;
		this.question = question2;
		this.relation = role;
	}
	
}
