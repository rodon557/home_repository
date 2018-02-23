package com.lemon.auto.day1121;

public class ExceptionDemo {
   public static void main(String[] args) throws ClassNotFoundException, InstantiationException, IllegalAccessException {
	@SuppressWarnings("unchecked")
	Class<Car> clazz=(Class<Car>) ClassLoader.getSystemClassLoader().loadClass("com.lemon.auto.day1121.Car");
	clazz.newInstance();
	System.out.println("no problem");
}
   
   
   
   
   
   
}
