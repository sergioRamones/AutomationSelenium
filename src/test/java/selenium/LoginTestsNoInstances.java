package selenium;

import org.testng.ITestContext;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Listeners;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import utility.Base;


@Listeners({utility.Listener.class})
public class LoginTestsNoInstances  {
	
	String url = "https://opensource-demo.orangehrmlive.com/";
	String usuario = "Admin";
	String pass = "admin123";

	
	@Parameters(value= {"browser"})
	@BeforeTest
	public void initTest(ITestContext context, @Optional("chrome") String browser) {
		Base.page.getBase().openBrowser(browser,context);
		Base.page.getBase().openUrl(url);	
	}
	
	
	@Test(enabled = true, priority=2)
	public void accederCorrectamente(){
		Base.page.getLogin().loginSuccess(usuario, pass);
		Base.page.getLogin().logout();
	
	}
	
	@Test(enabled= true, priority=1)
	public void loginFallido() {
		Base.page.getLogin().loginFallido("Sergio", "1234", "Invalid credentials");
		Base.page.getLogin().loginFallido("", "1234", "Username cannot be empty");
		Base.page.getLogin().loginFallido("Admin", "", "Password cannot be empty");
	}
	
	@Test(enabled = true, priority=3)
	public void pedirVacaciones(){
		
		Base.page.getLogin().loginSuccess(usuario, pass);
		Base.page.getMenu().selectMenuSubMenu("Leave", "Assign Leave");
		Base.page.getLeave().requestVacationFullDay("Jacqueline White", "2022-03-27", "2022-03-30", "US - Vacation");
		Base.page.getLogin().logout();
	}
	

	
	
	@AfterTest
	public void closeBrowser() {
		Base.page.getBase().closeBrowser();
	}
	

}
