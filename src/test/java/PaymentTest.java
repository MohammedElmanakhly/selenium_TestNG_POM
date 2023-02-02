import org.testng.annotations.*;

public class PaymentTest{
	
	Base base = new Base();
	PaymentPage payment = new PaymentPage();
	LoginPage login = new LoginPage();
	
	@BeforeMethod
	public void openBrowser(){
		
		payment.openBrowser();
		payment.implicitWait();
		base.GetElements();
		payment.implicitWait();
		login.GetElements();
		payment.implicitWait();
		payment.GetElements();
		payment.implicitWait();
		
	}
	
	@Test(priority = 1)
	public void validPayment() {
		login.loginWithValidAccount();
		payment.validPayment();
		payment.logout();
	}
	
	@Test(priority = 2)
	public void invalidPayment() {
		login.loginWithValidAccount();
		payment.invalidPayment();
		payment.logout();
	}
	
	@AfterMethod
	public void closeBrowser() {
		payment.closeBrowser();
	}
	

}
