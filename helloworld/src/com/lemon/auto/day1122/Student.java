package com.lemon.auto.day1122;

public abstract class Student {
	abstract String type();
	abstract int classNumber();
	public void dairly(){
		System.out.println("==================");
		System.out.println("我是："+this.type());
		System.out.println("我的一天是这样的：");
		getUp();
		eatBreakfast();
		goToSchool();
		task();
		System.out.println("上完课后，准备回家");
		goHome();
		homework();
		sleep();
		System.out.println("==================");
	}
	
	public void getUp(){
		System.out.println("起床");
	}
	
	public void eatBreakfast(){
		System.out.println("吃早餐");
	}
	
	abstract void goToSchool();
	
	public void task(){
		System.out.println("我的学习任务是上课");
	}
	
	abstract void goHome();
	
	public void homework(){
		System.out.println("做作业");
	}
	
	public void sleep(){
		System.out.println("睡觉");
	}
	
}
