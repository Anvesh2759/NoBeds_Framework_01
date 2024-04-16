package com.app.nobeds.genericutility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Parameters;


public class BaseClass extends ObjectManager 
{
	protected WebDriver driver;
	public static WebDriver st_driver;
	@Parameters({"browsername"})
	@BeforeClass
	public void selectBrowser(String browsername)
	{
		if(browsername.equals("Firefox"))
		{
			driver=new FirefoxDriver();
		}
		else if(browsername.equals("Chrome"))
		{
			driver=new ChromeDriver();
		}
		else
		{
			driver=new EdgeDriver();
		}
		st_driver=driver;
	}
	@BeforeMethod
	public void openApp()
	{
		getSeleniumWebDriverActions(driver).openApp(PropertyFileUtility.getDataFromPropertyFile("appurl"));
		getSeleniumWebDriverActions(driver).implicitwait();
	}
	@AfterClass
	public void closeBrowser()
	{
		getSeleniumWebDriverActions(driver).closeAllWindows();
	}
	
}
