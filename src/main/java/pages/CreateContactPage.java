package pages;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;

import extenthtmlreporter.Annotationsnew3;
import wdMethods.Annotations;
import wdMethods.Annotationsnew;
import wdMethods.SeMethods;

//import week3.dailychallenges.wdmethods.*;
public class CreateContactPage extends  Annotationsnew3 {
		
		public CreateContactPage() {
			PageFactory.initElements(driver,this);

		}

		
		@FindBy(id="firstNameField")
		WebElement eleFCName;
		
		@FindBy(id = "lastNameField")
		WebElement eleLCName;
		
		@FindBy(xpath = "//*[@name='submitButton']")
		WebElement clickCreateContact;
		

		public CreateContactPage typeFName(String firstName) {
			type(eleFCName, firstName);
			reportStep("First Name "+firstName+" has been entered Successfully", "pass");
			return this;
		}
		public CreateContactPage typeLName(String lastName) {
			type(eleLCName, lastName);
			reportStep("Last Name "+lastName+" has been entered Successfully", "pass");
			return this;
		}
				
		public ViewContactsPage clickViewContact() {
			click(clickCreateContact);
			reportStep("View Contact has been cicked Successfully", "pass");
			return new ViewContactsPage();
		}
		
}
			


