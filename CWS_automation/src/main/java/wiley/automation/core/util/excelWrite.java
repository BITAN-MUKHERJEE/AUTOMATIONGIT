package wiley.automation.core.util;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import jxl.Workbook;
import jxl.format.Colour;
import jxl.format.Pattern;
import jxl.write.WritableSheet;
import jxl.write.WritableWorkbook;

import jxl.write.Label;
import jxl.write.WritableCell;
import jxl.write.WritableCellFormat;
import jxl.write.WritableFont;
import jxl.write.WriteException;


public class excelWrite {

    static Workbook wbook;
    static WritableWorkbook wwbCopy;
    static String ExecutedTestCasesSheet;
    static WritableSheet shSheet;
    //static WritableSheet shSheet;
    static XSSFWorkbook wbook1;
    static XSSFWorkbook wwbCopy1;
    static XSSFSheet sheet;
    static XSSFRow rowhead;
    static XSSFRow row;
    static XSSFCell cell;
    static FileInputStream ExcelFileToRead;
    public static  String time=null;
    public static final String Path_TestData = System.getProperty("user.dir");
    public void readExcel(String value)
    {
    try{
    	SimpleDateFormat sdf = new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss");
		
		Timestamp timestamp = new Timestamp(System.currentTimeMillis());
		time=sdf.format(timestamp).replace(".", "_");
		String resultpath;
		
		String path= System.getProperty("user.dir")+"\\output\\"+VariableController.getTestCaseName()+"\\"+VariableController.getTestCaseName()+"Output.xls";
		if(value=="Pricing")
			resultpath= Path_TestData +  "/tests/DataEngine2.xls";
		if(value=="Non")
			resultpath= Path_TestData +  "/tests/DataEngine3.xls";
		else
			resultpath= Path_TestData +  "/tests/DataEngine1.xls";
    	
    	
    //wbook = Workbook.getWorkbook(new File("C:\\Users\\apsinha\\workspace\\tax_calculation\\src\\main\\java\\dataengine\\DateEngine1.xls"));
		wbook = Workbook.getWorkbook(new File(resultpath));
		wwbCopy = Workbook.createWorkbook(new File(path),wbook);	
    //wwbCopy = Workbook.createWorkbook(new File("C:\\Users\\apsinha\\workspace\\tax_calculation\\src\\main\\java\\dataengine\\Dataenginecopy1.xls"), wbook);
		
		
    shSheet = wwbCopy.getSheet(0);
    }
    catch(Exception e)
    {
        e.printStackTrace();
    }
    }
    
    public void readExcelnew()
    {
    try{
    	//String path= System.getProperty("user.dir")+"\\output\\"+VariableController.getTestCaseName()+"\\"+VariableController.getTestCaseName()+"Output.xlsx";
    	//FileInputStream ExcelFileToRead = new FileInputStream(file);
    	String path= System.getProperty("user.dir")+"\\output\\"+VariableController.getTestCaseName()+"\\"+VariableController.getTestCaseName()+"Output.xlsx";
		String resultpath;
		
			resultpath= Path_TestData +  "/tests/DataCheck.xlsx";
		
			wbook1 = new XSSFWorkbook(resultpath);

			//output new excel file to which we need to copy the above sheets
			//this would copy entire workbook from source
			wwbCopy1=wbook1;
			sheet = wwbCopy1.getSheetAt(0);
    	
    }
    catch(Exception e)
    {
        e.printStackTrace();
    }
    }
    
   
	public static void writeCellData(String strSheetName,int iColumnNumber, int iRowNumber,String strData) throws Exception{
    	 
       // fos=new FileOutputStream(file);
      //  System.out.println("Writing the Data to the Excel in rownum:" + rowNum +"::colNum:: "+colNum+"::content::" + content );
		sheet = wwbCopy1.getSheet(strSheetName);
       cell = wwbCopy1.getSheet(strSheetName).getRow(iRowNumber).createCell(iColumnNumber);
       cell.setCellValue(strData);
       
    
   }

    
    public static void setValueIntoCell(String strSheetName,int iColumnNumber, int iRowNumber,String strData) throws WriteException
    {
        WritableSheet wshTemp = wwbCopy.getSheet(strSheetName);
        Label labTemp = new Label(iColumnNumber, iRowNumber, strData);
                
        try {
            wshTemp.addCell(labTemp);
             } 
            catch (Exception e) 
            {
                e.printStackTrace();
            }
    }
    
    public static void setValueIntoCellCol(String strSheetName,int iColumnNumber, int iRowNumber,String strData) throws WriteException
    {
        WritableSheet wshTemp = wwbCopy.getSheet(strSheetName);
        WritableCell c = wshTemp.getWritableCell(iColumnNumber,iRowNumber);
        WritableCellFormat newFormat = new WritableCellFormat();

        newFormat.setBackground(Colour.RED);
        
        
        //Label labTemp = new Label(iColumnNumber, iRowNumber, strData, getCellFormat(Colour.RED, Pattern.GRAY_25));
        Label labTemp = new Label(iColumnNumber, iRowNumber, strData, getCellFormat(Colour.RED));
                
        try {
            wshTemp.addCell(labTemp);
            //c.setCellFormat(newFormat);
            
             } 
            catch (Exception e) 
            {
                e.printStackTrace();
            }
    }
    
   // private static WritableCellFormat getCellFormat(Colour colour, Pattern pattern) throws WriteException {
    private static WritableCellFormat getCellFormat(Colour colour) throws WriteException {
    WritableFont cellFont = new WritableFont(WritableFont.ARIAL, 10);
        WritableCellFormat cellFormat = new WritableCellFormat(cellFont);
        cellFormat.setBackground(colour);
        return cellFormat;
      }
    
    public void closeFile()
    {
        try {
            // Closing the writable work book
            wwbCopy.write();
            wwbCopy.close();

            // Closing the original work book
            wbook.close();
        } catch (Exception e)

        {
            e.printStackTrace();
        }
    }
    public void closeFilexlsx()
    {
        try {
            // Closing the writable work book
        	String path= System.getProperty("user.dir")+"\\output\\"+VariableController.getTestCaseName()+"\\"+VariableController.getTestCaseName()+"Output.xlsx";
        	FileOutputStream fos = new FileOutputStream(path);
        	 
        		wwbCopy1.write(fos);
        	 fos.close();
        	 wwbCopy.close();

            // Closing the original work book
            
        } catch (Exception e)

        {
            e.printStackTrace();
        }
    }

}

