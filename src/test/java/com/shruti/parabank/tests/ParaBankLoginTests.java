package com.shruti.parabank.tests;




import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;


import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.shruti.parabank.pages.AccountsOverviewPage;
import com.shruti.parabank.pages.LoginPage;

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
		LoginPage loginPage=new LoginPage(driver);
		loginPage.login("john", "demo");
		
		AccountsOverviewPage overviewPage=new AccountsOverviewPage(driver);
		
		Assert.assertTrue(overviewPage.isLogoutLinkDisplayed(), "Log Out Link should be display");
		Assert.assertEquals(overviewPage.getPageTitle(), "ParaBank | Accounts Overview");
	}
	
	@Test(priority = 2)
	public void invalidLogin()
	{
		LoginPage loginPage=new LoginPage(driver);
		loginPage.login("john", "wrong");
		
		Assert.assertTrue(loginPage.isErrorMessageDisplayed(), "Error message should be display");
		Assert.assertEquals(loginPage.getErrorMessage(), "The username and password could not be verified.");
	
	}
	
	@Test(priority = 3)
	public void emptyCredentials()
	{
		LoginPage loginPage=new LoginPage(driver);
		loginPage.clickLogin();
		
		Assert.assertTrue(loginPage.isErrorMessageDisplayed(), "Error message should be display");
		Assert.assertEquals(loginPage.getErrorMessage(), "Please enter a username and password.");
	
	}
	
	@AfterMethod
	public void tearDown()
	{
		driver.quit();
	}
}
