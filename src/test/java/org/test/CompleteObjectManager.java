package org.test;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CompleteObjectManager extends Baseclass {

	public CompleteObjectManager() {
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
	@FindBy(xpath = "//button[@aria-label='New']")
	WebElement btnNew;
	@CacheLookup
	@FindBy(xpath = "//input[@aria-label='Company Name']")
	WebElement txtCompanyname;
	// @CacheLookup
	// @FindBy(xpath=
	// "//input[@id='id-8448b78f-8f42-454e-8e2a-f8196b0419af-2-cba_groupid270bd3db-d9af-4782-9025-509e298dec0a-cba_groupid.fieldControl-LookupResultsDropdown_cba_groupid_0_textInputBox_with_filter_new']
	// ")
	// WebElement txtGroup;
	// @CacheLookup
	// @FindBy(xpath = "//input[@aria-label='SBU, Lookup']")
	// WebElement txtSBU;
	// @CacheLookup
	// @FindBy(xpath = "//input[@aria-label='Sector, Lookup']")
	// WebElement txtSector;
	// @CacheLookup
	// @FindBy(xpath = "//input[@aria-label='Division, Lookup']")
	// WebElement txtDivision;
	// @CacheLookup
	// @FindBy(xpath = "//input[@aria-label='Function, Lookup']")
	// WebElement txtFunction;
	// @CacheLookup
	// @FindBy(xpath = "//input[@aria-label='Country, Lookup']")
	// WebElement txtCountry;
	// @CacheLookup
	// @FindBy(xpath = "//input[@aria-label='Region, Lookup']")
	// WebElement txtRegion;

	@CacheLookup
	@FindBy(xpath = "//button[@aria-label='Search records for Group, Lookup field']")
	WebElement txtsearchGroup;
	@CacheLookup
	@FindBy(xpath = "//li[@aria-label='23 Mar 24 Group, 3/23/2024 5:52 PM']")
	WebElement txtSelectGroup;

	@CacheLookup
	@FindBy(xpath = "//button[@aria-label='Search records for SBU, Lookup field']")
	WebElement txtsearchSBU;
	@CacheLookup
	@FindBy(xpath = "//li[@aria-label='23 Mar 24 SBU, 3/23/2024 5:53 PM']")
	WebElement txtSelectSBU;

	@CacheLookup
	@FindBy(xpath = "//button[@aria-label='Search records for Sector, Lookup field']")
	WebElement txtsearchSector;
	@CacheLookup
	@FindBy(xpath = "//li[@aria-label='23 Mar 25 Sector, 3/23/2024 5:59 PM']")
	WebElement txtSelectSector;

	@CacheLookup
	@FindBy(xpath = "//button[@aria-label='Search records for Division, Lookup field']")
	WebElement txtsearchDivision;
	@CacheLookup
	@FindBy(xpath = "//li[@aria-label='23 Mar 24 Div, 3/23/2024 6:00 PM']")
	WebElement txtSelectDivision;

	@CacheLookup
	@FindBy(xpath = "//button[@aria-label='Search records for Function, Lookup field']")
	WebElement txtsearchFunction;
	@CacheLookup
	@FindBy(xpath = "//li[@aria-label='23 Mar 24 Fun, 3/23/2024 6:00 PM']")
	WebElement txtSelectFunction;

	@CacheLookup
	@FindBy(xpath = "//button[@aria-label='Search records for Country, Lookup field']")
	WebElement txtsearchCountry;
	@CacheLookup
	@FindBy(xpath = "//li[@aria-label='India, 3/18/2024 12:48 PM']")
	WebElement txtSelectCountry;

	@CacheLookup
	@FindBy(xpath = "//button[@aria-label='Search records for Region, Lookup field']")
	WebElement txtsearchRegion;
	@CacheLookup
	@FindBy(xpath = "//li[@aria-label='NCR, 3/18/2024 12:48 PM']")
	WebElement txtSelectRegion;

	@CacheLookup
	@FindBy(xpath = "//button[@id='account|NoRelationship|Form|Mscrm.Form.account.Save01-button']")
	WebElement btnSave;

	@CacheLookup
	@FindBy(xpath = "//button[@aria-label='Copy Templates']")
	WebElement btnCopyTemplate;

	@CacheLookup
	@FindBy(id = "FullPageWebResource")
	WebElement switchToFrame;

	@CacheLookup
	@FindBy(xpath = "//input[@id='e0c02a6b-bb13-ee11-8f6d-002248801cc7']")
	WebElement chkboxProactive;

	@CacheLookup
	@FindBy(id = "0f26db58-bb13-ee11-8f6d-002248801cc7")
	WebElement chkboxBuildingConfidence;

	@CacheLookup
	@FindBy(id = "f4f9e687-bb13-ee11-8f6d-002248801cc7")
	WebElement chkboxConceptualFlexing;

	@CacheLookup
	@FindBy(id = "dbc02a6b-bb13-ee11-8f6d-002248801cc7")
	WebElement chkboxEmpathy;

	@CacheLookup
	@FindBy(xpath = "(//button[@class='btn-next'])[1]")
	WebElement scrollDownNext;

	@CacheLookup
	@FindBy(xpath = "(//button[@class='btn-next'])[1]")
	WebElement btnCopyTemplateNext;

//	@CacheLookup
//	@FindBy(id = "FullPageWebResource")
//	WebElement switchToFrameRaterTypes;

	@CacheLookup
	@FindBy(xpath = "(//tbody[@id='RaterTypesBody']/tr/td/input[@type='checkbox'])[1]")
	WebElement chkboxSelf;

	@CacheLookup
	@FindBy(xpath = "(//tbody[@id='RaterTypesBody']/tr/td/input[@type='checkbox'])[2]")
	WebElement chkboxManager;

	@CacheLookup
	@FindBy(xpath = "(//tbody[@id='RaterTypesBody']/tr/td/input[@type='checkbox'])[3]")
	WebElement chkboxpeer;

	@CacheLookup
	@FindBy(xpath = "(//tbody[@id='RaterTypesBody']/tr/td/input[@type='checkbox'])[4]")
	WebElement chkboxReport;
	
	@CacheLookup
	@FindBy(xpath = "(//button[@class='btn-next'])[2]")
	WebElement btnNextRaterType;
	
	@CacheLookup
	@FindBy(xpath = "(//button[@class='btn-next'])[3]")
	WebElement btnNextEmailMsg;
	
	@CacheLookup
	@FindBy(xpath = "(//button[@class='btn-next'])[4]")
	WebElement btnNextInstructionTemp;
	
	@CacheLookup
	@FindBy(xpath = "//button[@id='btnSave']")
	WebElement btnSaveBenchmark;
	
	@CacheLookup
	@FindBy(xpath= "((//div[@role='presentation' and contains(@class, 'pa-az') and contains(@class, 'flexbox')])[8]")
	WebElement btnSurveyUser;
	
	@CacheLookup
	@FindBy(xpath= "(//span[@aria-hidden='true' and contains(@class, 'pa-cr')])[8]")
	WebElement btnSurveyUsersAdd;
	
	
	
	

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
	// public WebElement getTextGroup() {
	// return txtGroup;
	// }
	// public WebElement getTextSBU() {
	// return txtSBU;
	// }
	// public WebElement getTextSector() {
	// return txtSector;
	// }
	// public WebElement getTextDivision() {
	// return txtDivision;
	// }
	// public WebElement getTextFunction() {
	// return txtDivision;
	// }
	// public WebElement getTextCountry() {
	// return txtCountry;
	// }
	// public WebElement getTextRegion() {
	// return txtRegion;
	// }

	public WebElement getButtonSearchGroup() {
		return txtsearchGroup;
	}

	public WebElement getClickSelectGroup() {
		return txtSelectGroup;
	}

	public WebElement getButtonSearchSBU() {
		return txtsearchSBU;
	}

	public WebElement getClickSelectSBU() {
		return txtSelectSBU;
	}

	public WebElement getButtonSearchSector() {
		return txtsearchSector;
	}

	public WebElement getClickSelectSector() {
		return txtSelectSector;
	}

	public WebElement getButtonSearchDivision() {
		return txtsearchDivision;
	}

	public WebElement getClickSelectDivision() {
		return txtSelectDivision;
	}

	public WebElement getButtonSearchFunction() {
		return txtsearchFunction;
	}

	public WebElement getClickSelectFunction() {
		return txtSelectFunction;
	}

	public WebElement getButtonSearchCountry() {
		return txtsearchCountry;
	}

	public WebElement getClickSelectCountry() {
		return txtSelectCountry;
	}

	public WebElement getButtonSearchRegion() {
		return txtsearchRegion;
	}

	public WebElement getClickSelectRegion() {
		return txtSelectRegion;
	}

	public WebElement getButtonSave() {
		return btnSave;
	}

	public WebElement getButtonCopyTemplate() {
		return btnCopyTemplate;
	}

	public WebElement getSwitchToFrame() {
		return switchToFrame;
	}

	public WebElement getCheckboxProactive() {
		return chkboxProactive;
	}

	public WebElement getCheckboxBuildingConfidence() {
		return chkboxBuildingConfidence;
	}

	public WebElement getCheckboxConceptualFlexing() {
		return chkboxConceptualFlexing;
	}

	public WebElement getCheckboxConnectEmpathy() {
		return chkboxEmpathy;
	}

	public WebElement getScrollDownNext() {
		return scrollDownNext;
	}

	public WebElement getButtonCopyTemplateNext() {
		return btnCopyTemplateNext;
	}

//	public WebElement getRaterTypeFrame() {
//		return switchToFrameRaterTypes;
//	}

	public WebElement getRaterTypeSelf() {
		return chkboxSelf;
	}

	public WebElement getRaterTypeManager() {
		return chkboxManager;
	}

	public WebElement getRaterTypepeer() {
		return chkboxpeer;
	}

	public WebElement getRaterTypeReport() {
		return chkboxReport;
	}
	
	public WebElement getButtonNextRaterType() {
		return btnNextRaterType;
	}
	
	public WebElement getButtonNextEmailMessage() {
		return btnNextEmailMsg;
	}
	
	public WebElement getButtonNextInstructionTemplates(){
		return btnNextInstructionTemp;
	}
	
	public WebElement getButtonSaveBenchmark(){
		return btnSaveBenchmark;
	}
	
	public WebElement getButtonSurveyUsers(){
		return btnSurveyUser;
	}
	
	public WebElement getButtonSurveyUsersAdd(){
		return btnSurveyUsersAdd;
	}
	

}
