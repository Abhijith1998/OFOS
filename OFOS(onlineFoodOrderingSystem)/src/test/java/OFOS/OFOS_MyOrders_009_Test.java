package OFOS;

import org.apache.poi.ss.formula.functions.Count;
import org.openqa.selenium.Alert;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.LogStatus;

import generic.Base_Test;
import pom_scripts.MyOrdersPage;

public class OFOS_MyOrders_009_Test extends Base_Test {
	@Test
	public void deleteOrder() throws Throwable {
		OFOS_MyOrders_006_Test myOrdersPageTest=new OFOS_MyOrders_006_Test();
		myOrdersPageTest.placeOrderViaCod();
		MyOrdersPage myOrdersPage=new MyOrdersPage(driver);
		int countBeforeCancellingOrder = myOrdersPage.getDeleteButtonofAllItems().size();
//		System.out.println(countBeforeCancellingOrder);
		myOrdersPage.getDeleteButtonofAllItems().get(0).click();
//		Thread.sleep(2000);
		Alert alert = driver.switchTo().alert();
		alert.accept();
		try {
			int countAfterCancellingOrder = myOrdersPage.getDeleteButtonofAllItems().size();
//			System.out.println(countAfterCancellingOrder);
			Assert.assertEquals(countBeforeCancellingOrder==countAfterCancellingOrder, true);
			test.log(LogStatus.FAIL, "Order is not cancelled");
			test.log(LogStatus.INFO , test.addScreenCapture(getPhoto(driver)));
		} catch (NoSuchElementException e) {
			test.log(LogStatus.PASS, "Order cancelled successfully");
			test.log(LogStatus.INFO , test.addScreenCapture(getPhoto(driver)));
		}catch (AssertionError e) {
			test.log(LogStatus.PASS, "Order is cancelled successfully");
			test.log(LogStatus.INFO , test.addScreenCapture(getPhoto(driver)));
		}	
	}
}
