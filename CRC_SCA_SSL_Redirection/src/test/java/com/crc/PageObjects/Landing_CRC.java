package com.crc.PageObjects;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import com.PropertyFile.*;
import com.crc.helper.AbstractBaseClass;

public class Landing_CRC extends AbstractBaseClass
{
	@FindBy(how = How.XPATH, using = "//img[@src='https://app.creditrepaircloud.com/application/images/cloud_logo.png']")
	static WebElement CRClogo;
	
	@FindBy(how = How.XPATH, using = "//span[normalize-space()='Team Member Login']")
	static WebElement teamMemberLoginText;
	
	@FindBy(how = How.XPATH, using = "//body/div[1]/div[1]/div[1]/div[2]")
	static WebElement loginFormContainer;
	
	@FindBy(how = How.XPATH, using = "//h1[contains(text(),'Hello again!')]")
	static WebElement helloAgainText;
	
	@FindBy(how = How.XPATH, using = "//input[@id='username']")
	static WebElement userId;
	
	@FindBy(how = How.XPATH, using = "//input[@id='password']")
	static WebElement password;
	
	@FindBy(how = How.XPATH, using = "//input[@id='signin']")
	static WebElement loginButton;
	
	@FindBy(how = How.XPATH, using = "//a[@id='forgotpassword']")
	static WebElement forgotPassword;
	
	@FindBy(how = How.XPATH, using = "//a[contains(text(),'Join Our Free Live Software Classes!')]")
	static WebElement joinOurFreeliveSoftwareClassesButton;
	
	
	public Landing_CRC(WebDriver driver)
	{
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	public WebElement getCRClogo()
	{
		wait_validation(CRClogo);
		return CRClogo;
	}
	
	public WebElement getTeamMemberLoginText()
	{
		String teamMemberLogintext = "Team Member Login";
		wait_validation(teamMemberLoginText);
		Assert.assertEquals(teamMemberLoginText.getText(), teamMemberLogintext);		
		return teamMemberLoginText;
	}
	
	public WebElement getLoginFormContainer()
	{
		wait_validation(loginFormContainer);		
		return loginFormContainer;
	}
	
	public WebElement getHelloAgaintext()
	{
		String HelloAgainText = "Hello again!";
		wait_validation(helloAgainText);
		Assert.assertEquals(helloAgainText.getText(), HelloAgainText);		
		return helloAgainText;
	}
	
	public WebElement getUserId()
	{
		wait_validation(userId);
		send_text(userId, PropertyFile.prop.getProperty("CRC_userid"));		
		return userId;
	}
	
	public WebElement getPassword()
	{
		wait_validation(password);
		send_text(password, PropertyFile.prop.getProperty("CRC_password"));		
		return password;
	}
	
	public WebElement getLogin()
	{
		wait_validation(loginButton);
		click_action(loginButton);		
		return loginButton;
	}
	
	public WebElement getforgotPassword()
	{
		wait_validation(forgotPassword);
		Assert.assertTrue(forgotPassword.isDisplayed());		
		return forgotPassword;
	}
	public void BrowserQuit()
	{
		driver.quit();
	}
}
