package com.model;

public class Customer {

	public static Object get;
	private	String c_name;
	private String c_email;
	private String c_pass;
	private long c_contact;
	private String c_address;
	public Customer() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Customer(String c_name, String c_email, String c_pass, long c_contact, String c_address) {
		super();
		this.c_name = c_name;
		this.c_email = c_email;
		this.c_pass = c_pass;
		this.c_contact = c_contact;
		this.c_address = c_address;
	}
	public Customer(String c_email, String c_pass) {

this.c_email=c_email;
this.c_pass=c_pass;
	}
	public  String getC_name() {
		return c_name;
	}
	public void setC_name(String c_name) {
		this.c_name = c_name;
	}
	public String getC_email() {
		return c_email;
	}
	public void setC_email(String c_email) {
		this.c_email = c_email;
	}
	public String getC_pass() {
		return c_pass;
	}
	public void setC_pass(String c_pass) {
		this.c_pass = c_pass;
	}
	public long getC_contact() {
		return c_contact;
	}
	public void setC_contact(long c_contact) {
		this.c_contact = c_contact;
	}
	public String getC_address() {
		return c_address;
	}
	public void setC_address(String c_address) {
		this.c_address = c_address;
	}
	@Override
	public String toString() {
		return "Customer [c_name=" + c_name + ", c_email=" + c_email + ", c_pass=" + c_pass + ", c_contact=" + c_contact
				+ ", c_address=" + c_address + "]";
	}
	
	
	
}
