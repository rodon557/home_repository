package com.lemon.auto.day05;

public class Car {
	private int price;//0
	private String brand;//null
	
	
	public int getPrice() {
		return price;
	}

	public void setBrand(String brand) {
		this.brand = brand;
	}

	public void setPrice(int price){
		this.price = price;
	}
	
	/**获取汽车的价格
	 * @return
	 
	public int getPrice(){
		return this.price;
	}
	
	/**给汽车对象设置品牌
	 * @param brand
	 
	public void setBrand(String brand){
		this.brand = brand;
	}
	
	/**获取汽车对象的品牌
	 * @return
	 */
	public String getBrand(){
		return this.brand;
	}
	
	
	

	public Car(){//不带参构造函数，也叫作默认构造函数
		
	}
	
	public Car(String brand,int price){
		this.brand = brand;
		this.price = price;
	}
	
	
	public static void main(String[] args) {
		Car car1 = new Car();
		Car car2 = new Car("丰田",200000);
//		
//		String brand1 = car1.brand;
//		int price1 = car1.price; 
//		
//		String brand2 = car2.brand;
//		int price2 = car2.price;
		
		String brand1 = car1.getBrand();
		int price1 = car1.getPrice();
		
		String brand2 = car2.getBrand();
		int price2 = car2.getPrice();
		
		System.out.println("汽车1--car1的品牌是："+brand1+"，价格是："+price1);
		System.out.println("汽车2--car2的品牌是："+brand2+"，价格是："+price2);
		
		System.out.println("=================================");
		car1.setPrice(300000);
		car1.setBrand("jeep");
		
		brand1 = car1.getBrand();
		price1 = car1.getPrice();
		System.out.println("汽车1--car1的品牌是："+brand1+"，价格是："+price1);
		System.out.println("汽车2--car2的品牌是："+brand2+"，价格是："+price2);
		
	}
}


