package com.app.nobeds.webpages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage 
{
	@FindBy(name = "useris")
	private WebElement username;
	
	@FindBy(id="slapt")
	private WebElement password;
	
	@FindBy(id="slapt_login")
	private WebElement loginbutton;
	
	@FindBy(partialLinkText = "Forgot Password?")
	private WebElement forgotpassword;
	
	public LoginPage(WebDriver driver) 
	{
		PageFactory.initElements(driver, this);
	}
	public void setLoginCredentials(String user,String pass)
	{
		username.sendKeys(user);
		password.sendKeys(pass);
	}
	public void clickOnLoginButton()
	{
		loginbutton.click();
	}
	public void clickOnForgotPassword()
	{
		forgotpassword.click();
	}

}
