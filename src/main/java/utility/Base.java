package utility;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Calendar;
import java.util.List;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.ITestContext;
import org.testng.Reporter;

public class Base {
	
	private WebDriver driver;
	private String OSName = System.getProperty("os.name");
	private String projectPath = System.getProperty("user.dir");
	private String chromeDriver;
	private String edgeDriver;
	private String geckoDriver;
	
	
	/**
	 * @Description get Operating system name 
	 * @author sramones
	 * @Date 01/03/2022
	 * @param N/A
	 * @return String
	 * @exception 
	 * **/
	public Base() {
		
	}
	
	/**
	 * @Description get Operating system name 
	 * @author sramones
	 * @Date 01/03/2022
	 * @param N/A
	 * @return String
	 * @exception 
	 * **/
	public Base(WebDriver driver) {
		this.driver=driver;
	}
	
	/**
	 * @Description get Operating system name 
	 * @author sramones
	 * @Date 01/03/2022
	 * @param N/A
	 * @return String
	 * @exception 
	 * **/
	public void setDriver(WebDriver driver) {
		this.driver=driver;
	}
	
	/**
	 * @Description get Operating system name 
	 * @author sramones
	 * @Date 01/03/2022
	 * @param N/A
	 * @return String
	 * @exception 
	 * **/
	public WebDriver getDriver() {
		return driver;
	}
	
	/**
	 * @Description get Operating system name 
	 * @author sramones
	 * @Date 01/03/2022
	 * @param N/A
	 * @return String
	 * @exception 
	 * **/
	public String getOSName() {
		if (OSName.contains("Windows")) {
			OSName = "Windows";
		} else if (OSName.contains("Mac")) {
			OSName = "Mac";
		} else if (OSName.contains("Linux")) {
			OSName = "Linux";
		}

		return OSName;
	}
	
	/**
	 * @Description get Operating system name 
	 * @author sramones
	 * @Date 01/03/2022
	 * @param N/A
	 * @return String
	 * @exception 
	 * **/
	public void setDriverPaths() {
		OSName = getOSName();
		switch(OSName) {
		case"Mac":
		case"Linux":
			chromeDriver = projectPath + "/chromedriver/chromedriver";
			edgeDriver = projectPath + "/msedgedriver/msedgedriver";
			geckoDriver = projectPath + "/geckodriver/geckodriver";
			break;
		case "Windows":
			chromeDriver = projectPath + "\\chromedriver\\chromedriver.exe";
			edgeDriver = projectPath + "\\msedgedriver\\msedgedriver.exe";
			geckoDriver = projectPath + "\\geckodriver\\geckodriver.exe";
			break;
		default:
			Reporter.log("El path no esta inicializado",true);
		}
		
	}
	
	/**
	 * @Description get Operating system name 
	 * @author sramones
	 * @Date 01/03/2022
	 * @param N/A
	 * @return String
	 * @exception 
	 * **/
	public WebDriver chromeDriverConnection() {
		setDriverPaths();
		System.setProperty("webdriver.chrome.driver", chromeDriver);
		ChromeOptions option = new ChromeOptions();
		option.addArguments("--start-maximized");
		option.addArguments("--incognito");
		driver = new ChromeDriver(option);
		driver.manage().timeouts().implicitlyWait(Duration.ofMillis(600));
		
		return driver;
	}
	/**
	 * @Description get Operating system name 
	 * @author sramones
	 * @Date 01/03/2022
	 * @param N/A
	 * @return String
	 * @exception 
	 * **/
	public WebDriver edgeDriverConnection() {
		setDriverPaths();
		System.setProperty("webdriver.edge.driver", edgeDriver);
		EdgeOptions option = new EdgeOptions();
		option.addArguments("--start-maximized");
		option.addArguments("--incognito");
		driver = new EdgeDriver(option);
		driver.manage().timeouts().implicitlyWait(Duration.ofMillis(600));
		
		return driver;
	}
	/**
	 * @Description get Operating system name 
	 * @author sramones
	 * @Date 01/03/2022
	 * @param N/A
	 * @return String
	 * @exception 
	 * **/
	public WebDriver geckoDriverConnection() {
		setDriverPaths();
		System.setProperty("webdriver.gecko.driver", geckoDriver);
		FirefoxOptions option = new FirefoxOptions();
		option.addArguments("--start-maximized");
		option.addArguments("--incognito");
		driver = new FirefoxDriver(option);
		driver.manage().timeouts().implicitlyWait(Duration.ofMillis(600));
		
		return driver;
	}
	/**
	 * @Description get Operating system name 
	 * @author sramones
	 * @Date 01/03/2022
	 * @param N/A
	 * @return String
	 * @exception 
	 * **/
	public WebDriver openBrowser(String browserName, ITestContext context) {

		switch (browserName) {
		case "chrome":
			driver = chromeDriverConnection();
			break;
		case "edge":
			driver = edgeDriverConnection();
			break;
		case "firefox":
			driver = geckoDriverConnection();
			break;
		default:
			Reporter.log("Driver can't be initialited. browser is: " + browserName, true);

		}
		context.setAttribute("WebDriver", driver);
		return driver;

	}
	
