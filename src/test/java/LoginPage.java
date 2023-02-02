import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage extends Base {
	
	public  String vlaidUserName = "standard_user";
	public  String vlaidPassword = "secret_sauce";
	
	public String invlaidUserName = "fdjkskr44er";
	public String invlaidPassword = "sdjfj234j";
	
	@FindBy(xpath =  "//div[@class='footer_copy']")
	public WebElement footer;
	
	@FindBy(xpath ="/html/body/div/div/div[2]/div[1]/div[1]/div/form/div[3]")
	public WebElement errorMessageInvalidUserNameOrPassword;
	
	@FindBy(id = "user-name")
	public WebElement userNameElement;
	
	@FindBy(id = "password")
	public WebElement passwordElement;
	
	@FindBy(id = "login-button")
	public WebElement LoginButtonElement;
	
	public void enterUserName(String username){	
		userNameElement.sendKeys(username);
	}
	

	
	public void enterPassword(String password){
		passwordElement.sendKeys(password);
	}
	
	public void clickOnLoginButton() {
		LoginButtonElement.click();
	}
	
	
	public void loginWithValidAccount(){
				
		enterUserName(vlaidUserName);
		
		
		enterPassword(vlaidPassword);
		
		clickOnLoginButton();
		
		String Actual = footer.getText();
		String Expected = "2023";
		
		implicitWait();

		softAssertion(Actual,Expected);
		
		softAssert.assertAll();
		
	
	}
	
	
	public void loginWithInvalidAccount(){
		
		enterUserName(invlaidUserName);
		
		enterPassword(invlaidPassword);
		
		clickOnLoginButton();
		
		String Actual = errorMessageInvalidUserNameOrPassword.getText();
		String Expected = "Username and password do not match any user";
		
		implicitWait();

		softAssertion(Actual,Expected);
		softAssert.assertAll();
		
	}
	
	public void GetElements() {
		PageFactory.initElements(driver, this);
	}
	

}
