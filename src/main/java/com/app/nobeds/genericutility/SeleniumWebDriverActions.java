package com.app.nobeds.genericutility;

import java.io.File;
import java.io.IOException;
import java.nio.file.Path;
import java.time.Duration;
import java.util.List;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.Alert;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SeleniumWebDriverActions extends ObjectManager implements PathConstants
{
	WebDriver driver;
	String path ;
	/**
	 * initalize driver variable
	 * @param driver
	 */
	 public SeleniumWebDriverActions(WebDriver driver)
	 {
		 this.driver=driver;
		 
	 }
	 /**
	  * used to maximize browser
	  */
	 public void maximizeBrowser()
	 {
		 driver.manage().window().maximize();
	 }
	 /**
	  * used to refresh browser
	  */
	 public void refreshBrowser()
	 {
		 driver.navigate().refresh();
	 }
	 /**
	  * used to close all windows
	  */
	 public void closeAllWindows()
	 {
		 driver.quit();
	 }
	 /**
	  * used to open app
	  * @param url
	  */
	 public void openApp(String url)
	 {
		 driver.get(url);
	 }
	 
	 public Select selectInstance(WebElement targetelement)
	 {
		 return new Select(targetelement);
	 }
	 /**
	  * used to select dropdown option
	  * @param targetelement
	  * @param optiontext
	  */
	 public void selectOption(WebElement targetelement, String optiontext)
	 {
		 selectInstance(targetelement).selectByVisibleText(optiontext);
	 }
	 
	 public Actions actionsInstance()
	 {
		 return new Actions(driver);
	 }
	 /**
	  * used to move mouse cursor over target element
	  * @param targetelement
	  */
	 public void moveToTargetElement(WebElement targetelement)
	 {
		 actionsInstance().moveToElement(targetelement).perform();
	 }
	 /**
	  * used to perform mouse right click action on target element
	  * @param targetelement
	  */
	 public void rightClickOnTargetElement(WebElement targetelement)
	 {
		 actionsInstance().contextClick(targetelement).perform();
	 }
	 /**
	  * used to scroll upto target element
	  * @param targetelement
	  */
	 public void scrollToTargetElement(WebElement targetelement)
	 {
		 actionsInstance().scrollToElement(targetelement).perform();
	 }
	 
	 public JavascriptExecutor jsInstance()
	 {
		 return (JavascriptExecutor)driver;
	 }
	 
	 /**
	  * used to perform click action on targetelement using javascript
	  * @param targetelement
	  */
	 public void clickOnElementUsingJS(WebElement targetelement)
	 {
		 jsInstance().executeScript("arguments[0].click()", targetelement);
	 }
	 
	 /**
	  * used to enter text on targetelement using javascript
	  * @param targetelement
	  * @param value
	  */
	 public void enterTextUsingJS(WebElement targetelement, String value)
	 {
		 jsInstance().executeScript("arguments[0].value='"+value+"'", targetelement);
	 }
	 
	
	 /**
	  * used to take screenshot of webpage
	  * @param imagename
	  */
	 public void getScreenShot(String path , String imagename)
	 {
		TakesScreenshot s=(TakesScreenshot)driver;
		 File src = s.getScreenshotAs(OutputType.FILE);
		 
		 File dest=new File(path+"/"+imagename+".png");
		 try {
			FileUtils.copyFile(src, dest);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
	 }
	 /**
	  * used to handle alertpopup
	  */
	 public void acceptAlertPopup()
	 {
		 driver.switchTo().alert().accept();
	 }
	 public void declineAlertPopup()
	 {
		 driver.switchTo().alert().dismiss();
	 }
	 /**
	  * used to switch to mainpage
	  */
	 public void switchToMainPage()
	 {
		 driver.switchTo().defaultContent();
	 }
	/**
	 * used to make selenium implicitlywait for time 
	 */
	 public void implicitwait()
	 {
		 driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(waittime));
		 
	 }
	 /**
	  * used to make selenium explicitlywait 
	  * @return
	  */
	 
	 public WebDriverWait explicitwaitInstance()
	 {
		 return new WebDriverWait(driver, Duration.ofSeconds(waittime));
	 }
	 
	 public void waitTillAlertPopupDisplay()
	 {
		explicitwaitInstance().until(ExpectedConditions.alertIsPresent());
	 }
	 
	 public void verifyIframePresentAndSwitchTOFrame(WebElement frame)
	 {
		 explicitwaitInstance().until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(frame));
	 }
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 

}
