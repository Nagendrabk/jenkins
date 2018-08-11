package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import extenthtmlreporter.Annotationsnew3;
import wdMethods.Annotationsnew;

public class MyHomePage extends Annotationsnew3{
	
	public MyHomePage() {
		PageFactory.initElements(driver,this);

	}
	
	@FindBy(xpath = "//a[text()='Leads']")
	WebElement eleLeads;
	
		
	public MyLeadsPage clickLeads() {
		click(eleLeads);
		reportStep("Leads has been cicked Successfully", "pass");
		return new MyLeadsPage();
	}
	
}
