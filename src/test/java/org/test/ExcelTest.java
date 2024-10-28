package org.test;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;

public class ExcelTest {

	public static void main(String[] args) throws IOException {
		File fileSurveyAssessment = new File(
				"C:\\Users\\deepi\\eclipse-workspace\\BehaviourAssessment\\DataFiles\\MultipleSelfSurveyAssessment.xlsx");
		FileInputStream finSurvey = new FileInputStream(fileSurveyAssessment);
		Workbook workbookLink = new XSSFWorkbook(finSurvey);
		Sheet sheet = workbookLink.getSheet("Sheet1");
		for (int j = 1; j < sheet.getPhysicalNumberOfRows(); j++) {
			System.out.println("Row count"+sheet.getPhysicalNumberOfRows());
			Row rowSurveyLink = sheet.getRow(j);
		
			rowSurveyLink.getCell(0).getStringCellValue();
			
		}

	}

}
