package org.test;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

import org.apache.commons.io.FileUtils;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DateUtil;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.Point;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

public class Baseclass {
	static WebDriver driver;

	public static void browserConfigure() {
		// Disable Notification
		/*
		 * ChromeOptions option = new ChromeOptions();
		 * option.addArguments("--disable-notifications");
		 * option.addArguments("--disable-popup-blocking");
		 * option.addArguments("disable-infobars");
		 */
		driver = new ChromeDriver();

	}

	public static void lanuchURL(String url) {
		driver.get(url);

	}

	public static void windowMaximize() {
		driver.manage().window().maximize();
	}

	public WebElement locateUsingId(String idvalue) {
		WebElement findElement = driver.findElement(By.id(idvalue));
		return findElement;

	}

	public WebElement locateUsingName(String nameValue) {
		WebElement element = driver.findElement(By.name(nameValue));
		return element;

	}

	public static void keys(WebElement ref, String data) {
		ref.sendKeys(data);

	}

	public static void click(WebElement ref) {
		ref.click();
	}

	public Alert clickOkinAlert() {
		Alert alert = driver.switchTo().alert();
		alert.accept();
		return alert;
	}

	public static void randomDelay(int minMillis, int maxMillis) {
		try {
			int delay = ThreadLocalRandom.current().nextInt(minMillis, maxMillis + 1);
			Thread.sleep(delay);
		} catch (InterruptedException e) {
			Thread.currentThread().interrupt();
		}
	}

	public Alert clickCancelinAlert() {
		Alert alert = driver.switchTo().alert();
		alert.dismiss();
		return alert;

	}

	public Alert getTextinAlert() {
		Alert alert = driver.switchTo().alert();
		alert.getText();
		return alert;

	}

	public String getTextWebpage(WebElement ref) {
		String text = ref.getText();
		return text;

	}

	public String getAttributeValue(WebElement ref, String Value) {
		String attribute = ref.getAttribute(Value);
		return attribute;
	}

	public void closeCurrentWindows() {
		driver.close();
	}

	public void closeAllWindows() {
		driver.quit();
	}

	public String getBrowserTitle() {
		String title = driver.getTitle();
		return title;

	}

	public String getBrowserUrl(String url) {
		String currentUrl = driver.getCurrentUrl();
		return currentUrl;
	}

	public static void selcetDropdownByText(WebElement ref, String value) {
		Select select = new Select(ref);
		select.selectByVisibleText(value);

	}

	public void selectDropdownByValue(WebElement ref, String value) {
		Select select = new Select(ref);
		select.selectByValue(value);
	}

	public void selectDropdownByIndex(WebElement ref, int value) {
		Select select = new Select(ref);
		select.selectByIndex(value);
	}

