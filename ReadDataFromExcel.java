package com.utilities;


import com.helper.TestcaseHelper;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

public class ReadDataFromExcel extends TestcaseHelper //To read Test Data stored in Excel file under resource folder

{

    public static String configPath = System.getProperty("user.dir") + "/src/test/java/com/unity/set-up/";

    public static String readDataFromExcel(String Data,int rowno, int col) throws IOException

    {

        InputStream fs = new FileInputStream(configPath+"TestData.xlsx");
        XSSFWorkbook wb = new XSSFWorkbook(fs);
        XSSFSheet sh = wb.getSheet(Data);
        Row row = sh.getRow(rowno);
        Cell cell = row.getCell(col);
        cell.setCellType ( Cell.CELL_TYPE_STRING );//to convert data into string format as excel column are  always in string format
        return cell.getStringCellValue();
    }


}

