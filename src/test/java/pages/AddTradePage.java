package pages;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utilities.Driver;

public class AddTradePage {
	   public AddTradePage() {
	        PageFactory.initElements(Driver.getDriver(),this);
	    }
	    @FindBy(id = "username")
		public WebElement username;
		@FindBy(id = "password")
		public WebElement password;
		@FindBy(xpath = "//button[text()='Sign in']")
		public WebElement signinBtn;
		@FindBy(linkText = "Add trade")
		public WebElement addTradeBtn;
		@FindBy(xpath = "//a[@class=\"btn btn-info btn-sm\"][@href=\"/records/showFormForUpdate?recordId=24\"]")
		public WebElement updateTrade;
		@FindBy(id = "longTrade")
		public WebElement buyOrSellDropdown;
		@FindBy(id = "symbol")
		public WebElement tradeSymbol;
		@FindBy(id = "openDate")
		public WebElement entryDate;
		@FindBy(id = "entry")
		public WebElement entryPrice;
		@FindBy(id = "closeDate")
		public WebElement exitDate;
		@FindBy(id = "exit")
		public WebElement exitPrice;
		@FindBy(xpath = "//button[text()='Save']")
		public WebElement tradeSaveBtn;
		@FindBy(xpath = "//table[@class='table table-bordered table-striped']/tbody/tr/td[2]")
		public List<WebElement> anyRowStockSymbol;
	    @FindBy(xpath = ("//p[text()='Save Trade']"))
	    public WebElement saveTradeLogo;
}
