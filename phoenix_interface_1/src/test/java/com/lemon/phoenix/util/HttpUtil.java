package com.lemon.phoenix.util;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;

import org.apache.http.NameValuePair;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;
import org.apache.log4j.Logger;

public class HttpUtil {
	
	private static Logger logger=Logger.getLogger(HttpUtil.class);
	/**post请求通用处理函数
	 * @param uri 接口地址
	 * @param params 提交的参数
	 * @return  响应数据
	 */
	public static String getResultStringByPost(String uri,List<NameValuePair>params) {
		logger.info("请求的接口地址为:"+uri);
		logger.info("请求的参数为:"+getparamsString(params));
		if(StringUtils.isEmpty(uri)){
			return "";
		}
		//创建httppost对象
		 HttpPost httppost=new HttpPost(uri);
		 String resultString="";
		 try {
			//设置参数到httppost对象中
			httppost.setEntity(new UrlEncodedFormEntity(params));
			//准备httpClient对象
			 CloseableHttpClient httpClient=HttpClients.createDefault();
			//发送请求
			 CloseableHttpResponse response=httpClient.execute(httppost);
			 resultString=EntityUtils.toString(response.getEntity());
			//解析数据
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		 return resultString;
	}
	/**get请求通用处理函数
	 * @param uri  接口地址
	 * @param params 参数列表
	 * @return 响应数据
	 */
	public static String getResultStringByGet(String uri,List<NameValuePair>params) {
		if(StringUtils.isEmpty(uri)){
			return "";
		}
		if(params==null){
			return "";
		}
		for (int i = 0; i < params.size(); i++) {
			NameValuePair nameValuePair=params.get(i);
			if(i==0){
				uri+=("?"+nameValuePair.getName()+"="+nameValuePair.getValue());
			}else{
				uri+=("&"+nameValuePair.getName()+"="+nameValuePair.getValue());
			}
			
		}
		//创建httppost对象
		HttpGet httpget=new HttpGet(uri);
		String resultString="";
		try {
			//设置参数到httpget对象中
			//httpget.setEntity(new UrlEncodedFormEntity(params));
			//准备httpClient对象
			CloseableHttpClient httpClient=HttpClients.createDefault();
			//发送请求
			CloseableHttpResponse response=httpClient.execute(httpget);
			resultString=EntityUtils.toString(response.getEntity());
			//解析数据
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return resultString;
	}

	
	public static String getparamsString(List<NameValuePair>params){
		String paramsString="";
		if(params!=null){
			for (NameValuePair nameValuePair:params){
				paramsString+=("【"+nameValuePair.getName()+"】");
				paramsString+=":";
				paramsString+=("【"+nameValuePair.getValue()+"】");
			}
		}
		return paramsString;
	}
	
	
	
	public static void main(String[] args) {
		 String uri ="http://119.23.241.154:8080/futureloan/mvc/api/member/register";
		   //决定接口提交的方式
		   List<NameValuePair>params=new ArrayList<NameValuePair>();
		   params.add(new BasicNameValuePair("mobilephone","13517315120"));
		   params.add(new BasicNameValuePair("password","e10adc3949ba59abbe56e057f20f883e"));
		   for (int i = 0; i < params.size(); i++) {
				NameValuePair nameValuePair=params.get(i);
				if(i==0){
					uri+=("?"+nameValuePair.getName()+"="+nameValuePair.getValue());
				}else{
					uri+=("&"+nameValuePair.getName()+"="+nameValuePair.getValue());
				}
	}
		   System.out.println("uri="+uri);	   
 }
}