package wiley.automation.wol.impl;


import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;

import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

import wiley.automation.core.util.CommonUtil;
import wiley.automation.core.util.EnvUtil;
import wiley.automation.core.util.ObjectLocator;
import wiley.automation.wol.workflow.LoginPage;

public class ALMtoLITImpl extends ObjectLocator {

 static //Logger log = Logger.getLogger(HomePageImpl.class);
 String msg;
 static String idname,getDOI;
 static int k=1;
 static int q=1;
 static int rowtocheck=0;

 public static void navigateToProcessQueuePage() {
		
	 CommonUtil.refresh(EnvUtil.getProperty("Literatum_APPLICATION_URL_Process_Queue"));
		CommonUtil.sleep(2000);
		
	}

public static boolean hoverOn(String string) {
	// TODO Auto-generated method stub
	CommonUtil.sleep(2000);
	By by = By.linkText(string);
	CommonUtil.mouseOverAction(by);
	CommonUtil.sleep(2000);
	msg = "MouseOver on "+string+" Successful";	
	CommonUtil.report(msg,pass);
	return true;
}


public static boolean clickOnLinkSync(String linktext) {
	// TODO Auto-generated method stub
	By by = By.linkText(linktext);
		if(CommonUtil.isElementPresent(by)){
			CommonUtil.clicksync(by);
			msg = "clicked on "+linktext+" Successful";	
			CommonUtil.report(msg,pass);
			return true;
	}
	msg = "clicked on "+linktext+" UnSuccessful";	
	CommonUtil.report(msg,fail);
	return false;
}


	

public static boolean clickOnLink(String linktext) {
	// TODO Auto-generated method stub
	By by = By.linkText(linktext);
		if(CommonUtil.isElementPresent(by)){
			CommonUtil.click(by);
			msg = "clicked on "+linktext+" Successful";	
			CommonUtil.report(msg,pass);
			return true;
	}
	msg = "clicked on "+linktext+" UnSuccessful";	
	CommonUtil.report(msg,fail);
	return false;
}

public static String createCustomer(String custtype) 

{
	// TODO Auto-generated method stub
//	By by = By.linkText(linktext);
//		if(CommonUtil.isElementPresent(by)){
//			CommonUtil.click(by);
//			msg = "clicked on "+linktext+" Successful";	
	Select drpCustomer = new Select(CommonUtil.driver.findElement(By.id("pt1:_d_reg:region1:1:r2:0:dtrt_dc_4061095816::content")));
	if(custtype.equalsIgnoreCase("Regional Provision")){
		drpCustomer.selectByIndex(6);
	}
	
	else
	
	{
		drpCustomer.selectByVisibleText(custtype);
	}
	
	//Random random = new Random();
    //int randomNumber = random.nextInt(900000) + 100000;
	
	//String custdata= "CUST"+randomNumber;
	
	
	DateFormat ts = new SimpleDateFormat("yyyyMMddHHmmss");
	Date date = new Date();
	String timestamp = ts.format(date);

    String data1="CUST"+timestamp;
    String custdata=data1.toUpperCase();

	
	CommonUtil.sleep(2000);
	CommonUtil.sendKeys(custid, custdata);
	CommonUtil.sendKeys(custname, custdata);
	Select drpCountry = new Select(CommonUtil.driver.findElement(By.id("pt1:_d_reg:region1:1:r2:0:e5182218973::content")));
	drpCountry.selectByIndex(102);
	
	if(custtype.equalsIgnoreCase("Society"))
	
	{
		Select drpRegister = new Select(CommonUtil.driver.findElement(By.id("pt1:_d_reg:region1:1:r2:0:dtrt_dc_6630152345::content")));
		drpRegister.selectByIndex(1);
		
		//CommonUtil.sendKeys(access, String.valueOf(randomNumber));
		//String URLdata= "www.google"+randomNumber+".com";
		//CommonUtil.sendKeys(societyURL, URLdata);
		
		CommonUtil.sendKeys(access,timestamp);
		String URLdata= "www.google"+timestamp+".com";
		CommonUtil.sendKeys(societyURL, URLdata);
		CommonUtil.sendKeys(address, "Gatehauss");
		CommonUtil.sleep(500);
		CommonUtil.sendKeys(city, "Bradford");
		CommonUtil.sleep(500);
		CommonUtil.sendKeys(street, "Green Street");
		CommonUtil.sleep(500);
		CommonUtil.sendKeys(state, "London");
		CommonUtil.sleep(500);
		CommonUtil.sendKeys(pincode, "BD1 5BL");
		CommonUtil.sleep(500);
		
		
	}
	
	if(custtype.equalsIgnoreCase("Institution"))
	{
		Select drpRegister = new Select(CommonUtil.driver.findElement(By.id("pt1:_d_reg:region1:1:r2:0:dtrt_dc_9433075672::content")));
		drpRegister.selectByIndex(1);
	}
	
	if(custtype.equalsIgnoreCase("Personal") || custtype.equalsIgnoreCase("Regional Provision"))
	{
		CommonUtil.sendKeys(maxuser, "1");
	}
	
	else
	{
		CommonUtil.sendKeys(maxuser, "2");
	}
	
	
	CommonUtil.click(submitcustomer);
	CommonUtil.clicksyncALM(stateValue);
	String data=CommonUtil.driver.findElement(By.xpath("//*[@id='pt1:ptsi1']/img")).getAttribute("title");
	

	CommonUtil.sleep(2000);
	String customertype=CommonUtil.getText(custValue).trim();
	

	
	if (customertype.equals(custdata))
	{
			msg = "The customer has been created succesfully";	
			CommonUtil.report(msg,pass);
			return custdata;
	}
	
	msg = "The customer has been not been created succesfully";	
	CommonUtil.report(msg,fail);
	return null;
}



public static void navigateToLitAdminPage() {
	// TODO Auto-generated method stub
	//CommonUtil.clearBrowserData();
	CommonUtil.refresh(EnvUtil.getProperty("Literatum_APPLICATION_ADMIN_URL"));
	CommonUtil.driver.manage().deleteAllCookies();
	CommonUtil.refresh(EnvUtil.getProperty("Literatum_APPLICATION_ADMIN_URL"));
	if(CommonUtil.driver.findElements(By.linkText("Continue to this website (not recommended).")).size() > 0)
		CommonUtil.driver.findElement(By.linkText("Continue to this website (not recommended).")).click();
	CommonUtil.sleep(2000);
	
}

public static void navigateToRSSPage() {
	// TODO Auto-generated method stub
	//CommonUtil.clearBrowserData();
	CommonUtil.refresh(EnvUtil.getProperty("Literatum_APPLICATION_RSS"));
	CommonUtil.driver.manage().deleteAllCookies();
	CommonUtil.refresh(EnvUtil.getProperty("Literatum_APPLICATION_RSS"));
	if(CommonUtil.driver.findElements(By.linkText("Continue to this website (not recommended).")).size() > 0)
		CommonUtil.driver.findElement(By.linkText("Continue to this website (not recommended).")).click();
	CommonUtil.sleep(2000);
	
}


public static boolean checkcustomer(String Volumne, String value) {
    
    // TODO Auto-generated method stub
    
    CommonUtil.clicksync(admin);
    CommonUtil.clicksync(identi);
    while(true){
           if(CommonUtil.driver.findElement(By.xpath("//*[.='"+Volumne+"']")).isDisplayed() == false){
                  //click on >>
                  CommonUtil.driver.findElement(By.xpath("//*[@class='v-tabsheet-scrollerNext']")).click();
           }else{
                  CommonUtil.driver.findElement(By.xpath("//*[@class='v-tabsheet-scrollerNext']")).click();
                  break;
           }
                  
    }
    CommonUtil.driver.findElement(By.xpath("//*[.='"+Volumne+"']")).click();
    CommonUtil.sleep(2000);
    CommonUtil.sendKeys(publicval, value);
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
//                CommonUtil.driver.findElement(By.xpath("//*[@class='v-tabsheet-scrollerNext']")).click();
        	   if(flag>2)
                   break;
         	   else{
         		   CommonUtil.sleep(10000);
         		   flag++;
         	   }
           }
                  
    }
    CommonUtil.sleep(2000);
    
    if(Volumne.equalsIgnoreCase("Basic Group")){
           Actions action = new Actions(CommonUtil.driver);
           WebElement element=CommonUtil.driver.findElement(By.xpath("//*[contains(text(), 'ALM-CU:"+value+"')]"));
           //Double click
           action.doubleClick(element).perform();
           CommonUtil.sleep(3000);
    }
    
    
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
    
    //$('#gwt-uid-52').value
    
    
    msg = "The customer has been not been created properly";      
    CommonUtil.report(msg,fail);
    return false;
}


public static boolean modifyCustomer(String Volumne,String value) {
	// TODO Auto-generated method stub
	CommonUtil.sendKeys(customeID, value);
	CommonUtil.clicksync(clickonsearch);
	CommonUtil.sleep(500);
	CommonUtil.clicksync(clickoncustid);
	CommonUtil.sleep(500);
	
	CommonUtil.clicksync(clickmodify);
	CommonUtil.sleep(500);
	if(Volumne.equalsIgnoreCase("Personal")){
		CommonUtil.sendKeys(firstNameper, "Arka");
		CommonUtil.sleep(500);
		CommonUtil.click(secondNameper);
		CommonUtil.sleep(500);
		CommonUtil.sendKeys(secondNameper, "");
		CommonUtil.sleep(500);
		CommonUtil.sendKeys(secondNameper, "Sinha");
		CommonUtil.sleep(500);
		CommonUtil.sendKeys(emailper, "cyrusonearth@gmail.com");
		CommonUtil.sleep(500);
	}
	else{
		CommonUtil.sendKeys(firstName, "Arka");
		CommonUtil.sleep(500);
		CommonUtil.click(secondName);
		CommonUtil.sleep(500);
		CommonUtil.sendKeys(secondName, "");
		CommonUtil.sleep(500);
		CommonUtil.sendKeys(secondName, "Sinha");
		CommonUtil.sleep(500);
		CommonUtil.sendKeys(email, "cyrusonearth@gmail.com");
		CommonUtil.sleep(500);
	}
	CommonUtil.clear(address);
	CommonUtil.sendKeys(address, "Unitech Building");
	CommonUtil.sleep(500);
	CommonUtil.clear(city);
	CommonUtil.sendKeys(city, "Kolkata");
	CommonUtil.sleep(500);
	CommonUtil.clear(street);
	CommonUtil.sendKeys(street, "Downing Street");
	CommonUtil.sleep(500);
	CommonUtil.clear(state);
	CommonUtil.sendKeys(state, "West Bengal");
	CommonUtil.sleep(500);
	CommonUtil.clear(pincode);
	CommonUtil.sendKeys(pincode, "700156");
	CommonUtil.sleep(500);
	
	msg = "The customer has been modified with this details";	
	CommonUtil.report(msg,pass);
	CommonUtil.click(submitcustomer);
	CommonUtil.clicksyncALM(stateValue);
	String opertaion= CommonUtil.getText(succesfull);
	String[] dataArray2= opertaion.split(" ");
	opertaion=dataArray2[0];
	if(opertaion.equalsIgnoreCase("Successfully"))
	{
		msg = "The customer has been modified succesfully";	
		CommonUtil.report(msg,pass);
		return true;
	}
	
	//$('#gwt-uid-52').value
	
	
	
	
	msg = "Modify customer failed";	
	CommonUtil.report(msg,fail);
	return false;
}

public static boolean checkcustomermod(String Volumne, String value) {
	// TODO Auto-generated method stub
	// TODO Auto-generated method stub
	
		CommonUtil.clicksync(admin);
		CommonUtil.clicksync(identi);
		CommonUtil.sleep(500);
		CommonUtil.sendKeys(publicval, value);
		CommonUtil.sleep(5000);
		CommonUtil.clicksync(search);
		CommonUtil.sleep(30000);
		int flag1=0;
		if(Volumne.equalsIgnoreCase("Basic Group")){
			CommonUtil.clicksync(Address);
			CommonUtil.sleep(3000);
			while(true){
				if((CommonUtil.driver.findElement(By.xpath("//*[@class='v-table-row']/td[2]/div")).getText().equals("")) && (flag1!=20)){
					//click on >>
					
					CommonUtil.clicksync(identi);
					CommonUtil.sleep(500);
					CommonUtil.sendKeys(publicval, value);
					CommonUtil.sleep(10000);
					CommonUtil.clicksync(search);
					CommonUtil.sleep(5000);
					
					CommonUtil.clicksync(Address);
					CommonUtil.sleep(3000);
					
					flag1=flag1+1;
				}else{
//					CommonUtil.driver.findElement(By.xpath("//*[@class='v-tabsheet-scrollerNext']")).click();
					break;
				}
					
			}
			String zipcode= CommonUtil.driver.findElement(By.xpath("//*[@class='v-table-row']/td[4]/div")).getText();
			String city=CommonUtil.driver.findElement(By.xpath("//*[@class='v-table-row']/td[3]/div")).getText();
			
			
		
			if(zipcode.equalsIgnoreCase("700156") && city.equalsIgnoreCase("Kolkata")  )
			{
				msg = "The customer has been Modified and updated succesfully in LIT";	
				CommonUtil.report(msg,pass);
				return true;
			}
			
			//$('#gwt-uid-52').value
			
			
			
			
			msg = "The customer has been not been modified properly";	
			CommonUtil.report(msg,fail);
			return false;
			}
			
		
		else{
			Actions action = new Actions(CommonUtil.driver);
			WebElement element=CommonUtil.driver.findElement(By.xpath("//*[contains(text(), 'PersonUser')]"));
			//Double click
			action.doubleClick(element).perform();
			CommonUtil.sleep(5000);
		
		
		int flag=0;
		while(true){
			if(((CommonUtil.driver.findElement(By.xpath("//*[@class='v-table-cell-content']")).getText()).contains("invalid")) && (flag!=20)){
				//click on >>
				
				CommonUtil.clicksync(identi);
				CommonUtil.sleep(500);
				CommonUtil.sendKeys(publicval, value);
				CommonUtil.sleep(10000);
				CommonUtil.clicksync(search);
				CommonUtil.sleep(5000);
				
				action = new Actions(CommonUtil.driver);
				element=CommonUtil.driver.findElement(By.xpath("//*[contains(text(), 'PersonUser')]"));
				//Double click
				action.doubleClick(element).perform();
				CommonUtil.sleep(5000);
				
				flag=flag+1;
			}else{
//				CommonUtil.driver.findElement(By.xpath("//*[@class='v-tabsheet-scrollerNext']")).click();
				break;
			}
				
		}
		
		
		String firstname= CommonUtil.driver.findElement(By.xpath("//*[@class='v-formlayout-row'][2]//input")).getAttribute("value");
		String secondname=CommonUtil.driver.findElement(By.xpath("//*[@class='v-formlayout-row'][3]//input")).getAttribute("value");
		
		
	
		if(firstname.equalsIgnoreCase("Arka") && secondname.equalsIgnoreCase("Sinha")  )
		{
			msg = "The customer has been Modified and updated succesfully in LIT";	
			CommonUtil.report(msg,pass);
			return true;
		}
		
		//$('#gwt-uid-52').value
		
		
		
		
		msg = "The customer has been not been modified properly";	
		CommonUtil.report(msg,fail);
		return false;
		}
	}

