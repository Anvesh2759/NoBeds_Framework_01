package com.app.nobeds.genericutility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ObjectManager
{
	private static SeleniumWebDriverActions s_actions;
	private static DataBaseUtility db_utility;
	private static JavaUtility j_utility;
	
	public SeleniumWebDriverActions getSeleniumWebDriverActions(WebDriver driver)
	{
		return (s_actions==null)?new SeleniumWebDriverActions(driver):s_actions;
	}
	
	public  DataBaseUtility getDataBaseUtility()
	{
		return (db_utility==null)?new DataBaseUtility():db_utility;
	}
	
	public JavaUtility getJavaUtility()
	{
		return (j_utility==null)?new JavaUtility():j_utility;
	}
	

}
