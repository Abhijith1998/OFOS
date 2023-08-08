package OFOS;

import org.openqa.selenium.NoSuchElementException;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.LogStatus;

import generic.Base_Test;
import pom_scripts.HomePage;
import pom_scripts.WelcomePage;

public class OFOS_Logout_020_Test extends Base_Test{
	@Test
	public void logout() throws Throwable {
		OFOS_Login_002_Test login=new OFOS_Login_002_Test();
		login.login(getValueProperty("username"), getValueProperty("password"));
		HomePage homePage=new HomePage(driver);
		WelcomePage welcomePage=new WelcomePage(driver);
		homePage.getLogoutLink().click();
		test.log(LogStatus.PASS, "Clicked on logout");
		try {
			Assert.assertEquals(welcomePage.getLoginLink().isDisplayed(), true);
			test.log(LogStatus.INFO, test.addScreenCapture(getPhoto(driver)));
			test.log(LogStatus.PASS, "Successfully loged out");
		} catch (NoSuchElementException e) {
			test.log(LogStatus.FAIL, "failed to logout");
		}	
	}
}
