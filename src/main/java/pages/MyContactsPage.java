package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import extenthtmlreporter.Annotationsnew3;
import wdMethods.Annotationsnew;

public class MyContactsPage extends Annotationsnew3 {
	
	public MyContactsPage() {
		PageFactory.initElements(driver,this);

	}
	@FindBy(linkText = "Create Contact")
	WebElement eleclickcreateContact;
	
	
	
	public CreateContactPage clickCreateContacts() {
		click(eleclickcreateContact);
		reportStep("Create Contacts has been cicked Successfully", "pass");
		return new CreateContactPage();
	}
	
}
