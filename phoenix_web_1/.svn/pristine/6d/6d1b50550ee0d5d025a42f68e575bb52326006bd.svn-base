package com.lemon.phoenix.util;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;
import com.lemon.phoenix.po.pojo.Locator;

public class UILibraryUtil {
    public static Map<String,Map<String,Locator>> pageLocatorsMap =new HashMap<String,Map<String,Locator>>();
    static{
    	readUILibrary();
    }
	private static void readUILibrary() {
		//创建一个解析器
    	SAXReader reader=new SAXReader();
    	//从classpath路径底下去读取student.xml以文档document的形式返回
    	Document document;
		try {
			document = reader.read(UILibraryUtil.class.getResourceAsStream("/UILibrary.xml"));
			//获取文档里面定义的根元素
	    	Element root = document.getRootElement();
	    	//获取根元素底下的所有子元素
	    	List<Element> pageList =root.elements("page");
			//创建一个集合对象保存xml中的所有page
	    	for (Element pageElement : pageList) {
				String pageClass = pageElement.attributeValue("class"); 
				List<Element>locatorList=pageElement.elements("locator");
				HashMap<String,Locator>pagelocatormap=new HashMap<String,Locator>();
				for (Element locatorElement : locatorList) {
				   String by=locatorElement.attributeValue("by");
				   String value=locatorElement.attributeValue("value");
				   String desc=locatorElement.attributeValue("desc");
				   Locator locator=new Locator(by,value,desc);
				   pagelocatormap.put(desc, locator);
				}
				pageLocatorsMap.put(pageClass, pagelocatormap);
			}
			
		} catch (DocumentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	
	}
	public static void main(String[] args){
		UILibraryUtil.readUILibrary();
		pageLocatorsMap.keySet();
		Set<String> keys = pageLocatorsMap.keySet();
		for (String key : keys) {
			System.out.println("=======================");
			System.out.println("page页面"+key);
			Map<String,Locator>map =pageLocatorsMap.get(key);
			Set<String> descs = map.keySet();
			for (String desc : descs) {
				System.out.println("描述信息  "+desc);
				System.out.println("定位信息"+map.get(desc));
				
			}
		}
	}
}
