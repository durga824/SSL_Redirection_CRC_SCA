package com.crc.helper;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AbstractBaseClass
{
	 public static WebDriver driver;
	 public static  WebDriverWait wait;
	 public WebElement ele;
	 public static String value;
   	 public static JavascriptExecutor js;
   	  	 
   	public  void send_text(WebElement ele, String value) 
	{
//    	ele.clear();
    	ele.sendKeys(value);
    }
	
	public static void wait_validation(WebElement ele)
	{
		wait = new WebDriverWait(driver,60);
		wait.until(ExpectedConditions.elementToBeClickable(ele));
	}
	
	public static void click_action(WebElement ele)
	{
		wait_validation(ele);
		ele.click();
	}
	
	public static void PageScrollUntillVisibilityOfWebelement(WebElement ele)
	{
		
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollTo(0,0)");
		
	}
	public void select_dropdown_by_value(WebElement ele, String valueToChoose)
	{
	   Select sel = new Select(ele);
	   wait_validation(ele);
	   sel.selectByVisibleText(valueToChoose); 
	}
	 
	public void select_dropdown_by_index(WebElement ele, int index)
	{
	   Select sel = new Select(ele);
	   wait_validation(ele);
	   sel.selectByIndex(index);
	    
	}
}
