package testPage;

import java.io.IOException;
import java.util.Map;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.util.ExcelRead;

import base.TestBase;
import pages.CrediardPage;
import pages.HomePage;
import pages.LoginPage;
import pages.PaymentPage;
import pages.ProductPage;
import pages.SearchPage;

public class CreditCardTest extends TestBase{

	HomePage home;
	LoginPage login;
	SearchPage search;
	ProductPage product;
	PaymentPage payment;
	CrediardPage credit;
	
	public CreditCardTest() throws IOException {
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

		//search=login.login("suryaannthomas21@gmail.com", "Surya@55");
		product=search.enterProduct();
		product.nextWindow();
		payment=product.buyClick();
		credit=payment.selectCardOption();
	}
	@Test(enabled=false)
public void enterCard() {
credit.enterCardNumber();	
}
	@Test
	public void tile() throws InterruptedException {
		String text=credit.getTitle();
		Assert.assertEquals(text,"Add a credit or debit card");
	}
	@AfterMethod
	public void end() {
		//driver.quit();
	}
}
