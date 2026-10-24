package com.shruti.parabank.tests;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class ParaBankLoginTests {

	WebDriver driver;
	
	@BeforeMethod
	public void setUp()
	{
		driver=new ChromeDriver();
		driver.get("https://parabank.parasoft.com/");
		driver.manage().window().maximize();
	}
	
	@Test(priority = 1)
	public void validLogin()
	{
		driver.findElement(By.xpath("//input[@name='username']")).sendKeys("john");
		driver.findElement(By.xpath("//input[@name='password']")).sendKeys("demo");
		
		driver.findElement(By.xpath("//input[@value='Log In']")).click();
		
		WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[text()='Log Out']")));
		
		Assert.assertEquals(driver.getTitle(), "ParaBank | Accounts Overview");
		Assert.assertTrue(driver.findElement(By.xpath("//a[text()='Log Out']")).isDisplayed(), "Log Out Link should be display");
	}
	
	@Test(priority = 2)
	public void invalidLogin()
	{
		driver.findElement(By.xpath("//input[@name='username']")).sendKeys("john");
		driver.findElement(By.xpath("//input[@name='password']")).sendKeys("wrong");
		
		driver.findElement(By.xpath("//input[@value='Log In']")).click();
		
		WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//p[@class='error']")));
		
		Assert.assertTrue(driver.findElement(By.xpath("//p[@class='error']")).isDisplayed(), "Error message should be display");
		Assert.assertEquals(driver.findElement(By.xpath("//p[@class='error']")).getText(), "The username and password could not be verified.");
	
	}
	
	@AfterMethod
	public void tearDown()
	{
		driver.quit();
	}
}
