//package utils;
//
//
//import java.io.FileReader;
//import java.io.IOException;
//
//
//import org.apache.poi.ss.usermodel.Cell;
//import org.apache.poi.ss.usermodel.Row;
//import org.apache.poi.ss.usermodel.Sheet;
//import org.apache.poi.ss.usermodel.Workbook;
//import org.apache.poi.xssf.usermodel.XSSFWorkbook;
//
//import java.io.FileInputStream;
//import java.io.FileNotFoundException;
//
//
//public class Utilities {
//    public String readTestData(int vRow, int vColumn) {
//        String value = null;
//        Workbook wb = null;
//        try {
//
//            FileInputStream fis = new FileInputStream("src/test/TestData/TestData.xlsx");
//            wb = new XSSFWorkbook(fis);
//        } catch (FileNotFoundException e) {
//            e.printStackTrace();
//        } catch (IOException e1) {
//            e1.printStackTrace();
//        }
//        Sheet sheet = wb.getSheetAt(0);
//        Row row = sheet.getRow(vRow);
//        Cell cell = row.getCell(vColumn);
//        value = cell.getStringCellValue();
//        return value;
//    }
//}
package utils;

import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileInputStream;
import java.io.IOException;

public class Utilities {

    public String readTestData(int vRow, int vColumn) {
        String value = "";

        try (FileInputStream fis = new FileInputStream("src/test/TestData/TestData.xlsx"); Workbook wb = new XSSFWorkbook(fis)) {

            Sheet sheet = wb.getSheetAt(0);
            Row row = sheet.getRow(vRow);
            Cell cell = row.getCell(vColumn);

            if (cell != null) {
                switch (cell.getCellType()) {
                    case STRING:
                        value = cell.getStringCellValue().trim();
                        break;
                    case NUMERIC:
                        double numericValue = cell.getNumericCellValue();
                        if (numericValue == Math.floor(numericValue)) {
                            value = String.valueOf((long) numericValue);
                        } else {
                            value = String.valueOf(numericValue);
                        }
                        break;

                    default:
                        value = "";
                }
            }

        } catch (IOException e) {
            e.printStackTrace();
        }

        return value;
    }
}

