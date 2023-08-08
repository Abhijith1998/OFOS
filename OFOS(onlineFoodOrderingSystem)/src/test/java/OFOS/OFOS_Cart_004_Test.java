package OFOS;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.LogStatus;

import generic.Base_Test;
import pom_scripts.DishesPage;
import pom_scripts.HomePage;
import pom_scripts.RestaurantsPage;

public class OFOS_Cart_004_Test extends Base_Test{
	@Test
	public void addToCartFromRestaurant() throws Throwable {
		OFOS_Login_002_Test loginTest=new OFOS_Login_002_Test();
		loginTest.login(getValueProperty("username"), getValueProperty("password"));
		HomePage homePage=new HomePage(driver);
		homePage.getRestaurantLink().click();
		RestaurantsPage restaurantPage=new RestaurantsPage(driver);
		restaurantPage.getViewMenuButtons().get(0).click();
		DishesPage dishesPage=new DishesPage(driver);
		dishesPage.getAddToCartButtonOfAllItems().get(1).click();
		try {
			Assert.assertEquals(dishesPage.getAllItemsNameInYourCartItems().get(0).getText(), dishesPage.getAllItemsName().get(1).getText());
			test.log(LogStatus.PASS, dishesPage.getAllItemsName().get(1).getText()+" is added to cart");
			test.log(LogStatus.PASS, test.addScreenCapture(getPhoto(driver)));
		} catch (Exception e) {
			test.log(LogStatus.FAIL, dishesPage.getAllItemsName().get(1).getText()+" is failed to add to cart");
		}
	}
}
