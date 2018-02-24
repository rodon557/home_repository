package com.lemon.phoenix.config;

import java.util.List;

import com.lemon.phoenix.pojo.Rest;
import com.lemon.phoenix.util.ExcelUtil;

public class RestConfig {
	
	public static List<Rest> rList;
	
	static{
		Object [][] datas=ExcelUtil.read("/rest_info.xlsx", 0, 2, 14, 1, 4);
		for (Object[] rowDatas : datas) {
			Rest rest=new Rest();
			for (int i = 0; i < rowDatas.length; i++) {
				if(i==0){
					rest.
				}else if(i==2){
					
				}else if(i==3){
				
			}
			}
		}
	}

	/**根据api编号获取对应接口的url地址
	 * @param apiId :接口编号
	 */
	public static void getRestUrlByApiId(String apiId) {
		// TODO Auto-generated method stub
		
	}

}
