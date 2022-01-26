package com.yugi.stepdefinition;

import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Amazon {
	static WebDriver d;
	static long start;
	 @BeforeClass
     public static void launch() {
    	 
    	 System.out.println("Browser launch");
    	 
    	WebDriverManager.chromedriver().setup();
    	d = new ChromeDriver();
    	d.get("https://www.amazon.com/");
    	d.manage().window().maximize();
    	d.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS);
    	 
     }
     
     @AfterClass
     public static void close() {
    	d.quit();
     }
     
     @Before
     public void startTime() {
    	 long start = System.currentTimeMillis();
     }
     
     @After
     public void endTime() {
    	long end = System.currentTimeMillis();
    	long t = end - start; 
    	System.out.println("Time taken :" +t);
     }
     
     @Test
     public void method1() {
    
        	System.out.println("search mobile");
        	WebElement search = d.findElement(By.id("twotabsearchtextbox"));
        	search.sendKeys("mobile",Keys.ENTER);
     }
}
