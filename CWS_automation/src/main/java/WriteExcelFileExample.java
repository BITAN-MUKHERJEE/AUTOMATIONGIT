
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.Font;
import org.apache.poi.ss.usermodel.IndexedColors;
import org.apache.poi.ss.usermodel.Row;

import org.apache.poi.ss.usermodel.Sheet;

import org.apache.poi.ss.usermodel.Workbook;

import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileNotFoundException;

import java.io.FileOutputStream;

import java.io.IOException;

import java.util.ArrayList;

import java.util.List;

public class WriteExcelFileExample {

    private static final String FILE_PATH = "C://testWriteStudents.xlsx";

    //We are making use of a single instance to prevent multiple write access to same file.

    private static final WriteExcelFileExample INSTANCE = new WriteExcelFileExample();
 
    static Workbook workbook;
 

    public static CellStyle cellFormat(Workbook workbook) {
    	Font headerFont = workbook.createFont();
        headerFont.setBold(true);
        //headerFont.setFontHeightInPoints((short) 14);
        headerFont.setColor(IndexedColors.RED.getIndex());
        
        CellStyle headerCellStyle = workbook.createCellStyle();
        headerCellStyle.setFont(headerFont);
        
        return headerCellStyle;
    }

 

    public static void main(String args[]){

    	workbook = new XSSFWorkbook();
    	Sheet studentsSheet = workbook.createSheet("New XLS"); 
    	 
        writeStudentsListToExcel(studentsSheet, 1, 1, "Test XLS");
        writeStudentsListToExcel(studentsSheet, 1, 2, "Test XLS");
        
        closeExcel(); 
    }

 

    public static void writeStudentsListToExcel(Sheet studentsSheet, int colno, int rowno, String value){

        

        Row row = studentsSheet.createRow(rowno);

        //first place in row is name
        Cell cell = row.createCell(colno);
        cell.setCellValue(value); 
        if(rowno == 1)
        	cell.setCellStyle(cellFormat(workbook));
        
    }
    
    public static void closeExcel(){

        //write this workbook in excel file.
      
            FileOutputStream fos;
			try {
				fos = new FileOutputStream(FILE_PATH);
				workbook.write(fos);
	            fos.close();
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
             

            System.out.println(FILE_PATH + " is successfully written");
    }

}
