package testPage;

import java.io.IOException;
import java.util.Map;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.util.ExcelRead;

import base.TestBase;
import pages.HomePage;
import pages.LoginPage;
import pages.ProductPage;
import pages.SearchPage;

public class SearchPageTest extends TestBase{

	LoginPage login;
	HomePage home;
	SearchPage search;
	ProductPage product;
	public SearchPageTest() throws IOException {
		super();
		// TODO Auto-generated constructor stub
	}
@BeforeMethod
public void start() throws IOException, InterruptedException {
	initialization();
	home=new HomePage();
	login=home.getSigninPage();
	Map<String,String> data=ExcelRead.getMap();
	search=login.login(data.get("username"), data.get("passwrd"));
	
	
}
@Test(priority=1)
public void siginCheck() {
	Assert.assertTrue(search.verifyLogin(), "User logged in");
}

@Test(priority=2)
public void productClick() throws InterruptedException, IOException{
	product=search.enterProduct();
	
}

@AfterMethod
public void end() {
	driver.quit();
}
}
