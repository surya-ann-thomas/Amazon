package testPage;


import java.io.FileInputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.util.ExcelRead;


import base.TestBase;
import pages.HomePage;
import pages.LoginPage;
import pages.SearchPage;

public class LoginPageTest extends TestBase{

	HomePage home;
	LoginPage login;
	SearchPage search;
	
	public LoginPageTest() throws IOException {
		super();
		// TODO Auto-generated constructor stub
	}

	@BeforeMethod
	public void before() throws IOException {
	initialization();
	home=new HomePage();
	login=home.getSigninPage();
	
	}

@Test(enabled=false)
public void veriftTitle() {
Assert.assertEquals(login.loginTitle(), "Amazon Sign In","Title not found");	
}


@Test(priority=2)
public void loginTest() throws IOException, InterruptedException {

	Map<String,String> data=ExcelRead.getMap();
	search=login.login(data.get("username"), data.get("passwrd"));

}
	@AfterMethod
	public void end()
	{
	driver.quit();	
	}
	
}
