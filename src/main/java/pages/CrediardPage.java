package pages;

import java.io.IOException;
import java.util.ArrayList;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import base.TestBase;

public class CrediardPage extends TestBase{

	@FindBy(xpath="//input[@name='addCreditCardNumber']")
	WebElement cardNumber;
	
	//@FindBy(xpath="//span[text()='Add your card']")
	@FindBy(xpath="//input[@class='a-button-input']")
	WebElement addCard;
	
	@FindBy(xpath="//h4[@class='a-popover-header-content']")
	WebElement title;
	
	@FindBy(xpath="//span[@class='a-list-item' and text()='Card number is not correct.']")
	WebElement verifyError;
	
	public CrediardPage() throws IOException {
		
		PageFactory.initElements(driver, this);
	}
	
	public void enterCardNumber() throws InterruptedException {
		
		//ArrayList<String> tabs=new ArrayList<> (driver.getWindowHandles());
		//driver.switchTo().window(tabs.get(1));
		cardNumber.sendKeys("12345678");
		Thread.sleep(3000);
		addCard.click();
	}
	
	public String verify() {
		String invalidMessage="";
		if(driver.findElements(By.xpath("(//span[@class='a-list-item' ])[1]")).size()>0) {
			System.out.println("error message found");
			invalidMessage=verifyError.getText();
			
		}
		else {
			System.out.println("error message not displayed");
		}
		return invalidMessage;
		
	}
	
	public String getTitle() throws InterruptedException {
		//ArrayList<String> tabs=new ArrayList<> (driver.getWindowHandles());
		//driver.switchTo().window(tabs.get(1));
		
		Thread.sleep(7000);
		String text=title.getText();
		return text;
	}

}
