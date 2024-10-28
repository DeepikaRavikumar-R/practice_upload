package org.test;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class NomineesObjectManager extends Baseclass {
	
	public NomineesObjectManager() {
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
	@FindBy(xpath ="//button[@aria-label='New']")
	WebElement btnAddNewNominee;
	@CacheLookup
	@FindBy(xpath ="//button[@aria-label='Designation']")
	WebElement drpDownboxDesignation;
	@CacheLookup
	@FindBy(xpath = "//button[@aria-label='Search records for Company, Lookup field']")
	WebElement btnSeacrhCompany;
	@CacheLookup
	@FindBy(xpath = "//button[@aria-label='Search records for Assessment, Lookup field']")
	WebElement btnSeacrhAssessment;
	@CacheLookup
	@FindBy(xpath = "//button[@aria-label='Search records for Nominee Type, Lookup field']")
	WebElement btnSeacrhNomineeType;
	@CacheLookup
	@FindBy(xpath = "//button[@aria-label='Search records for SBU, Lookup field']")
	WebElement btnSeacrhSBU;
	@CacheLookup
	@FindBy(xpath = "//button[@aria-label='Search records for DNU_SBU, Lookup field']")
	WebElement btnSeacrhDNUSBU;
	@CacheLookup
	@FindBy(xpath = "//button[@aria-label='Save & Close']")
	WebElement btnSaveAndClose;
	
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
	public WebElement getButtonAddNewNominee() {
		return btnAddNewNominee;
	}
	public WebElement getDropDownNomineeDesignation() {
		return drpDownboxDesignation;
	}
	public WebElement getButtonSearchCompany() {
		return btnSeacrhCompany;
	}
	public WebElement getButtonSearchAssessment() {
		return btnSeacrhAssessment;
	}
	public WebElement getButtonSearchNomineeType() {
		return btnSeacrhNomineeType;
	}
	public WebElement getButtonSearchSBU() {
		return btnSeacrhSBU;
	}
	public WebElement getButtonSearchDNUSBU() {
		return btnSeacrhDNUSBU;
	}
	public WebElement getButtonSaveAndClose() {
		return btnSaveAndClose;
	}
	
	

}
