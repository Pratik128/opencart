package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.HomePage;
import pageObjects.LoginPage;
import pageObjects.MyAccountPage;
import testBase.BaseClass;

public class TC_002_LoginTest extends BaseClass
{
	@Test(groups={"sanity","master"})
	public void verify_login()
	{
		
		logger.info("****** Starting TC_002_LoginTest ******");
		logger.debug("capturing application debug logs...");
		
		try 
		{
		//HomePage
		HomePage hp = new HomePage(driver);
		hp.clickMyAccount();
		logger.info("clicked on Myaccount link on home page..");
		hp.clickLogin();
		logger.info("clicked on Login link under my account..");
		
		//LoginPage
		LoginPage lp = new LoginPage(driver);
		logger.info("Entering valid email and password..");
		lp.setEmail(p.getProperty("email"));
		lp.setPassword(p.getProperty("password"));
		lp.clickLogin();
		logger.info("clicked on login button..");
		
		//My AccountPage
		MyAccountPage macc = new MyAccountPage(driver);
		boolean targetpage = macc.isMyAccountPageExists();
		
		if(targetpage==true)
		{
			logger.info("Login test passed..");
			Assert.assertTrue(true);
		}
		else
		{
			logger.error("Login test failed..");
			Assert.fail();
		}
		}catch(Exception e)
		{	
			Assert.fail();
		}
		logger.info("****** Starting TC_002_LoginTest ******");
	}
}
