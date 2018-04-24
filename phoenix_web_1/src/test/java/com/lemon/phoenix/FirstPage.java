package com.lemon.phoenix;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

import com.lemon.phoenix.assertion.Assertion;

public class FirstPage extends Base {
	@Test
	public void Test1() throws InterruptedException{
		to("https://www.baidu.com/");
		Thread.sleep(2000);
		click(getElement("新闻"));
	//	Thread.sleep(2000);
		Assertion.assertElementisSelect(getElement("新闻全文"));
		Assertion.assertElementisNotSelect(getElement("新闻标题"));
		click(getElement("新闻标题"));
		//Thread.sleep(2000);
		Assertion.assertElementisSelect(getElement("新闻标题"));
		back();
	//	Thread.sleep(2000);
		click(getElement("贴吧"));
		back();
	//	Thread.sleep(2000);
		click(getElement("hao123"));
		back();
		WebElement settings =getElement("设置") ;  
        
        Actions action = new Actions(driver);  
        action.moveToElement(settings).perform();  
          
        click(getElement("高级搜索"));;
		
	}

}
