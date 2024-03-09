package PageObjects;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CareersPage extends HomePage {

	public CareersPage(WebDriver driver) {
		super(driver);
	}

	@FindBy(xpath = "//h2[normalize-space()='JOIN OUR CREW']")
	WebElement HeaderText;

	@FindBy(tagName = "lyte-drop-button")
	WebElement FilterBy;

	@FindBy(xpath = "//lyte-drop-item[@id='Lyte_Drop_Item_2']")
	WebElement EngineerFilter;

	@FindBy(xpath = "//*[contains(text(),'QA Engineer')]")
	WebElement QAJobOption;

	public String getHeaderText() {
		return HeaderText.getText();
		
	}
	public String RequiredText() throws EncryptedDocumentException, IOException, InterruptedException {
	return "JOIN OUR CREW";
	}

	
	public void SelectFilter(String text) {
		HomePage bp = new HomePage(driver);
		bp.scrollToElement(FilterBy);
		FilterBy.click();
		if (text.equalsIgnoreCase(EngineerFilter.getText()))
		{
			EngineerFilter.click();
		}

		if (QAJobOption.isDisplayed()) {
			bp.scrollToElement(QAJobOption);
			QAJobOption.click();
		} else {
			QAJobOption.click();
		}
	}

}
