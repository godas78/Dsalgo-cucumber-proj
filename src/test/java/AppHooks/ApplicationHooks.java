package AppHooks;

import java.util.Properties;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import com.qa.factory.DriverFactory;
import com.qa.util.ConfigReader;
import com.qa.util.Loggerload;
import io.cucumber.java.AfterAll;
import io.cucumber.java.AfterStep;
import io.cucumber.java.Before;
import io.cucumber.java.BeforeAll;
import io.cucumber.java.Scenario;
import io.qameta.allure.Allure;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

//import io.cucumber.messages.types.Scenario;

public class ApplicationHooks {

	//private static final String Loggerload = null;
	private static DriverFactory driverFactory;
	public static WebDriver driver;
	private static ConfigReader configReader;
	static Properties prop;
	static Scenario scenario;

	@BeforeAll
	public static void beforeScenario()
	{
		Loggerload.info("Loading Config file");
		try
		{
			configReader = new ConfigReader();
			prop = ConfigReader.init_prop();

		    if(driver== null)
		    {
		    	String browserName = prop.getProperty("browser");
		    	//System.out.println(browserName);
		    	driverFactory = new DriverFactory();
		    	driver = driverFactory.init_driver(browserName);
		    	Loggerload.info("Initializing driver for : "+browserName);
		    }
            Loggerload.info("//////////////Browser is launched");
		 }
		 catch (Exception e)
		 {
		 e.printStackTrace();
		 }
	}

@Before
	public void scenario(Scenario scenario) {
		Loggerload.info("===============================================================================================");
		Loggerload.info(scenario.getSourceTagNames() +" : "+scenario.getName());
		Loggerload.info("-----------------------------------------------------------------------------------------------");
		
	}
	@AfterStep
	public void afterstep(Scenario scenario) {
		if (scenario.isFailed()) {
			Loggerload.error("Steps Failed , Taking Screenshot");
			final byte[] screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
			scenario.attach(screenshot, "image/png", "My screenshot");
			Allure.addAttachment("Myscreenshot", new String(((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES)));
		
		}
	}

	@AfterAll
	public static void after() {
		Loggerload.info("Closing Driver");
		driverFactory.closeallDriver();	        
	}
}
	

	/*@AfterStep
	public void addScreenShot(Scenario scenario)
	{

		if(scenario.isFailed())//if(scenario.getStatus==Status.FAILED))
		{
			//ExtentCucumberAdapter.getCurrentStep().log(Status.FAIL, MediaEntityBuilder.createScreenCaptureFromBase64String(getBase64Screenshot()).build());

			//LOG.error("Scenario failed");
			String ScreenShotName = scenario.getName().replaceAll(" ", "_");
			byte[] sourcePath = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);

			scenario.attach(sourcePath, "image/png", ScreenShotName);
			//Allure.addAttachment("ScreenShotInAllure", new ByteArrayInputStream(sourcePath);
		}
	}

	public static WebDriver getDriver()
	{
	 return driver;
	}

	@AfterAll
	public static void quitBrowser()
	{
		driver.quit();
	}
}



	/*Properties prop;

	@Before(order = 0)
	public void getProperty() {
		configReader = new ConfigReader();
		prop = configReader.init_prop();
		}

	@Before(order = 1)
	public void launchBrowser() {
		String browserName = prop.getProperty("browser");
		driverFactory = new DriverFactory();
		driver = driverFactory.init_driver(browserName);
		}

	@After(order = 0)
	public void quitBrowser() {
		driver.quit();
	}
	/*@After(order = 1)
	public void tearDown(Scenario scenario) {
		if(scenario.isFailed()) {
			//take screenshot;

			String screenshotName = scenario.getName().replaceAll("", "_");
			byte [] sourcepath = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
			scenario.attach(sourcepath, "image/png", screenshotName);
		}

	}*/


