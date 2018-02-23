
package com.lemon.auto.day10_1107;
import java.util.Date;


public class ClassCall {
	public static void main(String[] args){
		Date date=new Date();
		int hour=date.getHours();
		int minutes=date.getMinutes();
		@SuppressWarnings("deprecation")
		int seconds=date.getSeconds();
		System.out.println("时钟:"+hour+",分钟："+minutes+",秒钟:"+seconds);
		String cc="aaa";
		System.out.println(cc.replace("aa", "bb"));
		System.out.println(cc.replaceAll("aa", "bb"));
		System.out.println(cc.substring(2));
		
		
	}

}
