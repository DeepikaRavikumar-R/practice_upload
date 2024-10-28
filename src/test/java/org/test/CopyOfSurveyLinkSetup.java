package org.test;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.ElementClickInterceptedException;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CopyOfSurveyLinkSetup extends Baseclass {

	public static void main(String[] args) throws IOException, InterruptedException {
		browserConfigure();
		driver.get(
				"https://org3356c1e0.crm4.dynamics.com/main.aspx?appid=c8dc5600-7e89-4955-9641-97822d57f714&pagetype=entitylist&etn=cba_survey&viewid=bd1b7aab-e3b2-4cf9-aba8-13ead4b62e12&viewType=1039");
		windowMaximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));

		CompleteObjectManagerSurvey lc = new CompleteObjectManagerSurvey();
		WebElement textUserEmail = lc.getTxtUserEmail();
		JavascriptExecutor js = (JavascriptExecutor) driver;
		keys(textUserEmail, "deepika.ravikumar@modusetp.com");
		WebElement buttonNext = lc.getButtonNext();
		buttonNext.click();
		WebElement textPassword = lc.getTextPassword();
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(40));
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("i0118")));
		keys(textPassword, "Sendeep@1");
		WebElement buttonSignin = lc.getButtonSignin();
		click(buttonSignin);
		WebElement buttonYes = lc.getButtonYes();
		click(buttonYes);

		// try {
		FileInputStream excelFile = new FileInputStream(
				"C:\\Users\\deepi\\eclipse-workspace\\BehaviourAssessment\\DataFiles\\survey.xlsx");
		Workbook workbook = new XSSFWorkbook(excelFile);
		Sheet datatypeSheet = workbook.getSheetAt(0);

		// Assuming the structure is: survey name in cell 0, company name in cell 1,
		// scheduled date in cell 2
		for (int i = 1; i <= datatypeSheet.getLastRowNum(); i++) {
			Row currentRow = datatypeSheet.getRow(i);
			Cell surveyNameCell = currentRow.getCell(0);
			Cell companyNameCell = currentRow.getCell(1);
			Cell scheduledDateCell = currentRow.getCell(2);
			Cell designation = currentRow.getCell(3);

			if (surveyNameCell != null && companyNameCell != null && scheduledDateCell != null) {
				String surveyName = surveyNameCell.getStringCellValue().trim();
				String companyName = companyNameCell.getStringCellValue();
				String scheduledDate = scheduledDateCell.getStringCellValue();
				String designationString = designation.getStringCellValue().trim();
				String[] designationArray = designationString.split(",");
				// Navigate to the menu where you want to input data
				// Assuming there's a menu item with id "surveyMenu" to navigate to the survey
				// page
				System.out.println(surveyName);
				WebElement surveyButton = lc.getButtonSurvey();
				try {

					click(surveyButton);
				} catch (ElementClickInterceptedException e) {
					surveyButton = lc.getButtonSurvey();
					click(surveyButton);
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

				/*
				 * WebElement textCompanyName = lc.getCompanyNameText(); // Thread.sleep(4000);
				 * textCompanyName.clear(); keys(textCompanyName, companyName);// Multi Test
				 * Company,Test Unique Account Thread.sleep(5000);
				 * textCompanyName.sendKeys(Keys.ENTER); Thread.sleep(1500);
				 */

				WebElement textCompanyName = lc.getCompanyNameText();
				keys(textCompanyName, companyName);

				try {

					driver.findElement(By.xpath("//span[contains(.,'" + companyName + "')]")).click();

				} catch (StaleElementReferenceException e) {
					textCompanyName = lc.getCompanyNameText();
					click(textCompanyName);
					driver.findElement(By.xpath("//span[contains(.,'" + companyName + "')]")).click();

				}

				/*
				 * WebElement designationDrop=driver.findElement(By.xpath(
				 * "//button[@class='msos-caret-button']")); try { designationDrop.click(); }
				 * catch (ElementClickInterceptedException e) {
				 * textCompanyName.sendKeys(Keys.ENTER); Thread.sleep(1500);
				 * designationDrop.click();
				 * 
				 * } //List<WebElement>
				 * designationList=driver.findElements(By.xpath("//ul/li[@class='msos-option']")
				 * ); for(int k=0;k<designationArray.length;k++) {
				 * clickWithJavaScript(driver.findElement(By.xpath(
				 * "//ul/li[@class='msos-option']/label[@title='"+designationArray[k]+"']")));
				 * 
				 * } designationDrop.click();
				 */
				WebElement schDate = lc.getSchDate();
				Thread.sleep(3000);
				keys(schDate, scheduledDate);

				// driver.switchTo().frame("WebResource_SelectTraits");
				WebElement iframe = driver.findElement(By.id("WebResource_SelectTraits"));
				try {
					driver.switchTo().frame(iframe);
				} catch (StaleElementReferenceException e) {
					// TODO Auto-generated catch block
					iframe = driver.findElement(By.id("WebResource_SelectTraits"));
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

				// driver.switchTo().frame("WebResource_selectsurveytypes");
				WebElement iframe2 = driver.findElement(By.id("WebResource_selectsurveytypes"));

				try {
					driver.switchTo().frame(iframe2);
				} catch (StaleElementReferenceException e) {
					// TODO Auto-generated catch block
					iframe2 = driver.findElement(By.id("WebResource_selectsurveytypes"));
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
				Thread.sleep(2000);
				WebElement sendSurveyButton = lc.getSendSurvey();
				click(sendSurveyButton);
				Thread.sleep(2000);
				// driver.navigate().refresh();

				// Clicking Survey link

				WebElement buttonBack = driver.findElement(By.xpath("//button[@aria-label='Press Enter to go back.']"));
				try {
					click(buttonBack);
				} catch (ElementClickInterceptedException e) {
					buttonBack = driver.findElement(By.xpath("//button[@aria-label='Press Enter to go back.']"));
					click(buttonBack);

				}
				driver.findElement(By.xpath("//span[contains(.,'" + surveyName + "')]")).click();
				System.out.println("USERNAME :" + surveyName);

				JavascriptExecutor javaScript = (JavascriptExecutor) driver;

				WebElement scrollBehaviour = driver
						.findElement(By.xpath("//h3[normalize-space()='Behavioural Questionnaire']"));
				javaScript.executeScript("arguments[0].scrollIntoView();", scrollBehaviour);
				/*
				 * WebDriverWait waitlink = new WebDriverWait(driver, Duration.ofSeconds(50));
				 * waitlink.until(ExpectedConditions.elementToBeClickable(By.
				 * xpath("//a[@aria-label='fouth user - Self - 23-07-2024']")));
				 */
				/*
				 * WebElement linkBehaviourName = driver.findElement(By.
				 * xpath("//a[@aria-label='fouth user - Self - 25-07-2024']"));
				 * linkBehaviourName.click(); WebElement surveyLink=driver.findElement(By.
				 * xpath("//input[@aria-label='Link to Survey']")); Thread.sleep(2000); String
				 * surveyLinkAssessment=surveyLink.getAttribute("value");
				 * 
				 * System.out.println("Survey Link"+surveyLinkAssessment);
				 * driver.get(surveyLinkAssessment);
				 */

				WebElement textBehaviour = driver
						.findElement(By.xpath("//h3[normalize-space()='Behavioural Questionnaire']"));

				// System.out.println("Text"+textValue);

				WebElement gridBehaviour1 = driver.findElement(By.id("dataSetRoot_Subgrid_new_1"));
				List<WebElement> elements1 = gridBehaviour1.findElements(By.tagName("a"));
				// List<WebElement> elements = driver.findElements(By.tagName("a"));
				List<String> outerSurveyLinks = new ArrayList<String>();
				List<String> innerSurveyLinks = new ArrayList<String>();
				for (int j = 0; j < elements1.size(); j++) {
					System.out.println("jhghjghghjggghj" + elements1.size());
					try {
						Thread.sleep(2000);
						WebElement gridBehaviour = driver.findElement(By.id("dataSetRoot_Subgrid_new_1"));
						List<WebElement> elements = gridBehaviour.findElements(By.tagName("a"));
						System.out.println("ABCDEDFG" + elements.size() + " and " + j);
						WebElement element = elements.get(j);

						if (elements.get(j).getAttribute("href").contains("cba_behaviouralquestionnaire")) {
							System.out.println("254255555555");
							//Thread.sleep(2000);
							String linkBehaviour = elements.get(j).getAttribute("href");
							// System.out.println("LINK"+linkBehaviour);

							outerSurveyLinks.add(linkBehaviour);
							element.click();
							  Thread.sleep(6000);
							    driver.navigate().refresh();

							// break;
							WebElement surveyLink = driver
									.findElement(By.xpath("//input[@aria-label='Link to Survey']"));

							String surveyLinks = surveyLink.getAttribute("value");
							// System.out.println("Survey Link"+surveyLinks);
							innerSurveyLinks.add(surveyLinks);
							WebElement buttonBackBQ = driver
									.findElement(By.xpath("//button[@aria-label='Press Enter to go back.']"));
							buttonBackBQ.click();

							// driver.get(surveyLinkAssessment);
							// break;
							System.out.println("List of Links" + innerSurveyLinks);
							int tagSize = outerSurveyLinks.size();
							System.out.println("Tag Size:" + tagSize);

						}

					}

					catch (StaleElementReferenceException e) {
						/*
						 * gridBehaviour=driver.findElement(By.id("dataSetRoot_Subgrid_new_1"));
						 * elements = gridBehaviour.findElements(By.tagName("a"));
						 * System.out.println("ABCDEDFG" + elements.size() +" and "+j);
						 * 
						 * WebElement element = elements.get(j);
						 * 
						 * if(elements.get(j).getAttribute("href").contains(
						 * "cba_behaviouralquestionnaire")) { System.out.println("254255555555"); String
						 * linkBehaviour=elements.get(j).getAttribute("href");
						 * //System.out.println("LINK"+linkBehaviour);
						 * 
						 * outerSurveyLinks.add(linkBehaviour); element.click(); Thread.sleep(5000);
						 */
						// break;
						WebElement surveyLink = driver.findElement(By.xpath("//input[@aria-label='Link to Survey']"));
						String surveyLinks = surveyLink.getAttribute("value");
						// System.out.println("Survey Link"+surveyLinks);
						innerSurveyLinks.add(surveyLinks);
						WebElement buttonBackBQ = driver
								.findElement(By.xpath("//button[@aria-label='Press Enter to go back.']"));
						buttonBackBQ.click();

						// driver.get(surveyLinkAssessment);
						// break;
						System.out.println("List of Links" + innerSurveyLinks);
						int tagSize = outerSurveyLinks.size();
						System.out.println("Tag Size:" + tagSize);

					}

				}
				int innerTagSize = innerSurveyLinks.size();
				System.out.println("INNER TAG SIZE" + innerTagSize);

				int selfCount = 0;
				TeamSurveyAssessment teamSurveyAssessment = new TeamSurveyAssessment();
				for (int k = 0; k < innerSurveyLinks.size(); k++) {
					System.out.println("inner check : " + innerSurveyLinks.size() + "and" + k);
					String fetchSelfLink = innerSurveyLinks.get(k).toString();
					System.out.println("Question Link :" + fetchSelfLink);

					System.out.println("Self survey link" + fetchSelfLink.contains("surveyassessmentv2"));

					if (fetchSelfLink.contains("surveyassessmentv2multi")) {
						System.out.println("Multi Assessment :" +innerSurveyLinks.get(k).toString());
						//driver.get(innerSurveyLinks.get(k).toString());
						teamSurveyAssessment.MultiTeam(innerSurveyLinks.get(k).toString());

					} else {
						System.out.println("Self Assessment");
						driver.get(innerSurveyLinks.get(k).toString());

						File fileSurveyAssessment = new File(
								"C:\\Users\\deepi\\eclipse-workspace\\BehaviourAssessment\\DataFiles\\MultipleSelfSurveyAssessment.xlsx");
						FileInputStream finSurvey = new FileInputStream(fileSurveyAssessment);
						Workbook workbookLink = new XSSFWorkbook(finSurvey);
						Sheet sheet = workbookLink.getSheet("Sheet1");

						// for (int j = 1; j < sheet.getPhysicalNumberOfRows(); j++) {
						System.out.println("Sheet Row Check : " + sheet.getPhysicalNumberOfRows());
						selfCount = selfCount + 1;
						Row rowSurveyLink = sheet.getRow(selfCount);
						System.out.println("Row No Count Check : " + (k + 1));
						// Click Button NextPage in Complete Behavioural Reoprt
						WebDriverWait waitNextPage = new WebDriverWait(driver, Duration.ofSeconds(40));
						waitNextPage.until(
								ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[@id='nextInstr']")));
						driver.findElement(By.xpath("//button[@id='nextInstr']")).click();

						// Click Button NextPage in Welcome User
						driver.findElement(By.xpath("//button[@id='nextInstr']")).click();

						// Selecting Option in Leadership Level from Excel

						System.out.println("Row count : " + sheet.getRow(4).getCell(0).toString());

						System.out.println("Row count Alternative : " + sheet.getRow(selfCount).getCell(0).toString());

						String levelLeadership = rowSurveyLink.getCell(0).getStringCellValue();
						System.out.println("Row survey link level" + levelLeadership);
						driver.findElement(By.xpath("//label[contains(.,'" + levelLeadership + "')]")).click();
						WebDriverWait leadershipNextPage = new WebDriverWait(driver, Duration.ofSeconds(20));
						leadershipNextPage.until(
								ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[@id='nextInstr']")));

						WebElement button = driver.findElement(By.xpath("//button[@id='nextInstr']"));
						JavascriptExecutor javascript = (JavascriptExecutor) driver;
						javascript.executeScript("arguments[0].click();", button);

						// Click Checkbox in Acknowledgement

						WebElement buttonCheckbox = driver
								.findElement(By.xpath("(//div[@class='custom-checkbox'])[7]"));
						buttonCheckbox.click();

						driver.findElement(By.id("startButton")).click();

						int questionCount = driver.findElements(By.xpath("//div[@class='progressbar']")).size();
						int qOneCount = 0, qTeamCount = 0;
						String className;
						for (int i1 = 1; i1 <= questionCount; i1++) {

							String question = rowSurveyLink.getCell(i1).getStringCellValue();
							// System.out.println("Excel Value :" + question);
							String[] splitAnswer = question.split(",");
							System.out.println("ccccc :" + questionCount + "and" + i1);
							// String headerText =
							// driver.findElement(By.xpath("(//div[@class='qHeaderVal'])['" + i +
							// "']")).getText();
							// System.out.println("Text :" + headerText);

							if (i1 % 2 != 0) {
								if (i1 > 1) {
									qOneCount = qOneCount + 6;

								}
								className = "questionSelectOne";
							} else {
								if (i1 > 2) {
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
									if (i1 % 2 != 0) {
										clickDropdown = driver.findElement(By.xpath(
												"(//select[@class='" + className + "'])['" + qOneCount + "'+1]"));

									} else {
										clickDropdown = driver.findElement(By.xpath(
												"(//select[@class='" + className + "'])['" + qTeamCount + "'+1]"));
									}
									Select select = new Select(clickDropdown);
									if (clickDropdown.isEnabled()) {
										// System.out.println("Drop down :" + Ans.split("-")[1]);
										select.selectByValue(Ans.split("-")[1]);
									}
								}
								if (Ans.split("-")[0].contains("b")) {
									System.out.println("abcd");
									if (i1 % 2 != 0) {
										clickDropdown = driver.findElement(By.xpath(
												"(//select[@class='" + className + "'])['" + qOneCount + "'+2]"));
									} else {
										clickDropdown = driver.findElement(By.xpath(
												"(//select[@class='" + className + "'])['" + qTeamCount + "'+2]"));
									}
									Select select = new Select(clickDropdown);
									if (clickDropdown.isEnabled()) {
										// System.out.println("Drop down :" + Ans.split("-")[1]);
										select.selectByValue(Ans.split("-")[1]);
									}
								}
								if (Ans.split("-")[0].contains("c")) {
									// System.out.println("abcd");
									if (i1 % 2 != 0) {
										clickDropdown = driver.findElement(By.xpath(
												"(//select[@class='" + className + "'])['" + qOneCount + "'+3]"));
									} else {
										clickDropdown = driver.findElement(By.xpath(
												"(//select[@class='" + className + "'])['" + qTeamCount + "'+3]"));

									}

									Select select = new Select(clickDropdown);
									if (clickDropdown.isEnabled()) {
										// System.out.println("Drop down :" + Ans.split("-")[1]);
										select.selectByValue(Ans.split("-")[1]);
									}
								}
								if (Ans.split("-")[0].contains("d")) {
									System.out.println("abcd");
									if (i1 % 2 != 0) {
										clickDropdown = driver.findElement(By.xpath(
												"(//select[@class='" + className + "'])['" + qOneCount + "'+4]"));
									} else {
										clickDropdown = driver.findElement(By.xpath(
												"(//select[@class='" + className + "'])['" + qTeamCount + "'+4]"));
									}

									Select select = new Select(clickDropdown);
									if (clickDropdown.isEnabled()) {
										System.out.println("Drop down :" + Ans.split("-")[1]);
										select.selectByValue(Ans.split("-")[1]);
									}
								}
								if (Ans.split("-")[0].contains("e")) {
									System.out.println("abcd");
									if (i1 % 2 != 0) {
										clickDropdown = driver.findElement(By.xpath(
												"(//select[@class='" + className + "'])['" + qOneCount + "'+5]"));
									} else {
										clickDropdown = driver.findElement(By.xpath(
												"(//select[@class='" + className + "'])['" + qTeamCount + "'+5]"));

									}
									Select select = new Select(clickDropdown);
									if (clickDropdown.isEnabled()) {
										System.out.println("Drop down :" + Ans.split("-")[1]);
										select.selectByValue(Ans.split("-")[1]);
									}
								}
								if (Ans.split("-")[0].contains("f")) {
									System.out.println("abcd");
									if (i1 % 2 != 0) {
										clickDropdown = driver.findElement(By.xpath(
												"(//select[@class='" + className + "'])['" + qOneCount + "'+6]"));
									} else {
										clickDropdown = driver.findElement(By.xpath(
												"(//select[@class='" + className + "'])['" + qTeamCount + "'+6]"));
									}

									Select select = new Select(clickDropdown);
									if (clickDropdown.isEnabled()) {
										System.out.println("Drop down :" + Ans.split("-")[1]);
										select.selectByValue(Ans.split("-")[1]);
									}
								}
							}
							driver.findElement(By.xpath("//button[@id='nextButton']")).click();
							Thread.sleep(2000);

						}

						// }
					}
					
					
				}

				/*
				 * WebDriverWait waitScroll = new WebDriverWait(driver, Duration.ofSeconds(70));
				 * waitScroll.until(ExpectedConditions.elementToBeClickable(By.
				 * xpath("//h3[normalize-space()='Behavioural Questionnaire']"))); WebElement
				 * iframe3 = driver.findElement(By.id("WebResource_selectsurveytypes"));
				 * driver.switchTo().frame(iframe3); //driver.navigate().refresh();
				 * //Thread.sleep(3000);
				 * 
				 * //javaScript.executeScript("window.scrollTo(0, document.body.scrollHeight)");
				 * //WebElement scrollBehaviour=driver.findElement(By.
				 * xpath("//h3[normalize-space()='Behavioural Questionnaire']"));
				 * 
				 * //driver.switchTo().defaultContent();
				 * 
				 * 
				 * 
				 * }
				 */

			}

		}
	}
}
