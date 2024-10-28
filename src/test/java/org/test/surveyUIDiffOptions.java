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

public class surveyUIDiffOptions extends Baseclass {

	public static void main(String[] args) throws InterruptedException {
	}

	public void surveyUI() throws InterruptedException {
		browserConfigure();
		surveyUIObjects so = new surveyUIObjects();

		try {
			FileInputStream file = new FileInputStream(
					("C:\\Users\\deepi\\eclipse-workspace\\BehaviourAssessment\\DataFiles\\surveyUI.xlsx"));
			Workbook workbook = new XSSFWorkbook(file);
			Sheet sheet = workbook.getSheetAt(0); // Assuming data is in the first sheet

			// Loop through each row in the sheet, starting from index 1 to skip the header
			for (int i = 1; i <= sheet.getLastRowNum(); i++) {
				Row row = sheet.getRow(i);
				String url = row.getCell(0).getStringCellValue(); // Assuming URLs are in the first column
				driver.get(url);

				windowMaximize();
				driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
				WebElement buttonNextInstr = so.getNextInstrButton();
				try {
					click(buttonNextInstr);

				} catch (StaleElementReferenceException e) {
					driver.findElement(By.id("nextInstr")).click(); // TODO: handle exception
				}

				click(buttonNextInstr);

				surveyUIObjects_Options sod = new surveyUIObjects_Options();
				if (url.contains("multi")) {

					WebElement checkMultiUser = sod.getCheckUserMulti();
					Thread.sleep(4000);
					clickWithJavaScript(checkMultiUser);
					clickWithJavaScript(buttonNextInstr);

					WebElement ackCheckBoxMulti = sod.getAckCheckBoxMulti();
					click(ackCheckBoxMulti);
					WebElement startAssessment = so.getStartAssessmentButton();
					click(startAssessment);
					if (i % 2 != 0) {
						// d,e,f
						List<WebElement> progressBar = so.getProgressBar();

						int optionD = 4;
						int optionE = optionD + 1;
						int optionF = optionE + 1;
						for (int k = 0; k < (progressBar.size()) / 2; k++) {

							selectDropdownByIndex(driver.findElement(
									By.xpath("(//select[@class='questionTableOne'])[" + optionD + "]")), 2);

							System.out.println("selected option D Multi " + k + "optionD=" + optionD);

							// selectDropdownByIndex(optionEone,2);
							selectDropdownByIndex(driver.findElement(
									By.xpath("(//select[@class='questionTableOne'])[" + optionE + "]")), 2);
							System.out.println("selected option E Multi " + k);
							// selectDropdownByIndex(optionFone,2);
							selectDropdownByIndex(driver.findElement(
									By.xpath("(//select[@class='questionTableOne'])[" + optionF + "]")), 2);
							System.out.println("selected option F Multi " + k);

							WebElement nextButton = so.getNextButton();

							clickWithJavaScript(nextButton);

							// teams options
							// selectDropdownByIndex(optionDteam, 2);
							selectDropdownByIndex(driver.findElement(
									By.xpath("(//select[@class='questionTableTeam'])[" + optionD + "]")), 2);

							System.out.println("selected option D multi team " + k + "optionD=" + optionD);
							selectDropdownByIndex(driver.findElement(
									By.xpath("(//select[@class='questionTableTeam'])[" + optionE + "]")), 2);
							System.out.println("selected option E multi team " + k);
							selectDropdownByIndex(driver.findElement(
									By.xpath("(//select[@class='questionTableTeam'])[" + optionF + "]")), 2);
							System.out.println("selected option F multi team " + k);
							if (k == ((progressBar.size()) / 2) - 1) {
								clickWithJavaScript(driver.findElement(By.xpath("//button[@id='submitButton']")));

							} else {
								clickWithJavaScript(nextButton);
								optionD = optionD + 6;
								optionE = optionD + 1;
								optionF = optionE + 1;
							}
						}
					}

					else {
						// a,b,c multi
						List<WebElement> progressBar = so.getProgressBar();

						int optionA = 1;
						int optionB = optionA + 1;
						int optionC = optionB + 1;
						for (int k = 0; k < (progressBar.size()) / 2; k++) {

							selectDropdownByIndex(driver.findElement(
									By.xpath("(//select[@class='questionTableOne'])[" + optionA + "]")), 2);

							System.out.println("selected option D Multi " + k + "optionA=" + optionA);

							// selectDropdownByIndex(optionEone,2);
							selectDropdownByIndex(driver.findElement(
									By.xpath("(//select[@class='questionTableOne'])[" + optionB + "]")), 2);
							System.out.println("selected option  B Multi " + k);
							// selectDropdownByIndex(optionFone,2);
							selectDropdownByIndex(driver.findElement(
									By.xpath("(//select[@class='questionTableOne'])[" + optionC + "]")), 2);
							System.out.println("selected option C Multi " + k);

							WebElement nextButton = so.getNextButton();

							clickWithJavaScript(nextButton);

							// teams options
							// selectDropdownByIndex(optionDteam, 2);
							selectDropdownByIndex(driver.findElement(
									By.xpath("(//select[@class='questionTableTeam'])[" + optionA + "]")), 2);

							System.out.println("selected option A multi team " + k + "optionA=" + optionA);
							selectDropdownByIndex(driver.findElement(
									By.xpath("(//select[@class='questionTableTeam'])[" + optionB + "]")), 2);
							System.out.println("selected option E multi team " + k);
							selectDropdownByIndex(driver.findElement(
									By.xpath("(//select[@class='questionTableTeam'])[" + optionC + "]")), 2);
							System.out.println("selected option F multi team " + k);
							if (k == ((progressBar.size()) / 2) - 1) {
								clickWithJavaScript(driver.findElement(By.xpath("//button[@id='submitButton']")));

							} else {
								clickWithJavaScript(nextButton);
								optionA = optionA + 6;
								optionB = optionA + 1;
								optionC = optionB + 1;
							}
						}

					}

				} else {
					// execute for Self Survey
					WebElement professionalButton = so.getProfessionalButton();
					click(professionalButton);

					Thread.sleep(4000);
					clickWithJavaScript(buttonNextInstr);

					WebElement ackCheckBox = so.getAckCheckBox();
					click(ackCheckBox);
					WebElement startAssessment = so.getStartAssessmentButton();
					click(startAssessment);
					if (i % 2 != 0) {
						// d,e,f self //select[@class='questionSelectOne']
						List<WebElement> progressBar = so.getProgressBar();
						int optionD = 4;
						int optionE = optionD + 1;
						int optionF = optionE + 1;

						for (int j = 0; j < (progressBar.size()) / 2; j++) {
							System.out.println("" + j);
							selectDropdownByIndex(driver.findElement(
									By.xpath("(//select[@class='questionSelectOne'])[" + optionD + "]")), 2);

							System.out.println("selected option D self " + j + " optionD= " + optionD);
							selectDropdownByIndex(driver.findElement(
									By.xpath("(//select[@class='questionSelectOne'])[" + optionE + "]")), 2);
							System.out.println("selected option E self " + j);
							selectDropdownByIndex(driver.findElement(
									By.xpath("(//select[@class='questionSelectOne'])[" + optionF + "]")), 2);
							System.out.println("selected option F self " + j);
							WebElement nextButton = so.getNextButton();

							clickWithJavaScript(nextButton);// questionSelectTeam
							selectDropdownByIndex(driver.findElement(
									By.xpath("(//select[@class='questionSelectTeam'])[" + optionD + "]")), 2);
							System.out.println("selected option D team in self " + j + "option D=" + optionD);
							selectDropdownByIndex(driver.findElement(
									By.xpath("(//select[@class='questionSelectTeam'])[" + optionE + "]")), 2);
							System.out.println("selected optionE team in self " + j);
							selectDropdownByIndex(driver.findElement(
									By.xpath("(//select[@class='questionSelectTeam'])[" + optionF + "]")), 2);
							System.out.println("selected optionF team in self " + j);
							clickWithJavaScript(nextButton);
							optionD = optionD + 6;
							optionE = optionD + 1;
							optionF = optionE + 1;

						}
					} else {
						List<WebElement> progressBar = so.getProgressBar();
						int optionA = 1;
						int optionB = optionA + 1;
						int optionC = optionB + 1;

						for (int j = 0; j < (progressBar.size()) / 2; j++) {
							System.out.println("" + j);
							selectDropdownByIndex(driver.findElement(
									By.xpath("(//select[@class='questionSelectOne'])[" + optionA + "]")), 2);

							System.out.println("selected option D self " + j + " optionD= " + optionA);
							selectDropdownByIndex(driver.findElement(
									By.xpath("(//select[@class='questionSelectOne'])[" + optionB + "]")), 2);
							System.out.println("selected option E self " + j);
							selectDropdownByIndex(driver.findElement(
									By.xpath("(//select[@class='questionSelectOne'])[" + optionC + "]")), 2);
							System.out.println("selected option F self " + j);
							WebElement nextButton = so.getNextButton();

							clickWithJavaScript(nextButton);// questionSelectTeam
							selectDropdownByIndex(driver.findElement(
									By.xpath("(//select[@class='questionSelectTeam'])[" + optionA + "]")), 2);
							System.out.println("selected option D team in self " + j + "option D=" + optionA);
							selectDropdownByIndex(driver.findElement(
									By.xpath("(//select[@class='questionSelectTeam'])[" + optionB + "]")), 2);
							System.out.println("selected optionE team in self " + j);
							selectDropdownByIndex(driver.findElement(
									By.xpath("(//select[@class='questionSelectTeam'])[" + optionC + "]")), 2);
							System.out.println("selected optionF team in self " + j);
							clickWithJavaScript(nextButton);
							optionA = optionA + 6;
							optionB = optionA + 1;
							optionC = optionB + 1;

						}

					}

					System.out.println("okay");
				}
				Thread.sleep(5000);
			}

			// Close workbook and quit WebDriver
			// workbook.close();
			driver.quit();

		} catch (

		IOException e) {
			e.printStackTrace();
		}
	}
}
