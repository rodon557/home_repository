package com.lemon.phoenix.util;

import java.io.File;
import java.io.IOException;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.firefox.FirefoxDriver;

import com.lemon.phoenix.Base;


public class ScreenUtil {
   public static File takeScreenShot(String dir){
	   Date date=new Date();
	   long time =date.getTime();
	   if(Base.driver instanceof FirefoxDriver){
		   FirefoxDriver firefoxDriver=(FirefoxDriver) Base.driver;
		   File from =firefoxDriver.getScreenshotAs(OutputType.FILE);
		   File to =new File(dir+File.separator+time+".jpg");
		   try {
			FileUtils.copyFile(from, to);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		   return to;
	   }
	   return null;
   }
}
