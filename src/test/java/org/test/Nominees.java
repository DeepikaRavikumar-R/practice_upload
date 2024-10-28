package org.test;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.Duration;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Nominees extends Baseclass {

	public static void main(String[] args) {

	}

	public  void nomineeUsers() throws IOException, InterruptedException {
		/*
		 * browserConfigure(); lanuchURL(
		 * "https://org3356c1e0.crm4.dynamics.com/main.aspx?appid=c8dc5600-7e89-4955-9641-97822d57f714&forceUCI=1&pagetype=entitylist&etn=cba_nominee&viewid=736c2035-cebd-4542-ad43-5fa973429194&viewType=1039"
		 * );
		 */
		windowMaximize();
		//driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);

		/*
		 * NomineesObjectManager nominee = new NomineesObjectManager(); WebElement
		 * textUserEmail = nominee.getTxtUserEmail(); keys(textUserEmail,
		 * "deepika.ravikumar@modusetp.com"); WebElement buttonNext =
		 * nominee.getButtonNext(); buttonNext.click(); WebElement textPassword =
		 * nominee.getTextPassword(); WebDriverWait wait = new WebDriverWait(driver,
		 * Duration.ofSeconds(40));
		 * wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("i0118")));
		 * keys(textPassword, "Sendeep@1"); WebElement buttonSignin =
		 * nominee.getButtonSignin(); click(buttonSignin); WebElement buttonYes =
		 * nominee.getButtonYes(); click(buttonYes);
		 */
		System.out.println("Nominee method");
		driver.findElement(By.xpath("//div[@title='Nominees']")).click();
		File f = new File("C:\\Users\\deepi\\eclipse-workspace\\BehaviourAssessment\\DataFiles\\Nominees.xlsx");
		FileInputStream fin = new FileInputStream(f);
		Workbook w = new XSSFWorkbook(fin);
		Sheet s = w.getSheet("Sheet1");

		for (int i = 1; i < s.getPhysicalNumberOfRows(); i++) {
			WebElement buttonAddNew = driver.findElement(By.xpath("//button[@aria-label='New']"));
			try {
				click(buttonAddNew);
			} catch (StaleElementReferenceException e) {
				buttonAddNew = driver.findElement(By.xpath("//button[@aria-label='New']"));
				click(buttonAddNew);
			}

			System.out.println(1);
			Row rfirstname = s.getRow(i);

			// Adding FirstName

			String firstName = rfirstname.getCell(0).toString().trim();
			System.out.println(firstName);

			WebElement textNomineeFirstname = driver.findElement(By.xpath("//input[@aria-label='First Name']"));
			try {

				textNomineeFirstname.sendKeys(firstName);
				textNomineeFirstname.clear();
			} catch (StaleElementReferenceException e) {
				textNomineeFirstname = driver.findElement(By.xpath("//input[@aria-label='First Name']"));
				textNomineeFirstname.sendKeys(firstName);

			}

			// Adding LastName

			Row nomineeLastname = s.getRow(i);
			String lastnameNominee = nomineeLastname.getCell(1).toString().trim();
			System.out.println(lastnameNominee);
			WebElement textNomineeLastname = driver.findElement(By.xpath("//input[@aria-label='Last Name']"));
			try {

				textNomineeLastname.sendKeys(lastnameNominee);
			} catch (StaleElementReferenceException e) {
				textNomineeLastname = driver.findElement(By.xpath("//input[@aria-label='Last Name']"));
				textNomineeLastname.sendKeys(lastnameNominee);

			}

			// Adding Email

			Row nomineeEmail = s.getRow(i);
			String emailNominee = nomineeEmail.getCell(2).toString().trim();
			System.out.println(emailNominee);
			WebElement textNomineeEmail = driver.findElement(By.xpath("//input[@aria-label='Email']"));
			try {

				textNomineeEmail.sendKeys(emailNominee);
			} catch (StaleElementReferenceException e) {
				textNomineeEmail = driver.findElement(By.xpath("//input[@aria-label='Email']"));
				textNomineeEmail.sendKeys(emailNominee);

			}

			// Adding Designation

			WebElement buttonDropdown = driver.findElement(By.xpath("//button[@aria-label='Designation']"));
			click(buttonDropdown);
			Row nomineeDesignation = s.getRow(i);
			String designation = nomineeDesignation.getCell(3).getStringCellValue().trim();

			try {

				System.out.println("Excel Value :" + designation);
				List<WebElement> listDesignations = driver.findElements(By.xpath(
						"//div[@class='fui-Listbox fui-Dropdown__listbox ___1lp10z0 fxugw4r f1ewtqcl f22iagw f1vx9l62 f3hsy1e f5zp4f fpvhumw f1yog68k f13sgyd8 f1x4af0m f7x41pl fd55psn fruq291 fiut8dr f1hg901r f1aa9q02 f16jpd5f f1jar5jt fyu767a fbvlk4a']//div"));
				System.out.println("total number of Designation" + listDesignations.size());
				for (int j = 0; j < listDesignations.size(); j++) {

					System.out.println(listDesignations.get(j).getText());
					if (listDesignations.get(j).getText().contains(designation)) {
						listDesignations.get(j).click();
						break;

					}

				}
			} catch (StaleElementReferenceException e) {
				buttonDropdown = driver.findElement(By.xpath("//button[@aria-label='Designation']"));
				click(buttonDropdown);
				List<WebElement> listDesignations = driver.findElements(By.xpath(
						"//div[@class='fui-Listbox fui-Dropdown__listbox ___1lp10z0 fxugw4r f1ewtqcl f22iagw f1vx9l62 f3hsy1e f5zp4f fpvhumw f1yog68k f13sgyd8 f1x4af0m f7x41pl fd55psn fruq291 fiut8dr f1hg901r f1aa9q02 f16jpd5f f1jar5jt fyu767a fbvlk4a']//div"));
				System.out.println("total number of Designation" + listDesignations.size());
				for (int j = 0; j < listDesignations.size(); j++) {
					System.out.println(listDesignations.get(j).getText());
					if (listDesignations.get(j).getText().contains(designation)) {
						listDesignations.get(j).click();
						break;

					}

				}
			}

			// Adding Company

			WebElement buttonNomineeSearchCompany = driver
					.findElement(By.xpath("//button[@aria-label='Search records for Company, Lookup field']"));
			click(buttonNomineeSearchCompany);

			Row nomineeCompany = s.getRow(i);
			String companyvalue = nomineeCompany.getCell(4).getStringCellValue().trim();

			try {
				System.out.println(companyvalue);
				driver.findElement(By.xpath("//span[contains(.,'" + companyvalue + "')]")).click();

			} catch (StaleElementReferenceException e) {
				buttonNomineeSearchCompany = driver
						.findElement(By.xpath("//button[@aria-label='Search records for Company, Lookup field']"));
				click(buttonNomineeSearchCompany);

				driver.findElement(By.xpath("//span[contains(.,'" + companyvalue + "')]")).click();

			}

			// Adding Assessment

			WebElement buttonNomineeSearchAssessment = driver
					.findElement(By.xpath("//button[@aria-label='Search records for Assessment, Lookup field']"));
			click(buttonNomineeSearchAssessment);
			Row nomineeAssessment = s.getRow(i);
			String Assessmentvalue = nomineeAssessment.getCell(5).getStringCellValue().trim();
			try {

				driver.findElement(By.xpath("//span[contains(.,'" + Assessmentvalue + "')]")).click();

			} catch (StaleElementReferenceException e) {
				buttonNomineeSearchAssessment = driver
						.findElement(By.xpath("//button[@aria-label='Search records for Assessment, Lookup field']"));
				click(buttonNomineeSearchAssessment);

				driver.findElement(By.xpath("//span[contains(.,'" + Assessmentvalue + "')]")).click();

			}

			// Adding NomineeType

			WebElement buttonSearchNominee = driver
					.findElement(By.xpath("//button[@aria-label='Search records for Nominee Type, Lookup field']"));
			click(buttonSearchNominee);
			Row nomineeType = s.getRow(i);
			String nomineeValue = nomineeType.getCell(6).getStringCellValue().trim();
			try {

				driver.findElement(By.xpath("//span[contains(.,'" + nomineeValue + "')]")).click();
				/*
				 * if
				 * (driver.findElement(By.xpath("//span[contains(.,'Copilot')]")).isDisplayed())
				 * {
				 * 
				 * driver.findElement(By.xpath("(//button[@aria-label='Copilot'])[2]")).click();
				 * 
				 * }
				 */

			} catch (StaleElementReferenceException e) {
				buttonNomineeSearchAssessment = driver
						.findElement(By.xpath("//button[@aria-label='Search records for Nominee Type, Lookup field']"));
				click(buttonNomineeSearchAssessment);

				driver.findElement(By.xpath("//span[contains(.,'" + nomineeValue + "')]")).click();

			}

			// Adding SBU

			WebElement buttonSearchSBU = driver
					.findElement(By.xpath("//button[@aria-label='Search records for SBU, Lookup field']"));
			click(buttonSearchSBU);
			Row nomineeSBU = s.getRow(i);
			String nomineeSBUValue = nomineeSBU.getCell(7).getStringCellValue().trim();
			try {
				/*
				 * WebDriverWait waitSBU = new WebDriverWait(driver, Duration.ofSeconds(40));
				 * waitSBU.until(ExpectedConditions
				 * .visibilityOfElementLocated(By.xpath("//span[contains(.,'" + nomineeSBUValue
				 * + "')]")));
				 */

				driver.findElement(By.xpath("//span[contains(.,'" + nomineeSBUValue + "')]")).click();

			} catch (StaleElementReferenceException e) {
				buttonSearchSBU = driver
						.findElement(By.xpath("//button[@aria-label='Search records for SBU, Lookup field']"));
				click(buttonSearchSBU);
				/*
				 * WebDriverWait waitSBU = new WebDriverWait(driver, Duration.ofSeconds(40));
				 * waitSBU.until(ExpectedConditions
				 * .visibilityOfElementLocated(By.xpath("//span[contains(.,'" + nomineeSBUValue
				 * + "')]")));
				 */

				driver.findElement(By.xpath("//span[contains(.,'" + nomineeSBUValue + "')]")).click();

			}

			// Adding DNU_SBU

			WebElement buttonSearchDNUSBU = driver
					.findElement(By.xpath("//button[@aria-label='Search records for DNU_SBU, Lookup field']"));
			click(buttonSearchDNUSBU);
			Row nomineeDNUSBU = s.getRow(i);
			String nomineeDNUSBUValue = nomineeDNUSBU.getCell(8).getStringCellValue().trim();
			try {

				driver.findElement(By.xpath("//span[contains(.,'" + nomineeDNUSBUValue + "')]")).click();

			} catch (StaleElementReferenceException e) {
				buttonSearchSBU = driver
						.findElement(By.xpath("//button[@aria-label='Search records for DNU_SBU, Lookup field']"));
				click(buttonSearchSBU);

				driver.findElement(By.xpath("//span[contains(.,'" + nomineeDNUSBUValue + "')]")).click();

			}

			// Saving Nominee

			WebElement buttonSaveCloseNominee = driver.findElement(By.xpath("//button[@aria-label='Save & Close']"));
			try {
				WebDriverWait waitSave = new WebDriverWait(driver, Duration.ofSeconds(40));
				waitSave.until(ExpectedConditions
						.visibilityOfElementLocated(By.xpath("//button[@aria-label='Save & Close']")));

				click(buttonSaveCloseNominee);
			} catch (StaleElementReferenceException e) {
				buttonSaveCloseNominee = driver.findElement(By.xpath("//button[@aria-label='Save & Close']"));
				WebDriverWait waitSave = new WebDriverWait(driver, Duration.ofSeconds(40));
				waitSave.until(ExpectedConditions
						.visibilityOfElementLocated(By.xpath("//button[@aria-label='Save & Close']")));

				click(buttonSaveCloseNominee);

			}
			Thread.sleep(2000);

		}

		// Scroll in to the Company Configuration

		WebElement scrollCompanyConfig = driver.findElement(By.xpath("//li[@aria-label='Company Configurations']"));
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", scrollCompanyConfig);
		driver.findElement(By.xpath("//li[@aria-label='Company Configurations']")).click();
		// Clicking New button in Company Configuration
		try {
			WebDriverWait waitCompanyConfig = new WebDriverWait(driver, Duration.ofSeconds(50));
			waitCompanyConfig
					.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[@aria-label='New']")));

			driver.findElement(By.xpath("//button[@aria-label='New']")).click();
		} catch (StaleElementReferenceException e) {
			WebDriverWait waitCompanyConfig = new WebDriverWait(driver, Duration.ofSeconds(50));
			waitCompanyConfig
					.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[@aria-label='New']")));
			driver.findElement(By.xpath("//button[@aria-label='New']")).click();

		}

		File fileNominee = new File(
				"C:\\Users\\deepi\\eclipse-workspace\\BehaviourAssessment\\DataFiles\\CompanyDetails.xlsx");
		FileInputStream finNominee = new FileInputStream(fileNominee);
		Workbook workbookNominee = new XSSFWorkbook(finNominee);
		Sheet sheetNominee = workbookNominee.getSheet("Sheet1");

		Row rowCompany = sheetNominee.getRow(1);

		String valueCompanyName = rowCompany.getCell(0).getStringCellValue().trim();
		System.out.println(valueCompanyName);

		WebElement buttonNomineeCompany = driver
				.findElement(By.xpath("//button[@aria-label='Search records for Company, Lookup field']"));
		buttonNomineeCompany.click();

		try {
			WebDriverWait waitCompany = new WebDriverWait(driver, Duration.ofSeconds(50));
			waitCompany.until(ExpectedConditions
					.visibilityOfElementLocated(By.xpath("//span[contains(.,'" + valueCompanyName + "')]")));

			driver.findElement(By.xpath("//span[contains(.,'" + valueCompanyName + "')]")).click();

		} catch (StaleElementReferenceException e) {
			buttonNomineeCompany = driver
					.findElement(By.xpath("//button[@aria-label='Search records for Company, Lookup field']"));
			click(buttonNomineeCompany);
			WebDriverWait waitCompany = new WebDriverWait(driver, Duration.ofSeconds(50));
			waitCompany.until(ExpectedConditions
					.visibilityOfElementLocated(By.xpath("//span[contains(.,'" + valueCompanyName + "')]")));
			driver.findElement(By.xpath("//span[contains(.,'" + valueCompanyName + "')]")).click();

		}

		WebElement buttonNomineePageNeeded = driver
				.findElement(By.xpath("//button[@aria-label='Nominee Page Needed?']"));
		buttonNomineePageNeeded.click();
		String excelvalNomineeNeeded = rowCompany.getCell(10).getStringCellValue().trim();

		try {

			System.out.println("Excel Value :" + excelvalNomineeNeeded);
			List<WebElement> optionNominee = driver.findElements(By.xpath(
					"//div[@class='fui-Listbox fui-Dropdown__listbox ___1lp10z0 fxugw4r f1ewtqcl f22iagw f1vx9l62 f3hsy1e f5zp4f fpvhumw f1yog68k f13sgyd8 f1x4af0m f7x41pl fd55psn fruq291 fiut8dr f1hg901r f1aa9q02 f16jpd5f f1jar5jt fyu767a fbvlk4a']//div"));
			System.out.println("total number of Designation" + optionNominee.size());
			for (int j = 0; j < optionNominee.size(); j++) {
				System.out.println(optionNominee.get(j).getText());
				if (optionNominee.get(j).getText().contains(excelvalNomineeNeeded)) {
					optionNominee.get(j).click();
					break;

				}

			}
		} catch (StaleElementReferenceException e) {

			List<WebElement> optionNominee = driver.findElements(By.xpath(
					"//div[@class='fui-Listbox fui-Dropdown__listbox ___1lp10z0 fxugw4r f1ewtqcl f22iagw f1vx9l62 f3hsy1e f5zp4f fpvhumw f1yog68k f13sgyd8 f1x4af0m f7x41pl fd55psn fruq291 fiut8dr f1hg901r f1aa9q02 f16jpd5f f1jar5jt fyu767a fbvlk4a']//div"));
			System.out.println("total number of Designation" + optionNominee.size());
			for (int j = 0; j < optionNominee.size(); j++) {
				System.out.println(optionNominee.get(j).getText());
				if (optionNominee.get(j).getText().contains(excelvalNomineeNeeded)) {
					optionNominee.get(j).click();
					break;
				}

			}
		}

		String excelEditorVal = rowCompany.getCell(11).getStringCellValue().trim();
		System.out.println("Excel Text Result :" + excelEditorVal);
		WebElement textEditor = driver.findElement(By.xpath(
				"//div[@aria-label='Rich Text Editor Control cba_companyconfiguration cba_behavioral360reporttext']"));
		textEditor.sendKeys(excelEditorVal);

		// Sava and Close
		driver.findElement(By.xpath("//button[@aria-label='Save & Close']")).click();

	}

}
