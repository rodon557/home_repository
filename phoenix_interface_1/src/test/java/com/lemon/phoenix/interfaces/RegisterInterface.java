package com.lemon.phoenix.interfaces;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;

import org.apache.http.NameValuePair;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;
import org.testng.annotations.Test;

import com.lemon.phoenix.util.HttpUtil;

public class RegisterInterface {
	@Test
   public void test1() throws ClientProtocolException, IOException{
	String url ="http://119.23.241.154:8080/futureloan/mvc/api/member/register";
   List<NameValuePair>params=new ArrayList<NameValuePair>();
   params.add(new BasicNameValuePair("mobilephone","13517315120"));
   params.add(new BasicNameValuePair("password","e10adc3949ba59abbe56e057f20f883e"));
   String jsonStr=HttpUtil.getResultStringByPost(url, params);
   System.out.println(jsonStr);
   }
}
