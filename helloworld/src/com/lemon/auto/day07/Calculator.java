package com.lemon.auto.day07;

public class Calculator {
	public int jiafa(int a,int b){
		return a+b;
	}
	public int jianfa(int a,int b){
		return a-b;
	}
	public int chenfa(int a,int b){
		return a*b;
	}
	public int chufa(int a,int b){
		return a/b;
	}
//	public  Calculator(){
//		
//	}
	public static void main(String arg[]){
		Calculator calculator =new Calculator();
		System.out.println("3+5 等于"+calculator.jiafa(3,5));
		System.out.println("3-5 等于"+calculator.jianfa(3,5));
		System.out.println("3*5 等于"+calculator.chenfa(3,5));
		System.out.println("3/5 等于"+calculator.chufa(3,5));
		}
}
