import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Date;
import java.util.Iterator;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;


public class ReadExcel {
	
    public static void main(String[] args) {
        String company = "DHC";
		try {
             
            FileInputStream file = new FileInputStream(new File("C:\\Users\\tri\\Desktop\\busi\\"+company+".xlsx"));
             
             //Get the workbook instance for XLS file 
            XSSFWorkbook workbook = new XSSFWorkbook(file);
 
            //Get first sheet from the workbook
            XSSFSheet sheet = workbook.getSheetAt(0);
 
            //Get iterator to all the rows in current sheet
            Iterator <Row> rowIterator = sheet.iterator();
 

            while(rowIterator.hasNext()) {
                Row row = rowIterator.next();
                 
                //For each row, iterate through each columns
                Iterator<Cell> cellIterator = row.cellIterator();
                while(cellIterator.hasNext()) {
                     
                    Cell cell = cellIterator.next();
                     
                    switch(cell.getCellType()) {
                        case Cell.CELL_TYPE_BOOLEAN:
                            System.out.print(cell.getBooleanCellValue() + "\t\t");
                            break;
                        case Cell.CELL_TYPE_NUMERIC:
                            System.out.print(cell.getNumericCellValue() + "\t\t");
                            break;
                        case Cell.CELL_TYPE_STRING:
                            System.out.print(cell.getStringCellValue() + "\t\t");
                            break;
                    }
                }
                System.out.println("");
            }
            file.close();
            FileOutputStream out = 
                new FileOutputStream(new File("C:\\Users\\tri\\Desktop\\busi\\AMC.xls"));
            workbook.write(out);
            out.close();
             
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
}
}