package wiley.automation.wol.workflow;

import java.io.IOException;

import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.WebDriver;

import jxl.write.WriteException;
import wiley.automation.core.util.ObjectLocator;
import wiley.automation.wol.impl.ALMtoLITImpl;
import wiley.automation.wol.impl.CompareSelectionImpl;


public class CompareSelection_Page extends ObjectLocator {

	private final WebDriver driver;
	
	//static Logger log = Logger.getLogger(HomePage.class);

	
	static CompareSelectionImpl comp;

	public CompareSelection_Page(WebDriver driver) {
		this.driver = driver;
		comp = new CompareSelectionImpl();
		// Check that we're on the right page.
		
	}

	public static void navigateToUATPage() {
		// TODO Auto-generated method stub
		
		CompareSelectionImpl.navigateToUATPage();
	}

	public static void navigateToWIPPage() {
		// TODO Auto-generated method stub
		CompareSelectionImpl.navigateToWIPPage();
	}

	public static boolean compareUATWIP(String username, String password, String volumne) throws WriteException {
		// TODO Auto-generated method stub
		return CompareSelectionImpl.compareUATWIP(username,password, volumne);
	}

	public static boolean pricingToolCheck(String username, String password, int i, int loop) throws Exception {
		// TODO Auto-generated method stub
		return CompareSelectionImpl.pricingToolCheck(username,password, i,loop);
	}
	public static boolean pricingToolInsert(String username, String password, int i, int loop) throws Exception {
		// TODO Auto-generated method stub
		return CompareSelectionImpl.pricingToolInsert(username,password, i,loop);
	}
	
	public static boolean searchISSN( String PrintISSN, String OnlineISSN)throws Exception {
		// TODO Auto-generated method stub
		return CompareSelectionImpl.searchISSN( PrintISSN, OnlineISSN);
	}

	public static String PricingToolView(String volumne) {
		// TODO Auto-generated method stub
		return CompareSelectionImpl.PricingToolView(volumne);
	}

	public static boolean pricingToolChecKFail(String username, String password, int i) throws WriteException, IOException {
		// TODO Auto-generated method stub
		return true;
	}

	public static boolean pricingToolCheckxlsx(String username, String password, int i, int loop, XSSFWorkbook workbook) throws Exception {
		// TODO Auto-generated method stub
		return CompareSelectionImpl.pricingToolCheckxlsx(username,password, i,loop, workbook);
	}

	public static boolean orderingDisplayTrue(String username, String password, int i, int loop) throws Exception {
		// TODO Auto-generated method stub
		return CompareSelectionImpl.orderingDisplayTrue(username,password, i,loop);
	}
	

	public static boolean orderingformPage(String username, String password, int i, int loop) throws Exception {
		// TODO Auto-generated method stub
		return CompareSelectionImpl.orderingformPage(username,password, i,loop);
	}

	
}
