package pages;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;

import wdMethods.Annotations;
import wdMethods.Annotationsnew;
import wdMethods.SeMethods;

//import week3.dailychallenges.wdmethods.*;
public class EditLead extends Annotationsnew3 {
	ExtentReports extent;

	@Parameters ({"url", "uName", "pwd"})
	@Test
 public void editLead(String url, String uName, String pwd) {


		WebElement eleLogin = locateElement("class","decorativeSubmit");
		click(eleLogin);
		WebElement eleLinkText = locateElement("linkText", "CRM/SFA");
		click(eleLinkText);
		
		WebElement contactLink = locateElement("xpath", "//a[text()='Leads']");
		click(contactLink);
		WebElement createCntLink = locateElement("xpath", "//a[text()='Find Leads']");
		click(createCntLink);
		WebElement editElement  = locateElement("xpath", "(//input[@name='firstName'])[3]");
		type(editElement, "Nagendra");
		
		WebElement findBtn = locateElement("xpath", "//button[text()='Find Leads']");
		click(findBtn);

		WebElement clickOnFirstName = locateElement ("linkText", "Nagendra");
		click(clickOnFirstName);
		
		WebElement clickOnEdit = locateElement ("linkText", "Edit");
		click(clickOnEdit);

 }
}
