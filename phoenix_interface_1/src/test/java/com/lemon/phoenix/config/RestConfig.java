package com.lemon.phoenix.config;

import java.util.ArrayList;
import java.util.List;

import com.lemon.phoenix.pojo.Rest;
import com.lemon.phoenix.util.ExcelUtil;

public class RestConfig {
	
	public static List<Rest> rList;
	
	static{
		if(rList==null){
			rList=new ArrayList<Rest>();
		}
		Object [][] datas=ExcelUtil.read("/rest_info.xlsx", 0, 2, 14, 1, 4);
		for (Object[] rowDatas : datas) {
			Rest rest=new Rest();
			for (int i = 0; i < rowDatas.length; i++) {
				String attributeValue=rowDatas[i].toString();
				if(i==0){
					rest.setApiId(attributeValue);
				}else if(i==1){
					rest.setApiName(attributeValue);
				}else if(i==2){
				    rest.setType(attributeValue);
			    }else if(i==3){
				    rest.setUrl(attributeValue);
			    }
			}
			rList.add(rest);
		}
	}

	/**根据api编号获取对应接口的url地址
	 * @param apiId :接口编号
	 */
	public static String getRestUrlByApiId(String apiId) {
		for (Rest rest : rList) {
			if(apiId.equals(rest.getApiId())){
				return rest.getUrl();
			}				
		}
		return "";
		
	}
	
    public static void main(String[] args) {
		for(Rest rest:RestConfig.rList){
			System.out.println(rest);
		}
	}

}
