package org.test;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SurveyUserObjectManager extends Baseclass {

	public SurveyUserObjectManager() {
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
	@FindBy(xpath = "//button[@aria-label='New' and @role='menuitem']")
	WebElement btnSurveyUsersAddNew;
	@CacheLookup
	@FindBy(xpath = "//input[@aria-label='First Name']")
	WebElement txtFirstName;
	@CacheLookup
	@FindBy(xpath = "//input[@aria-label='Last Name']")
	WebElement txtLastName;
	@CacheLookup
	@FindBy(xpath = "//button[@aria-label='Search records for Company Name, Lookup field']")
	WebElement btnSearchCompanyName;
	@CacheLookup
	@FindBy(xpath = "//input[@aria-label='Email']")
	WebElement txtEmailId;
	@CacheLookup
	@FindBy(xpath = "//button[@aria-label='Save & Close']")
	WebElement btnSaveSurveyUser;
	@CacheLookup
	@FindBy(xpath = "//div[@id='id-1fed44d1-ae68-4a41-bd2b-f13acac4acfa-6-gendercode3ef39988-22bb-4f0b-bbbe-64b5a3748aee']")
	WebElement drpdwnGender;
	@CacheLookup
	@FindBy(xpath = "//div[@id='pa-option-set-component-e19c4b2c-8c2f-4618-4504-22320cbfc557fluent-option203']//span[@class='fui-Option__checkIcon ___1de1wj6 fod5ikn f18b9hdq f1xk557c fd7fpy0 fvc9v3g']")
	WebElement drpdwnGenderFemale;
	@CacheLookup
	@FindBy(xpath = "//button[@aria-label='Search records for Department, Lookup field']")
	WebElement txtDepartmentSearch;
	@CacheLookup
	@FindBy(xpath = "//button[@aria-label='Search records for Region, Lookup field']")
	WebElement btnSearchSurveyRegion;
	@CacheLookup
	@FindBy(xpath = "//button[@aria-label='Search records for Location, Lookup field']")
	WebElement btnSearchSurveyLocation;
	@CacheLookup
	@FindBy(xpath = "//button[@aria-label='Search records for Assessment, Lookup field']")
	WebElement btnSearchSurveyAssessment;
	

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

	public WebElement getButtonSurveyUsersAdd() {
		return btnSurveyUsersAddNew;
	}

	public WebElement getUserFirstname() {
		return txtFirstName;
	}

	public WebElement getUserLastname() {
		return txtLastName;
	}

	public WebElement getButtonSearchCompany() {
		return btnSearchCompanyName;
	}

	public WebElement getTextEmailId() {
		return txtEmailId;
	}

	public WebElement getButtonSaveSurveyUser() {
		return btnSaveSurveyUser;
	}
	public WebElement getDropdownSurveyUserGender() {
		return drpdwnGender;
	}
	public WebElement getDropdownSurveyUserGenderFemale() {
		return drpdwnGenderFemale;
	}
	public WebElement getButtonSearchDepartment() {
		return txtDepartmentSearch;
	}
	public WebElement getButtonSearchSurveyRegion() {
		return btnSearchSurveyRegion;
	}
	public WebElement getButtonSearchSurveyLocation() {
		return btnSearchSurveyLocation;
	}
	public WebElement getButtonSearchSurveyAssessment() {
		return btnSearchSurveyAssessment;
	}

}
