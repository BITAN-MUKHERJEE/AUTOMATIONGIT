package wiley.automation.wol.impl;

import java.util.ArrayList;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;

import wiley.automation.core.util.CommonUtil;
import wiley.automation.core.util.EnvUtil;
import wiley.automation.core.util.ObjectLocator;
//import wiley.automation.core.util.dbConnection;
import wiley.automation.wol.workflow.LoginPage;



public class LoginPageImpl extends ObjectLocator {
	
	 //static Logger log = Logger.getLogger(LoginPageImpl.class);
	 private static String msg;

	/*public boolean registerUser(String User_email) {
		// TODO Auto-generated method stub
		CommonUtil.click(loginoverlay);
		CommonUtil.sleep(2000);
		if(CommonUtil.isElementPresent(register)){
			CommonUtil.click(register);
			CommonUtil.waitForpageToLoad();
			if(CommonUtil.isElementPresent(email)
					&& CommonUtil.isElementPresent(confirm_email)
					&& CommonUtil.isElementPresent(password)
					&& CommonUtil.isElementPresent(confirm_password)
					&& CommonUtil.isElementPresent(firstName)
					&& CommonUtil.isElementPresent(lastName)
					&& CommonUtil.isElementPresent(country)
					&& CommonUtil.isElementPresent(aoi)
					&& CommonUtil.isElementPresent(atnc)
					&& CommonUtil.isElementPresent(submitReg)){
				CommonUtil.sendKeys(email, User_email);
				CommonUtil.sendKeys(confirm_email, User_email);
				CommonUtil.sendKeys(password, "password");
				CommonUtil.sendKeys(confirm_password, "password");
				CommonUtil.sendKeys(firstName, User_email.split("@")[0]);
				CommonUtil.sendKeys(lastName, User_email.split("@")[0]);
				CommonUtil.selectdropdownvaluebyvisibletext(country, "INDIA");
				CommonUtil.selectdropdownvaluebyvisibletext(aoi, "Accounting");
				CommonUtil.driver.findElement(atnc).click();
				CommonUtil.click(submitReg);
				msg = "Registration page filled and submitted";	
				//log.info(msg);
				CommonUtil.report(msg,pass);
				CommonUtil.waitForpageToLoad();
				if(CommonUtil.isElementPresent(successmessage)){
					msg = "Registration page filled and submitted";	
					//log.info(msg);
					CommonUtil.report(msg,pass);
					return true;
				}
				return false;
			}else{
				msg = "Registration page Not opened properly";	
				//log.info(msg);
				CommonUtil.report(msg,fail);
				return false;
			}
				
		}
		return false;
	}

/*	public boolean verifyAddContentXML(String user_email) {
		// TODO Auto-generated method stub
		MarkLogicImpl ml = new MarkLogicImpl();
		if(ml.verifyCreateUserXML(user_email))
			return true;
		return false;
	}

	public boolean yopmailLogin(String user_email) {
		// TODO Auto-generated method stub
		CommonUtil.isElementPresent(yopmailemail);
		CommonUtil.sendKeys(yopmailemail, user_email);
		CommonUtil.isElementPresent(yopmailsubmit);
		CommonUtil.click(yopmailsubmit);
		CommonUtil.waitForpageToLoad();
		CommonUtil.sleep(2000);
		if(CommonUtil.isElementPresent(yopmailInbox))
			return true;
		return false;
	}

	public boolean ActivateYopmailUser() {
		// TODO Auto-generated method stub
		int count = 0;
		while(true){
			CommonUtil.driver.switchTo().frame(CommonUtil.driver.findElement(By.cssSelector("iframe#ifinbox.whc")));
			if(!CommonUtil.isElementPresent(emailsubject)){
				CommonUtil.click(deletebtn);
				CommonUtil.waitForpageToLoad();
				CommonUtil.sleep(2000);
				count++;
				if(count == 10)
					break;
			}else{
				if(CommonUtil.isElementPresent(authenticationlink)){
					CommonUtil.click(authenticationlink);
					CommonUtil.sleep(5000);
					return true;
				}
				return false;
			}
			
		}
			
		return false;
	}*/
	 



