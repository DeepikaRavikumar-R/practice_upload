package org.test;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.concurrent.TimeUnit;

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

public class SurveySelfAssessmentwithNomination extends Baseclass{
	public static void main(String[] args) throws IOException, InterruptedException {
		browserConfigure();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

		// Getting Survey Assessment Link from Excel

		File fileSurveyAssessment = new File(
				"C:\\Users\\deepi\\eclipse-workspace\\BehaviourAssessment\\DataFiles\\SurveyAssessmentLink.xlsx");
		FileInputStream finSurvey = new FileInputStream(fileSurveyAssessment);
		Workbook workbook = new XSSFWorkbook(finSurvey);
		Sheet sheet = workbook.getSheet("Sheet1");
		Row rowSurveyLink = sheet.getRow(1);

		String linkSurveyAssess = rowSurveyLink.getCell(0).getStringCellValue();
		System.out.println(linkSurveyAssess);
		driver.get(linkSurveyAssess);

		// Click Button NextPage in Complete Behavioural Reoprt
		WebDriverWait waitNextPage = new WebDriverWait(driver, Duration.ofSeconds(20));
		waitNextPage.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[@id='nextInstr']")));
		driver.findElement(By.xpath("//button[@id='nextInstr']")).click();

		// Click Button NextPage in Welcome User
		driver.findElement(By.xpath("//button[@id='nextInstr']")).click();

		// Selecting Option in Leadership Level from Excel
		String levelLeadership = rowSurveyLink.getCell(1).getStringCellValue();
		driver.findElement(By.xpath("//label[contains(.,'" + levelLeadership + "')]")).click();
		WebDriverWait leadershipNextPage = new WebDriverWait(driver, Duration.ofSeconds(20));
		leadershipNextPage.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[@id='nextInstr']")));

		WebElement button = driver.findElement(By.xpath("//button[@id='nextInstr']"));
		JavascriptExecutor javascript = (JavascriptExecutor) driver;
		javascript.executeScript("arguments[0].click();", button);

		// Click Checkbox in Acknowledgement

		WebElement buttonCheckbox = driver.findElement(By.xpath("(//div[@class='custom-checkbox'])[7]"));
		buttonCheckbox.click();

		driver.findElement(By.id("startButton")).click();

		int questionCount = driver.findElements(By.xpath("//div[@class='progressbar']")).size();
		int qOneCount = 0, qTeamCount = 0;
		String className;
		for (int i = 1; i <= questionCount; i++) {

			String question = rowSurveyLink.getCell(i + 1).getStringCellValue();
			//System.out.println("Excel Value :" + question);
			String[] splitAnswer = question.split(",");
			System.out.println("ccccc :" + questionCount+ "and" +i);
			//String headerText = driver.findElement(By.xpath("(//div[@class='qHeaderVal'])['" + i + "']")).getText();
			//System.out.println("Text :" + headerText);

			if (i%2!=0) {
				if (i > 1) {
					qOneCount = qOneCount + 6;

				}
				className = "questionSelectOne";
			} else {
				if (i > 2) {
					qTeamCount = qTeamCount + 6;

				}
				className = "questionSelectTeam";
			}
			System.out.println("classname : " + className);

			for (String Ans : splitAnswer) {
				WebElement clickDropdown;
				System.out.println("First Split :" + Ans);
				if (Ans.split("-")[0].contains("a")) {
					System.out.println("abcd");
					if (i%2!=0) {
						clickDropdown = driver
								.findElement(By.xpath("(//select[@class='" + className + "'])['" + qOneCount + "'+1]"));

					} else {
						clickDropdown = driver.findElement(
								By.xpath("(//select[@class='" + className + "'])['" + qTeamCount + "'+1]"));
					}
					Select select = new Select(clickDropdown);
					//System.out.println("Drop down :" + Ans.split("-")[1]);
					select.selectByValue(Ans.split("-")[1]);
				}
				if (Ans.split("-")[0].contains("b")) {
					System.out.println("abcd");
					if (i%2!=0) {
						clickDropdown = driver
								.findElement(By.xpath("(//select[@class='" + className + "'])['" + qOneCount + "'+2]"));
					} else {
						clickDropdown = driver.findElement(
								By.xpath("(//select[@class='" + className + "'])['" + qTeamCount + "'+2]"));
					}
					Select select = new Select(clickDropdown);
					//System.out.println("Drop down :" + Ans.split("-")[1]);
					select.selectByValue(Ans.split("-")[1]);
				}
				if (Ans.split("-")[0].contains("c")) {
					//System.out.println("abcd");
					if (i%2!=0) {
						clickDropdown = driver
								.findElement(By.xpath("(//select[@class='" + className + "'])['" + qOneCount + "'+3]"));
					} else {
						clickDropdown = driver.findElement(
								By.xpath("(//select[@class='" + className + "'])['" + qTeamCount + "'+3]"));

					}

					Select select = new Select(clickDropdown);
					//System.out.println("Drop down :" + Ans.split("-")[1]);
					select.selectByValue(Ans.split("-")[1]);
				}
				if (Ans.split("-")[0].contains("d")) {
					System.out.println("abcd");
					if (i%2!=0) {
						clickDropdown = driver
								.findElement(By.xpath("(//select[@class='" + className + "'])['" + qOneCount + "'+4]"));
					} else {
						clickDropdown = driver.findElement(
								By.xpath("(//select[@class='" + className + "'])['" + qTeamCount + "'+4]"));
					}

					Select select = new Select(clickDropdown);
					System.out.println("Drop down :" + Ans.split("-")[1]);
					select.selectByValue(Ans.split("-")[1]);
				}
				if (Ans.split("-")[0].contains("e")) {
					System.out.println("abcd");
					if (i%2!=0) {
						clickDropdown = driver
								.findElement(By.xpath("(//select[@class='" + className + "'])['" + qOneCount + "'+5]"));
					} else {
						clickDropdown = driver.findElement(
								By.xpath("(//select[@class='" + className + "'])['" + qTeamCount + "'+5]"));

					}
					Select select = new Select(clickDropdown);
					System.out.println("Drop down :" + Ans.split("-")[1]);
					select.selectByValue(Ans.split("-")[1]);
				}
				if (Ans.split("-")[0].contains("f")) {
					System.out.println("abcd");
					if (i%2!=0) {
						clickDropdown = driver
								.findElement(By.xpath("(//select[@class='" + className + "'])['" + qOneCount + "'+6]"));
					} else {
						clickDropdown = driver.findElement(
								By.xpath("(//select[@class='" + className + "'])['" + qTeamCount + "'+6]"));
					}

					Select select = new Select(clickDropdown);
					System.out.println("Drop down :" + Ans.split("-")[1]);
					select.selectByValue(Ans.split("-")[1]);
				}
			}
			driver.findElement(By.xpath("//button[@id='nextButton']")).click();
			Thread.sleep(2000);

		}

	}

}
