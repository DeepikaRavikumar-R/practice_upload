package org.test;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.Duration;
import java.util.concurrent.TimeUnit;

import org.apache.poi.ss.formula.functions.Count;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class TeamSurveyAssessment extends Baseclass {
	public static void main(String[] args) throws IOException, InterruptedException {
		browserConfigure();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

		// Getting Survey Assessment Link from Excel

		
		MultiTeam("https://modus-behaviourassessment.powerappsportals.com/surveyassessmentv2multi/?contactid=a8db3bbf-406f-ef11-a670-6045bddd4abe&questionnaireid=1a53d0f2-3a88-ef11-ac21-7c1e523530b8");
		
		
	}
	
	public static void MultiTeam(String multiLink) throws IOException, InterruptedException {
		File fileSurveyAssessment = new File(
				"C:\\Users\\deepi\\eclipse-workspace\\BehaviourAssessment\\DataFiles\\Bulk_Upload.xlsx");
		FileInputStream finSurvey = new FileInputStream(fileSurveyAssessment);
		Workbook workbook = new XSSFWorkbook(finSurvey);
		Sheet sheet = workbook.getSheet("Sheet1");
		Row rowSurveyLink = sheet.getRow(1);

		//String linkSurveyAssess = rowSurveyLink.getCell(0).getStringCellValue();
		//System.out.println(linkSurveyAssess);
		driver.get(multiLink);
		Thread.sleep(3000);
		String mesaageResult=driver.findElement(By.xpath("//div[@id='SuccessMessage']//p")).getText();
		System.out.println("dfdfsdfdsfdsfdsf :" +mesaageResult);
      if(!mesaageResult.contains("Congratulations")) {
		// Click Button NextPage in Complete Behavioural Reoprt
		WebDriverWait waitNextPage = new WebDriverWait(driver, Duration.ofSeconds(40));
		waitNextPage.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[@id='nextInstr']")));
		driver.findElement(By.xpath("//button[@id='nextInstr']")).click();

		// Click Button NextPage in Welcome User
		driver.findElement(By.xpath("//button[@id='nextInstr']")).click();

		// Selecting Option in Participant Selection from Excel
		/*String levelParticipant = rowSurveyLink.getCell(1).getStringCellValue();
		driver.findElement(By.xpath("//label[contains(.,'" + levelParticipant + "')]")).click();*/ //tr//td
		
		// Participation selection page
		
		int rowSize=driver.findElements(By.xpath("//table//tbody//tr//td//label//input")).size();
		System.out.println("Number of rows"+rowSize);
		for (int i = 1; i <= rowSize; i++) {
		String value = driver.findElement(By.xpath("//div[@id='PendingValsDiv']//tr[" + i + "]//td[1]")).getText();
		System.out.println("dfdsf " +sheet.getPhysicalNumberOfRows());
		for (int j = 1; j < sheet.getPhysicalNumberOfRows(); j++) {
			Row participation = sheet.getRow(j);
			String userName = participation.getCell(1).getStringCellValue();
			System.out.println("AAAAAAA "+i+" -- " +value);
			System.out.println("BBBBBBB "+i+" -- " +userName);
			if (userName.contains(value)) {
				System.out.println("Test");
           System.out.println("//td[.='" + value + "']//following::input[1]");
				driver.findElement(By.xpath("//td[.='" + value + "']//following::input[1]")).click();
			}

		}
		}
		WebDriverWait leadershipNextPage = new WebDriverWait(driver, Duration.ofSeconds(20));
		leadershipNextPage.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[@id='nextInstr']")));

		WebElement button = driver.findElement(By.xpath("//button[@id='nextInstr']"));
		JavascriptExecutor javascript = (JavascriptExecutor) driver;
		javascript.executeScript("arguments[0].click();", button);
		
		
		
		// Click Checkbox in Acknowledgement

		WebElement buttonCheckbox = driver.findElement(By.xpath("//input[@id='agreemntCheck']"));
		buttonCheckbox.click();

		driver.findElement(By.id("startButton")).click();

		int questionCount = driver.findElements(By.xpath("//div[@class='progressbar']")).size();
		int qOneCount = 0, qTeamCount = 0;
		String className;

		
		for (int i = 1; i <= questionCount; i++) {

			String question = rowSurveyLink.getCell(i + 1).getStringCellValue();
			String name = rowSurveyLink.getCell(i).getStringCellValue();
			//System.out.println("Excel Value :" + question);
			String[] quesAnsSplit = question.split("/");
			String[] nameSplit = name.split("/");
			System.out.println("Multi Length :" + quesAnsSplit.length);
			for(int j = 0; j<rowSize;j++) {
			String[] splitAnswer = quesAnsSplit[j].split(",");
			System.out.println("ccccc :" + quesAnsSplit[j]+ "and" +i);
			//String headerText = driver.findElement(By.xpath("(//div[@class='qHeaderVal'])['" + i + "']")).getText();
			//System.out.println("Text :" + headerText);

			if (i%2!=0) {
				if(i > 1 && j == 0) {
					
					qOneCount = qOneCount + (rowSize*6);
				}
				className = "questionTableOne";
			} else {
				if(i > 2 && j == 0) {
					qTeamCount = qTeamCount + (rowSize*6);
				}
				className = "questionTableTeam";
			}
			
			for (String Ans : splitAnswer) {
				WebElement clickDropdown;
				System.out.println("First Split :" + Ans);
				if (Ans.split("-")[0].contains("a")) {
					System.out.println("Test1");
					if (i%2!=0) {
						System.out.println("AAAA - " + "(//td[not(contains(@style,'display:none'))]//select[@class='" + className + "'])["+j+" + " + qOneCount + " + 1]");
						clickDropdown = driver
								.findElement(By.xpath("(//td[not(contains(@style,'display:none'))]//select[@class='" + className + "'])['"+j+"' + '" + qOneCount + "' + 1]"));

					} else {
						clickDropdown = driver.findElement(
								By.xpath("(//td[not(contains(@style,'display:none'))]//select[@class='" + className + "'])['"+j+"' + '" + qTeamCount + "'+1]"));
					}
					Select select = new Select(clickDropdown);
					//System.out.println("Drop down :" + Ans.split("-")[1]);
					if(clickDropdown.isEnabled()) {
					select.selectByValue(Ans.split("-")[1]);
					}
				}
				if (Ans.split("-")[0].contains("b")) {
					System.out.println("Test2");
					if (i%2!=0) {
						System.out.println("BBBB - " + "(//td[not(contains(@style,'display:none'))]//select[@class='" + className + "'])["+j+" + " + qOneCount + " + ('"+rowSize+"' * 1) + 1]");
						clickDropdown = driver
								.findElement(By.xpath("(//td[not(contains(@style,'display:none'))]//select[@class='" + className + "'])['"+j+"' + '" + qOneCount + "' + ('"+rowSize+"' * 1) + 1]"));
					} else {
						clickDropdown = driver.findElement(
								By.xpath("(//td[not(contains(@style,'display:none'))]//select[@class='" + className + "'])['"+j+"' + '" + qTeamCount + "' + ('"+rowSize+"' * 1) +1]"));
					}
					Select select = new Select(clickDropdown);
					//System.out.println("Drop down :" + Ans.split("-")[1]);
					if(clickDropdown.isEnabled()) {
					select.selectByValue(Ans.split("-")[1]);
					}
				}
				if (Ans.split("-")[0].contains("c")) {
					System.out.println("Test3");
					if (i%2!=0) {
						System.out.println("CCCC - " + "(//td[not(contains(@style,'display:none'))]//select[@class='" + className + "'])["+j+" + " + qOneCount + " + ('"+rowSize+"' * 2)+ 1]");
						clickDropdown = driver
								.findElement(By.xpath("(//td[not(contains(@style,'display:none'))]//select[@class='" + className + "'])['"+j+"' + '" + qOneCount + "'+ ('"+rowSize+"' * 2) +1]"));
					} else {
						clickDropdown = driver.findElement(
								By.xpath("(//td[not(contains(@style,'display:none'))]//select[@class='" + className + "'])['"+j+"' + '" + qTeamCount + "'+ ('"+rowSize+"' * 2) +1]"));

					}

					Select select = new Select(clickDropdown);
					//System.out.println("Drop down :" + Ans.split("-")[1]);
					if(clickDropdown.isEnabled()) {
					select.selectByValue(Ans.split("-")[1]);
				}
				}
				if (Ans.split("-")[0].contains("d")) {
					System.out.println("Test4");
					if (i%2!=0) {
						System.out.println("DDDD - " + "(//td[not(contains(@style,'display:none'))]//select[@class='" + className + "'])["+j+" + " + qOneCount + " + ('"+rowSize+"' * 3) + 1]");
						clickDropdown = driver
								.findElement(By.xpath("(//td[not(contains(@style,'display:none'))]//select[@class='" + className + "'])['"+j+"' + '" + qOneCount + "' + ('"+rowSize+"' * 3) +1]"));
					} else {
						clickDropdown = driver.findElement(
								By.xpath("(//td[not(contains(@style,'display:none'))]//select[@class='" + className + "'])['"+j+"' + '" + qTeamCount + "' + ('"+rowSize+"' * 3) +1]"));
					}

					Select select = new Select(clickDropdown);
					System.out.println("Drop down :" + Ans.split("-")[1]);
					if(clickDropdown.isEnabled()) {
					select.selectByValue(Ans.split("-")[1]);
					}
				}
				if (Ans.split("-")[0].contains("e")) {
					
					System.out.println("Test5");
					if (i%2!=0) {
						System.out.println("EEEEE - " + "(//select[@class='" + className + "'])["+j+" + " + qOneCount + " + ('"+rowSize+"' * 4) + 1]");
						clickDropdown = driver
								.findElement(By.xpath("(//select[@class='" + className + "'])['"+j+"' + '" + qOneCount + "' + ('"+rowSize+"' * 4) +1]"));
						System.out.println("Check Display : " + clickDropdown.isDisplayed());
					} else {
						clickDropdown = driver.findElement(
								By.xpath("(//td[not(contains(@style,'display:none'))]//select[@class='" + className + "'])['"+j+"' + '" + qTeamCount + "' + ('"+rowSize+"' * 4) +1]"));
						System.out.println("Check Display 1 : " + clickDropdown.isDisplayed());

					}
					Select select = new Select(clickDropdown);
					System.out.println("Drop down :" + Ans.split("-")[1]);
					if(clickDropdown.isEnabled()) {
					select.selectByValue(Ans.split("-")[1]);
					}
				}
				if (Ans.split("-")[0].contains("f")) {
					System.out.println("Test6");
					if (i%2!=0) {
						System.out.println("FFFF - " + "(//td[not(contains(@style,'display:none'))]//select[@class='" + className + "'])["+j+" + " + qOneCount + " + ('"+rowSize+"' * 5) + 1]");
						clickDropdown = driver
								.findElement(By.xpath("(//td[not(contains(@style,'display:none'))]//select[@class='" + className + "'])['"+j+"' + '" + qOneCount + "' + ('"+rowSize+"' * 5) +1]"));
					} else {
						clickDropdown = driver.findElement(
								By.xpath("(//td[not(contains(@style,'display:none'))]//select[@class='" + className + "'])['"+j+"' + '" + qTeamCount + "' + ('"+rowSize+"' * 5) +1]"));
					}

					Select select = new Select(clickDropdown);
					System.out.println("Drop down :" + Ans.split("-")[1]);
					if(clickDropdown.isEnabled()) {
					select.selectByValue(Ans.split("-")[1]);
					}
				}
			}
			}
			if (i < questionCount) {
			driver.findElement(By.xpath("//button[@id='nextButton']")).click();
			Thread.sleep(3000);
			}
			else {
				Thread.sleep(4000);
				driver.findElement(By.xpath("//button[@id='submitButton']")).click();
				Thread.sleep(4000);
			}

		}
	}
}
}


