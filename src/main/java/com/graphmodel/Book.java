package com.graphmodel;

import java.util.HashSet;
import java.util.Set;

import org.neo4j.graphdb.Direction;
import org.springframework.data.annotation.TypeAlias;
import org.springframework.data.neo4j.annotation.GraphId;
import org.springframework.data.neo4j.annotation.Indexed;
import org.springframework.data.neo4j.annotation.NodeEntity;
import org.springframework.data.neo4j.annotation.RelatedTo;

/**
 * Created by 146871 on 8/28/2014.
 */
@NodeEntity
@TypeAlias("Book")
public class Book {
    @GraphId Long id;
	@Indexed(unique=true)
	private String Isbn;
	private String Title;
	@RelatedTo(type = "HAS", direction = Direction.OUTGOING, elementClass = Book.class)
	private Set<BookQuestion> questions = new HashSet<BookQuestion>();
    
	public Book() {};
	public Book(String Isbn, String Title) {
		this.Isbn = Isbn;
		this.Title = Title;
	}

	// private void contains(Question question) { questions.add(question); }

	public String getIsbn() {
		return Isbn;
	}

	public String getTitle() {
		return Title;
	}

	public void addContentToBook(Question question) {
		questions.add(new BookQuestion(question,this,"HAS"));
	}

	public boolean isContain(Question question) {
		return questions.contains(question);
	}

}