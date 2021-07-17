package pages;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utilities.Driver;

public class HomePage {
	   public HomePage() {
	        PageFactory.initElements(Driver.getDriver(),this);
	           }

	    public final String pageTitle = "Transactions";


	    @FindBy(xpath = "//button[text()=\"Logout\"]")
	    public WebElement signOutButton;


	    //Created by Beka
	    @FindBy(xpath = "//a[text()='Home ']")
	    public WebElement labelHome;

	    //Created by Beka
	    @FindBy(name= "symbol")
	    public WebElement symbolInput;

	    //Created by Beka
	    @FindBy(name= "date")
	    public WebElement dateInput;

	    //Created by Beka
	    @FindBy(xpath = "//button[text()='Search']")
	    public WebElement searchButton;

	    //Created by Beka
	    @FindBy(xpath = "//td[text()='ORPR']")
	    public WebElement secondColomFirsRowFromTable;

	    @FindBy(xpath = "//thead")
	    public WebElement headerOfTable;

	    @FindBy(xpath = "//tr")
	    public List<WebElement> ListOfAllRowsFromTable;

	//created by Hakan
	    @FindBy(xpath = "//table[@class = 'table table-bordered table-striped']")
	    public WebElement tableView;
	    @FindBy(xpath = "//a[@class = 'btn btn-danger btn-sm']")
	    public WebElement deleteButton;


	    //created by Liubomyr
	    @FindBy (xpath= "//img[@src='https://www.pinclipart.com/picdir/middle/11-111719_clipart-arrows-graph-trading-icon-png-download.png']")
	    public WebElement logo;
	    @FindBy (xpath = "//a[text()='Finom Group']")
	    public WebElement finomGroupTab;
	    @FindBy (xpath = "//a[text()='Slack Channel']")
	    public WebElement slackChannelTab;
	    @FindBy (xpath = "//img[@alt='Slack']")
	    public WebElement slackChannelLogo;
	    @FindBy (xpath = "//a[@class='nav-link dropdown-toggle']")
	    public WebElement toolsTab;
	    @FindBy (xpath = "//a[text()='Options Calculator']")
	    public WebElement calculatorTab;

	    @FindBy(xpath = "//a[@href='https://finviz.com/']")
	    public WebElement todaysMarketTab;

	    @FindBy(xpath = "//a[text()='Vol ETF/ETN Price Converter']")
	    public WebElement converterTab;
	    @FindBy(xpath = ("(//button[@class='btn btn-outline-success my-2 my-sm-0'])[2]"))
	    public WebElement logoutButton;
	    @FindBy(xpath = ("//a[@class='btn btn-primary btn-sm mb-3']"))
	    public WebElement addTradeButton;
	    @FindBy(xpath = "//div[@aria-labelledby='navbarDropdown']")
	    public WebElement toolsDropDown;
	    
	    //created by Dilmira
	    @FindBy(xpath= ("//th[text()='Action'][1]"))
		public WebElement actionCol;
		
	    //created by Dilmira
		@FindBy(xpath= "//th[text()='Symbol'][1]")
		public WebElement symbolCol;
		
		@FindBy(xpath = "//th[text()='Open date'][1]")
		public WebElement openDateCol;
		
		@FindBy(xpath = "//th[text()='Entry']")
		public WebElement entryCol;
		
		@FindBy(xpath = "//th[text()='Close date']")
		public WebElement closeDateCol;
		
		@FindBy(xpath = "//th[text()='Exit']")
		public WebElement exitCol;
		
		@FindBy(xpath = "//th[text()='Gain/Loss']")
		public WebElement gainLossCol;
		
		@FindBy(xpath = ("//th[text()='Action'][2]"))
		public WebElement action2Col;

	    @FindBy(xpath = ("//title[text()='Home - Finom Group']"))
	    public WebElement finomGroupPageLogo;

	    @FindBy(xpath = ("//head[@id='head']/title"))
	    public WebElement calculatorPageLogo;

	    @FindBy(xpath = ("//a[@class='logo']"))
	    public WebElement finwizPageLogo;

	    @FindBy(xpath = ("//a[contains(text(), 'Update')]"))
	    public List<WebElement> updatebtn;
}
