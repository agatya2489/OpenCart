package pageObjects;

import java.time.Duration;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AccountRegistrationPage extends BasePage{

	public AccountRegistrationPage(WebDriver driver) {
		super(driver);
		
	}

	//Elements
	@FindBy(name = "firstname")
	WebElement txtfirstname;
	
	@FindBy(name = "lastname")
	WebElement txtlastname;
	
	@FindBy(name = "email")
	WebElement txtEmail;
	
	@FindBy(name = "telephone")
	WebElement txtTelephone;
	
	@FindBy(name = "password")
	WebElement txtPassword;
	
	@FindBy(name = "confirm")
	WebElement txtConfirmPassword;
	
	@FindBy(name = "agree")
	WebElement chkdPolicy;

	@FindBy(css =  "button[type='submit']")
	WebElement btnConfirmation;
	
	@FindBy(xpath = "//h1[normalize-space()='Your Account Has Been Created!']")
	WebElement msgConfirmation;
	
	public void setFirstName(String fname)
	{
		txtfirstname.sendKeys(fname);
	}
	
	public void setLastName(String lname)
	{
		txtlastname.sendKeys(lname);
	}
	
	public void setEmail(String email)
	{
		txtEmail.sendKeys(email);
	}
	
	public void setTelephone(String tel)
	{
		txtTelephone.sendKeys(tel);

	}

	
	public void setPassword(String pwd)
	{
		txtPassword.sendKeys(pwd);
	}
	
	public void setConfirmPassword(String pwd) 
	{
		txtConfirmPassword.sendKeys(pwd);

	}
	
	public void setPrivacyPolicy()
	{
		chkdPolicy.click();
	}
	
	public void clickContinue()
	{
		//sol 1
		btnConfirmation.click();
		
		//sol 2
		//btnConfirmation.submit();
		
		//sol 3
		//Actions act= new Actions(driver);
		
		//sol 4
		//JavascriptExecutor js=(JavascriptExecutor) driver;
		
		//sol 5
		//btnConfirmation.sendKeys(Keys.RETURN);
		
		//sol 6
		//WebDriverWait mywait=new WebDriverWait(driver, Duration.ofSeconds(10));
		//mywait.until(ExpectedConditions.elementToBeClickable(btnConfirmation).click());
		
	}
	
	public String getConfirmationMsg()
	{
		try
		{
			return (msgConfirmation.getText());
		}
		catch(Exception e)
		{
			return e.getMessage();
		}
	}
		
}
