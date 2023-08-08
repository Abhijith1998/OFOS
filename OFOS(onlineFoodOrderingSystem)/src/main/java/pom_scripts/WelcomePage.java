package pom_scripts;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class WelcomePage extends BasePage{
	
	public WelcomePage(WebDriver driver) {
		super(driver);
	}
	
	@FindBy(partialLinkText = "Home")
	private WebElement homeLink;
	
	@FindBy(partialLinkText = "Restaurants")
	private WebElement restaurantsLink;
	
	@FindBy(linkText = "Login")
	private WebElement loginLink;
	
	@FindBy(partialLinkText = "Register")
	private WebElement registerLink;
	
	public WebElement getHomeLink() {
		return homeLink;
	}

	public WebElement getRestaurantsLink() {
		return restaurantsLink;
	}

	public WebElement getLoginLink() {
		return loginLink;
	}

	public WebElement getRegisterLink() {
		return registerLink;
	}
}
