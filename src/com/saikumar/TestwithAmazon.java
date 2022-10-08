/**
 * 
 */
package com.saikumar;


import java.util.ArrayList;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

public class TestwithAmazon {
	public static String str;
	public static WebDriver driver;
	public static WebElement element;
	
	@BeforeSuite
	public void initialization()
	{
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\naiks\\Downloads\\chromedriver_win32\\chromedriver.exe");		
		driver = new ChromeDriver();
	}
	//@BeforeClass
	@Test(priority=1)
	public void register()
	{
		driver.get("https://www.amazon.in/ap/register?showRememberMe=true&openid.pape.max_auth_age=0&openid.identity=http%3A%2F%2Fspecs.openid.net%2Fauth%2F2.0%2Fidentifier_select&pageId=inflex&mobileBrowserWeblabTreatment=C&openid.return_to=https%3A%2F%2Fwww.amazon.in%2F%3F%26ext_vrnc%3Dhi%26tag%3Dgooginhydr1-21%26ref%3Dnav_custrec_signin%26adgrpid%3D60611463244%26hvpone%3D%26hvptwo%3D%26hvadid%3D617724335923%26hvpos%3D%26hvnetw%3Dg%26hvrand%3D2269137946552846840%26hvqmt%3Db%26hvdev%3Dc%26hvdvcmdl%3D%26hvlocint%3D%26hvlocphy%3D20453%26hvtargid%3Dkwd-320833120261%26hydadcr%3D15413_2322997%26gclid%3DCjwKCAjw4c-ZBhAEEiwAZ105Rd-Aq_G1eNMOyEQO9MfkRpVqRS2lS_SLhEaJzc-4XXks5I3KUO_2mxoCUIYQAvD_BwE&prevRID=4KVJCE9F7G4MR6KTZWRH&openid.assoc_handle=inflex&openid.mode=checkid_setup&desktopBrowserWeblabTreatment=C&prepopulatedLoginId=&failedSignInCount=0&openid.claimed_id=http%3A%2F%2Fspecs.openid.net%2Fauth%2F2.0%2Fidentifier_select&openid.ns=http%3A%2F%2Fspecs.openid.net%2Fauth%2F2.0");
		//driver.findElement(By.id("navbar-main")).click();
		//driver.findElement(By.xpath("//*[@id=\"hmenu-content\"]/ul[18]/li[26]/a")).click();
		//driver.findElement(By.xpath("/html/body/div[1]/div[1]/div[2]/div/div[2]/div/span/span/a")).click();
		element = driver.findElement(By.xpath("/html/body/div[1]/div[1]/div[2]/div/div[2]/div/form/div/div/div[1]/input"));
		element.sendKeys("Rahul");
		element = driver.findElement(By.xpath("/html/body/div[1]/div[1]/div[2]/div/div[2]/div/form/div/div/div[2]/div/div/div/div[2]/input"));
		element.sendKeys("7995607812");
		element = driver.findElement(By.xpath("/html/body/div[1]/div[1]/div[2]/div/div[2]/div/form/div/div/div[3]/div/input"));
		element.sendKeys("rahulram9858@gmail.com");
		element = driver.findElement(By.xpath("/html/body/div[1]/div[1]/div[2]/div/div[2]/div/form/div/div/div[4]/div/input"));
		element.sendKeys("rahul9858");
		driver.findElement(By.xpath("//input[@id='continue']")).click();
		driver.manage().window().maximize();
	}
	//@BeforeMethod
	@Test(priority=2)
	public void Login()
	{
		driver.navigate().to("https://www.amazon.in/ap/signin?openid.pape.max_auth_age=0&openid.return_to=https%3A%2F%2Fwww.amazon.in%2F%3Fref_%3Dnav_custrec_signin&openid.identity=http%3A%2F%2Fspecs.openid.net%2Fauth%2F2.0%2Fidentifier_select&openid.assoc_handle=inflex&openid.mode=checkid_setup&openid.claimed_id=http%3A%2F%2Fspecs.openid.net%2Fauth%2F2.0%2Fidentifier_select&openid.ns=http%3A%2F%2Fspecs.openid.net%2Fauth%2F2.0&");
		driver.manage().window().maximize();
		//driver.findElement(By.id("nav-signin-tooltip")).click();
		element = driver.findElement(By.id("ap_email"));
		element.sendKeys("7995607812");
		driver.findElement(By.id("continue")).click();
		element = driver.findElement(By.id("ap_password"));
		element.sendKeys("rahul9858");
		driver.findElement(By.id("signInSubmit")).click();
	}
  @Test(priority=3)
  public static void search() 
  {
	  	driver.get("https://www.amazon.in/");
		element = driver.findElement(By.xpath("//input[@id='twotabsearchtextbox']"));
		element.sendKeys("Apple iPhone 12 (64GB) - (Product) RED");
		element.findElement(By.xpath("//input[@id='nav-search-submit-button']")).click();
		driver.manage().window().maximize();
		str = driver.findElement(By.xpath("//span[normalize-space()='Apple iPhone 12 (64GB) - (Product) RED']")).getText();
		Assert.assertTrue(str.contains("Apple iPhone 12 (64GB) - (Product) RED"));
		driver.findElement(By.xpath("//span[normalize-space()='Apple iPhone 12 (64GB) - (Product) RED']")).click();
		ArrayList<String> tabs2 = new ArrayList<String> (driver.getWindowHandles());
	    driver.switchTo().window(tabs2.get(1));
	    str = driver.getCurrentUrl();
	    System.out.println(str);
	    str = driver.findElement(By.id("productTitle")).getText();
		Assert.assertTrue(str.contains("Apple iPhone 12 (64GB) - (Product) RED"));
		//str = driver.findElement(By.xpath("//*[@id=\"ddmDeliveryMessage\"]")).getText();
		//Assert.assertTrue(str.contains("Delivery"));
		//element.findElement(By.xpath("//input[@id='add-to-cart-button']")).click();
		Assert.assertTrue(driver.findElement(By.xpath("//input[@id='add-to-cart-button']")).isEnabled());
		driver.findElement(By.xpath("//input[@id='add-to-cart-button']")).click();
		System.out.println("item will added successfully");
		Assert.assertTrue(driver.findElement(By.xpath("//*[@id=\"buy-now-button\"]")).isEnabled());
  }
  @AfterSuite
	public void aftersuite()
	{
		System.out.println("After Suite");
	}
  @AfterClass
 	public void afterclass()
 	{
 		System.out.println("After Class");
 	}
  @AfterMethod
	public void aftermethod()
	{
		System.out.println("After Method");
	}

	

}