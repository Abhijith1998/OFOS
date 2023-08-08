package pom_scripts;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends BasePage {
	
	public LoginPage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}

	//User name text field
	@FindBy(xpath = "//input[@name='username']")
	private WebElement usernameTF;

	//Password text field
	@FindBy(xpath = "//input[@name='password']")
	private WebElement passwordTF;

	//login button
	@FindBy(xpath = "//input[@name='submit']")
	private WebElement loginButton;

	//login page heading
	@FindBy(xpath = "//div[@class='form']//h2")
	private WebElement loginPageHeading;

	public WebElement getUsernameTF() {
		return usernameTF;
	}

	public WebElement getPasswordTF() {
		return passwordTF;
	}

	public WebElement getLoginButton() {
		return loginButton;
	}

	public WebElement getLoginPageHeading() {
		return loginPageHeading;
	}
}