	public static boolean goToMyProfile() {
		CommonUtil.sleep(2000);
		CommonUtil.clicksync(myprofilelink);
		CommonUtil.clicksync(myprofilelinkcheck);
		if(CommonUtil.verifyTextPresent(checkmyaccount, "My account")){
			msg = "Login is successfull";	
			//log.info(msg);
			CommonUtil.report(msg,pass);
			return true;
		}else{
			msg = "Login is unsuccessfull";	
			//log.info(msg);
			CommonUtil.report(msg,fail, "Present");
			return false;
		}
			}

	
	public static boolean updateUserProfile() {
		CommonUtil.sleep(2000);
		long number = (long) Math.floor(Math.random() * 9000000000L) + 1000000000L;
		String phone_number = "phone[0].value";
		By phone_number_link= By.id(phone_number);
		String number1= String.valueOf(number);
		CommonUtil.clear(phone_number_link);
		CommonUtil.sendKeys(phone_number_link, number1);
		CommonUtil.scrolldown(phone_number_link); 
		CommonUtil.clicksync(clickupdate);
		CommonUtil.clicksync(homepagemove);
		CommonUtil.clicksync(myprofilelink);
		CommonUtil.clicksync(myprofilelinkcheck);
		String ret_phoneNumber= CommonUtil.getAttributeValue(phone_number_link, "value");
		
		if(ret_phoneNumber.contains(number1)){
			msg = "Update is successfull";	
			//log.info(msg);
			CommonUtil.report(msg,pass);
			return true;
		}else{
			msg = "Update is unsuccessfull";	
			//log.info(msg);
			CommonUtil.report(msg,fail, "Present");
			return false;
		}
			}
	public void deleteAllSavedArticle() {
		// TODO Auto-generated method stub
		if(CommonUtil.isElementPresent(savedarticles)){
			CommonUtil.clicksync(savedarticles);
			CommonUtil.sleep(2000);
			CommonUtil.driver.findElement(selectAllCheckBox).click();
			CommonUtil.clicksync(deletearticlebtn);
			CommonUtil.sleep(2000);
			msg = "Delete all saved articles in my profile";	
			//log.info(msg);
			CommonUtil.report(msg,pass);
		}
	}

	public boolean verifySavedAAArticleReqPermission(String dOI) {
		// TODO Auto-generated method stub
		if(CommonUtil.isElementPresent(savedarticles)){
			CommonUtil.clicksync(savedarticles);
			CommonUtil.sleep(5000);
			if(!CommonUtil.isElementPresent(requestpermissioninmyprofile)){
				msg = "Request Permission not present";	
				//log.info(msg);
				CommonUtil.report(msg,pass);
				return true;
			}else{
				msg = "Request Permission not present";	
				//log.info(msg);
				CommonUtil.report(msg,fail, "Present");
				return false;
			}
		}
		return false;
	}

	public void deleteSavedPublication() {
		// TODO Auto-generated method stub
		if(CommonUtil.isElementPresent(savedpublications)){
			CommonUtil.clicksync(savedpublications);
			CommonUtil.sleep(2000);
			CommonUtil.driver.findElement(selectAllCheckBox).click();
			CommonUtil.sleep(2000);
			CommonUtil.clicksync(deletepublicationbtn);
			CommonUtil.sleep(2000);
			msg = "Delete all saved publication in my profile";	
			//log.info(msg);
			CommonUtil.report(msg,pass);
		}else{
			msg = "Delete all saved publication in my profile";	
			//log.info(msg);
			CommonUtil.report(msg,fail);
		}
	}

	public boolean verifyReferenceWorkInSavedPub() {
		// TODO Auto-generated method stub
		if(CommonUtil.isElementPresent(savedpublications)){
			CommonUtil.clicksync(savedpublications);
			CommonUtil.sleep(2000);
			if(CommonUtil.isElementPresent(referenceworkinmyprofile)){
				msg = "Reference work in saved publication present";	
				//log.info(msg);
				CommonUtil.report(msg,pass);
				return true;
			}else{
				msg = "Reference work in saved publication present";	
				//log.info(msg);
				CommonUtil.report(msg,fail);
			}
			
		}
		return false;
	}

	public void logout() {
		// TODO Auto-generated method stub
		CommonUtil.logoutMyProfile(logout);
	}

	public boolean goToSubscriptionAccess() {
		if(CommonUtil.isElementPresent(subscriptionaccesslink)){
			CommonUtil.clicksync(subscriptionaccesslink);
			msg = "Clicked on Subscription Access";	
			//log.info(msg);
			CommonUtil.report(msg,pass);
			CommonUtil.sleep(2000);
			if(CommonUtil.isElementPresent(subscriptionaccesscustid) &&
					CommonUtil.isElementPresent(subscriptionaccessaccesscode)){
				msg = "Subscription Access for Individuals page loaded";	
				//log.info(msg);
				CommonUtil.report(msg,pass);
				return true;
			}
			else{
				msg = "Subscription Access for Individuals page loaded";	
				//log.info(msg);
				CommonUtil.report(msg,fail);
				return false;
			}
		}
		msg = "Clicked on Subscription Access";	
		//log.info(msg);
		CommonUtil.report(msg,fail);
		return false;
	}

	

