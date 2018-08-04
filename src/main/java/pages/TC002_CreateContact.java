package pages;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import extenthtmlreporter.Annotationsnew3;
import wdMethods.Annotationsnew;

public class TC002_CreateContact extends Annotationsnew3{

	@BeforeTest
	public void setValues() {
		excelFileName = "CreateContact";
		testName = "Create Contact";
		testDesc = "Create a New Contact";
		category = "smoke";
		author = "sarath";
		moduleName = "Leads";
		
	}
	
	@Test (dataProvider = "fetchData")
	public void createContact(String cName, String firstName, String lastName) {
		new MyHomePage()
		.clickContacts()
		.clickCreateContacts()
		.typeFName(firstName)
		.typeLName(lastName)
		.clickViewContact()
		.verifyfName(firstName);
	
	}
}
