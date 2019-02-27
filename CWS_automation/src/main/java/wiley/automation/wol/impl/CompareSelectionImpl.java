package wiley.automation.wol.impl;


import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.Font;
import org.apache.poi.ss.usermodel.IndexedColors;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

import jxl.write.WriteException;
import wiley.automation.core.util.CommonUtil;
import wiley.automation.core.util.CompareTwoImages;
import wiley.automation.core.util.EnvUtil;
import wiley.automation.core.util.ObjectLocator;
import wiley.automation.core.util.ReadExcelDataProvider;
import wiley.automation.core.util.VariableController;
import wiley.automation.core.util.excelWrite;
import wiley.automation.core.util.excelWriteNew;
import wiley.automation.wol.workflow.LoginPage;

public class CompareSelectionImpl extends ObjectLocator {

 static //Logger log = Logger.getLogger(HomePageImpl.class);
 String msg;
 static String idname,getDOI;
 static int k=1;
 static int q=1;
 static int rowtocheck=0;
static Sheet  studentsSheet;
static Workbook workbook;

 public static void readExcelnew()
 {

	workbook = new XSSFWorkbook();
 	studentsSheet= workbook.createSheet("PricingCompare"); 
 	//studentsSheet = workbook.getSheetAt(0);
 	


 }


 public static void writeExcel(String sheetName, int colno, int rowno, String value, XSSFWorkbook workbook2){

     
 	//studentsSheet = workbook.getSheet(sheetName);
     Row row = studentsSheet.createRow(rowno);

     //first place in row is name
     Cell cell = row.createCell(colno);
     cell.setCellValue(value); 
    /* if(rowno == 1)
     	cell.setCellStyle(cellFormat(workbook));*/
     
 }
 
