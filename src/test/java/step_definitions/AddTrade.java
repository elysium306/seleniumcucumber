package step_definitions;

import java.util.ArrayList;
import java.util.List;

import org.junit.Assert;
import org.openqa.selenium.WebElement;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.TradeAppPage;
import utilities.BrowserUtils;
import utilities.DBUtils;
import utilities.Driver;
import utilities.PropertiesReader;

public class AddTrade {
	BrowserUtils utils = new BrowserUtils();
	TradeAppPage tradepage = new TradeAppPage();
	DBUtils dbutils = new DBUtils();
	
	String inputSymbol;
	String inputEntryPrice;
	String inputExitPrice;
	
	@Given("I am on the app log in page")
	public void I_am_on_the_app_log_in_page() {
	    Driver.getDriver().get(PropertiesReader.getProperty("tradeAppUrl"));
	    utils.waitUntilElementVisible(tradepage.username);
	    Assert.assertTrue(tradepage.username.isDisplayed());
	}
	
	@When("I enter valid username {string} and password {string}")
	public void i_enter_valid_username_and_password(String username, String password) {
		tradepage.username.sendKeys(username);
		tradepage.password.sendKeys(password);
	}
	
	@When("I click on trade signin button")
	public void i_click_on_trade_signin_button() {
	    tradepage.signinBtn.click();
	}
	
	@Then("I should be in the trade homepage")
	public void i_should_be_in_the_trade_homepage() {
	   utils.waitUntilElementVisible(tradepage.addTradeBtn);
	   Assert.assertTrue(tradepage.addTradeBtn.isDisplayed());
	}
	
	@When("I click on Add Trade button")
	public void i_click_on_add_trade_button() {
	    tradepage.addTradeBtn.click();
	}
	
	@Then("I should be on Save Trade Form")
	public void i_should_be_on_save_trade_form() {
	   utils.waitUntilElementVisible(tradepage.buyOrSellDropdown);
	   Assert.assertTrue(tradepage.buyOrSellDropdown.isDisplayed());
	}
	
	@When("I select {string} and enter symble {string} entrydate {string} entryprice {string} exitdate {string} exitprice {string}")
	public void i_select_and_enter_symble_entrydate_entryprice_exitdate_exitprice(
			String buyToOpen, String symbol, String entryDate, String entryPrice, String exitDate, String exitPrice) {
		
		inputSymbol = symbol;
		
	   BrowserUtils.selectByVisibleText(tradepage.buyOrSellDropdown, buyToOpen);
	   tradepage.tradeSymbol.sendKeys(symbol);
	   tradepage.entryDate.sendKeys(entryDate);
	   tradepage.entryPrice.sendKeys(entryPrice);
	   tradepage.exitDate.sendKeys(exitDate);
	   tradepage.exitPrice.sendKeys(exitPrice);
	   
	}
	
	@When("I click save button")
	public void i_click_save_button() throws InterruptedException {
	 tradepage.addTradeSaveBtn.click();
	 Thread.sleep(2000);
	}
	
	@Then("the trade is displayed in the trade table")
	public void the_trade_is_displayed_in_the_trade_table() {
	   utils.waitUntilElementVisible(tradepage.anyRowStockSymbol.get(0));
	   
	   for ( WebElement element : tradepage.anyRowStockSymbol) {
		   String actualStockSymbol = element.getText();
		   boolean flag = false;
		   if (actualStockSymbol.equals(inputSymbol)) {
			   flag = true;
			   Assert.assertTrue(flag);
			   break;
		}   
	}
	}
	
	@When("I enter following trade details")
	public void i_enter_following_trade_details(DataTable dataTable) {
		List<String> list = dataTable.asList();
		
		inputSymbol = list.get(1);
		inputEntryPrice = list.get(3);
		inputExitPrice = list.get(5);
		
		   BrowserUtils.selectByVisibleText(tradepage.buyOrSellDropdown, list.get(0));
		   tradepage.tradeSymbol.sendKeys(list.get(1));
		   tradepage.entryDate.sendKeys(list.get(2));
		   tradepage.entryPrice.sendKeys(list.get(3));
		   tradepage.exitDate.sendKeys(list.get(4));
		   tradepage.exitPrice.sendKeys(list.get(5));
	}
	
	// add trade and validate database
	
	@Then("the trade input matches with the database record")
	public void the_trade_input_matches_with_the_database_record() {
		String selectQuery = "SELECT * FROM records WHERE symbol='"+inputSymbol+"'";
	    List<String> list = dbutils.selectARecord(selectQuery);
//	    System.out.println(list.get(3));
//	    System.out.println(list.get(5));
//	    System.out.println(list.get(7));
//	    
//	    System.out.println(inputSymbol);
//	    System.out.println(inputEntryPrice);
//	    System.out.println(inputExitPrice);
	    
	    Assert.assertEquals(list.get(3), inputSymbol);
	    Assert.assertEquals(list.get(5), inputEntryPrice);
	    Assert.assertEquals(list.get(7), inputExitPrice);
	    
	}
	
	
	// database to UI test
	@Given("I insert the following record to database")
	public void i_insert_the_following_record_to_database(DataTable dataTable) {
		List<String> list = dataTable.asList();
		
		inputSymbol = list.get(3);
		inputEntryPrice = list.get(5);
		inputExitPrice = list.get(7);
		
		String id = list.get(0);
		String user_id = list.get(1);
		String long_short = list.get(2);
		String symbol = list.get(3);
		String open_date = list.get(4);
		String entry_price = list.get(5);
		String close_date = list.get(6);
		String exit_price = list.get(7);
		String gain = list.get(8);
		
		String insertQuery = 
				"INSERT INTO records VALUES('"+id+"','"+user_id+"','"+long_short+"','"+symbol+"','"+open_date+"','"+entry_price+"','"+close_date+"','"+exit_price+"','"+gain+"')";
	System.out.println("Insert query is: " + insertQuery);
	dbutils.insertRecord(insertQuery);
	
	}

	
	@Then("the trade input displays on UI")
	public void the_trade_input_displays_on_ui() throws InterruptedException {
		utils.waitUntilElementVisible(tradepage.searchSymbol);
		tradepage.searchSymbol.sendKeys(inputSymbol);
		tradepage.searchButton.click();
		utils.waitUntilElementVisible(tradepage.searchTableFirstRow.get(0));
		
		List<String> list = new ArrayList<>();
		
		for (int i = 0; i < tradepage.searchTableFirstRow.size()-1; i++) {
			list.add(tradepage.searchTableFirstRow.get(i).getText());
		}
		
		String uiSymbol = list.get(1);
		String uiEntryPrice = list.get(3).substring(1);
		String uiExitPrice = list.get(5).substring(1);
		
//		System.out.println(uiSymbol);
//		System.out.println(uiEntryPrice);
//		System.out.println(uiExitPrice);
		
		Assert.assertEquals(uiSymbol, inputSymbol);
		Assert.assertEquals(uiEntryPrice, inputEntryPrice);
		Assert.assertEquals(uiExitPrice, inputExitPrice);
		
		
		String deleteQuery = "DELETE FROM records WHERE symbol='"+inputSymbol+"'";
		dbutils.deleteRecord(deleteQuery);
		
	}
}
