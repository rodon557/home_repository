package com.lemon.phoenix;

import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Properties;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.lemon.phoenix.assertion.Assertion;
import com.lemon.phoenix.util.ExcelUtil;
import com.lemon.phoenix.util.JDBCUtil;
import com.lemon.phoenix.util.PropertiesUtil;

public class RegisterPage extends Base{
	@Test(dataProvider="failDatas")
   public void testfaildatas(String mobilephone,String password,String confPwd,String expected){	 
	 to(PropertiesUtil.urlProperties.getProperty("register.url"));
	// driver.get("http://39.108.136.60:8380/lmcanon_web_auto/mng/register.html");	 
	 sendkeys(getElement("注册页面用户名输入框"),mobilephone);	
	 sendkeys(getElement("注册页面密码输入框"),password);	 
	 sendkeys(getElement("注册页面重复密码输入框"),confPwd);	
	 click(getElement("注册页面登录按钮"));
	 //getElement("注册页面重置按钮").click();
	 //断言来判断实际错误提示信息是否与期望值保持一致
     Assertion.assertTextPresentPrecision(getElement("错误提示信息"), expected);
   }
	@Test
	public void testSuccessdatas() throws InterruptedException, ClassNotFoundException, SQLException{	 
		Object[][]datas=ExcelUtil.read("/register.xlsx",1,8,8,1,3);
		to(PropertiesUtil.urlProperties.getProperty("register.url"));
		String mobile =datas[0][0].toString();
		String password =datas[0][0].toString();
		String confPwd =datas[0][0].toString();
		sendkeys(getElement("注册页面用户名输入框"),mobile);	
		sendkeys(getElement("注册页面密码输入框"),password);	 
		sendkeys(getElement("注册页面重复密码输入框"),confPwd);	
		click(getElement("注册按钮"));
		Assertion.assertNotNull(getElementByCertainPage("登录按钮",LoginPage.class.getName()));
		String sql ="select * from member where mobilephone=?";
		Object [] values={mobile};
		String url=JDBCUtil.properties.getProperty("url");
		String dbUser=JDBCUtil.properties.getProperty("user");
		String dbPassword=JDBCUtil.properties.getProperty("password");
		ResultSet resultSet=JDBCUtil.query(url, dbUser, dbPassword, sql, values);
		//断言取出的用户不为空，则表示表里存在这条用户数据
		String mobileFromDB=null;
		try {
			if(resultSet.next()){
			mobileFromDB=resultSet.getString("mobilephone");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Assert.assertEquals(mobileFromDB, mobile);
	}
   
@DataProvider
   public Object[][] failDatas(){
	   Object[][]datas=ExcelUtil.read("/register.xlsx",1,2,7,1,4);
		
	   return datas;
   }
}
