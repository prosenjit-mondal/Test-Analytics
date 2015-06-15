package com.graphmodel;

import org.springframework.data.annotation.TypeAlias;
import org.springframework.data.neo4j.annotation.GraphId;
import org.springframework.data.neo4j.annotation.Indexed;
import org.springframework.data.neo4j.annotation.NodeEntity;

@NodeEntity
@TypeAlias("Question")
public class Question {
	public Question() {
		
	}
	@GraphId 
	Long nodeId;
	@Indexed (unique=true,indexName="question")
	String nativeAlaID;
	String activityItemTitle;
	float weight;	
	public Question(String nativeAlaID,String activityItemTitle,float weight){
		this.nativeAlaID=nativeAlaID;
		this.activityItemTitle=activityItemTitle;
		this.weight=weight;
	}
	
	
	
	public Long getNodeId() {
		return nodeId;
	}
	public void setNodeId(Long nodeId) {
		this.nodeId = nodeId;
	}
	public String getNativeAlaID() {
		return nativeAlaID;
	}
}
