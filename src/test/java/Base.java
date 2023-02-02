import java.time.Duration;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;

public class Base {
	
	public static WebDriver driver;
	public WebDriverWait wait;
	SoftAssert softAssert = new SoftAssert();
	
	
	@FindBy(xpath = "//*[@id=\"logout_sidebar_link\"]")
	public WebElement LogoutButton;
	
	@FindBy(xpath = "//*[@id=\"react-burger-menu-btn\"]")
	public WebElement MenuButtonElement;
	
	public void openBrowser(){
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\ncm\\Downloads\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.get("https://www.saucedemo.com/");
	}
	
	public void closeBrowser(){
		driver.close();
		driver.quit();
	}
	
	public void softAssertion(String Actual,String Expected){
		softAssert.assertTrue(Actual.contains(Expected));
	}
	
	public void hardAssertion(String Actual,String Expected){
		Assert.assertTrue(Actual.contains(Expected));
	}
	
	public void explicitWait(WebElement element){
		wait= new WebDriverWait(driver,Duration.ofSeconds(20));
	    wait.until(ExpectedConditions.visibilityOf(element));
	}
	
	public void sleep() throws InterruptedException{
		Thread.sleep(Duration.ofSeconds(5));
	}
	
	public void implicitWait() {
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
	}
	
	public void GetElements() {
		PageFactory.initElements(driver, this);
	}
	
    public void logout() {
		
		MenuButtonElement.click();
		
		LogoutButton.click();
		
	}
	
	
	
}
