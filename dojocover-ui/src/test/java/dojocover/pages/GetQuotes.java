package dojocover.pages;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class GetQuotes {

	private final WebDriver driver;
	private static final Logger log=LogManager.getLogger(SignInPage.class);
	
	@FindBy(linkText = "Get a quote")
	private WebElement getQuoteLink;
	@FindBy(tagName = "h1")
	private WebElement pageHeader;
	@FindBy(id="quote-motor")
	private WebElement motorRadioButton;
	@FindBy(xpath = "//input[@id='quote-motor']/parent::label")
	private WebElement motorLabel;
	@FindBy(id="quote-home")
	private WebElement homeRadioButton;
	@FindBy(xpath = "//input[@id='quote-home']/parent::label")
	private WebElement homeLabel;
	@FindBy(id="quote-health")
	private WebElement healthRadioButton;
	@FindBy(xpath = "//input[@id='quote-health']/parent::label")
	private WebElement healthLabel;
	@FindBy(id="quote-travel")
	private WebElement travelRadioButton;
	@FindBy(xpath = "//input[@id='quote-travel']/parent::label")
	private WebElement travelLabel;
	@FindBy(css = "#quote-plan-third-party")
	private WebElement coverType1;
	@FindBy(css = "#quote-plan-fire-theft")
	private WebElement coverType2;
	@FindBy(css = "#quote-plan-comprehensive")
	private WebElement coverType3;
	@FindBy(css="#quote-age")
	private WebElement driverAgeInput;
	@FindBy(css="#quote-vehicle-age")
	private WebElement vehicleAgeInput;
	@FindBy(css = "#quote-mileage")
	private WebElement vehicleDistanceCovered;
	@FindBy(xpath = "//button[text()='Get my price']")
	private WebElement getPriceButton;
	
	
	public GetQuotes(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	private void verifyDisplayed(WebElement element, String name)
	{
	    Assert.assertTrue(element.isDisplayed(), name + " is not displayed");
	    log.info(name + " is displayed");
	}
	
	public void navigateToGetaQuote()
	{
		log.info("Clicking on Get Quote");
		getQuoteLink.click();
	}
	
	public void verifyMotorQuotePage()
	{
	    verifyDisplayed(motorRadioButton, "Motor radio button");
	    Assert.assertTrue(motorLabel.getAttribute("class").contains("is-selected"),
	            "Motor tile should be highlighted");
	    log.info("Product selected is Motor");

	    verifyDisplayed(coverType1, "Cover type: Third-party");
	    verifyDisplayed(coverType2, "Cover type: Third-party, fire and theft");
	    verifyDisplayed(coverType3, "Cover type: Comprehensive");

	    verifyDisplayed(driverAgeInput, "Main driver's age field");
	    verifyDisplayed(vehicleAgeInput, "Vehicle age field");
	    verifyDisplayed(vehicleDistanceCovered, "Yearly distance dropdown");
	    verifyDisplayed(getPriceButton, "Get my price button");
	}

}
