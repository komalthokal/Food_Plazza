package com.model;

public class Orders {

	private int o_id;
	private String c_email;
	private float t_price;
	private String date;
	public Orders() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Orders(int o_id, String c_email, float t_price, String date) {
		super();
		this.o_id = o_id;
		this.c_email = c_email;
		this.t_price = t_price;
		this.date = date;
	}
	public int getO_id() {
		return o_id;
	}
	public void setO_id(int o_id) {
		this.o_id = o_id;
	}
	public String getC_email() {
		return c_email;
	}
	public void setC_email(String c_email) {
		this.c_email = c_email;
	}
	public float getT_price() {
		return t_price;
	}
	public void setT_price(float t_price) {
		this.t_price = t_price;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	@Override
	public String toString() {
		return "Orders [o_id=" + o_id + ", c_email=" + c_email + ", t_price=" + t_price + ", date=" + date + "]";
	}
	
	
}