 /*public static CellStyle cellFormat(Workbook workbook2) {
 	Font headerFont = workbook.createFont();
     headerFont.setBold(true);
     //headerFont.setFontHeightInPoints((short) 14);
     headerFont.setColor(IndexedColors.RED.getIndex());
     
     CellStyle headerCellStyle = workbook.createCellStyle();
     headerCellStyle.setFont(headerFont);
     
     return headerCellStyle;
 }*/


public static void closeExcel(){

     //write this workbook in excel file.
   
         FileOutputStream fos;
			try {
				String FILE_PATH = "C://testWriteStudents.xlsx";
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
          

        
 }
 
 


public static boolean checkcustomerSC(String volumne, String value) {
	// TODO Auto-generated method stub
	CommonUtil.clicksync(admin);
	CommonUtil.clicksync(identi);
	CommonUtil.sleep(500);
	String value1="code:"+value;
    CommonUtil.sendKeys(publicval, value1);
    CommonUtil.clicksync(search);
    CommonUtil.sleep(10000);
    int flag=0;
    while(true){
           if((CommonUtil.driver.findElements(By.xpath("//div[contains(@id, 'window_close')]")).size()>0) && (flag!=40)){
                  //click on >>
                  CommonUtil.driver.findElement(By.xpath("//div[contains(@id, 'window_close')]")).click();
                  CommonUtil.sleep(10000);
                  CommonUtil.clicksync(search);
                  flag=flag+1;
           }else{
        	   if(flag>2)
                  break;
        	   else{
        		   CommonUtil.sleep(10000);
        		   flag++;
        	   }
        		   
           }
                  
    }
    CommonUtil.sleep(2000);
       
    
    String fetchdata= CommonUtil.getTitle();
    String[] dataArray1= fetchdata.split(" - ");
    fetchdata=dataArray1[2];
    if(fetchdata.equalsIgnoreCase(value))
    {
           msg = "The customer has been created and fetched succesfully";       
           CommonUtil.report(msg,pass);
//           CommonUtil.driver.findElement(By.xpath("//*[@class='v-menubar v-widget user-account-menu v-menubar-user-account-menu']")).click();
//           CommonUtil.driver.findElement(By.xpath("//*[@class='v-menubar-submenu v-widget user-account-menu v-menubar-submenu-user-account-menu']")).click();
//           CommonUtil.driver.findElement(By.xpath("//*[@class='v-slot v-align-center v-align-middle']/div/div")).click();
           return true;
    }
    msg = "The customer has been not been created properly";      
    CommonUtil.report(msg,fail);
    return false;
}

public static void waitfordata() {
	// TODO Auto-generated method stub
	CommonUtil.clicksyncALM(stateValue);
}

public static void navigateToUATPage() {
	// TODO Auto-generated method stub
	
	CommonUtil.refresh(EnvUtil.getProperty("UAT_URL"));
	CommonUtil.sleep(2000);
	}

public static void navigateToWIPPage() {
	// TODO Auto-generated method stub
	CommonUtil.refresh(EnvUtil.getProperty("WIP_URL"));
	CommonUtil.sleep(2000);
}

public static boolean compareUATWIP(String Username, String Password, String Volumne) throws WriteException {
	// TODO Auto-generated method stub
	excelWrite ds = new excelWrite();
	ds.readExcel("compare");
	CommonUtil.clicksync(clickOnSelection);
	
	   
    CommonUtil.driver.findElement(By.id("dropdownMenu1")).click();
	CommonUtil.driver.findElement(By.xpath(".//*[@id='years']/li[10]/a")).click();
	
	CommonUtil.sleep(7000);
	CommonUtil.clicksync(clickOnEntries);
	Select number = new Select(CommonUtil.driver.findElement(By.xpath(".//*[@id='myTable_length']/label/select")));
    number.selectByVisibleText("All");
    
    CommonUtil.clicksync(clickOnSearch);
        
    List<WebElement> title = CommonUtil.driver.findElements(By.xpath(".//table[@id='myTable']/tbody/tr"));
    System.out.println(title.size());
    
    excelWrite.setValueIntoCell("UATdetails",0,0,"Acronym");
	excelWrite.setValueIntoCell("UATdetails",1,0,"ISSN");
	excelWrite.setValueIntoCell("UATdetails",2,0,"Title");
	excelWrite.setValueIntoCell("UATdetails",3,0,"Status");
	excelWrite.setValueIntoCell("UATdetails",4,0,"Codegroup");
	
	excelWrite.setValueIntoCell("WIPdetails",0,0,"Acronym");
	excelWrite.setValueIntoCell("WIPdetails",1,0,"ISSN");
	excelWrite.setValueIntoCell("WIPdetails",2,0,"Title");
	excelWrite.setValueIntoCell("WIPdetails",3,0,"Status");
	excelWrite.setValueIntoCell("WIPdetails",4,0,"Codegroup");
	
	excelWrite.setValueIntoCell("CompareSame",0,0,"Acronym");
	excelWrite.setValueIntoCell("CompareSame",1,0,"ISSN");
	excelWrite.setValueIntoCell("CompareSame",2,0,"Title");
	excelWrite.setValueIntoCell("CompareSame",3,0,"Status");
	excelWrite.setValueIntoCell("CompareSame",4,0,"Codegroup");
	
	excelWrite.setValueIntoCell("CompareDifferent",0,0,"WIPAcronym");
	excelWrite.setValueIntoCell("CompareDifferent",1,0,"WIPISSN");
	excelWrite.setValueIntoCell("CompareDifferent",2,0,"WIPTitle");
	excelWrite.setValueIntoCell("CompareDifferent",3,0,"WIPStatus");
	excelWrite.setValueIntoCell("CompareDifferent",4,0,"WIPCodegroup");
	excelWrite.setValueIntoCell("CompareDifferent",6,0,"UATAcronym");
	excelWrite.setValueIntoCell("CompareDifferent",7,0,"UATISSN");
	excelWrite.setValueIntoCell("CompareDifferent",8,0,"UATTitle");
	excelWrite.setValueIntoCell("CompareDifferent",9,0,"UATStatus");
	excelWrite.setValueIntoCell("CompareDifferent",10,0,"UATCodegroup");
	
	excelWrite.setValueIntoCell("UniqueInWIP",0,0,"Acronym");
	excelWrite.setValueIntoCell("UniqueInWIP",1,0,"ISSN");
	excelWrite.setValueIntoCell("UniqueInWIP",2,0,"Title");
	excelWrite.setValueIntoCell("UniqueInWIP",3,0,"Status");
	excelWrite.setValueIntoCell("UniqueInWIP",4,0,"Codegroup");
	
	excelWrite.setValueIntoCell("NotPresentinWIP",0,0,"Acronym");
	excelWrite.setValueIntoCell("NotPresentinWIP",1,0,"ISSN");
	excelWrite.setValueIntoCell("NotPresentinWIP",2,0,"Title");
	excelWrite.setValueIntoCell("NotPresentinWIP",3,0,"Status");
	excelWrite.setValueIntoCell("NotPresentinWIP",4,0,"Codegroup");
    
    List<String> WIP_JOURNALS = new ArrayList<String>();
    List <String> ACRONYM_OF_WIP_JOURNALS = new ArrayList<String>();
    List<String> ISSN_OF_WIP_JOURNALS = new ArrayList<String>();
    List<String> STATUSCODE_OF_WIP_JOURNALS = new ArrayList<String>();
    List<String> CODEGROUP_OF_WIP_JOURNALS = new ArrayList<String>();
    int totalSize=0;
    
    if(!Volumne.equals("ALL")){
    	
    	totalSize=Integer.parseInt(Volumne);
    }
    else{
    	totalSize=title.size();
    }
    
  for (int i = 1; i<=totalSize; i++)
   // for (int i = 1; i<=5; i++)
    	
    {
    	
		String arr = CommonUtil.driver.findElement(By.xpath(".//table[@id='myTable']/tbody/tr["+i+"]/td[3]")).getText();
		ACRONYM_OF_WIP_JOURNALS.add(arr); 
		excelWrite.setValueIntoCell("WIPdetails",0,i,arr);
		
		String arr2 = CommonUtil.driver.findElement(By.xpath(".//table[@id='myTable']/tbody/tr["+i+"]/td[4]")).getText(); 
    	ISSN_OF_WIP_JOURNALS.add(arr2);
    	excelWrite.setValueIntoCell("WIPdetails",1,i,arr2);
    	
    	String arr3= CommonUtil.driver.findElement(By.xpath(".//table[@id='myTable']/tbody/tr["+i+"]/td[5]")).getText();
    	WIP_JOURNALS.add(arr3);
    	excelWrite.setValueIntoCell("WIPdetails",2,i,arr3);
    	   		
    	String arr4 = CommonUtil.driver.findElement(By.xpath(".//table[@id='myTable']/tbody/tr["+i+"]/td[6]")).getText();
    	STATUSCODE_OF_WIP_JOURNALS.add(arr4);
    	excelWrite.setValueIntoCell("WIPdetails",3,i,arr4);
    	
    	String arr5 = CommonUtil.driver.findElement(By.xpath(".//table[@id='myTable']/tbody/tr["+i+"]/td[7]")).getText();
    	CODEGROUP_OF_WIP_JOURNALS.add(arr5); 	
    	excelWrite.setValueIntoCell("WIPdetails",4,i,arr5);
    	
    	System.out.println(i);
    }
  
  	msg = "The WIP Details has been captured succesfully";       
  	CommonUtil.report(msg,pass);

	CommonUtil.refresh(EnvUtil.getProperty("UAT_URL"));
	CommonUtil.sleep(1000);
	
	LoginPage.LoginUAT(Username,Password);
	
	CommonUtil.clicksync(clickOnSelection);
	CommonUtil.clicksync(clickOnEntries);
	
    
    CommonUtil.driver.findElement(By.id("dropdownMenu1")).click();
   	CommonUtil.driver.findElement(By.xpath(".//*[@id='years']/li[10]/a")).click();
   	
   	CommonUtil.sleep(5000);
	
   	Select number1 = new Select(CommonUtil.driver.findElement(By.xpath(".//*[@id='myTable_length']/label/select")));
    number1.selectByVisibleText("All");
    
    CommonUtil.clicksync(clickOnSearch);
        
    List<WebElement> title1 = CommonUtil.driver.findElements(By.xpath(".//table[@id='myTable']/tbody/tr"));
    System.out.println(title1.size());
    
    List<String> UAT_JOURNALS = new ArrayList<String>();
    List <String> ACRONYM_OF_UAT_JOURNALS = new ArrayList<String>();
    List<String> ISSN_OF_UAT_JOURNALS = new ArrayList<String>();
    List<String> STATUSCODE_OF_UAT_JOURNALS = new ArrayList<String>();
    List<String> CODEGROUP_OF_UAT_JOURNALS = new ArrayList<String>();
    
    totalSize=0;
    if(!Volumne.equals("ALL")){
    	
    	totalSize=Integer.parseInt(Volumne);
    }
    else{
    	totalSize=title1.size();
    }
    
    for (int i = 1; i<=totalSize; i++)
    //for (int i = 1; i<=5; i++)	
    {
    	
		String arr = CommonUtil.driver.findElement(By.xpath(".//table[@id='myTable']/tbody/tr["+i+"]/td[3]")).getText();
		ACRONYM_OF_UAT_JOURNALS.add(arr); 
		excelWrite.setValueIntoCell("UATdetails",0,i,arr);
		
		String arr2 = CommonUtil.driver.findElement(By.xpath(".//table[@id='myTable']/tbody/tr["+i+"]/td[4]")).getText(); 
    	ISSN_OF_UAT_JOURNALS.add(arr2);
    	excelWrite.setValueIntoCell("UATdetails",1,i,arr2);
    	
    	String arr3= CommonUtil.driver.findElement(By.xpath(".//table[@id='myTable']/tbody/tr["+i+"]/td[5]")).getText();
    	UAT_JOURNALS.add(arr3);
    	excelWrite.setValueIntoCell("UATdetails",2,i,arr3);
    	   		
    	String arr4 = CommonUtil.driver.findElement(By.xpath(".//table[@id='myTable']/tbody/tr["+i+"]/td[6]")).getText();
    	STATUSCODE_OF_UAT_JOURNALS.add(arr4);
    	excelWrite.setValueIntoCell("UATdetails",3,i,arr4);
    	
    	String arr5 = CommonUtil.driver.findElement(By.xpath(".//table[@id='myTable']/tbody/tr["+i+"]/td[7]")).getText();
    	CODEGROUP_OF_UAT_JOURNALS.add(arr5); 	
    	excelWrite.setValueIntoCell("UATdetails",4,i,arr5);
    	
    	CommonUtil.sleep(100);
    	System.out.println(i);
    	
    }
    
    msg = "The UAT Details has been captured succesfully";       
  	CommonUtil.report(msg,pass);



	List<String> DIFFERENT_JOURNALS = new ArrayList<String>();
	List<String> UINQUE_WIP_JOURNALS = new ArrayList<String>();
	
	int j=1, d=1, l=1 ,c=0, s=0, a=0;
	for ( String S1: WIP_JOURNALS  )
	{
		
			
		
		if(UAT_JOURNALS.contains(S1))
	
		{
			int k = UAT_JOURNALS.indexOf(S1);
			int m = WIP_JOURNALS.indexOf(S1);
		
		
		    		
			if ((ISSN_OF_UAT_JOURNALS.get(k).equals(ISSN_OF_WIP_JOURNALS.get(m)))  && (ACRONYM_OF_UAT_JOURNALS.get(k).equals(ACRONYM_OF_WIP_JOURNALS.get(m))) && (STATUSCODE_OF_UAT_JOURNALS.get(k).equals(STATUSCODE_OF_WIP_JOURNALS.get(m))) && (CODEGROUP_OF_UAT_JOURNALS.get(k).equals(CODEGROUP_OF_WIP_JOURNALS.get(m))) )
		
			{   
							
				excelWrite.setValueIntoCell("CompareSame",0,j,ACRONYM_OF_UAT_JOURNALS.get(k));
				excelWrite.setValueIntoCell("CompareSame",1,j,ISSN_OF_UAT_JOURNALS.get(k));
				excelWrite.setValueIntoCell("CompareSame",2,j,UAT_JOURNALS.get(k));
				excelWrite.setValueIntoCell("CompareSame",3,j,STATUSCODE_OF_UAT_JOURNALS.get(k));
				excelWrite.setValueIntoCell("CompareSame",4,j,CODEGROUP_OF_UAT_JOURNALS.get(k));
				
				
				
				UAT_JOURNALS.remove(S1); 
				ISSN_OF_UAT_JOURNALS.remove(ISSN_OF_UAT_JOURNALS.get(k));
				ACRONYM_OF_UAT_JOURNALS.remove(ACRONYM_OF_UAT_JOURNALS.get(k));
				STATUSCODE_OF_UAT_JOURNALS.remove(STATUSCODE_OF_UAT_JOURNALS.get(k));
				CODEGROUP_OF_UAT_JOURNALS.remove(CODEGROUP_OF_UAT_JOURNALS.get(k));
				
				j++;
					
			}
			else if((ISSN_OF_UAT_JOURNALS.get(k).equals(ISSN_OF_WIP_JOURNALS.get(m+1)))  && (ACRONYM_OF_UAT_JOURNALS.get(k).equals(ACRONYM_OF_WIP_JOURNALS.get(m+1))) && (STATUSCODE_OF_UAT_JOURNALS.get(k).equals(STATUSCODE_OF_WIP_JOURNALS.get(m+1))) && (CODEGROUP_OF_UAT_JOURNALS.get(k).equals(CODEGROUP_OF_WIP_JOURNALS.get(m+1))) ){
				excelWrite.setValueIntoCell("CompareSame",0,j,ACRONYM_OF_UAT_JOURNALS.get(k));
				excelWrite.setValueIntoCell("CompareSame",1,j,ISSN_OF_UAT_JOURNALS.get(k));
				excelWrite.setValueIntoCell("CompareSame",2,j,UAT_JOURNALS.get(k));
				excelWrite.setValueIntoCell("CompareSame",3,j,STATUSCODE_OF_UAT_JOURNALS.get(k));
				excelWrite.setValueIntoCell("CompareSame",4,j,CODEGROUP_OF_UAT_JOURNALS.get(k));
				
				
				
				UAT_JOURNALS.remove(S1); 
				ISSN_OF_UAT_JOURNALS.remove(ISSN_OF_UAT_JOURNALS.get(k));
				ACRONYM_OF_UAT_JOURNALS.remove(ACRONYM_OF_UAT_JOURNALS.get(k));
				STATUSCODE_OF_UAT_JOURNALS.remove(STATUSCODE_OF_UAT_JOURNALS.get(k));
				CODEGROUP_OF_UAT_JOURNALS.remove(CODEGROUP_OF_UAT_JOURNALS.get(k));
				
				j++;
			}
			
			else
			{	
				if (!(CODEGROUP_OF_UAT_JOURNALS.get(k).equals(CODEGROUP_OF_WIP_JOURNALS.get(m))) ){
					excelWrite.setValueIntoCell("CompareDifferent",0,d,ACRONYM_OF_WIP_JOURNALS.get(m));
					excelWrite.setValueIntoCell("CompareDifferent",1,d,ISSN_OF_WIP_JOURNALS.get(m));
					excelWrite.setValueIntoCell("CompareDifferent",2,d,WIP_JOURNALS.get(m));
					excelWrite.setValueIntoCell("CompareDifferent",3,d,STATUSCODE_OF_WIP_JOURNALS.get(m));
					excelWrite.setValueIntoCellCol("CompareDifferent",4,d,CODEGROUP_OF_WIP_JOURNALS.get(m));
					excelWrite.setValueIntoCell("CompareDifferent",6,d,ACRONYM_OF_UAT_JOURNALS.get(k));
					excelWrite.setValueIntoCell("CompareDifferent",7,d,ISSN_OF_UAT_JOURNALS.get(k));
					excelWrite.setValueIntoCell("CompareDifferent",8,d,UAT_JOURNALS.get(k));
					excelWrite.setValueIntoCell("CompareDifferent",9,d,STATUSCODE_OF_UAT_JOURNALS.get(k));
					excelWrite.setValueIntoCellCol("CompareDifferent",10,d,CODEGROUP_OF_UAT_JOURNALS.get(k));
					c=1;
				}				
				
				if(!(STATUSCODE_OF_UAT_JOURNALS.get(k).equals(STATUSCODE_OF_WIP_JOURNALS.get(m)))){
					if(c==1){
						excelWrite.setValueIntoCell("CompareDifferent",0,d,ACRONYM_OF_WIP_JOURNALS.get(m));
						excelWrite.setValueIntoCell("CompareDifferent",1,d,ISSN_OF_WIP_JOURNALS.get(m));
						excelWrite.setValueIntoCell("CompareDifferent",2,d,WIP_JOURNALS.get(m));
						excelWrite.setValueIntoCellCol("CompareDifferent",3,d,STATUSCODE_OF_WIP_JOURNALS.get(m));
						//excelWrite.setValueIntoCell("CompareDifferent",4,d,CODEGROUP_OF_WIP_JOURNALS.get(m));
						excelWrite.setValueIntoCell("CompareDifferent",6,d,ACRONYM_OF_UAT_JOURNALS.get(k));
						excelWrite.setValueIntoCell("CompareDifferent",7,d,ISSN_OF_UAT_JOURNALS.get(k));
						excelWrite.setValueIntoCell("CompareDifferent",8,d,UAT_JOURNALS.get(k));
						excelWrite.setValueIntoCellCol("CompareDifferent",9,d,STATUSCODE_OF_UAT_JOURNALS.get(k));
						//excelWrite.setValueIntoCell("CompareDifferent",10,d,CODEGROUP_OF_UAT_JOURNALS.get(k));
						
					}
					else{
						excelWrite.setValueIntoCell("CompareDifferent",0,d,ACRONYM_OF_WIP_JOURNALS.get(m));
						excelWrite.setValueIntoCell("CompareDifferent",1,d,ISSN_OF_WIP_JOURNALS.get(m));
						excelWrite.setValueIntoCell("CompareDifferent",2,d,WIP_JOURNALS.get(m));
						excelWrite.setValueIntoCellCol("CompareDifferent",3,d,STATUSCODE_OF_WIP_JOURNALS.get(m));
						excelWrite.setValueIntoCell("CompareDifferent",4,d,CODEGROUP_OF_WIP_JOURNALS.get(m));
						excelWrite.setValueIntoCell("CompareDifferent",6,d,ACRONYM_OF_UAT_JOURNALS.get(k));
						excelWrite.setValueIntoCell("CompareDifferent",7,d,ISSN_OF_UAT_JOURNALS.get(k));
						excelWrite.setValueIntoCell("CompareDifferent",8,d,UAT_JOURNALS.get(k));
						excelWrite.setValueIntoCellCol("CompareDifferent",9,d,STATUSCODE_OF_UAT_JOURNALS.get(k));
						excelWrite.setValueIntoCell("CompareDifferent",10,d,CODEGROUP_OF_UAT_JOURNALS.get(k));
					}
					s=1;
				}
				
				if (!(ACRONYM_OF_UAT_JOURNALS.get(k).equals(ACRONYM_OF_WIP_JOURNALS.get(m)))){
					excelWrite.setValueIntoCellCol("CompareDifferent",0,d,ACRONYM_OF_WIP_JOURNALS.get(m));
					excelWrite.setValueIntoCell("CompareDifferent",1,d,ISSN_OF_WIP_JOURNALS.get(m));
					excelWrite.setValueIntoCell("CompareDifferent",2,d,WIP_JOURNALS.get(m));
					excelWrite.setValueIntoCell("CompareDifferent",3,d,STATUSCODE_OF_WIP_JOURNALS.get(m));
					excelWrite.setValueIntoCell("CompareDifferent",4,d,CODEGROUP_OF_WIP_JOURNALS.get(m));
					excelWrite.setValueIntoCellCol("CompareDifferent",6,d,ACRONYM_OF_UAT_JOURNALS.get(k));
					excelWrite.setValueIntoCell("CompareDifferent",7,d,ISSN_OF_UAT_JOURNALS.get(k));
					excelWrite.setValueIntoCell("CompareDifferent",8,d,UAT_JOURNALS.get(k));
					excelWrite.setValueIntoCell("CompareDifferent",9,d,STATUSCODE_OF_UAT_JOURNALS.get(k));
					excelWrite.setValueIntoCell("CompareDifferent",10,d,CODEGROUP_OF_UAT_JOURNALS.get(k));
				}
				
				if (!(ISSN_OF_UAT_JOURNALS.get(k).equals(ISSN_OF_WIP_JOURNALS.get(m)))){
					excelWrite.setValueIntoCell("CompareDifferent",0,d,ACRONYM_OF_WIP_JOURNALS.get(m));
					excelWrite.setValueIntoCellCol("CompareDifferent",1,d,ISSN_OF_WIP_JOURNALS.get(m));
					excelWrite.setValueIntoCell("CompareDifferent",2,d,WIP_JOURNALS.get(m));
					excelWrite.setValueIntoCell("CompareDifferent",3,d,STATUSCODE_OF_WIP_JOURNALS.get(m));
					excelWrite.setValueIntoCell("CompareDifferent",4,d,CODEGROUP_OF_WIP_JOURNALS.get(m));
					excelWrite.setValueIntoCell("CompareDifferent",6,d,ACRONYM_OF_UAT_JOURNALS.get(k));
					excelWrite.setValueIntoCellCol("CompareDifferent",7,d,ISSN_OF_UAT_JOURNALS.get(k));
					excelWrite.setValueIntoCell("CompareDifferent",8,d,UAT_JOURNALS.get(k));
					excelWrite.setValueIntoCell("CompareDifferent",9,d,STATUSCODE_OF_UAT_JOURNALS.get(k));
					excelWrite.setValueIntoCell("CompareDifferent",10,d,CODEGROUP_OF_UAT_JOURNALS.get(k));
				}
				
				c=0;
				
				DIFFERENT_JOURNALS.add(UAT_JOURNALS.get(k));
				
				UAT_JOURNALS.remove(S1); 
				ISSN_OF_UAT_JOURNALS.remove(ISSN_OF_UAT_JOURNALS.get(k));
				ACRONYM_OF_UAT_JOURNALS.remove(ACRONYM_OF_UAT_JOURNALS.get(k));
				STATUSCODE_OF_UAT_JOURNALS.remove(STATUSCODE_OF_UAT_JOURNALS.get(k));
				CODEGROUP_OF_UAT_JOURNALS.remove(CODEGROUP_OF_UAT_JOURNALS.get(k));
				
				d++;
			}
			
			
			
				
				
			
		}
		else{
			int w= WIP_JOURNALS.indexOf(S1);
			
			excelWrite.setValueIntoCell("UniqueInWIP",0,l,ACRONYM_OF_WIP_JOURNALS.get(w));
			excelWrite.setValueIntoCell("UniqueInWIP",1,l,ISSN_OF_WIP_JOURNALS.get(w));
			excelWrite.setValueIntoCell("UniqueInWIP",2,l,WIP_JOURNALS.get(w));
			excelWrite.setValueIntoCell("UniqueInWIP",3,l,STATUSCODE_OF_WIP_JOURNALS.get(w));
			excelWrite.setValueIntoCell("UniqueInWIP",4,l,CODEGROUP_OF_WIP_JOURNALS.get(w));
			
			UINQUE_WIP_JOURNALS.add(WIP_JOURNALS.get(w));
			l++;
		}


	}
	
	
	/*for ( String S2: WIP_JOURNALS  )
	{
		int w= WIP_JOURNALS.indexOf(S2);
		
		excelWrite.setValueIntoCell("UniqueInWIP",0,j,ACRONYM_OF_UAT_JOURNALS.get(w));
		excelWrite.setValueIntoCell("UniqueInWIP",0,j,ISSN_OF_UAT_JOURNALS.get(w));
		excelWrite.setValueIntoCell("UniqueInWIP",0,j,UAT_JOURNALS.get(w));
		excelWrite.setValueIntoCell("UniqueInWIP",0,j,STATUSCODE_OF_UAT_JOURNALS.get(w));
		excelWrite.setValueIntoCell("UniqueInWIP",0,j,CODEGROUP_OF_UAT_JOURNALS.get(w));
		
		
	}*/
	
	int WIP_JOURNAL_UNIQUE_SIZE=UINQUE_WIP_JOURNALS.size();
	
	j=1;
	for ( String S3: UAT_JOURNALS  )
	{
		int u= UAT_JOURNALS.indexOf(S3);
		
		excelWrite.setValueIntoCell("NotPresentinWIP",0,j,ACRONYM_OF_UAT_JOURNALS.get(u));
		excelWrite.setValueIntoCell("NotPresentinWIP",1,j,ISSN_OF_UAT_JOURNALS.get(u));
		excelWrite.setValueIntoCell("NotPresentinWIP",2,j,UAT_JOURNALS.get(u));
		excelWrite.setValueIntoCell("NotPresentinWIP",3,j,STATUSCODE_OF_UAT_JOURNALS.get(u));
		excelWrite.setValueIntoCell("NotPresentinWIP",4,j,CODEGROUP_OF_UAT_JOURNALS.get(u));
		
		j++;
	}
	
	ds.closeFile();
	
	CommonUtil.sleep(5000);
	int UAT_JOURNAL_UNIQUE_SIZE=UAT_JOURNALS.size();
	
	if(WIP_JOURNAL_UNIQUE_SIZE==0 && UAT_JOURNAL_UNIQUE_SIZE==0 && DIFFERENT_JOURNALS.size()==0 )
	{
		msg = "All the Journal details are same in UAT & WIP";       
        CommonUtil.reportexcel(msg,pass);
        return true;
		
	}
	
	msg = "The journal details are different";       
    CommonUtil.reportexcel(msg,fail);
	return false;

}

public static boolean pricingToolCheck(String username, String password, int volumne, int loop) throws Exception {
	// TODO Auto-generated method stub
	JavascriptExecutor js = (JavascriptExecutor) CommonUtil.driver;
	
	//String "PricingCompare"=VariableController.getTestCaseName()+"Output";
	CommonUtil.clicksync(clickOnSelection);
	//CommonUtil.clicksync(clickOnEntries);
	

    
	CommonUtil.driver.findElement(By.id("dropdownMenu1")).click();
	CommonUtil.driver.findElement(By.xpath(".//*[@id='years']/li[10]/a")).click();
	
	CommonUtil.sleep(5000);
	
	Select number = new Select(CommonUtil.driver.findElement(By.xpath(".//*[@id='myTable_length']/label/select")));
    number.selectByVisibleText("All");
    
    CommonUtil.clicksync(clickOnSearch);
    
    String Value=CommonUtil.driver.findElement(By.xpath(".//*[@id='myTable']/tbody/tr["+volumne+"]/td[1]/a")).getAttribute("href");  
	CommonUtil.refresh(Value);
	CommonUtil.sleep(1000);
	
	
	
	String splitValue[]=Value.split("main.aspx?");
	String URLdetails=EnvUtil.getProperty("UAT_URL")+"main.aspx"+splitValue[1];
	
	
	
	
	//Select numberitem = new Select(CommonUtil.driver.findElement(By.id("ultblcurrentPrices")));
//    number.selectByVisibleText("All");
	
	String environment = CommonUtil.getText(environMentDetail);
	String environmentDetails[] = environment.split("Renew Pages - ");
	String environmentModify[] = environmentDetails[1].split("_");
	String environmentFinal1 = environmentModify[0];
	environmentFinal1=environmentFinal1+volumne;
	
	//CommonUtil.scrolldown(sapIssn);
	//CommonUtil.capturePartScreenshot(tablePricingDetail);
	
	 List<String> WIP_JOURNAL_NAME = new ArrayList<String>();
	 List<String> WIP_JOURNAL_NAME_ISSN = new ArrayList<String>();
	 List<String> WIP_JOURNAL_TYPE = new ArrayList<String>();
	 List<String> WIP_DETAILS = new ArrayList<String>();

	 
	 List<String> UAT_JOURNAL_NAME = new ArrayList<String>();
	 List<String> UAT_JOURNAL_NAME_ISSN = new ArrayList<String>();
	 List<String> UAT_JOURNAL_TYPE = new ArrayList<String>();
	 List<String> UAT_DETAILS = new ArrayList<String>();
	 List<String> SAME_DETAILS= new ArrayList<String>();

	 int u=0, g=1, r=2;	 
	for(int i=0; i<=2; i++){
		excelWrite.setValueIntoCell("PricingCompare",u,0,"WIPDETAILS");
		excelWrite.setValueIntoCell("PricingCompare",g,0,"UATDETAILS");
		excelWrite.setValueIntoCell("PricingCompare",r,0,"RESULT");
		u=u+3; g=g+3; r=r+3;
	}
	for(int i=0;i<=55;i++){
		excelWrite.setValueIntoCell("PricingCompare",u,0,"Data");
		excelWrite.setValueIntoCell("PricingCompare",g,0,"ReasonforFailure");
		u=u+2;g=g+2;
	}
	 
	 
	 
	
	    String journalName = CommonUtil.getText(journalTitle);
	    WIP_JOURNAL_NAME.add(journalName); 
	    
	    
	    
	    
	    boolean testflag=ReadExcelDataProvider.getMatchJournal(VariableController.baseSheet,VariableController.CompareSame,journalName);
	    
	    if(!testflag){
	    	msg = "The journal captured is not present in UAT";  
	 		CommonUtil.report(msg, fail,journalName);
	 		CommonUtil.refresh(EnvUtil.getProperty("WIP_URL"));
			CommonUtil.sleep(1000);
	 		return false;
	    }
	    excelWrite.setValueIntoCell("PricingCompare",0,loop,journalName);
	    
	    msg="Partial Screenshot is captured for "+environmentFinal1;
	    CommonUtil.reportPartScreenshot(msg,pass,journalName,tablePricingDetail,environmentFinal1);
	    
	    String journalNameIssn = CommonUtil.getText(journalIssn);
	    WIP_JOURNAL_NAME_ISSN.add(journalNameIssn); 
	    excelWrite.setValueIntoCell("PricingCompare",3,loop,journalNameIssn);
	    			    
	    String journalTypePricingtool = CommonUtil.getText(journalType);
	    WIP_JOURNAL_TYPE.add(journalTypePricingtool); 
	    excelWrite.setValueIntoCell("PricingCompare",6,loop,journalTypePricingtool);
	    
	    List<WebElement> tablerow = CommonUtil.driver.findElements(By.xpath(".//table[@id='tblcurrentPrices']/tbody/tr"));
	    System.out.println(tablerow.size());
	    
	    int xlvalue=6, flag=0, flag1=0, flag2=0;
	    String value, zalue, zvalu1[];
	    zalue=CommonUtil.driver.findElement(By.xpath(".//*[@id='chkActivetblcurrentPrices']/span/img")).getAttribute("src");
	    //xlvalue=xlvalue+3;
	    zvalu1=zalue.split("/icons/");
	 	WIP_DETAILS.add(zvalu1[1]);
	  
/*	 	CommonUtil.driver.findElement(By.id("dropdownMenutblcurrentPrices")).click();
		WebElement insertdropdown=CommonUtil.driver.findElement(By.id("ultblcurrentPrices"));
		WebElement elment=CommonUtil.driver.findElement(By.xpath("//div[@id='ddmenuDivtblcurrentPrices']/span/span"));
		List<WebElement> countriesList=insertdropdown.findElements(By.tagName("li"));
		int q=1;
		String KK;
		for (WebElement li : countriesList) {
			//li.click();
			KK=CommonUtil.driver.findElement(By.xpath("(//*[@id='text'])["+q+"]")).getText();
			WIP_DETAILS.add(KK);
			q++;
			//CommonUtil.driver.findElement(By.id("dropdownMenutblcurrentPrices")).click();
		}
		CommonUtil.driver.findElement(By.id("dropdownMenutblcurrentPrices")).click();
	    */
	    for(int k=2; k<=tablerow.size();k++){
	    	

	    	 List<WebElement> tablecol = CommonUtil.driver.findElements(By.xpath(".//table[@id='tblcurrentPrices']/tbody/tr["+k+"]/td"));
	    	
	    	
	    	 
	    	 js.executeScript("window.scrollBy(0,40)");
	    	 CommonUtil.click(By.xpath(".//*[@id='tblcurrentPrices']/tbody/tr["+k+"]/td[1]/input"));
		    
	    
	    	 
	    	 
	    	 if(!(tablecol.size()==1)){
	    	 if(k>2 && tablecol.size()>2)
	    	 {		
	    		 
	    		
	    		 	value= CommonUtil.getText(sapIssn);
	    		 	xlvalue=xlvalue+3;
	    		 	WIP_DETAILS.add(value); 
	    		 	value= CommonUtil.getText(RelationshipID);
	    		 	xlvalue=xlvalue+3;
	    		 	WIP_DETAILS.add(value); 
	    		 	
	    	 }
	    	if(tablecol.size()>2){
	    		for(int z=2;z<=tablecol.size();z++){
	    			value=CommonUtil.getText(By.xpath(".//*[@id='tblcurrentPrices']/tbody/tr["+k+"]/td["+z+"]"));
	    			xlvalue=xlvalue+3;
	    			WIP_DETAILS.add(value);
	    			//excelWrite.setValueIntoCell("PricingCompare",xlvalue,loop,value);
	    			
	    		}
	    	}else{
	    		
	    		
	    		
	    		 value=CommonUtil.getText(By.xpath(".//*[@id='tblcurrentPrices']/tbody/tr["+k+"]/td[2]"));
	    		 if(!value.equals("")){
	    				xlvalue=xlvalue+3;
		    			WIP_DETAILS.add(value);
		    			//excelWrite.setValueIntoCell("PricingCompare",xlvalue,loop,value);
	    			}
	    		
	    	}
	    	
	    }
	  
	  
	    }
	    msg = "The WIP Details has been captured successfully";       
	  	CommonUtil.reportSpecific(msg,pass,journalName,environmentFinal1);

	     
	  CommonUtil.sleep(1000);
	  
		CommonUtil.refresh(EnvUtil.getProperty("UAT_URL"));
		CommonUtil.sleep(1000);
		
		LoginPage.LoginUAT(username,password);
		
		CommonUtil.sleep(1000);
		
		CommonUtil.refresh(URLdetails);
		
		CommonUtil.sleep(1000);
		

		environment = CommonUtil.getText(environMentDetail);
		String environmentDetails1[] = environment.split("Renew Pages - ");
		String environmentModify1[] = environmentDetails1[1].split("_");
		String environmentFinal2 = environmentModify1[0];
		environmentFinal2=environmentFinal2+volumne;

		
		
		journalName = CommonUtil.getText(journalTitle);
	    UAT_JOURNAL_NAME.add(journalName); 
	    excelWrite.setValueIntoCell("PricingCompare",1,loop,journalName);
	   
	    msg="Partial Screenshot is captured for "+environmentFinal2;
	    CommonUtil.reportPartScreenshot(msg,pass,journalName,tablePricingDetail,environmentFinal2);

	    journalNameIssn = CommonUtil.getText(journalIssn);
	    UAT_JOURNAL_NAME_ISSN.add(journalNameIssn); 
	    excelWrite.setValueIntoCell("PricingCompare",4,loop,journalNameIssn);
	    			    
	    journalTypePricingtool = CommonUtil.getText(journalType);
	    UAT_JOURNAL_TYPE.add(journalTypePricingtool); 
	    excelWrite.setValueIntoCell("PricingCompare",7,loop,journalTypePricingtool);
	    
	    List<WebElement> tablerow1 = CommonUtil.driver.findElements(By.xpath(".//table[@id='tblcurrentPrices']/tbody/tr"));
	    System.out.println(tablerow1.size());
	    
	    xlvalue=7; flag=0; flag1=0; flag2=0;
	    zalue=CommonUtil.driver.findElement(By.xpath(".//*[@id='chkActivetblcurrentPrices']/span/img")).getAttribute("src");
	    zvalu1=zalue.split("/icons/");
	 	UAT_DETAILS.add(zvalu1[1]);
	/*	CommonUtil.driver.findElement(By.id("dropdownMenutblcurrentPrices")).click();
		WebElement insertdropdown1=CommonUtil.driver.findElement(By.id("ultblcurrentPrices"));
		
		List<WebElement> countriesList1=insertdropdown1.findElements(By.tagName("li"));
		q=1;
		for (WebElement li : countriesList1) {
			//li.click();
			KK=CommonUtil.driver.findElement(By.xpath("(//*[@id='text'])["+q+"]")).getText();
			UAT_DETAILS.add(KK);
			q++;
			
		}
		CommonUtil.driver.findElement(By.id("dropdownMenutblcurrentPrices")).click();*/
	 	
	    
	    for(int k=2; k<=tablerow1.size();k++){
	    	
	    	 List<WebElement> tablecol = CommonUtil.driver.findElements(By.xpath(".//table[@id='tblcurrentPrices']/tbody/tr["+k+"]/td"));
	    	 js.executeScript("window.scrollBy(0,40)");
		    		 CommonUtil.click(By.xpath(".//*[@id='tblcurrentPrices']/tbody/tr["+k+"]/td[1]/input"));
		    
	    	 if(!(tablecol.size()==1)){
	    	 if(k>2 && tablecol.size()>2)
	    	 {
	    	
	    		
	    		 	value= CommonUtil.getText(sapIssn);
	    		 	xlvalue=xlvalue+3;
	    		 	UAT_DETAILS.add(value); 
	    		 	value= CommonUtil.getText(RelationshipID);
	    		 	xlvalue=xlvalue+3;
	    		 	UAT_DETAILS.add(value); 
	    		 //   excelWrite.setValueIntoCell("PricingCompare",xlvalue,loop,value);
	    	 }
	    	if(tablecol.size()>2){
	    		for(int z=2;z<=tablecol.size();z++){
	    			value=CommonUtil.getText(By.xpath(".//*[@id='tblcurrentPrices']/tbody/tr["+k+"]/td["+z+"]"));
	    			
	    				xlvalue=xlvalue+3;
		    			UAT_DETAILS.add(value);
		    		//	excelWrite.setValueIntoCell("PricingCompare",xlvalue,loop,value);
	    			
	    		}
	    	}else{
	    		
	    		 value=CommonUtil.getText(By.xpath(".//*[@id='tblcurrentPrices']/tbody/tr["+k+"]/td[2]"));
	    		 if(!value.equals("")){
	    				xlvalue=xlvalue+3;
		    			UAT_DETAILS.add(value);
		    		//	excelWrite.setValueIntoCell("PricingCompare",xlvalue,loop,value);
	    			}
	    	}
	    	
	    }
	  
	    } 
	    
	    msg = "The UAT Details has been captured succesfully";       
	    CommonUtil.reportSpecific(msg,pass,journalName,environmentFinal2);

	    
	    int NotMatchedCount=0,w=0,m=0;
		
	    for ( String S1: WIP_JOURNAL_NAME  )
	        
	    	
		{
			if(UAT_JOURNAL_NAME.contains(S1)) 
		
			{
				w = WIP_JOURNAL_NAME.indexOf(S1);
				m = UAT_JOURNAL_NAME.indexOf(S1);
				
	
				if (WIP_JOURNAL_NAME_ISSN.get(w).equals(UAT_JOURNAL_NAME_ISSN.get(m)))  
					excelWrite.setValueIntoCell("PricingCompare",5,loop,"Matched");
				else{
					excelWrite.setValueIntoCellCol("PricingCompare",5,loop,"NotMatched");
					
					NotMatchedCount++;
				}
				
				if (WIP_JOURNAL_TYPE.get(w).equals(UAT_JOURNAL_TYPE.get(m)))  
					excelWrite.setValueIntoCell("PricingCompare",8,loop,"Matched");
				else{
					excelWrite.setValueIntoCellCol("PricingCompare",8,loop,"NotMatched");
					NotMatchedCount++;
				}
			}
		}
	    int xlwrite=9;
	    int ud = 0;
	    int checkflag=0;
	    
	    for ( String S1: WIP_DETAILS) 	
		{	
	    	
			if(UAT_DETAILS.contains(S1)) 
				 
		
			{
				
				UAT_DETAILS.remove(S1);
				SAME_DETAILS.add(S1);
			}
			else{
				
				//SAME_DETAILS.add(S1);
				excelWrite.setValueIntoCellCol("PricingCompare",xlwrite,loop,S1);
				xlwrite=xlwrite+3;
				
				NotMatchedCount++;
				
			}
		}
	    xlwrite=10;
	   
	    
	    
	   
 
    for ( String S2: UAT_DETAILS)
	        
	    	
	    {
				
				excelWrite.setValueIntoCellCol("PricingCompare",xlwrite,loop,S2);
				xlwrite++;
				excelWrite.setValueIntoCellCol("PricingCompare",xlwrite,loop,"Not Matched");
				xlwrite=xlwrite+2;
				NotMatchedCount++;
				
			}
	
	  
	    String WIPPath=System.getProperty("user.dir")+"\\output\\"+VariableController.getTestCaseName()+"\\screenshots\\"+environmentFinal1+".png";
	    String UATPath=System.getProperty("user.dir")+"\\output\\"+VariableController.getTestCaseName()+"\\screenshots\\"+environmentFinal2+".png";
	    String environmentOutput="Output"+volumne;
	    String OuTPath=System.getProperty("user.dir")+"\\output\\"+VariableController.getTestCaseName()+"\\screenshots\\"+environmentOutput+".png";
	    
	   CompareTwoImages cti = new CompareTwoImages(WIPPath, UATPath);
		cti.setParameters(30, 30);
		boolean flagcomp=cti.compare();
		CompareTwoImages.saveJPG(cti.getImageResult(), OuTPath);
	    
		
	    
	 if(NotMatchedCount==0){
		 
		 		msg = "All the Pricing details are same in UAT & WIP";  
		 		CommonUtil.report(msg, pass,WIP_JOURNAL_NAME.get(w));	
		 		excelWrite.setValueIntoCell("PricingCompare",2,loop,"Matched");
		 		if(!flagcomp){
		 			msg = "All the Pricing details are same in UAT & WIP, but screen compare not possible due to pixel difference in screenshot";      
			        CommonUtil.reportCmpare(msg,pass,WIP_JOURNAL_NAME.get(w),environmentOutput);
		 		}
		 		else{
		 			msg = "All the Pricing details are same in UAT & WIP, please check the compare screenshot result";      
			        CommonUtil.reportCmpare(msg,pass,WIP_JOURNAL_NAME.get(w),environmentOutput);
		 		}
		        CommonUtil.refresh(EnvUtil.getProperty("WIP_URL"));
				CommonUtil.sleep(1000);
		        return true;
				
	 }
	 else{
		 	msg = "The Pricing details are different in UAT & WIP";
		 	CommonUtil.report(msg, fail,WIP_JOURNAL_NAME.get(w));
		 	excelWrite.setValueIntoCellCol("PricingCompare",2,loop,"NotMatched");
			if(!flagcomp){
	 			msg = "The Pricing details are different in UAT & WIP, but screen compare not possible due to pixel difference in screenshot";      
		        CommonUtil.reportCmpare(msg,fail,WIP_JOURNAL_NAME.get(w),environmentOutput);
	 		}
	 		else{
	 			msg = "The Pricing details are different in UAT & WIP, please check the compare screenshot result";      
		        CommonUtil.reportCmpare(msg,fail,WIP_JOURNAL_NAME.get(w),environmentOutput);
	 		}
	        CommonUtil.refresh(EnvUtil.getProperty("WIP_URL"));
			CommonUtil.sleep(1000);
	        return false;
	 }
	
	
}

public static  void highLighterMethod(WebDriver driver, WebElement element){
	 JavascriptExecutor js = (JavascriptExecutor) driver;
	 js.executeScript("arguments[0].setAttribute('style', 'background: yellow; border: 2px solid red;');", element);
	 }


public static void unhighlightLast(WebDriver driver,WebElement element) { 
	  JavascriptExecutor js=(JavascriptExecutor) driver;
	  js.executeScript("arguments[0].setAttribute('style', 'background: white; ');", element);
	 }
public static boolean searchISSN(String PrintISSN, String OnlineISSN) throws Exception
{
	JavascriptExecutor js = (JavascriptExecutor) CommonUtil.driver;
	
	CommonUtil.clicksync(clickOnSelection);
	CommonUtil.sleep(2000);
	CommonUtil.sendKeys(By.xpath(".//*[@id='myTable_filter']/label/input"), PrintISSN);
	CommonUtil.sleep(2000);
	CommonUtil.clicksync(viewXpath);
	CommonUtil.sleep(2000);
	for(String  winHandle: CommonUtil.driver.getWindowHandles()){
		CommonUtil.driver.switchTo().window(winHandle);
		
	}
		CommonUtil.click(By.id("tab4"));
		CommonUtil.sleep(5000);
		
		
		
		//WebElement elementLocator = CommonUtil.driver.findElement(By.xpath("//input[@placeholder='Print ISSN']"));
		String getprintissn=CommonUtil.driver.findElement(By.xpath("//input[@placeholder='Print ISSN']")).getAttribute("value");
		//highLighterMethod(CommonUtil.driver,CommonUtil.driver.findElement(By.xpath("//input[@placeholder='Print ISSN']")));
		System.out.println("The Print ISSN is " +getprintissn);
		
		String onlineISSN=CommonUtil.driver.findElement(By.xpath("//input[@placeholder='Online ISSN']")).getAttribute("value");
		//highLighterMethod(CommonUtil.driver,CommonUtil.driver.findElement(By.xpath("//input[@placeholder='Online ISSN']")));
		System.out.println("The Online ISSN is " +onlineISSN);
		
		String Acronym=CommonUtil.driver.findElement(By.xpath("//input[@placeholder='Acronym']")).getAttribute("value");
		System.out.println("The Acronym is " +Acronym);
		
		String JournalDOI=CommonUtil.driver.findElement(By.xpath("//input[@placeholder='Journal DOI']")).getAttribute("value");
		System.out.println("The JournalDOI is " +JournalDOI);
		
		String JournalTitle=CommonUtil.driver.findElement(By.xpath("//input[@placeholder='Journal Title']")).getAttribute("value");
		System.out.println("The Journal Title  is---> " +JournalTitle);
		
		String JournalSubTitle=CommonUtil.driver.findElement(By.xpath("//input[@placeholder='Journal Sub Title']")).getAttribute("value");
		System.out.println("The Journal Sub Title is ----->" +JournalSubTitle);
		
		String Societyname=CommonUtil.driver.findElement(By.xpath("//input[@placeholder='Society Name']")).getAttribute("value");
		System.out.println("The Journal Sub Title is --->" +Societyname);
		
		String SocietyURL=CommonUtil.driver.findElement(By.xpath("//input[@placeholder='Society URL']")).getAttribute("value");
		System.out.println("The Journal Sub Title is ---->" +SocietyURL);
		
		String CoverImagePath=CommonUtil.driver.findElement(By.xpath("//input[@placeholder='Cover Image Path']")).getAttribute("value");
		System.out.println("The Journal Sub Title is --->" +CoverImagePath);
		
		String ElectronicEditorialURL=CommonUtil.driver.findElement(By.xpath("//input[@placeholder='Electronic Editorial URL']")).getAttribute("value");
		System.out.println("The Journal Sub Title is --->" +ElectronicEditorialURL);
		
		Select selectItem = new Select(CommonUtil.driver.findElement(By.id("inputSubscriptionType")));
		WebElement option = selectItem.getFirstSelectedOption();
		String content = option.getText();
		System.out.println("Subscription Type --->" + content);
		
		
		Select selectItem1 = new Select(CommonUtil.driver.findElement(By.id("inputFrequency")));
		WebElement optio1n = selectItem1.getFirstSelectedOption();
		String content1 = optio1n.getText();
		System.out.println("Frequency Description is ---> " + content1);
		
		if(PrintISSN.contains(getprintissn))
		{
			msg="PrintISSN is succesfully matched  ";
			highLighterMethod(CommonUtil.driver,CommonUtil.driver.findElement(By.xpath("//input[@placeholder='Print ISSN']")));
			
			CommonUtil.report(msg,pass);
			CommonUtil.sleep(2000);
			unhighlightLast(CommonUtil.driver,CommonUtil.driver.findElement(By.xpath("//input[@placeholder='Print ISSN']")));
			//return true;
		}
		else
		{
		msg = "PrintISSN is succesfully not matched  ";	
		CommonUtil.report(msg,fail);
	
	}
		 if(OnlineISSN.contains(onlineISSN))
		{
			 msg="Online ISSN  is succesfully matched  ";
			 highLighterMethod(CommonUtil.driver,CommonUtil.driver.findElement(By.xpath("//input[@placeholder='Online ISSN']")));
				
				CommonUtil.report(msg,pass);
				CommonUtil.sleep(2000);
				unhighlightLast(CommonUtil.driver,CommonUtil.driver.findElement(By.xpath("//input[@placeholder='Online ISSN']")));
				
				//return true;
			
		}
		 else
			{
			msg = "OnlineISSN is succesfully not matched  ";	
			CommonUtil.report(msg,fail);
			
			}
		 
		 return false;
		}



public static boolean pricingToolInsert(String username, String password, int volumne, int loop) throws Exception {
	// TODO Auto-generated method stub
	JavascriptExecutor js = (JavascriptExecutor) CommonUtil.driver;
	
	//String "PricingCompare"=VariableController.getTestCaseName()+"Output";
	CommonUtil.clicksync(clickOnSelection);
	//CommonUtil.clicksync(clickOnEntries);
	

    
	CommonUtil.driver.findElement(By.id("dropdownMenu1")).click();
	CommonUtil.driver.findElement(By.xpath(".//*[@id='years']/li[10]/a")).click();
	
	CommonUtil.sleep(5000);
	
	Select number = new Select(CommonUtil.driver.findElement(By.xpath(".//*[@id='myTable_length']/label/select")));
    number.selectByVisibleText("All");
    
    CommonUtil.clicksync(clickOnSearch);
    
    String Value=CommonUtil.driver.findElement(By.xpath(".//*[@id='myTable']/tbody/tr["+volumne+"]/td[1]/a")).getAttribute("href");  
	CommonUtil.refresh(Value);
	CommonUtil.sleep(1000);
	
	
	
	String splitValue[]=Value.split("main.aspx?");
	String URLdetails=EnvUtil.getProperty("UAT_URL")+"main.aspx"+splitValue[1];
	
	
	
	
	//Select numberitem = new Select(CommonUtil.driver.findElement(By.id("ultblcurrentPrices")));
//    number.selectByVisibleText("All");
	
	String environment = CommonUtil.getText(environMentDetail);
	String environmentDetails[] = environment.split("Renew Pages - ");
	String environmentModify[] = environmentDetails[1].split("_");
	String environmentFinal1 = environmentModify[0];
	environmentFinal1=environmentFinal1+volumne;
	
	//CommonUtil.scrolldown(sapIssn);
	//CommonUtil.capturePartScreenshot(tablePricingDetail);
	
	 List<String> WIP_JOURNAL_NAME = new ArrayList<String>();
	 List<String> WIP_JOURNAL_NAME_ISSN = new ArrayList<String>();
	 List<String> WIP_JOURNAL_TYPE = new ArrayList<String>();
	 List<String> WIP_DETAILS = new ArrayList<String>();

	 
	 List<String> UAT_JOURNAL_NAME = new ArrayList<String>();
	 List<String> UAT_JOURNAL_NAME_ISSN = new ArrayList<String>();
	 List<String> UAT_JOURNAL_TYPE = new ArrayList<String>();
	 List<String> UAT_DETAILS = new ArrayList<String>();
	 List<String> SAME_DETAILS= new ArrayList<String>();

	 int u=0, g=1, r=2;	 
	for(int i=0; i<=2; i++){
		excelWrite.setValueIntoCell("PricingCompare",u,0,"WIPDETAILS");
		excelWrite.setValueIntoCell("PricingCompare",g,0,"UATDETAILS");
		excelWrite.setValueIntoCell("PricingCompare",r,0,"RESULT");
		u=u+3; g=g+3; r=r+3;
	}
	for(int i=0;i<=55;i++){
		excelWrite.setValueIntoCell("PricingCompare",u,0,"Data");
		excelWrite.setValueIntoCell("PricingCompare",g,0,"ReasonforFailure");
		u=u+2;g=g+2;
	}
	 
	 
	 
	
	    String journalName = CommonUtil.getText(journalTitle);
	    WIP_JOURNAL_NAME.add(journalName); 
	    
	    
	    
	    
	    boolean testflag=ReadExcelDataProvider.getMatchJournal(VariableController.baseSheet,VariableController.CompareSame,journalName);
	    
	    if(!testflag){
	    	msg = "The journal captured is not present in UAT";  
	 		CommonUtil.report(msg, fail,journalName);
	 		CommonUtil.refresh(EnvUtil.getProperty("WIP_URL"));
			CommonUtil.sleep(1000);
	 		return false;
	    }
	    excelWrite.setValueIntoCell("PricingCompare",0,loop,journalName);
	    
	    msg="Partial Screenshot is captured for "+environmentFinal1;
	    CommonUtil.reportPartScreenshot(msg,pass,journalName,tablePricingDetail,environmentFinal1);
	    
	    String journalNameIssn = CommonUtil.getText(journalIssn);
	    WIP_JOURNAL_NAME_ISSN.add(journalNameIssn); 
	    excelWrite.setValueIntoCell("PricingCompare",3,loop,journalNameIssn);
	    			    
	    String journalTypePricingtool = CommonUtil.getText(journalType);
	    WIP_JOURNAL_TYPE.add(journalTypePricingtool); 
	    excelWrite.setValueIntoCell("PricingCompare",6,loop,journalTypePricingtool);
	    
	    List<WebElement> tablerow = CommonUtil.driver.findElements(By.xpath(".//table[@id='tblcurrentPrices']/tbody/tr"));
	    System.out.println(tablerow.size());
	    
	    int xlvalue=6, flag=0, flag1=0, flag2=0;
	    String value, zalue, zvalu1[];
	    zalue=CommonUtil.driver.findElement(By.xpath(".//*[@id='chkActivetblcurrentPrices']/span/img")).getAttribute("src");
	    //xlvalue=xlvalue+3;
	    zvalu1=zalue.split("/icons/");
	 	WIP_DETAILS.add(zvalu1[1]);
	  /*  CommonUtil.click(By.id("makeMoreRoomformenutblcurrentPrices"));
		CommonUtil.sleep(2000);*/
	 	CommonUtil.driver.findElement(By.id("dropdownMenutblcurrentPrices")).click();
		WebElement insertdropdown=CommonUtil.driver.findElement(By.id("ultblcurrentPrices"));
		WebElement elment=CommonUtil.driver.findElement(By.xpath("//div[@id='ddmenuDivtblcurrentPrices']/span/span"));
		List<WebElement> countriesList=insertdropdown.findElements(By.tagName("li"));
		int q=1;
		String KK;
		for (WebElement li : countriesList) {
			//li.click();
			KK=CommonUtil.driver.findElement(By.xpath("(//*[@id='text'])["+q+"]")).getText();
			WIP_DETAILS.add(KK);
			q++;
			//CommonUtil.driver.findElement(By.id("dropdownMenutblcurrentPrices")).click();
		}
		CommonUtil.driver.findElement(By.id("dropdownMenutblcurrentPrices")).click();
	    
	    
	    msg = "The WIP Details has been captured successfully";       
	  	CommonUtil.reportSpecific(msg,pass,journalName,environmentFinal1);

	     
	  CommonUtil.sleep(1000);
	  
		CommonUtil.refresh(EnvUtil.getProperty("UAT_URL"));
		CommonUtil.sleep(1000);
		
		LoginPage.LoginUAT(username,password);
		
		CommonUtil.sleep(1000);
		
		CommonUtil.refresh(URLdetails);
		
		CommonUtil.sleep(1000);
		

		environment = CommonUtil.getText(environMentDetail);
		String environmentDetails1[] = environment.split("Renew Pages - ");
		String environmentModify1[] = environmentDetails1[1].split("_");
		String environmentFinal2 = environmentModify1[0];
		environmentFinal2=environmentFinal2+volumne;
	//	CommonUtil.scrolldown(sapIssn);
		
		
		journalName = CommonUtil.getText(journalTitle);
	    UAT_JOURNAL_NAME.add(journalName); 
	    excelWrite.setValueIntoCell("PricingCompare",1,loop,journalName);
	   
	    msg="Partial Screenshot is captured for "+environmentFinal2;
	    CommonUtil.reportPartScreenshot(msg,pass,journalName,tablePricingDetail,environmentFinal2);
	//	CommonUtil.capturePartScreenshot(tablePricingDetail);

	    journalNameIssn = CommonUtil.getText(journalIssn);
	    UAT_JOURNAL_NAME_ISSN.add(journalNameIssn); 
	    excelWrite.setValueIntoCell("PricingCompare",4,loop,journalNameIssn);
	    			    
	    journalTypePricingtool = CommonUtil.getText(journalType);
	    UAT_JOURNAL_TYPE.add(journalTypePricingtool); 
	    excelWrite.setValueIntoCell("PricingCompare",7,loop,journalTypePricingtool);
	    
	    List<WebElement> tablerow1 = CommonUtil.driver.findElements(By.xpath(".//table[@id='tblcurrentPrices']/tbody/tr"));
	    System.out.println(tablerow1.size());
	    
	    xlvalue=7; flag=0; flag1=0; flag2=0;
	    zalue=CommonUtil.driver.findElement(By.xpath(".//*[@id='chkActivetblcurrentPrices']/span/img")).getAttribute("src");
	    zvalu1=zalue.split("/icons/");
	 	UAT_DETAILS.add(zvalu1[1]);
		CommonUtil.driver.findElement(By.id("dropdownMenutblcurrentPrices")).click();
		WebElement insertdropdown1=CommonUtil.driver.findElement(By.id("ultblcurrentPrices"));
		//WebElement elment1=CommonUtil.driver.findElement(By.xpath("//div[@id='ddmenuDivtblcurrentPrices']/span/span"));
		List<WebElement> countriesList1=insertdropdown1.findElements(By.tagName("li"));
		q=1;
		for (WebElement li : countriesList1) {
			//li.click();
			KK=CommonUtil.driver.findElement(By.xpath("(//*[@id='text'])["+q+"]")).getText();
			UAT_DETAILS.add(KK);
			q++;
			//CommonUtil.driver.findElement(By.id("dropdownMenutblcurrentPrices")).click();
		}
		CommonUtil.driver.findElement(By.id("dropdownMenutblcurrentPrices")).click();

	    
	    msg = "The UAT Details has been captured succesfully";       
	    CommonUtil.reportSpecific(msg,pass,journalName,environmentFinal2);

	    
	    int NotMatchedCount=0,w=0,m=0;
		
	    for ( String S1: WIP_JOURNAL_NAME  )
	        
	    	
		{
			if(UAT_JOURNAL_NAME.contains(S1)) 
		
			{
				w = WIP_JOURNAL_NAME.indexOf(S1);
				m = UAT_JOURNAL_NAME.indexOf(S1);
				
	
				if (WIP_JOURNAL_NAME_ISSN.get(w).equals(UAT_JOURNAL_NAME_ISSN.get(m)))  
					excelWrite.setValueIntoCell("PricingCompare",5,loop,"Matched");
				else{
					excelWrite.setValueIntoCellCol("PricingCompare",5,loop,"NotMatched");
					
					NotMatchedCount++;
				}
				
				if (WIP_JOURNAL_TYPE.get(w).equals(UAT_JOURNAL_TYPE.get(m)))  
					excelWrite.setValueIntoCell("PricingCompare",8,loop,"Matched");
				else{
					excelWrite.setValueIntoCellCol("PricingCompare",8,loop,"NotMatched");
					NotMatchedCount++;
				}
			}
		}
	    int xlwrite=9;
	    int ud = 0;
	    int checkflag=0;
	    
	    for ( String S1: WIP_DETAILS) 	
		{	
	    	
			if(UAT_DETAILS.contains(S1)) 
				 
		
			{
				//xlwrite=xlwrite+3;
				//excelWrite.setValueIntoCell("PricingCompare",xlwrite,loop,"Matched");
				UAT_DETAILS.remove(S1);
				SAME_DETAILS.add(S1);
			}
			else{
				
				//SAME_DETAILS.add(S1);
				excelWrite.setValueIntoCellCol("PricingCompare",xlwrite,loop,S1);
				xlwrite=xlwrite+3;
				//excelWrite.setValueIntoCellCol("PricingCompare",xlwrite,loop,UAT_DETAILS.get(ud));
				//excelWrite.setValueIntoCellCol("PricingCompare",xlwrite,loop,"NotMatched");
				//xlwrite++;
				//UAT_DETAILS.remove(UAT_DETAILS.get(ud));
				NotMatchedCount++;
				
			}
		}
	    xlwrite=10;
	   
	    
	    
	   
 
    for ( String S2: UAT_DETAILS)
	        
	    	
	    {
				
				excelWrite.setValueIntoCellCol("PricingCompare",xlwrite,loop,S2);
				xlwrite++;
				excelWrite.setValueIntoCellCol("PricingCompare",xlwrite,loop,"Not Matched");
				xlwrite=xlwrite+2;
				NotMatchedCount++;
				
			}
	
	  
	    String WIPPath=System.getProperty("user.dir")+"\\output\\"+VariableController.getTestCaseName()+"\\screenshots\\"+environmentFinal1+".png";
	    String UATPath=System.getProperty("user.dir")+"\\output\\"+VariableController.getTestCaseName()+"\\screenshots\\"+environmentFinal2+".png";
	    String environmentOutput="Output"+volumne;
	    String OuTPath=System.getProperty("user.dir")+"\\output\\"+VariableController.getTestCaseName()+"\\screenshots\\"+environmentOutput+".png";
	    
	   CompareTwoImages cti = new CompareTwoImages(WIPPath, UATPath);
		cti.setParameters(30, 30);
		boolean flagcomp=cti.compare();
		CompareTwoImages.saveJPG(cti.getImageResult(), OuTPath);
	    
		
	    
	 if(NotMatchedCount==0){
		 
		 		msg = "All the Pricing details are same in UAT & WIP";  
		 		CommonUtil.report(msg, pass,WIP_JOURNAL_NAME.get(w));	
		 		excelWrite.setValueIntoCell("PricingCompare",2,loop,"Matched");
		 		if(!flagcomp){
		 			msg = "All the Pricing details are same in UAT & WIP, but screen compare not possible due to pixel difference in screenshot";      
			        CommonUtil.reportCmpare(msg,pass,WIP_JOURNAL_NAME.get(w),environmentOutput);
		 		}
		 		else{
		 			msg = "All the Pricing details are same in UAT & WIP, please check the compare screenshot result";      
			        CommonUtil.reportCmpare(msg,pass,WIP_JOURNAL_NAME.get(w),environmentOutput);
		 		}
		        CommonUtil.refresh(EnvUtil.getProperty("WIP_URL"));
				CommonUtil.sleep(1000);
		        return true;
				
	 }
	 else{
		 	msg = "The Pricing details are different in UAT & WIP";
		 	CommonUtil.report(msg, fail,WIP_JOURNAL_NAME.get(w));
		 	excelWrite.setValueIntoCellCol("PricingCompare",2,loop,"NotMatched");
			if(!flagcomp){
	 			msg = "The Pricing details are different in UAT & WIP, but screen compare not possible due to pixel difference in screenshot";      
		        CommonUtil.reportCmpare(msg,fail,WIP_JOURNAL_NAME.get(w),environmentOutput);
	 		}
	 		else{
	 			msg = "The Pricing details are different in UAT & WIP, please check the compare screenshot result";      
		        CommonUtil.reportCmpare(msg,fail,WIP_JOURNAL_NAME.get(w),environmentOutput);
	 		}
	        CommonUtil.refresh(EnvUtil.getProperty("WIP_URL"));
			CommonUtil.sleep(1000);
	        return false;
	 }
	
	
}

public static String PricingToolView(String volumne) {
	// TODO Auto-generated method stub
	
	CommonUtil.clicksync(clickOnSelection);
	CommonUtil.clicksync(clickOnEntries);
	

    
    CommonUtil.driver.findElement(By.id("dropdownMenu1")).click();
	CommonUtil.driver.findElement(By.xpath(".//*[@id='years']/li[10]/a")).click();
	
	CommonUtil.sleep(5000);
	
	Select number = new Select(CommonUtil.driver.findElement(By.xpath(".//*[@id='myTable_length']/label/select")));
    number.selectByVisibleText("All");
    
    CommonUtil.clicksync(clickOnSearch);
        
    List<WebElement> title = CommonUtil.driver.findElements(By.xpath(".//table[@id='myTable']/tbody/tr"));
    System.out.println(title.size());
	
	return null;
}



public static boolean pricingToolCheckxlsx(String username, String password, int volumne, int loop, XSSFWorkbook workbook) throws Exception {
	// TODO Auto-generated method stub
	readExcelnew();
	 
	
	CommonUtil.clicksync(clickOnSelection);
	CommonUtil.clicksync(clickOnEntries);
	

    
    CommonUtil.driver.findElement(By.id("dropdownMenu1")).click();
	CommonUtil.driver.findElement(By.xpath(".//*[@id='years']/li[10]/a")).click();
	
	CommonUtil.sleep(5000);
	
	Select number = new Select(CommonUtil.driver.findElement(By.xpath(".//*[@id='myTable_length']/label/select")));
    number.selectByVisibleText("All");
    
    CommonUtil.clicksync(clickOnSearch);
    
    String Value=CommonUtil.driver.findElement(By.xpath(".//*[@id='myTable']/tbody/tr["+volumne+"]/td[1]/a")).getAttribute("href");  
	CommonUtil.refresh(Value);
	CommonUtil.sleep(1000);
	
	String splitValue[]=Value.split("main.aspx?");
	String URLdetails=EnvUtil.getProperty("UAT_URL")+"main.aspx"+splitValue[1];
	
	String environment = CommonUtil.getText(environMentDetail);
	String environmentDetails[] = environment.split("Renew Pages - ");
	String environmentModify[] = environmentDetails[1].split("_");
	String environmentFinal1 = environmentModify[0];
	environmentFinal1=environmentFinal1+volumne;
	
	//CommonUtil.scrolldown(sapIssn);
	//CommonUtil.capturePartScreenshot(tablePricingDetail);
	
	 List<String> WIP_JOURNAL_NAME = new ArrayList<String>();
	 List<String> WIP_JOURNAL_NAME_ISSN = new ArrayList<String>();
	 List<String> WIP_JOURNAL_TYPE = new ArrayList<String>();
	 List<String> WIP_DETAILS = new ArrayList<String>();

	 
	 List<String> UAT_JOURNAL_NAME = new ArrayList<String>();
	 List<String> UAT_JOURNAL_NAME_ISSN = new ArrayList<String>();
	 List<String> UAT_JOURNAL_TYPE = new ArrayList<String>();
	 List<String> UAT_DETAILS = new ArrayList<String>();

	 int u=0, g=1, r=2;	 
	for(int i=0; i<=55; i++){
		writeExcel("PricingCompare",u,0,"WIPDETAILS", workbook);
		writeExcel("PricingCompare",g,0,"UATDETAILS", workbook);
		writeExcel("PricingCompare",r,0,"RESULT", workbook);
		u=u+3; g=g+3; r=r+3;
	}
	 
	
	 
	
	    String journalName = CommonUtil.getText(journalTitle);
	    WIP_JOURNAL_NAME.add(journalName); 
	    
	    
	    
	    
	    boolean testflag=ReadExcelDataProvider.getMatchJournal(VariableController.baseSheet,VariableController.CompareSame,journalName);
	    
	    if(!testflag){
	    	msg = "The journal captured is not present in UAT";  
	 		CommonUtil.report(msg, fail,journalName);
	 		CommonUtil.refresh(EnvUtil.getProperty("WIP_URL"));
			CommonUtil.sleep(1000);
	 		return false;
	    }
	    writeExcel("PricingCompare",0,loop,journalName,workbook);
	    
	    msg="Partial Screenshot is captured for "+environmentFinal1;
	    CommonUtil.reportPartScreenshot(msg,pass,journalName,tablePricingDetail,environmentFinal1);
	    
	    String journalNameIssn = CommonUtil.getText(journalIssn);
	    WIP_JOURNAL_NAME_ISSN.add(journalNameIssn); 
	    writeExcel("PricingCompare",3,loop,journalNameIssn,workbook);
	    			    
	    String journalTypePricingtool = CommonUtil.getText(journalType);
	    WIP_JOURNAL_TYPE.add(journalTypePricingtool); 
	    writeExcel("PricingCompare",6,loop,journalTypePricingtool,workbook);
	    
	    List<WebElement> tablerow = CommonUtil.driver.findElements(By.xpath(".//table[@id='tblcurrentPrices']/tbody/tr"));
	    System.out.println(tablerow.size());
	    
	    int xlvalue=6, flag=0, flag1=0, flag2=0;
	    String value;
	    for(int k=2; k<=tablerow.size();k++){
	    	if(k>5 && flag==0){
	    		 CommonUtil.scrolldown(".//*[@id='tblcurrentPrices']");
	    		 flag=1;
	    	 }
	    	if(k>14 && flag1==0){
	    		CommonUtil.scrolldown(By.xpath(".//*[@id='tblcurrentPrices']/tbody/tr["+(k-4)+"]/td[1]/input"));
	    		flag1=1;
	    	}
	    	if(k>17 && flag2==0){
	    		CommonUtil.scrolldown(By.xpath(".//*[@id='tblcurrentPrices']/tbody/tr["+(k-4)+"]/td[1]/input"));
	    		flag2=1;
	    	}
	    	 List<WebElement> tablecol = CommonUtil.driver.findElements(By.xpath(".//table[@id='tblcurrentPrices']/tbody/tr["+k+"]/td"));
	    	 CommonUtil.click(By.xpath(".//*[@id='tblcurrentPrices']/tbody/tr["+k+"]/td[1]/input"));
	    	 if(!(tablecol.size()==1)){
	    	 if(k>2 && tablecol.size()>2)
	    	 {
	    		 	value= CommonUtil.getText(sapIssn);
	    		 	xlvalue=xlvalue+3;
	    		 	WIP_DETAILS.add(value); 
	    		    writeExcel("PricingCompare",xlvalue,loop,value,workbook);
	    	 }
	    	if(tablecol.size()>2){
	    		for(int z=2;z<=tablecol.size();z++){
	    			value=CommonUtil.getText(By.xpath(".//*[@id='tblcurrentPrices']/tbody/tr["+k+"]/td["+z+"]"));
	    			xlvalue=xlvalue+3;
	    			WIP_DETAILS.add(value);
	    			writeExcel("PricingCompare",xlvalue,loop,value,workbook);
	    			
	    		}
	    	}else{
	    		
	    		
	    		
	    		 value=CommonUtil.getText(By.xpath(".//*[@id='tblcurrentPrices']/tbody/tr["+k+"]/td[2]"));
	    		 if(!value.equals("")){
	    				xlvalue=xlvalue+3;
		    			WIP_DETAILS.add(value);
		    			writeExcel("PricingCompare",xlvalue,loop,value,workbook);
	    			}
	    		 /*xlvalue=xlvalue+3;
	    		 WIP_DETAILS.add(value);
	    		 writeExcel("PricingCompare",xlvalue,loop,value);*/
	    	}
	    	
	    }
	  
	  
	    }
	    msg = "The WIP Details has been captured successfully";       
	  	CommonUtil.reportSpecific(msg,pass,journalName,environmentFinal1);

	     
	  CommonUtil.sleep(1000);
	  
		CommonUtil.refresh(EnvUtil.getProperty("UAT_URL"));
		CommonUtil.sleep(1000);
		
		LoginPage.LoginUAT(username,password);
		
		CommonUtil.sleep(1000);
		
		CommonUtil.refresh(URLdetails);
		
		CommonUtil.sleep(1000);

		environment = CommonUtil.getText(environMentDetail);
		String environmentDetails1[] = environment.split("Renew Pages - ");
		String environmentModify1[] = environmentDetails1[1].split("_");
		String environmentFinal2 = environmentModify1[0];
		environmentFinal2=environmentFinal2+volumne;
	//	CommonUtil.scrolldown(sapIssn);
		
		
		journalName = CommonUtil.getText(journalTitle);
	    UAT_JOURNAL_NAME.add(journalName); 
	    writeExcel("PricingCompare",1,loop,journalName,workbook);
	   
	    msg="Partial Screenshot is captured for "+environmentFinal2;
	    CommonUtil.reportPartScreenshot(msg,pass,journalName,tablePricingDetail,environmentFinal2);
	//	CommonUtil.capturePartScreenshot(tablePricingDetail);

	    journalNameIssn = CommonUtil.getText(journalIssn);
	    UAT_JOURNAL_NAME_ISSN.add(journalNameIssn); 
	    writeExcel("PricingCompare",4,loop,journalNameIssn,workbook);
	    			    
	    journalTypePricingtool = CommonUtil.getText(journalType);
	    UAT_JOURNAL_TYPE.add(journalTypePricingtool); 
	    writeExcel("PricingCompare",7,loop,journalTypePricingtool,workbook);
	    
	    List<WebElement> tablerow1 = CommonUtil.driver.findElements(By.xpath(".//table[@id='tblcurrentPrices']/tbody/tr"));
	    System.out.println(tablerow1.size());
	    
	    xlvalue=7; flag=0; flag1=0; flag2=0;
	    
	    for(int k=2; k<=tablerow1.size();k++){
	    	if(k>5 && flag==0){
	    		 CommonUtil.scrolldown(".//*[@id='tblcurrentPrices']");
	    		 flag=1;
	    	 }
	    	if(k>14 && flag1==0){
	    		CommonUtil.scrolldown(By.xpath(".//*[@id='tblcurrentPrices']/tbody/tr["+(k-6)+"]/td[1]/input"));
	    		flag1=1;
	    	}
	    	if(k>17 && flag2==0){
	    		CommonUtil.scrolldown(By.xpath(".//*[@id='tblcurrentPrices']/tbody/tr["+(k-4)+"]/td[1]/input"));
	    		flag2=1;
	    	}
	    	 List<WebElement> tablecol = CommonUtil.driver.findElements(By.xpath(".//table[@id='tblcurrentPrices']/tbody/tr["+k+"]/td"));
	    	 CommonUtil.click(By.xpath(".//*[@id='tblcurrentPrices']/tbody/tr["+k+"]/td[1]/input"));
	    	 if(!(tablecol.size()==1)){
	    	 if(k>2 && tablecol.size()>2)
	    	 {
	    		 	value= CommonUtil.getText(sapIssn);
	    		 	xlvalue=xlvalue+3;
	    		 	UAT_DETAILS.add(value); 
	    		    writeExcel("PricingCompare",xlvalue,loop,value,workbook);
	    	 }
	    	if(tablecol.size()>2){
	    		for(int z=2;z<=tablecol.size();z++){
	    			value=CommonUtil.getText(By.xpath(".//*[@id='tblcurrentPrices']/tbody/tr["+k+"]/td["+z+"]"));
	    			
	    				xlvalue=xlvalue+3;
		    			UAT_DETAILS.add(value);
		    			writeExcel("PricingCompare",xlvalue,loop,value,workbook);
	    			
	    		}
	    	}else{
	    		
	    		 value=CommonUtil.getText(By.xpath(".//*[@id='tblcurrentPrices']/tbody/tr["+k+"]/td[2]"));
	    		 if(!value.equals("")){
	    				xlvalue=xlvalue+3;
		    			UAT_DETAILS.add(value);
		    			writeExcel("PricingCompare",xlvalue,loop,value,workbook);
	    			}
	    	}
	    	
	    }
	  
	    } 
	    
	    msg = "The UAT Details has been captured succesfully";       
	    CommonUtil.reportSpecific(msg,pass,journalName,environmentFinal2);

	    
	    int NotMatchedCount=0,w=0,m=0;
		
	    for ( String S1: WIP_JOURNAL_NAME  )
	        
	    	
		{
			if(UAT_JOURNAL_NAME.contains(S1)) 
		
			{
				w = WIP_JOURNAL_NAME.indexOf(S1);
				m = UAT_JOURNAL_NAME.indexOf(S1);
				
	
				if (WIP_JOURNAL_NAME_ISSN.get(w).equals(UAT_JOURNAL_NAME_ISSN.get(m)))  
					writeExcel("PricingCompare",5,loop,"Matched",workbook);
				else{
					writeExcel("PricingCompare",5,loop,"NotMatched",workbook);
					NotMatchedCount++;
				}
				
				if (WIP_JOURNAL_TYPE.get(w).equals(UAT_JOURNAL_TYPE.get(m)))  
					writeExcel("PricingCompare",8,loop,"Matched",workbook);
				else{
					writeExcel("PricingCompare",8,loop,"NotMatched",workbook);
					NotMatchedCount++;
				}
			}
		}
	    int xlwrite=8;
	    
	    for ( String S1: WIP_DETAILS)
	        
	    	
		{
			if(UAT_DETAILS.contains(S1)) 
		
			{
				xlwrite=xlwrite+3;
				writeExcel("PricingCompare",xlwrite,loop,"Matched",workbook);
			}
			else{
				xlwrite=xlwrite+3;
				writeExcel("PricingCompare",xlwrite,loop,"NotMatched",workbook);
				NotMatchedCount++;
				
			}
		}
	  
	    String WIPPath=System.getProperty("user.dir")+"\\output\\"+VariableController.getTestCaseName()+"\\screenshots\\"+environmentFinal1+".png";
	    String UATPath=System.getProperty("user.dir")+"\\output\\"+VariableController.getTestCaseName()+"\\screenshots\\"+environmentFinal2+".png";
	    String environmentOutput="Output"+volumne;
	    String OuTPath=System.getProperty("user.dir")+"\\output\\"+VariableController.getTestCaseName()+"\\screenshots\\"+environmentOutput+".png";
	    
	   CompareTwoImages cti = new CompareTwoImages(WIPPath, UATPath);
		cti.setParameters(30, 30);
		boolean flagcomp=cti.compare();
		CompareTwoImages.saveJPG(cti.getImageResult(), OuTPath);
	    
		closeExcel();
	    
	 if(NotMatchedCount==0){
		 
		 		msg = "All the Pricing details are same in UAT & WIP";  
		 		CommonUtil.report(msg, pass,WIP_JOURNAL_NAME.get(w));	
		 		if(!flagcomp){
		 			msg = "All the Pricing details are same in UAT & WIP, but screen compare not possible due to pixel difference in screenshot";      
			        CommonUtil.reportCmpare(msg,pass,WIP_JOURNAL_NAME.get(w),environmentOutput);
		 		}
		 		else{
		 			msg = "All the Pricing details are same in UAT & WIP, please check the compare screenshot result";      
			        CommonUtil.reportCmpare(msg,pass,WIP_JOURNAL_NAME.get(w),environmentOutput);
		 		}
		        CommonUtil.refresh(EnvUtil.getProperty("WIP_URL"));
				CommonUtil.sleep(1000);
		        return true;
				
	 }
	 else{
		 	msg = "The Pricing details are different in UAT & WIP";
		 	CommonUtil.report(msg, fail,WIP_JOURNAL_NAME.get(w));
			if(!flagcomp){
	 			msg = "The Pricing details are different in UAT & WIP, but screen compare not possible due to pixel difference in screenshot";      
		        CommonUtil.reportCmpare(msg,fail,WIP_JOURNAL_NAME.get(w),environmentOutput);
	 		}
	 		else{
	 			msg = "The Pricing details are different in UAT & WIP, please check the compare screenshot result";      
		        CommonUtil.reportCmpare(msg,fail,WIP_JOURNAL_NAME.get(w),environmentOutput);
	 		}
	        CommonUtil.refresh(EnvUtil.getProperty("WIP_URL"));
			CommonUtil.sleep(1000);
	        return false;
	 }
	
	
}


public static boolean orderingDisplayTrue(String username, String password, int volumne, int loop) throws WriteException, IOException {
	// TODO Auto-generated method stub
	JavascriptExecutor js = (JavascriptExecutor) CommonUtil.driver;
	
	//String "PricingCompare"=VariableController.getTestCaseName()+"Output";
	CommonUtil.clicksync(clickOnSelection);
	//CommonUtil.clicksync(clickOnEntries);
	

    
	CommonUtil.driver.findElement(By.id("dropdownMenu1")).click();
	CommonUtil.driver.findElement(By.xpath(".//*[@id='years']/li[10]/a")).click();
	
	CommonUtil.sleep(5000);
	
	Select number = new Select(CommonUtil.driver.findElement(By.xpath(".//*[@id='myTable_length']/label/select")));
    number.selectByVisibleText("All");
    
    CommonUtil.clicksync(clickOnSearch);
    
    String Value=CommonUtil.driver.findElement(By.xpath(".//*[@id='myTable']/tbody/tr["+volumne+"]/td[2]/a")).getAttribute("href");
    System.out.println("The URL is "+Value);
	/*CommonUtil.refresh(Value);
	CommonUtil.sleep(1000);*/
	
	
	String getSubMem=CommonUtil.driver.findElement(By.xpath(".//*[@id='myTable']/tbody/tr["+volumne+"]/td[6]")).getText();
	if(getSubMem.equals("Subscription")){
		CommonUtil.refresh(Value);
		
	}
	else{
		CommonUtil.refresh(Value);
	}
	
	
	String strt=Value.replace("ordering-cwswip.onlinelibrary.wiley.com", "ordering-cwspre.aws.wiley.com");
	
	String splitValue[]=Value.split("subs.asp?");
	
		
	
	String URLdetails=strt;
	
	System.out.println("The new URL is "+URLdetails);
	
	

	 List<String> WIP_JOURNAL_TYPE = new ArrayList<String>();
	 List<String> SAME_DETAILS= new ArrayList<String>();
	 List<String> WIP_JOURNAL_BANNER_NAME=  new ArrayList<String>();
	 List<String> WIP_JOURNAL_TITLE_SIZE=  new ArrayList<String>();
	 List<String> WIP_JOURNAL_NAME = new ArrayList<String>();
	 List<String> WIP_JOURNAL_NAME_ISSN = new ArrayList<String>();
	 List<String> WIP_JOURNAL_SIDEBANNER_NAME=  new ArrayList<String>();
	 List<String> WIP_SUBSCRIPTION=new ArrayList<String>();
	 List<String> WIP_DETAILS = new ArrayList<String>();
	 
	 List<String> UAT_JOURNAL_BANNER_NAME=  new ArrayList<String>();
	 List<String> UAT_JOURNAL_TITLE_SIZE=  new ArrayList<String>();
	 List<String> UAT_JOURNAL_NAME = new ArrayList<String>();
	 List<String> UAT_JOURNAL_NAME_ISSN = new ArrayList<String>();
	 List<String> UAT_JOURNAL_SIDEBANNER_NAME=  new ArrayList<String>();
	 List<String> UAT_SUBSCRIPTION=new ArrayList<String>();
	 List<String> UAT_DETAILS = new ArrayList<String>();

	 int u=0, g=1, r=2;	 
	for(int i=0; i<=55; i++){
		excelWrite.setValueIntoCell("GridViewCompare",u,0,"WIPDETAILS");
		excelWrite.setValueIntoCell("GridViewCompare",g,0,"UATDETAILS");
		excelWrite.setValueIntoCell("GridViewCompare",r,0,"RESULT");
		u=u+3; g=g+3; r=r+3;
	}
	
	 
	 String value, zalue, zvalu1[];
	 int random = (int)(Math.random() * 4 + 1);
	 int xlvalue = 0;
	 int t=0;
	
	    //String journalName = CommonUtil.getText(journalTitle);
	    
	    //Above Image get details
	 
	 if(getSubMem.equals("Subscription")){
	 	String journalNameEmpty = CommonUtil.getText(By.xpath(".//*[@id='DivBanner']/div/h1[2]"));
	 	String JournalTitleEmpty=CommonUtil.getText(By.xpath(".//*[@id='productTitle']/h2"));
	 	if(journalNameEmpty.contains("Journal not found")){
	 		msg="No Journal details is present";
	 		CommonUtil.report(msg,fail);
	 		excelWrite.setValueIntoCell("GridViewCompare",0,loop,journalNameEmpty);
	 		CommonUtil.refresh(EnvUtil.getProperty("WIP_URL"));
	 		return false;
	 	}
	 	if(JournalTitleEmpty!=null){
	 	if(JournalTitleEmpty.contains("no longer")){
	 		msg="No Journal details is present";
	 		CommonUtil.report(msg,fail);
	 		excelWrite.setValueIntoCell("GridViewCompare",0,loop,journalNameEmpty);
	 		CommonUtil.refresh(EnvUtil.getProperty("WIP_URL"));
	 		return false;
	 	}
	 	}
	 }else{
		 String journalNameEmpty =CommonUtil.getText(By.xpath("//*[@id='productTitle']/h1[2]"));
		 String JournalTitleEmpty=CommonUtil.getText(By.xpath(".//*[@id='productTitle']/h2"));
		 if(journalNameEmpty!=null){
		 	if(journalNameEmpty.contains("Journal not found")){
		 		msg="No Journal details is present";
		 		CommonUtil.report(msg,fail);
		 		excelWrite.setValueIntoCell("GridViewCompare",0,loop,journalNameEmpty);
		 		CommonUtil.refresh(EnvUtil.getProperty("WIP_URL"));
		 		return false; 
		 	}
		 	if(JournalTitleEmpty.contains("no longer")){
		 		msg="No Journal details is present";
		 		CommonUtil.report(msg,fail);
		 		excelWrite.setValueIntoCell("GridViewCompare",0,loop,journalNameEmpty);
		 		CommonUtil.refresh(EnvUtil.getProperty("WIP_URL"));
		 		return false;
		 	}
		 }
	 }
	    String bannerName = CommonUtil.driver.findElement(By.xpath(".//*[@id='divJournalImageBanner']/img")).getAttribute("src");
	    WIP_JOURNAL_BANNER_NAME.add(bannerName); 
	    excelWrite.setValueIntoCell("GridViewCompare",6,loop,bannerName);
	    
	    //Get the size of above flow banner
	    int journalTitlesize= CommonUtil.driver.findElements(By.xpath("html/body/div[6]/ul/li")).size();
	    String journalTitlesizes=Integer.toString(journalTitlesize);
	    WIP_JOURNAL_TITLE_SIZE.add(journalTitlesizes);
	    excelWrite.setValueIntoCell("GridViewCompare",3,loop,journalTitlesizes);
	    String journalName = null, journalNameISSN, subscriptionDetails;
	    
	  //Get the Side Banner Details
	    String sideBanner= CommonUtil.driver.findElement(By.xpath(".//*[@id='divJournalCoverImage']/p/img")).getAttribute("src");
	    WIP_JOURNAL_SIDEBANNER_NAME.add(sideBanner);
	    excelWrite.setValueIntoCell("GridViewCompare",12,loop,sideBanner);
	    boolean radiocheck1 = false,radiocheck2 = false;
	    if(getSubMem.equals("Subscription")){
	    radiocheck1=CommonUtil.driver.findElement(By.xpath("//form[@id='frmsubs']/fieldset/input[1]")).isDisplayed();
	    radiocheck2=CommonUtil.driver.findElement(By.xpath("//form[@id='frmsubs']/fieldset/input[2]")).isDisplayed();
	    //int radioSize=CommonUtil.driver.findElements(By.xpath("//form[@id='frmsubs']/fieldset/input")).size();
	    }
	    
	    if(radiocheck1 || getSubMem.equals("Membership")){
	    //Get the journal name & journalTitle in case of membership
	    if(getSubMem.equals("Subscription")){
	    	journalName = CommonUtil.getText(By.xpath(".//*[@id='DivBanner']/div/h1[2]"));
		    WIP_JOURNAL_NAME.add(journalName); 
		    excelWrite.setValueIntoCell("GridViewCompare",0,loop,journalName);
		    
		    //Get the Journal Print and Online ISSN details
		    journalNameISSN= CommonUtil.getText(By.xpath(".//*[@id='DivBanner']/div/p[6]"));
		    WIP_JOURNAL_NAME_ISSN.add(journalNameISSN);
		    excelWrite.setValueIntoCell("GridViewCompare",9,loop,journalNameISSN);
		    
		    subscriptionDetails= CommonUtil.getText(By.xpath(".//*[@id='journalHome']/div[2]/div/p[4]"));
		    WIP_SUBSCRIPTION.add(subscriptionDetails);
		    excelWrite.setValueIntoCell("GridViewCompare",15,loop,subscriptionDetails);
		    
		    
		    
		    
		   
		    if(radiocheck2){
		    	CommonUtil.click(By.xpath("//*[@id='other']"));
		    }else{
		    	CommonUtil.click(By.xpath("//*[@id='institutional']"));
		    }
		    
		    if(random==1){
		    	new Select(CommonUtil.driver.findElement(By.id("fld_country"))).selectByVisibleText("United States of America");
		    }
		    if(random==2){
		    	new Select(CommonUtil.driver.findElement(By.id("fld_country"))).selectByVisibleText("United Kingdom");
		    }
		    if(random==3){
		    	new Select(CommonUtil.driver.findElement(By.id("fld_country"))).selectByVisibleText("France");
		    }
		    if(random==4){
		    	new Select(CommonUtil.driver.findElement(By.id("fld_country"))).selectByVisibleText("India");
		    }
		    
		    
		    /*Select country = new Select(CommonUtil.driver.findElement(By.xpath(".//*[@id='fld_country']")));
		    number.selectByValue("P4:102");*/
		    
		    CommonUtil.click(By.xpath(".//*[@id='frmsubs']/fieldset/div/a"));
		    
		    CommonUtil.sleep(1000);
		    
		    t = CommonUtil.driver.findElements(By.id("PricingMatrix")).size();
		    xlvalue=15;
		    for(int i=1;i<=t; i++)
		    {
		    	 

		    List<WebElement> tablerowNon = CommonUtil.driver.findElements(By.xpath(".//*[@id='table_"+i+"']/tbody/tr"));
		    System.out.println(tablerowNon.size());
		    if(i==1){
		    	
		    }
		    

		    if(tablerowNon.size()!=0){
		
		 	    for(int k=2; k<=tablerowNon.size();k++){

		 	    	 List<WebElement> tablecolNon = CommonUtil.driver.findElements(By.xpath(".//*[@id='table_"+i+"']/tbody/tr["+k+"]/td"));

		 	    	for(int z=1;z<=tablecolNon.size();z++){
		 	    		//value=CommonUtil.getText(By.xpath(".//*[@id='table_1']/tbody/tr["+k+"]/td["+z+"]"));
		 	    		if(z==1){
		 	    			value=CommonUtil.getText(By.cssSelector("#table_"+i+" > tbody > tr.clsRow_"+k+" > td.clsCol_"+z+""));
		 	    			z=random;
		 	    		}
		 	    		else{
		 	    			value=CommonUtil.getText(By.cssSelector("#table_"+i+" > tbody > tr.clsRow_"+k+" > td.clsCol_"+z+" > a"));
		 	    			z=tablecolNon.size();
		 	    		}xlvalue=xlvalue+3;
		 	    		if(value!=null){
		 	    			if(value.equals("")){
			 	    			continue;
			 	    		}else{
			 	    			WIP_DETAILS.add(value);
			 	    		}
		 	    		}
		 	    		
		 	    			
		 	    		}
		 	    	
		 	    }
		    }
		    }
 
	    }
	    else{
	    	journalName = CommonUtil.getText(By.xpath("//*[@id='productTitle']/h1[2]"));
		    WIP_JOURNAL_NAME.add(journalName); 
		    excelWrite.setValueIntoCell("GridViewCompare",0,loop,journalName);
		    
		  //Get the Journal Print and Online ISSN details
		    journalNameISSN= CommonUtil.getText(By.xpath(".//*[@id='journalHome']/div[2]/div/h2[1]"));
		    WIP_JOURNAL_NAME_ISSN.add(journalNameISSN);
		    excelWrite.setValueIntoCell("GridViewCompare",9,loop,journalNameISSN);
		    
		    subscriptionDetails= CommonUtil.getText(By.xpath(".//*[@id='journalHome']/div[2]/div/p[3]"));
		    WIP_SUBSCRIPTION.add(subscriptionDetails);
		    excelWrite.setValueIntoCell("GridViewCompare",15,loop,subscriptionDetails);
		    
		 		    
		    
	    }

	    
	   
	    String NewValue= Value+"&DisplayDefault=True";
	    CommonUtil.refresh(NewValue);
	    
	    CommonUtil.sleep(2000);
	    t = CommonUtil.driver.findElements(By.id("PricingMatrix")).size();
	    
	    for(int i=1;i<=t; i++)
	    {

	    List<WebElement> tablerowNon = CommonUtil.driver.findElements(By.xpath("(.//*[@id='PricingMatrix'])["+i+"]/table/tbody/tr"));
	    System.out.println(tablerowNon.size());

	    if(tablerowNon.size()!=0){
	
	 	    for(int k=2; k<=tablerowNon.size();k++){

	 	    	 List<WebElement> tablecolNon = CommonUtil.driver.findElements(By.xpath("(.//*[@id='PricingMatrix'])["+i+"]/table/tbody/tr["+k+"]/td"));

	 	    	for(int z=1;z<=tablecolNon.size();z++){
	 	    		//value=CommonUtil.getText(By.xpath(".//*[@id='table_1']/tbody/tr["+k+"]/td["+z+"]"));
	 	    		value=CommonUtil.getText(By.xpath("(.//*[@id='PricingMatrix']/table/tbody/tr["+k+"]/td["+z+"])["+i+"]"));
	 	    		//	value=CommonUtil.getText(By.cssSelector("#table_"+i+" > tbody > tr.clsRow_"+k+" > td.clsCol_"+z+" > a"));
	 	    		xlvalue=xlvalue+3;
	 	    		if(value!=null){
	 	    			if(value.equals("")){
		 	    			continue;
		 	    		}else{
		 	    			WIP_DETAILS.add(value);
		 	    		}
	 	    		}
	 	    			
	 	    		}
	 	    	
	 	    }
	    }else{
	    	WIP_DETAILS.add("EMPTY");
	    }
	    }
	    }else{
	    	journalName = CommonUtil.getText(By.xpath(".//*[@id='DivBanner']/div/h1[2]"));
		    WIP_JOURNAL_NAME.add(journalName); 
		    excelWrite.setValueIntoCell("GridViewCompare",0,loop,journalName);
	    }
	    
	    
	   
	    msg = "The WIP Details has been captured successfully";       
	  	CommonUtil.report(msg,pass,journalName);

	    CommonUtil.sleep(1000);
	  
		CommonUtil.refresh(EnvUtil.getProperty("UAT_URL"));
		CommonUtil.sleep(1000);
		
		LoginPage.LoginUAT(username,password);
		
		CommonUtil.sleep(1000);
		
		CommonUtil.refresh(URLdetails);
		
		URLdetails= URLdetails+"&DisplayDefault=True";
		
		CommonUtil.sleep(1000);
		

/*		environment = CommonUtil.getText(environMentDetail);
		String environmentDetails1[] = environment.split("Renew Pages - ");
		String environmentModify1[] = environmentDetails1[1].split("_");
		String environmentFinal2 = environmentModify1[0];
		environmentFinal2=environmentFinal2+volumne;*/
		
		 //Above Image get details
	    bannerName = CommonUtil.driver.findElement(By.xpath(".//*[@id='divJournalImageBanner']/img")).getAttribute("src");
	    UAT_JOURNAL_BANNER_NAME.add(bannerName); 
	    excelWrite.setValueIntoCell("GridViewCompare",7,loop,bannerName);
	    
	    //Get the size of above flow banner
	    journalTitlesize= CommonUtil.driver.findElements(By.xpath("html/body/div[6]/ul/li")).size();
	    journalTitlesizes=Integer.toString(journalTitlesize);
	    UAT_JOURNAL_TITLE_SIZE.add(journalTitlesizes);
	    excelWrite.setValueIntoCell("GridViewCompare",4,loop,journalTitlesizes);
	    
	    
	    
	    

	    sideBanner = CommonUtil.driver.findElement(By.xpath(".//*[@id='divJournalCoverImage']/p/img")).getAttribute("src");
	    UAT_JOURNAL_SIDEBANNER_NAME.add(sideBanner);
	    excelWrite.setValueIntoCell("GridViewCompare",13,loop,sideBanner);
	    
	    //radiocheck1=CommonUtil.driver.findElement(By.xpath("//form[@id='frmsubs']/fieldset/input[1]")).isDisplayed();
	    //radiocheck2=CommonUtil.driver.findElement(By.xpath("//form[@id='frmsubs']/fieldset/input[2]")).isDisplayed();
	    //int radioSize=CommonUtil.driver.findElements(By.xpath("//form[@id='frmsubs']/fieldset/input")).size();
	    
	    if(radiocheck1 || getSubMem.equals("Membership")){
	    
	    if(getSubMem.equals("Subscription")){
	    	//Get the journal name
		    journalName = CommonUtil.getText(By.xpath(".//*[@id='DivBanner']/div/h1[2]"));
		    UAT_JOURNAL_NAME.add(journalName); 
		    excelWrite.setValueIntoCell("GridViewCompare",1,loop,journalName);
		    
		  //Get the Journal Print and Online ISSN details
		    journalNameISSN= CommonUtil.getText(By.xpath(".//*[@id='DivBanner']/div/p[6]"));
		    UAT_JOURNAL_NAME_ISSN.add(journalNameISSN);
		    excelWrite.setValueIntoCell("GridViewCompare",10,loop,journalNameISSN);
		    
		    subscriptionDetails= CommonUtil.getText(By.xpath(".//*[@id='journalHome']/div[2]/div/p[4]"));
		    UAT_SUBSCRIPTION.add(subscriptionDetails);
		    excelWrite.setValueIntoCell("GridViewCompare",16,loop,subscriptionDetails);
		    
		    

		    
		    if(radiocheck2){
		    	CommonUtil.click(By.xpath("//*[@id='other']"));
		    }else{
		    	CommonUtil.click(By.xpath("//*[@id='institutional']"));
		    }
		    
		    /*Select country = new Select(CommonUtil.driver.findElement(By.xpath(".//*[@id='fld_country']")));
		    country.selectByVisibleText("India");*/
		    if(random==1){
		    	new Select(CommonUtil.driver.findElement(By.id("fld_country"))).selectByVisibleText("United States of America");
		    }
		    if(random==2){
		    	new Select(CommonUtil.driver.findElement(By.id("fld_country"))).selectByVisibleText("United Kingdom");
		    }
		    if(random==3){
		    	new Select(CommonUtil.driver.findElement(By.id("fld_country"))).selectByVisibleText("France");
		    }
		    if(random==4){
		    	new Select(CommonUtil.driver.findElement(By.id("fld_country"))).selectByVisibleText("India");
		    }
		    
		   // new Select(CommonUtil.driver.findElement(By.id("fld_country"))).selectByVisibleText("Timor-Leste");
		    
		    CommonUtil.click(By.xpath(".//*[@id='frmsubs']/fieldset/div/a"));
		    
		    CommonUtil.sleep(1000);
		    
		    t = CommonUtil.driver.findElements(By.id("PricingMatrix")).size();
		    xlvalue=16;
		    for(int i=1;i<=t; i++)
		    {

		    List<WebElement> tablerowNon = CommonUtil.driver.findElements(By.xpath(".//*[@id='table_"+i+"']/tbody/tr"));
		    System.out.println(tablerowNon.size());
		    
		   

		    if(tablerowNon.size()!=0){
		
		 	    for(int k=2; k<=tablerowNon.size();k++){

		 	    	 List<WebElement> tablecolNon = CommonUtil.driver.findElements(By.xpath(".//*[@id='table_"+i+"']/tbody/tr["+k+"]/td"));

		 	    	for(int z=1;z<=tablecolNon.size();z++){
		 	    		//value=CommonUtil.getText(By.xpath(".//*[@id='table_1']/tbody/tr["+k+"]/td["+z+"]"));
		 	    		if(z==1){
		 	    			value=CommonUtil.getText(By.cssSelector("#table_"+i+" > tbody > tr.clsRow_"+k+" > td.clsCol_"+z+""));
		 	    			z=random;
		 	    		}
		 	    		else{
		 	    			value=CommonUtil.getText(By.cssSelector("#table_"+i+" > tbody > tr.clsRow_"+k+" > td.clsCol_"+z+" > a"));
		 	    			z=tablecolNon.size();
		 	    		}
		 	    		if(value!=null){
		 	    			if(value.equals("")){
			 	    			continue;
			 	    		}else{
			 	    			UAT_DETAILS.add(value);
			 	    		}
		 	    		}
		 	    			
		 	    		}
		 	    	
		 	    }
		    }
		    }
	    }
	    else{
	    	
	    	journalName = CommonUtil.getText(By.xpath("//*[@id='productTitle']/h1[2]"));
		    UAT_JOURNAL_NAME.add(journalName); 
		    excelWrite.setValueIntoCell("GridViewCompare",1,loop,journalName);
		    
		  //Get the Journal Print and Online ISSN details
		    journalNameISSN= CommonUtil.getText(By.xpath(".//*[@id='journalHome']/div[2]/div/h2[1]"));
		    
		    UAT_JOURNAL_NAME_ISSN.add(journalNameISSN);
		    excelWrite.setValueIntoCell("GridViewCompare",10,loop,journalNameISSN);
		    
		    subscriptionDetails= CommonUtil.getText(By.xpath(".//*[@id='journalHome']/div[2]/div/p[3]"));
		    UAT_SUBSCRIPTION.add(subscriptionDetails);
		    excelWrite.setValueIntoCell("GridViewCompare",16,loop,subscriptionDetails);
		    
		    
	    }
	    
	    CommonUtil.refresh(URLdetails);
	    CommonUtil.sleep(1000);
	    
	    t = CommonUtil.driver.findElements(By.id("PricingMatrix")).size();
	    
	    for(int i=1;i<=t; i++)
	    {

	    List<WebElement> tablerowNon = CommonUtil.driver.findElements(By.xpath("(.//*[@id='PricingMatrix'])["+i+"]/table/tbody/tr"));
	    System.out.println(tablerowNon.size());

	    if(tablerowNon.size()!=0){
	
	 	    for(int k=2; k<=tablerowNon.size();k++){

	 	    	 List<WebElement> tablecolNon = CommonUtil.driver.findElements(By.xpath("(.//*[@id='PricingMatrix'])["+i+"]/table/tbody/tr["+k+"]/td"));

	 	    	for(int z=1;z<=tablecolNon.size();z++){
	 	    		//value=CommonUtil.getText(By.xpath(".//*[@id='table_1']/tbody/tr["+k+"]/td["+z+"]"));
	 	    		value=CommonUtil.getText(By.xpath("(.//*[@id='PricingMatrix']/table/tbody/tr["+k+"]/td["+z+"])["+i+"]"));
	 	    		//	value=CommonUtil.getText(By.cssSelector("#table_"+i+" > tbody > tr.clsRow_"+k+" > td.clsCol_"+z+" > a"));
	 	    		if(value!=null){
	 	    			if(value.equals("")){
		 	    			continue;
		 	    		}else{
		 	    			UAT_DETAILS.add(value);
		 	    		}
	 	    		}
	 	    			
	 	    		}
	 	    	
	 	    }
	    }else{
	    	UAT_DETAILS.add("EMPTY");
	    }
	    }
	    }else{
	    	journalName = CommonUtil.getText(By.xpath(".//*[@id='DivBanner']/div/h1[2]"));
		    UAT_JOURNAL_NAME.add(journalName); 
		    excelWrite.setValueIntoCell("GridViewCompare",1,loop,journalName);
	    }
	    
 
	    msg = "The UAT Details has been captured succesfully";       
	    CommonUtil.report(msg,pass,journalName);

	    
	    int NotMatchedCount=0,w=0,m=0;
	
	    if(radiocheck1 || getSubMem.equals("Membership")){
	    
	   if(WIP_JOURNAL_BANNER_NAME.get(0)!=null && UAT_JOURNAL_BANNER_NAME.get(0)!=null){
	    if(WIP_JOURNAL_BANNER_NAME.get(0).equals(UAT_JOURNAL_BANNER_NAME.get(0))){
	    	excelWrite.setValueIntoCell("GridViewCompare",2,loop,"Matched");
	    }
	    else{
	    	excelWrite.setValueIntoCellCol("GridViewCompare",2,loop,"NotMatched");
	    }
	   }
	   
	   if(WIP_JOURNAL_TITLE_SIZE.get(0)!=null && UAT_JOURNAL_TITLE_SIZE.get(0)!=null){
	    if(WIP_JOURNAL_TITLE_SIZE.get(0).equals(UAT_JOURNAL_TITLE_SIZE.get(0))){
	    	excelWrite.setValueIntoCell("GridViewCompare",5,loop,"Matched");
	    }
	    else{
	    	excelWrite.setValueIntoCellCol("GridViewCompare",5,loop,"NotMatched");
	    }
	   }
	   
	   if(WIP_JOURNAL_NAME.get(0)!=null && UAT_JOURNAL_NAME.get(0)!=null){
	    if(WIP_JOURNAL_NAME.get(0).equals(UAT_JOURNAL_NAME.get(0))){
	    	excelWrite.setValueIntoCell("GridViewCompare",8,loop,"Matched");
	    }
	    else{
	    	excelWrite.setValueIntoCellCol("GridViewCompare",8,loop,"NotMatched");
	    }
	   }
	   
	   if(WIP_JOURNAL_NAME_ISSN.get(0)!=null && UAT_JOURNAL_NAME_ISSN.get(0)!=null){
	    if(WIP_JOURNAL_NAME_ISSN.get(0).equals(UAT_JOURNAL_NAME_ISSN.get(0))){
	    	excelWrite.setValueIntoCell("GridViewCompare",11,loop,"Matched");
	    }
	    else{
	    	excelWrite.setValueIntoCellCol("GridViewCompare",11,loop,"NotMatched");
	    }
	   }
	   
	   if(WIP_JOURNAL_SIDEBANNER_NAME.get(0)!=null && UAT_JOURNAL_SIDEBANNER_NAME.get(0)!=null){
	    if(WIP_JOURNAL_SIDEBANNER_NAME.get(0).equals(UAT_JOURNAL_SIDEBANNER_NAME.get(0))){
	    	excelWrite.setValueIntoCell("GridViewCompare",14,loop,"Matched");
	    }
	    else{
	    	excelWrite.setValueIntoCellCol("GridViewCompare",14,loop,"NotMatched");
	    }
	   }
	    
	    if(WIP_SUBSCRIPTION.get(0)!=null && UAT_SUBSCRIPTION.get(0)!=null){
	    if(WIP_SUBSCRIPTION.get(0).equals(UAT_SUBSCRIPTION.get(0))){
	    	excelWrite.setValueIntoCell("GridViewCompare",17,loop,"Matched");
	    }
	    else{
	    	excelWrite.setValueIntoCellCol("GridViewCompare",17,loop,"NotMatched");
	    }
	    }
	    
	    int xlwrite=18;
	    int ud = 0;
	   // int checkflag=0;
	    
	    for ( String S1: WIP_DETAILS) 	
		{	
	    	
			if(UAT_DETAILS.contains(S1)) 
				 
		
			{
				int k = UAT_DETAILS.indexOf(S1);
				excelWrite.setValueIntoCell("GridViewCompare",xlwrite,loop,S1);
				xlwrite++;
				excelWrite.setValueIntoCell("GridViewCompare",xlwrite,loop,UAT_DETAILS.get(k));
				xlwrite++;
				excelWrite.setValueIntoCell("GridViewCompare",xlwrite,loop,"Matched");
				xlwrite++;
				UAT_DETAILS.remove(S1);
				SAME_DETAILS.add(S1);
			}
			else{
				
				//SAME_DETAILS.add(S1);
				excelWrite.setValueIntoCell("GridViewCompare",xlwrite,loop,S1);
				xlwrite=xlwrite+2;
				excelWrite.setValueIntoCellCol("GridViewCompare",xlwrite,loop,"Not Matched");
				xlwrite++;
				NotMatchedCount++;
				
			}
		}
	    xlwrite=16;
	    }else{

		    if(WIP_JOURNAL_BANNER_NAME.get(0).equals(UAT_JOURNAL_BANNER_NAME.get(0))){
		    	excelWrite.setValueIntoCell("GridViewCompare",2,loop,"MatchedButOptIn");
		    }
		    else{
		    	excelWrite.setValueIntoCellCol("GridViewCompare",2,loop,"NotMatched");
		    }
		    if(WIP_JOURNAL_TITLE_SIZE.get(0).equals(UAT_JOURNAL_TITLE_SIZE.get(0))){
		    	excelWrite.setValueIntoCell("GridViewCompare",5,loop,"MatchedOptIn");
		    }
		    else{
		    	excelWrite.setValueIntoCellCol("GridViewCompare",5,loop,"NotMatched");
		    }
		    if(WIP_JOURNAL_NAME.get(0).equals(UAT_JOURNAL_NAME.get(0))){
		    	excelWrite.setValueIntoCell("GridViewCompare",8,loop,"MatchedOptIn");
		    }
		    else{
		    	excelWrite.setValueIntoCellCol("GridViewCompare",8,loop,"NotMatched");
		    }
		    if(WIP_JOURNAL_SIDEBANNER_NAME.get(0).equals(UAT_JOURNAL_SIDEBANNER_NAME.get(0))){
		    	excelWrite.setValueIntoCell("GridViewCompare",14,loop,"Matched");
		    }
		    else{
		    	excelWrite.setValueIntoCellCol("GridViewCompare",14,loop,"NotMatched");
		    }
	    }
	    
	 if(NotMatchedCount==0){
		 
		 		msg = "All the Pricing details are same in UAT & WIP";  
		 		CommonUtil.report(msg, pass);
		 		 CommonUtil.refresh(EnvUtil.getProperty("WIP_URL"));
					CommonUtil.sleep(1000);
		        return true;
				
	 }
	 else{
		 	msg = "The Pricing details are different in UAT & WIP";
		 	CommonUtil.report(msg, fail);
		 	 CommonUtil.refresh(EnvUtil.getProperty("WIP_URL"));
				CommonUtil.sleep(1000);
	        return false;
	 }
	
	
}


public static boolean orderingformPage(String username, String password, int volumne, int loop) throws WriteException {
JavascriptExecutor js = (JavascriptExecutor) CommonUtil.driver;
	
	//String "PricingCompare"=VariableController.getTestCaseName()+"Output";
	CommonUtil.clicksync(clickOnSelection);
	//CommonUtil.clicksync(clickOnEntries);
	

    
	CommonUtil.driver.findElement(By.id("dropdownMenu1")).click();
	CommonUtil.driver.findElement(By.xpath(".//*[@id='years']/li[10]/a")).click();
	
	CommonUtil.sleep(5000);
	
	Select number = new Select(CommonUtil.driver.findElement(By.xpath(".//*[@id='myTable_length']/label/select")));
    number.selectByVisibleText("All");
    
    CommonUtil.clicksync(clickOnSearch);
    
    String Value=CommonUtil.driver.findElement(By.xpath(".//*[@id='myTable']/tbody/tr["+volumne+"]/td[2]/a")).getAttribute("href");  
	/*CommonUtil.refresh(Value);
	CommonUtil.sleep(1000);*/
	
	
	String getSubMem=CommonUtil.driver.findElement(By.xpath(".//*[@id='myTable']/tbody/tr["+volumne+"]/td[6]")).getText();
	if(getSubMem.equals("Subscription")){
		CommonUtil.refresh(Value);
		
	}
	else{
		CommonUtil.refresh(Value);
	}
	
	
	
	
	
	String URLdetails=null;
	
	

	 int u=0, g=1, r=2;	 
	 
	for(int i=0; i<=55; i++){
		excelWrite.setValueIntoCell("GridViewCompare",u,0,"WIPDETAILS");
		excelWrite.setValueIntoCell("GridViewCompare",g,0,"UATDETAILS");
		excelWrite.setValueIntoCell("GridViewCompare",r,0,"RESULT");
		u=u+3; g=g+3; r=r+3;
	}
	
	 
	 String value, zalue, zvalu1[];
	 int random = (int)(Math.random() * 4 + 1);
	 int xlvalue = 0;
	 int t=0;
	
	    //String journalName = CommonUtil.getText(journalTitle);
	 if(getSubMem.equals("Subscription")){
		 	String journalNameEmpty = CommonUtil.getText(By.xpath(".//*[@id='DivBanner']/div/h1[2]"));
		 	String JournalTitleEmpty=CommonUtil.getText(By.xpath(".//*[@id='productTitle']/h2"));
		 	if(journalNameEmpty.contains("Journal not found")){
		 		msg="No Journal details is present";
		 		CommonUtil.report(msg,fail);
		 		excelWrite.setValueIntoCell("GridViewCompare",0,loop,journalNameEmpty);
		 		CommonUtil.refresh(EnvUtil.getProperty("WIP_URL"));
		 		return false;
		 	}
		 	if(JournalTitleEmpty!=null){
		 	if(JournalTitleEmpty.contains("no longer")){
		 		msg="No Journal details is present";
		 		CommonUtil.report(msg,fail);
		 		excelWrite.setValueIntoCell("GridViewCompare",0,loop,journalNameEmpty);
		 		CommonUtil.refresh(EnvUtil.getProperty("WIP_URL"));
		 		return false;
		 	}
		 	}
		 }else{
			 String journalNameEmpty =CommonUtil.getText(By.xpath("//*[@id='productTitle']/h1[2]"));
			 String JournalTitleEmpty=CommonUtil.getText(By.xpath(".//*[@id='productTitle']/h2"));
			 if(journalNameEmpty!=null){
			 	if(journalNameEmpty.contains("Journal not found")){
			 		msg="No Journal details is present";
			 		CommonUtil.report(msg,fail);
			 		excelWrite.setValueIntoCell("GridViewCompare",0,loop,journalNameEmpty);
			 		CommonUtil.refresh(EnvUtil.getProperty("WIP_URL"));
			 		return false; 
			 	}
			 }
			 if(JournalTitleEmpty!=null){
			 	if(JournalTitleEmpty.contains("no longer")){
			 		msg="No Journal details is present";
			 		CommonUtil.report(msg,fail);
			 		excelWrite.setValueIntoCell("GridViewCompare",0,loop,journalNameEmpty);
			 		CommonUtil.refresh(EnvUtil.getProperty("WIP_URL"));
			 		return false;
			 	}
			 }
		 }   
	    
	    
	 	boolean radiocheck1 = false;
		boolean radiocheck2 = false;
		if(getSubMem.equals("Subscription")){
		    radiocheck1=CommonUtil.driver.findElement(By.xpath("//form[@id='frmsubs']/fieldset/input[1]")).isDisplayed();
		    radiocheck2=CommonUtil.driver.findElement(By.xpath("//form[@id='frmsubs']/fieldset/input[2]")).isDisplayed();
		    
		    }
		    
		if(radiocheck1 || getSubMem.equals("Membership")){
	    
		
	   
	    //Get the journal name & journalTitle in case of membership
	    if(getSubMem.equals("Subscription")){
	    	String journalName = CommonUtil.getText(By.xpath(".//*[@id='DivBanner']/div/h1[2]"));		   
		    if(radiocheck2){
		    	CommonUtil.click(By.xpath("//*[@id='other']"));
		    }else{
		    	CommonUtil.click(By.xpath("//*[@id='institutional']"));
		    }
		    
		    if(random==1){
		    	new Select(CommonUtil.driver.findElement(By.id("fld_country"))).selectByVisibleText("United States of America");
		    }
		    if(random==2){
		    	new Select(CommonUtil.driver.findElement(By.id("fld_country"))).selectByVisibleText("United Kingdom");
		    }
		    if(random==3){
		    	new Select(CommonUtil.driver.findElement(By.id("fld_country"))).selectByVisibleText("France");
		    }
		    if(random==4){
		    	new Select(CommonUtil.driver.findElement(By.id("fld_country"))).selectByVisibleText("India");
		    }
		    
		    CommonUtil.click(By.xpath(".//*[@id='frmsubs']/fieldset/div/a"));

		    CommonUtil.sleep(1000);
		    
		    t = CommonUtil.driver.findElements(By.id("PricingMatrix")).size();
		    
		    int random1 = (int)(Math.random() * t + 1);
		    
		    List<WebElement> tablerowNon = CommonUtil.driver.findElements(By.xpath(".//*[@id='table_"+random1+"']/tbody/tr"));
		    System.out.println(tablerowNon.size());
		    
		    int random2=(int)(Math.random() * (tablerowNon.size()-2) + 2);
		    if(radiocheck2){
		    	 value=CommonUtil.getText(By.cssSelector("#table_"+random1+" > tbody > tr.clsRow_"+(tablerowNon.size())+" > td.clsCol_"+(random+1)+" > a"));
		    }else{
		    	 value=CommonUtil.getText(By.cssSelector("#table_"+random1+" > tbody > tr.clsRow_"+random2+" > td.clsCol_"+(random+1)+" > a"));
		    }
		   
		    if(value!=null){
		    	if(radiocheck2){
		    		CommonUtil.driver.findElement(By.cssSelector("#table_"+random1+" > tbody > tr.clsRow_"+(tablerowNon.size())+" > td.clsCol_"+(random+1)+" > a")).click();
		    	}else{
		    	 CommonUtil.driver.findElement(By.cssSelector("#table_"+random1+" > tbody > tr.clsRow_"+random2+" > td.clsCol_"+(random+1)+" > a")).click();
		    	}
		    	CommonUtil.sleep(2000);
		    	 
		    }else{
		    	msg="The price value is null, hence not clickable";
		 		CommonUtil.report(msg,fail);
		 		excelWrite.setValueIntoCell("GridViewCompare",0,loop,journalName);
		 		CommonUtil.refresh(EnvUtil.getProperty("WIP_URL"));
		 		return false;
		    }
		   
		    
	    }else{
	    	
		    
		    CommonUtil.sleep(2000);
		 
		    t = CommonUtil.driver.findElements(By.id("PricingMatrix")).size();
		    
		    int random1 = (int)(Math.random() * t + 1);
		    
		    List<WebElement> tablerowNon = CommonUtil.driver.findElements(By.xpath(".//*[@id='memberPriceTable']/tbody/tr"));
		    System.out.println(tablerowNon.size());
		    
		    int random2=(int)(Math.random() * (tablerowNon.size()-2) + 2);
		    
		    List<WebElement> tablecolNon = CommonUtil.driver.findElements(By.xpath(".//*[@id='memberPriceTable']/tbody/tr["+random2+"]/td"));
		    
		    random=(int)(Math.random() * (tablecolNon.size()-2) + 2);
		    
		    
		    value=CommonUtil.getText(By.xpath(".//*[@id='memberPriceTable']/tbody/tr["+random2+"]/td["+random+"]"));
		    
		    if(value!=null){
		    	
		    	CommonUtil.driver.findElement(By.xpath(".//*[@id='memberPriceTable']/tbody/tr["+random2+"]/td["+random+"]/a")).click();
		    	CommonUtil.sleep(2000);
		    	
		    }
		    else{
		    	String journalName =CommonUtil.getText(By.xpath("//*[@id='productTitle']/h1[2]"));
		    	msg="The price value is null, hence not clickable";
		 		CommonUtil.report(msg,fail);
		 		excelWrite.setValueIntoCell("GridViewCompare",0,loop,journalName);
		 		CommonUtil.refresh(EnvUtil.getProperty("WIP_URL"));
		 		return false;
		    }
		    
		    
		    }
	    }else{
	    	String journalName = CommonUtil.getText(By.xpath(".//*[@id='DivBanner']/div/h1[2]"));
	    	msg = "It is an Opt IN Page";  
	 		CommonUtil.report(msg, pass);
	 		excelWrite.setValueIntoCell("GridViewCompare",0,loop,journalName);
	 		CommonUtil.refresh(EnvUtil.getProperty("WIP_URL"));
	 		return true;
	 		
	    }
		    xlvalue=15;

			 
			 List<String> WIP_JOURNAL_TITLE=  new ArrayList<String>();
			 List<String> WIP_REGION=  new ArrayList<String>();
			 List<String> WIP_NEW_TOTAL = new ArrayList<String>();
			 List<String> WIP_CONFIRMATION = new ArrayList<String>();
			 List<String> WIP_JOURNAL_SIDEBANNER_NAME=  new ArrayList<String>();
			 List<String> WIP_SUBSCRIPTION=new ArrayList<String>();
			 List<String> WIP_PRICE = new ArrayList<String>();
			 
			 List<String> UAT_JOURNAL_TITLE=  new ArrayList<String>();
			 List<String> UAT_REGION=  new ArrayList<String>();
			 List<String> UAT_NEW_TOTAL = new ArrayList<String>();
			 List<String> UAT_CONFIRMATION = new ArrayList<String>();
			 List<String> UAT_JOURNAL_SIDEBANNER_NAME=  new ArrayList<String>();
			 List<String> UAT_SUBSCRIPTION=new ArrayList<String>();
			 List<String> UAT_PRICE = new ArrayList<String>();
			 
			 
			 URLdetails= CommonUtil.driver.getCurrentUrl();
			 
			 String journalTitle= CommonUtil.getText(By.xpath(".//*[@id='productTitle']/h1"));
			 WIP_JOURNAL_TITLE.add(journalTitle);
			 excelWrite.setValueIntoCell("GridViewCompare",0,loop,journalTitle);
			 
			 String journalRegion= CommonUtil.getText(By.xpath(".//*[@id='journalHome']/div[3]/center/div/table/tbody/tr[3]/td[1]/b/b"));
			 WIP_REGION.add(journalRegion);
			 excelWrite.setValueIntoCell("GridViewCompare",3,loop,journalRegion);
			 
			 String subscription= CommonUtil.getText(By.xpath(".//*[@id='substype']/b"));
			 WIP_SUBSCRIPTION.add(subscription);
			 excelWrite.setValueIntoCell("GridViewCompare",6,loop,subscription);
			 
			 String price= CommonUtil.getText(By.xpath(".//*[@id='journalHome']/div[3]/center/div/table/tbody/tr[3]/td[3]/b"));
			 WIP_PRICE.add(price);
			 excelWrite.setValueIntoCell("GridViewCompare",9,loop,price);
			 
			 CommonUtil.click(By.xpath(".//*[@id='pay_ordertype_1']"));
			 
			 String newTotal =CommonUtil.getText(By.xpath(".//*[@id='payvatnumber2']"));
			 WIP_NEW_TOTAL.add(newTotal);
			 excelWrite.setValueIntoCell("GridViewCompare",12,loop,newTotal);
			 
			 String sideBanner = CommonUtil.driver.findElement(By.xpath(".//*[@id='divJournalCoverImage']/p/img")).getAttribute("src");
			 WIP_JOURNAL_SIDEBANNER_NAME.add(sideBanner);
			 excelWrite.setValueIntoCell("GridViewCompare",15,loop,sideBanner);
			 
			 CommonUtil.clear(By.xpath(".//*[@id='fld_email']"));
			 CommonUtil.sendKeys(By.xpath(".//*[@id='fld_email']"), "apsinha@yopmail.com");
			 
			 CommonUtil.clear(By.xpath(".//*[@id='email_verify']"));
			 CommonUtil.sendKeys(By.xpath(".//*[@id='email_verify']"), "apsinha@yopmail.com");
			 
			 Select title = new Select(CommonUtil.driver.findElement(By.xpath(".//*[@id='fld_CourtesyTitle']")));
			 title.selectByVisibleText("Mr.");
			 
			 CommonUtil.clear(By.xpath(".//*[@id='fld_firstname']"));
			 CommonUtil.sendKeys(By.xpath(".//*[@id='fld_firstname']"), "Arka");
			 
			 CommonUtil.clear(By.xpath(".//*[@id='fld_lastname']"));
			 CommonUtil.sendKeys(By.xpath(".//*[@id='fld_lastname']"), "Sinha");
			 
			 if(getSubMem.equals("Subscription") && !radiocheck2){
			 Select InstitutionType = new Select(CommonUtil.driver.findElement(By.xpath(".//*[@id='fld_InstitutionType']")));
			 InstitutionType.selectByVisibleText("Academic");
			 }
			 
			 new Select(CommonUtil.driver.findElement(By.id("fld_country"))).selectByVisibleText("India");
			 
			 CommonUtil.clear(By.xpath(".//*[@id='fld_postcode']"));
			 CommonUtil.sendKeys(By.xpath(".//*[@id='fld_postcode']"), "712104");
			 
			 CommonUtil.clear(By.xpath(".//*[@id='fld_street']"));
			 CommonUtil.sendKeys(By.xpath(".//*[@id='fld_street']"), "Abinash Chandra Road");
			 
			 CommonUtil.click(By.xpath(".//*[@id='journalHome']/form/div/div[7]/div/table/tbody/tr[31]/td[2]/a"));
			 int flag=0;
			 while(true){
				 if((CommonUtil.driver.findElement(By.xpath(".//*[@id='wait2']")).isDisplayed())){
	                  //click on >>
					 flag=flag+1;
					 if(flag==40){
		        		   break;
		        	   }
					 CommonUtil.sleep(2000);
	                
	                 
	           }else{
	        	   if((CommonUtil.driver.findElements(By.xpath("//div[@id='mainListCA']/input")).size()>1)){
	        		   CommonUtil.driver.findElement(By.xpath(".//*[@id='CA2']")).click();
		        	   CommonUtil.sleep(2000);
		        	   break;
	        	   }else{
	        		   CommonUtil.click(By.xpath(".//*[@id='journalHome']/form/div/div[7]/div/table/tbody/tr[31]/td[2]/a"));
	        		   flag=flag+1;
	        		   CommonUtil.sleep(2000);
	        	   }
	        	   
	        	   
	        	   }
	        		   
	           }
			 
			 CommonUtil.click(By.xpath(".//*[@id='pay_vatreg_0']"));
			 CommonUtil.sleep(1000);
			 
			 CommonUtil.scrolldown(By.xpath(".//*[@id='pay_vatreg_0']"));
			 CommonUtil.sleep(1000);
			 
			 
			 CommonUtil.click(By.xpath("(//input[@id='btnDiscount'])[2]"));
			 
			 CommonUtil.clear(By.xpath(".//*[@id='pay_cardholdername']"));
			 CommonUtil.sendKeys(By.xpath(".//*[@id='pay_cardholdername']"), "Arka Sinha");
			 
			 CommonUtil.click(By.xpath(".//*[@id='btnSubscribed']"));
			 
			 CommonUtil.sleep(2000);
			 
			 String urlnow=CommonUtil.driver.getCurrentUrl();
			 if(urlnow.contains("onlinelibrary.wiley.com")){
				 msg="No payment page is dispalyed for this journal";
				 CommonUtil.report(msg, fail);
				 CommonUtil.refresh(EnvUtil.getProperty("WIP_URL"));
				CommonUtil.sleep(1000);
		        return false;
			 }
			 
			 js.executeScript("window.scrollBy(0,1400)");
			// CommonUtil.scrolldown(By.linkText("Payment Details"));
			 urlnow=CommonUtil.driver.getCurrentUrl();
			 
			 int isize = CommonUtil.driver.findElements(By.tagName("iframe")).size();
			 
			 CommonUtil.driver.switchTo().frame(0);
			 
			 CommonUtil.clear(By.xpath("//div[@id='cardPanel']/div[3]/input"));
			 CommonUtil.sendKeys(By.xpath("//div[@id='cardPanel']/div[3]/input"), "4508750015741019");
			 
			 new Select(CommonUtil.driver.findElement(By.xpath("//select[@id='cardExpYear']"))).selectByVisibleText("2020");
			 
			 CommonUtil.clear(By.xpath(".//*[@id='csc']"));
			 CommonUtil.sendKeys(By.xpath(".//*[@id='csc']"), "000");
			 
			 CommonUtil.click(By.id("pay"));
			 
			 CommonUtil.sleep(2000);
			 
			 String confirmation= CommonUtil.getText(By.xpath(".//*[@id='titleConf']/div/p[1]"));
			 WIP_CONFIRMATION.add(confirmation);
			 excelWrite.setValueIntoCell("GridViewCompare",18,loop,confirmation);
			 
		 msg = "The WIP Details has been captured successfully";       
	
		CommonUtil.report(msg,pass,journalTitle);

		CommonUtil.sleep(1000);
			  
		CommonUtil.refresh(EnvUtil.getProperty("UAT_URL"));
		CommonUtil.sleep(1000);
				
		LoginPage.LoginUAT(username,password);
				
		CommonUtil.sleep(1000);
				
		CommonUtil.refresh(URLdetails);
		CommonUtil.sleep(2000);
			
		journalTitle= CommonUtil.getText(By.xpath(".//*[@id='productTitle']/h1"));
		 UAT_JOURNAL_TITLE.add(journalTitle);
		 excelWrite.setValueIntoCell("GridViewCompare",1,loop,journalTitle);
		 
		 journalRegion= CommonUtil.getText(By.xpath(".//*[@id='journalHome']/div[3]/center/div/table/tbody/tr[3]/td[1]/b/b"));
		 UAT_REGION.add(journalRegion);
		 excelWrite.setValueIntoCell("GridViewCompare",4,loop,journalRegion);
		 
		 subscription= CommonUtil.getText(By.xpath(".//*[@id='substype']/b"));
		 UAT_SUBSCRIPTION.add(subscription);
		 excelWrite.setValueIntoCell("GridViewCompare",7,loop,subscription);
		 
		 price= CommonUtil.getText(By.xpath(".//*[@id='journalHome']/div[3]/center/div/table/tbody/tr[3]/td[3]/b"));
		 UAT_PRICE.add(price);
		 excelWrite.setValueIntoCell("GridViewCompare",10,loop,price);
		 
		 CommonUtil.click(By.xpath(".//*[@id='pay_ordertype_1']"));
		 
		 newTotal =CommonUtil.getText(By.xpath(".//*[@id='payvatnumber2']"));
		 UAT_NEW_TOTAL.add(newTotal);
		 excelWrite.setValueIntoCell("GridViewCompare",13,loop,newTotal);
		 
		 sideBanner = CommonUtil.driver.findElement(By.xpath(".//*[@id='divJournalCoverImage']/p/img")).getAttribute("src");
		 UAT_JOURNAL_SIDEBANNER_NAME.add(sideBanner);
		 excelWrite.setValueIntoCell("GridViewCompare",16,loop,sideBanner);
		 
		 CommonUtil.clear(By.xpath(".//*[@id='fld_email']"));
		 CommonUtil.sendKeys(By.xpath(".//*[@id='fld_email']"), "apsinha@yopmail.com");
		 
		 CommonUtil.clear(By.xpath(".//*[@id='email_verify']"));
		 CommonUtil.sendKeys(By.xpath(".//*[@id='email_verify']"), "apsinha@yopmail.com");
		 
		 title = new Select(CommonUtil.driver.findElement(By.xpath(".//*[@id='fld_CourtesyTitle']")));
		 title.selectByVisibleText("Mr.");
		 
		 CommonUtil.clear(By.xpath(".//*[@id='fld_firstname']"));
		 CommonUtil.sendKeys(By.xpath(".//*[@id='fld_firstname']"), "Arka");
		 
		 CommonUtil.clear(By.xpath(".//*[@id='fld_lastname']"));
		 CommonUtil.sendKeys(By.xpath(".//*[@id='fld_lastname']"), "Sinha");
		 
		 if(getSubMem.equals("Subscription")  && !radiocheck2){
		 Select InstitutionType = new Select(CommonUtil.driver.findElement(By.xpath(".//*[@id='fld_InstitutionType']")));
		 InstitutionType.selectByVisibleText("Academic");
		 }
		 new Select(CommonUtil.driver.findElement(By.id("fld_country"))).selectByVisibleText("India");
		 
		 CommonUtil.clear(By.xpath(".//*[@id='fld_postcode']"));
		 CommonUtil.sendKeys(By.xpath(".//*[@id='fld_postcode']"), "712104");
		 
		 CommonUtil.clear(By.xpath(".//*[@id='fld_street']"));
		 CommonUtil.sendKeys(By.xpath(".//*[@id='fld_street']"), "Abinash Chandra Road");
		 
		 CommonUtil.click(By.xpath(".//*[@id='journalHome']/form/div/div[7]/div/table/tbody/tr[31]/td[2]/a"));
		 flag=0;
		 while(true){
			 if((CommonUtil.driver.findElement(By.xpath(".//*[@id='wait2']")).isDisplayed())){
                 //click on >>
				 flag=flag+1;
				 if(flag==40){
	        		   break;
	        	   }
				 CommonUtil.sleep(2000);
               
                
          }else{
       	   if((CommonUtil.driver.findElements(By.xpath("//div[@id='mainListCA']/input")).size()>1)){
       		   CommonUtil.driver.findElement(By.xpath(".//*[@id='CA2']")).click();
	        	   CommonUtil.sleep(2000);
	        	   break;
       	   }else{
       		   CommonUtil.click(By.xpath(".//*[@id='journalHome']/form/div/div[7]/div/table/tbody/tr[31]/td[2]/a"));
       		   flag=flag+1;
       		   CommonUtil.sleep(2000);
       	   }
       	   
       	   
       	   }
       		   
          }
		 
		 CommonUtil.click(By.xpath(".//*[@id='pay_vatreg_0']"));
		 CommonUtil.sleep(1000);
		 
		 CommonUtil.scrolldown(By.xpath(".//*[@id='pay_vatreg_0']"));
		 CommonUtil.sleep(1000);
		 
		 
		 CommonUtil.click(By.xpath("(//input[@id='btnDiscount'])[2]"));
		 
		 CommonUtil.clear(By.xpath(".//*[@id='pay_cardholdername']"));
		 CommonUtil.sendKeys(By.xpath(".//*[@id='pay_cardholdername']"), "Arka Sinha");
		 
		 CommonUtil.click(By.xpath(".//*[@id='btnSubscribed']"));
		 
		 CommonUtil.sleep(2000);
		 
		
		 
		 js.executeScript("window.scrollBy(0,1400)");
		// CommonUtil.scrolldown(By.linkText("Payment Details"));
		 
		 
		 
		 
		 CommonUtil.driver.switchTo().frame(0);
		 
		 CommonUtil.clear(By.xpath("//div[@id='cardPanel']/div[3]/input"));
		 CommonUtil.sendKeys(By.xpath("//div[@id='cardPanel']/div[3]/input"), "4508750015741019");
		 
		 new Select(CommonUtil.driver.findElement(By.xpath("//select[@id='cardExpYear']"))).selectByVisibleText("2020");
		 
		 CommonUtil.clear(By.xpath(".//*[@id='csc']"));
		 CommonUtil.sendKeys(By.xpath(".//*[@id='csc']"), "000");
		 
		 CommonUtil.click(By.id("pay"));
		 
		 CommonUtil.sleep(2000);
		 
		 confirmation= CommonUtil.getText(By.xpath(".//*[@id='titleConf']/div/p[1]"));
		 UAT_CONFIRMATION.add(confirmation);
		 excelWrite.setValueIntoCell("GridViewCompare",19,loop,confirmation);
				 
		 msg = "The UAT Details has been captured succesfully";       
		    CommonUtil.report(msg,pass,journalTitle);

		    
		    int NotMatchedCount=0,w=0,m=0;
		
		 
		    
		   if(WIP_JOURNAL_TITLE.get(0)!=null && UAT_JOURNAL_TITLE.get(0)!=null){
		    if(WIP_JOURNAL_TITLE.get(0).equals(UAT_JOURNAL_TITLE.get(0))){
		    	excelWrite.setValueIntoCell("GridViewCompare",2,loop,"Matched");
		    }
		    else{
		    	excelWrite.setValueIntoCellCol("GridViewCompare",2,loop,"NotMatched");
		    	NotMatchedCount++;
		    }
		   }
		   
		   if(WIP_REGION.get(0)!=null && UAT_REGION.get(0)!=null){
		    if(WIP_REGION.get(0).equals(UAT_REGION.get(0))){
		    	excelWrite.setValueIntoCell("GridViewCompare",5,loop,"Matched");
		    }
		    else{
		    	excelWrite.setValueIntoCellCol("GridViewCompare",5,loop,"NotMatched");
		    	NotMatchedCount++;
		    }
		   }
		   if(WIP_SUBSCRIPTION.get(0)!=null && UAT_SUBSCRIPTION.get(0)!=null){
			    if(WIP_SUBSCRIPTION.get(0).equals(UAT_SUBSCRIPTION.get(0))){
			    	excelWrite.setValueIntoCell("GridViewCompare",8,loop,"Matched");
			    }
			    else{
			    	excelWrite.setValueIntoCellCol("GridViewCompare",8,loop,"NotMatched");
			    }
			    } 
		   
		   
		    if(WIP_PRICE.get(0)!=null && UAT_PRICE.get(0)!=null){
		    if(WIP_PRICE.get(0).equals(UAT_PRICE.get(0))){
		    	excelWrite.setValueIntoCell("GridViewCompare",11,loop,"Matched");
		    }
		    else{
		    	excelWrite.setValueIntoCellCol("GridViewCompare",11,loop,"NotMatched");
		    }
		    }                
	    
		   
		   if(WIP_NEW_TOTAL.get(0)!=null && UAT_NEW_TOTAL.get(0)!=null){
		    if(WIP_NEW_TOTAL.get(0).equals(UAT_NEW_TOTAL.get(0))){
		    	excelWrite.setValueIntoCell("GridViewCompare",14,loop,"Matched");
		    }
		    else{
		    	excelWrite.setValueIntoCellCol("GridViewCompare",14,loop,"NotMatched");
		    	NotMatchedCount++;
		    }
		   }
		   
		   if(WIP_CONFIRMATION.get(0)!=null && UAT_CONFIRMATION.get(0)!=null){
		    if(WIP_CONFIRMATION.get(0).equals(UAT_CONFIRMATION.get(0))){
		    	excelWrite.setValueIntoCell("GridViewCompare",20,loop,"Matched");
		    }
		    else{
		    	excelWrite.setValueIntoCellCol("GridViewCompare",20,loop,"NotMatched");
		    	NotMatchedCount++;
		    }
		   }
		   
		   if(WIP_JOURNAL_SIDEBANNER_NAME.get(0)!=null && UAT_JOURNAL_SIDEBANNER_NAME.get(0)!=null){
		    if(WIP_JOURNAL_SIDEBANNER_NAME.get(0).equals(UAT_JOURNAL_SIDEBANNER_NAME.get(0))){
		    	excelWrite.setValueIntoCell("GridViewCompare",17,loop,"Matched");
		    }
		    else{
		    	excelWrite.setValueIntoCellCol("GridViewCompare",17,loop,"NotMatched");
		    }
		   }
		   
	  
	    
	   

	if(NotMatchedCount==0){
		 
		 		msg = "All the Pricing details are same in UAT & WIP";  
		 		CommonUtil.report(msg, pass);
		 		 CommonUtil.refresh(EnvUtil.getProperty("WIP_URL"));
					CommonUtil.sleep(1000);
		        return true;
				
	 }
	 else{
		 	msg = "The Pricing details are different in UAT & WIP";
		 	CommonUtil.report(msg, fail);
		 	 CommonUtil.refresh(EnvUtil.getProperty("WIP_URL"));
				CommonUtil.sleep(1000);
	        return false;
	 }
	
	

}
}




	







