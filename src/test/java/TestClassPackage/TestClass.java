package TestClassPackage;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import LibaryFiles.BaseClass;
import LibaryFiles.DataProviders;
import PageObjects.CareersPage;
import PageObjects.QaPage;

public class TestClass extends BaseClass {
	@Test(priority = 1)
	public void VerifyHeaderText() throws EncryptedDocumentException, IOException, InterruptedException {

		CareersPage HomePg = new CareersPage(driver);
		Assert.assertEquals(HomePg.getHeaderText(),HomePg.RequiredText());
	}
	
	@Test(priority = 2)
	public void DropDownFilter() throws EncryptedDocumentException, IOException {

		CareersPage CP = new CareersPage(driver);
		CP.SelectFilter("Engineering");
		QaPage QP = new QaPage(driver);
		Assert.assertEquals(QP.getHeaderText(),QP.RequiredText());
	}
	@Test(priority = 3)
	public void VerifyPageTitle() throws EncryptedDocumentException, IOException {
		QaPage QAp = new QaPage(driver);
		Assert.assertEquals(QAp.getPageTitleText(),QAp.RequiredTextNumetics() );
	}
	
	@Test(priority = 4)
	public void VerifImIntrestedInButton() {
		QaPage QAp = new QaPage(driver);
		QAp.clickImInterested();
		Assert.assertEquals(QAp.getAutofillText(),QAp.AutofillText());
	}
	@Test(priority = 5,dataProvider = "fieldValidation", dataProviderClass = DataProviders.class)
	public void VerifyFieldsValidatins(String FNvalidation, String LNvalidation, String EmailValidation, String MobileValidation, String EmployerValidation, String JobValidation, String CurrentCTCvalidation,
			String ExpectedCTCValidation, String NoticePeriodValidation, String ResonValidation, String ResumeValidation) {
		SoftAssert Sa = new SoftAssert();
		QaPage qa = new QaPage(driver);
		qa.clickSubmit();
		
	Sa.assertEquals(qa.getFirstNameValidation(),FNvalidation);
		Sa.assertEquals(qa.getLastNameValidation(), LNvalidation);
		Sa.assertEquals(qa.getEmailValidation(), EmailValidation);
		Sa.assertEquals(qa.getMobileValidation(), MobileValidation);

		Sa.assertEquals(qa.getEmployerValidation(), EmployerValidation);
		Sa.assertEquals(qa.getjobValidation(), JobValidation);
		Sa.assertEquals(qa.getCurrentCTCValidation(), CurrentCTCvalidation);
		Sa.assertEquals(qa.getExpectedCTCValidation(), ExpectedCTCValidation);

		Sa.assertEquals(qa.getnoticePeriodValidation(), NoticePeriodValidation);
		Sa.assertEquals(qa.getReasonValidation(), ResonValidation);

		Sa.assertEquals(qa.getResumeValidation(), ResumeValidation);

		Sa.assertAll();
	}

}
