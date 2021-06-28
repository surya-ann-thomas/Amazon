package pages;

import java.io.IOException;
import java.util.ArrayList;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import base.TestBase;

public class CrediardPage extends TestBase{

	@FindBy(xpath="//input[@name='addCreditCardNumber']")
	WebElement cardNumber;
	
	@FindBy(xpath="//span[text()='Add your card']")
	WebElement addCard;
	
	@FindBy(xpath="//h4[@class='a-popover-header-content']")
	WebElement title;
	public CrediardPage() throws IOException {
		
		PageFactory.initElements(driver, this);
	}
	
	public void enterCardNumber() {
		//driver.switchTo().alert().sendKeys("123456");
		ArrayList<String> tabs=new ArrayList<> (driver.getWindowHandles());
		driver.switchTo().window(tabs.get(1));
		cardNumber.sendKeys("12345678");
		addCard.click();
		
	}
	
	public String getTitle() throws InterruptedException {
		Thread.sleep(7000);
		String text=title.getText();
		return text;
	}

}
