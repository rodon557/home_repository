package com.lemon.app.util;

public class StringUtils {
	public static boolean isEmpty(String content){
		boolean isEmpty=(content==null||content!=null&&content.trim().length()==0);
		return isEmpty;
	}

}
