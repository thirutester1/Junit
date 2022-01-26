package com.yugi.stepdefinition;

import java.io.File;
import java.io.IOException;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Flipkart {
	    static WebDriver d;
	    static long start;
       @BeforeClass
       public static void launch(){
    	 System.out.println("Browser launch");
      	 
       	WebDriverManager.chromedriver().setup();
       	d = new ChromeDriver();
       	d.get("https://www.flipkart.com/");
       	d.manage().window().maximize();
       	d.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS);
       }
       
      @AfterClass
      public static void close() {
    	  d.quit();
      }
      @Before
      public void start() {
    	  long start = System.currentTimeMillis();
      }
      
      @After
      public void end() {
    	long end = System.currentTimeMillis();
      	long t = end - start; 
      	System.out.println("Time taken :" +t);	  
      }
      
      @Test
      public void method1() {
    	  System.out.println("login test");
      	try {
      		WebElement button = d.findElement(By.xpath("//button[@class='_2KpZ6l _2doB4z']"));
      		 button.isDisplayed();
      	     button.click();
      	}catch (Exception e) {
      		System.out.println("Popup not displayed");
      	}
    	  
      }
      @Test
      public void method2() {
    	  System.out.println("search mobile");
      	WebElement search = d.findElement(By.xpath("//input[@type='text']"));
      	search.sendKeys("realme",Keys.ENTER);
      
      	WebElement mobileName = d.findElement(By.xpath("(//div[contains(text(),'realme')])[2]"));
      	mobileName.click();
      }
      @Test
      public void method3() {
     	System.out.println("Window handling");
     	String par = d.getWindowHandle();
     	Set<String> child = d.getWindowHandles();
  		for(String x : child) {
  		if(!par.equals(x)) {
  				System.out.println("tab switched");
  				d.switchTo().window(x);
  			}
  		}
     }
  		@Test
  		public void method4() {
  			WebElement mobileName2 = d.findElement(By.xpath("//span[contains(text(),'realme')]"));
  			String name = mobileName2.getText();
  			System.out.println(name);
  		
  			Assert.assertTrue(mobileName2.isDisplayed());
  		    Assert.assertEquals("realme Narzo 50i (Carbon Black, 32 GB)  (2 GB RAM)", name);
  			System.out.println("passed");
  		
      }
  		@Ignore
  		@Test
  		public void method5() throws IOException{
  			TakesScreenshot ts = (TakesScreenshot)d;
  			File src = ts.getScreenshotAs(OutputType.FILE);
  			File des = new File(".//target//Image.png");
  			FileUtils.copyFile(src, des);
  		}
       
       
}
