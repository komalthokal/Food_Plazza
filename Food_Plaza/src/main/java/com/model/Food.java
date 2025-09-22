package com.model;

public class Food {

	private int f_id;
	private String f_name;
	private String f_type;
	private String f_category;
	private float f_price ;
	public Food() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Food( String f_name, String f_type, String f_category, float f_price) {
		super();
		
		this.f_name = f_name;
		this.f_type = f_type;
		this.f_category = f_category;
		this.f_price = f_price;
	}
	public int getF_id() {
		return f_id;
	}
	public void setF_id(int f_id) {
		this.f_id = f_id;
	}
	public String getF_name() {
		return f_name;
	}
	public void setF_name(String f_name) {
		this.f_name = f_name;
	}
	public String getF_type() {
		return f_type;
	}
	public void setF_type(String f_type) {
		this.f_type = f_type;
	}
	public String getF_category() {
		return f_category;
	}
	public void setF_category(String f_category) {
		this.f_category = f_category;
	}
	public float getF_price() {
		return f_price;
	}
	public void setF_price(float f_price) {
		this.f_price = f_price;
	}
	@Override
	public String toString() {
		return "Food [f_id=" + f_id + ", f_name=" + f_name + ", f_type=" + f_type + ", f_category=" + f_category
				+ ", f_price=" + f_price + "]";
	}
	
}
