package selenium;

import org.testng.ITestContext;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Listeners;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import data.DataTest;
import utility.Base;
@Listeners({utility.Listener.class})
public class ValidateLinksHRM {

	String url = "https://opensource-demo.orangehrmlive.com/";

	
	@Parameters(value= {"browser"})
	@BeforeTest(groups= {"smoke", "regression","vacaciones"})
	public void initTest(ITestContext context, @Optional("chrome") String browser) {
		Base.page.getBase().openBrowser(browser, context);
		Base.page.getBase().openUrl(url);
	}
	
	
	@Test(enabled=true, priority=1, dataProvider="user", dataProviderClass = DataTest.class, groups= {"smoke", "regression"})
	public void validarLinksHRM(String usuario, String password) {
		Base.page.getLogin().loginSuccess(usuario, password);
		Base.page.getMenu().verifyPageLinks();
		Base.page.getLogin().logout();
	}
	
	
	@AfterTest(groups= {"smoke", "regression","vacaciones"})
	public void close() {
		Base.page.getBase().closeBrowser();
	}

	
}
