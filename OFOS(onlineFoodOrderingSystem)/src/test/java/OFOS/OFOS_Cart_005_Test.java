package OFOS;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.LogStatus;

import generic.Base_Test;
import pom_scripts.DishesPage;

public class OFOS_Cart_005_Test extends Base_Test{
	@Test
	public void deleteDishFromCart() throws Throwable {
		OFOS_Login_002_Test loginTest=new OFOS_Login_002_Test();
		loginTest.login(getValueProperty("username"), getValueProperty("password"));
		OFOS_Cart_004_Test cartTest=new OFOS_Cart_004_Test();
		cartTest.addToCartFromRestaurant();
		DishesPage dishesPage=new DishesPage(driver);
		test.log(LogStatus.INFO,test.addScreenCapture(getPhoto(driver)));
		dishesPage.getDeleteButtonsOfAllYourcartItems().get(0).click();
		try {
			Assert.assertEquals(dishesPage.getDeleteButtonsOfAllYourcartItems().get(0).isDisplayed(), true);
			test.log(LogStatus.FAIL, "unable to delete the dish ");
		} catch (Exception e) {
			test.log(LogStatus.PASS, "Dish deleted successfully");
			test.log(LogStatus.PASS, test.addScreenCapture(getPhoto(driver)));
		}
	}
}
