package org.test;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.time.LocalDate;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.openqa.selenium.By;
import org.openqa.selenium.ElementClickInterceptedException;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class survey3 extends Baseclass {

	public static void main(String[] args) throws InterruptedException, IOException {
		}
public static void surveySetup() throws InterruptedException, IOException {
	System.out.println("Survey method");
	String surveyNameforDB;

	/*	browserConfigure();
		driver.get(
				"https://org3356c1e0.crm4.dynamics.com/main.aspx?appid=c8dc5600-7e89-4955-9641-97822d57f714&pagetype=entitylist&etn=cba_survey&viewid=bd1b7aab-e3b2-4cf9-aba8-13ead4b62e12&viewType=1039");*/
		// driver.manage().window().maximize();
		windowMaximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));

		CompleteObjectManagerSurvey lc = new CompleteObjectManagerSurvey();
		/*WebElement textUserEmail = lc.getTxtUserEmail();
		JavascriptExecutor js = (JavascriptExecutor) driver;
		keys(textUserEmail, "vishal.nayak@modusetp.com");
		WebElement buttonNext = lc.getButtonNext();
		buttonNext.click();
		WebElement textPassword = lc.getTextPassword();
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(40));
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("i0118")));
		keys(textPassword, "");
		WebElement buttonSignin = lc.getButtonSignin();
		click(buttonSignin);
		WebElement buttonYes = lc.getButtonYes();
		click(buttonYes);*/

		// try {
		FileInputStream excelFile = new FileInputStream("C:\\Users\\deepi\\eclipse-workspace\\BehaviourAssessment\\DataFiles\\survey.xlsx");
		Workbook workbook = new XSSFWorkbook(excelFile);
		Sheet datatypeSheet = workbook.getSheetAt(0);

		// Assuming the structure is: survey name in cell 0, company name in cell 1,
		// scheduled date in cell 2
		for (int i = 1; i <= datatypeSheet.getLastRowNum(); i++) {
			Row currentRow = datatypeSheet.getRow(i);
			Cell surveyNameCell = currentRow.getCell(0);
			Cell companyNameCell = currentRow.getCell(1);
			Cell scheduledDateCell = currentRow.getCell(2);
			Cell designation=currentRow.getCell(3);

			if (surveyNameCell != null && companyNameCell != null && scheduledDateCell != null) {
				String surveyName = surveyNameCell.getStringCellValue();
				String companyName = companyNameCell.getStringCellValue();
				String scheduledDate = scheduledDateCell.getStringCellValue();
				String designationString=designation.getStringCellValue().trim();
				String[] designationArray=designationString.split(",");
				// Navigate to the menu where you want to input data
				// Assuming there's a menu item with id "surveyMenu" to navigate to the survey
				// page
				System.out.println(surveyName);
				WebElement surveyButton = lc.getButtonSurvey();
				try {

					click(surveyButton);
				} catch (ElementClickInterceptedException e) {
					surveyButton = lc.getButtonSurvey();
					clickWithJavaScript(surveyButton);
				}
				WebElement newSurveyButton = driver.findElement(By.xpath("//button[@aria-label='New']"));
				try {
					click(newSurveyButton);
				} catch (StaleElementReferenceException e) {
					newSurveyButton = lc.getNewSurveyButton();
					click(newSurveyButton);
				}

				// Find input fields and input data
				WebElement textSurveyName = lc.getSurveyNameText();
				keys(textSurveyName, surveyName);

				WebElement textCompanyName = lc.getCompanyNameText();
				// Thread.sleep(4000);
				textCompanyName.clear();
				keys(textCompanyName, companyName);// Multi Test Company,Test Unique Account
				Thread.sleep(5000);
				textCompanyName.sendKeys(Keys.ENTER);
				Thread.sleep(1500);
				WebElement designationDrop=driver.findElement(By.xpath("//button[@class='msos-caret-button']"));
				try {
					designationDrop.click();
				} catch (ElementClickInterceptedException e) {
					textCompanyName.sendKeys(Keys.ENTER);
					Thread.sleep(1500);
					designationDrop.click();
			
				}
				//List<WebElement> designationList=driver.findElements(By.xpath("//ul/li[@class='msos-option']"));
				for(int k=0;k<designationArray.length;k++) {
					clickWithJavaScript(driver.findElement(By.xpath("//ul/li[@class='msos-option']/label[@title='"+designationArray[k]+"']")));
					
				}
				designationDrop.click();
				WebElement schDate = lc.getSchDate();

				schDate.sendKeys(scheduledDate);
				Thread.sleep(1000); 
				
				
				//driver.switchTo().frame("WebResource_SelectTraits");
				WebElement iframe = driver.findElement(By.id("WebResource_SelectTraits"));
				try {
					driver.switchTo().frame(iframe);
				} catch (StaleElementReferenceException e) {
					// TODO Auto-generated catch block
					iframe=driver.findElement(By.id("WebResource_SelectTraits"));
					driver.switchTo().frame(iframe);
					
				}
System.out.println("switched to behavioral types iframe");

				WebElement drop = driver
						.findElement(By.xpath("(//div[@class='chosen-container chosen-container-multi'])[1]"));
				drop.click();                
				List<WebElement> listItemsTraits = driver
						.findElements((By.xpath("(//div[@class='chosen-drop'])[1]//li")));

				System.out.println("\n" + listItemsTraits.size());

				System.out.println("\n" + listItemsTraits.size());

				for (int j = 0; j < listItemsTraits.size(); j++) {
					try {
						if (j != 0) {
							drop.click();
						}
						listItemsTraits = driver.findElements(By.xpath("(//div[@class='chosen-drop'])[1]//li"));

						driver.findElement(By.xpath("//li[contains(.,'" + listItemsTraits.get(j).getText() + "')]"))
								.click();

					}

					catch (StaleElementReferenceException e) {
						if (j != 0) {
							drop.click();
						}
						listItemsTraits = driver.findElements(By.xpath("(//div[@class='chosen-drop'])[1]//li"));

						driver.findElement(By.xpath("//li[contains(.,'" + listItemsTraits.get(j).getText() + "')]"))
								.click();

					}

				}

				// Switching back to the main window

				driver.switchTo().defaultContent();

				//driver.switchTo().frame("WebResource_selectsurveytypes");
				WebElement iframe2 = driver.findElement(By.id("WebResource_selectsurveytypes"));
			
				try {
					driver.switchTo().frame(iframe2);
				} catch (StaleElementReferenceException e) {
					// TODO Auto-generated catch block
					iframe2=driver.findElement(By.id("WebResource_selectsurveytypes"));
					driver.switchTo().frame(iframe2);
				}

				WebElement drop2 = driver
						.findElement(By.xpath("(//div[@class='chosen-container chosen-container-multi'])[1]"));
				drop2.click();
				List<WebElement> listItemsTypes = driver.findElements(By.xpath("(//div[@class='chosen-drop'])[1]//li"));

				System.out.println("\n" + listItemsTypes.size());
				for (int j = 0; j < listItemsTypes.size(); j++) {
					try {
						if (j != 0) {

							drop2.click();
						}

						listItemsTypes = driver.findElements(By.xpath("(//div[@class='chosen-drop'])[1]//li"));

						driver.findElement(By.xpath("//li[contains(.,'" + listItemsTypes.get(j).getText() + "')]"))
								.click();

					}

					catch (StaleElementReferenceException e) {
						if (j != 0) {
							drop2.click();
						}
						listItemsTypes = driver.findElements(By.xpath("(//div[@class='chosen-drop'])[1]//li"));

						driver.findElement(By.xpath("//li[contains(.,'" + listItemsTypes.get(j).getText() + "')]"))
								.click();

					}

				}
				driver.switchTo().defaultContent();

				WebElement saveSurveyButton = lc.getSaveSurveyButton();
				click(saveSurveyButton);
				WebElement sendSurveyButton = lc.getSendSurvey();
				click(sendSurveyButton);

				surveyNameforDB=surveyName;		}
		}
		//workbook.close();
		//survey link extraction from DB() 
		surveyUIDiffOptions sui=new surveyUIDiffOptions();
		sui.surveyUI();
	}// catch (IOException e) {
		// e.printStackTrace();


}
	

