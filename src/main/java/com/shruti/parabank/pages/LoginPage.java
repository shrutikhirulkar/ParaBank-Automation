package com.shruti.parabank.pages;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LoginPage {
	
	WebDriver driver;
	WebDriverWait wait;
	
	By usernameField = By.name("username");
	By passwordField = By.name("password");
	By loginButton = By.xpath("//input[@value='Log In']");
	By errorMessage = By.xpath("//p[@class='error']");
	
	public LoginPage(WebDriver driver)
	{
		this.driver=driver;
		this.wait=new WebDriverWait(driver, Duration.ofSeconds(10));
	}
	
	public void enterUsername(String username)
	{
		driver.findElement(usernameField).sendKeys(username);
	}
	
	public void enterPassword(String password)
	{
		driver.findElement(passwordField).sendKeys(password);
	}
	
	public void clickLogin()
	{
		driver.findElement(loginButton).click();
	}

	public void login(String username, String password)
	{
		enterUsername(username);
		enterPassword(password);
		clickLogin();
	}
	
	public boolean isErrorMessageDisplayed()
	{
		try
		{
		return wait.until(ExpectedConditions.visibilityOfElementLocated(errorMessage)).isDisplayed();
		}
		catch(TimeoutException e)
		{
			System.out.println("Error message is not displayed");
			return false;
		}
	}
	
	public String getErrorMessage()
	{
		return wait.until(ExpectedConditions.visibilityOfElementLocated(errorMessage)).getText();
	}
	
	
	
	
	
	
	
	
	
	
}