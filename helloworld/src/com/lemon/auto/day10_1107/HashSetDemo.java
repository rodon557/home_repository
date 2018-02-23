package com.lemon.auto.day10_1107;

import java.util.HashSet;
import java.util.Iterator;

public class HashSetDemo {
	public static void main(String[]args){
		HashSet<String> set=new HashSet<String>();
		set.add("张三");
		set.add("李四");
		set.add("王五");
		System.out.println(set.contains("李四"));
//		set.toArray();
//		System.out.println(set.toArray()[1]);
//		String aa[]=set.toArray();//这样写会报错 因为toArray()不是String类下的方法 而是Object类下的
		Object aa[]=set.toArray();
		System.out.println(aa[1]);
		System.out.println("===========toArray第二种用法===============");
		String bb[]=new String[set.size()];
		set.toArray(bb);
		System.out.println(bb[1]);
		set.remove("王五");
		System.out.println("===========增强型for循环输出集合类元素===============");
		for(String a:set){
			System.out.println(a);
		}
		System.out.println("===========迭代输出集合类元素===============");
		Iterator<String> iterator=set.iterator();//Iterator是java.util下的类
		while(iterator.hasNext()){//判断是否有元素
			String cc=iterator.next();
			System.out.println(cc);
			
		}
		
		
		
	}

}
