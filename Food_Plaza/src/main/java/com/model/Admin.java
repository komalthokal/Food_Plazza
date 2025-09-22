package com.model;

public class Admin {
private String a_email;
private	String a_pass;
	public Admin() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Admin(String email, String pass) {
		super();
		this.a_email = email;
		this.a_pass = pass;
	}
	public String getA_email() {
		return a_email;
	}
	public void setA_email(String a_email) {
		this.a_email = a_email;
	}
	public String getA_pass() {
		return a_pass;
	}
	public void setA_pass(String a_pass) {
		this.a_pass = a_pass;
	}
	
	
	

}
