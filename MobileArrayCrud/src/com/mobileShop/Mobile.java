package com.mobileShop;

public class Mobile {
	private String model;
	private float price;
	private String brandName;
	public Mobile() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Mobile(String model, float price, String brandName) {
		super();
		this.model = model;
		this.price = price;
		this.brandName = brandName;
	}
	public String getModel() {
		return model;
	}
	public void setModel(String model) {
		this.model = model;
	}
	public float getPrice() {
		return price;
	}
	public void setPrice(float price) {
		this.price = price;
	}
	public String getBrandName() {
		return brandName;
	}
	public void setBrandName(String brandName) {
		this.brandName = brandName;
	}
	@Override
	public String toString() {
		return "Mobile [model=" + model + ", price=" + price + ", brandName=" + brandName + "]";
	}
	
	
}
