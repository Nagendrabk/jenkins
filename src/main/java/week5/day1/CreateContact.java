package week5.day1;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
//import org.junit.Test;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

import wdMethods.Annotations;
import wdMethods.Annotationsnew;
import wdMethods.SeMethods;


public class CreateContact extends Annotationsnew {

		@Test(groups= {"smoke"})

		public void startLogin() {
		startApp("chrome", "http://leaftaps.com/opentaps/control/main");
		WebElement eleUserName = locateElement("id", "username");
		type(eleUserName, "DemoSalesManager");
		WebElement elePassword = locateElement("id","password");
		type(elePassword, "crmsfa");

		WebElement eleLogin = locateElement("class","decorativeSubmit");
		click(eleLogin);
		WebElement eleLinkText = locateElement("linkText", "CRM/SFA");
		click(eleLinkText);
		
		WebElement eleContact = locateElement ("linkText", "Create Contact");
		click(eleContact);
		WebElement eleFirst = locateElement ("id", "firstNameField");
		type(eleFirst, "Nagendra");
		String str = getText(eleFirst);
		WebElement eleLast = locateElement("id","lastNameField");
		type(eleLast, "Saravana");
		WebElement eleFirstlocal= locateElement("id", "createContactForm_firstNameLocal");
		type(eleFirstlocal, "Nag");
		WebElement eleLastLocal = locateElement("id", "createContactForm_firstNameLocal");
		type(eleLastLocal, "Sara");
		WebElement elePersonalTitle = locateElement("id", "createContactForm_personalTitle");
		type(elePersonalTitle, "Mr");
		WebElement eleTitle = locateElement("name", "generalProfTitle");
		type(eleTitle, "Indigo");
		WebElement eleDept = locateElement("id", "createContactForm_departmentName");
		type(eleDept, "Marketing");
		WebElement eleCurr = locateElement("id", "createContactForm_preferredCurrencyUomId");
		selectDropDownUsingIndex(eleCurr, 2);
		WebElement eleDesc = locateElement ("id", "createContactForm_description");
		type (eleDesc, "This is a test description");
		WebElement eleNote = locateElement ("id", "createContactForm_importantNote");
		type (eleNote, "Test Note");
		WebElement eleAreaCode = locateElement("id", "createContactForm_primaryPhoneAreaCode");
		type(eleAreaCode, "603103");
		WebElement elePhoneNumber = locateElement ("xpath", "//input[@id='createContactForm_primaryPhoneNumber']");
		type(elePhoneNumber, "9886821345");
		WebElement elePhoneExtn = locateElement ("id", "createContactForm_primaryPhoneExtension");
		type(elePhoneExtn, "044");
		WebElement elePhoneAskName = locateElement ("id", "createContactForm_primaryPhoneAskForName");
		type(elePhoneAskName, "Nage");
		WebElement elePrimaryEmail = locateElement ("id", "createContactForm_primaryEmail");
		type(elePrimaryEmail, "saravanak@gmail.com");
		
		WebElement eleGeneralToName = locateElement ("id", "generalToNameField");
		verifyPartialText(eleGeneralToName, "Nagendra");
		
		WebElement eleGenAttrName = locateElement ("xpath", "//input[@id='createContactForm_generalAttnName']");
		type(eleGenAttrName, "Nagend");
		WebElement eleGenCity = locateElement("id", "createContactForm_generalCity");
		type(eleGenCity, "Chennai");
		WebElement eleGenPostal = locateElement ("id", "createContactForm_generalPostalCode");
		type (eleGenPostal, "583101");
		WebElement elePostExtn = locateElement ("name", "generalPostalCodeExt");
		type(elePostExtn, "044");
		WebElement eleCountry = locateElement ("id", "createContactForm_generalCountryGeoId");
		selectDropDownUsingIndex(eleCountry, 2);
		WebElement eleClick = locateElement ("xpath", "//input[@class='smallSubmit']");
		click(eleClick);
		WebElement eleSmallClick = locateElement ("linkText", "Edit");
		click(eleSmallClick);
		WebElement eleAddMarketingCamp = locateElement("id","addMarketingCampaignForm_marketingCampaignId");
		selectDropDownUsingIndex(eleAddMarketingCamp, 3);
		
		Select newM = new Select(eleAddMarketingCamp);
		WebElement firstSelectedOption = newM.getFirstSelectedOption();
		String eleMarket = firstSelectedOption.getText();
		
		WebElement add = locateElement("xpath", "//input[@value='Add']");
		click(add);
		WebElement update = locateElement ("xpath", "//input[@value='Update']");
		click(update);
		
		WebElement eleMarkcam = locateElement ("xpath", "//span[text()='Catalog Generating Marketing Campaigns']");
		String eMark = eleMarkcam.getText();
		
		verifyPartialText (eleMarkcam, eleMarket);
		closeBrowser();
	
	}
	
}