package com.lemon.auto.day1121;

public class Car {
	private int price;//类（对象）的成员变量
	private String brand;
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public String getBrand() {
		return brand;
	}
	public void setBrand(String brand) {
		this.brand = brand;
	}
	public Car(int price, String brand) {
		super();
		this.price = price;
		this.brand = brand;
	}
	public Car() {
		
	}

}
