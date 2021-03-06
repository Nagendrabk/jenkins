package extenthtmlreporter;

import java.io.IOException;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
//import org.testng.annotations.BeforeMethod;

import com.aventstack.extentreports.ExtentReports;

import wdMethods.SeMethods;

public class Annotationsnew3 extends SeMethods {
	public String excelFileName, testName, testDesc, category, author, moduleName;

	@BeforeSuite
	public void startSuite() {
		beginResult();
	}
	
	@BeforeClass
	public void starttest() {
		startTest(testName, testDesc);
	}
	
	
@Parameters ({"url","uName", "pwd" } )
	@BeforeMethod (groups = {"smoke", "sanity"})
	public void login (String url, String uName, String pwd) {
		startTestIteration (moduleName, author, category);
		startApp("chrome", url);
		type(locateElement("id", "username"), uName);
		type(locateElement("id","password"),pwd);
		click(locateElement("class","decorativeSubmit"));
		click(locateElement("linkText", "CRM/SFA"));
	
	}

@AfterMethod(groups = {"smoke","sanity"})
public void closeApp() {
	closeBrowser();
}

@AfterSuite
public void stopSuite() {
	endResult();
}

@DataProvider(name="fetchData")
public Object[][] getData() throws IOException {
	ReadExcelDataProvider excel = new ReadExcelDataProvider();
	return excel.readExcel(excelFileName);
}

		public void beginResult() {
	}

	// This method creates the test case level report in HTML
	//@BeforeClass
	public void startTest(String testCaseName, String testDescription) {
	}

	// This method create entry for every test case iteration
	//@BeforeMethod
	public void startTestIteration(String iteration, String author, String category) {	
		 
		 
	}

	// This method create entry for every step
	public void reportStep(String desc,String status) {
	}

	// This method create the html report finally
	public void endResult() {
	}
}
