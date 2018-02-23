package com.lemon.phoenix.mail;
import java.util.Properties;

import javax.mail.Authenticator;
import javax.mail.PasswordAuthentication;

//smtp 身份验证类
public class Auth extends Authenticator
{
	Properties pwdProperties;
	public Auth(String userName,String passWord)
	{
		pwdProperties=new Properties();
		try {
			pwdProperties.put(userName,passWord);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	//实现 PasswordAuthentication 方法
	public PasswordAuthentication passwordAuthentication()
	{
		String userName=getDefaultUserName();
		//当前用户存在
		if (pwdProperties.containsKey(userName)) {
			//取出密码
			return new PasswordAuthentication(userName, pwdProperties.getProperty(userName).toString());
		}
		else {
			//不在返回Null
			System.out.println("当前用户不存在");
			return null;
		}
	}
}

