package OFOS;

import org.openqa.selenium.Alert;
import org.openqa.selenium.ElementClickInterceptedException;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.LogStatus;

import generic.Base_Test;
import pom_scripts.DishesPage;
import pom_scripts.MyOrdersPage;

public class OFOS_MyOrders_007_Test extends Base_Test{
	@Test
	public void placeOrderViaPaypal() throws Throwable {
		OFOS_Cart_003_Test cartTest=new OFOS_Cart_003_Test();
		cartTest.addTocartFromHome();
		DishesPage dishesPage=new DishesPage(driver);
		dishesPage.getCheckoutButton().click();
		MyOrdersPage myOrdersPage=new MyOrdersPage(driver);
		try {
			myOrdersPage.getOnlinePaymentRadioButton().click();
			myOrdersPage.getOrderNowButton().click();
			Alert alert = driver.switchTo().alert();
			alert.accept();
			try {
				Assert.assertEquals(alert.getText().contains("Order has been placed"), true);
				test.log(LogStatus.PASS, "Order has been placed successfully");
				alert.accept();
				test.log(LogStatus.PASS, test.addScreenCapture(getPhoto(driver)));
			} catch (Exception e) {
				test.log(LogStatus.FAIL, "Order not placed");
			}
		} catch (ElementClickInterceptedException e) {
			test.log(LogStatus.FAIL, "unable to click on paypal radio button");
			test.log(LogStatus.FAIL, test.addScreenCapture(getPhoto(driver)));
		}	
	}
}
