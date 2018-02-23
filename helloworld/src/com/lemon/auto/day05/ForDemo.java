package com.lemon.auto.day05;

public class ForDemo {
	public static void main(String args[]){
		int sum_odd=0;
		int sum_even=0;
		for(int i=1;i<=100;i=i+2){
			sum_odd=sum_odd+i;
		}
		System.out.println("0到100奇数的和是："+sum_odd);
		for(int i=2;i<=100;i=i+2){
			sum_even=sum_even+i;
		}
		System.out.println("0到100偶数的和是："+sum_even);
	}

}
