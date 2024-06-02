package testCases;


import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.AccountRegisterationPage;
import pageObjects.HomePage;
import testBase.BaseClass;


public class TC_001_AccountRegisterationTest extends BaseClass{
	
	
	
	@Test(groups= {"regression","master"})
	public void verify_account_registration()
	{
		logger.info("******    Starting TC_001_ AccountRegisterationTest  ******");
		
		logger.debug("Application logs started..");
		try
		{
		HomePage hp = new HomePage(driver);
		hp.clickMyAccount();
		logger.info("Clicked on MyAccount link..");
		
		hp.clickRegister();
		logger.info("Clicked on Registeration link..");
		
		
		logger.info("Providing customer details...");
		AccountRegisterationPage regpage = new AccountRegisterationPage(driver);
		regpage.setFirstname(randomeString().toUpperCase());
		regpage.setLastname(randomeString().toUpperCase());
		regpage.setEmail(randomeString()+"@gmail.com");
		regpage.setTelephone(randomeNumber());
		
		String password = randomeAlphaNumeric();
		regpage.setPassword(password);
		regpage.setConfirmPassword(password);

		regpage.setPrivacyPolicy();
		regpage.clickContinue();
		logger.info("Clicking on continue button..");
		
		
		String confmsg = regpage.getConfirmationMsg();
		
		logger.info("Validating msg..");
		
		
		if(confmsg.equals("Your Account Has Been Created!")) 
		{
			logger.info("Test Passed..");
			Assert.assertTrue(true);
		}
		else
		{
			logger.error("Test Failed..");
			Assert.fail();
		}
		
		}
		catch(Exception e)
		{
			logger.error("test failed..");
			Assert.fail();
		}
		
		logger.debug("application logs ended..");
		logger.info("******  Finished TC_001_AccountRegisteratioTest   ******");
	}
	
}
