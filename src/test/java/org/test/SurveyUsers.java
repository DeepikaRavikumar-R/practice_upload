package org.test;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;
import java.util.List;
import java.util.concurrent.TimeUnit;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DateUtil;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SurveyUsers extends Baseclass {

	public static void main(String[] args) throws IOException, InterruptedException {
		 surveyUser();

	}

	public static void surveyUser() throws IOException, InterruptedException {
		
		 browserConfigure(); lanuchURL(
		  "https://org3356c1e0.crm4.dynamics.com/main.aspx?appid=c8dc5600-7e89-4955-9641-97822d57f714&pagetype=entitylist&etn=contact&viewid=00000000-0000-0000-00aa-000010001004&viewType=1039"
		  ); windowMaximize(); driver.manage().deleteAllCookies();
		 
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

		
		  SurveyUserObjectManager survey = new SurveyUserObjectManager(); WebElement
		  textUserEmail = survey.getTxtUserEmail(); //JavascriptExecutor js =
		//JavascriptExecutor js =(JavascriptExecutor) driver; 
		  keys(textUserEmail,
		  "deepika.ravikumar@modusetp.com"); WebElement buttonNext =
		  survey.getButtonNext(); buttonNext.click(); WebElement textPassword =
		  survey.getTextPassword(); WebDriverWait wait = new WebDriverWait(driver,
		  Duration.ofSeconds(40));
		  wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("i0118")));
		  keys(textPassword, "Sendeep@1"); WebElement buttonSignin =
		  survey.getButtonSignin(); click(buttonSignin); WebElement buttonYes =
		  survey.getButtonYes(); click(buttonYes);
		 
		System.out.println("survey user method");
		driver.findElement(By.xpath("//div[@title='Survey Users']")).click();
		WebDriverWait waitSurveyUsers = new WebDriverWait(driver, Duration.ofSeconds(50));
		waitSurveyUsers.until(
				ExpectedConditions.elementToBeClickable(By.xpath("//button[@aria-label='New' and @role='menuitem']")));

		File f = new File("C:\\Users\\deepi\\eclipse-workspace\\BehaviourAssessment\\DataFiles\\UserDetails.xlsx");
		FileInputStream fin = new FileInputStream(f);
		Workbook w = new XSSFWorkbook(fin);
		Sheet s = w.getSheet("Sheet1");
		for (int i = 1; i < s.getPhysicalNumberOfRows(); i++) {
			WebElement clickButtonSurveyUSERS = driver
					.findElement(By.xpath("//button[@aria-label='New' and @role='menuitem']"));
			try {

				click(clickButtonSurveyUSERS);
			} catch (StaleElementReferenceException e) {
				clickButtonSurveyUSERS = driver
						.findElement(By.xpath("//button[@aria-label='New' and @role='menuitem']"));
				click(clickButtonSurveyUSERS);
			}

			Row rfirstname = s.getRow(i);

			// Adding FirstName
			String firstName = rfirstname.getCell(0).getStringCellValue();
			System.out.println(firstName);
			WebElement textSurveyFirstname = driver.findElement(By.xpath("//input[@aria-label='First Name']"));
			try {

				textSurveyFirstname.sendKeys(firstName);
			} catch (StaleElementReferenceException e) {
				textSurveyFirstname = driver.findElement(By.xpath("//input[@aria-label='First Name']"));
				textSurveyFirstname.sendKeys(firstName);
			}

			// Adding Lastname
			Row rlastName = s.getRow(i);
			String lastName = rlastName.getCell(1).toString();
			WebElement textSurveyLastname = driver.findElement(By.xpath("//input[@aria-label='Last Name']"));
			try {
				textSurveyLastname.sendKeys(lastName);
			} catch (StaleElementReferenceException e) {
				textSurveyLastname = driver.findElement(By.xpath("//input[@aria-label='Last Name']"));
				textSurveyLastname.sendKeys(lastName);

			}

			// Adding Company
			WebElement buttonSearch = driver
					.findElement(By.xpath("//button[@aria-label='Search records for Company Name, Lookup field']"));
			click(buttonSearch);
			Row rCompanyName = s.getRow(i);
			String companyName = rCompanyName.getCell(2).toString();
			try {
				WebDriverWait waitCompanyName = new WebDriverWait(driver, Duration.ofSeconds(80));
				
				waitCompanyName.until(ExpectedConditions.visibilityOfElementLocated(
						By.xpath("//div[@aria-label='Company Name Lookup results']//child::ul//li")));

				List<WebElement> listItemsCompany = waitCompanyName
						.until(ExpectedConditions.presenceOfAllElementsLocatedBy(
								By.xpath("//div[@aria-label='Company Name Lookup results']//child::ul//li")));
				System.out.println("Company Name " +companyName);
				System.out.println("total number of list" + listItemsCompany.size());
				driver.findElement(By.xpath("//span[contains(.,'" + companyName + "')]")).click();

			} catch (StaleElementReferenceException e) {
				buttonSearch = driver
						.findElement(By.xpath("//button[@aria-label='Search records for Company Name, Lookup field']"));
				click(buttonSearch);
				WebDriverWait waitCompanyName = new WebDriverWait(driver, Duration.ofSeconds(80));
				waitCompanyName.until(ExpectedConditions.visibilityOfElementLocated(
						By.xpath("//div[@aria-label='Company Name Lookup results']//child::ul//li")));

				List<WebElement> listItemsCompany = waitCompanyName
						.until(ExpectedConditions.presenceOfAllElementsLocatedBy(
								By.xpath("//div[@aria-label='Company Name Lookup results']//child::ul//li")));
				System.out.println("total number of list" + listItemsCompany.size());
				driver.findElement(By.xpath("//span[contains(.,'" + companyName + "')]")).click();

			}
			// Adding Email
			Row rEmail = s.getRow(i);
			String valueEmail = rEmail.getCell(3).toString();
			WebElement textEmailId = driver.findElement(By.xpath("//input[@aria-label='Email']"));
			try {
				textEmailId.sendKeys(valueEmail);
			} catch (StaleElementReferenceException e) {
				textEmailId = driver.findElement(By.xpath("//input[@aria-label='Email']"));
				textEmailId.sendKeys(valueEmail);
			}

			// Selecting Gender
			/*
			 * WebElement dropdownGender = survey.getDropdownSurveyUserGender();
			 * click(dropdownGender);
			 */

			/*
			 * WebElement element =
			 * driver.findElement(By.xpath("//input[@aria-label='Region, Lookup']"));
			 * ((JavascriptExecutor)
			 * driver).executeScript("arguments[0].scrollIntoView(true);", element);
			 */
			/*
			 * WebDriverWait waitGender = new WebDriverWait(driver, Duration.ofSeconds(50));
			 * waitGender.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(
			 * "//div[@id='pa-option-set-component-36a025d3-bb6d-4a69-170f-ef7a96ed0a53fluent-listbox2']//div//span"
			 * )));
			 */

			WebElement dropdownFemale = driver.findElement(By.xpath("//button[@aria-label='Gender']"));
			click(dropdownFemale);
			String excelvalGender = rfirstname.getCell(4).getStringCellValue().trim();
			try {
				List<WebElement> listbox = driver.findElements(By.xpath(
						"//div[@class='fui-Listbox fui-Dropdown__listbox ___1lp10z0 fxugw4r f1ewtqcl f22iagw f1vx9l62 f3hsy1e f5zp4f fpvhumw f1yog68k f13sgyd8 f1x4af0m f7x41pl fd55psn fruq291 fiut8dr f1hg901r f1aa9q02 f16jpd5f f1jar5jt fyu767a fbvlk4a']//div"));

				System.out.println("total number of listbox" + listbox.size());

				for (int j = 0; j < listbox.size(); j++) {
					System.out.println(listbox.get(j).getText());
					if (listbox.get(j).getText().contains(excelvalGender)) {
						listbox.get(j).click();
						break;
					}
				}
			} catch (StaleElementReferenceException e) {
				List<WebElement> listbox = driver.findElements(By.xpath(
						"//div[@class='fui-Listbox fui-Dropdown__listbox ___1lp10z0 fxugw4r f1ewtqcl f22iagw f1vx9l62 f3hsy1e f5zp4f fpvhumw f1yog68k f13sgyd8 f1x4af0m f7x41pl fd55psn fruq291 fiut8dr f1hg901r f1aa9q02 f16jpd5f f1jar5jt fyu767a fbvlk4a']//div"));

				System.out.println("total number of listbox" + listbox.size());

				for (int j = 0; j < listbox.size(); j++) {
					System.out.println(listbox.get(j).getText());
					if (listbox.get(j).getText().contains(excelvalGender)) {
						listbox.get(j).click();
						break;
					}
				}

			}

			// Adding Designation

			WebElement btnDesignation = driver.findElement(By.xpath("//button[@aria-label='Designation']"));
			click(btnDesignation);
			String excelvalDesignation = rfirstname.getCell(5).getStringCellValue().trim();
			try {
				System.out.println("Try Block  :" + excelvalDesignation);
				List<WebElement> listDesignations = driver.findElements(By.xpath(
						"//div[@class='fui-Listbox fui-Dropdown__listbox ___1lp10z0 fxugw4r f1ewtqcl f22iagw f1vx9l62 f3hsy1e f5zp4f fpvhumw f1yog68k f13sgyd8 f1x4af0m f7x41pl fd55psn fruq291 fiut8dr f1hg901r f1aa9q02 f16jpd5f f1jar5jt fyu767a fbvlk4a']//div"));
				System.out.println("total number of Designation" + listDesignations.size());
				for (int j = 0; j < listDesignations.size(); j++) {
					System.out.println(listDesignations.get(j).getText());
					if (listDesignations.get(j).getText().contains(excelvalDesignation)) {
						listDesignations.get(j).click();
						break;
					}
				}
			} catch (StaleElementReferenceException e) {
				List<WebElement> listDesignations = driver.findElements(By.xpath(
						"//div[@class='fui-Listbox fui-Dropdown__listbox ___1lp10z0 fxugw4r f1ewtqclf22iagw f1vx9l62 f3hsy1e f5zp4f fpvhumw f1yog68k f13sgyd8 f1x4af0m f7x41plfd55psn fruq291 fiut8dr f1hg901r f1aa9q02 f16jpd5f f1jar5jt fyu767afbvlk4a']//div"));
				System.out.println("total number of Designation" + listDesignations.size());
				for (int j = 0; j < listDesignations.size(); j++) {
					System.out.println(listDesignations.get(j).getText());
					if (listDesignations.get(j).getText().contains(excelvalDesignation)) {
						listDesignations.get(j).click();
						break;
					}
				}

			}
			/*
			 * WebElement scrollLocation = driver.findElement(By.xpath(
			 * "//input[@id='id-1fed44d1-ae68-4a41-bd2b-f13acac4acfa-12-na_locationid270bd3db-d9af-4782-9025-509e298dec0a-na_locationid.fieldControl-LookupResultsDropdown_na_locationid_3_textInputBox_with_filter_new']"
			 * )); ((JavascriptExecutor)
			 * driver).executeScript("arguments[0].scrollIntoView(true);", scrollLocation);
			 */
			// Adding Department

			WebElement searchDepartment = driver
					.findElement(By.xpath("//button[@aria-label='Search records for Department, Lookup field']"));
			click(searchDepartment);

			Row rDepartmentName = s.getRow(i);
			String departmentName = rDepartmentName.getCell(6).toString();

			try {

				WebDriverWait waitDepart = new WebDriverWait(driver, Duration.ofSeconds(50));
				waitDepart.until(ExpectedConditions
						.visibilityOfElementLocated(By.xpath("//div[@aria-label='Department Lookup results']//div")));

				List<WebElement> listItemsDepartment = waitDepart
						.until(ExpectedConditions.presenceOfAllElementsLocatedBy(
								By.xpath("//div[@aria-label='Department Lookup results']//div")));
				System.out.println("total number of list Depart" + listItemsDepartment.size());
				System.out.println("Department Name"+departmentName);
				driver.findElement(By.xpath("//span[contains(.,'" + departmentName + "')]")).click();

			} catch (StaleElementReferenceException e) {
				searchDepartment = driver
						.findElement(By.xpath("//button[@aria-label='Search records for Department, Lookup field']"));
				click(searchDepartment);
				WebDriverWait waitDepart = new WebDriverWait(driver, Duration.ofSeconds(20));
				waitDepart.until(ExpectedConditions
						.visibilityOfElementLocated(By.xpath("//div[@aria-label='Department Lookup results']//div")));

				List<WebElement> listItemsDepartment = waitDepart
						.until(ExpectedConditions.presenceOfAllElementsLocatedBy(
								By.xpath("//div[@aria-label='Department Lookup results']//div")));
				System.out.println("total number of list Depart" + listItemsDepartment.size());
				driver.findElement(By.xpath("//span[contains(.,'" + departmentName + "')]")).click();

			}

			// Adding WorkLevel

			WebElement buttonWorkLevel = driver.findElement(By.xpath("//button[@aria-label='Work Level']"));
			click(buttonWorkLevel);
			String excelvalWorkLevel = rfirstname.getCell(7).getStringCellValue().trim();

			try {

				List<WebElement> listWorkLevel = driver.findElements(By.xpath(
						"//div[@class='fui-Listbox fui-Dropdown__listbox ___1lp10z0 fxugw4r f1ewtqcl f22iagw f1vx9l62 f3hsy1e f5zp4f fpvhumw f1yog68k f13sgyd8 f1x4af0m f7x41pl fd55psn fruq291 fiut8dr f1hg901r f1aa9q02 f16jpd5f f1jar5jt fyu767a fbvlk4a']//div"));
				System.out.println("total number of Designation" + listWorkLevel.size());
				for (int j = 0; j < listWorkLevel.size(); j++) {
					System.out.println(listWorkLevel.get(j).getText());
					if (listWorkLevel.get(j).getText().contains(excelvalWorkLevel)) {
						listWorkLevel.get(j).click();
						break;
					}
				}
			} catch (StaleElementReferenceException e) {
				List<WebElement> listWorkLevel = driver.findElements(By.xpath(
						"//div[@class='fui-Listbox fui-Dropdown__listbox ___1lp10z0 fxugw4r f1ewtqcl f22iagw f1vx9l62 f3hsy1e f5zp4f fpvhumw f1yog68k f13sgyd8 f1x4af0m f7x41pl fd55psn fruq291 fiut8dr f1hg901r f1aa9q02 f16jpd5f f1jar5jt fyu767a fbvlk4a']//div"));
				System.out.println("total number of Designation" + listWorkLevel.size());
				for (int j = 0; j < listWorkLevel.size(); j++) {
					System.out.println(listWorkLevel.get(j).getText());
					if (listWorkLevel.get(j).getText().contains(excelvalWorkLevel)) {
						listWorkLevel.get(j).click();
						break;
					}
				}

			}

			// Adding Region

			WebElement buttonSearchRegion = driver
					.findElement(By.xpath("//button[@aria-label='Search records for Region, Lookup field']"));
			click(buttonSearchRegion);
			Row rRegionName = s.getRow(i);
			String regionName = rRegionName.getCell(8).toString();

			try {

				WebDriverWait waitRegion = new WebDriverWait(driver, Duration.ofSeconds(60));
				waitRegion.until(ExpectedConditions
						.visibilityOfElementLocated(By.xpath("//div[@aria-label='Region Lookup results']//div")));
				List<WebElement> listItemsRegion = waitRegion.until(ExpectedConditions
						.presenceOfAllElementsLocatedBy(By.xpath("//div[@aria-label='Region Lookup results']//div")));
				System.out.println("total number of list Region" + listItemsRegion.size());
				driver.findElement(By.xpath("//span[contains(.,'" + regionName + "')]")).click();

			} catch (StaleElementReferenceException e) {
				buttonSearchRegion = driver
						.findElement(By.xpath("//button[@aria-label='Search records for Region, Lookup field']"));
				click(buttonSearchRegion);
				WebDriverWait waitRegion = new WebDriverWait(driver, Duration.ofSeconds(40));
				waitRegion.until(ExpectedConditions
						.visibilityOfElementLocated(By.xpath("//ul[@aria-label='Lookup results']//div")));
				List<WebElement> listItemsRegion = waitRegion.until(ExpectedConditions
						.presenceOfAllElementsLocatedBy(By.xpath("//ul[@aria-label='Lookup results']//div")));
				System.out.println("total number of list Region" + listItemsRegion.size());
				driver.findElement(By.xpath("//span[contains(.,'" + regionName + "')]")).click();

			}

			// Adding Location

			WebElement buttonSearchLocation = driver
					.findElement(By.xpath("//button[@aria-label='Search records for Location, Lookup field']"));
			click(buttonSearchLocation);
			Row rLocationName = s.getRow(i);
			String locationName = rLocationName.getCell(9).toString();
			try {

				WebDriverWait waitLocation = new WebDriverWait(driver, Duration.ofSeconds(50));
				waitLocation.until(ExpectedConditions
						.visibilityOfElementLocated(By.xpath("//ul[@aria-label='Lookup results']//div")));
				List<WebElement> listItemsLocation = waitLocation.until(ExpectedConditions
						.presenceOfAllElementsLocatedBy(By.xpath("//ul[@aria-label='Lookup results']//div")));
				System.out.println("total number of list Location" + listItemsLocation.size());
				driver.findElement(By.xpath("//span[contains(.,'" + locationName + "')]")).click();

			} catch (StaleElementReferenceException e) {
				buttonSearchLocation = driver
						.findElement(By.xpath("//button[@aria-label='Search records for Location, Lookup field']"));
				click(buttonSearchLocation);
				WebDriverWait waitLocation = new WebDriverWait(driver, Duration.ofSeconds(40));
				waitLocation.until(ExpectedConditions
						.visibilityOfElementLocated(By.xpath("//ul[@aria-label='Lookup results']//div")));
				List<WebElement> listItemsLocation = waitLocation.until(ExpectedConditions
						.presenceOfAllElementsLocatedBy(By.xpath("//ul[@aria-label='Lookup results']//div")));
				System.out.println("total number of list Location" + listItemsLocation.size());
				driver.findElement(By.xpath("//span[contains(.,'" + locationName + "')]")).click();

			} // Adding UserName
			Row surveyUsername = s.getRow(i);
			String userName = surveyUsername.getCell(10).toString();
			System.out.println(userName);
			WebElement textSurveyUsername = driver.findElement(By.xpath("//input[@aria-label='User Name']"));
			try {

				textSurveyUsername.sendKeys(userName);
			} catch (StaleElementReferenceException e) {
				textSurveyUsername = driver.findElement(By.xpath("//input[@aria-label='User Name']"));
				textSurveyUsername.sendKeys(firstName);

			} // Adding Password
			Row surveyPassword = s.getRow(i);
			String passWord = surveyPassword.getCell(11).toString();
			System.out.println(passWord);
			WebElement textSurveyPassword = driver.findElement(By.xpath("//input[@aria-label='Password']"));
			try {

				textSurveyPassword.sendKeys(passWord);
			} catch (StaleElementReferenceException e) {
				textSurveyPassword = driver.findElement(By.xpath("//input[@aria-label='Password']"));
				textSurveyPassword.sendKeys(passWord);

			} // Adding Assessment

			WebElement buttonSearchAssessment = driver
					.findElement(By.xpath("//button[@aria-label='Search records for Assessment, Lookup field']"));
			click(buttonSearchAssessment);
			Row rAssessmentName = s.getRow(i);
			String assessmentName = rAssessmentName.getCell(12).toString();
			try {

				WebDriverWait waitAsses = new WebDriverWait(driver, Duration.ofSeconds(50));
				waitAsses.until(ExpectedConditions
						.visibilityOfElementLocated(By.xpath("//ul[@aria-label='Lookup results']//li")));
				List<WebElement> listItemsAssessment = waitAsses.until(ExpectedConditions
						.presenceOfAllElementsLocatedBy(By.xpath("//ul[@aria-label='Lookup results']//li")));
				System.out.println("total number of list Assessment" + listItemsAssessment.size());
				driver.findElement(By.xpath("//span[contains(.,'" + assessmentName + "')]")).click();

			} catch (StaleElementReferenceException e) {
				buttonSearchAssessment = driver
						.findElement(By.xpath("//button[@aria-label='Search records for Assessment, Lookup field']"));
				click(buttonSearchAssessment);
				WebDriverWait waitAsses = new WebDriverWait(driver, Duration.ofSeconds(40));
				waitAsses.until(ExpectedConditions
						.visibilityOfElementLocated(By.xpath("//ul[@aria-label='Lookup results']//li")));
				List<WebElement> listItemsAssessment = waitAsses.until(ExpectedConditions
						.presenceOfAllElementsLocatedBy(By.xpath("//ul[@aria-label='Lookup results']//li")));
				System.out.println("total number of list Assessment" + listItemsAssessment.size());
				driver.findElement(By.xpath("//span[contains(.,'" + assessmentName + "')]")).click();

			} // Adding Nationality
			Row surveyNationality = s.getRow(i);
			String nationality = surveyNationality.getCell(13).toString();
			System.out.println(nationality);
			WebElement textSurveyNationality = driver.findElement(By.xpath("//input[@aria-label='Nationality']"));
			try {

				textSurveyNationality.sendKeys(nationality);
			} catch (StaleElementReferenceException e) {
				textSurveyNationality = driver.findElement(By.xpath("//input[@aria-label='Nationality']"));
				textSurveyNationality.sendKeys(nationality);

			} // Adding Region
			Row surveyReligion = s.getRow(i);
			String relegion = surveyReligion.getCell(14).toString();
			System.out.println(relegion);
			WebElement textSurveyRelegion = driver.findElement(By.xpath("//input[@aria-label='Region']"));
			try {

				textSurveyRelegion.sendKeys(relegion);
			} catch (StaleElementReferenceException e) {
				textSurveyRelegion = driver.findElement(By.xpath("//input[@aria-label='Region']"));
				textSurveyRelegion.sendKeys(relegion);

			} // Adding Language
			Row surveyLanguage = s.getRow(i);
			String language = surveyLanguage.getCell(15).toString();
			System.out.println(language);
			WebElement textSurveyLanguage = driver.findElement(By.xpath("//input[@aria-label='Language']"));
			try {

				textSurveyLanguage.sendKeys(language);
			} catch (StaleElementReferenceException e) {
				textSurveyLanguage = driver.findElement(By.xpath("//input[@aria-label='Language']"));
				textSurveyLanguage.sendKeys(language);

			}

			// Adding DOB
			Row surveyDOB = s.getRow(i);
			Cell surveyCellDOB = surveyDOB.getCell(16);
			int cellType = surveyCellDOB.getCellType();
			WebElement textSurveyDOB = driver.findElement(By.xpath("//input[@aria-label='Date of DOB']"));

			if (cellType == 1) {
				String surveyDOBCellValue = surveyCellDOB.getStringCellValue();
				System.out.println(surveyDOBCellValue);

				try {

					textSurveyDOB.sendKeys(surveyDOBCellValue);
				} catch (StaleElementReferenceException e) {
					textSurveyDOB = driver.findElement(By.xpath("//input[@aria-label='Date of DOB']"));
					textSurveyDOB.sendKeys(surveyDOBCellValue);
				}
			} else if (cellType == 0) {
				if (DateUtil.isCellDateFormatted(surveyCellDOB)) {
					Date dateCellValue = surveyCellDOB.getDateCellValue();
					SimpleDateFormat sim = new SimpleDateFormat("MM/dd/YYYY");
					String format = sim.format(dateCellValue);
					System.out.print(format);
					try {

						textSurveyDOB.sendKeys(format);
					} catch (StaleElementReferenceException e) {
						textSurveyDOB = driver.findElement(By.xpath("//input[@aria-label='Date of DOB']"));
						textSurveyDOB.sendKeys(format);
					}
				}

			}

			// Adding SubDepartment
			Row surveySubDepartment = s.getRow(i);
			String subDepartment = surveySubDepartment.getCell(18).toString();
			System.out.println(subDepartment);
			WebElement textSurveySubDepartment = driver.findElement(By.xpath("//input[@aria-label='Sub Department']"));
			try {

				textSurveySubDepartment.sendKeys(subDepartment);
			} catch (StaleElementReferenceException e) {
				textSurveySubDepartment = driver.findElement(By.xpath("//input[@aria-label='Sub Department']"));
				textSurveySubDepartment.sendKeys(subDepartment);

			} // Adding Salary

			Row surveySalary = s.getRow(i);
			Cell cell = surveySalary.getCell(19);

			int cellTypeSalary = cell.getCellType(); // System.out.print(cellType);
			if (cellTypeSalary == 1) {
				String salaryCellValue = cell.getStringCellValue();
				System.out.println(salaryCellValue);
				WebElement textSurveySalary = driver.findElement(By.xpath("//input[@aria-label='Salary']"));
				try {

					textSurveySalary.sendKeys(salaryCellValue);
				} catch (StaleElementReferenceException e) {
					textSurveySalary = driver.findElement(By.xpath("//input[@aria-label='Salary']"));
					textSurveySalary.sendKeys(salaryCellValue);
				}
			} else {
				double numericCellValue = cell.getNumericCellValue();
				long l = (long) numericCellValue;
				String value = String.valueOf(l);
				System.out.print("Test" + value);
				WebElement textSurveySalary = driver.findElement(By.xpath("//input[@aria-label='Salary']"));
				try {

					textSurveySalary.sendKeys(value);
				} catch (StaleElementReferenceException e) {
					textSurveySalary = driver.findElement(By.xpath("//input[@aria-label='Salary']"));
					textSurveySalary.sendKeys(value);

				}
			} // Adding Employement Status

			Row surveyEmployementStatus = s.getRow(i);
			String employementStatus = surveyEmployementStatus.getCell(20).toString();
			System.out.println(employementStatus);
			WebElement textSurveyEmploymentStatus = driver
					.findElement(By.xpath("//input[@aria-label='Employment Status']"));
			try {

				textSurveyEmploymentStatus.sendKeys(employementStatus);
			} catch (StaleElementReferenceException e) {
				textSurveyEmploymentStatus = driver.findElement(By.xpath("//input[@aria-label='Employment Status']"));
				textSurveyEmploymentStatus.sendKeys(employementStatus);

			} // Adding Tenure
			Row surveyTenure = s.getRow(i);
			Cell cellTenure = surveyTenure.getCell(21);

			int cellTypeTenure = cellTenure.getCellType();
			if (cellTypeTenure == 1) {
				String tenureCellValue = cellTenure.getStringCellValue();
				System.out.println(tenureCellValue);
				WebElement textSurveyTenure = driver.findElement(By.xpath("//input[@aria-label='Tenure ']"));
				try {

					textSurveyTenure.sendKeys(tenureCellValue);
				} catch (StaleElementReferenceException e) {
					textSurveyTenure = driver.findElement(By.xpath("//input[@aria-label='Tenure ']"));
					textSurveyTenure.sendKeys(tenureCellValue);
				}
			} else {
				double numericCellValue = cell.getNumericCellValue();
				long l = (long) numericCellValue;
				String valueOf = String.valueOf(l);
				System.out.print(valueOf);

			} // Adding Start Date

			Row surveyStartDate = s.getRow(i);
			Cell surveyCellStartDate = surveyStartDate.getCell(22);
			int cellTypeStartDate = surveyCellStartDate.getCellType();
			WebElement textSurveyStartDate = driver.findElement(By.xpath("//input[@aria-label='Date of Start Date']"));

			if (cellTypeStartDate == 1) {
				String surveyStartDateValue = surveyCellStartDate.getStringCellValue();
				System.out.println(surveyStartDateValue);

				try {

					textSurveyStartDate.sendKeys(surveyStartDateValue);
				} catch (StaleElementReferenceException e) {
					textSurveyStartDate = driver.findElement(By.xpath("//input[@aria-label='Date of Start Date']"));
					textSurveyStartDate.sendKeys(surveyStartDateValue);
				}
			} else if (cellTypeStartDate == 0) {
				if (DateUtil.isCellDateFormatted(surveyCellStartDate)) {
					Date dateValue = surveyCellStartDate.getDateCellValue();
					SimpleDateFormat sim = new SimpleDateFormat("MM/dd/YYYY");
					String formatStartDate = sim.format(dateValue);
					System.out.print(formatStartDate);
					try {

						textSurveyStartDate.sendKeys(formatStartDate);
					} catch (StaleElementReferenceException e) {
						textSurveyStartDate = driver.findElement(By.xpath("//input[@aria-label='Date of DOB']"));
						textSurveyStartDate.sendKeys(formatStartDate);
					}
				}

			}

			// Adding Reports To
			Row surveyReportsTo = s.getRow(i);
			String reportsTo = surveyReportsTo.getCell(23).toString();
			System.out.println(reportsTo);
			WebElement textSurveyReportsTo = driver.findElement(By.xpath("//input[@aria-label='Reports To']"));
			try {

				textSurveyReportsTo.sendKeys(reportsTo);
			} catch (StaleElementReferenceException e) {
				textSurveyReportsTo = driver.findElement(By.xpath("//input[@aria-label='Reports To']"));
				textSurveyReportsTo.sendKeys(reportsTo);

			} // Adding Top Level Reports To
			Row surveyTopReportsTo = s.getRow(i);
			String topReportsTo = surveyTopReportsTo.getCell(24).toString();
			System.out.println(topReportsTo);
			WebElement textSurveyTopLevelReportsTo = driver
					.findElement(By.xpath("//input[@aria-label='Top Level Reports To']"));
			try {

				textSurveyTopLevelReportsTo.sendKeys(topReportsTo);
			} catch (StaleElementReferenceException e) {
				textSurveyTopLevelReportsTo = driver
						.findElement(By.xpath("//input[@aria-label='Top Level Reports To']"));
				textSurveyTopLevelReportsTo.sendKeys(topReportsTo);

			}

			// Adding Leadership Team
			WebElement buttonSearchLeadershipTeam = driver
					.findElement(By.xpath("//button[@aria-label='Search records for Leadership Team, Lookup field']"));
			click(buttonSearchLeadershipTeam);
			Row rLeadershipTeam = s.getRow(i);
			String LeadershipTeam = rLeadershipTeam.getCell(25).toString();
			System.out.println("leadershipteam name" + LeadershipTeam);

			try {

				WebDriverWait waitLeadershipTeam = new WebDriverWait(driver, Duration.ofSeconds(60));
				waitLeadershipTeam.until(ExpectedConditions
						.visibilityOfElementLocated(By.xpath("//ul[@aria-label='Lookup results']//div")));
				List<WebElement> listItemsLeadershipTeam = waitLeadershipTeam.until(ExpectedConditions
						.presenceOfAllElementsLocatedBy(By.xpath("//ul[@aria-label='Lookup results']//div")));
				System.out.println("total number of Leadership Team " + listItemsLeadershipTeam.size());
				driver.findElement(By.xpath("//span[contains(.,'" + LeadershipTeam + "')]")).click();

			} catch (StaleElementReferenceException e) {
				buttonSearchRegion = driver
						.findElement(By.xpath("//button[@aria-label='Search records for Region, Lookup field']"));
				click(buttonSearchRegion);
				WebDriverWait waitRegion = new WebDriverWait(driver, Duration.ofSeconds(40));
				waitRegion.until(ExpectedConditions
						.visibilityOfElementLocated(By.xpath("//ul[@aria-label='Lookup results']//div")));
				List<WebElement> listItemsLeadershipTeam = waitRegion.until(ExpectedConditions
						.presenceOfAllElementsLocatedBy(By.xpath("//ul[@aria-label='Lookup results']//div")));
				System.out.println("total number of Leadership Team " + listItemsLeadershipTeam.size());
				driver.findElement(By.xpath("//span[contains(.,'" + LeadershipTeam + "')]")).click();

			}

			// Adding Team Number
			/*
			 * Row surveyTeamNo = s.getRow(i); Cell LeaderTeamNo = surveyTeamNo.getCell(26);
			 * 
			 * int cellTypeLeaderTeamNumber = LeaderTeamNo.getCellType(); if
			 * (cellTypeLeaderTeamNumber == 1) { String leaderTeamNoCell =
			 * LeaderTeamNo.getStringCellValue(); System.out.println(leaderTeamNoCell);
			 * WebElement textSurveyLeaderTeamNumber = driver
			 * .findElement(By.xpath("//input[@aria-label='Leader Number']")); try {
			 * 
			 * textSurveyLeaderTeamNumber.sendKeys(leaderTeamNoCell); } catch
			 * (StaleElementReferenceException e) { textSurveyLeaderTeamNumber =
			 * driver.findElement(By.xpath("//input[@aria-label='Leader Number']"));
			 * textSurveyLeaderTeamNumber.sendKeys(leaderTeamNoCell); }
			 * 
			 * } else { double numericCellValue = LeaderTeamNo.getNumericCellValue(); long l
			 * = (long) numericCellValue; String valueTeamNumber = String.valueOf(l);
			 * System.out.print("Test" + valueTeamNumber); WebElement
			 * textSurveyLeaderTeamNumber = driver
			 * .findElement(By.xpath("//input[@aria-label='Leader Number']")); try {
			 * 
			 * textSurveyLeaderTeamNumber.sendKeys(valueTeamNumber); } catch
			 * (StaleElementReferenceException e) { textSurveyLeaderTeamNumber =
			 * driver.findElement(By.xpath("//input[@aria-label='Leader Number']"));
			 * textSurveyLeaderTeamNumber.sendKeys(valueTeamNumber); }
			 * 
			 * }
			 */
			// Adding Remote

			Row remoteWork = s.getRow(i);
			String remoteWorkValue = remoteWork.getCell(27).toString();
			System.out.println(remoteWorkValue);
			WebElement textSurveyRemotework = driver.findElement(By.xpath("//input[@aria-label='Remote Work']"));
			try {

				textSurveyRemotework.sendKeys(remoteWorkValue);
			} catch (StaleElementReferenceException e) {
				textSurveyRemotework = driver.findElement(By.xpath("//input[@aria-label='Remote Work']"));
				textSurveyRemotework.sendKeys(remoteWorkValue);

			}

			// Adding Other
			Row rowOther = s.getRow(i);
			String valueOther = rowOther.getCell(28).toString();
			System.out.println(valueOther);
			WebElement textSurveyOther = driver.findElement(By.xpath("//input[@aria-label='Other']"));
			try {

				textSurveyOther.sendKeys(valueOther);
			} catch (StaleElementReferenceException e) {
				textSurveyOther = driver.findElement(By.xpath("//input[@aria-label='Other']"));
				textSurveyOther.sendKeys(valueOther);

			}

			// Adding TFother

			Row rowTFother = s.getRow(i);
			String valueTFother = rowTFother.getCell(29).toString();
			System.out.println(valueTFother);
			WebElement textSurveyTFother = driver.findElement(By.xpath("//input[@aria-label='TFother']"));
			try {

				textSurveyTFother.sendKeys(valueTFother);
			} catch (StaleElementReferenceException e) {
				textSurveyTFother = driver.findElement(By.xpath("//input[@aria-label='TFother']"));
				textSurveyTFother.sendKeys(valueTFother);

			}

			// Saving User
			WebElement buttonSaveCloseUser = driver.findElement(By.xpath("//button[@aria-label='Save & Close']"));
			try {

				WebDriverWait waitSave = new WebDriverWait(driver, Duration.ofSeconds(40));
				waitSave.until(ExpectedConditions
						.visibilityOfElementLocated(By.xpath("//button[@aria-label='Save & Close']")));
				click(buttonSaveCloseUser);
			} catch (StaleElementReferenceException e) {
				WebDriverWait waitSave = new WebDriverWait(driver, Duration.ofSeconds(40));
				waitSave.until(ExpectedConditions
						.visibilityOfElementLocated(By.xpath("//button[@aria-label='Save & Close']")));
				buttonSaveCloseUser = driver.findElement(By.xpath("//button[@aria-label='Save & Close']"));
				click(buttonSaveCloseUser);

			}
			Thread.sleep(3000);
		}

		File fileHierarchy = new File(
				"C:\\Users\\deepi\\eclipse-workspace\\BehaviourAssessment\\DataFiles\\UserHierarchyTemplate.xlsx");
		FileInputStream fileHierarchyInputStream = new FileInputStream(fileHierarchy);
		Workbook workbookHierarchy = new XSSFWorkbook(fileHierarchyInputStream);
		Sheet sheetHierarchy = workbookHierarchy.getSheet("User_Hierarchy");

		for (int j = 1; j < sheetHierarchy.getPhysicalNumberOfRows(); j++) {
			Row rowUserName = sheetHierarchy.getRow(j);
			// System.out.println("Excel username :"+rowUserName );
			String userName = rowUserName.getCell(0).getStringCellValue().trim();
			System.out.println("USERNAME :" + userName);

			driver.findElement(By.xpath("//a[contains(.,'" + userName + "')]")).click();
			driver.findElement(By.xpath("//button[@aria-label='More commands for Survey User Hierarchy']")).click();

			driver.findElement(By.xpath("//button[@aria-label='New Survey User Hierarchy. Add New Survey User Hierarchy']")).click();
			System.out.println("no of coloumns : " + sheetHierarchy.getRow(j).getPhysicalNumberOfCells());
			System.out.println("Test :" + sheetHierarchy.getRow(j).getPhysicalNumberOfCells());

			// Adding Name
			for (int k = 0; k < sheetHierarchy.getRow(0).getPhysicalNumberOfCells(); k++) {

				Row rowUser = sheetHierarchy.getRow(j);
				System.out.println("Excel Test :" + rowUser.getCell(k));
				if (rowUser.getCell(k) != null) {
					WebElement textUserHierarchyFirstname = driver.findElement(By.xpath("//input[@aria-label='Name']"));
					String hierarchyUserName = rowUser.getCell(k).getStringCellValue().trim();
					System.out.println("Hierrchy User Name : " + hierarchyUserName);
					
					/*if (driver.findElement(By.xpath("//span[contains(text(),'How do you like')]")).isDisplayed()) {

						driver.findElement(By.xpath("//button[@aria-label='Close']")).click();

					}*/

					try {
						textUserHierarchyFirstname.sendKeys(hierarchyUserName);
					} catch (StaleElementReferenceException e) {
						textUserHierarchyFirstname = driver.findElement(By.xpath("//input[@aria-label='Name']"));
						textUserHierarchyFirstname.sendKeys(hierarchyUserName);
					}
                // Adding RaterType
					WebDriverWait waitRaterType = new WebDriverWait(driver, Duration.ofSeconds(60));
					waitRaterType.until(ExpectedConditions
							.visibilityOfElementLocated(By.xpath("//button[@aria-label='Search records for Rater Type, Lookup field']")));
					WebElement searchHierarchyRaterTypes = driver.findElement(
							By.xpath("//button[@aria-label='Search records for Rater Type, Lookup field']"));
					searchHierarchyRaterTypes.click();

					try {

						String raterType = sheetHierarchy.getRow(0).getCell(k).getStringCellValue()
								.replaceAll("[0-9]", "").trim();
						driver.findElement(By.xpath("//span[contains(.,'" + raterType + "')]")).click();



					} catch (StaleElementReferenceException e) {

						String raterType = sheetHierarchy.getRow(0).getCell(k).getStringCellValue()
								.replaceAll("[0-9]", "").trim();
						driver.findElement(By.xpath("//span[contains(.,'" + raterType + "')]")).click();

					}

					// Adding RaterUser
					WebElement raterUser = driver.findElement(
							By.xpath("//button[@aria-label='Search records for Rater User, Lookup field']"));
                         String raterUserType=hierarchyUserName;
                         System.out.println("Testtt"+raterUserType);
					// Row rRaterUser = s.getRow(j);

					try {
						click(raterUser);
						driver.findElement(By.xpath("//span[contains(.,'" + raterUserType + "')]")).click();
						// Save and Close Action
						WebElement buttonSaveClose = driver.findElement(By.xpath("//button[@aria-label='Save & Close']"));
						click(buttonSaveClose);

					} catch (StaleElementReferenceException e) {

						click(raterUser);
						driver.findElement(By.xpath("//span[contains(.,'" + raterUserType + "')]")).click();
						// Save and Close Action
						WebElement buttonSaveClose = driver.findElement(By.xpath("//button[@aria-label='Save & Close']"));
						click(buttonSaveClose);

					}

					
					
					// addUser = false;

					if (k < sheetHierarchy.getRow(0).getPhysicalNumberOfCells() - 1) {

					/*	if (driver.findElement(By.xpath("//h1[contains(.,'Discard suggestions?')]")).isDisplayed()) {

							driver.findElement(By.xpath("//div[contains(text(),'Continue')]")).click();

						}*/
						/*if (driver.findElement(By.xpath("//span[contains(.,'Copilot')]")).isDisplayed()) {

							driver.findElement(By.xpath("(//button[@aria-label='Copilot'])[2]")).click();

						}*/
						try {

							driver.findElement(By.xpath(
									"//button[@aria-label='New Survey User Hierarchy. Add New Survey User Hierarchy']"))
									.click();

						} catch (StaleElementReferenceException e) {

							driver.findElement(By.xpath(
									"//button[@aria-label='New Survey User Hierarchy. Add New Survey User Hierarchy']"))
									.click();
						}

					} else {
						System.out.println("Sample 1");
						Thread.sleep(1000);
						try {
							driver.findElement(By.xpath("//button[@aria-label='Press Enter to go back.']")).click();
						} catch (StaleElementReferenceException e) {
							driver.findElement(By.xpath("//button[@aria-label='Press Enter to go back.']")).click();

						}

					}
				}
			}
		}

	}

}
