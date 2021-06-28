package pages;

import java.io.IOException;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import base.TestBase;

public class LoginPage extends TestBase{
	@FindBy(xpath="//input[@type='email']")
	WebElement username;
	
	@FindBy(xpath="//input[@id='continue']")
	WebElement continu;
	
	@FindBy(xpath="//input[@type='password']")
	WebElement password;
	
	@FindBy(xpath="(//input[@type='submit'])[1]")
	WebElement submit;
	
public LoginPage() throws IOException {
		
		PageFactory.initElements(driver, this);
	}

public String loginTitle() {
	return driver.getTitle();
}
public SearchPage login(String uname,String pass) throws IOException, InterruptedException {
	
	username.sendKeys(uname);
	continu.click();
	Thread.sleep(3000);
	password.sendKeys(pass);
	submit.click();
	return new SearchPage();

}
}