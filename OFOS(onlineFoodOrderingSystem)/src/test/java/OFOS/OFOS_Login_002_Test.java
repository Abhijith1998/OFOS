package OFOS;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.LogStatus;

import generic.Base_Test;
import generic.ReadExcel;
import pom_scripts.DishesPage;
import pom_scripts.HomePage;
import pom_scripts.LoginPage;
import pom_scripts.RestaurantsPage;
import pom_scripts.WelcomePage;

public class OFOS_Login_002_Test extends Base_Test{
	@DataProvider(name = "testdata")
	public Object[][] testData() throws IOException {
		Object[][] data = ReadExcel.getMultipleData("login");
			return data;
	}
	@Test(dataProvider = "testdata")
	public void login(String username, String passwoord) {
		WelcomePage welcomePage=new WelcomePage(driver);
		welcomePage.getLoginLink().click();
		LoginPage loginPage=new LoginPage(driver);
		loginPage.getUsernameTF().sendKeys(username);
		loginPage.getPasswordTF().sendKeys(passwoord);
		loginPage.getLoginButton().click();
		HomePage homePage=new HomePage(driver);
		try {
		  Assert.assertEquals(homePage.getLogoutLink().isDisplayed(), true);
		  test.log(LogStatus.PASS, "User is logged in");
		  test.log(LogStatus.PASS, test.addScreenCapture(getPhoto(driver)));
		  }catch (NoSuchElementException e) {
		  test.log(LogStatus.FAIL, "User is not logged in");
		}
	}
}
