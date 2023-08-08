package OFOS;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.LogStatus;

import generic.Base_Test;
import pom_scripts.MyOrdersPage;

public class OFOS_MyOrders_008_Test extends Base_Test{
	@Test
	public void dispatchOrder() throws Throwable {
		OFOS_MyOrders_006_Test myOrdersPageTest=new OFOS_MyOrders_006_Test();
		myOrdersPageTest.placeOrderViaCod();
		MyOrdersPage myOrdersPage=new MyOrdersPage(driver);
		myOrdersPage.getDispatchButtons().get(0).click();
		try {
			Assert.assertEquals(driver.getTitle().contains("Dispatch"), true);
			test.log(LogStatus.PASS, "Dispatch details are displayed");
		} catch (AssertionError e) {
			test.log(LogStatus.FAIL, "Dispatch details are not displayed");
			test.log(LogStatus.INFO, test.addScreenCapture(getPhoto(driver)));
		}
	}
}