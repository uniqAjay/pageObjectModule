package Utility;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class ReadExcelFile {

	public static void main(String[] args) throws EncryptedDocumentException, IOException {

		ReadExcelFile file = new ReadExcelFile();
		file.readExcelFIle("Sheet1");
	}

	public String[][] readExcelFIle(String logIn) throws EncryptedDocumentException, IOException {

		File excelFilePath = new File("C:\\Users\\ajayg\\eclipse-workspace\\PageObjectModule\\src\\test\\resources\\testdata\\testData.xlsx");
		FileInputStream excelFileData = new FileInputStream(excelFilePath);
		Workbook wb = WorkbookFactory.create(excelFileData);
		Sheet sheetName = wb.getSheet(logIn);
		int totalRows = sheetName.getLastRowNum();
		System.out.println(totalRows);
		Row rowcells = sheetName.getRow(0);
		int totalCols = rowcells.getLastCellNum();
		System.out.println(totalCols);

		String testData[][] = new String[totalRows][totalCols];
		DataFormatter formatData = new DataFormatter();
		for (int i = 1; i <= totalRows; i++) {
			for (int j = 0; j < totalCols; j++) {
				testData[i - 1][j] = formatData.formatCellValue(sheetName.getRow(i).getCell(j));
				System.out.println(testData[i-1][j]);
			}

		}

		return testData;

	}

}
