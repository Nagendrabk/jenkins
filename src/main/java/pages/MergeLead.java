package pages;


import org.openqa.selenium.WebElement;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;

import wdMethods.Annotations;
import wdMethods.Annotationsnew;
import wdMethods.SeMethods;

public class MergeLead extends Annotationsnew3 {

	@Parameters ({"url", "uName", "pwd"})
	@Test
public void mergeLead(String url, String uName, String pwd) throws InterruptedException {
		
		WebElement eleLogin = locateElement("class","decorativeSubmit");
		click(eleLogin);
		WebElement eleLinkText = locateElement("linkText", "CRM/SFA");
		click(eleLinkText);
	
	WebElement createCntLink = locateElement("xpath", "//a[text()='Create Lead']");
	click(createCntLink);
	
	//Click to access the Merge Lead
	 WebElement mergeLead=locateElement("xpath", "//a[text()='Merge Leads']");
	 click(mergeLead);
	 closeBrowser();
	


	
}
}
