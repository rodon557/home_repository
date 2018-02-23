package com.lemon.phoenix;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Parameters;

import com.lemon.phoenix.po.pojo.Locator;
import com.lemon.phoenix.util.EmailUtil;
import com.lemon.phoenix.util.UILibraryUtil;

public class Base {
	private  static Log logger=LogFactory.getLog(Base.class);
	public  static WebDriver driver;
    @BeforeSuite
	@Parameters({"browserType","driverPath"})
	public void setUp(String browserType,String driverPath){
		//  WebDriver driver=null;
    	logger.info("*************************开始测试********************************");
    	logger.info("初始化浏览器驱动，浏览器类型是"+browserType+"，驱动路径是:"+driverPath+"");
		  if("firefox".equalsIgnoreCase(browserType)){
			  System.setProperty("webdriver.gecko.driver", driverPath);
			   driver=new FirefoxDriver();
			   logger.info("创建了firefox驱动");
		  }else if("ie".equalsIgnoreCase(browserType)){
			  System.setProperty("webdriver.gecko.driver", driverPath);
				DesiredCapabilities capabilities=new DesiredCapabilities();
				capabilities.setCapability(InternetExplorerDriver.INTRODUCE_FLAKINESS_BY_IGNORING_SECURITY_DOMAINS, true);//忽略安全模式
				capabilities.setCapability(InternetExplorerDriver.INITIAL_BROWSER_URL, "http://www.baidu.com");//指定一个初始化页面
				driver = new InternetExplorerDriver(capabilities); 
				logger.info("创建了IE驱动");
		  }else{
			   driver = new  ChromeDriver();
			   logger.info("创建了chrome驱动");
		  }
	}
    /**
     * 结束套件测试
     */
    @AfterSuite
    public void tearDown(){
    	logger.info("****************************完成套件测试*********************************");
    	driver.quit();
    	logger.info("********************************开始发送邮件***************************");
		File logFile = new File("target/surefire-reports/log/web.log");
		File testCase = new File("src/test/resources/register.xlsx");
		List<File> files = new ArrayList<File>();
		files.add(logFile);
		files.add(testCase);
		EmailUtil.sendmessage("13517315120@163.com", "nick1234", "smtp.163.com", "25", "m13517315120@163.com","546492510@qq.com", "测试报告", "http://localhost/html/index.html", files);
		//EmailUtil.sendmessage("546492510@qq.com", "gizqzkjebqkmbfai", "smtp.qq.com", "465", "546492510@qq.com","luodongxingkong@163.com", "测试报告", "http://localhost/html/index.html", files);
		logger.info("********************************发送邮件成功***************************");
    }
    /**查找元素调用显示等待
     * @param keyword
     * @return
     */
    public WebElement getElement(String keyword){
    	//根据关键字找到元素定位对象
    	final Locator locator=UILibraryUtil.pageLocatorsMap.get(this.getClass().getName()).get(keyword);
    	String tips="获取元素：{'by','"+locator.getBy()+"',{'value','"+locator.getValue()+"'}'";
    	WebDriverWait wait = new WebDriverWait(driver,30);
    	WebElement element=null;
    	try {
    		element=wait.until(new ExpectedCondition<WebElement>(){
    			public WebElement apply(WebDriver driver) {
    				String by=locator.getBy();
    				String value=locator.getValue();
    				By by2 =null;
    				if("id".equals(by)){
    					by2=By.id(value);
    				}else if("name".equals(by)){
    					by2=By.name(value);
    				}else if("className".equals(by)){
    					by2=By.className(value);
    				}else if("xpath".equals(by)){
    					by2=By.xpath(value);
    				}else if("cssSelector".equals(by)){
    					by2=By.cssSelector(value);
    				}else if("linkText".equals(by)){
    					by2=By.linkText(value);
    				}else if("partialLinkText".equals(by)){
    					by2=By.partialLinkText(value);
    				}else if("tagName".equals(by)){
    					by2=By.tagName(value);
    				}
    				if(by2==null){
    					throw new RuntimeException("找不到'"+by+"'的处理程序,请检查配置");
    				}
    				return driver.findElement(by2);
    			} 		
        	});
		} catch (Exception e) {
			tips+="【失败】";
			logger.error(tips, e);
			return null;
		}
		tips+="【成功】";
		logger.info(tips);
		return element;
    }
    
