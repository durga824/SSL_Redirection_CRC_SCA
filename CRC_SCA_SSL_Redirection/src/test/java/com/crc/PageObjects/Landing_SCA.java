package com.crc.PageObjects;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import com.PropertyFile.*;
import com.crc.helper.AbstractBaseClass;

import junit.framework.Assert;

public class Landing_SCA extends AbstractBaseClass
{
	
	@FindBy(how = How.XPATH, using = "//strong[contains(text(),'Secure')]")
	static WebElement secureClientTitle;
	
	@FindBy(how = How.XPATH, using = "//h3[contains(text(),'Log in')]")
	static WebElement loginTitle;
	
	@FindBy(how = How.XPATH, using = "//div[@class='content']")
	static WebElement loginSection;
	
	@FindBy(how = How.XPATH, using = "//input[@placeholder='Email address or User ID']")
	static WebElement username;
	
	@FindBy(how = How.XPATH, using = "//input[@placeholder='Password']")
	static WebElement password;
	
	@FindBy(how = How.XPATH, using = "//button[@name='signin']")
	static WebElement signInButton;
	
	@FindBy(how = How.XPATH, using = "//button[@id='slidebtn']")
	static WebElement forgotYourPasswordButton;
	
		
	public Landing_SCA(WebDriver driver)
	{
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	public WebElement getSecureClientTitle()
	{
		String Securetitle = "Secure";
		wait_validation(secureClientTitle);
		Assert.assertEquals(secureClientTitle.getText(), Securetitle);		
		return secureClientTitle;
	}
	
	public WebElement getLoginTitle()
	{
		String LoginTitle = "Log in";
		wait_validation(loginTitle);
		Assert.assertEquals(loginTitle.getText(), LoginTitle);		
		return loginTitle;
	}
	
	public WebElement getUsername()
	{
		wait_validation(username);
		send_text(username, PropertyFile.prop.getProperty("Sca_userid"));		
		return username;
	}
	
	public WebElement getPassword()
	{
		wait_validation(password);
		send_text(password, PropertyFile.prop.getProperty("Sca_passwrd"));		
		return password;
	}
	
	public WebElement getSignInButton()
	{
		wait_validation(signInButton);
		signInButton.click();	
		return signInButton;
	}
	
	public WebElement getForgotPasswordButton()
	{
		wait_validation(forgotYourPasswordButton);		
		return forgotYourPasswordButton;
	}
	
	public WebElement getBrowserQuit()
	{
		driver.quit();
		return forgotYourPasswordButton;
	}
}
