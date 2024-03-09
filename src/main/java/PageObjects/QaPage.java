package PageObjects;

import java.io.IOException;
import java.util.List;

import org.apache.poi.EncryptedDocumentException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class QaPage extends HomePage {

	public QaPage(WebDriver driver) {
		super(driver);
	}

	HomePage HP = new HomePage(driver);

	@FindBy(xpath = "//h1[normalize-space()='QA Engineer']")
	WebElement headerText;

	@FindBy(xpath = "//lyte-button[@id='detail-page-applybtn']//button[@type='button']")
	WebElement imInterestedBtn;

	@FindBy(xpath = "//span[normalize-space()='Job application']")
	WebElement jobApplicationText;
	
	@FindBy(xpath = "//h3[normalize-space()='Autofill Application']")
	WebElement AutofillApplicationText;

	@FindBy(xpath = "//lyte-drop-button[contains(@data-zcqa,'manual_Salutation')]")
	WebElement salutionDrop;

	@FindBy(xpath = "//lyte-drop-item[contains(@id,'Lyte_Drop_Item_')]")
	List<WebElement> salutionDropList;

	@FindBy(xpath = "//lyte-drop-button[contains(@data-zcqa,'manual_Current_Job_Title')]//span[contains(@class,'lyteDropPlaceholderNormal')][normalize-space()='-None-']")
	WebElement jobDrop;

	@FindBy(xpath = "//lyte-drop-item[contains(@id,'Lyte_Drop_Item_')]")
	List<WebElement> jobDropList;

	@FindBy(xpath = "(//input[@type='text'])[11]")
	WebElement currentCTC;

	@FindBy(xpath = "(//input[@type='text'])[12]")
	WebElement expectedCTC;

	@FindBy(xpath = "(//input[@type='text'])[13]")
	WebElement noticePeriod;

	@FindBy(xpath = "(//input[@type='text'])[14]")
	WebElement reason;

	@FindBy(xpath = "(//input[@type='text'])[15]")
	WebElement whyJoin;

	@FindBy(xpath = "(//input[@type='text'])[16]")
	WebElement linkedIn;

	@FindBy(xpath = "//span[text()='First Name cannot be empty.']")
	WebElement firstnameVal;

	@FindBy(xpath = "//span[text()='Last Name cannot be empty.']")
	WebElement lastnameVal;

	@FindBy(xpath = "//span[text()='Email cannot be empty.']")
	WebElement emailVal;

	@FindBy(xpath = "//span[text()='Mobile cannot be empty.']")
	WebElement mobileVal;

	@FindBy(xpath = "//span[text()='Current Employer cannot be empty.']")
	WebElement currentEmpVal;

	@FindBy(xpath = "//span[text()='Current Job Title cannot be empty.']")
	WebElement currentJobVal;

	@FindBy(xpath = "//span[text()='Current CTC cannot be empty.']")
	WebElement currentCTCVal;

	@FindBy(xpath = "//span[text()='Expected CTC cannot be empty.']")
	WebElement expectedCTCVal;

	@FindBy(xpath = "//span[text()='Notice Period (days) cannot be empty.']")
	WebElement NoticePeriodVal;

	@FindBy(xpath = "//span[text()='Reason for change from current organization? cannot be empty.']")
	WebElement reasonVal;

	@FindBy(xpath = "//span[text()='Resume cannot be empty.']")
	WebElement resumeVal;

	@FindBy(xpath = "//lyte-yield[normalize-space()='Submit Application']")
	WebElement submitBtn;

	public String getHeaderText() {
		HP.scrollToElement(headerText);
		String text = headerText.getText();
		return text;
	}
	
	public String RequiredText() throws EncryptedDocumentException, IOException
	{
		return "QA Engineer";
		
	}

	public String getPageTitleText() {
		String text = driver.getTitle();
		return text;
	}
	
	public String RequiredTextNumetics() throws EncryptedDocumentException, IOException {
		return "Numadic Iot Pvt. Ltd. - QA Engineer in";
	}

	public void clickImInterested() {
		if (imInterestedBtn.isEnabled()) {
			imInterestedBtn.click();
		}
	}

	public String getJobAppText() {
		return AutofillApplicationText.getText();
	}
	
	public String getAutofillText() {
		return AutofillApplicationText.getText();
	}
	
	public String AutofillText() {
		return "Autofill Application";
	}

	public void clickSubmit() {
		HP.scrollToElement(submitBtn);
		submitBtn.click();
	}

	public String getFirstNameValidation() {
		HP.scrollToElement(firstnameVal);
		return firstnameVal.getText();
	}

	public String getLastNameValidation() {
		HP.scrollToElement(lastnameVal);
		return lastnameVal.getText();
	}

	public String getEmailValidation() {
		HP.scrollToElement(emailVal);
		return emailVal.getText();
	}

	public String getMobileValidation() {
		HP.scrollToElement(mobileVal);
		return mobileVal.getText();
	}

	public String getEmployerValidation() {
		HP.scrollToElement(currentEmpVal);
		return currentEmpVal.getText();
	}

	public String getjobValidation() {
		HP.scrollToElement(currentJobVal);
		return currentJobVal.getText();
	}

	public String getCurrentCTCValidation() {
		HP.scrollToElement(currentCTCVal);
		return currentCTCVal.getText();
	}

	public String getExpectedCTCValidation() {
		HP.scrollToElement(expectedCTCVal);
		return expectedCTCVal.getText();
	}

	public String getnoticePeriodValidation() {
		HP.scrollToElement(NoticePeriodVal);
		return NoticePeriodVal.getText();
	}

	public String getReasonValidation() {
		HP.scrollToElement(reasonVal);
		return reasonVal.getText();
	}

	public String getResumeValidation() {
		HP.scrollToElement(reasonVal);
		return reasonVal.getText();
	}

}
