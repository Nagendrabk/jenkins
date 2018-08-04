package pages;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import extenthtmlreporter.Annotationsnew3;
import wdMethods.Annotationsnew;

public class TC004_DeleteLead extends Annotationsnew3{

	@BeforeTest
	public void setValues() {
		excelFileName = "DeleteLead";
		testName = "Delete Lead";
		testDesc = "Delete an existing Lead";
		category = "smoke";
		author = "sarath";
		moduleName = "Leads";
		
	}
	
	@Test (dataProvider = "fetchData")
	public void DeleteLead(String fName) {
		new MyHomePage()
		.clickLeads()
		.clickFindLeads()
		.typeFName(fName)
		.clickFindLeads()
		.clickViewLead()
		.clickonDeleteButton();
	}
}
