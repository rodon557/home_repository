package com.lemon.auto.day10_1107;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map.Entry;
import java.util.Set;

public class HashMapDemo {
	public static void main(String[]args){
		HashMap<String,String>map=new HashMap<String,String>();
		System.out.println(map.size());
		map.put("name", "张三");
		map.put("age", "12");
		map.put("name", "李四");
		map.put("age", "15");
		System.out.println(map.size());
		System.out.println(map.get("name"));//键不可以重复 后面的会替代前面的
		System.out.println("==============输出所有键================");
		Set<String> keys=map.keySet();
		for(String key:keys){
			System.out.println(key);
		}
		System.out.println("==============输出所有value值================");
		Collection<String> collection=map.values();
		for(String value:collection){
			System.out.println(value);
		}
		System.out.println("==============输出所有键值对方法一================");
		Set<String> keys1=map.keySet();
		for(String key:keys1){
			String value=map.get(key);
			System.out.println("key="+key+",value="+value);
		}
		System.out.println("==============输出所有键值对方法二===============");
		Set<Entry<String,String>> entrySet=map.entrySet();
		for(Entry<String,String>entry:entrySet){
			System.out.println(entry.getKey()+",value="+entry.getValue());
		}
	}

}
