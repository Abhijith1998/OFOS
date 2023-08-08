package OFOS;

import org.openqa.selenium.Alert;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.LogStatus;

import generic.Base_Test;
import pom_scripts.DishesPage;
import pom_scripts.MyOrdersPage;

public class OFOS_MyOrders_010_Test extends Base_Test{
	@Test
	public void placeOrderFromRestaurantViaCod() throws Throwable {
		OFOS_Cart_004_Test cartTest=new OFOS_Cart_004_Test();
		cartTest.addToCartFromRestaurant();
		DishesPage dishesPage=new DishesPage(driver);
		dishesPage.getCheckoutButton().click();
		MyOrdersPage myOrdersPage=new MyOrdersPage(driver);
//		myOrdersPage.getCodRadioButton().click();
		myOrdersPage.getOrderNowButton().click();
		Alert alert = driver.switchTo().alert();
		alert.getText();
		alert.accept();
		alert.accept();
		int itemOrdered = myOrdersPage.getNameOfAllItems().size();
		try {
			Assert.assertEquals(itemOrdered>=1, true);
			test.log(LogStatus.PASS, "order placed successfully");
			test.log(LogStatus.INFO, test.addScreenCapture(getPhoto(driver)));
		} catch (Exception e) {
			test.log(LogStatus.FAIL, "order is not placed");
			test.log(LogStatus.INFO, test.addScreenCapture(getPhoto(driver)));
		}
	}
}
