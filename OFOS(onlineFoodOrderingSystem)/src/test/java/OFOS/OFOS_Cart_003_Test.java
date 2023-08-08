package OFOS;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.LogStatus;

import generic.Base_Test;
import pom_scripts.DishesPage;
import pom_scripts.HomePage;

public class OFOS_Cart_003_Test extends Base_Test{
	@Test
	public void addTocartFromHome() throws Throwable {
		OFOS_Login_002_Test loginTest=new OFOS_Login_002_Test();
		loginTest.login(getValueProperty("username"), getValueProperty("password"));
		HomePage homePage=new HomePage(driver);
		homePage.getAllOrdernowButton().get(0).click();
		DishesPage dp=new DishesPage(driver);
		dp.getAddToCartButtonOfAllItems().get(0).click();
		try {
			Assert.assertEquals(dp.getCheckoutButton().isEnabled(), true);
			test.log(LogStatus.PASS, dp.getAllItemsName().get(0).getText()+" is added to cart successfully");
			test.log(LogStatus.PASS, test.addScreenCapture(getPhoto(driver)));
		} catch (Exception e) {
			test.log(LogStatus.PASS, dp.getAllItemsName().get(0).getText()+" is failed to add into cart");
		}
	}
}