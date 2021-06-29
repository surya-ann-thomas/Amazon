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

public class PaymentPageTest extends TestBase{
HomePage home;
LoginPage login;
SearchPage search;
ProductPage product;
PaymentPage payment;
CrediardPage credit;
	public PaymentPageTest() throws IOException {
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

		
		product=search.enterProduct();
		product.nextWindow();
		payment=product.buyClick();
	}
@Test(priority=1)
	public void paymentTitle() {
		String text=payment.paymentPageTitle();
		Assert.assertEquals(text, "Select a Payment Method - Amazon.in Checkout");
	}
	@Test(priority=2)
	public void cardSelect() throws InterruptedException, IOException {
		credit=payment.selectCardOption();
	}
	@AfterMethod
	public void end() {
		driver.quit();
	}
}
