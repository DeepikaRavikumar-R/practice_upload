package org.test;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.Duration;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.concurrent.TimeUnit;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.ElementClickInterceptedException;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebElement;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Complete extends Baseclass {

	public static void main(String[] args) throws InterruptedException, IOException {

		browserConfigure();
		driver.get(
				"https://completeqa.crm4.dynamics.com/main.aspx?appid=b3c9ac1f-1847-ed11-bba3-000d3adf69cc&pagetype=entitylist&etn=account&viewid=00000000-0000-0000-00aa-000010001002&viewType=1039");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

		CompleteObjectManager lc = new CompleteObjectManager();
		WebElement textUserEmail = lc.getTxtUserEmail();
		
		keys(textUserEmail, "Portal.Dev1@complete-coherence.com");
		WebElement buttonNext = lc.getButtonNext();
		buttonNext.click();
		WebElement textPassword = lc.getTextPassword();
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(40));
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("i0118")));
		keys(textPassword, "Mar50230");
		WebElement buttonSignin = lc.getButtonSignin();
		click(buttonSignin);
		WebElement buttonYes = lc.getButtonYes();
		click(buttonYes);
		WebElement buttonNew = lc.getButtonNew();
		WebDriverWait waitNew = new WebDriverWait(driver, Duration.ofSeconds(30));
		waitNew.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[@aria-label='New']")));
		click(buttonNew);
		Thread.sleep(40000);

		File f = new File("C:\\Users\\deepi\\eclipse-workspace\\BehaviourAssessment\\DataFiles\\CompanyDetails.xlsx");
		FileInputStream fin = new FileInputStream(f);
		Workbook w = new XSSFWorkbook(fin);
		Sheet s = w.getSheet("Sheet1");
		Row r = s.getRow(1);
		// Cell c=r.getCell(1);

		String val = r.getCell(0).getStringCellValue();
		System.out.println(val);

		WebElement textCompanyname = lc.getTextCompanyname();
		WebDriverWait waitCompanyname = new WebDriverWait(driver, Duration.ofSeconds(40));
		waitCompanyname
				.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@aria-label='Company Name']")));
		textCompanyname.sendKeys(val);

		/*
		 * WebElement buttonGroup = lc.getButtonSearchGroup(); click(buttonGroup);
		 * WebDriverWait waitGroup = new WebDriverWait(driver, Duration.ofSeconds(60));
		 * waitGroup.until(ExpectedConditions .visibilityOfElementLocated(By.
		 * xpath("//div[@aria-label='Group Lookup results']//child::ul//li")));
		 * 
		 * List<WebElement> listItems = waitGroup.until(ExpectedConditions
		 * .presenceOfAllElementsLocatedBy(By.
		 * xpath("//div[@aria-label='Group Lookup results']//child::ul//li")));
		 * System.out.println("total number of list" + listItems.size()); boolean isFlag
		 * = false; for (int i = 0; i < listItems.size(); i++) { if (!isFlag) { String
		 * listGroup = listItems.get(i).getText(); String valueGroup =
		 * listGroup.substring(0, listGroup.length() - 16);
		 * System.out.println("New String - " + valueGroup);
		 * 
		 * for (int j = 1; j < s.getPhysicalNumberOfRows(); j++) { Row group =
		 * s.getRow(j); if (group.getCell(2) != null) { String companyGroup =
		 * group.getCell(2).getStringCellValue().trim(); System.out.println("Group Name"
		 * + companyGroup); System.out.println(valueGroup.contains(companyGroup)); if
		 * (valueGroup.contains(companyGroup)) { listItems.get(i).click(); isFlag =
		 * true;
		 * 
		 * } } } } }
		 */

		// Adding Group

		WebElement buttonGroup = driver
				.findElement(By.xpath("//button[@aria-label='Search records for Group, Lookup field']"));
		click(buttonGroup);

		Row rCompanyName = s.getRow(1);
		String nameGroup = rCompanyName.getCell(2).getStringCellValue().trim();

		try {

			driver.findElement(By.xpath("//span[contains(.,'" + nameGroup + "')]")).click();

		} catch (ElementClickInterceptedException e) {
			buttonGroup = driver
					.findElement(By.xpath("//button[@aria-label='Search records for Group, Lookup field']"));
			click(buttonGroup);
			driver.findElement(By.xpath("//span[contains(.,'" + nameGroup + "')]")).click();

		}

		// Adding SBU

		WebElement buttonSBU = lc.getButtonSearchSBU();
		click(buttonSBU);
		String nameSBU = rCompanyName.getCell(3).getStringCellValue().trim();
		try {

			driver.findElement(By.xpath("//span[contains(.,'" + nameSBU + "')]")).click();

		} catch (ElementClickInterceptedException e) {
			buttonSBU = lc.getButtonSearchSBU();
			click(buttonSBU);
			driver.findElement(By.xpath("//span[contains(.,'" + nameSBU + "')]")).click();

		}

		// Adding Sector

		WebElement buttonSector = lc.getButtonSearchSector();
		click(buttonSector);
		String nameSector = rCompanyName.getCell(4).getStringCellValue().trim();
		try {

			driver.findElement(By.xpath("//span[contains(.,'" + nameSector + "')]")).click();

		} catch (ElementClickInterceptedException e) {
			buttonSector = lc.getButtonSearchSector();
			click(buttonSector);
			driver.findElement(By.xpath("//span[contains(.,'" + nameSector + "')]")).click();

		}

		// Adding Division

		WebElement buttonDivision = lc.getButtonSearchDivision();
		click(buttonDivision);
		String nameDivision = rCompanyName.getCell(5).getStringCellValue().trim();
		try {

			driver.findElement(By.xpath("//span[contains(.,'" + nameDivision + "')]")).click();

		} catch (ElementClickInterceptedException e) {
			buttonDivision = lc.getButtonSearchDivision();
			click(buttonDivision);
			driver.findElement(By.xpath("//span[contains(.,'" + nameDivision + "')]")).click();

		}

		// Adding Function

		WebElement buttonFunction = lc.getButtonSearchFunction();
		click(buttonFunction);
		String nameFunction = rCompanyName.getCell(6).getStringCellValue().trim();
		try {

			driver.findElement(By.xpath("//span[contains(.,'" + nameFunction + "')]")).click();

		} catch (ElementClickInterceptedException e) {
			buttonFunction = lc.getButtonSearchFunction();
			click(buttonFunction);
			driver.findElement(By.xpath("//span[contains(.,'" + nameFunction + "')]")).click();

		}

		// Adding Country

		WebElement buttonCountry = lc.getButtonSearchCountry();
		click(buttonCountry);
		String nameCountry = rCompanyName.getCell(7).getStringCellValue().trim();
		try {

			driver.findElement(By.xpath("//span[contains(.,'" + nameCountry + "')]")).click();

		} catch (StaleElementReferenceException e) {
			buttonCountry = lc.getButtonSearchCountry();
			click(buttonCountry);
			driver.findElement(By.xpath("//span[contains(.,'" + nameCountry + "')]")).click();

		}

		// Adding Region

		WebElement buttonRegion = lc.getButtonSearchRegion();
		click(buttonRegion);
		String nameRegion = rCompanyName.getCell(8).getStringCellValue().trim();
		try {

			driver.findElement(By.xpath("//span[contains(.,'" + nameRegion + "')]")).click();

		} catch (ElementClickInterceptedException e) {
			buttonRegion = lc.getButtonSearchRegion();
			click(buttonRegion);
			driver.findElement(By.xpath("//span[contains(.,'" + nameRegion + "')]")).click();

		}

		WebDriverWait waitClick = new WebDriverWait(driver, Duration.ofSeconds(20));
		waitClick.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[@aria-label='Save (CTRL+S)']")));

		WebElement buttonSave = lc.getButtonSave();
		click(buttonSave);
		Thread.sleep(1500);

		// Copy Templates

		WebElement buttonCopyTemplate = lc.getButtonCopyTemplate();
		WebDriverWait waitCopyTemplate = new WebDriverWait(driver, Duration.ofSeconds(30));
		waitCopyTemplate
				.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[@aria-label='Copy Templates']")));
		click(buttonCopyTemplate);

		WebDriverWait waitIframe = new WebDriverWait(driver, Duration.ofSeconds(30));
		waitIframe.until(ExpectedConditions.presenceOfElementLocated(By.id("FullPageWebResource")));
		WebElement iframe = lc.getSwitchToFrame();
		driver.switchTo().frame(iframe);

		int row = driver.findElements(By.xpath("//html//body//table[@class='tblTraits table']//tbody//tr")).size();
		System.out.println("Number of rows" + row);

		for (int i = 1; i <= row; i++) {

			String valueExcel = driver.findElement(By.xpath("//div[@id='Traits']//tr[" + i + "]//td[2]")).getText();
			System.out.println(valueExcel);

			for (int j = 1; j < s.getPhysicalNumberOfRows(); j++) {
				Row copyTemplate = s.getRow(j);
				String proActive = copyTemplate.getCell(1).getStringCellValue();
				if (proActive.contains(valueExcel)) {
					System.out.println("Test");

					driver.findElement(By.xpath("//label[.='" + valueExcel + "']//preceding::input[1]")).click();
				}

			}

		}

		JavascriptExecutor er = (JavascriptExecutor) driver;
		WebElement scrollNext = lc.getScrollDownNext();
		er.executeScript("arguments[0].scrollIntoView();", scrollNext);
		Thread.sleep(1000);
		WebDriverWait waitCopyTemplateNext = new WebDriverWait(driver, Duration.ofSeconds(50));
		waitCopyTemplateNext
				.until(ExpectedConditions.elementToBeClickable(By.xpath("(//button[@class='btn-next'])[1]")));
		WebElement clickButtonNext = lc.getButtonCopyTemplateNext();
		click(clickButtonNext);

		Thread.sleep(1000);

		// Rater Types
		int rowRatertypes = driver.findElements(By.xpath("//table[@class='tblRaterTypes table']//tr//td[2]")).size();
		System.out.println("Number of rows" + rowRatertypes);

		for (int i = 1; i <= rowRatertypes; i++) {

			String valueRaterTypes = driver
					.findElement(By.xpath("//table[@class='tblRaterTypes table']//tr[" + i + "]//td[2]")).getText();
			System.out.println("System Value :" + valueRaterTypes);

			for (int j = 1; j < s.getPhysicalNumberOfRows(); j++) {
				Row raterTypeTemplate = s.getRow(j);
				String excelRaterType = raterTypeTemplate.getCell(9).getStringCellValue().trim();
				System.out.println("Excel Value :" + excelRaterType);
				if (excelRaterType.contains(valueRaterTypes)) {

					driver.findElement(By.xpath("//label[.='" + valueRaterTypes + "']//preceding::input[1]")).click();
				}

			}

		}

		WebDriverWait waitNextRaterType = new WebDriverWait(driver, Duration.ofSeconds(50));
		waitNextRaterType.until(ExpectedConditions.elementToBeClickable(By.xpath("(//button[@class='btn-next'])[2]")));
		WebElement clickButtonNextRaterType = lc.getButtonNextRaterType();
		click(clickButtonNextRaterType);

		WebDriverWait waitNextEmailMsg = new WebDriverWait(driver, Duration.ofSeconds(50));
		waitNextEmailMsg.until(ExpectedConditions.elementToBeClickable(By.xpath("(//button[@class='btn-next'])[3]")));
		WebElement clickButtonNextEmailMessage = lc.getButtonNextEmailMessage();
		click(clickButtonNextEmailMessage);

		WebDriverWait waitNextInstruction = new WebDriverWait(driver, Duration.ofSeconds(50));
		waitNextInstruction
				.until(ExpectedConditions.elementToBeClickable(By.xpath("(//button[@class='btn-next'])[4]")));
		WebElement clickButtonNextInstruction = lc.getButtonNextInstructionTemplates();
		click(clickButtonNextInstruction);

		WebDriverWait waitSaveBenchmark = new WebDriverWait(driver, Duration.ofSeconds(50));
		waitSaveBenchmark.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[@id='btnSave']")));
		WebElement clickButtonSaveBenchmark = lc.getButtonSaveBenchmark();
		click(clickButtonSaveBenchmark);

		Thread.sleep(8000);
		driver.navigate().refresh();
		
		//Action Save and Close
		
		driver.findElement(By.xpath("//button[@aria-label='Save & Close']")).click();
		
		SurveyUsers survey=new SurveyUsers();
		survey.surveyUser();
		Nominees nominee=new Nominees();
		nominee.nomineeUsers();
       /* survey3 objectSurvey=new survey3();
        objectSurvey.surveySetup();*/
		SurveyLinkSetup objectSurveylink=new SurveyLinkSetup();
		objectSurveylink.SurveylinkSetup();
		
	}
	

}
