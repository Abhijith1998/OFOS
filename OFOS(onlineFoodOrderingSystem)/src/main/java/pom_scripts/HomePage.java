package pom_scripts;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage extends BasePage{

	public HomePage(WebDriver driver) {
		super(driver);
	}
	
	@FindBy(linkText = "Logout")
	private WebElement logoutLink;
	
	@FindBy(partialLinkText = "Restaurants")
	private WebElement restaurantLink;
	
	@FindBy(linkText = "My Orders")
	private WebElement myOrdersLink;
	
	@FindBy(partialLinkText = "Home")
	private WebElement homeLink;
	
	public WebElement getRestaurantLink() {
		return restaurantLink;
	}

	public WebElement getMyOrdersLink() {
		return myOrdersLink;
	}

	public WebElement getHomeLink() {
		return homeLink;
	}

	//popular Dishes Heading element
	@FindBy(xpath = "//div[contains(@class,'title text')]/h2")
	private WebElement popularDishesHeading;
	
	@FindBy(xpath = "(//div[@class=\"row\"])[1]/div/div/div[2]/h5")
	private List<WebElement> allPopularDishesHeading;
	
	@FindBy(xpath = "//a[text()='Order Now']")
	private List<WebElement> allOrdernowButton;
	
	@FindBy(partialLinkText = "all")
	private WebElement allLink;
	
	@FindBy(partialLinkText = "Continental")
	private WebElement ContinentalLink;
	
	@FindBy(partialLinkText = "Italian")
	private WebElement ItalianLink;
	
	@FindBy(partialLinkText = "Chinese")
	private WebElement ChineseLink;
	
	@FindBy(partialLinkText = "American")
	private WebElement AmericanLink;
	
	@FindBy(partialLinkText = "South Indian")
	private WebElement SouthIndianLink;
	
	@FindBy(partialLinkText = "North Indian")
	private WebElement NorthIndianLink;
	
	@FindBy(partialLinkText = "HELL")
	private WebElement HELLLink;
	
	@FindBy(partialLinkText = "Heavenly Food")
	private WebElement HEAVENLYFOODLink;
	
	@FindBy(partialLinkText ="Auth0")
	private WebElement Auth0Link;
	
	//to click on title of the dishes or links instead order now
	@FindBy(xpath = "//div[@class='content']/h5/a")
	private List<WebElement> nameOfAllPopularDishesLink;
	
	@FindBy(xpath = "//div[contains(@class,'restaurant-wrap')]//h5/a")
	private List<WebElement> availableRestaurants;

	public List<WebElement> getAvailableRestaurants() {
		return availableRestaurants;
	}

	public WebElement getPopularDishesHeading() {
		return popularDishesHeading;
	}

	public List<WebElement> getAllPopularDishesHeading() {
		return allPopularDishesHeading;
	}

	public List<WebElement> getAllOrdernowButton() {
		return allOrdernowButton;
	}

	public WebElement getAllLink() {
		return allLink;
	}

	public WebElement getContinentalLink() {
		return ContinentalLink;
	}

	public WebElement getItalianLink() {
		return ItalianLink;
	}

	public WebElement getChineseLink() {
		return ChineseLink;
	}

	public WebElement getAmericanLink() {
		return AmericanLink;
	}

	public WebElement getSouthIndianLink() {
		return SouthIndianLink;
	}

	public WebElement getNorthIndianLink() {
		return NorthIndianLink;
	}

	public WebElement getHELLLink() {
		return HELLLink;
	}

	public WebElement getHEAVENLYFOODLink() {
		return HEAVENLYFOODLink;
	}

	public WebElement getAuth0Link() {
		return Auth0Link;
	}

	public List<WebElement> getNameOfAllPopularDishesLink() {
		return nameOfAllPopularDishesLink;
	}

	public WebElement getLogoutLink() {
		return logoutLink;
	}
	
}
