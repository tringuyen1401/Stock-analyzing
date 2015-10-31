package jdbc;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Iterator;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author tri
 */
public class IS {

    public static void main(String[] args) throws ClassNotFoundException, InstantiationException, IllegalAccessException, Exception {
        IS obj = new IS();
        System.out.println(obj.read_IS("AAA", 7, 2014));
    }

    String read_IS(String company, Integer rownumber, Integer data_year) { // linenumber > 5
        Integer rowindex = 2;
        Integer n = 0;
        Integer y = 0;
        Integer colindex = -1;//number of years in the file
        Integer max_year = 2014;
        String result = "N/A";
        DataFormatter fmt = new DataFormatter();
        try {
            FileInputStream file = new FileInputStream(new File("C:\\Users\\tri\\Desktop\\busi\\data\\All\\" + company + "_IS.xlsx"));

            XSSFWorkbook workbook = new XSSFWorkbook(file);
            XSSFSheet sheet = workbook.getSheetAt(0);
            Iterator<Row> rowIterator = sheet.iterator();
            while (rowIterator.hasNext()) {

                Row row = rowIterator.next();
                if (rowindex > 3 && rowindex < 25) {
                    if (rowindex == 4) {
                        Iterator<Cell> cellIterator = row.cellIterator();
                        while (cellIterator.hasNext()) {
                            Cell cell = cellIterator.next();
                            colindex++;
                        }
                    }
                
                if (rowindex == rownumber) {
                    Iterator<Cell> cellIterator = row.cellIterator();
                    if (data_year == 999) {
                            Cell cell = cellIterator.next();
                            result = fmt.formatCellValue(cell);
                            
                            return result;
                        }
                    while (cellIterator.hasNext()) {
                        Cell cell = cellIterator.next();
                        y = colindex + data_year - max_year; //get the number of cells we need to jump 
                        if (y > 0) {
                        if (y == n) {//go through the cells till reach right one
                            
                            return result = fmt.formatCellValue(cell);
                        }
                        n++;
                        }
                        
                    }

                }
                }
                rowindex++;
            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if ("".equals(result) || "-".equals(result) || "N/A".equals(result)) {
                return "0.0";
            } else {
                return result;
            }
        }
    }

    String import_IS(String company, Integer linenumber, Integer data_year) { // linenumber > 5
        Integer rowindex = 2;
        Integer colindex = 8;
        Integer max_year = 2014;
        String result = null;
        DataFormatter fmt = new DataFormatter();
        try {
            FileInputStream file = new FileInputStream(new File("C:\\Users\\tri\\Desktop\\busi\\data\\All\\" + company + "_IS.xlsx"));

            XSSFWorkbook workbook = new XSSFWorkbook(file);
            XSSFSheet sheet = workbook.getSheetAt(0);
            Iterator<Row> rowIterator = sheet.iterator();
            while (rowIterator.hasNext()) {
                Row row = rowIterator.next();
                if (rowindex > 3 && rowindex < 25) {

                    if (rowindex == 4) {
                        Iterator<Cell> cellIterator = row.cellIterator();
                        Cell cell = cellIterator.next();
                        while (cellIterator.hasNext()) {
                            cell = cellIterator.next();
                            return result = fmt.formatCellValue(cell);
                        }

                    }

                    if (rowindex == linenumber) {

                        Iterator<Cell> cellIterator = row.cellIterator();
                        if (data_year == 999) {

                            Cell cell = cellIterator.next();

                            result = fmt.formatCellValue(cell);

                        } else {

                            while (cellIterator.hasNext()) {

                                Cell cell = cellIterator.next();

                                return result = fmt.formatCellValue(cell);

                            }

                        }

                    }
                }
                rowindex++;

            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            return result;
        }
    }

    String import_IS_Current(String company, Integer linenumber, Integer data_year) { // linenumber > 5
        Integer b = 3;
        Integer c = 0;
        Integer y = 0;
        Integer n = 0;
        String result = null;
        DataFormatter fmt = new DataFormatter();
        try {
            FileInputStream file_IS = new FileInputStream(new File("C:\\Users\\tri\\Desktop\\busi\\data\\Current\\" + company + "_IS.xlsx"));

            XSSFWorkbook workbook_IS = new XSSFWorkbook(file_IS);
            XSSFSheet sheet_IS = workbook_IS.getSheetAt(0);
            Iterator<Row> rowIterator_IS = sheet_IS.iterator();
            while (rowIterator_IS.hasNext()) {
                Row row = rowIterator_IS.next();
                if (b > 4 && b < 25) {

                    if (b == 5) {
                        Iterator<Cell> cellIterator = row.cellIterator();
                        while (cellIterator.hasNext()) {
                            Cell cell = cellIterator.next();
                            c = c + 1;
                        }

                    }

                    if (b == linenumber) {

                        Iterator<Cell> cellIterator = row.cellIterator();
                        if (data_year == 999) {

                            Cell cell = cellIterator.next();

                            result = fmt.formatCellValue(cell);

                        } else {
                            y = c + data_year - 2014;
                            if (y > 0) {

                                while (cellIterator.hasNext()) {

                                    Cell cell = cellIterator.next();
                                    if (n == y) {
                                        result = fmt.formatCellValue(cell);
                                    }
                                    n = n + 1;
                                }
                            } else {
                                result = "N/A";
                            }
                        }

                    }
                }
                b = b + 1;

            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            return result;
        }
    }
}
