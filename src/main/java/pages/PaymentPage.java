package pages;

import java.io.IOException;
import java.util.ArrayList;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import base.TestBase;

public class PaymentPage extends TestBase{

	//@FindBy(xpath="//input[@id='pp-PWzgjn-75']")
	@FindBy(xpath="(//span[@class='a-text-bold'])[1]")
	WebElement cardButton;
	@FindBy(xpath="(//a[contains(text(),'Add a credit ')])[1]")
	
	//@FindBy(xpath="//a[@id='pp-TZte8V-80']")
	WebElement addCard;
	
public PaymentPage() throws IOException {
	PageFactory.initElements(driver, this);	
	}

public String paymentPageTitle() {
	return driver.getTitle();
}

public CrediardPage selectCardOption() throws InterruptedException, IOException {
	
	cardButton.click();
	Thread.sleep(5000);
	//String newTab=Keys.chord(Keys.CONTROL,Keys.RETURN);
	addCard.click();
	//addCard.sendKeys(newTab);
	//ArrayList<String> tabs=new ArrayList<> (driver.getWindowHandles());
	//driver.switchTo().window(tabs.get(1));
	driver.switchTo().frame(0);
	return new CrediardPage();
}
}
