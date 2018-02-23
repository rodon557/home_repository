package com.lemon.phoenix.util;

import java.io.IOException;
import java.util.Properties;

public class PropertiesUtil {
  public static Properties urlProperties;
  static{
	  if(urlProperties==null){
		  loadUrlProperties();
	  }  
  }
private static void loadUrlProperties() {
	// TODO Auto-generated method stub
	urlProperties=new Properties();
	try {
		urlProperties.load(PropertiesUtil.class.getResourceAsStream("/url.properties"));
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
}
}
