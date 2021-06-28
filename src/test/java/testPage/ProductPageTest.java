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
import pages.PaymentPage;
import pages.ProductPage;
import pages.SearchPage;

public class ProductPageTest extends TestBase{
LoginPage login;
HomePage home;
SearchPage search;
ProductPage product;
PaymentPage payment;
	public ProductPageTest() throws IOException {
		super();
		// TODO Auto-generated constructor stub
	}
	
	@BeforeMethod
	public void start() throws IOException,InterruptedException {
		initialization();
		home=new HomePage();
		login=home.getSigninPage();
		Map<String,String> data=ExcelRead.getMap();
		search=login.login(data.get("username"), data.get("passwrd"));
		
		product=search.enterProduct();
		
	}
	@Test(priority=1)
	public void checkTitle() {
		product.nextWindow();
		String text=product.titleVerify();
		Assert.assertEquals(text,"Samsung Galaxy M11 (Metallic Blue, 4GB RAM, 64GB Storage) with No Cost EMI/Additional Exchange Offers");
	}
	@Test(priority=2)
public void ClickOnBuy() throws IOException {
	product.nextWindow();
	payment=product.buyClick();
}
	
	@AfterMethod
	public void end() {
		driver.quit();
	}
}
