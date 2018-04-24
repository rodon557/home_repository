package com.lemon.phoenix.util;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;

import com.alibaba.fastjson.JSONObject;
import com.lemon.phoenix.pojo.CheckResult;
import com.lemon.phoenix.pojo.DBChecker;


public class DBCheckerUtil {
	private static Logger logger=Logger.getLogger(DBCheckerUtil.class);
	public static String validateDBDataOneColumn(String sqlList ) throws ClassNotFoundException, SQLException  {
		logger.info("数据验证时需要执行的sql脚本信息：【"+sqlList+"】");
		//数据验证
		 List<DBChecker> checkers=JSONObject.parseArray(sqlList, DBChecker.class);
		 List<CheckResult> results =new ArrayList<CheckResult>();
		 if(checkers!=null){
			 for (DBChecker dbChecker : checkers) {
					String sql=dbChecker.getSql();
					ResultSet resultSet = JDBCUtil.query(sql);
					try {
						CheckResult checkResult =new CheckResult();
						checkResult.setNo(dbChecker.getNo());
						if(resultSet.next()){
							int dbResult=resultSet.getInt(1);
							String sdbResult=dbResult+"";
							String expectedQueryResult=dbChecker.getExpectedQueryResult();
							//String expectedQueryResult=dbChecker.getNo();
							logger.info("期望查询结果为：【"+expectedQueryResult+"】");
							logger.info("实际查询结果为：【"+sdbResult+"】");
							if(sdbResult.equals(expectedQueryResult)){
								checkResult.setResult("pass");
							}else{
								checkResult.setResult("not pass");
							}
					}else{
						checkResult.setResult("not pass");
					}
						results.add(checkResult);
					}catch (SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					
					}
			 String resultString=JSONObject.toJSONString(results);
			 return resultString;
			 
		 }else{
			 return null;
		 }
		 
		
		}
	}


