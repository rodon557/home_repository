package com.lemon.auto.day1121;

public class PrimaryStudent extends Student{
	private String type;
	private int number;
	
	public int getNumber(){
		return this.number;
	}
	
	public String getType(){
		return this.type;
	}
	
	public PrimaryStudent(String type,int number){
		this.type = type;
		this.number = number;
	}

	@Override
	String type() {
		return getType();
	}

	@Override
	int classNumber() {
		return getNumber();
	}

	@Override
	void goToSchool() {
		System.out.println("爸妈送我去学校");
		
	}

	@Override
	void goHome() {
		System.out.println("爸妈接我回家");
	}

}
