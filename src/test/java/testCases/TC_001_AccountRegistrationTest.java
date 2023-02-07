package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.AccountRegistrationPage;
import pageObjects.HomePage;
import testBase.BaseClass;

public class TC_001_AccountRegistrationTest extends BaseClass {

	@Test(groups = {"Regression","Master"})//strp8 groups added
	public void test_account_Registration() throws InterruptedException{
		
		logger.debug("application logs...");
		logger.info("*** Starting TC_001_AccountRegistrationTest ***");
		
		try 
		{
			HomePage hp = new HomePage(driver);
			hp.clickMyAccount();
			logger.info("Clicked on My account link");
			
			hp.clickRegister();
			logger.info("Clicked on register link");

			AccountRegistrationPage regpage = new AccountRegistrationPage(driver);
			logger.info("Providing Customer Data");
			
			regpage.setFirstName(randomeString().toUpperCase());
			logger.info("Provided First Name ");
			
			regpage.setLastName(randomeString().toUpperCase());
			logger.info("Provided Last Name ");

			regpage.setEmail(randomeString() + "@gmail.com");// randomly generated the email
			//regpage.setEmail(rb.getString("email"));
			logger.info("Provided Email ");
			
			 //regpage.setTelephone(randomNumber());
             //logger.info("Provided Telephone ");

			 //String password=randomAlphaNumeric();
			 //regpage.setPassword(password);
			 //regpage.setConfirmPassword(password);
			regpage.setPassword(randomAlphaNumeric());
			//regpage.setPassword(rb.getString("password"));
			logger.info("Provided Password ");
			
			regpage.setPrivacyPolicy();
			logger.info("Set Privacy Policy ");

			regpage.clickContinue();
			logger.info("Clicked on Continue");

			Thread.sleep(5000);
			
			String confmsg=regpage.getConfirmationMsg();
			
			logger.info("Validating expected message");
			Assert.assertEquals(confmsg, "Your Account Has Been Created!","Test failed");

		} catch (Exception e)
		{
			//logger.error("Test Failed");
			Assert.fail();
		}
		logger.info("*** Finished TC_001_AccountRegistrationTest ***");

	}

}
