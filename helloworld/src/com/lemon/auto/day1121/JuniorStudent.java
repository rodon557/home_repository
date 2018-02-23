package com.lemon.auto.day1121;

public class JuniorStudent extends Student{
	private String type;
	private int number;
	
	public JuniorStudent(String type, int number) {
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
		System.out.println("坐公交车去学校");
	}

	@Override
	void goHome() {
		System.out.println("坐公交车回家");
	}

}

