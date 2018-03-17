package com.lemon.phoenix.interfaces;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
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
import org.apache.log4j.Logger;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.alibaba.fastjson.JSONObject;
import com.lemon.phoenix.config.RestConfig;
import com.lemon.phoenix.pojo.DBChecker;
import com.lemon.phoenix.util.DBCheckerUtil;
import com.lemon.phoenix.util.ExcelUtil;
import com.lemon.phoenix.util.HttpUtil;

public class RegisterInterface extends  Base{
	private  Logger logger=Logger.getLogger(RegisterInterface.class);
	@Test(dataProvider="datas")
   public void test1(String caseId,String apiId,String requestData,String expected ,String sqlList) throws ClientProtocolException, IOException, ClassNotFoundException, SQLException{
	logger.info("*************当前执行测试用例：【caseId为"+caseId+"】*******************");
	String url =RestConfig.getRestUrlByApiId(apiId);
	Map<String,String>map=(Map<String,String>)JSONObject.parse(requestData);
   List<NameValuePair>params=new ArrayList<NameValuePair>();
   Set<String> keys=map.keySet();
   for (String key : keys) {
	   params.add(new BasicNameValuePair(key,map.get(key)));
  }
   String resultString=HttpUtil.getResultStringByPost(url, params);
  // ExcelUtil.write(1,caseId,6,resultString,"target/test-classes/rest_info.xlsx");
   Map<Integer,String> cellValueMap=new HashMap<Integer,String>();
   cellValueMap.put(6, resultString);
   //数据验证
   String dbCheckResultString=DBCheckerUtil.validateDBDataOneColumn(sqlList);
   if(dbCheckResultString!=null){
	   cellValueMap.put(7, dbCheckResultString);
   }
   ExcelUtil.caseResultMap.put(caseId,cellValueMap);
   logger.info("*************执行测试用例：【caseId为"+caseId+"】结束*******************");
   }
	@DataProvider
	public Object[][] datas(){
		return ExcelUtil.read("/rest_info.xlsx", 1,2, 7, 1,5);
	
	}
}
