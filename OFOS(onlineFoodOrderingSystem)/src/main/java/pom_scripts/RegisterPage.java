package pom_scripts;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class RegisterPage extends BasePage{

	public RegisterPage(WebDriver driver) {
		super(driver);
	}

	//Username text field
	@FindBy(xpath = "//input[@name='username']")
	private WebElement userNameTF;

	//First name text field
	@FindBy(xpath = "//input[@name='firstname']")
	private WebElement firstNameTF;

	//Last name text field
	@FindBy(xpath = "//input[@name='lastname']")
	private WebElement lastNameTF;

	//email text field
	@FindBy(xpath = "//input[@name='email']")
	private WebElement emailTF;

	//phone number text field
	@FindBy(xpath = "//input[@name='phone']")
	private WebElement phoneNumberTF;

	//password text field
	@FindBy(xpath = "//input[@name='password']")
	private WebElement passwordTF;

	//Confirm password  text field
	@FindBy(xpath = "//input[@name='cpassword']")
	private WebElement confirmPasswordTF;

	//Address text Area
	@FindBy(xpath = "//textarea[@id='exampleTextarea']")
	private WebElement addressTextArea;

	//register button
	@FindBy(xpath = "//input[@name='submit']")
	private WebElement registerButton;

	public WebElement getUserNameTF() {
		return userNameTF;
	}

	public WebElement getFirstNameTF() {
		return firstNameTF;
	}

	public WebElement getLastNameTF() {
		return lastNameTF;
	}

	public WebElement getEmailTF() {
		return emailTF;
	}

	public WebElement getPhoneNumberTF() {
		return phoneNumberTF;
	}

	public WebElement getPasswordTF() {
		return passwordTF;
	}

	public WebElement getConfirmPasswordTF() {
		return confirmPasswordTF;
	}

	public WebElement getAddressTextArea() {
		return addressTextArea;
	}

	public WebElement getRegisterButton() {
		return registerButton;
	}
	
}
