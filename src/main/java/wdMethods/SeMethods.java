package wdMethods;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.Alert;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.Select;

import extenthtmlreporter.ReadExcelDataProvider;
import extenthtmlreporter.Reporter;

public class SeMethods extends Reporter implements WdMethods {

	public static RemoteWebDriver driver;
	int i = 1;

	public void startApp(String browser, String url) {
		try {
			if (browser.equalsIgnoreCase("chrome")) {
				System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");
				driver = new ChromeDriver();
			} else if (browser.equalsIgnoreCase("firefox")) {
				System.setProperty("webdriver.gecko.driver", "./drivers/geckoriver.exe");
				driver = new FirefoxDriver();
			}
			driver.manage().window().maximize();
			driver.get(url);
			driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		} catch (WebDriverException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("The Browser " + browser + " is Launched Successfully");
		takeSnap();

	}

	public WebElement locateElement(String locator, String locValue) {
		try {
			switch (locator) {
			case "id":
				return driver.findElementById(locValue);
			case "class":
				return driver.findElementByClassName(locValue);
			case "xpath":
				return driver.findElementByXPath(locValue);
			case "linkText":
				return driver.findElementByLinkText(locValue);
			case "name":
				return driver.findElementByName(locValue);
			}
		} catch (Exception e) {
			System.err.println("Exception has occurred");
			throw new RuntimeException();
		}
		return null;
	}

	public WebElement locateElement(String locValue) {
		return driver.findElementById(locValue);
	}

	public void type(WebElement ele, String data) {
		try {
			ele.sendKeys(data);
			System.out.println("The Data " + data + " is Entered Successfully");
		} catch (WebDriverException e) {
			// TODO Auto-generated catch block
			System.out.println("Web Driver Exception has ocurred");
			throw new RuntimeException();
		} catch (Exception e) {
			System.out.println("An Exception has occurred ");
			throw new RuntimeException();
		} finally {
			takeSnap();
		}
	}

	public void click(WebElement ele) {
		try {
			ele.click();
			System.out.println("The Element " + ele + " is clicked Successfully");
		} catch (WebDriverException e) {
			// TODO Auto-generated catch block
			System.err.println("WebDriver Exception has occurred");
			throw new RuntimeException();
		} finally {
			takeSnap();
		}
	}

	public String getText(WebElement ele) throws NullPointerException {
		// TODO Auto-generated method stub
		try {
			System.out.println("the text returned is " + ele.getText());
		} finally {
			takeSnap();
		}

		return null;
	}

	public void selectDropDownUsingText(WebElement ele, String value) {
		// TODO Auto-generated method stub
		try {
			Select dd = new Select(ele);
			dd.selectByVisibleText(value);
		} catch (Exception e) {
			System.out.println(e);
			throw new RuntimeException();
		} finally {
			takeSnap();
		}

	}

	public void selectDropDownUsingIndex(WebElement ele, int index) {
		// TODO Auto-generated method stub
		Select ind = new Select(ele);
		ind.selectByIndex(index);
		System.out.println("The element" + ele + "has been selected by index");
		takeSnap();
	}

	public boolean verifyTitle(String expectedTitle) {
		// TODO Auto-generated method stub
		String actualTitle = driver.getTitle();
		if (actualTitle == expectedTitle) {
			System.out.println("The actual Title matches with the expected Title");
			takeSnap();
			return true;
		} else {
			System.out.println("The actual Title does not with match the expected Title");
			takeSnap();
			return false;
		}

	}

	public void verifyExactText(WebElement ele, String expectedText) {

		String actualText = ele.getText();
		if (actualText == expectedText) {
			System.out.println("the expected text matches with the returned text");
		} else {
			System.out.println("The expected Text does not match with the returned text");
		}
		takeSnap();
	}

	public void verifyPartialText(WebElement ele, String expectedText) {
		// TODO Auto-generated method stub
		String actualText = ele.getText();
		if (actualText.contains(expectedText)) {
			System.out.println("Expected Text" +expectedText +" is present in the acutal Text");
		} else {
			System.out.println("Expected Text " +expectedText + "is not present in the acutal Text");

		}
		takeSnap();
	}

	public void verifyExactAttribute(WebElement ele, String attribute, String value) {
		// TODO Auto-generated method stub
		if (ele.getAttribute(attribute) == value) {
			System.out.println("the attribute value matches with the expected attribute value ");
		} else {
			System.out.println("The attribute value does not match with the expected attribute value");
		}

	}

	public void verifyPartialAttribute(WebElement ele, String attribute, String value) {
		// TODO Auto-generated method stub
		if (ele.getAttribute(attribute).contains(value)) {
			System.out.println("the attribute value contains the expected attribute value");
		} else {
			System.out.println("the attribute value does not contain the expected attribute value");
		}
		takeSnap();
	}

	public void verifySelected(WebElement ele) {
		// TODO Auto-generated method stub
		if (ele.isSelected()) {
			System.out.println("The element " + ele + "is selected");
		} else {
			System.out.println("the element is not selected");
		}
		takeSnap();

	}

	public void verifyDisplayed(WebElement ele) {
		// TODO Auto-generated method stub
		if (ele.isDisplayed()) {
			System.out.println("The element " + ele + "is displayed");
		} else {
			System.out.println("the element is not displayed");
		}
		takeSnap();
	}

	public void switchToWindow(int index) {
		String parentHandle = driver.getWindowHandle();
		Set<String> allWindowHandles = driver.getWindowHandles() ;
		//driver.switchTo().window(arg0)
		List<String> allHandles = new ArrayList<String>();
		allHandles.addAll(allWindowHandles);
		driver.switchTo().window(allHandles.get(index));
		//allHandles = 
		//System.out.println("Count of windows:"+allWindowHandles.size());
		//driver.switchTo().window(parentHandle);

	}

	public void switchToFrame(WebElement ele) {
		driver.switchTo().frame(ele);
		System.out.println("the frame has been switched to the element " + ele);
		// TODO Auto-generated method stub

	}

	public void acceptAlert() {
		// TODO Auto-generated method stub
		driver.switchTo().alert().accept();
		// myalert.accept();

	}

	public void dismissAlert() {
		// TODO Auto-generated method stub
		driver.switchTo().alert().dismiss();

	}

	public String getAlertText() {
		// TODO Auto-generated method stub
		String alertText = driver.switchTo().alert().getText();
		return alertText;
	}

	public void takeSnap() {
		File src = driver.getScreenshotAs(OutputType.FILE);
		File desc = new File("./snaps/img" + i + ".png");
		try {
			FileUtils.copyFile(src, desc);
		} catch (IOException e) {
			e.printStackTrace();
		}
		i++;
	}

	public void closeBrowser() {
		// TODO Auto-generated method stub
		driver.close();

	}

	public void closeAllBrowsers() {
		// TODO Auto-generated method stub
		driver.quit();

	}

}
