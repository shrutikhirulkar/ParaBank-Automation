package com.shruti.parabank.pages;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AccountsOverviewPage {

	WebDriver driver;
	WebDriverWait wait;
	
	By logoutLink = By.xpath("//a[text()='Log Out']");
	
	public AccountsOverviewPage(WebDriver driver)
	{
		this.driver=driver;
		this.wait=new WebDriverWait(driver, Duration.ofSeconds(10));
	}
	
	public boolean isLogoutLinkDisplayed()
	{
		try
		{
		return wait.until(ExpectedConditions.visibilityOfElementLocated(logoutLink)).isDisplayed();
		}
		catch(TimeoutException e)
		{
			System.out.println("Logout Link is not displayed");
			return false;
		}
	}
	
	public String getPageTitle()
	{
		return driver.getTitle();
	}
}
