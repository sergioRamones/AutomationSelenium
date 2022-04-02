package selenium;

import org.testng.ITestContext;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Listeners;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import data.DataTest;
import utility.Base;


@Listeners({utility.Listener.class})
public class LoginTestsNoInstances  extends DataTest{
	
	String url = "https://opensource-demo.orangehrmlive.com/";
	String usuario = "Admin";
	String pass = "admin123";

	
	@Parameters(value= {"browser"})
	@BeforeTest( groups={"smoke","regression"})
	public void initTest(ITestContext context, @Optional("edge") String browser) {
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
	
	@Test(enabled= true, priority=1, dataProvider="fallidos_test", dataProviderClass = DataTest.class, groups={"smoke","regression"})
	public void loginFallidoDataProvider(String user, String password, String errorMessage) {
		Base.page.getLogin().loginFallido(user, password, errorMessage);

	}
	
	@Test(enabled = true, priority=3, dataProvider="dates" )
	public void pedirVacaciones(String fromDate, String toDate){
		
		Base.page.getLogin().loginSuccess(usuario, pass);
		Base.page.getMenu().selectMenuSubMenu("Leave", "Assign Leave");
		Base.page.getLeave().requestVacationFullDay("Jacqueline White", fromDate, fromDate, "US - Vacation");
		Base.page.getLogin().logout();
	}
	
	@DataProvider(name="loginFallidos")
	public Object[][] getUsers(){
		
		Object[][] data = new Object[3][3];
		
		data[0][0] = "Sergio";
		data[0][1] = "1234";
		data[0][2] = "Invalid credentials";
		
		data[1][0] = "";
		data[1][1] = "12345";
		data[1][2] = "Username cannot be empty";
		
		data[2][0] = "Admin";
		data[2][1] = "";
		data[2][2] = "Password cannot be empty";
		
		return data;
		
	}
	
	@DataProvider(name="dates")
	public Object[][] getDates() {
		Object[][] date = new Object[2][2];
		date[0][0] = Base.page.getBase().getDate(0);
		date[0][1] = Base.page.getBase().getDate(5);
		
		date[1][0] = Base.page.getBase().getDate(10);
		date[1][1] = Base.page.getBase().getDate(15);
		return date;
		
	}
	@AfterTest(groups={"smoke","regression"})
	public void closeBrowser() {
		Base.page.getBase().closeBrowser();
	}
	

}
