package pages;

import java.io.IOException;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import base.TestBase;

public class SearchPage extends TestBase {

	

	@FindBy(xpath="//input[@type='text']")
	WebElement search;
	
	@FindBy(xpath="//input[@type='submit']")
	WebElement submit;
	@FindBy(xpath="//span[contains(text(),'Hello, Surya')]")
	WebElement verify_name;
	@FindBy(xpath="//span[contains(text(),'Samsung Galaxy M11 (Metallic Blue, 4GB RAM')]")
	WebElement productName;
	
	
	public SearchPage() throws IOException {
		PageFactory.initElements(driver,this);
	}
	
	
	public boolean verifyLogin() {
		return verify_name.isDisplayed();
	}

		public ProductPage enterProduct() throws InterruptedException, IOException {
			Thread.sleep(4000);
			search.sendKeys("samsung mobile");
			submit.click();
			productName.click();
			return new ProductPage();
		}
}