    public WebElement getElementByCertainPage(String keyword,String className){
    	//根据关键字找到元素定位对象
    	final Locator locator=UILibraryUtil.pageLocatorsMap.get(className).get(keyword);
    	String tips="获取元素：{'by','"+locator.getBy()+"',{'value','"+locator.getValue()+"'}'";
    	WebDriverWait wait = new WebDriverWait(driver,30);
    	WebElement element=null;
    	try {
    		element=wait.until(new ExpectedCondition<WebElement>(){
    			public WebElement apply(WebDriver driver) {
    				String by=locator.getBy();
    				String value=locator.getValue();
    				By by2 =null;
    				if("id".equals(by)){
    					by2=By.id(value);
    				}else if("name".equals(by)){
    					by2=By.name(value);
    				}else if("className".equals(by)){
    					by2=By.className(value);
    				}else if("xpath".equals(by)){
    					by2=By.xpath(value);
    				}else if("cssSelector".equals(by)){
    					by2=By.cssSelector(value);
    				}else if("linkText".equals(by)){
    					by2=By.linkText(value);
    				}else if("partialLinkText".equals(by)){
    					by2=By.partialLinkText(value);
    				}else if("tagName".equals(by)){
    					by2=By.tagName(value);
    				}
    				if(by2==null){
    					throw new RuntimeException("找不到'"+by+"'的处理程序,请检查配置");
    				}
    				return driver.findElement(by2);
    			} 		
        	});
		} catch (Exception e) {
			tips+="【失败】";
			logger.error(tips, e);
			return null;
		}
		tips+="【成功】";
		logger.info(tips);
		return element;
    }
    
    public List<WebElement> getElements(String keyword){
    	final Locator locator=UILibraryUtil.pageLocatorsMap.get(this.getClass().getName()).get(keyword);
    	String tips="获取元素列表：{'by','"+locator.getBy()+"',{'value','"+locator.getValue()+"'}'";
    	WebDriverWait wait = new WebDriverWait(driver,30);
    	List<WebElement> elements=null;
    	try {
    		elements=wait.until(new ExpectedCondition<List<WebElement>>(){
    			public List<WebElement> apply(WebDriver driver) {
    				String by=locator.getBy();
    				String value=locator.getValue();
    				By by2 =null;
    				if("name".equals(by)){
    					by2=By.name(value);
    				}else if("className".equals(by)){
    					by2=By.className(value);
    				}else if("xpath".equals(by)){
    					by2=By.xpath(value);
    				}else if("cssSelector".equals(by)){
    					by2=By.cssSelector(value);
    				}else if("linkText".equals(by)){
    					by2=By.linkText(value);
    				}else if("partialLinkText".equals(by)){
    					by2=By.partialLinkText(value);
    				}else if("tagName".equals(by)){
    					by2=By.tagName(value);
    				}
    				if(by2==null){
    					throw new RuntimeException("找不到'"+by+"'的处理程序，请检查配置");
    				}
    				return driver.findElements(by2);
    			} 		
        	});
		} catch (Exception e) {
			tips+="【失败】";
			logger.error(tips, e);
			return null;
		}
    	tips+="【成功】";
    	logger.info(tips);
		return elements;
    }
    /**访问对应url路径
     * @param url
     */
    public void to(String url){
    	driver.navigate().to(url);
    }
    /**
     * 浏览器后退
     */
    public void back(){
    	driver.navigate().back();;
    }
    /**
     * 浏览器前进
     */
    public void forward(){
    	driver.navigate().forward();
    }
    /**
     * 浏览器窗口最大化
     */
    public void maxmize(){
    	driver.manage().window().maximize();
    }
    /**
     * 获取页面标题
     */
    public void getTitle(){
    	driver.getTitle();
    }
   
    /**往元素写入数据
     * @param webElement
     * @param value
     */
    public static void sendkeys(WebElement webElement,String value){
    	logger.info("输入数据：【"+value+"】");
    	webElement.sendKeys(value);
    }
    /**点击事件
     * @param webElement
     */
    public static void click(WebElement webElement){
    	logger.info("触发点击事件");
    	webElement.click();
    }
    /**获取元素文本内容
     * @param webElement
     * @return
     */
    public static String getText(WebElement webElement){
    	String text=webElement.getText();
    	logger.info("获取元素文本内容：【"+text+"】");
    	return text;
    }
}