	/**
	 * @Description Encontrar webElement por locator
	 * @author sramones
	 * @Date 01/03/2022
	 * @param N/A
	 * @return By 
	 * @exception 
	 * **/
	public WebElement findElement(By locator) {
		Reporter.log("Localizar Elemento",true);
		return driver.findElement(locator);
	}
	
	/**
	 * @Description Encontrar lista de webElement por locator
	 * @author sramones
	 * @Date 01/03/2022
	 * @param By
	 * @return List WebElement 
	 * @exception 
	 * **/
	public List<WebElement> findElements(By locator){
		return driver.findElements(locator);
	}
	
	/**
	 * @Description Obtener texto por locator
	 * @author sramones
	 * @Date 01/03/2022
	 * @param By
	 * @return String
	 * @exception 
	 * **/
	public String getText(By locator) {
		String text = findElement(locator).getText();
		reporter("El texto obtenido es", text);
		return text;
	}
	
	/**
	 * @Description hacer click en locator.
	 * @author sramones
	 * @Date 01/03/2022
	 * @param By
	 * @return N/A 
	 * @exception 
	 * **/
	public void click(By locator) {
		Reporter.log("Web Element was clicked");
		findElement(locator).click();
	}
	
	/**
	 * @Description Mostrar mensaje en reporte de ejecucion
	 * @author sramones
	 * @Date 01/03/2022
	 * @param String String
	 * @return N/A
	 * @exception 
	 * **/
	public void reporter(String message, String value) {
		Reporter.log(message + "<b> [ "+value+" ] </b>", true);
	}
	
	/**
	 * @Description Mostrar mensaje en reporte de ejecucion
	 * @author sramones
	 * @Date 01/03/2022
	 * @param String String
	 * @return N/A
	 * @exception 
	 * **/
	public void reporter(String message) {
		Reporter.log("<b> [ "+message+" ] </b>", true);
	}
	
	/**
	 * @Description Escribir texto en web element
	 * @author sramones
	 * @Date 01/03/2022
	 * @param String, By
	 * @return N/A
	 * @exception 
	 * **/
	public void type(String inputText, By locator) {
		findElement(locator).clear();
		findElement(locator).sendKeys(inputText);
		reporter("Fue ingresado",inputText);
	}
	