	public void keysUsingJavascript(WebElement element, String data) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].setAttributes('value','data')", element);
		js.executeScript("arguments[0].click()", element);
	}

	public String getParentWindowId() {
		String windowid = driver.getWindowHandle();
		return windowid;
	}
	// public String swithToChildWindow(String value) {
	// Set<String> windowHandles = driver.getWindowHandles();
	// driver.switchTo().window(value);

	// Takescreenshot}
	public WebDriver switchToFrameByIndex(int indexvalue) {
		WebDriver frame = driver.switchTo().frame(indexvalue);
		return frame;

	}

	public WebDriver switchToFrameById(String idValue) {
		WebDriver frame = driver.switchTo().frame(idValue);
		return frame;
	}

	public WebDriver swithToFrameByWebElement(WebElement element) {
		return driver.switchTo().frame(element);

	}

	public void mouseHoverAction(WebDriver d, WebElement element) {
		Actions action = new Actions(d);
		action.moveToElement(element).perform();
		;

	}

	public static void clickWithJavaScript(WebElement element) {
		JavascriptExecutor executor = (JavascriptExecutor) driver;
		executor.executeScript("arguments[0].click();", element);
	}

	public void dragAndDropAction(WebDriver d, WebElement srcElement, WebElement destElement) {
		Actions action = new Actions(d);
		action.dragAndDrop(srcElement, destElement).perform();
	}

	public void performContextClick(WebDriver driver, WebElement element) {
		Actions action = new Actions(driver);
		action.contextClick(element).perform();
		;
	}

	public void performDoubleClick(WebDriver driver, WebElement ref) {
		Actions action = new Actions(driver);
		action.doubleClick(ref).perform();
	}

	public void backTotheParentWindow() {
		driver.switchTo().defaultContent();
	}

	public void scrollUp() {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("windows.scrollBy(0,-500)");

	}

	public void scrollDown() {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("windows.scrollBy(0,500)");

	}

	public void scrollDownUpToParticularLocator(WebElement element) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView(true)", element);

	}

	public void highlightedByGreencolorandRedbox(WebElement element) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].setAttribute('style','background: green;border: solid 2px red');", element);
	}

	public void elementIsDisplayed(WebElement ref) {
		ref.isDisplayed();

	}

	public void elementIsSelected(WebElement ref) {
		ref.isSelected();
	}

	public void elementEnabled(WebElement ref) {
		ref.isEnabled();
	}

	public void navigatetonextPage() {
		driver.navigate().forward();
	}

	public void navigatetoPreviousPage() {
		driver.navigate().back();

	}

	public void navigatetoRefreshPage() {
		driver.navigate().refresh();
	}

	public void deleteAllCookies() {
		driver.manage().deleteAllCookies();
	}

	public void setSizeOfWindow(int width, int height) {
		Dimension d = new Dimension(width, height);
		driver.manage().window().setSize(d);
	}

	public void setWindowPosition(int x, int y) {
		Point p = new Point(x, y);
		driver.manage().window().setPosition(p);

	}

	public void getScreenshot(String pathValue) throws IOException {
		TakesScreenshot ss = (TakesScreenshot) driver;
		File source = ss.getScreenshotAs(OutputType.FILE);
		File dest = new File(pathValue);
		FileUtils.copyFile(source, dest);
	}

	public WebElement locateUsingXpath(String pathvalue) {
		WebElement findElement = driver.findElement(By.xpath(pathvalue));
		return findElement;
	}

	public String setCellData(String pathValue, String sheetName, int rowIndex, int cellIndex) throws IOException {
		File f = new File(pathValue);

		FileInputStream fi = new FileInputStream(f);
		Workbook w = new XSSFWorkbook(fi);
		Sheet sheet = w.getSheet(sheetName);
		Row row = sheet.getRow(rowIndex);
		Cell cell = row.getCell(cellIndex);

		int cellType = cell.getCellType();
		String Value;
		if (cellType == 1) {

			Value = cell.getStringCellValue();
			System.out.println(Value);
		} else {
			if (DateUtil.isCellDateFormatted(cell)) {
				Date date = cell.getDateCellValue();
				SimpleDateFormat simple = new SimpleDateFormat("dd/MM/YYYY");
				Value = simple.format(date);

			} else {
				double numericCellValue = cell.getNumericCellValue();
				long l = (long) numericCellValue;
				Value = String.valueOf(l);

			}
		}
		return Value;

	}

	//
	public static void selectOptionFromDropdown(WebElement ele, String value) {
		Select select = new Select(ele);
		List<WebElement> allOptions = select.getOptions();
		for (WebElement options : allOptions) {
			if (options.getText().equals(value)) {
				options.click();
				break;
			}

		}
	}

	public static void selectOptionFromDropdownCard(WebElement ele, String value) {

		Select select = new Select(ele);
		List<WebElement> options = select.getOptions();
		for (WebElement optioncard : options) {
			if (optioncard.getText().equals(value)) {
				optioncard.click();
				break;

			}

		}

	}

}
