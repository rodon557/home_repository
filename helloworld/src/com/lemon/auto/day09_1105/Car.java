package com.lemon.auto.day09_1105;

public class Car {
	private int price;//类（对象）的成员变量
	private String brand;
	
	public Car(int price, String brand) {
		super();//父类的默认构造函数（通过快捷方式自动生成）
		this.price = price;
		this.brand = brand;
	}
	public Car(String brand,int price) {
		super();//父类的默认构造函数
		this.price = price;
		this.brand = brand;
	}

	public Car(int price) {
		super();
		this.price = price;
	}

	public Car(String brand) {
		super();
		this.brand = brand;
	}

	
	//函数的重载:函数名可以相同，但是，函数的
	//参数必须不一样(1,参数的个数不一样；2，参数的类型不一样;3，如果参数个数一样,类型也一样，但是顺序不一样)
	public int getPrice(String name) {
		return price;
	}
	
	public int getPrice(int aa) {
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

	public Car(){
		
	}

	public String[] getProperties(){
		String [] arr = new String [2];
		arr[0] = this.brand;
		arr[1] = this.price+"";
		return arr;
	} 
	
	
	public static void main(String[] args) {
		Car car1 = new Car();
		car1.setBrand("大众");//初始化：对对象的属性进行了赋值
		car1.setPrice(300000);
		String brand1 = car1.getBrand();
//		int price1 = car1.getPrice();
		System.out.println(car1);
		Car car2 = new Car(350000,"Jeep");
		System.out.println(car2);//"汽车二：car2的品牌是："+car2.getBrand()+"，价格是："+car2.getPrice()
		int a = 4;
		int b = 4;
		System.out.println(a==b);
		Car car3 = new Car();
		Car car4 = new Car(300000,"Jeep");
		Car car5 = new Car(300000,"Jeep");
		System.out.println(car4 == car5);//输出结果为false 因为car4与car5指向地址不一样
		System.out.println(car4.toString());//输出结果为car4对象地址 默认调用父类Object的toString方法
		System.out.println(car4);//输出结果为car4对象地址 默认调用父类Object的toString方法
	}
	
//	@Override//重写（覆盖了父类的方法）
//	public String toString() {
//		System.out.println("我被调用了");
//		return "汽车的品牌是："+this.brand+"，价格是："+this.price;
//	}
	

}