	/**
	 * @Description Esperar un webElement con timeout
	 * @author sramones
	 * @Date 01/03/2022
	 * @param By
	 * @return N/A
	 * @exception 
	 * **/
	public void verifyElementIsPresent(By locator) {
		WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(30));
		wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(locator));
		reporter("El elemento existe: ", "");
	}
	
	
	public void openUrl(String url) {
		driver.get(url);
		reporter("El URL fue abierto :", url);
	}
	
	public void navigateToUrl(String url) {
		driver.navigate().to(url);
		reporter("El URL fue abierto :", url);
	}
	
	public void openNewTab() {
		driver.switchTo().newWindow(WindowType.TAB);
	}
	
	public void openNewWindow() {
		driver.switchTo().newWindow(WindowType.WINDOW);
	}
	
	
	public void takeScreenShot() {
		OSName = getOSName();
		String path="";
		switch(OSName) {
		case"MAC":
		case"Linux":
			path = projectPath+"/execution_results/screenshots/";
			// projectPath = "/execution_results/screenshots/"
			break;
		case"Windows":
			path = projectPath + "\\execution_results\\screenshots\\";
			// projectPath = ".\\execution_results\\screenshots\\";
			break;
		}
		
		Calendar calendar = Calendar.getInstance();
		SimpleDateFormat formater = new SimpleDateFormat("dd_MM_yyyy_hh_mm_ss");
		
		File srcFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		try {
				
				String fullPath = path + "screen_"+formater.format(calendar.getTime())+".png";
				FileUtils.copyFile(srcFile, new File(fullPath));		
				
			
				Reporter.log("************EL screenshot fue guardado en [" + fullPath+" ]********************",true);
				Reporter.log("<br> <img src='"+ fullPath+"' height='400' width='800'/></br>", true );
				
		}catch(IOException e) {
			e.printStackTrace();
			
		}
		
		
		
	}//end screenshot
	
	
	/**
	 * @Description Verificar un texto esperado
	 * @author sramones
	 * @Date 26/03/2022
	 * @param String,String
	 * @return N/A
	 * @exception 
	 * **/
	public void validateExpectedText(String expected, String actual) {
		try {
			Assert.assertEquals(expected, actual);
			reporter("Expected text  [" + expected + " ] IS EQUAL TO [ "+ actual+" ]");
		} catch (AssertionError e) {
//			reporter("Expected text  [" + expected + " ] IS NOT EQUAL TO [ "+ actual+" ]");
			Assert.fail("text are not matching <b> expeected:  [ " + expected + " ] and actaual: [ " + actual+ " ] <b>");
		}
	}
	
	/**
	 * @Description click web element si conicide con el texto esperado
	 * @author sramones
	 * @Date 26/03/2022
	 * @param By, String
	 * @return N/A
	 * @exception 
	 * **/
	public void selectElementByValue(By locator, String expectedText) {
		
		List<WebElement> elements = findElements(locator);
		
		for(int i = 0 ; i<elements.size(); i++) {
			
			if(i>=elements.size()) {
				Assert.fail("El elemento que buscas en la lista no existe: [ "+ expectedText+ " ]");
			}
			
			if(elements.get(i).getText().equals(expectedText)) {
				reporter("Element in the list was clicked", elements.get(i).getText());
				elements.get(i).click();
				break;
			}
			
		}//end for
		
	}
	
	/**
	 * @Description seleccionar Elemento por index
	 * @author sramones
	 * @Date 26/03/2022
	 * @param By, int
	 * @return N/A
	 * @exception 
	 * **/
	public void selectDropDownByIndex(By locator, int index) {
		WebElement dropdown = findElement(locator);
		Select action = new Select(dropdown);
		
		try {
			action.selectByIndex(index);
			reporter("Element was selected by Index", String.valueOf(index));
		}catch(StaleElementReferenceException e) {
				Assert.fail("Cannot select element: [ "+ dropdown.toString()+" ]");
		}catch(NoSuchElementException e) {
				Assert.fail("Cannot select element: [ "+ dropdown.toString()+" ]");
		}
		
	}
	
	/**
	 * @Description seleccionar Elemento por Value
	 * @author sramones
	 * @Date 26/03/2022
	 * @param By, int
	 * @return N/A
	 * @exception 
	 * **/
	public void selectDropDownByValue(By locator, String value) {
		WebElement dropdown = findElement(locator);
		Select action = new Select(dropdown);
		
		try {
			action.selectByValue(value);
			reporter("Element was selected by Value", value);
		}catch(StaleElementReferenceException e) {
				Assert.fail("Cannot select element: [ "+ dropdown.toString()+" ]");
		}catch(NoSuchElementException e) {
				Assert.fail("Cannot select element: [ "+ dropdown.toString()+" ]");
		}
		
	}
	
	/**
	 * @Description seleccionar Elemento por Value
	 * @author sramones
	 * @Date 26/03/2022
	 * @param By, int
	 * @return N/A
	 * @exception 
	 * **/
	public void selectDropDownByVisibleText(By locator, String expectedText) {
		WebElement dropdown = findElement(locator);
		Select action = new Select(dropdown);
		
		try {
			action.selectByVisibleText(expectedText);
			reporter("Element was selected by Visible text", expectedText);
		}catch(StaleElementReferenceException e) {
				Assert.fail("Cannot select element: [ "+ dropdown.toString()+" ]");
		}catch(NoSuchElementException e) {
				Assert.fail("Cannot select element: [ "+ dropdown.toString()+" ]");
		}
		
	}


}
