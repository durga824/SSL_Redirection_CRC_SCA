package com.SCA.BaseClass;
import java.util.concurrent.TimeUnit;
import java.util.logging.Level;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.w3c.dom.DOMException;
import com.PropertyFile.*;
import com.crc.PageObjects.Landing_CRC;
import com.crc.PageObjects.Landing_SCA;
import org.openqa.selenium.remote.RemoteWebDriver;


public class SSlRedirections_Class extends PropertyFile
{	
	public static WebDriver driver;
    
	public static void launchBrowser(String url) 
	{			
		System.setProperty("webdriver.chrome.driver", "D:\\Durga\\chromedriver_win32\\chromedriver.exe");
        driver = new ChromeDriver();	
        ((RemoteWebDriver) driver).setLogLevel(Level.INFO);
		driver.manage().deleteAllCookies();
		driver.get(url);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
	}
	
	@Test
	public  void Initialising() throws DOMException, Throwable
	{
//		SCA LANDING PAGE
		System.out.println("Hitting URL: " + prop.getProperty("HittingSCAurl"));
		launchBrowser(prop.getProperty("HittingSCAurl"));
		System.out.println("URL changing to: " + driver.getCurrentUrl());
		try
		{
			Assert.assertEquals(prop.getProperty("ActualSCAurl"), driver.getCurrentUrl());	
			
		} catch (Exception e) {
			
			System.out.println("This is not the Expected URL So the Exception is Handeled");
		}
				
		Landing_SCA landing = new Landing_SCA(driver);
		landing.getSecureClientTitle();
		landing.getLoginTitle();
		landing.getUsername();
		landing.getPassword();
		landing.getForgotPasswordButton();
		landing.getSignInButton();		
		landing.getBrowserQuit();
					
//		CRC LANDING
		
		System.out.println("Hitting URL: " + prop.getProperty("HittingCRCurl"));
		launchBrowser(prop.getProperty("HittingCRCurl"));
		System.out.println("URL changing to: " + driver.getCurrentUrl());
		try 
		{
			Assert.assertEquals(prop.getProperty("ActualCRCurl"), driver.getCurrentUrl());
		} catch (Exception e) {
			System.out.println("This is not the Expected URL So the Exception is Handeled");
		}
		
		prop.getProperty("ActualCRCurl").equals(driver.getCurrentUrl());
		Landing_CRC lancrc = new Landing_CRC(driver);
		lancrc.getCRClogo();
		lancrc.getHelloAgaintext();
		lancrc.getLoginFormContainer();
		lancrc.getTeamMemberLoginText();
		lancrc.getUserId();
		lancrc.getPassword();
		lancrc.getforgotPassword();
		lancrc.getLogin();
		lancrc.BrowserQuit();
	}
}
