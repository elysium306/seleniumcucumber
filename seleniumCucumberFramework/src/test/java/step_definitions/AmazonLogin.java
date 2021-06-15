package step_definitions;

import org.junit.Assert;
import io.cucumber.java.en.And;
import io.cucumber.java.en.But;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.AmazonPage;
import utilities.BrowserUtils;
import utilities.Driver;
import utilities.PropertiesReader;

public class AmazonLogin {
	
	BrowserUtils utils = new BrowserUtils();
	AmazonPage amazonpage = new AmazonPage();
	
	
	@Given("I am on the amazon homepage")
	public void i_am_on_the_amazon_homepage() {
	    Driver.getDriver().get(PropertiesReader.getProperty("amazonURL"));
	}

	@Then("Sign in button is displayed")
	public void sign_in_button_is_displayed() {
	    Assert.assertTrue(amazonpage.signinSecurelyBtn.isDisplayed());
	}

	@When("I click on signin button")
	public void i_click_on_signin_button() {
	    amazonpage.signinSecurelyBtn.click();
	}

	@Then("I should be directed to login page")
	public void i_should_be_directed_to_login_page() {
	    utils.waitUntilElementVisible(amazonpage.signInText);
	    Assert.assertTrue(amazonpage.signInText.isDisplayed());
	}
	
	
	// the amazon invalid email test 
	
	@Given("I am on the amazon signin page")
	public void i_am_on_the_amazon_signin_page() {
		Driver.getDriver().get(PropertiesReader.getProperty("amazonURL"));
		amazonpage.signinSecurelyBtn.click();
		utils.waitUntilElementVisible(amazonpage.signInText);
		Assert.assertTrue(amazonpage.signInText.isDisplayed()); 
	}
	
	@When("I enter invalid user email {string}")
	public void i_enter_invalid_user_email(String invalidUserEmail) {
	    amazonpage.signInEmailField.sendKeys(invalidUserEmail);
	}
	
	@And("I clicked on continue button")
	public void i_clicked_on_continue_button() {
	   amazonpage.signInContinueBtn.click();
	}
	
	@Then("An error message {string} should display")
	public void an_error_message_should_display(String errorMessage) {
	   utils.waitUntilElementVisible(amazonpage.signInErrorMessageHeader);
	   String actualErrorMessageHeader = amazonpage.signInErrorMessageHeader.getText();
	   Assert.assertEquals(actualErrorMessageHeader, errorMessage);
	}
	
	@But("The password field should not display")
	public void the_password_field_should_not_display() {
	    Assert.assertFalse(amazonpage.signInPasswordField.isDisplayed());
	}

	

}
