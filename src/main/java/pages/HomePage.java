package pages;

import java.io.IOException;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import base.TestBase;

public class HomePage extends TestBase{
	
	@FindBy(xpath="//span[contains(text(),'Hello,')]")
    WebElement over;
	
	@FindBy(xpath="//span[contains(text(),'Sign in')]")
	WebElement signin_click;
	
public HomePage() throws IOException {
		
		PageFactory.initElements(driver, this);
	}

public String before_login() {
	return driver.getTitle();
}

public LoginPage getSigninPage() throws IOException {
	Actions a = new Actions(driver);
	a.moveToElement(over).build().perform();
	signin_click.click();
	return new LoginPage();
}
}
