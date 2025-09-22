package com.model;

public class Feedback {

	private String c_email;
	private String review;
	private String advice;
	private int ranks;
	public Feedback() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Feedback(String c_email, String review, String advice, int ranks) {
		super();
		this.c_email = c_email;
		this.review = review;
		this.advice = advice;
		this.ranks = ranks;
	}
	public String getC_email() {
		return c_email;
	}
	public void setC_email(String c_email) {
		this.c_email = c_email;
	}
	public String getReview() {
		return review;
	}
	public void setReview(String review) {
		this.review = review;
	}
	public String getAdvice() {
		return advice;
	}
	public void setAdvice(String advice) {
		this.advice = advice;
	}
	public int getRanks() {
		return ranks;
	}
	public void setRanks(int ranks) {
		this.ranks = ranks;
	}
	@Override
	public String toString() {
		return "Feedback [c_email=" + c_email + ", review=" + review + ", advice=" + advice + ", ranks=" + ranks + "]";
	}
	
	
}
