package wiley.automation.wol.test;

import static org.testng.Assert.assertNotNull;
import static org.testng.Assert.assertTrue;

import java.net.URL;
import java.util.Collection;
import java.util.concurrent.TimeUnit;

import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import wiley.automation.core.driver.BrowserList;
import wiley.automation.core.driver.WebBrowser;
import wiley.automation.core.driver.WebConfig;
import wiley.automation.core.report.ReportUtil;
import wiley.automation.core.util.CommonUtil;
import wiley.automation.core.util.EnvUtil;
import wiley.automation.core.util.ReadExcelDataProvider;
import wiley.automation.core.util.VariableController;
import wiley.automation.core.util.excelWrite;
import wiley.automation.core.util.excelWriteNew;
import wiley.automation.wol.workflow.LoginPage;
import wiley.automation.wol.impl.CompareSelectionImpl;
import wiley.automation.wol.workflow.CompareSelection_Page;



public class Compare_Selection extends VariableController {
	//static Logger log = Logger.getLogger(literatum_Sanity.class);
	protected WebBrowser WOLBrowser = null;
	private  WebDriver driver;
	String Status;
	String value,value1,value2, value3, value4, value5, value6, value7, value8, value9, value10, value11, value12, value13, value14, value15, value16, value17, value18, value19;
	static String DOI_local = null;
	//New details
	 public static final String USERNAME = "arka9";
	  public static final String AUTOMATE_KEY = "RGnz6K5nyCZa8Thrzycn";
	  public static final String URL = "https://" + USERNAME + ":" + AUTOMATE_KEY + "@hub-cloud.browserstack.com/wd/hub";


