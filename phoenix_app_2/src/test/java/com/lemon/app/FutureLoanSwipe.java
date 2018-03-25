package com.lemon.app;

import org.testng.annotations.Test;

public class FutureLoanSwipe extends Base{
    	@Test
    	public void testSwipe() throws InterruptedException{
    		int width=androidDriver.manage().window().getSize().getWidth();
    		int height=androidDriver.manage().window().getSize().getHeight();
    		int startx=width*7/8;
    		int endx=width*1/8;
    		int starty=height*1/2;
    		int endy=height*1/2;
    		int duration=500;//单位是毫秒
    		for(int i=0;i<3;i++){
    			androidDriver.swipe(startx, starty, endx, endy, duration);
    			Thread.sleep(1000);
    		}
    	}
    }

