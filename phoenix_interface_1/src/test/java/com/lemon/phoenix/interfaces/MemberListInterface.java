package com.lemon.phoenix.interfaces;

import java.io.IOException;

import org.apache.http.Header;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.testng.annotations.Test;

public class MemberListInterface {
	@Test
	public void list() throws ClientProtocolException, IOException{
		//定义接口地址
		String interfaceUrl ="http://119.23.241.154:8080/futureloan/mvc/api/member/list";
		//决定接口提交方式
		HttpGet httpget=new HttpGet(interfaceUrl);
		//直接提交接口请求
		CloseableHttpClient httpClient=HttpClients.createDefault();
		//获取响应数据
		CloseableHttpResponse response=httpClient.execute(httpget);
		String jsonString=EntityUtils.toString(response.getEntity());
		System.out.print(jsonString);
		Header[] headers=response.getAllHeaders();
		for (Header header : headers) {
			System.out.println("name="+header.getName()+",value="+header.getValue());
		}
	}

}