	public boolean verifySubscrption(boolean b) {
		// TODO Auto-generated method stub
		if(!b){
			CommonUtil.driver.getPageSource().toString().contains("The Access Code entered is invalid");
			msg = "The Access Code entered is invalid";	
			//log.info(msg);
			CommonUtil.report(msg,pass);
			return true;
		}else{
			
		}
		return false;
	}


	public static boolean loginDSSAs(String user, String password) {
		// TODO Auto-generated method stub
		CommonUtil.driver.navigate().refresh();
		CommonUtil.sleep(3000);
		if(CommonUtil.isElementPresent(DSSUser) && CommonUtil.isElementPresent(DSSPassword)){
			CommonUtil.sendKeys(DSSUser, user);
			CommonUtil.sendKeys(DSSPassword, password);
			CommonUtil.clicksync(button_login);
			
			CommonUtil.sleep(5000);
			
			try {
				
				CommonUtil.driver.findElement(By.xpath("//*[contains(text(), 'LOGOUT')]"));
				msg = "DSS Login is Successful";
				CommonUtil.report(msg,pass);
				return true;
				
				}
				catch (org.openqa.selenium.NoSuchElementException e) 
				{
					
					msg = "DSS Login is Fail";	
					CommonUtil.report(msg,fail);
					return false;
					
				}
			
			
			/*CommonUtil.driver.navigate().refresh();
			msg = "DSS Login Successful";	
			CommonUtil.report(msg,pass);
			return true;*/
		}
		msg = "DSS Login UnSuccessful";	
		CommonUtil.report(msg,fail);
		return false;
	}
	
	
	public static boolean LoginALM(String user, String password) {
		// TODO Auto-generated method stub
		if(CommonUtil.isElementPresent(ALMuser) && CommonUtil.isElementPresent(ALMpassword)){
			CommonUtil.sendKeys(ALMuser, user);
			CommonUtil.sendKeys(ALMpassword, password);
			CommonUtil.clicksync(submitALM_login);
			

			CommonUtil.sleep(5000);
			
			try {
				
				CommonUtil.driver.findElement(By.xpath("//a[contains(text(),'Sign Out')]"));
				msg = "ALM Login is Successful";
				CommonUtil.report(msg,pass);
				return true;
				
				}
				catch (org.openqa.selenium.NoSuchElementException e) 
				{
					
					msg = "ALM page Login is Fail";	
					CommonUtil.report(msg,fail);
					return false;
					
					}
			
			/*msg = "ALM Login Successful";	
			CommonUtil.report(msg,pass);
			return true;*/
		}
		
		msg = "ALM Login UnSuccessful";	
		CommonUtil.report(msg,fail);
		return false;
	}

	
	

	public static boolean LoginLIT(String username, String password) {
		// TODO Auto-generated method stub
		if(CommonUtil.isElementPresent(LITuser) && CommonUtil.isElementPresent(LITpassword)){
			CommonUtil.sendKeys(LITuser, username);
			CommonUtil.sendKeys(LITpassword, password);
			CommonUtil.scrolldown(LITuser);
			CommonUtil.sleep(200);
			CommonUtil.driver.findElement(LITpassword).sendKeys(Keys.ENTER);
			//CommonUtil.clicksync(submitLIT_login);
			
 			CommonUtil.sleep(1000);
			
			try {
				
				CommonUtil.driver.findElement(By.xpath("//span[@class='a-user-name']"));
				msg = "Literatum Login is Successful";
				CommonUtil.report(msg,pass);
				return true;
				
				}
				catch (org.openqa.selenium.NoSuchElementException e) 
				{
					
					msg = "Literatum Login is Fail";	
					CommonUtil.report(msg,fail);
					return false;
					
					}
		
			
						//return true;
			
		}
		msg = "LIT Login UnSuccessful";	
		CommonUtil.report(msg,fail);
		return false;
	}


	public static boolean LoginWOLLibAdmin(String customer, String customerPassword) {
		// TODO Auto-generated method stub
		CommonUtil.refresh(CommonUtil.driver.getCurrentUrl()+"/adlogin/");
		CommonUtil.sendKeys(By.id("accessEmail"), customer);
		CommonUtil.sendKeys(By.id("accessPassword"), customerPassword);
		CommonUtil.clicksync(By.id("accessSubmit"));
		if(CommonUtil.driver.findElements(By.linkText("Log Out")).size() > 0){
			msg = "WOL Login UnSuccessful";	
			CommonUtil.report(msg,pass);
			return true;
		}
		msg = "WOL Login UnSuccessful";	
		CommonUtil.report(msg,fail);
		return false;
	}


