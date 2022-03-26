package selenium;

import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Listeners;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import orangeHRM.Leave;
import orangeHRM.Login;
import orangeHRM.Menu;


@Listeners({utility.Listener.class})
public class LoginTests {
	private WebDriver driver;
	Login login;
	Menu menu; 
	Leave leave;
	String url = "https://opensource-demo.orangehrmlive.com/";
	String usuario = "Admin";
	String pass = "admin123";
	
	@Parameters(value= {"browser"})
	@BeforeTest
	public void initTest(ITestContext context, @Optional("chrome") String browser) {
		login = new Login(driver);
		driver = login.openBrowser(browser,context);
		login.openUrl(url);
		
	}
	
	
	@Test(enabled = true, priority=2)
	public void accederCorrectamente(){
		login.loginSuccess(usuario, pass);
		login.logout();
	
	}
	
	@Test(enabled= true, priority=1)
	public void loginFallido() {
		login.loginFallido("Sergio", "1234", "Invalid credentials");
		login.loginFallido("", "1234", "Username cannot be empty");
		login.loginFallido("Admin", "", "Password cannot be empty");
	}
	
	@Test(enabled = true, priority=3)
	public void pedirVacaciones(){
		login.loginSuccess(usuario, pass);
		menu = new Menu(driver);
		menu.selectMenuSubMenu("Leave", "Assign Leave");
		leave = new Leave(driver);
		leave.requestVacationFullDay("Jacqueline White", "2022-03-27", "2022-03-30", "US - Vacation");
		login.logout();
	
	}
	
	
	@AfterTest
	public void closeBrowser() {
		driver.quit();
	}
	

}
