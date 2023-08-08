package OFOS;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.LogStatus;

import generic.Base_Test;
import generic.ReadExcel;
import pom_scripts.RegisterPage;
import pom_scripts.WelcomePage;

public class OFOS_Register_001_Test extends Base_Test{
	
	@DataProvider(name = "testdata")
	public Object[][] testData() throws IOException {
		Object[][] data = ReadExcel.getMultipleData("register");
			return data;
	}
	@Test(dataProvider = "testdata")
	public void register(String username,String firstname,String lastname,String email,String phoneNumber,String password,String confPassword,String address) throws InterruptedException {
		WelcomePage welcomePage=new WelcomePage(driver);
		welcomePage.getRegisterLink().click();
		try {
			Assert.assertEquals(driver.getTitle(), "Registration");
			test.log(LogStatus.PASS, "Register page is displayed");
		} catch (Exception e) {
			test.log(LogStatus.FAIL, "Register page is not displayed");
		}
		RegisterPage registerPage=new RegisterPage(driver);
		registerPage.getUserNameTF().sendKeys(username);
		registerPage.getFirstNameTF().sendKeys(firstname);
		registerPage.getLastNameTF().sendKeys(lastname);
		registerPage.getEmailTF().sendKeys(email);
		registerPage.getPhoneNumberTF().sendKeys(phoneNumber);
		registerPage.getPasswordTF().sendKeys(password);
		registerPage.getConfirmPasswordTF().sendKeys(confPassword);
		registerPage.getAddressTextArea().sendKeys(address);
		registerPage.getRegisterButton().click();
		try {
			Assert.assertEquals(driver.getTitle(), "Login");
			test.log(LogStatus.PASS, "User Succesfully Registered");
		} catch (Exception e) {
			test.log(LogStatus.FAIL, "User failed to register or user already exist");
		}
	}
}
