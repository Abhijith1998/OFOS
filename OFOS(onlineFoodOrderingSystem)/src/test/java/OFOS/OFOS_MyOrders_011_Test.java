package OFOS;

import org.openqa.selenium.Alert;
import org.openqa.selenium.ElementClickInterceptedException;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.LogStatus;

import generic.Base_Test;
import pom_scripts.DishesPage;
import pom_scripts.MyOrdersPage;

public class OFOS_MyOrders_011_Test extends Base_Test {
	@Test
	public void placeOrderViaPaypal() throws Throwable {
		OFOS_Cart_004_Test cartTest = new OFOS_Cart_004_Test();
		cartTest.addToCartFromRestaurant();
		DishesPage dishesPage = new DishesPage(driver);
		dishesPage.getCheckoutButton().click();
		MyOrdersPage myOrdersPage = new MyOrdersPage(driver);
		try {
			myOrdersPage.getOnlinePaymentRadioButton().click();
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
	}
}
