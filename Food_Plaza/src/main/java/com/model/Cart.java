package com.model;

public class Cart {

	private int c_id;
	private int f_id;
	private String c_email;
	private String f_name;
	private float f_price;
	private int f_quantity;
	private float t_price;
	
	public Cart() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	
	public Cart(int f_id, String c_email, String f_name, float f_price, int f_quantity, float t_price
			) {
		super();
		this.f_id = f_id;
		this.c_email = c_email;
		this.f_name = f_name;
		this.f_price = f_price;
		this.f_quantity = f_quantity;
		this.t_price = t_price;
		
	}



	public int getC_id() {
		return c_id;
	}
	public void setC_id(int c_id) {
		this.c_id = c_id;
	}
	public int getF_id() {
		return f_id;
	}
	public void setF_id(int f_id) {
		this.f_id = f_id;
	}
	public String getC_email() {
		return c_email;
	}
	public void setC_email(String c_email) {
		this.c_email = c_email;
	}
	public String getF_name() {
		return f_name;
	}
	public void setF_name(String f_name) {
		this.f_name = f_name;
	}
	public float getF_price() {
		return f_price;
	}
	public void setF_price(float f_price) {
		this.f_price = f_price;
	}
	public int getF_quantity() {
		return f_quantity;
	}
	public void setF_quantity(int f_quantity) {
		this.f_quantity = f_quantity;
	}
	public float getT_price() {
		return t_price;
	}
	public void setT_price(float t_price) {
		this.t_price = t_price;
	}



	@Override
	public String toString() {
		return "Cart [c_id=" + c_id + ", f_id=" + f_id + ", c_email=" + c_email + ", f_name=" + f_name + ", f_price="
				+ f_price + ", f_quantity=" + f_quantity + ", t_price=" + t_price + "]";
	}
	
	
	
	
	
	
	
	
}
