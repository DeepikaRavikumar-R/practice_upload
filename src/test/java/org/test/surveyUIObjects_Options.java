package org.test;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class surveyUIObjects_Options extends Baseclass {

	public surveyUIObjects_Options() {
		PageFactory.initElements(driver, this);
	}

	
    
    @CacheLookup
    @FindBy(id="nextInstr")
    WebElement nextInstr;
    @CacheLookup
    @FindBy(xpath="//div[@id=1]")
    WebElement professionalButton;
    @CacheLookup
    @FindBy(xpath="//div[@id=2]")
    WebElement teamLeaderButton;
    @CacheLookup
    @FindBy(xpath="//div[@id=3]")
    WebElement headOfUnitButton;
    @CacheLookup
    @FindBy(xpath="//div[@id=4]")
    WebElement directorButton;
    @CacheLookup
    @FindBy(xpath="//div[@id=5]")
    WebElement CEOButton;
    @CacheLookup
    @FindBy(xpath="//div[@id=6]")
    WebElement globalCEOButton; 
    @CacheLookup
    @FindBy(xpath="//label[@for='agreemntCheck']")
    WebElement ackCheckBox;
//    @CacheLookup
//    @FindBy(xpath="//input[@type='checkbox']")
//    WebElement checkUserMulti;
//    @CacheLookup
//    @FindBy(id="agreemntCheck")
//    WebElement ackCheckBoxMulti;
    @CacheLookup
    @FindBy(id="startButton")
    WebElement startAssmnt;
    @CacheLookup
    @FindBy(xpath="//div[@class='progressbar']")
   List< WebElement> progressBar;
    
    @CacheLookup
    @FindBy(id="nextButton")
    WebElement nextButton;
    
  

    
	
	public WebElement getNextInstrButton() {
		return nextInstr;
	}


	public WebElement getProfessionalButton() {
		return professionalButton;
	}
	
	public WebElement getTeamLeaderButton() {
		return teamLeaderButton;
	}

	
	public WebElement getHeadOfUnitButton() {
		return headOfUnitButton;
	}
	
	public WebElement getDirectorButton() {
		return directorButton;
	}
	public WebElement getCEOButton() {
		return CEOButton;
	}
	public WebElement getGlobalCEOButton() {
		return globalCEOButton;
	}
	
	public WebElement getAckCheckBox() {
		return ackCheckBox;
	}
	public WebElement getAckCheckBoxMulti() {
		return  driver.findElement(By.id("agreemntCheck"));
	}
	
	public WebElement getStartAssessmentButton() {
		return startAssmnt;
	}
	
	public List< WebElement> getProgressBar() {
		return progressBar;
	}
	public WebElement getNextButton() {
		return nextButton;
	}
	
	
	public WebElement getCheckUserMulti() {
		return driver.findElement(By.xpath("//input[@type='checkbox']"));
	}
	
	}
