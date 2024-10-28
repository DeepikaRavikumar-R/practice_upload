package org.test;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SurveySelfAssessmentObjectManager extends Baseclass {
	public SurveySelfAssessmentObjectManager() {
		PageFactory.initElements(driver, this);
	}

	@CacheLookup
	@FindBy(id = "i0116")
	WebElement txtEmail;
	@CacheLookup
	@FindBy(id = "idSIButton9")
	WebElement btnNext;
	@CacheLookup
	@FindBy(xpath = "//input[@id='i0118']")
	WebElement txtPassword;
	@CacheLookup
	@FindBy(xpath = "//input[@id='idSIButton9']")
	WebElement btnSignin;
	@CacheLookup
	@FindBy(id = "idSIButton9")
	WebElement btnYes;

}
