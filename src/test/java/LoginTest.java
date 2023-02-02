import org.testng.annotations.*;

public class LoginTest extends Base{
	
	LoginPage login = new LoginPage();
	
	@BeforeMethod
	public void openBrowser(){
		
		login.openBrowser();
		login.GetElements();
		login.implicitWait();
	}
	
	@Test(priority = 1)
    public void loginWithValidAccount() {
    	login.loginWithValidAccount();
    	login.logout();
    }
	
	@Test(priority = 2)
    public void loginWithInvalidAccount() {
    	login.loginWithInvalidAccount();
    }
    
	 @AfterMethod 
	 public void closeBrowser() {
	    
	    login.closeBrowser();
	  
	 }
	 
}
