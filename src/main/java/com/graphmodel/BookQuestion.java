package com.graphmodel;

import org.springframework.data.neo4j.annotation.EndNode;
import org.springframework.data.neo4j.annotation.GraphId;
import org.springframework.data.neo4j.annotation.RelationshipEntity;
import org.springframework.data.neo4j.annotation.StartNode;

@RelationshipEntity(type="HAS")
public class BookQuestion {
    public BookQuestion(){}
	public BookQuestion(Question question,Book book, String role) {
		this.book = book;
		this.question = question;
		this.relation = role;
	}
    @GraphId Long id;
	@StartNode Book book;
    @EndNode Question question;
	String relation;
	
}
