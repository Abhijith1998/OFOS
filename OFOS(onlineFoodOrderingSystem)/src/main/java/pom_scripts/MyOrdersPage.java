package pom_scripts;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import pom_scripts.BasePage;

public class MyOrdersPage extends BasePage{

	public MyOrdersPage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}

	//Name of all items
	@FindBy(xpath = "//td[@data-column='Item']")
	private List<WebElement> nameOfAllItems;

	//Delete buttons of all items
	@FindBy(xpath = "//a[contains(@onclick,'return confirm')]")
	private List<WebElement> deleteButtonofAllItems;
	
	//Dispatch button
	@FindBy(xpath = "//td[@data-column='status']//button")
	private List<WebElement> dispatchButtons;

	//Table header(Item )
	@FindBy(xpath = "//table[@class='table table-bordered table-hover']//th[text()='Item']" )
	private WebElement tableHeaderItem;
	
	@FindBy(xpath = "//input[@value='Order Now']")
	private WebElement orderNowButton;
	
	@FindBy(xpath = "//span[contains(text(),'Paypal')]/..//input[@type='radio']")
	private WebElement onlinePaymentRadioButton;
	
	@FindBy(xpath = "//input[@value='COD']")
	private WebElement codRadioButton;
	
	public WebElement getOrderNowButton() {
		return orderNowButton;
	}

	public WebElement getOnlinePaymentRadioButton() {
		return onlinePaymentRadioButton;
	}

	public WebElement getCodRadioButton() {
		return codRadioButton;
	}

	public WebElement getTableHeaderItem() {
		return tableHeaderItem;
	}

	public void setTableHeaderIte(WebElement tableHeaderItem) {
		this.tableHeaderItem = tableHeaderItem;
	}

	public void setDispatchButtons(List<WebElement> dispatchButtons) {
		this.dispatchButtons = dispatchButtons;
	}

	public List<WebElement> getDispatchButtons() {
		return dispatchButtons;
	}

	public void setNameOfAllItems(List<WebElement> nameOfAllItems) {
		this.nameOfAllItems = nameOfAllItems;
	}



	public void setDeleteButtonofAllItems(List<WebElement> deleteButtonofAllItems) {
		this.deleteButtonofAllItems = deleteButtonofAllItems;
	}



	public List<WebElement> getNameOfAllItems() {
		return nameOfAllItems;
	}

	

	public List<WebElement> getDeleteButtonofAllItems() {
		return deleteButtonofAllItems;
	}

}
