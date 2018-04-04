package com.lemon.app;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;

public class AppActions {
	/**向左滑动（按照默认滑动设置去滑动）
	 * @param androidDriver
	 * @param num
	 */
	public static void swipeLeft(AppiumDriver androidDriver,int num){
		int width = androidDriver.manage().window().getSize().getWidth();
		int height = androidDriver.manage().window().getSize().getHeight();
		int startx = width*7/8;
		int endx = width*2/8;
		int starty = height/2;
		int endy = height/2;
		for (int i = 0; i < num; i++) {
			TouchAction touchAction = new TouchAction(androidDriver);
			Duration dd = Duration.ofMillis(500);
//			touchAction.press(startx, starty).waitAction(dd).moveTo(endx, endy).release().perform();
		}
	}
	
	
	/**向右滑动（按照默认滑动设置去滑动）
	 * @param driver
	 * @param nums
	 */
	public static void swipeRight(AndroidDriver driver,int nums){
		int width = driver.manage().window().getSize().getWidth();
		int height = driver.manage().window().getSize().getHeight();
		int startx = width*2/8;
		int endx = width*7/8;
		int starty = height/2;
		int endy = height/2;
		for (int i = 0; i < nums; i++) {
			TouchAction touchAction = new TouchAction(driver);
			Duration dd = Duration.ofMillis(500);
//			touchAction.press(startx, starty).waitAction(dd).moveTo(endx, endy).release().perform();
		}
	}
	
	/**向下滑动（按照默认滑动设置去滑动）
	 * @param driver
	 * @param nums
	 */
	public static void swipeDown(AndroidDriver driver,int nums){
		int width = driver.manage().window().getSize().getWidth();
		int height = driver.manage().window().getSize().getHeight();
		int startx = width/2;
		int endx = width/2;
		int starty = height*2/8;
		int endy = height*7/8;
		for (int i = 0; i < nums; i++) {
			TouchAction touchAction = new TouchAction(driver);
			Duration dd = Duration.ofMillis(500);
//			touchAction.press(startx, starty).waitAction(dd).moveTo(endx, endy).release().perform();
		}
	}
	
	/**向上滑动（按照默认滑动设置去滑动）
	 * @param driver
	 * @param nums
	 */
	public static void swipeUp(AndroidDriver driver,int nums){
		int width = driver.manage().window().getSize().getWidth();
		int height = driver.manage().window().getSize().getHeight();
		int startx = width/2;
		int endx = width/2;
		int starty = height*7/8;
		int endy = height*2/8;
		for (int i = 0; i < nums; i++) {
			TouchAction touchAction = new TouchAction(driver);
			Duration dd = Duration.ofMillis(500);
//			touchAction.press(startx, starty).waitAction(dd).moveTo(endx, endy).release().perform();
		}
	}
	
	/**滑动（可定制化滑动）
	 * @param driver
	 * @param startx
	 * @param starty
	 * @param endx
	 * @param endy
	 * @param duration
	 */
	public static void swipe(AndroidDriver driver,int startx,int starty,int endx,int endy,long duration ){
		TouchAction touchAction = new TouchAction(driver);
		Duration dd = Duration.ofMillis(duration);
//		touchAction.press(startx, starty).waitAction(dd).moveTo(endx, endy).release().perform();
	}
	
	public static WebElement getElement(AndroidDriver driver,By by){
		WebDriverWait wait = new WebDriverWait(driver, 30);
		return wait.until(ExpectedConditions.presenceOfElementLocated(by));
	}
	public static List<WebElement> getElements(AndroidDriver driver,By by){
		WebDriverWait wait = new WebDriverWait(driver, 30);
		return wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(by));
	}
}


