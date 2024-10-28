package org.test;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CompleteObjectManagerSurvey extends Baseclass {

	public CompleteObjectManagerSurvey() {
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
	@CacheLookup
	@FindBy(id = "cba_survey|NoRelationship|HomePageGrid|Mscrm.HomepageGrid.cba_survey.NewRecord17-button")
	WebElement btnNew;
	@CacheLookup
	@FindBy(xpath = "//input[@aria-label='Company Name']")
	WebElement txtCompanyname;
	@CacheLookup
	@FindBy(xpath= "//input[@id='id-8448b78f-8f42-454e-8e2a-f8196b0419af-2-cba_groupid270bd3db-d9af-4782-9025-509e298dec0a-cba_groupid.fieldControl-LookupResultsDropdown_cba_groupid_0_textInputBox_with_filter_new'] ")
	WebElement txtGroup;
//    @CacheLookup
//    @FindBy(xpath="//li[@aria-label='Survey']")
//    WebElement surveyButton;
    @CacheLookup
    @FindBy(xpath="//button[@aria-label='New']")
    WebElement newSurveyButton;
//    @CacheLookup
//    @FindBy(xpath="//input[@aria-label='Survey Name']")
//    WebElement txtSurveyName;
    
//    @CacheLookup
//    @FindBy(id="id-e6ce0c56-8c5b-47c4-9468-6524ba865e5b-2-cba_company270bd3db-d9af-4782-9025-509e298dec0a-cba_company.fieldControl-LookupResultsDropdown_cba_company_0_textInputBox_with_filter_new")
//    WebElement txtCompanyName;
    
//    @CacheLookup
//    @FindBy(xpath="//button[@aria-label='Save (CTRL+S)']")
//    WebElement saveSurveyButton;
    
//    @CacheLookup
//    @FindBy(xpath="//input[@aria-label='Date of Schedule Date']")
//    WebElement schDate;
//    @CacheLookup
//    @FindBy(xpath="//button[@aria-label='Send Survey']")
//    WebElement sendSurvey;
    


	public WebElement getTxtUserEmail() {
		return txtEmail;
	}

	public WebElement getButtonNext() {
		return btnNext;
	}

	public WebElement getTextPassword() {
		return txtPassword;
	}

	public WebElement getButtonSignin() {
		return btnSignin;
	}

	public WebElement getButtonYes() {
		return btnYes;
	}

	public WebElement getButtonNew() {
		return btnNew;
	}

	public WebElement getTextCompanyname() {
		return txtCompanyname;
	}
	public WebElement getTextGroup() {
		return txtGroup;
	}
	public WebElement getButtonSurvey() {
		return driver.findElement(By.xpath("//li[@aria-label='Survey']"));
	}
	public WebElement getNewSurveyButton() {
		return newSurveyButton;
	}
	public WebElement getSurveyNameText() {
		return driver.findElement(By.xpath("//input[@aria-label='Survey Name']"));
	}
	public WebElement getCompanyNameText() {
		return driver.findElement(By.xpath("//input[@aria-label='Company, Lookup']"));
	}
	public WebElement getSaveSurveyButton() {
		return driver.findElement(By.xpath("//button[@aria-label='Save (CTRL+S)']"));
	}
	public WebElement getSchDate() {
		return driver.findElement(By.xpath("//input[@aria-label='Date of Schedule Date']"));
	}
	public WebElement getSendSurvey() {
		return driver.findElement(By.xpath("//button[@aria-label='Send Survey']"));
	}
	
	
}
