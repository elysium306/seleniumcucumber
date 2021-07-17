package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utilities.Driver;

public class LogOutPage {
	 public final String LogOutConfirmationPageTitle = "Confirm Log Out?";

	    public LogOutPage() {
	        PageFactory.initElements(Driver.getDriver(),this);
	    }

	    @FindBy(xpath = "//button[text()='Logout']")
	    public WebElement logOutBtn;

	    @FindBy(css = "[class=\"form-signin-heading\"]")
	    public WebElement confirmLogoutText;

	    @FindBy(xpath="//button[text()='Log Out']")
	    public WebElement logoutConfirmationButton;

	    @FindBy(xpath="//div[text()='You have been signed out']")
	    public WebElement alertSignedOutText;
}
