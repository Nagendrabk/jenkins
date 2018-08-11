package wdMethods;

import org.openqa.selenium.WebElement;
//import org.testng.annotations.BeforeMethod;
import org.testng.annotations.*;

public class Annotationsnew extends SeMethods {
@Parameters ({"url","uName", "pwd" } )
	@BeforeMethod ()
	public void start (String url, String uName, String pwd) {
	
		startApp("chrome", url);
		WebElement eleUserName = locateElement("id", "username");
		type(eleUserName, uName);
		WebElement elePassword = locateElement("id","password");
		type(elePassword, pwd);
	
	}
	@AfterMethod()
	public void stop() {
		closeAllBrowsers();
	}
}
