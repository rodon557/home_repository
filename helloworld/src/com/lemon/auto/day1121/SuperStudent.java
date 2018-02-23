package com.lemon.auto.day1121;

public class SuperStudent extends Student{
	private String type;
	private int number;
	
	public SuperStudent(String type, int number) {
		super();
		this.type = type;
		this.number = number;
	}

	@Override
	String type() {
		return this.type;
	}

	@Override
	int classNumber() {
		return this.number;
	}

	@Override
	void goToSchool() {
		System.out.println("骑车去学校");
	}

	@Override
	void goHome() {
		System.out.println("骑车回家");
	}

}
