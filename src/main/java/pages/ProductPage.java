package pages;

import java.io.IOException;
import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import base.TestBase;

public class ProductPage extends TestBase{
	
@FindBy(xpath="//span[@id='productTitle']")
WebElement productName;

@FindBy(id="buy-now-button")
WebElement buyButton;

public ProductPage() throws IOException{
	PageFactory.initElements(driver,this);
}

public void nextWindow() {
	String MainWindow=driver.getWindowHandle();		
    Set<String> s1=driver.getWindowHandles();		
    Iterator<String> i1=s1.iterator();		
    		
    while(i1.hasNext())			
    {		
        String ChildWindow=i1.next();		
        		
        if(!MainWindow.equalsIgnoreCase(ChildWindow))			
        {    		
             
                
                driver.switchTo().window(ChildWindow);	                                                                                                           
         
               
        }        
        		
        }		
	
}

public String titleVerify() {
	String title=productName.getText();
	return title;
	
}

public PaymentPage buyClick() throws IOException {
	buyButton.click();
	return new PaymentPage();
}
}
