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



public class Compare_JPSlite extends VariableController {
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
			WOLBrowser.NavigateTo(EnvUtil.getProperty("Browser"),EnvUtil.getProperty("JPS_URL"));	
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

@DataProvider(name="compare11")
	public Object[][] compare11() {
	Object[][] arrayObject = ReadExcelDataProvider.getExcelData(VariableController.indsheet,VariableController.JPSSHEET,"Compare1TC");
	
			return arrayObject;
		}

@Test(dataProvider="compare11")
	public void almtolit(String No,
		   String Active,
		   String Scenario,
		   String TestCase, String Description,
		   String Username,
		   String Password,
		   String PrintISSN, 
		   String OnlineISSN,
		   String Acronym,
		   String JournalDOI,
		   String JournalTitle,
		   String JournalSubtitle,
		   String SocietyName,
		   String SocietyURL,
		   String Coverimagepath,
		   String SubscriptionType,
		   String Frequencydescription,
		   String ElectronicEditorialURL
		  
		   
		  ) {
    String msg;
    
    try{
    	JavascriptExecutor je = (JavascriptExecutor) driver;
    	String newdesc=Description +  PrintISSN;
    	setTestCaseName(No , newdesc, Scenario);
    	
    	assertTrue(LoginPage.LoginWIP(Username,Password), "WIP Login Unsuccessful");
    	assertNotNull(CompareSelection_Page.searchISSN( PrintISSN, OnlineISSN), "Not successfully search");
    	
    	
    	
    	//String Value=CommonUtil.driver.findElement(By).getAttribute("href");

    	
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

@DataProvider(name="compare12")
public Object[][] compare12() {
Object[][] arrayObject = ReadExcelDataProvider.getExcelData(VariableController.indsheet,VariableController.JPSSHEET,"Compare2TC");

		return arrayObject;
	}

@Test(dataProvider="compare12")
public void almtolit1(String No,
	   String Active,
	   String Scenario,
	   String TestCase, String Description,
	   String Username,
	   String Password,
	   String PrintISSN, 
	   String OnlineISSN,
	   String Acronym,
	   String JournalDOI,
	   String JournalTitle,
	   String JournalSubtitle,
	   String SocietyName,
	   String SocietyURL,
	   String Coverimagepath,
	   String SubscriptionType,
	   String Frequencydescription,
	   String ElectronicEditorialURL
	  
	   
	  ) {
String msg;

try{
	JavascriptExecutor je = (JavascriptExecutor) driver;
	String newdesc=Description +  PrintISSN;
	setTestCaseName(No , newdesc, Scenario);
	
	assertTrue(LoginPage.LoginWIP(Username,Password), "WIP Login Unsuccessful");
	assertNotNull(CompareSelection_Page.searchISSN( PrintISSN, OnlineISSN), "Not successfully search");
	
	
	
	//String Value=CommonUtil.driver.findElement(By).getAttribute("href");

	
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
}