	public static boolean LoginAS2(String aS2_Username, String aS2_Password) {
		CommonUtil.clearBrowserData();
		CommonUtil.refresh(EnvUtil.getProperty("AS2-URL"));
		if(CommonUtil.isElementPresent(By.xpath("//a[@class='menu__btn menu__btn_active action-anchor-menu-login-button']"))){
			//CommonUtil.scrolltoview(By.xpath("//a[@class='menu__btn menu__btn_active action-anchor-menu-login-button']"));
			//CommonUtil.clicksync(By.xpath("//a[@class='menu__btn menu__btn_active action-anchor-menu-login-button']"));
			CommonUtil.clicksync(By.xpath("(//a[contains(text(),'Login')])[2]"));
			if(CommonUtil.isElementPresent(By.id("login-inputEmail")) && CommonUtil.isElementPresent(By.id("login-inputPassword"))){
				CommonUtil.sendKeys(By.id("login-inputEmail"), aS2_Username);
				CommonUtil.sendKeys(By.id("login-inputPassword"), aS2_Password);
				CommonUtil.clicksync(By.id("login-btn"));
				if(CommonUtil.isElementDisplay(By.xpath("//*[@class='page__nav-bar']//li[2]/a"))){
					CommonUtil.click(By.xpath("//*[@class='page__nav-bar']//li[2]/a"));
					CommonUtil.sleep(5000);
					msg = "AS Login Successful";	
					CommonUtil.report(msg,pass);
					return true;
				}
				else if(CommonUtil.isElementDisplay(clickAS2Check)){
					CommonUtil.click(clickAS2Check);
					
					CommonUtil.clicksync(clickNext);
					CommonUtil.sleep(5000);
					
					if(CommonUtil.isElementDisplay(By.xpath("//*[@class='page__nav-bar']//li[2]/a"))){
						CommonUtil.click(By.xpath("//*[@class='page__nav-bar']//li[2]/a"));
						CommonUtil.sleep(5000);
						msg = "AS Login Successful";	
						CommonUtil.report(msg,pass);
						return true;
					}
				}
			}
		}
		msg = "AS Login UnSuccessful";	
		CommonUtil.report(msg,fail);
		return false;
	}
	
	
	public static boolean loginAs(String username, String password) {
		
		CommonUtil.waitForpageToLoad();
    	if(CommonUtil.isElementPresent(loginchecker)){
    		CommonUtil.waitForpageToLoad();
    		CommonUtil.click(loginchecker);
    		CommonUtil.sleep(4000);
		//if(CommonUtil.isElementPresent(LITuser) && CommonUtil.isElementPresent(LITpassword)){
			CommonUtil.sendKeys(LITuser, username);
			CommonUtil.sendKeys(LITpassword, password);
			CommonUtil.scrolldown(LITuser);
			CommonUtil.sleep(2000);
			CommonUtil.clicksync(submitLIT_login);
			
			CommonUtil.sleep(5000);
			
			try {
				
				CommonUtil.driver.findElement(By.xpath("//span[@class='profile-text']"));
				msg = "Literatum page Login is Successful";
				CommonUtil.report(msg,pass);
				return true;
				
				}
				catch (org.openqa.selenium.NoSuchElementException e) 
				{
					
					msg = "Literatum page Login is Fail";	
					CommonUtil.report(msg,fail);
					return false;
					
					}
		
			
						//return true;
			
		}
		msg = "Literatum page Login UnSuccessful";	
		CommonUtil.report(msg,fail);
		return false;
	}


	public static boolean loginBPAAs(String username, String password) {
		// TODO Auto-generated method stub
		CommonUtil.sleep(3000);
		if(CommonUtil.isElementPresent(BPAUserName) && CommonUtil.isElementPresent(BPAPassword)){
			CommonUtil.sendKeys(BPAUserName, username);
			CommonUtil.sleep(2000);
			CommonUtil.sendKeys(BPAPassword, password);
			CommonUtil.sleep(2000);
			CommonUtil.clicksync(BPASignIn);
			
			CommonUtil.sleep(7000);
			
			try {
				
				CommonUtil.driver.findElement(By.xpath("//input[@name='submit']"));
				msg = "BPA Login is Successful";
				CommonUtil.report(msg,pass);
				return true;
				
				}
				catch (org.openqa.selenium.NoSuchElementException e) 
				{
					
					msg = "BPA Login is Fail";	
					CommonUtil.report(msg,fail);
					return false;
					
				}
			
			
			/*CommonUtil.driver.navigate().refresh();
			msg = "DSS Login Successful";	
			CommonUtil.report(msg,pass);
			return true;*/
		}
		msg = "BPA Login UnSuccessful";	
		CommonUtil.report(msg,fail);
		return false;
	}