	@BeforeMethod
	public void Setup()
  {
	   //log.info("Before Test");
		try {

			WOLBrowser = BrowserList.Browser("QI");
			WOLBrowser.NavigateTo(EnvUtil.getProperty("Browser"),EnvUtil.getProperty("WIP_URL"));	
			driver = CommonUtil.getDriver();
			driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
			//driver.manage().window().maximize();
			
			Status = null;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}     
  }
@AfterMethod
	 public void TearDown(){
			try {
				WOLBrowser.Quit();
				WOLBrowser = null;
				CommonUtil.CloseDriver();
				Status = null;
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}finally{
				if(WOLBrowser != null){
					WOLBrowser.Quit();
					WOLBrowser = null;
					Status = null;
				}
			}
	    }

// Society Customer Creation

@DataProvider(name="compare1")
	public Object[][] compare1() {
	Object[][] arrayObject = ReadExcelDataProvider.getExcelData(VariableController.indsheet,VariableController.CompareSheet,"Compare_TC");
	
			return arrayObject;
		}

@Test(dataProvider="compare1")
	public void almtolit(String No,
		   String Active,
		   String Scenario,
		   String TestCase, String Description,
		   String Username,
		   String Password,
		   String StartValue, 
		   String EndValue
		  ) {
    String msg;
    
    try{
    	JavascriptExecutor je = (JavascriptExecutor) driver;
    	setTestCaseName(No , Description, Scenario);
    	
    	assertTrue(LoginPage.LoginWIP(Username,Password), "WIP Login Unsuccessful");
    	assertTrue(CompareSelection_Page.compareUATWIP(Username,Password, StartValue), "UAT & WIP details are not same");

    	
    	Status = "Pass";
    	
    	
    	
    }catch(Exception e){
    	msg="Failed step";
    	CommonUtil.report(msg,fail);
    	 CommonUtil.refresh(EnvUtil.getProperty("Literaturm_APPLICATION_URL"));
		 Status = "Fail";
		 
    }
    finally{
    	if(Status == null)
    		Status = "Fail";
    	ReportUtil.generateHTMLReport(Status);
    	
    }
}

//Society Customer Creation

@DataProvider(name="compare2")
	public Object[][] compare2() {
	Object[][] arrayObject = ReadExcelDataProvider.getExcelData(VariableController.indsheet,VariableController.CompareSheet,"Compare2_TC");
	
			return arrayObject;
		}

@Test(dataProvider="compare2")
	public void compare2(String No,
		   String Active,
		   String Scenario,
		   String TestCase, String Description,
		   String Username,
		   String Password,
		   String StartValue, 
		   String EndValue
		  ) {
 String msg;
 
	excelWrite ds = new excelWrite();
 //excelWriteNew ds = new excelWriteNew();
 XSSFWorkbook workbook = null; 	
 try{
 	JavascriptExecutor je = (JavascriptExecutor) driver;
 	setTestCaseName(No , Description, Scenario);
 	int startValue = Integer.valueOf(StartValue);
	int endValue = Integer.valueOf(EndValue);
 	
 	assertTrue(LoginPage.LoginWIP(Username,Password), "WIP Login Unsuccessful");
 	//assertNotNull(value = CompareSelection_Page.PricingToolView(Volumne), "Customer is not created");
 
 	ds.readExcel("Pricing");
 	
 	//CompareSelectionImpl.readExcelnew();
	/*workbook1 = new XSSFWorkbook();
	Sheet studentsSheet = workbook1.createSheet("PricingCompare");*/ 
 	
	int count_fail=0, loop=1;
 	for(int i=startValue; i<=endValue; i++){
 		
 		try{
 			  
 			//assertTrue(CompareSelection_Page.pricingToolCheck(Username,Password, i,loop), "UAT & WIP pricing details are not same");
 			assertTrue(CompareSelection_Page.pricingToolCheck(Username,Password, i,loop), "UAT & WIP pricing details are not same");
 			
 			
 		 }catch(AssertionError e){
 				 
 			 //assertTrue(CompareSelection_Page.pricingToolCheck(Username,Password, i), "UAT & WIP pricing details are not same");
 			 count_fail++;
 				 
 				 
 			}
 		loop++;
 	}
 	//CompareSelectionImpl.closeExcel(workbook);
 	ds.closeFile();
 	if(count_fail == 0){
 		msg="All prices in CWS UAT and WIP are same, please check the excel sheet";
		Status = "Pass";
 		CommonUtil.reportexcel(msg, pass);
 		
 	}	
	else{
		msg="The prices in CWS UAT and WIP are not same, please check the excel sheet";
		Status = "Fail";
 		CommonUtil.reportexcel(msg, fail);
	}
	
 	
 	
 	
 }catch(Exception e){
 	msg="Failed step";
 	ds.closeFile();
 	//CompareSelectionImpl.closeExcel();
 	CommonUtil.reportexcel(msg,fail);
 	CommonUtil.report(msg,fail);
 	 CommonUtil.refresh(EnvUtil.getProperty("WIP_URL"));
		 Status = "Fail";
		 
 }
 finally{
 	if(Status == null)
 		Status = "Fail";
 	ReportUtil.generateHTMLReport(Status);
 	
 }
}


@DataProvider(name="compare3")
	public Object[][] compare3() {
	Object[][] arrayObject = ReadExcelDataProvider.getExcelData(VariableController.indsheet,VariableController.CompareSheet,"Compare3_TC");
	
			return arrayObject;
		}

@Test(dataProvider="compare3")
	public void compare3(String No,
		   String Active,
		   String Scenario,
		   String TestCase, String Description,
		   String Username,
		   String Password,
		   String StartValue, 
		   String EndValue
		  ) {
 String msg;
 
 try{
 	JavascriptExecutor je = (JavascriptExecutor) driver;
 	setTestCaseName(No , Description, Scenario);
 	int startValue = Integer.valueOf(StartValue);
	int endValue = Integer.valueOf(EndValue);
 	
 	assertTrue(LoginPage.LoginWIP(Username,Password), "WIP Login Unsuccessful");
 	//assertNotNull(value = CompareSelection_Page.PricingToolView(Volumne), "Customer is not created");
 	excelWrite ds = new excelWrite();
	ds.readExcel("Pricing");
	int count_fail=0, loop=1;
for(int i=startValue; i<=endValue; i++){
 		
 		try{
 			  
 			//assertTrue(CompareSelection_Page.pricingToolCheck(Username,Password, i,loop), "UAT & WIP pricing details are not same");
 			assertTrue(CompareSelection_Page.pricingToolInsert(Username,Password, i,loop), "UAT & WIP pricing details are not same");
 			
 			
 		 }catch(AssertionError e){
 				 
 			 //assertTrue(CompareSelection_Page.pricingToolCheck(Username,Password, i), "UAT & WIP pricing details are not same");
 			 count_fail++;
 				 
 				 
 			}
 		loop++;
 	}
 	ds.closeFile();
 	if(count_fail == 0){
 		msg="All prices in CWS UAT and WIP are same, please check the excel sheet";
		Status = "Pass";
 		CommonUtil.reportexcel(msg, pass);
 	}	
	else{
		msg="The prices in CWS UAT and WIP are not same, please check the excel sheet";
		Status = "Fail";
 		CommonUtil.reportexcel(msg, pass);
	}
	
 	
 	
 	
 }catch(Exception e){
 	msg="Failed step";
 	CommonUtil.report(msg,fail);
 	 CommonUtil.refresh(EnvUtil.getProperty("Literaturm_APPLICATION_URL"));
		 Status = "Fail";
		 
 }
 finally{
 	if(Status == null)
 		Status = "Fail";
 	ReportUtil.generateHTMLReport(Status);
 	
 }
}

//Society Customer Creation

@DataProvider(name="compare4")
	public Object[][] compare4() {
	Object[][] arrayObject = ReadExcelDataProvider.getExcelData(VariableController.indsheet,VariableController.CompareSheet,"Compare4_TC");
	
			return arrayObject;
		}

@Test(dataProvider="compare4")
	public void compare4(String No,
		   String Active,
		   String Scenario,
		   String TestCase, String Description,
		   String Username,
		   String Password,
		   String StartValue, 
		   String EndValue
		  ) {
String msg;

	excelWrite ds = new excelWrite();
//excelWriteNew ds = new excelWriteNew();
XSSFWorkbook workbook = null; 	
try{
	JavascriptExecutor je = (JavascriptExecutor) driver;
	setTestCaseName(No , Description, Scenario);
	int startValue = Integer.valueOf(StartValue);
	int endValue = Integer.valueOf(EndValue);
	
	assertTrue(LoginPage.LoginWIP(Username,Password), "WIP Login Unsuccessful");
	//assertNotNull(value = CompareSelection_Page.PricingToolView(Volumne), "Customer is not created");

	ds.readExcel("Non");
	
	//CompareSelectionImpl.readExcelnew();
	/*workbook1 = new XSSFWorkbook();
	Sheet studentsSheet = workbook1.createSheet("PricingCompare");*/ 
	
	int count_fail=0, loop=1;
	for(int i=startValue; i<=endValue; i++){
		
		try{
			  
			//assertTrue(CompareSelection_Page.pricingToolCheck(Username,Password, i,loop), "UAT & WIP pricing details are not same");
			assertTrue(CompareSelection_Page.orderingDisplayTrue(Username,Password, i,loop), "UAT & WIP pricing details are not same");
			
			
		 }catch(AssertionError e){
				 
			 //assertTrue(CompareSelection_Page.pricingToolCheck(Username,Password, i), "UAT & WIP pricing details are not same");
			 count_fail++;
				 
				 
			}
		loop++;
	}
	//CompareSelectionImpl.closeExcel(workbook);
	ds.closeFile();
	if(count_fail == 0){
		msg="All prices in CWS UAT and WIP are same, please check the excel sheet";
		Status = "Pass";
		CommonUtil.reportexcel(msg, pass);
		
	}	
	else{
		msg="The prices in CWS UAT and WIP are not same, please check the excel sheet";
		Status = "Fail";
		CommonUtil.reportexcel(msg, fail);
	}
	
	
	
	
}catch(Exception e){
	msg="Failed step";
	ds.closeFile();
	//CompareSelectionImpl.closeExcel();
	CommonUtil.reportexcel(msg,fail);
	CommonUtil.report(msg,fail);
	 CommonUtil.refresh(EnvUtil.getProperty("WIP_URL"));
		 Status = "Fail";
		 
}
finally{
	if(Status == null)
		Status = "Fail";
	ReportUtil.generateHTMLReport(Status);
	
}
}



@DataProvider(name="compare5")
	public Object[][] compare5() {
	Object[][] arrayObject = ReadExcelDataProvider.getExcelData(VariableController.indsheet,VariableController.CompareSheet,"Compare5_TC");
	
			return arrayObject;
		}

@Test(dataProvider="compare5")
	public void compare5(String No,
		   String Active,
		   String Scenario,
		   String TestCase, String Description,
		   String Username,
		   String Password,
		   String StartValue, 
		   String EndValue
		  ) {
String msg;

	excelWrite ds = new excelWrite();
//excelWriteNew ds = new excelWriteNew();
XSSFWorkbook workbook = null; 	
try{
	JavascriptExecutor je = (JavascriptExecutor) driver;
	setTestCaseName(No , Description, Scenario);
	int startValue = Integer.valueOf(StartValue);
	int endValue = Integer.valueOf(EndValue);
	
	assertTrue(LoginPage.LoginWIP(Username,Password), "WIP Login Unsuccessful");
	//assertNotNull(value = CompareSelection_Page.PricingToolView(Volumne), "Customer is not created");

	ds.readExcel("Non");
	
	//CompareSelectionImpl.readExcelnew();
	/*workbook1 = new XSSFWorkbook();
	Sheet studentsSheet = workbook1.createSheet("PricingCompare");*/ 
	
	int count_fail=0, loop=1;
	for(int i=startValue; i<=endValue; i++){
		
		try{
			  
			//assertTrue(CompareSelection_Page.pricingToolCheck(Username,Password, i,loop), "UAT & WIP pricing details are not same");
			assertTrue(CompareSelection_Page.orderingformPage(Username,Password, i,loop), "UAT & WIP pricing details are not same");
			
			
		 }catch(AssertionError e){
				 
			 //assertTrue(CompareSelection_Page.pricingToolCheck(Username,Password, i), "UAT & WIP pricing details are not same");
			 count_fail++;
				 
				 
			}
		loop++;
	}
	//CompareSelectionImpl.closeExcel(workbook);
	ds.closeFile();
	if(count_fail == 0){
		msg="All prices in CWS UAT and WIP are same, please check the excel sheet";
		Status = "Pass";
		CommonUtil.reportexcel(msg, pass);
		
	}	
	else{
		msg="The prices in CWS UAT and WIP are not same, please check the excel sheet";
		Status = "Fail";
		CommonUtil.reportexcel(msg, fail);
	}
	
	
	
	
}catch(Exception e){
	msg="Failed step";
	ds.closeFile();
	//CompareSelectionImpl.closeExcel();
	CommonUtil.reportexcel(msg,fail);
	CommonUtil.report(msg,fail);
	 CommonUtil.refresh(EnvUtil.getProperty("WIP_URL"));
		 Status = "Fail";
		 
}
finally{
	if(Status == null)
		Status = "Fail";
	ReportUtil.generateHTMLReport(Status);
	
}
}

}
