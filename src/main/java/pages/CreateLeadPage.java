package pages;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;

import extenthtmlreporter.Annotationsnew3;
import wdMethods.Annotationsnew;
import wdMethods.SeMethods;

//import week3.dailychallenges.wdmethods.*;
public class CreateLeadPage extends  Annotationsnew3 {
		
		public CreateLeadPage() {
			PageFactory.initElements(driver,this);

		}
		

		@FindBy(id = "createLeadForm_companyName")
		WebElement eleCName;
		
		@FindBy(id="createLeadForm_firstName")
		WebElement eleFName;
		
		@FindBy(id = "createLeadForm_lastName")
		WebElement eleLName;
		
		@FindBy(xpath = "//*[@name='submitButton']")
		WebElement clickviewLead;
		
		public CreateLeadPage typeCName(String cName) {
			type(eleCName, cName);
			reportStep("Comany Name has been entered Successfully", "pass");
			return this;
		}
		public CreateLeadPage typeFName(String fName) {
			type(eleFName, fName);
			reportStep("First Name has been entered Successfully", "pass");
			return this;
		}
		public CreateLeadPage typeLName(String lName) {
			type(eleLName, lName);
			reportStep("Last Name has been entered Successfully", "pass");
			return this;
		}
				
		public ViewLeadsPage clickViewLead() {
			click(clickviewLead);
			reportStep("View Leads page been clicked Successfully", "pass");
			return new ViewLeadsPage();
		}
		
}
			