public static boolean checkcustomermod1(String volumne, String value) {
	// TODO Auto-generated method stub
	CommonUtil.clicksync(admin);
	CommonUtil.clicksync(accesstoken);
	CommonUtil.sleep(2000);
	CommonUtil.sendKeys(tokenval, value);
	CommonUtil.clicksync(searchtoken);
	CommonUtil.sleep(10000);
	int flag=0;
	String title=CommonUtil.driver.getTitle();
	while(true){
		if(title.contains(volumne) && (flag!=40)){
			//click on >>
			break;
			
		}else{
//			CommonUtil.driver.findElement(By.xpath("//*[@class='v-tabsheet-scrollerNext']")).click();
			CommonUtil.clicksync(accesstoken);
			CommonUtil.sleep(2000);
			CommonUtil.sendKeys(tokenval, value);
			CommonUtil.clicksync(searchtoken);
			CommonUtil.sleep(10000);
			flag=flag+1;
		}
		
			
	}
	
	
	
	//String email= CommonUtil.driver.findElement(By.xpath("//*[@class='v-formlayout-row'][2]//input")).getAttribute("value");
	if(title.contains(volumne))
	{
		msg = "The customer has been Modified and updated succesfully in LIT";	
		CommonUtil.report(msg,pass);
		return true;
	}
	
	//$('#gwt-uid-52').value
	
	
	
	
	msg = "The customer has been not been modified properly";	
	CommonUtil.report(msg,fail);
	return false;
}

