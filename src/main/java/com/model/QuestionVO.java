package com.model;

public class QuestionVO {
	private String nativeAlaID =null ;
	private String activityItemtitle =null ;
	private float weight;
	
	/**
	 * @return the nativeAlaID
	 */
	public String getNativeAlaID() {
		return nativeAlaID;
	}
	/**
	 * @param nativeAlaID the nativeAlaID to set
	 */
	public void setNativeAlaID(String nativeAlaID) {
		this.nativeAlaID = nativeAlaID;
	}
	/**
	 * @return the activityItemtitle
	 */
	public String getActivityItemtitle() {
		return activityItemtitle;
	}
	/**
	 * @param activityItemtitle the activityItemtitle to set
	 */
	public void setActivityItemtitle(String activityItemtitle) {
		this.activityItemtitle = activityItemtitle;
	}
	/**
	 * @return the weight
	 */
	public float getWeight() {
		return weight;
	}
	/**
	 * @param weight the weight to set
	 */
	public void setWeight(float weight) {
		this.weight = weight;
	}
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "QuestionVO [activityItemtitle=" + activityItemtitle + ", nativeAlaID=" + nativeAlaID + ", weight=" + weight + "]";
	}
	
	
}
