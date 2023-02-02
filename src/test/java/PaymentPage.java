import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class PaymentPage extends Base{
	
	@FindBy(id = "add-to-cart-sauce-labs-backpack")
	public WebElement addToCard;
	
	@FindBy(xpath = "//a[@class='shopping_cart_link']")
	public WebElement cardButton;
	
	@FindBy(xpath = "//button[@id='checkout']")
	public WebElement checkoutButton;
	
	@FindBy(xpath = "//input[@id='first-name']")
	public WebElement firstName;
	
	@FindBy(xpath = "//input[@id='last-name']")
	public WebElement lastName;
	
	@FindBy(xpath = "//input[@id='postal-code']")
	public WebElement postalCode;
	
	@FindBy(xpath = "//input[@id='continue']")
	public WebElement continueButton;
	
	@FindBy(xpath = "//button[@id='finish']")
	public WebElement finishButton;
	
	@FindBy(xpath = "//h3[@data-test='error']")
	public WebElement userInformationIsEmpty;
	
	public void validPayment() {
		addToCard.click();
		cardButton.click();
		checkoutButton.click();
		firstName.sendKeys("Mohamed");
		lastName.sendKeys("Elmanakhly");
		postalCode.sendKeys("32591");
		
	    String Actual = continueButton.getText();
	    String Expected = "continue";
		softAssertion(Actual, Expected);
		softAssert.assertAll();
		
		continueButton.click();
		finishButton.click();
	}
	
	public void invalidPayment() {
		addToCard.click();
		cardButton.click();
		checkoutButton.click();
		firstName.sendKeys("");
		lastName.sendKeys("");
		postalCode.sendKeys("");
		continueButton.click();

		String Actual = userInformationIsEmpty.getText();
		String Expected = "Error: First Name is required" ;

		softAssertion(Actual,Expected);
		softAssert.assertAll();
	}
	
	public void GetElements() {
		PageFactory.initElements(driver, this);
	}

}
