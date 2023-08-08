package OFOS;

import org.openqa.selenium.Alert;
import org.openqa.selenium.ElementClickInterceptedException;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.LogStatus;

import generic.Base_Test;
import pom_scripts.DishesPage;
import pom_scripts.HomePage;
import pom_scripts.MyOrdersPage;

public class OFOS_MyOrders_019_Test extends Base_Test{
	@Test
	public void placeOrderFromHeavenlyFoodRestaurant() throws Throwable {
		OFOS_Login_002_Test loginTest=new OFOS_Login_002_Test();
		loginTest.login(getValueProperty("username"), getValueProperty("password"));
		HomePage homePage=new HomePage(driver);
		homePage.getHEAVENLYFOODLink().click();
		test.log(LogStatus.INFO, "clicked on "+homePage.getHEAVENLYFOODLink().getText()+" link");
		try {
			homePage.getAvailableRestaurants().get(0).click();
			test.log(LogStatus.INFO, "Clicked on "+homePage.getAvailableRestaurants().get(0).getText()+" restaurant");
			DishesPage dishesPage = new DishesPage(driver);
			dishesPage.getCheckoutButton().click();
			MyOrdersPage myOrdersPage = new MyOrdersPage(driver);
			try {
				myOrdersPage.getOrderNowButton().click();
				Alert alert = driver.switchTo().alert();
				alert.getText();
				alert.accept();
				alert.accept();
				int itemOrdered = myOrdersPage.getNameOfAllItems().size();
				try {
					Assert.assertEquals(itemOrdered >= 1, true);
					test.log(LogStatus.PASS, "order placed successfully");
					test.log(LogStatus.INFO, test.addScreenCapture(getPhoto(driver)));
				} catch (Exception e) {
					test.log(LogStatus.FAIL, "order is not placed");
					test.log(LogStatus.INFO, test.addScreenCapture(getPhoto(driver)));
				}
			} catch (ElementClickInterceptedException e) {
				test.log(LogStatus.FAIL, "Unable to select paypal radio button");
				test.log(LogStatus.INFO, test.addScreenCapture(getPhoto(driver)));
			}
		} catch (ElementClickInterceptedException e) {
			test.log(LogStatus.INFO, "No restaurant is available");
			test.log(LogStatus.INFO, test.addScreenCapture(getPhoto(driver)));
		}
	}
}
