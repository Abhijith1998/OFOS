package OFOS;

import org.openqa.selenium.Alert;
import org.openqa.selenium.ElementClickInterceptedException;
import org.openqa.selenium.ElementNotInteractableException;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.LogStatus;

import generic.Base_Test;
import generic.JavaScriptUtil;
import pom_scripts.DishesPage;
import pom_scripts.HomePage;
import pom_scripts.MyOrdersPage;

public class OFOS_MyOrders_015_Test extends Base_Test{
	@Test
	public void placeOrderFromAmericanRestaurant() throws Throwable {
		OFOS_Login_002_Test loginTest = new OFOS_Login_002_Test();
		loginTest.login(getValueProperty("username"), getValueProperty("password"));
		HomePage homePage = new HomePage(driver);
		JavaScriptUtil js = new JavaScriptUtil();
		js.jsScrollIntoView(true, homePage.getAmericanLink());
		homePage.getAmericanLink().click();
		System.out.println(homePage.getAvailableRestaurants().size());
		test.log(LogStatus.INFO, "clicked on "+homePage.getAmericanLink().getText()+" link");
//		for (int i = 0; i < homePage.getAvailableRestaurants().size(); i++) {
//			try {
//				homePage.getAvailableRestaurants().get(i).click();
//				break;
//			} catch (ElementClickInterceptedException e) {
//				e.printStackTrace();
//			} catch (ElementNotInteractableException e) {
//				e.printStackTrace();
//			}
//		}
		
		try {
			homePage.getAvailableRestaurants().get(0).click();
			DishesPage dishesPage = new DishesPage(driver);
			dishesPage.getAddToCartButtonOfAllItems().get(0).click();
			dishesPage.getCheckoutButton().click();
			MyOrdersPage myOrdersPage = new MyOrdersPage(driver);
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
		} catch (Exception e) {
			test.log(LogStatus.INFO, "Restaurant or dish is not available");
			test.log(LogStatus.INFO, test.addScreenCapture(getPhoto(driver)));
		}
	}
}
