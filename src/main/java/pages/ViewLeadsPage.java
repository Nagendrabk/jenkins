package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import extenthtmlreporter.Annotationsnew3;
import wdMethods.Annotationsnew;

public class ViewLeadsPage extends Annotationsnew3 {
	
	public ViewLeadsPage() {
		PageFactory.initElements(driver,this);

	}
	@FindBy(id = "viewLead_firstName_sp")
	WebElement actualFName;
	
	public ViewLeadsPage verifyfName(String expText) {
		verifyExactText(actualFName,expText );
		return this;
	}
	
	@FindBy(linkText = "Delete")
	WebElement clickOnDelete;
	
	public MyLeadsPage clickonDeleteButton() {
		click(clickOnDelete);
		return new MyLeadsPage();
	}
	
	
}