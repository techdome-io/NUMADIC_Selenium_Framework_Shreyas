package PageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;

public class HomePage {

	WebDriver driver;
	Actions action;
	
	public HomePage(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver,this);
	}
	
	public  void scrollToElement(WebElement element) {
		action = new Actions(driver);
		action.moveToElement(element).build().perform();
	}
}
