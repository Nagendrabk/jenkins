package pages;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import extenthtmlreporter.Annotationsnew3;
import wdMethods.Annotationsnew;

public class TC001_CreateLead extends Annotationsnew3{

	@BeforeTest
	public void setValues() {
		excelFileName = "CreateLead";
		testName = "Create Lead";
		testDesc = "Create a New Lead";
		category = "smoke";
		author = "sarath";
		moduleName = "Leads";
		
	}
	
	@Test (dataProvider = "fetchData")
	public void createLead(String cName, String fName, String lName) {
		new MyHomePage()
		.clickLeads()
		.clickCreateLeads()
		.typeCName(cName)
		.typeFName(fName)
		.typeLName(lName)
		.clickViewLead()
		.verifyfName(fName);
	
	}
}
