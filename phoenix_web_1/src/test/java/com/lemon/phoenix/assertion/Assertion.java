package com.lemon.phoenix.assertion;

import org.junit.Assert;
import org.openqa.selenium.WebElement;

import com.lemon.phoenix.Base;

public class Assertion {
    /**判断页面文本值是否与期望值一致
     * @param webElement
     * @param expected
     */
    public static void assertTextPresentPrecision(WebElement webElement,String expected){
    	String actual=Base.getText(webElement);
    	boolean flag=expected.equals(actual);
    	Assert.assertTrue(flag);
    }
    /**判断页面文本值是否包含期望值
     * @param webElement
     * @param expected
     */
    public static void assertTextPresent(WebElement webElement,String expected){
    	String actual=Base.getText(webElement);
    	boolean flag=expected.contains(actual);
    	Assert.assertTrue(flag);
    }
    /**断言一个页面可编辑
     * @param webElement
     * @param expected
     */
    public static void assertElementEditable(WebElement webElement){
    	boolean flag=webElement.isEnabled();
    	Assert.assertTrue(flag);
    }
    /**断言一个页面不可编辑
     * @param webElement
     * @param expected
     */
    public static void assertElementNotEditable(WebElement webElement){
    	boolean flag=webElement.isEnabled();
    	Assert.assertFalse(flag);
    }
    /**断言当前页面网址是否包含
     * @param expected
     */
    public static void assertUrlPresent(String expected){
    	String url =Base.driver.getCurrentUrl();
    	boolean flag=url!=null&&url.contains(expected);
    	Assert.assertFalse(flag);
    }
    public static void assertNotNull(WebElement webElement){
    	boolean flag=webElement.equals(null);
    	Assert.assertFalse(flag);
    }
}
