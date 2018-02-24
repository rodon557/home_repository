package com.lemon.phoenix.interfaces;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;

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

import com.alibaba.fastjson.JSONObject;
import com.lemon.phoenix.config.RestConfig;
import com.lemon.phoenix.util.ExcelUtil;
import com.lemon.phoenix.util.HttpUtil;

public class RegisterInterface {
	@Test(dataProvider="datas")
   public void test1(String casId,String apiId,String requestData) throws ClientProtocolException, IOException{
	//String url ="http://119.23.241.154:8080/futureloan/mvc/api/member/register";
	RestConfig.getRestUrlByApiId(apiId);
	Map<String,String>map=(Map<String,String>)JSONObject.parse(requestData);
   List<NameValuePair>params=new ArrayList<NameValuePair>();
   Set<String> keys=map.keySet();
   for (String key : keys) {
	   params.add(new BasicNameValuePair(key,map.get(key)));
  }
   String jsonStr=HttpUtil.getResultStringByPost(url, params);
   System.out.println(jsonStr);
   }
public Object[][] datas(){
	return ExcelUtil.read("/rest_info.xlsx", 1,2, 7, 1,3);
	
}
}
