package org.testinium.sample.util;

import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;

import org.apache.poi.ss.usermodel.*;

public class UtilFunctions {

    public static String readDataFromExcel(int rowPoint,int columnPoint){

        String excelFilePath = "src/test/resources/data.xlsx";
        Cell data = null;

        try {
            FileInputStream inputStream = new FileInputStream(excelFilePath);
            Workbook workbook = WorkbookFactory.create(inputStream);
            Sheet sheet = workbook.getSheetAt(0);
            data = sheet.getRow(rowPoint).getCell(columnPoint);
            if (data == null) {
                Log.error("Excel data is null!!!!!!!!!!!");
            }
            workbook.close();

        } catch (IOException e) {
            Log.error(e.getMessage());
        }
        return data != null ? data.toString() : "null";
    }

    public static void saveToTxtFile(String detail, String price) {
        String filePath = "src/test/resources/detail.txt";
        String information = detail+"," +price;


        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filePath))) {
            writer.write(information);
            Log.info("Details have been saved."+ information);
        } catch (IOException e) {
            Log.error("Error:"+ e.getMessage());
        }
    }

}