	public static boolean LoginWIP(String username, String password) {
		// TODO Auto-generated method stub
		if(CommonUtil.isElementPresent(userDetails) && CommonUtil.isElementPresent(passwordDetails)){
			CommonUtil.sendKeys(userDetails, username);
			CommonUtil.sendKeys(passwordDetails, password);
			CommonUtil.clicksync(loginDetails);
			

			CommonUtil.sleep(5000);
			
			try {
				
				CommonUtil.driver.findElement(By.xpath("//legend[contains(text(),'Select Year')]"));
				msg = "Login to WIP is Successful";
				CommonUtil.report(msg,pass);
				return true;
				
				}
				catch (org.openqa.selenium.NoSuchElementException e) 
				{
					
					msg = "Page Login is Fail";	
					CommonUtil.report(msg,fail);
					return false;
					
					}
			
			/*msg = "ALM Login Successful";	
			CommonUtil.report(msg,pass);
			return true;*/
		}
		
		msg = "Login UnSuccessful";	
		CommonUtil.report(msg,fail);
		return false;
	}


	public static boolean LoginUAT(String username, String password) {
		// TODO Auto-generated method stub
		if(CommonUtil.isElementPresent(userDetails) && CommonUtil.isElementPresent(passwordDetails)){
			CommonUtil.sendKeys(userDetails, username);
			CommonUtil.sendKeys(passwordDetails, password);
			CommonUtil.clicksync(loginDetails);
			

			CommonUtil.sleep(5000);
			
			try {
				
				CommonUtil.driver.findElement(By.xpath("//legend[contains(text(),'Select Year')]"));
			//	msg = "Login to UAT is Successful";
			//	CommonUtil.report(msg,pass);
				return true;
				
				}
				catch (org.openqa.selenium.NoSuchElementException e) 
				{
					
			//		msg = "Page Login is Fail";	
			//		CommonUtil.report(msg,fail);
					return false;
					
					}
			
			/*msg = "ALM Login Successful";	
			CommonUtil.report(msg,pass);
			return true;*/
		}
		
		msg = "Login UnSuccessful";	
		CommonUtil.report(msg,fail);
		return false;
	}

	}
	
	
	/*public static boolean LoginBPA(String user, String password) {
		// Riten
		if(CommonUtil.isElementPresent(ALMuser) && CommonUtil.isElementPresent(ALMpassword)){
			CommonUtil.sendKeys(ALMuser, user);
			CommonUtil.sendKeys(ALMpassword, password);
			CommonUtil.clicksync(submitALM_login);
			msg = "ALM Login Successful";	
			CommonUtil.report(msg,pass);
			return true;
		}
		msg = "ALM Login UnSuccessful";	
		CommonUtil.report(msg,fail);
		return false;
	}*/
	
	

	/*public boolean enterSubscriptionDetailsforInstitution() {
		// TODO Auto-generated method stub
		ArrayList<String> details = null;
		dbConnection connection = new dbConnection();
		if(connection.getConnection(strDBTimeout, strDBName, strDBURL, strDBUserName, strDBPassword)){
			details = connection.getValue("select top 1 external_id, administration_key from customer where customer_type_id = 2 and customer_status_id = 1 and administration_key != 'null'");
		    connection.endConnection();
		    if(details != null && details.size() == 2){
		    	CommonUtil.sendKeys(subscriptionaccesscustid, details.get(0));
		    	CommonUtil.sendKeys(subscriptionaccessaccesscode, details.get(1));
		    	msg = "Customer details";	
				//log.info(msg);
				CommonUtil.report(msg,pass, details.get(0)+", "+details.get(1));
		    	CommonUtil.clicksync(subscriptionsubmit);
		    	CommonUtil.sleep(2000);
		    	msg = "submit subscription";	
				//log.info(msg);
				CommonUtil.report(msg,pass);
		    	return true;
		    }
		    msg = "submit subscription";	
			//log.info(msg);
			CommonUtil.report(msg,fail);
		    return false;
		}
		return false;
	}*/

