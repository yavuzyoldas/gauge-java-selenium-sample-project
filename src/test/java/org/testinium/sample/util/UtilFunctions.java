package org.testinium.sample.util;

import java.io.*;

import org.apache.poi.ss.usermodel.*;

public class UtilFunctions {

    public static String readDataFromExcel(int rowPoint,int columnPoint){

        String path = "src/main/resources/data.xlsx"; // Yolu güncelleyin

        // File nesnesi oluşturun
        File file = new File(path);

        // Yolun bir klasör olup olmadığını kontrol edin
        if (file.exists()) {
            System.out.println("Bu yol bir dosyadır vardır.");
        } else {
            System.out.println("Bu yol bir klasör değildir veya mevcut değildir.");
        }




        String excelFilePath = "src/main/resources/data.xlsx";
        Cell data = null;

        try {
            FileInputStream inputStream = new FileInputStream(excelFilePath);
            Workbook workbook = WorkbookFactory.create(inputStream);
            Sheet sheet = workbook.getSheetAt(0);
            data = sheet.getRow(rowPoint).getCell(columnPoint);
            if (data == null) {
                Log.error("Excel data is null!!!!!!!!!!!");
                System.out.println("Excel data is null!!!!!!!!!!!");
            }
            workbook.close();

        } catch (IOException e) {
            Log.error(e.getMessage());
            System.out.println("excel hata" + e.getMessage());
        }
        return data != null ? data.toString() : "null";
    }

    public static void saveToTxtFile(String detail, String price) {
        String filePath = "src/main/resources/detail.txt";
        String information = detail+"," +price;


        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filePath))) {
            writer.write(information);
            Log.info("Details have been saved."+ information);

        } catch (IOException e) {
            Log.error("Error:"+ e.getMessage());
            System.out.println("saveToTxtFile hata" + e.getMessage());
        }
    }

}