public static boolean checkcustomerper(String Volumne, String value) {
	// TODO Auto-generated method stub
	
	CommonUtil.clicksync(admin);
	CommonUtil.clicksync(accesstoken);

	CommonUtil.sleep(2000);
	CommonUtil.sendKeys(tokenval, value);
	CommonUtil.clicksync(searchtoken);
	CommonUtil.sleep(10000);
	int flag=0;
	while(true){
		if((CommonUtil.driver.findElements(By.xpath("//div[contains(@id, 'window_close')]")).size()>0) && (flag!=40)){
			//click on >>
			CommonUtil.driver.findElement(By.xpath("//div[contains(@id, 'window_close')]")).click();
			CommonUtil.sleep(10000);
			CommonUtil.clicksync(searchtoken);
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
	String[] dataArray1= fetchdata.split(":");
	fetchdata=dataArray1[2];
	if(fetchdata.equalsIgnoreCase(value))
	{
		msg = "The customer has been created and fetched succesfully";	
		CommonUtil.report(msg,pass);
		return true;
	}
	
	//$('#gwt-uid-52').value
	
	
	
	
	msg = "The customer has been not been created properly";	
	CommonUtil.report(msg,fail);
	return false;
}

public static boolean deleteCustomer(String value) {
	// TODO Auto-generated method stub+
	CommonUtil.sendKeys(customeID, value);
	CommonUtil.clicksync(clickonsearch);
	CommonUtil.sleep(500);
	CommonUtil.clicksync(clickoncustid);
	CommonUtil.sleep(500);
	CommonUtil.clicksync(clickdelete);
	CommonUtil.sleep(500);
	msg = "The customer about to be deleted";	
	CommonUtil.report(msg,pass);
	CommonUtil.click(submitcustomer);
	CommonUtil.clicksyncALM(stateValue);
	String opertaion= CommonUtil.getText(succesfull);
	String[] dataArray2= opertaion.split(" ");
	opertaion=dataArray2[0];
	if(opertaion.equalsIgnoreCase("Successfully"))
	{
		msg = "The customer has been deleted succesfully";	
		CommonUtil.report(msg,pass);
		return true;
	}
	
	//$('#gwt-uid-52').value
	
	
	
	
	msg = "Delete customer failed";	
	CommonUtil.report(msg,fail);
	return false;
}

public static boolean checkcustomerdel(String string, String value) {
	// TODO Auto-generated method stub
	CommonUtil.clicksync(admin);
	CommonUtil.clicksync(identi);
	CommonUtil.sleep(500);
	CommonUtil.sendKeys(publicval, value);
	CommonUtil.sleep(10000);
	CommonUtil.clicksync(search);
	CommonUtil.sleep(5000);
	int flag=0;
	while(true){
		if((CommonUtil.driver.findElements(By.xpath("//div[contains(@id, 'window_close')]")).size()==0) && (CommonUtil.driver.findElements(By.xpath("//*[contains(text(), 'Description')]")).size()>0) && (flag!=20)){
			//click on >>
			CommonUtil.clicksync(identi);
			CommonUtil.sleep(500);
			CommonUtil.sendKeys(publicval, value);
			CommonUtil.sleep(10000);
			CommonUtil.clicksync(search);
			CommonUtil.sleep(5000);
			flag=flag+1;
		}else{
//			CommonUtil.driver.findElement(By.xpath("//*[@class='v-tabsheet-scrollerNext']")).click();
			if((CommonUtil.driver.findElements(By.xpath("//div[contains(@id, 'window_close')]")).size()>0)){
				msg="The customer has been deleted properly";
				
				CommonUtil.report(msg,pass);
				return true;
			}
			break;
		}
			
	}
	msg = "Delete customer failed";	
	CommonUtil.report(msg,fail);
	return false;
	
}

public static String resetpassword(String Volumne) 

{
	// TODO Auto-generated method stub
	CommonUtil.sendKeys(customeID, Volumne);
	CommonUtil.clicksync(clickonsearch);
	CommonUtil.sleep(500);
	CommonUtil.clicksync(clickoncustid);
	CommonUtil.sleep(500);
	CommonUtil.clicksync(clickreset);
	CommonUtil.sleep(5000);
	msg = "The customer set to reset password";	
	CommonUtil.report(msg,pass);
	CommonUtil.click(clickradio);
	Random random = new Random();
	int randomNumber = random.nextInt(9000) + 1000;
	CommonUtil.sleep(5000);
	String password= "Kolkat"+randomNumber;
	CommonUtil.sendKeys(setpassword, password);
	CommonUtil.sleep(500);
	CommonUtil.sendKeys(resetpassword, password);
	CommonUtil.sleep(500);
	CommonUtil.clicksync(clickresetpassword);
	
	String confirm=CommonUtil.driver.findElement(By.xpath("//*[@id='pt1:_diags:pgl9']/tbody/tr/td[3]")).getText();
	
	if((CommonUtil.driver.findElements(By.xpath("//*[contains(text(), 'Password has been reset successfully')]")).size()>0))
	{
		msg = "The customer password has been reset'd succesfully";	
		CommonUtil.report(msg,pass);
		return password;
	}
	
	//$('#gwt-uid-52').value
	
	
	
	
	msg = "Password change has failed";	
	CommonUtil.report(msg,fail);
	return null;
}

public static void navigateToLitPage() {
	// TODO Auto-generated method stub
	CommonUtil.refresh(EnvUtil.getProperty("Literaturm_APPLICATION_URL"));
	CommonUtil.driver.manage().deleteAllCookies();
	CommonUtil.refresh(EnvUtil.getProperty("Literaturm_APPLICATION_URL"));
	CommonUtil.sleep(2000);
}

public static void navigateToRSSPage1() {
	// TODO Auto-generated method stub
	CommonUtil.refresh(EnvUtil.getProperty("Literaturm_APPLICATION_RSS1"));
	CommonUtil.sleep(2000);
}


public static String createCustomerUser(String custtype) {
	Select drpCustomer = new Select(CommonUtil.driver.findElement(By.id("pt1:_d_reg:region1:1:r2:0:dtrt_dc_4061095816::content")));
			drpCustomer.selectByVisibleText(custtype);
	
	CommonUtil.sleep(2000);
	
	/*Random random = new Random();
	int randomNumber = random.nextInt(9000) + 1000;
	
	String custdata= "apsinha"+randomNumber+"@yopmail.com";
	
	*/
	
	DateFormat ts = new SimpleDateFormat("YYMMddHHmm");
	Date date = new Date();
	String timestamp = ts.format(date);

    String data1="apsinha"+timestamp+"@yahoo.com";
    String custdata=data1.toUpperCase();
	
	
	CommonUtil.sleep(2000);
	
	CommonUtil.sendKeys(emailuser, custdata);
	CommonUtil.sendKeys(passworduser, "Kolkata012");
	CommonUtil.sleep(500);
	CommonUtil.click(confirmpassworduser);
	CommonUtil.sleep(500);
	CommonUtil.sendKeys(confirmpassworduser, "");
	CommonUtil.sleep(500);
	CommonUtil.sendKeys(confirmpassworduser, "Kolkata012");
	CommonUtil.sleep(500);
	
	CommonUtil.sendKeys(firstNameper, "Arka");
	CommonUtil.sleep(500);
	CommonUtil.click(secondNameper);
	CommonUtil.sleep(500);
	CommonUtil.sendKeys(secondNameper, "");
	CommonUtil.sleep(500);
	CommonUtil.sendKeys(secondNameper, "Sinha");
	CommonUtil.sleep(500);
	Select drpRegister = new Select(CommonUtil.driver.findElement(By.id("pt1:_d_reg:region1:1:r2:0:dtrt_dc_9433075672::content")));
	drpRegister.selectByIndex(1);

	CommonUtil.sendKeys(address, "Gatehauss");
	CommonUtil.sleep(500);
	CommonUtil.sendKeys(city, "Bradford");
	CommonUtil.sleep(500);
	CommonUtil.sendKeys(street, "Green Street");
	CommonUtil.sleep(500);
	CommonUtil.sendKeys(state, "London");
	CommonUtil.sleep(500);
	CommonUtil.sendKeys(pincode, "BD1 5BL");
	CommonUtil.sleep(500);
	
	
	CommonUtil.click(submitcustomer);
	CommonUtil.clicksyncALM(stateValue);
	
	
	CommonUtil.sleep(2000);
	String customertype=CommonUtil.getText(custValue);
	
	if (customertype.equalsIgnoreCase(custdata))
	{
			msg = "The customer has been created succesfully";	
			CommonUtil.report(msg,pass);
			return custdata;
	}
	msg = "The customer has been not been created succesfully";	
	CommonUtil.report(msg,fail);
	return null;
}

public static String createLicense(String volumne, String License) 

{
	// TODO Auto-generated method stub
	CommonUtil.sendKeys(customeID, volumne);
	CommonUtil.clicksync(clickonsearch);
	CommonUtil.sleep(500);
	CommonUtil.clicksync(clickoncustid);
	CommonUtil.sleep(500);
	CommonUtil.clicksync(clickonAttribute);
	CommonUtil.sleep(500);
	CommonUtil.clicksync(clickmanageLicnese);
	CommonUtil.sleep(1000);
	CommonUtil.clicksync(clickAddLicense);
    
	//Random random = new Random();
	//int randomNumber = random.nextInt(9000) + 1000;
	

	
	
    DateFormat ts = new SimpleDateFormat("yyyyMMddHHmmss");
    DateFormat ts1 = new SimpleDateFormat("yyyyMMdd");
	Date date = new Date();
	String timestamp = ts.format(date).toUpperCase();
	String timestamp1= ts1.format(date);
	

	
	String licensedata = null;
	
	if(License.equalsIgnoreCase("Debit License"))
	
	{
		//licensedata= "LICE"+randomNumber;
		//String licensedesc= "New License Created for LICE"+randomNumber;
		licensedata= "LICE"+timestamp;
		String licensedesc= "New License Created for LICE"+timestamp;
		CommonUtil.sendKeys(LicenseID, licensedata);
		CommonUtil.sendKeys(description,licensedesc);
		CommonUtil.sendKeys(tokens, "100");
		Select drpLicenseType = new Select(CommonUtil.driver.findElement(By.id("pt1:_d_reg:region3:1:soc4::content")));
		drpLicenseType.selectByIndex(2);
		Select drpPolicy = new Select(CommonUtil.driver.findElement(By.id("pt1:_d_reg:region3:1:soc5::content")));
		drpPolicy.selectByIndex(3);
	}
	if(License.equalsIgnoreCase("Personal Debit License"))
	{
		//licensedata= "PERS"+randomNumber;
		//String licensedesc= "New License Created for PERS"+randomNumber;
		
		licensedata= "PERS"+timestamp;
		String licensedesc= "New License Created for PERS"+timestamp;
		
		CommonUtil.sendKeys(LicenseID, licensedata);
		CommonUtil.sendKeys(description,licensedesc);
		CommonUtil.sendKeys(tokens, "100");
		Select drpLicenseType = new Select(CommonUtil.driver.findElement(By.id("pt1:_d_reg:region3:1:soc4::content")));
		drpLicenseType.selectByIndex(4);
		CommonUtil.sleep(500);
		Select drpPolicy = new Select(CommonUtil.driver.findElement(By.id("pt1:_d_reg:region3:1:soc5::content")));
		drpPolicy.selectByIndex(2);
		CommonUtil.sleep(1000);
	    //String strI = Integer.toString(randomNumber);
		//CommonUtil.sendKeys(tranID, strI);
	    //CommonUtil.sendKeys(fullID, strI);
	
		CommonUtil.sleep(1000);
	     
		CommonUtil.sendKeys(tranID, timestamp1);
		CommonUtil.sendKeys(fullID, timestamp1);
		CommonUtil.sleep(1000);
	}
	if(License.equalsIgnoreCase("Subscription"))
	
	{
		//licensedata= "SUBC"+randomNumber;
		//String licensedesc= "New License Created for SUBC"+randomNumber;
		
		licensedata= "SUBC"+timestamp;
		String licensedesc= "New License Created for SUBC"+timestamp;
		
		CommonUtil.sendKeys(LicenseID, licensedata);
		CommonUtil.sendKeys(description,licensedesc);
		CommonUtil.sendKeys(tokens, "0");
		Select drpLicenseType = new Select(CommonUtil.driver.findElement(By.id("pt1:_d_reg:region3:1:soc4::content")));
		drpLicenseType.selectByIndex(5);
		Select drpPolicy = new Select(CommonUtil.driver.findElement(By.id("pt1:_d_reg:region3:1:soc5::content")));
		drpPolicy.selectByIndex(3);
	}
	
	Select drpStatus = new Select(CommonUtil.driver.findElement(By.id("pt1:_d_reg:region3:1:soc1::content")));
	drpStatus.selectByIndex(1);
	CommonUtil.click(contentStartDate);
	CommonUtil.sleep(1000);
	CommonUtil.click(selectstartdate);
	CommonUtil.sleep(1000);
	CommonUtil.click(contentEndDate);
	CommonUtil.sleep(1000);
	CommonUtil.click(selectarrow);
	CommonUtil.sleep(1000);
	CommonUtil.click(selectenddate);
	CommonUtil.sleep(1000);
	CommonUtil.click(validFromDate);
	CommonUtil.sleep(1000);
	CommonUtil.click(selectstartdate);
	CommonUtil.sleep(1000);
	CommonUtil.click(validEndDate);
	CommonUtil.sleep(1000);
	CommonUtil.click(selectarrow1);
	CommonUtil.sleep(1000);
	CommonUtil.click(selectenddate1);
	CommonUtil.sleep(1000);
	
	CommonUtil.click(addProduct);
	CommonUtil.sleep(1000);
	CommonUtil.sendKeys(productID, "1118916255");
	CommonUtil.sleep(1000);
	CommonUtil.click(searchproduct);
	CommonUtil.sleep(3000);
	CommonUtil.click(newrow);
	CommonUtil.sleep(1000);
	CommonUtil.clicksync(addSelected);
	CommonUtil.sleep(500);
	CommonUtil.scrolldown(addSelected);
	CommonUtil.sleep(500);
	CommonUtil.clicksync(selectok);
	CommonUtil.sleep(500);
	CommonUtil.clicksync(submitcustomerxpath);
	CommonUtil.sleep(3000);
	String message= CommonUtil.driver.findElement(By.xpath("//*[@id='pt1:_d_reg:region3:2:psl1::c']/span")).getText();
	if(message.contains("Successfully")){
		msg = "The License has been created succesfully";	
		CommonUtil.report(msg,pass);
		return licensedata;
	}
	msg = "The License has been not been created succesfully";	
	CommonUtil.report(msg,fail);
	return null;
}

public static boolean checkLicense(String string) 

{
	
	CommonUtil.clicksync(admin);
	CommonUtil.clicksync(License);
	CommonUtil.sleep(500);
	CommonUtil.sendKeys(codeval,string);
	CommonUtil.sleep(10000);
	CommonUtil.clicksync(searchLicense);
	CommonUtil.sleep(5000);
	int flag=0;
	while(true){
		if((CommonUtil.driver.findElements(By.xpath("//div[contains(@id, 'window_close')]")).size()>0) && (flag!=40)){
			//click on >>
			CommonUtil.driver.findElement(By.xpath("//div[contains(@id, 'window_close')]")).click();
			CommonUtil.sleep(10000);
			CommonUtil.clicksync(searchLicense);
			flag=flag+1;
		}
		
		else
		{

			if(flag>2)
                break;
      	   else{
      		   CommonUtil.sleep(10000);
      		   flag++;
      	   }
		}
			
	}
	
	String getTitle_License= CommonUtil.driver.getTitle();
	
	String text[]=string.split("-LID-");
	string= text[1];
	if(getTitle_License.contains(string)){
		msg = "The License has been found succesfully";	
		CommonUtil.report(msg,pass);
		return true;
	}
	msg = "The License has not been found succesfully";	
	CommonUtil.report(msg,fail);
	return false;
}

public static boolean modifyLicense(String volumne, String value) {
	// TODO Auto-generated method stub
	CommonUtil.sendKeys(customeID, volumne);
	CommonUtil.clicksync(clickonsearch);
	CommonUtil.sleep(500);
	CommonUtil.clicksync(clickoncustid);
	CommonUtil.sleep(500);
	CommonUtil.clicksync(clickonAttribute);
	CommonUtil.sleep(500);
	CommonUtil.clicksync(clickmanageLicnese);
	CommonUtil.sleep(1000);
	CommonUtil.driver.findElement(By.xpath("//*[contains(text(), '"+value+"')]")).click();
	CommonUtil.sleep(1000);
	CommonUtil.clicksync(modifyLicense);
	String licensedesc= "New License Modified for "+value;
	CommonUtil.clear(description1);
	CommonUtil.sendKeys(description1,licensedesc);
	CommonUtil.sleep(1000);
	CommonUtil.clicksync(submitcustomerxpath);
	if(CommonUtil.driver.findElements(By.xpath("//*[contains(text(), 'License Updated Successfully')]")).size()>0){
		msg = "The License has been modified succesfully";	
		CommonUtil.report(msg,pass);
		return true;
	}
	msg = "The License has not been modified succesfully";	
	CommonUtil.report(msg,fail);
	return false;
}

public static boolean checkmodifiedLicense(String string) {
	// TODO Auto-generated method stub
	CommonUtil.clicksync(admin);
	CommonUtil.clicksync(License);
	CommonUtil.sleep(500);
	CommonUtil.sendKeys(codeval,string);
	CommonUtil.sleep(10000);
	CommonUtil.clicksync(searchLicense);
	CommonUtil.sleep(5000);
	int flag=0;
	while(true){
		if((CommonUtil.driver.findElements(By.xpath("//div[contains(@id, 'window_close')]")).size()>0) && (flag!=40)){
			//click on >>
			CommonUtil.driver.findElement(By.xpath("//div[contains(@id, 'window_close')]")).click();
			CommonUtil.sleep(10000);
			CommonUtil.clicksync(searchLicense);
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
	
	String getTitle_License= CommonUtil.driver.getTitle();
	int flag1=0;
	while(true){
		if((!getTitle_License.contains("Modified")) && (flag1!=20)){
			//click on >>
			CommonUtil.clicksync(admin);
			CommonUtil.sleep(1000);
			CommonUtil.clicksync(admin);
			CommonUtil.sleep(1000);
			CommonUtil.clicksync(License);
			CommonUtil.sleep(500);
			CommonUtil.sendKeys(codeval,string);
			CommonUtil.sleep(10000);
			CommonUtil.clicksync(searchLicense);
			CommonUtil.sleep(5000);
			flag1=flag1+1;
			getTitle_License= CommonUtil.driver.getTitle();
		}
		else
			break;
	
	}
	getTitle_License= CommonUtil.driver.getTitle();
	if(getTitle_License.contains("Modified")){
		msg = "The License has been found and Modified succesfully";	
		CommonUtil.report(msg,pass);
		return true;
	}
	msg = "The License has not been found succesfully";	
	CommonUtil.report(msg,fail);
	return false;
}

public static boolean deleteLicense(String volumne, String value) {
	// TODO Auto-generated method stub
	CommonUtil.sendKeys(customeID, volumne);
	CommonUtil.clicksync(clickonsearch);
	CommonUtil.sleep(500);
	CommonUtil.clicksync(clickoncustid);
	CommonUtil.sleep(500);
	CommonUtil.clicksync(clickonAttribute);
	CommonUtil.sleep(500);
	CommonUtil.clicksync(clickmanageLicnese);
	CommonUtil.sleep(1000);
	CommonUtil.driver.findElement(By.xpath("//*[contains(text(), 'for "+value+"')]")).click();
	CommonUtil.sleep(1000);
	CommonUtil.clicksync(deletelicense);
	CommonUtil.sleep(1000);
	CommonUtil.clicksync(deleteok);
	CommonUtil.sleep(1000);
	if(CommonUtil.driver.findElements(By.xpath("//*[contains(text(), 'License Deleted Successfully')]")).size()>0){
		msg = "The License has been deleted succesfully";	
		CommonUtil.report(msg,pass);
		return true;
	}
	msg = "The License has not been deleted succesfully";	
	CommonUtil.report(msg,fail);
	return false;

}

public static boolean checkdeletedLicense(String string) {
	// TODO Auto-generated method stub
	CommonUtil.clicksync(admin);
	CommonUtil.clicksync(License);
	CommonUtil.sleep(500);
	CommonUtil.sendKeys(codeval, string);
	CommonUtil.sleep(10000);
	CommonUtil.clicksync(searchLicense);
	CommonUtil.sleep(5000);
	int flag=0;
	while(true){
		if((CommonUtil.driver.findElements(By.xpath("//div[contains(@id, 'window_close')]")).size()==0) && (CommonUtil.driver.findElements(By.xpath("//*[contains(text(), 'Description')]")).size()>0) && (flag!=20)){
			//click on >>
			CommonUtil.clicksync(License);
			CommonUtil.sleep(500);
			CommonUtil.sendKeys(codeval, string);
			CommonUtil.sleep(10000);
			CommonUtil.clicksync(searchLicense);
			CommonUtil.sleep(5000);
			flag=flag+1;
		}else{
//			CommonUtil.driver.findElement(By.xpath("//*[@class='v-tabsheet-scrollerNext']")).click();
			if((CommonUtil.driver.findElements(By.xpath("//div[contains(@id, 'window_close')]")).size()>0)){
				msg="The License has been deleted properly";
				
				CommonUtil.report(msg,pass);
				return true;
			}
			break;
		}
			
	}
	
	msg = "License Deletion failed";	
	CommonUtil.report(msg,fail);
	return false;
	
}

public static String createProduct() {
	// TODO Auto-generated method stub
	Random random = new Random();
	int randomNumber = random.nextInt(9000) + 1000;
	String productdata="PROD"+randomNumber;
	String productDesc="New Product Created for PROD"+randomNumber;
	CommonUtil.sendKeys(createProductID, productdata);
	CommonUtil.sleep(500);
	CommonUtil.sendKeys(productDescID, productDesc);
	CommonUtil.sleep(500);
	Select drpProducttype = new Select(CommonUtil.driver.findElement(By.id("pt1:_d_reg:region1:1:socc2::content")));
	drpProducttype.selectByIndex(1);
	CommonUtil.sleep(500);
	Select drpPubtype = new Select(CommonUtil.driver.findElement(By.id("pt1:_d_reg:region1:1:socc3::content")));
	drpPubtype.selectByIndex(1);
	CommonUtil.sleep(500);
	Select drpBackFile = new Select(CommonUtil.driver.findElement(By.id("pt1:_d_reg:region1:1:socc1::content")));
	drpBackFile.selectByIndex(1);
	CommonUtil.sleep(500);
	CommonUtil.clicksync(submitcustomerxpath);
	String message= CommonUtil.driver.findElement(By.xpath("//*[@id='pt1:_d_reg:region1:2:psl1::c']/span")).getText();
	if(message.contains("Successfully")){
		msg = "The Product has been created succesfully";	
		CommonUtil.report(msg,pass);
		return productdata;
	}
	msg = "The Product has been not been created succesfully";	
	CommonUtil.report(msg,fail);
	return null;

}

public static boolean checkProduct(String string) {
	// TODO Auto-generated method stub
	CommonUtil.clicksync(admin);
	CommonUtil.clicksync(contentslice);
	CommonUtil.sleep(500);
	CommonUtil.sendKeys(prodcodeval,string);
	CommonUtil.sleep(10000);
	CommonUtil.clicksync(searchLicense);
	CommonUtil.sleep(5000);
	int flag=0;
	while(true){
		if((CommonUtil.driver.findElements(By.xpath("//div[contains(@id, 'window_close')]")).size()>0) && (flag!=40)){
			//click on >>
			CommonUtil.driver.findElement(By.xpath("//div[contains(@id, 'window_close')]")).click();
			CommonUtil.sleep(10000);
			CommonUtil.clicksync(searchLicense);
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
	
	String getTitle_License= CommonUtil.driver.getTitle();
	
	String text[]=string.split("-");
	string= text[2];
	if(getTitle_License.contains(string)){
		msg = "The Product has been found succesfully";	
		CommonUtil.report(msg,pass);
		return true;
	}
	msg = "The Product has not been found succesfully";	
	CommonUtil.report(msg,fail);
	return false;
}

public static boolean modifyProduct(String value) {
	
	// TODO Auto-generated method stub
	CommonUtil.sendKeys(searchProd, value);
	CommonUtil.sleep(500);
	CommonUtil.clicksync(clickonsearch);
	CommonUtil.sleep(500);
	CommonUtil.clicksync(clickonprodid);
	CommonUtil.sleep(500);
	CommonUtil.clicksync(modifyproduct);
	CommonUtil.sleep(500);
	CommonUtil.clear(modProdDesc);
	CommonUtil.sleep(500);
	String modifieddata="New Product Modified for "+value;
	CommonUtil.sendKeys(modProdDesc, modifieddata);
	CommonUtil.sleep(550);
	CommonUtil.clicksync(submitcustomerxpath);
	if(CommonUtil.driver.findElements(By.xpath("//*[contains(text(), 'Product Updated Successfully')]")).size()>0){
		msg = "The Product has been modified succesfully";	
		CommonUtil.report(msg,pass);
		return true;
	}
	msg = "The Product has not been modified succesfully";	
	CommonUtil.report(msg,fail);
	return false;
}

public static boolean checkmodifiedProd(String string) {
	// TODO Auto-generated method stub
	CommonUtil.clicksync(admin);
	CommonUtil.clicksync(contentslice);
	CommonUtil.sleep(500);
	CommonUtil.sendKeys(prodcodeval,string);
	CommonUtil.sleep(10000);
	CommonUtil.clicksync(searchLicense);
	CommonUtil.sleep(5000);
	int flag=0;
	while(true){
		if((CommonUtil.driver.findElements(By.xpath("//div[contains(@id, 'window_close')]")).size()>0) && (flag!=40)){
			//click on >>
			CommonUtil.driver.findElement(By.xpath("//div[contains(@id, 'window_close')]")).click();
			CommonUtil.sleep(10000);
			CommonUtil.clicksync(searchLicense);
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
	
	String getTitle_License= CommonUtil.driver.getTitle();
	int flag1=0;
	while(true){
		if((!getTitle_License.contains("Modified")) && (flag1!=20)){
			//click on >>
			CommonUtil.clicksync(contentslice);
			CommonUtil.sleep(500);
			CommonUtil.sendKeys(prodcodeval,string);
			CommonUtil.sleep(10000);
			CommonUtil.clicksync(searchLicense);
			CommonUtil.sleep(5000);
			CommonUtil.sleep(5000);
			flag1=flag1+1;
			getTitle_License= CommonUtil.driver.getTitle();
		}
		else
			break;
	
	}
	getTitle_License= CommonUtil.driver.getTitle();
	if(getTitle_License.contains("Modified")){
		msg = "The Product has been found and Modified succesfully";	
		CommonUtil.report(msg,pass);
		return true;
	}
	msg = "The Product has not been found succesfully";	
	CommonUtil.report(msg,fail);
	return false;
}

public static boolean addContentProduct(String volumne, String license) {
	// TODO Auto-generated method stub
	CommonUtil.sendKeys(searchProd, volumne);
	CommonUtil.sleep(500);
	CommonUtil.clicksync(clickonsearch);
	CommonUtil.sleep(500);
	CommonUtil.clicksync(clickonprodid);
	CommonUtil.sleep(500);
	CommonUtil.clicksync(modifyproduct);
	CommonUtil.sleep(500);
	CommonUtil.clear(modProdDesc);
	CommonUtil.sleep(500);
	String modifieddata="New Product Modified for "+volumne;
	CommonUtil.sendKeys(modProdDesc, modifieddata);
	CommonUtil.sleep(1050);
	CommonUtil.clicksync(addContent);
	CommonUtil.sleep(1050);
	CommonUtil.sendKeys(electronicdet, license);
	CommonUtil.sleep(1050);
	CommonUtil.clicksync(contentsearch);
	CommonUtil.sleep(1050);
	CommonUtil.clicksync(selcontentrow);
	CommonUtil.sleep(1050);
	CommonUtil.clicksync(addSelectRow);
	CommonUtil.sleep(1050);
	CommonUtil.scrolldown(addSelectRow);
	CommonUtil.clicksync(addOkContent);
	CommonUtil.sleep(1050);
	CommonUtil.clicksync(submitcustomerxpath);
	if(CommonUtil.driver.findElements(By.xpath("//*[contains(text(), 'Product Updated Successfully')]")).size()>0){
		msg = "The Product has been modified succesfully with content";	
		CommonUtil.report(msg,pass);
		return true;
	}
	msg = "The Product has not been modified succesfully";	
	CommonUtil.report(msg,fail);
	return false;
}

public static boolean checkmodifiedCont(String string, String license) {
	// TODO Auto-generated method stub
	CommonUtil.clicksync(admin);
	CommonUtil.clicksync(contentslice);
	CommonUtil.sleep(500);
	CommonUtil.sendKeys(prodcodeval,string);
	CommonUtil.sleep(10000);
	CommonUtil.clicksync(searchLicense);
	CommonUtil.sleep(5000);
	int flag=0;
	while(true){
		if((CommonUtil.driver.findElements(By.xpath("//div[contains(@id, 'window_close')]")).size()>0) && (flag!=40)){
			//click on >>
			CommonUtil.driver.findElement(By.xpath("//div[contains(@id, 'window_close')]")).click();
			CommonUtil.sleep(10000);
			CommonUtil.clicksync(searchLicense);
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
	
	String getTitle_License= CommonUtil.driver.getTitle();
	int flag1=0;
	while(true){
		if((!getTitle_License.contains("Modified")) && (flag1!=20)){
			//click on >>
			CommonUtil.clicksync(contentslice);
			CommonUtil.sleep(500);
			CommonUtil.sendKeys(prodcodeval,string);
			CommonUtil.sleep(10000);
			CommonUtil.clicksync(searchLicense);
			CommonUtil.sleep(5000);
			CommonUtil.sleep(5000);
			flag1=flag1+1;
			getTitle_License= CommonUtil.driver.getTitle();
		}
		else
			break;
	
	}while(true){
		if((CommonUtil.driver.findElements(By.xpath("//*[contains(text(), '"+license+"')]")).size()==0) && (flag1!=20)){
			//click on >>
			CommonUtil.clicksync(contentslice);
			CommonUtil.sleep(500);
			CommonUtil.sendKeys(prodcodeval,string);
			CommonUtil.sleep(10000);
			CommonUtil.clicksync(searchLicense);
			CommonUtil.sleep(5000);
			CommonUtil.sleep(5000);
			CommonUtil.scrolldown(By.xpath("//*[contains(text(), 'Number of search')]"));
			flag1=flag1+1;
			//getTitle_License= CommonUtil.driver.getTitle();
		}
		else
			break;
	
	}
	//getTitle_License= CommonUtil.driver.getTitle();
	if((CommonUtil.driver.findElements(By.xpath("//*[contains(text(), '"+license+"')]")).size()>0)){
		CommonUtil.scrolldown(By.xpath("//*[contains(text(), 'Number of search')]"));
		msg = "The Product has been found and Content added succesfully";	
		CommonUtil.report(msg,pass);
		return true;
	}
	msg = "The Product has not been found succesfully";	
	CommonUtil.report(msg,fail);
	return false;
}

public static boolean deleteContentProduct(String volumne, String license) {
	// TODO Auto-generated method stub
	// TODO Auto-generated method stub
	CommonUtil.sendKeys(searchProd, volumne);
	CommonUtil.sleep(500);
	CommonUtil.clicksync(clickonsearch);
	CommonUtil.sleep(500);
	CommonUtil.clicksync(clickonprodid);
	CommonUtil.sleep(500);
	CommonUtil.clicksync(modifyproduct);
	CommonUtil.sleep(1050);
	CommonUtil.clear(modProdDesc);
	CommonUtil.sleep(1050);
	String modifieddata="New Product Content Deleted for "+volumne;
	CommonUtil.sendKeys(modProdDesc, modifieddata);
	CommonUtil.sleep(1050);
	CommonUtil.clicksync(removeContent);
	CommonUtil.sleep(1050);
	CommonUtil.sleep(2000);
	CommonUtil.clicksync(deleteOKContent);
	CommonUtil.sleep(550);
		CommonUtil.clicksync(submitcustomerxpath);
	if(CommonUtil.driver.findElements(By.xpath("//*[contains(text(), 'Product Updated Successfully')]")).size()>0){
		msg = "The Product has been modified succesfully with content";	
		CommonUtil.report(msg,pass);
		return true;
	}
	msg = "The Product has not been modified succesfully";	
	CommonUtil.report(msg,fail);
	return false;
}

public static boolean checkdeletedCont(String string, String license) {
	// TODO Auto-generated method stub
	CommonUtil.clicksync(admin);
	CommonUtil.clicksync(contentslice);
	CommonUtil.sleep(2000);
	CommonUtil.sendKeys(prodcodeval,string);
	CommonUtil.sleep(10000);
	CommonUtil.clicksync(searchLicense);
	
	
	String getTitle_License= CommonUtil.driver.getTitle();
	int flag1=0;
	while(true){
		if((!getTitle_License.contains("Deleted")) && (flag1!=20)){
			//click on >>
			CommonUtil.clicksync(contentslice);
			CommonUtil.sleep(2000);
			CommonUtil.sendKeys(prodcodeval,string);
			CommonUtil.sleep(10000);
			CommonUtil.clicksync(searchLicense);
			CommonUtil.sleep(5000);
			CommonUtil.sleep(5000);
			flag1=flag1+1;
			getTitle_License= CommonUtil.driver.getTitle();
		}
		else
			break;
	
	}

	if((CommonUtil.driver.findElements(By.xpath("//*[contains(text(), '"+license+"')]")).size()==0)){
		CommonUtil.scrolldown(By.xpath("//*[contains(text(), 'Number of search')]"));
		msg = "The Product has been found and Content deleted succesfully";	
		CommonUtil.report(msg,pass);
		return true;
	}
	msg = "The Product has not been found succesfully";	
	CommonUtil.report(msg,fail);
	return false;
}

public static void navigateToALMPage() {
	
	CommonUtil.refresh(EnvUtil.getProperty("ALM_APPLICATION_URL"));
	CommonUtil.driver.manage().deleteAllCookies();
	CommonUtil.refresh(EnvUtil.getProperty("ALM_APPLICATION_URL"));
	CommonUtil.sleep(2000);
	
}

public static boolean deleteProduct(String value) {
	// TODO Auto-generated method stub
	
	CommonUtil.sendKeys(searchProd, value);
	CommonUtil.sleep(500);
	CommonUtil.clicksync(clickonsearch);
	CommonUtil.sleep(500);
	CommonUtil.clicksync(deleteproduct);
	CommonUtil.sleep(10000);
	
	CommonUtil.clicksync(deleteOKProduct);
	CommonUtil.sleep(1000);
	if(CommonUtil.driver.findElements(By.xpath("//*[contains(text(), 'No data to display.')]")).size()>0){
		msg = "The Product has been deleted succesfully";	
		CommonUtil.report(msg,pass);
		return true;
	}
	msg = "The Product has not been deleted succesfully";	
	CommonUtil.report(msg,fail);
	return false;
}

public static boolean checkdeletedProd(String value) {
	CommonUtil.clicksync(admin);
	CommonUtil.clicksync(contentslice);
	CommonUtil.sleep(500);
	CommonUtil.sendKeys(prodcodeval,value);
	CommonUtil.sleep(10000);
	CommonUtil.clicksync(searchLicense);
	CommonUtil.sleep(5000);
	int flag=0;
	while(true){
		if((CommonUtil.driver.findElements(By.xpath("//div[contains(@id, 'window_close')]")).size()==0) && (flag!=20)){
			//click on >>
			CommonUtil.clicksync(contentslice);
			CommonUtil.sleep(500);
			CommonUtil.sendKeys(prodcodeval,value);
			CommonUtil.sleep(10000);
			CommonUtil.clicksync(searchLicense);
			CommonUtil.sleep(5000);
			flag=flag+1;
		}else{

			break;
		}
			
	}
	
	
	
	
	if(CommonUtil.driver.findElements(By.xpath("//div[contains(@id, 'window_close')]")).size()>0){
		msg = "The Product has been deleted succesfully";	
		CommonUtil.report(msg,pass);
		return true;
	}
	msg = "The Product has not been deletd succesfully";	
	CommonUtil.report(msg,fail);
	return false;
}

public static String createIP(String volumne, String license) {
	// TODO Auto-generated method stub
	CommonUtil.sendKeys(customeID, volumne);
	CommonUtil.clicksync(clickonsearch);
	CommonUtil.clicksyncALM(stateValue);
	CommonUtil.sleep(1000);
	CommonUtil.clicksync(clickoncustid);
	
	CommonUtil.clicksyncALM(stateValue);
	CommonUtil.sleep(500);
	while(true){
		if(CommonUtil.driver.findElements(By.xpath("//div[@id='pt1:_d_reg:region0:1:pc1:resId1::db']/table/tbody/tr/td[2]/span/a")).size()>0){
			System.out.println(CommonUtil.driver.findElements(By.xpath("//div[@id='pt1:_d_reg:region0:1:pc1:resId1::db']/table/tbody/tr/td[2]/span/a")).size());
			CommonUtil.clicksync(clickoncustid);
			CommonUtil.clicksyncALM(stateValue);
			CommonUtil.sleep(500);
		}
		else
			break;
			
	}
	CommonUtil.clicksync(clickonAuth);
	CommonUtil.sleep(1000);
	CommonUtil.clicksync(clickonIP);
	CommonUtil.sleep(1000);
	CommonUtil.clicksync(clickonModify);
	CommonUtil.sleep(1000);
	
	String IPdetails=null;
	
	
	CommonUtil.sleep(1000);
	if(license.equalsIgnoreCase("Modify"))
	{
		IPdetails="100.201.166.066";
		CommonUtil.clicksync(deleteIP);
		CommonUtil.sleep(1000);
		CommonUtil.clicksync(addIP);
		CommonUtil.sleep(1000);
		CommonUtil.clicksync(clickonEnterIP);
		CommonUtil.sleep(1000);
		CommonUtil.clicksync(clickonEnterIP);
		CommonUtil.sleep(1000);;
		CommonUtil.clicksync(enterIP);
		CommonUtil.sleep(1000);
		CommonUtil.clicksync(enterIP);
		CommonUtil.clear(enterIP);
		CommonUtil.sleep(1000);
		CommonUtil.clear(enterIP);
		CommonUtil.sleep(1000);
		CommonUtil.sendKeys(enterIP, IPdetails);
		CommonUtil.sleep(500);
		CommonUtil.clicksyncALM(stateValue);
		CommonUtil.sleep(2000);
		
	}
	if(license.equalsIgnoreCase("Create")){
		IPdetails="100.201.166.065";
		CommonUtil.clicksync(addIP);
		CommonUtil.sleep(1000);
		CommonUtil.clicksync(clickonEnterIP);
		CommonUtil.sleep(1000);
		CommonUtil.clicksync(clickonEnterIP);
		CommonUtil.sleep(1000);;
		CommonUtil.clicksync(enterIP);
		CommonUtil.sleep(1000);
		CommonUtil.clicksync(enterIP);
		CommonUtil.clear(enterIP);
		CommonUtil.sleep(1000);
		CommonUtil.clear(enterIP);
		CommonUtil.sleep(1000);
		CommonUtil.sendKeys(enterIP, IPdetails);
		CommonUtil.sleep(500);
		CommonUtil.clicksyncALM(stateValue);
		CommonUtil.sleep(2000);
		
	}
	if(license.equalsIgnoreCase("Delete")){
		IPdetails="100.201.166.066";
		CommonUtil.clicksync(deleteIP);
		CommonUtil.sleep(1000);
		CommonUtil.clicksyncALM(stateValue);
		CommonUtil.sleep(2000);
	}
	
	
	CommonUtil.clicksync(readyToSubmit);
	CommonUtil.sleep(500);
	CommonUtil.clicksyncALM(stateValue);
	CommonUtil.sleep(500);
	CommonUtil.click(submitcustomer);
	CommonUtil.clicksyncALM(stateValue);
	CommonUtil.sleep(2000);
	if(CommonUtil.driver.findElements(By.xpath("//*[contains(text(), 'Successfully Completed the operation.')]")).size()>0){
		if(license.equalsIgnoreCase("Create")){
			msg = "The IP has been added succesfully";
		}
		if(license.equalsIgnoreCase("Modify")){
			msg = "The IP has been Modified succesfully";
		}
		if(license.equalsIgnoreCase("Delete")){
			msg = "The IP has been Deleted succesfully";
		}
			
		CommonUtil.report(msg,pass);
		return IPdetails;
	}
	msg = "Failed to add IP";	
	CommonUtil.report(msg,fail);
	return null;
}

public static boolean checkIP(String value, String State) {
	// TODO Auto-generated method stub
	CommonUtil.clicksync(admin);
	CommonUtil.clicksync(identi);
	CommonUtil.sleep(500);
	CommonUtil.sendKeys(publicIP, value);
	CommonUtil.sleep(10000);
	CommonUtil.clicksync(search);
	CommonUtil.sleep(5000);
	int flag=0;
	while(true){
		if((CommonUtil.driver.findElements(By.xpath("//div[contains(@id, 'window_close')]")).size()>0) && (flag!=40)){
			//click on >>
			CommonUtil.driver.findElement(By.xpath("//div[contains(@id, 'window_close')]")).click();
			CommonUtil.sleep(10000);
			CommonUtil.clicksync(searchLicense);
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
	CommonUtil.sleep(1000);
	CommonUtil.clicksync(clickonImitate);
	CommonUtil.sleep(1000);
	CommonUtil.sendKeys(clickspace,"CHECK");
	CommonUtil.sleep(1000);
	CommonUtil.clicksync(checkOKContent);
	CommonUtil.sleep(5000);
	
	if(State.equalsIgnoreCase("Create")){
			
		if((CommonUtil.driver.findElements(By.xpath("//*[contains(text(), '"+value+"')]")).size()==0)){
			msg = "Imitate Failed";	
			CommonUtil.report(msg,fail);
			return false;
		}
		else{
			CommonUtil.driver.navigate().to(EnvUtil.getProperty("Literaturm_APPLICATION_URL_Journal_IP"));
			CommonUtil.sleep(10000);
			if(CommonUtil.driver.findElements(By.xpath("//*[contains(text(), 'The Internet of Things (IoT) paradigm promises to make “things”')]")).size()>0){
				//CommonUtil.scrolldown(By.xpath("//*[.='1 INTRODUCTION']"));
				msg = "The IP has been added succesfully in LIT and access is provided";	
				CommonUtil.report(msg,pass);
				return true;
		
			}
		
		}
	}
	else
	{
		if((CommonUtil.driver.findElements(By.xpath("//*[contains(text(), '"+value+"')]")).size()==0)){
			msg = "Imitate Failed";	
			CommonUtil.report(msg,fail);
			return false;
		}
		else{
			CommonUtil.driver.navigate().to(EnvUtil.getProperty("Literaturm_APPLICATION_URL_Journal_IP"));
			CommonUtil.sleep(10000);
			if(CommonUtil.driver.findElements(By.xpath("//*[contains(text(), 'The Internet of Things (IoT) paradigm promises to make “things”')]")).size()>0){
				CommonUtil.scrolldown(By.xpath("//*[.='1 INTRODUCTION']"));
				msg = "The IP has been Modified succesfully in LIT and access is provided";	
				CommonUtil.report(msg,pass);
				return true;
			
			}
			
		}
	}
	msg = "Imitate Failed";	
	
	CommonUtil.report(msg,fail);
	return false;
}

public static boolean checkDeletedIP(String value, By state) {
	// TODO Auto-generated method stub
	CommonUtil.clicksync(admin);
	CommonUtil.clicksync(identi);
	CommonUtil.sleep(500);
	CommonUtil.sendKeys(publicIP, value);
	CommonUtil.sleep(10000);
	CommonUtil.clicksync(search);
	CommonUtil.sleep(5000);
	int flag=0;
	while(true){
		if((CommonUtil.driver.findElements(By.xpath("//div[contains(@id, 'window_close')]")).size()==0) && (flag!=20)){
			//click on >>
			CommonUtil.clicksync(identi);
			CommonUtil.sleep(500);
			CommonUtil.sendKeys(publicIP, value);
			CommonUtil.sleep(10000);
			CommonUtil.clicksync(search);
			CommonUtil.sleep(5000);
			flag=flag+1;
		}else{

			break;
		}
			
	}
	if((CommonUtil.driver.findElements(By.xpath("//div[contains(@id, 'window_close')]")).size()>0)){
		msg = "The IP has been Deleted succesfully in LIT";	
		CommonUtil.report(msg,pass);
		return true;
	}
	msg = "IP has not been deleted";	
	CommonUtil.report(msg,fail);
	return false;
}

public static String createINSCustomer(String string, String value) {
	// TODO Auto-generated method stub
	Select drpCustomer = new Select(CommonUtil.driver.findElement(By.id("pt1:_d_reg:region1:1:r2:0:dtrt_dc_4061095816::content")));
	if(string.equalsIgnoreCase("Institution Login")){
		drpCustomer.selectByIndex(4);
	}
	Random random = new Random();
	int randomNumber = random.nextInt(900000) + 100000;
	
	String custdata= "INSL"+randomNumber;
	CommonUtil.sleep(2000);
	CommonUtil.sendKeys(custid, value);
	CommonUtil.sendKeys(login, custdata);
	CommonUtil.sendKeys(insPassword, "Kolkata012");
	//CommonUtil.clicksync(confirminspassword);
	CommonUtil.sendKeys(confirminspassword, "");
	CommonUtil.sleep(1000);
	CommonUtil.sendKeys(confirminspassword, "Kolkata012");
	CommonUtil.sleep(1000);
	CommonUtil.sendKeys(senddate, "11/12/25");
	
	CommonUtil.click(submitcustomer);
	CommonUtil.clicksyncALM(stateValue);
	String data=CommonUtil.driver.findElement(By.xpath("//*[@id='pt1:ptsi1']/img")).getAttribute("title");
	
	CommonUtil.sleep(2000);
	String customertype=CommonUtil.getText(custValue);
	
	if (customertype.equals(custdata))
	{
			msg = "The customer has been created succesfully";	
			CommonUtil.report(msg,pass);
			return custdata;
	}
	msg = "The customer has been not been created succesfully";	
	CommonUtil.report(msg,fail);
	return null;
	
	
}

public static boolean checkcustomerins(String string, String value, String value1) {
	// TODO Auto-generated method stub
	CommonUtil.clicksync(admin);
	CommonUtil.clicksync(identi);
	while(true){
		if(CommonUtil.driver.findElement(By.xpath("//*[.='"+string+"']")).isDisplayed() == false){
			//click on >>
			CommonUtil.driver.findElement(By.xpath("//*[@class='v-tabsheet-scrollerNext']")).click();
		}else{
			CommonUtil.driver.findElement(By.xpath("//*[@class='v-tabsheet-scrollerNext']")).click();
			break;
		}
			
	}
	CommonUtil.driver.findElement(By.xpath("//*[.='"+string+"']")).click();
	CommonUtil.sleep(2000);
	
	
	CommonUtil.sendKeys(descriptionrem, value);
	CommonUtil.sleep(2000);
	CommonUtil.clicksync(search);
	CommonUtil.sleep(4000);
	int flag=0;
	while(true){
		if((CommonUtil.driver.findElements(By.xpath("//div[contains(@id, 'window_close')]")).size()>0) && (flag!=40)){
			//click on >>
			CommonUtil.driver.findElement(By.xpath("//div[contains(@id, 'window_close')]")).click();
			CommonUtil.sleep(10000);
			CommonUtil.clicksync(search);
			flag=flag+1;
		}else{
//			CommonUtil.driver.findElement(By.xpath("//*[@class='v-tabsheet-scrollerNext']")).click();
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
	if(fetchdata.contains(value1))
	{
		msg = "The customer has been created and fetched succesfully";	
		CommonUtil.report(msg,pass);
		//CommonUtil.driver.findElement(By.xpath("//*[@class='v-menubar v-widget user-account-menu v-menubar-user-account-menu']")).click();
		//CommonUtil.driver.findElement(By.xpath("//*[@class='v-menubar-submenu v-widget user-account-menu v-menubar-submenu-user-account-menu']")).click();
		//CommonUtil.driver.findElement(By.xpath("//*[@class='v-slot v-align-center v-align-middle']/div/div")).click();
		return true;
	}
	
	//$('#gwt-uid-52').value
	
	
	
	
	msg = "The customer has been not been created properly";	
	CommonUtil.report(msg,fail);
	return false;
}

public static String createRegional(String volumne, String license) {
	// TODO Auto-generated method stub
	CommonUtil.sendKeys(customeID, volumne);
	CommonUtil.clicksync(clickonsearch);
	CommonUtil.clicksyncALM(stateValue);
	CommonUtil.sleep(500);
	CommonUtil.clicksync(clickoncustid);
	
	CommonUtil.clicksyncALM(stateValue);
	CommonUtil.sleep(500);
	while(true){
		if(CommonUtil.driver.findElements(By.id("pt1:_d_reg:region0:1:pc1:resId1:0:ot9")).size()>0){
			System.out.println(CommonUtil.driver.findElements(By.id("pt1:_d_reg:region0:1:pc1:resId1:0:ot9")).size());
			CommonUtil.clicksync(clickoncustid);
			CommonUtil.clicksyncALM(stateValue);
			CommonUtil.sleep(500);
		}
		else
			break;
			
	}
	CommonUtil.clicksync(clickonAuth);
	CommonUtil.clicksyncALM(stateValue);
	CommonUtil.sleep(500);
	CommonUtil.clicksync(clickonReg);
	CommonUtil.clicksyncALM(stateValue);
	CommonUtil.sleep(500);
	CommonUtil.clicksync(clickonModify);
	CommonUtil.clicksyncALM(stateValue);
	CommonUtil.sleep(500);
	
	String IPdetails=null;
	
	
	CommonUtil.sleep(1000);
	if(license.equalsIgnoreCase("Modify"))
	{
		
		Select drpState = new Select(CommonUtil.driver.findElement(By.id("pt1:_d_reg:region2:1:r2:0:_xgc_2:_xgtb_0:0:_xgc_11::content")));
		drpState.selectByIndex(2);
		
		CommonUtil.clicksyncALM(stateValue);
		CommonUtil.sleep(500);
		
	}
	if(license.equalsIgnoreCase("Create")){
		
		CommonUtil.clicksync(addIP);
		CommonUtil.sleep(1000);
		Select drpCustomer = new Select(CommonUtil.driver.findElement(By.id("pt1:_d_reg:region2:1:r2:0:_xgc_2:_xgtb_0:0:_xgc_9::content")));
		drpCustomer.selectByIndex(230);
		CommonUtil.sleep(3000);
		Select drpState = new Select(CommonUtil.driver.findElement(By.id("pt1:_d_reg:region2:1:r2:0:_xgc_2:_xgtb_0:0:_xgc_11::content")));
		drpState.selectByIndex(1);
		CommonUtil.clicksyncALM(stateValue);
		CommonUtil.sleep(500);
		
	}
	if(license.equalsIgnoreCase("Delete")){
		
		CommonUtil.clicksync(deleteIP);
		CommonUtil.sleep(1000);
		CommonUtil.clicksyncALM(stateValue);
		CommonUtil.sleep(500);
	}
	
	
	CommonUtil.clicksync(readyToSubmit);
	CommonUtil.sleep(500);
	CommonUtil.clicksyncALM(stateValue);
	CommonUtil.sleep(500);
	CommonUtil.click(submitcustomer);
	CommonUtil.clicksyncALM(stateValue);
	if(CommonUtil.driver.findElements(By.xpath("//*[contains(text(), 'Successfully Completed the operation.')]")).size()>0){
		if(license.equalsIgnoreCase("Create")){
			msg = "The IP has been added succesfully";
			String value= "India";
			CommonUtil.report(msg,pass);
			return value;
		}
		if(license.equalsIgnoreCase("Modify")){
			msg = "The IP has been Modified succesfully";
			String value= "Israel";
			CommonUtil.report(msg,pass);
			return value;
		}
		if(license.equalsIgnoreCase("Delete")){
			msg = "The IP has been Deleted succesfully";
			String value= "Israel";
			CommonUtil.report(msg,pass);
			return value;
		}
			
		
		
	}
	msg = "Failed to add IP";	
	CommonUtil.report(msg,fail);
	return null;
}

public static boolean checkRegional(String value, String string) {
	// TODO Auto-generated method stub
	CommonUtil.clicksync(admin);
	CommonUtil.clicksync(identi);
	CommonUtil.sleep(500);
	CommonUtil.sendKeys(publicval, value);
	
	CommonUtil.sleep(10000);
	CommonUtil.clicksync(search);
	CommonUtil.sleep(5000);
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
	CommonUtil.sleep(1000);
	while(true){
		if(CommonUtil.driver.findElement(By.xpath("//*[.='Members']")).isDisplayed() == false){
			//click on >>
			CommonUtil.driver.findElement(By.xpath("//*[@class='v-tabsheet-scrollerNext']")).click();
		}else{
			CommonUtil.driver.findElement(By.xpath("//*[@class='v-tabsheet-scrollerNext']")).click();
			break;
		}
			
	}
	//CommonUtil.sleep(15000);
	CommonUtil.driver.findElement(By.xpath("//*[.='Members']")).click();
	//CommonUtil.clicksync(clickonMembers);
	
	flag=0;
	if(string.equalsIgnoreCase("Create")){
		while(true){
		if((CommonUtil.driver.findElements(By.xpath("//*[contains(text(), 'United States - Alabama')]")).size()==0) && flag!=20){
			
			CommonUtil.clicksync(identi);
			CommonUtil.sleep(500);
			CommonUtil.sendKeys(publicval, value);
			
			CommonUtil.sleep(10000);
			CommonUtil.clicksync(search);
			CommonUtil.sleep(5000);
			CommonUtil.sleep(1000);
			while(true){
				if(CommonUtil.driver.findElement(By.xpath("//*[.='Members']")).isDisplayed() == false){
					//click on >>
					CommonUtil.driver.findElement(By.xpath("//*[@class='v-tabsheet-scrollerNext']")).click();
				}else{
					CommonUtil.driver.findElement(By.xpath("//*[@class='v-tabsheet-scrollerNext']")).click();
					break;
				}
					
			}
			//CommonUtil.sleep(15000);
			CommonUtil.driver.findElement(By.xpath("//*[.='Members']")).click();
			flag=flag+1;
			
		}
		else
			break;
		}
		
		if((CommonUtil.driver.findElements(By.xpath("//*[contains(text(), 'United States - Alabama')]")).size()==0)){
			msg = "The Regional provison ahs not been created in LIT";	
			CommonUtil.report(msg,fail);
			return false;
		}
		else{
				
				msg = "The Regional Provision has been added succesfully in LIT";	
				CommonUtil.report(msg,pass);
//				CommonUtil.driver.findElement(By.xpath("//*[@class='v-menubar v-widget user-account-menu v-menubar-user-account-menu']")).click();
//				CommonUtil.driver.findElement(By.xpath("//*[@class='v-menubar-submenu v-widget user-account-menu v-menubar-submenu-user-account-menu']")).click();
//				CommonUtil.driver.findElement(By.xpath("//*[@class='v-slot v-align-center v-align-middle'][2]")).click();
				return true;
		
			}
		
		
	}
	if(string.equalsIgnoreCase("Modify"))
	{
		while(true){
		if((CommonUtil.driver.findElements(By.xpath("//*[contains(text(), 'United States - Alaska')]")).size()==0) && flag!=20){
			
			CommonUtil.clicksync(identi);
			CommonUtil.sleep(500);
			CommonUtil.sendKeys(publicval, value);
			
			CommonUtil.sleep(10000);
			CommonUtil.clicksync(search);
			CommonUtil.sleep(5000);
			CommonUtil.sleep(1000);
			while(true){
				if(CommonUtil.driver.findElement(By.xpath("//*[.='Members']")).isDisplayed() == false){
					//click on >>
					CommonUtil.driver.findElement(By.xpath("//*[@class='v-tabsheet-scrollerNext']")).click();
				}else{
					CommonUtil.driver.findElement(By.xpath("//*[@class='v-tabsheet-scrollerNext']")).click();
					break;
				}
					
			}
			//CommonUtil.sleep(15000);
			CommonUtil.driver.findElement(By.xpath("//*[.='Members']")).click();
			
			flag=flag+1;
		}
		else
			break;
		}
		
		if((CommonUtil.driver.findElements(By.xpath("//*[contains(text(), 'United States - Alaska')]")).size()==0)){
			msg = "The Regional provison has not been modified in LIT";	
			CommonUtil.report(msg,fail);
			return false;
		}
		else{
			
				msg = "The Regional Provision has been Modified succesfully in LIT";	
				CommonUtil.report(msg,pass);
//				CommonUtil.driver.findElement(By.xpath("//*[@class='v-menubar v-widget user-account-menu v-menubar-user-account-menu']")).click();
//				CommonUtil.driver.findElement(By.xpath("//*[@class='v-menubar-submenu v-widget user-account-menu v-menubar-submenu-user-account-menu']")).click();
//				CommonUtil.driver.findElement(By.xpath("//*[@class='v-slot v-align-center v-align-middle'][2]")).click();
				return true;
			
			}
			
		
	}
	if(string.equalsIgnoreCase("Delete")){
		while(true){
		if((CommonUtil.driver.findElements(By.xpath("//*[contains(text(), 'United States - Alaska')]")).size()>0) && flag!=20){
			
			CommonUtil.clicksync(identi);
			CommonUtil.sleep(500);
			CommonUtil.sendKeys(publicval, value);
			
			CommonUtil.sleep(10000);
			CommonUtil.clicksync(search);
			CommonUtil.sleep(5000);
			CommonUtil.sleep(1000);
			while(true){
				if(CommonUtil.driver.findElement(By.xpath("//*[.='Members']")).isDisplayed() == false){
					//click on >>
					CommonUtil.driver.findElement(By.xpath("//*[@class='v-tabsheet-scrollerNext']")).click();
				}else{
					CommonUtil.driver.findElement(By.xpath("//*[@class='v-tabsheet-scrollerNext']")).click();
					break;
				}
					
			}
			//CommonUtil.sleep(15000);
			CommonUtil.driver.findElement(By.xpath("//*[.='Members']")).click();
			
			flag=flag+1;
		}
		else
			break;
		}

		if((CommonUtil.driver.findElements(By.xpath("//*[contains(text(), 'United States - Alaska')]")).size()==0)){
			msg = "The Regional provison has been deleted in LIT";	
			CommonUtil.report(msg,pass);
			return true;
		}
		else{
			
				msg = "The Regional Provision has been deleted succesfully in LIT";	
				CommonUtil.report(msg,fail);
				return false;
		
			}
		
		
	}
	msg = "The Regional provison has not been modified in LIT";	
	CommonUtil.report(msg,fail);
	return false;
}


public static boolean searchLicense(String licenseID) {
	if(CommonUtil.driver.findElements(LicenseID_id_search).size() > 0){
		CommonUtil.sendKeys(LicenseID_id_search, licenseID);
		CommonUtil.click(searchLicenseButton);
		CommonUtil.clicksyncALM(stateValue);
		msg = "License search successful in LIT";	
		CommonUtil.report(msg,pass);
		return true;
	}
	return false;
}

public static boolean createAffil(String volumne, String license) {
	// TODO Auto-generated method stub
	CommonUtil.sendKeys(customeID, volumne);
	CommonUtil.clicksync(clickonsearch);
	CommonUtil.sleep(500);
	CommonUtil.clicksync(clickoncustid);
	CommonUtil.sleep(500);
	CommonUtil.clicksync(clickonAttribute);
	CommonUtil.sleep(500);
	CommonUtil.clicksync(clickonView);
	CommonUtil.sleep(1000);
	CommonUtil.clicksync(clickonModUser);
	CommonUtil.sleep(1000);
	CommonUtil.clicksync(addEmail);
	CommonUtil.sleep(1000);
	CommonUtil.clicksync(clickonEnterEmail);
	CommonUtil.sleep(1000);
	CommonUtil.clicksync(clickonEnterEmail);
	CommonUtil.sleep(1000);;
	CommonUtil.clicksync(enterEmail);
	CommonUtil.sleep(1000);
	CommonUtil.clicksync(enterEmail);
	CommonUtil.clear(enterEmail);
	CommonUtil.sleep(1000);
	CommonUtil.sendKeys(enterEmail, "");
	CommonUtil.sleep(500);
	CommonUtil.sleep(2000);
	CommonUtil.sendKeys(enterEmail, license);
	CommonUtil.sleep(2000);
	CommonUtil.clicksyncALM(stateValue);
	CommonUtil.sleep(2000);
	Select drpLinkType = new Select(CommonUtil.driver.findElement(By.id("pt1:_d_reg:region3:1:r2:0:_xgc_2:_xgtb_0:1:_xgc_21::content")));
	drpLinkType.selectByIndex(1);
	CommonUtil.sleep(2000);
	CommonUtil.clicksyncALM(stateValue);
	CommonUtil.sleep(500);
	CommonUtil.clicksync(readyToSubmitemail);
	CommonUtil.sleep(500);
	CommonUtil.clicksyncALM(stateValue);
	CommonUtil.sleep(500);
	CommonUtil.click(submitcustomer);
	CommonUtil.clicksyncALM(stateValue);
	if(CommonUtil.driver.findElements(By.xpath("//*[contains(text(), 'Successfully Completed the operation.')]")).size()>0){
	
			msg = "The affiliation has been added succesfully";
			CommonUtil.report(msg,pass);
			return true;
	}
	msg = "affiliation has not been added";	
	CommonUtil.report(msg,fail);
	return false;
}

public static boolean checkAffil(String string, String license) {
	// TODO Auto-generated method stub
	CommonUtil.clicksync(admin);
	CommonUtil.clicksync(identi);
	CommonUtil.sleep(500);
	while(true){
		if(CommonUtil.driver.findElement(By.xpath("//*[.='"+string+"']")).isDisplayed() == false){
			//click on >>
			CommonUtil.driver.findElement(By.xpath("//*[@class='v-tabsheet-scrollerNext']")).click();
		}else{
			CommonUtil.driver.findElement(By.xpath("//*[@class='v-tabsheet-scrollerNext']")).click();
			break;
		}
			
	}
	CommonUtil.driver.findElement(By.xpath("//*[.='"+string+"']")).click();
	
	CommonUtil.sendKeys(sendEmail, license);
	CommonUtil.sleep(500);
	CommonUtil.clicksync(search);
	CommonUtil.sleep(5000);
	while(true){
		if(CommonUtil.driver.findElement(By.xpath("//*[.='Tokens']")).isDisplayed() == false){
			//click on >>
			CommonUtil.driver.findElement(By.xpath("//*[@class='v-tabsheet-scrollerNext']")).click();
		}else{
			CommonUtil.driver.findElement(By.xpath("//*[@class='v-tabsheet-scrollerNext']")).click();
			break;
		}
			
	}
	
	CommonUtil.driver.findElement(By.xpath("//*[.='Tokens']")).click();
	int flag=0;
	while(true){
	if((CommonUtil.driver.findElements(By.xpath("//*[contains(text(), 'INST00005')]")).size()==0) && flag!=20){
		
		CommonUtil.clicksync(identi);
		CommonUtil.sleep(10000);
		while(true){
			if(CommonUtil.driver.findElement(By.xpath("//*[.='"+string+"']")).isDisplayed() == false){
				//click on >>
				CommonUtil.driver.findElement(By.xpath("//*[@class='v-tabsheet-scrollerNext']")).click();
			}else{
				CommonUtil.driver.findElement(By.xpath("//*[@class='v-tabsheet-scrollerNext']")).click();
				break;
			}
				
		}
		CommonUtil.driver.findElement(By.xpath("//*[.='"+string+"']")).click();
		
		CommonUtil.sendKeys(sendEmail, license);
		CommonUtil.sleep(10000);
		CommonUtil.clicksync(search);
		CommonUtil.sleep(1000);
		while(true){
			if(CommonUtil.driver.findElement(By.xpath("//*[.='Tokens']")).isDisplayed() == false){
				//click on >>
				CommonUtil.driver.findElement(By.xpath("//*[@class='v-tabsheet-scrollerNext']")).click();
			}else{
				CommonUtil.driver.findElement(By.xpath("//*[@class='v-tabsheet-scrollerNext']")).click();
				break;
			}
				
		}
		
		CommonUtil.driver.findElement(By.xpath("//*[.='Tokens']")).click();
		flag=flag+1;
	}
	else
		break;
	}
	if((CommonUtil.driver.findElements(By.xpath("//*[contains(text(), 'INST00005')]")).size()>0))
	{
		msg = "The affiliation has been added succesfully to LIT";
		
		CommonUtil.report(msg,pass);
//		CommonUtil.driver.findElement(By.xpath("//*[@class='v-menubar v-widget user-account-menu v-menubar-user-account-menu']")).click();
//		CommonUtil.driver.findElement(By.xpath("//*[@class='v-menubar-submenu v-widget user-account-menu v-menubar-submenu-user-account-menu']")).click();
//		CommonUtil.driver.findElement(By.xpath("//*[@class='v-slot v-align-center v-align-middle']/div/div")).click();
		return true;
}
msg = "affiliation has not been added to LIT";	
CommonUtil.report(msg,fail);
return false;
}

public static boolean deleteAffil(String volumne, String license) {
	// TODO Auto-generated method stub
	CommonUtil.sendKeys(customeID, volumne);
	CommonUtil.clicksync(clickonsearch);
	CommonUtil.sleep(5000);
	CommonUtil.clicksync(clickoncustid);
	CommonUtil.sleep(500);
	CommonUtil.clicksync(clickonView);
	CommonUtil.sleep(2000);
	CommonUtil.clicksync(clickonModUser);
	CommonUtil.sleep(4000);
	CommonUtil.clicksync(deleteEmail);
	CommonUtil.sleep(1000);
	
	CommonUtil.clicksyncALM(stateValue);
	CommonUtil.sleep(500);
	CommonUtil.clicksync(readyToSubmitemail);
	CommonUtil.sleep(500);
	CommonUtil.clicksyncALM(stateValue);
	CommonUtil.sleep(500);
	CommonUtil.click(submitcustomer);
	CommonUtil.clicksyncALM(stateValue);
	if(CommonUtil.driver.findElements(By.xpath("//*[contains(text(), 'Successfully Completed the operation.')]")).size()>0){
	
			msg = "Affiliation deleted succesfully";
			CommonUtil.report(msg,pass);
			return true;
	}
	msg = "Affiliation has not been deleted";	
	CommonUtil.report(msg,fail);
	return false;

}

public static String getLicenseTokenCount(String license) {
	if(CommonUtil.driver.findElements(LicenseID_token_count).size() > 0){
		CommonUtil.click(By.partialLinkText(license));
		CommonUtil.sleep(5000);
		
		return CommonUtil.getText(By.id("pt1:_d_reg:region1:1:ot10"));
	}
	return null;
}

public static boolean searchUser(String user, String string) {
	// TODO Auto-generated method stub
	CommonUtil.clicksync(admin);
    CommonUtil.clicksync(identi);
    CommonUtil.sleep(500);
    while(true){
           if(CommonUtil.driver.findElement(By.xpath("//*[.='"+string+"']")).isDisplayed() == false){
                  //click on >>
                  CommonUtil.driver.findElement(By.xpath("//*[@class='v-tabsheet-scrollerNext']")).click();
           }else{
                  CommonUtil.driver.findElement(By.xpath("//*[@class='v-tabsheet-scrollerNext']")).click();
                  break;
           }
                  
    }
    CommonUtil.driver.findElement(By.xpath("//*[.='"+string+"']")).click();
    
    CommonUtil.sendKeys(sendEmail, user);
    CommonUtil.sleep(500);
    CommonUtil.clicksync(search);
    CommonUtil.sleep(5000);
    
    if(CommonUtil.isElementPresent(clickonImitate)){
    	CommonUtil.scrolltoview(clickonImitate);
    	CommonUtil.sleep(2000);
    	msg = "User search Result successful in LIT";	
    	CommonUtil.report(msg,pass);
    	return true;
    }
    msg = "User search Result not successful in LIT";	
	CommonUtil.report(msg,fail);
	return false;
}

public static boolean ImitateAction(String user) {
	// TODO Auto-generated method stub
	CommonUtil.clicksync(clickonImitate);
	CommonUtil.sleep(1000);
	CommonUtil.sendKeys(clickspace,"CHECK");
	CommonUtil.sleep(1000);
	CommonUtil.clicksync(checkOKContent);
	CommonUtil.sleep(5000);
	/*if(CommonUtil.driver.findElements(By.xpath("//table[@class='showIdentities']//td[.='"+user.toUpperCase()+"']")).size() > 0){
		msg = "Imitate successful in LIT";	
    	CommonUtil.report(msg,pass);
		return true;
	}
	msg = "Imitate unsuccessful in LIT";	
	CommonUtil.report(msg,fail);
	return false;*/
	return true;
}

public static boolean burnTokenToAccessContent(String contentDOI) {
	
	return false;
}

public static void navigateToWOLPage() {
	// TODO Auto-generated method stub
	CommonUtil.refresh(EnvUtil.getProperty("WOL_APPLICATION_URL"));
	CommonUtil.sleep(2000);
}

public static String getWOLLicenseTokenCount() {
	// TODO Auto-generated method stub
	CommonUtil.clicksync(By.linkText("Article Select Tokens"));
	msg = "Token count fetched in WOL";	
	CommonUtil.report(msg,pass);
	return CommonUtil.getText(By.id("currentTokenBalance"));
}

public static boolean searchLicenseLIT(String licenseID) {
	// TODO Auto-generated method stub
	CommonUtil.clicksync(admin);
	CommonUtil.sleep(2000);
    CommonUtil.clicksync(license);
    CommonUtil.sleep(2000);
   
    CommonUtil.sendKeys(codeval, "ALM-LID-"+licenseID);
    CommonUtil.sleep(500);
    CommonUtil.clicksync(searchLicense);
    CommonUtil.sleep(5000);
    CommonUtil.click(By.xpath("//*[.='Metrics']"));
    CommonUtil.sleep(5000);
    msg = "License -> Metrics opens in LIT";	
	CommonUtil.report(msg,pass);
	return true;
}

public static String getLicenseTokenCountLIT() {
	// TODO Auto-generated method stub
	String CountString = CommonUtil.getAttributeValue(By.xpath("//*[@class='v-formlayout-row'][2]//input"), "value");
	return CountString.split(" of ")[0];
}

public static String getLicenseTokenCountAfterBurn(String licenseID, String token, String ALM_Username, String ALM_Password) {
	int count = 0;
	if(CommonUtil.driver.findElements(LicenseID_token_count).size() > 0){
		while(true){
			CommonUtil.click(By.linkText(licenseID));
			CommonUtil.sleep(5000);
			if(Integer.parseInt(CommonUtil.getText(By.id("pt1:_d_reg:region1:1:ot10"))) == Integer.parseInt(token)-1){
				msg = "Token burned in ALM";	
				CommonUtil.report(msg,pass);
				return CommonUtil.getText(By.id("pt1:_d_reg:region1:1:ot10"));
			}else{
				if(count > 15)
					break;
				CommonUtil.sleep(10000);
				CommonUtil.refresh(EnvUtil.getProperty("ALM_APPLICATION_URL"));
				LoginPage.LoginALM(ALM_Username, ALM_Password);
				clickOnLinkSync("Licenses");
		    	searchLicense(licenseID);
		    	count++;
			}
		}
		
	}
	msg = "Token not burned in ALM";	
	CommonUtil.report(msg,fail);
	return null;
}

public static boolean searchIPAddress(String user, String string) {
	// TODO Auto-generated method stub
	CommonUtil.clicksync(admin);
    CommonUtil.clicksync(identi);
    CommonUtil.sleep(500);
    while(true){
           if(CommonUtil.driver.findElement(By.xpath("//*[.='"+string+"']")).isDisplayed() == false){
                  //click on >>
                  CommonUtil.driver.findElement(By.xpath("//*[@class='v-tabsheet-scrollerNext']")).click();
           }else{
                  CommonUtil.driver.findElement(By.xpath("//*[@class='v-tabsheet-scrollerNext']")).click();
                  break;
           }
                  
    }
    CommonUtil.driver.findElement(By.xpath("//*[.='"+string+"']")).click();
    
    CommonUtil.sendKeys(sendIP, user);
    CommonUtil.sleep(500);
    CommonUtil.clicksync(search);
    CommonUtil.sleep(5000);
    
    if(CommonUtil.isElementPresent(clickonImitate)){
    	CommonUtil.scrolltoview(clickonImitate);
    	CommonUtil.sleep(2000);
    	msg = "User search Result successful in LIT";	
    	CommonUtil.report(msg,pass);
    	return true;
    }
    msg = "User search Result not successful in LIT";	
	CommonUtil.report(msg,fail);
	return false;
}

public static boolean searchRemote(String user, String string) {
	CommonUtil.clicksync(admin);
    CommonUtil.clicksync(identi);
    CommonUtil.sleep(500);
    while(true){
           if(CommonUtil.driver.findElement(By.xpath("//*[.='"+string+"']")).isDisplayed() == false){
                  //click on >>
                  CommonUtil.driver.findElement(By.xpath("//*[@class='v-tabsheet-scrollerNext']")).click();
           }else{
                  CommonUtil.driver.findElement(By.xpath("//*[@class='v-tabsheet-scrollerNext']")).click();
                  break;
           }
                  
    }
    CommonUtil.driver.findElement(By.xpath("//*[.='"+string+"']")).click();
    
    CommonUtil.sendKeys(sendIP, user);
    CommonUtil.sleep(500);
    CommonUtil.clicksync(search);
    CommonUtil.sleep(5000);
    
    if(CommonUtil.isElementPresent(clickonImitate)){
    	CommonUtil.scrolltoview(clickonImitate);
    	CommonUtil.sleep(2000);
    	msg = "User search Result successful in LIT";	
    	CommonUtil.report(msg,pass);
    	return true;
    }
    msg = "User search Result not successful in LIT";	
	CommonUtil.report(msg,fail);
	return false;
}

public static boolean burnTokenToAccessContent_NoPolicy(String contentDOI) {
	
	return false;
}

public static boolean checkdelAffil(String string, String license) {
	// TODO Auto-generated method stub
	CommonUtil.clicksync(admin);
	CommonUtil.clicksync(identi);
	CommonUtil.sleep(500);
	while(true){
		if(CommonUtil.driver.findElement(By.xpath("//*[.='"+string+"']")).isDisplayed() == false){
			//click on >>
			CommonUtil.driver.findElement(By.xpath("//*[@class='v-tabsheet-scrollerNext']")).click();
		}else{
			CommonUtil.driver.findElement(By.xpath("//*[@class='v-tabsheet-scrollerNext']")).click();
			break;
		}
			
	}
	CommonUtil.driver.findElement(By.xpath("//*[.='"+string+"']")).click();
	
	CommonUtil.sendKeys(sendEmail, license);
	CommonUtil.sleep(500);
	CommonUtil.clicksync(search);
	CommonUtil.sleep(5000);
	while(true){
		if(CommonUtil.driver.findElement(By.xpath("//*[.='Tokens']")).isDisplayed() == false){
			//click on >>
			CommonUtil.driver.findElement(By.xpath("//*[@class='v-tabsheet-scrollerNext']")).click();
		}else{
			CommonUtil.driver.findElement(By.xpath("//*[@class='v-tabsheet-scrollerNext']")).click();
			break;
		}
			
	}
	
	CommonUtil.driver.findElement(By.xpath("//*[.='Tokens']")).click();
	int flag=0;
	while(true){
	if((CommonUtil.driver.findElements(By.xpath("//*[contains(text(), 'INST00005')]")).size()>0) && flag!=20){
		
		CommonUtil.clicksync(identi);
		CommonUtil.sleep(10000);
		while(true){
			if(CommonUtil.driver.findElement(By.xpath("//*[.='"+string+"']")).isDisplayed() == false){
				//click on >>
				CommonUtil.driver.findElement(By.xpath("//*[@class='v-tabsheet-scrollerNext']")).click();
			}else{
				CommonUtil.driver.findElement(By.xpath("//*[@class='v-tabsheet-scrollerNext']")).click();
				break;
			}
				
		}
		CommonUtil.driver.findElement(By.xpath("//*[.='"+string+"']")).click();
		
		CommonUtil.sendKeys(sendEmail, license);
		CommonUtil.sleep(10000);
		CommonUtil.clicksync(search);
		CommonUtil.sleep(1000);
		while(true){
			if(CommonUtil.driver.findElement(By.xpath("//*[.='Tokens']")).isDisplayed() == false){
				//click on >>
				CommonUtil.driver.findElement(By.xpath("//*[@class='v-tabsheet-scrollerNext']")).click();
			}else{
				CommonUtil.driver.findElement(By.xpath("//*[@class='v-tabsheet-scrollerNext']")).click();
				break;
			}
				
		}
		
		CommonUtil.driver.findElement(By.xpath("//*[.='Tokens']")).click();
		flag=flag+1;
	}
	else
		break;
	}
	if((CommonUtil.driver.findElements(By.xpath("//*[contains(text(), 'INST00005')]")).size()==0))
	{
		msg = "The affiliation has been deleted succesfully to LIT";
		
		CommonUtil.report(msg,pass);
		return true;
}
msg = "affiliation has not been deleted to LIT";	
CommonUtil.report(msg,fail);
return false;
}

public static boolean modifyInsl(String instLogin, String value) {
	// TODO Auto-generated method stub
	CommonUtil.sendKeys(customeID, value);
	CommonUtil.clicksync(clickonsearch);
	CommonUtil.sleep(500);
	String valuepath=CommonUtil.driver.findElement(By.xpath("//*[@id='pt1:_d_reg:region0:1:pc1:resId1::db']/table/tbody/tr[1]/td[1]")).getText();
	if(valuepath.contains(instLogin)){
		CommonUtil.driver.findElement(By.id("pt1:_d_reg:region0:1:pc1:resId1:0:ot9")).click();
		
	}
	else
	{
		CommonUtil.driver.findElement(By.id("pt1:_d_reg:region0:1:pc1:resId1:1:ot9")).click();
	}
	//CommonUtil.clicksync(valuepath);
	CommonUtil.sleep(500);
	CommonUtil.clicksync(clickmodify);
	CommonUtil.sleep(500);
	CommonUtil.sleep(1000);
	CommonUtil.clear(sendmoddate);
	CommonUtil.sleep(500);
	CommonUtil.sendKeys(sendmoddate, "11/11/30");
	
	
	
	
	//CommonUtil.click(By.id("pt1:_d_reg:region2:1:r2:0:dtrt_dc_3785338307::glyph"));
	
	CommonUtil.sleep(2000);
	
	CommonUtil.clicksync(submitcustomer);
//	CommonUtil.sleep(1000);
//	CommonUtil.clicksync(submitcustomer);
	CommonUtil.clicksyncALM(stateValue);
	if(CommonUtil.driver.findElements(By.xpath("//*[contains(text(), 'Successfully Completed the operation.')]")).size()>0){
		
		msg = "Modified institutional login succesfully";
		CommonUtil.report(msg,pass);
		return true;
	}
	msg = "Modification failed for institutional login";	
	CommonUtil.report(msg,fail);
	return false;
}

public static boolean checkmodcustomerins(String string, String instLogin, String value) {
	CommonUtil.clicksync(admin);
	CommonUtil.clicksync(identi);
	while(true){
		if(CommonUtil.driver.findElement(By.xpath("//*[.='"+string+"']")).isDisplayed() == false){
			//click on >>
			CommonUtil.driver.findElement(By.xpath("//*[@class='v-tabsheet-scrollerNext']")).click();
		}else{
			CommonUtil.driver.findElement(By.xpath("//*[@class='v-tabsheet-scrollerNext']")).click();
			break;
		}
			
	}
	CommonUtil.driver.findElement(By.xpath("//*[.='"+string+"']")).click();
	CommonUtil.sleep(2000);
	
	
	CommonUtil.sendKeys(descriptionrem, instLogin);
	CommonUtil.sleep(2000);
	CommonUtil.clicksync(search);
	CommonUtil.sleep(10000);
	int flag=0;
	
	CommonUtil.sleep(2000);
	
	String getdata=CommonUtil.driver.findElement(By.xpath("//*[contains(text(),'Expires')]/../../../td[3]//input")).getAttribute("value");;
	while(true){
	if((!getdata.equals("2030-11-10"))&& flag!=20){
		//CommonUtil.clicksync(admin);
		CommonUtil.clicksync(identi);
		CommonUtil.sleep(2000);
		while(true){
			if(CommonUtil.driver.findElement(By.xpath("//*[.='"+string+"']")).isDisplayed() == false){
				//click on >>
				CommonUtil.driver.findElement(By.xpath("//*[@class='v-tabsheet-scrollerNext']")).click();
			}else{
				CommonUtil.driver.findElement(By.xpath("//*[@class='v-tabsheet-scrollerNext']")).click();
				break;
			}
				
		}
		CommonUtil.driver.findElement(By.xpath("//*[.='"+string+"']")).click();
		CommonUtil.sleep(2000);
		
		
		CommonUtil.sendKeys(descriptionrem, instLogin);
		CommonUtil.sleep(2000);
		CommonUtil.clicksync(search);
		CommonUtil.sleep(10000);
		getdata=CommonUtil.driver.findElement(By.xpath("//*[contains(text(),'Expires')]/../../../td[3]//input")).getAttribute("value");
		flag=flag+1;
		
	}
	else
	{
		break;
		
	}
	
	getdata=CommonUtil.driver.findElement(By.xpath("//*[contains(text(),'Expires')]/../../../td[3]//input")).getAttribute("value");
	flag=flag+1;
}
	
	
	if(getdata.equals("2030-11-10"))
	{
		msg = "The customer Expires date has been modified and fetched succesfully";	
		CommonUtil.report(msg,pass);
		//CommonUtil.driver.findElement(By.xpath("//*[@class='v-menubar v-widget user-account-menu v-menubar-user-account-menu']")).click();
		//CommonUtil.driver.findElement(By.xpath("//*[@class='v-menubar-submenu v-widget user-account-menu v-menubar-submenu-user-account-menu']")).click();
		//CommonUtil.driver.findElement(By.xpath("//*[@class='v-slot v-align-center v-align-middle']/div/div")).click();
		return true;
	}
	
	//$('#gwt-uid-52').value
	
	
	
	
	msg = "The customer has been not been modified properly";	
	CommonUtil.report(msg,fail);
	return false;
}

public static boolean deleteInsl(String instLogin, String value) {
	// TODO Auto-generated method stub
		CommonUtil.sendKeys(customeID, value);
		CommonUtil.clicksync(clickonsearch);
		CommonUtil.sleep(500);
		String valuepath=CommonUtil.driver.findElement(By.xpath("//*[@id='pt1:_d_reg:region0:1:pc1:resId1::db']/table/tbody/tr[1]/td[1]")).getText();
		if(valuepath.contains(instLogin)){
			CommonUtil.driver.findElement(By.id("pt1:_d_reg:region0:1:pc1:resId1:0:ot9")).click();
			
		}
		else
		{
			CommonUtil.driver.findElement(By.id("pt1:_d_reg:region0:1:pc1:resId1:1:ot9")).click();
		}
		//CommonUtil.clicksync(valuepath);
		CommonUtil.sleep(500);
		CommonUtil.clicksync(clickdelete);
		CommonUtil.sleep(1000);
		CommonUtil.click(submitcustomer);
		CommonUtil.clicksyncALM(stateValue);
		if(CommonUtil.driver.findElements(By.xpath("//*[contains(text(), 'Successfully Completed the operation.')]")).size()>0){
			
			msg = "Delete institutional login succesfully";
			CommonUtil.report(msg,pass);
			return true;
		}
		msg = "Delete failed for institutional login";	
		CommonUtil.report(msg,fail);
		return false;
	}

public static boolean checkdelcustomerins(String string, String instLogin, String value) {
	CommonUtil.clicksync(admin);
	CommonUtil.clicksync(identi);
	CommonUtil.sleep(2000);
	while(true){
		if(CommonUtil.driver.findElement(By.xpath("//*[.='"+string+"']")).isDisplayed() == false){
			//click on >>
			CommonUtil.driver.findElement(By.xpath("//*[@class='v-tabsheet-scrollerNext']")).click();
		}else{
			CommonUtil.driver.findElement(By.xpath("//*[@class='v-tabsheet-scrollerNext']")).click();
			break;
		}
			
	}
	CommonUtil.driver.findElement(By.xpath("//*[.='"+string+"']")).click();
	CommonUtil.sleep(2000);
	
	
	CommonUtil.sendKeys(descriptionrem, instLogin);
	CommonUtil.sleep(2000);
	CommonUtil.clicksync(search);
	CommonUtil.sleep(10000);
	int flag=0;
	while(true){
		if((CommonUtil.driver.findElements(By.xpath("//div[contains(@id, 'window_close')]")).size()==0) && (flag!=40)){
			//click on >>
			CommonUtil.clicksync(identi);
			CommonUtil.sleep(2000);
			while(true){
				if(CommonUtil.driver.findElement(By.xpath("//*[.='"+string+"']")).isDisplayed() == false){
					//click on >>
					CommonUtil.driver.findElement(By.xpath("//*[@class='v-tabsheet-scrollerNext']")).click();
				}else{
					CommonUtil.driver.findElement(By.xpath("//*[@class='v-tabsheet-scrollerNext']")).click();
					break;
				}
					
			}
			CommonUtil.driver.findElement(By.xpath("//*[.='"+string+"']")).click();
			CommonUtil.sleep(2000);
			
			
			CommonUtil.sendKeys(descriptionrem, instLogin);
			CommonUtil.sleep(2000);
			CommonUtil.clicksync(search);
			CommonUtil.sleep(10000);
		
			flag=flag+1;
		}else{
//			CommonUtil.driver.findElement(By.xpath("//*[@class='v-tabsheet-scrollerNext']")).click();
			break;
		}
			
	}
	CommonUtil.sleep(2000);
	
//	String fetchdata= CommonUtil.getTitle();
//	String[] dataArray1= fetchdata.split(" - ");
//	fetchdata=dataArray1[2];
	if((CommonUtil.driver.findElements(By.xpath("//div[contains(@id, 'window_close')]")).size()>0))
	{
		msg = "The customer has been deleted succesfully";	
		CommonUtil.report(msg,pass);
//		CommonUtil.driver.findElement(By.xpath("//*[@class='v-menubar v-widget user-account-menu v-menubar-user-account-menu']")).click();
//		CommonUtil.driver.findElement(By.xpath("//*[@class='v-menubar-submenu v-widget user-account-menu v-menubar-submenu-user-account-menu']")).click();
//		CommonUtil.driver.findElement(By.xpath("//*[@class='v-slot v-align-center v-align-middle']/div/div")).click();
		return true;
	}
	
	//$('#gwt-uid-52').value
	
	
	
	
	msg = "The customer has been not been deleted properly";	
	CommonUtil.report(msg,fail);
	return false;
}

public static String createCustomerINS(String custtype) {
	// TODO Auto-generated method stub
	Select drpCustomer = new Select(CommonUtil.driver.findElement(By.id("pt1:_d_reg:region1:1:r2:0:dtrt_dc_4061095816::content")));
	if(custtype.equalsIgnoreCase("Regional Provision")){
		drpCustomer.selectByIndex(6);
	}
	else{
		drpCustomer.selectByVisibleText(custtype);
	}
	
	/* Random random = new Random();
	int randomNumber = random.nextInt(900000) + 100000;
	
	String custdata= "CUST"+randomNumber;
	
	*/
	
	DateFormat ts = new SimpleDateFormat("yyyyMMddHHmmss");
	Date date = new Date();
	String timestamp = ts.format(date);

    String data1="CUST"+timestamp;
    String custdata=data1.toUpperCase();
	
	CommonUtil.sleep(2000);
	CommonUtil.sendKeys(custid, custdata);
	CommonUtil.sendKeys(custname, custdata);
	Select drpCountry = new Select(CommonUtil.driver.findElement(By.id("pt1:_d_reg:region1:1:r2:0:e5182218973::content")));
	drpCountry.selectByIndex(100);
	if(custtype.equalsIgnoreCase("Society")){
		Select drpRegister = new Select(CommonUtil.driver.findElement(By.id("pt1:_d_reg:region1:1:r2:0:dtrt_dc_6630152345::content")));
		drpRegister.selectByIndex(1);
		CommonUtil.sendKeys(access, custdata);
		String URLdata= "www.google"+custdata+".com";
		CommonUtil.sendKeys(societyURL, URLdata);
	}
	if(custtype.equalsIgnoreCase("Institution")){
		Select drpRegister = new Select(CommonUtil.driver.findElement(By.id("pt1:_d_reg:region1:1:r2:0:dtrt_dc_9433075672::content")));
		drpRegister.selectByIndex(2);
		CommonUtil.sleep(1000);
		CommonUtil.sendKeys(adminPassword, "Kolkata012");
		CommonUtil.sleep(1000);
		CommonUtil.clear(adminConPassword);
		CommonUtil.sleep(1000);
		CommonUtil.sendKeys(adminConPassword, "");
		CommonUtil.sleep(1000);
		CommonUtil.sendKeys(adminConPassword, "Kolkata012");
	}
	if(custtype.equalsIgnoreCase("Personal") || custtype.equalsIgnoreCase("Regional Provision")){
		CommonUtil.sendKeys(maxuser, "1");
	}
	else{
		CommonUtil.sendKeys(maxuser, "2");
	}
	
	
	CommonUtil.click(submitcustomer);
	CommonUtil.clicksyncALM(stateValue);
	String data=CommonUtil.driver.findElement(By.xpath("//*[@id='pt1:ptsi1']/img")).getAttribute("title");
	
	CommonUtil.sleep(2000);
	String customertype=CommonUtil.getText(custValue);
	
	if (customertype.equals(custdata))
	{
			msg = "The customer has been created succesfully";	
			CommonUtil.report(msg,pass);
			return custdata;
	}
	msg = "The customer has been not been created succesfully";	
	CommonUtil.report(msg,fail);
	return null;
}

public static void naviagtetoAS2Page() {
	// TODO Auto-generated method stub
	CommonUtil.clearBrowserData();
	CommonUtil.refresh(EnvUtil.getProperty("AS2-URL"));
	CommonUtil.sleep(2000);
	
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
}

	







