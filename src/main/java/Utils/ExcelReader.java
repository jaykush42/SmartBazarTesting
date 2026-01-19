package Utils;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.*;
import java.io.IOException;
import java.io.InputStream;

public class ExcelReader {

    // Method to read Excel file from resources folder
    public static Object[][] readExcel(String fileName, String sheetName) throws IOException, InvalidFormatException {
        // Get InputStream from resources folder using ClassLoader
        InputStream fis = ExcelReader.class.getClassLoader().getResourceAsStream( fileName);

        if (fis == null) {
            throw new RuntimeException("File '" + fileName + "' not found in resources folder.");
        }

        // Create a Workbook from the InputStream
        Workbook workbook = WorkbookFactory.create(fis);
        Sheet sheet = workbook.getSheet(sheetName);

        if (sheet == null) {
            throw new RuntimeException("Sheet with name '" + sheetName + "' not found in the Excel file.");
        }

        int rows = sheet.getPhysicalNumberOfRows();
        int cols = sheet.getRow(0).getPhysicalNumberOfCells();

        Object[][] data = new Object[rows - 1][cols];  // Skip header row

        for (int i = 1; i < rows; i++) {  // Start from row 1 to skip header
            Row row = sheet.getRow(i);
            for (int j = 0; j < cols; j++) {
                data[i - 1][j] = row.getCell(j).toString();
            }
        }

        workbook.close();
        fis.close();
        return data;
    }
}
