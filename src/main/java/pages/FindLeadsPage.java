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
public class FindLeadsPage extends  Annotationsnew3 {
		
		public FindLeadsPage() {
			PageFactory.initElements(driver,this);

		}
		
		@FindBy(xpath = "(//input[@name='firstName'])[3]")
		WebElement eleFindByFname;
		
		@FindBy(xpath = "//button[text()='Find Leads']")
		WebElement eleClickFindLeads;

		@FindBy(linkText ="Nagendra")
		WebElement clickOnFirstName;
		
		public FindLeadsPage typeFName(String fName) {
			type(eleFindByFname, fName);
			reportStep("First Name to be searched has been entered Successfully", "pass");
			return this;
		}
		public FindLeadsPage clickFindLeads() {
			click(eleClickFindLeads);
			reportStep("Find Leads been clicked Successfully", "pass");
			return this;
		}
				
		public ViewLeadsPage clickViewLead() {
			click(clickOnFirstName);
			reportStep("View Leads page been clicked Successfully", "pass");
			return new ViewLeadsPage();
		}
		
}
			


