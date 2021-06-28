package testPage;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import base.TestBase;

import pages.HomePage;

import pages.LoginPage;

public class HomePageTest  extends TestBase{
	
	HomePage home;
	LoginPage login;
	public HomePageTest() throws IOException {
		super();
	}
	
	@BeforeMethod
	public void before() throws IOException {
	initialization();
	home=new HomePage();
	}

@Test(priority=1)
public void veriftTitle() {
Assert.assertEquals(home.before_login(), "Online Shopping site in India: Shop Online for Mobiles, Books, Watches, Shoes and More - Amazon.in","Title not found");	
}

@Test(priority=2)
public void loginTest() throws IOException {
	login=home.getSigninPage();
}
	
	@AfterMethod
	public void end()
	{
	driver.quit();	
	}
}
