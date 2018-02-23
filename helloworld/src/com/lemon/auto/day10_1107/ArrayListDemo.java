package com.lemon.auto.day10_1107;

import java.util.ArrayList;
import java.util.Iterator;

public class ArrayListDemo {
	public static void main(String[]args){
		ArrayList<String> list=new ArrayList<String>();
		list.add("张三");//增加元素
		list.add("344ddff");
		list.add("王五");
		System.out.println(list.size());//3
		System.out.println(list.get(1));//344ddff
		list.set(1,"李四");//修改元素
		System.out.println(list.get(1));//查询 结果：李四
		System.out.println("========for循环输出集合类元素==========");
		for(int i=0;i<list.size();i++){
			System.out.println(list.get(i));
		}
		System.out.println("========增强型for循环输出集合类元素==========");
		for(String a:list){
			System.out.println(a);
		}
		System.out.println("========利用迭代器输出集合类元素==========");
		Iterator<String> iterator=list.iterator();//Iterator是java.util下的类
		while(iterator.hasNext()){
			String bb=iterator.next();
			System.out.println(bb);
			
		}
	}

}
