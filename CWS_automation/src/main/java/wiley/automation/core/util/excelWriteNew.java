package wiley.automation.core.util;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.Font;
import org.apache.poi.ss.usermodel.IndexedColors;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class excelWriteNew {

    private static final String FILE_PATH = "C://testWriteStudents.xlsx";

    //We are making use of a single instance to prevent multiple write access to same file.

    private static final excelWriteNew INSTANCE = new excelWriteNew();
 
    static XSSFWorkbook workbook;
 

    public static CellStyle cellFormat(Workbook workbook) {
    	Font headerFont = workbook.createFont();
        headerFont.setBold(true);
        //headerFont.setFontHeightInPoints((short) 14);
        headerFont.setColor(IndexedColors.RED.getIndex());
        
        CellStyle headerCellStyle = workbook.createCellStyle();
        headerCellStyle.setFont(headerFont);
        
        return headerCellStyle;
    }

 

    /*public static void main(String args[]){

    	workbook = new XSSFWorkbook();
    	Sheet studentsSheet = workbook.createSheet("PricingCompare"); 
    	 
    	//writeExcel(studentsSheet, 1, 1, "Test XLS");
    	//writeExcel(studentsSheet, 1, 2, "Test XLS");
        
        closeExcel(); 
    }*/

    public static XSSFWorkbook readExcelnew()
    {
    	Sheet  studentsSheet = null;
    try{
    	//String path= System.getProperty("user.dir")+"\\output\\"+VariableController.getTestCaseName()+"\\"+VariableController.getTestCaseName()+"Output.xlsx";
    	//FileInputStream ExcelFileToRead = new FileInputStream(file);
    	String path= System.getProperty("user.dir")+"\\output\\"+VariableController.getTestCaseName()+"\\"+VariableController.getTestCaseName()+"Output.xlsx";
		String resultpath;
		
		workbook = new XSSFWorkbook();
    	studentsSheet= workbook.createSheet("PricingCompare"); 
    	//studentsSheet = workbook.getSheetAt(0);
    	
    	
    	
    }
    catch(Exception e)
    {
        e.printStackTrace();
    }
    
    return workbook;
    }
 

    public static void writeExcel(String sheetName, int colno, int rowno, String value, XSSFWorkbook workbook2){

        
    	Sheet studentsSheet = workbook2.getSheet(sheetName);
        Row row = studentsSheet.createRow(rowno);

        //first place in row is name
        Cell cell = row.createCell(colno);
        cell.setCellValue(value); 
        if(rowno == 1)
        	cell.setCellStyle(cellFormat(workbook2));
        
    }
    
    public static void closeExcel(XSSFWorkbook workbook2){

        //write this workbook in excel file.
      
            FileOutputStream fos;
			try {
				fos = new FileOutputStream(FILE_PATH);
				workbook2.write(fos);
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
