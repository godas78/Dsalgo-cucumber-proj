package testrunners;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import io.cucumber.testng.AbstractTestNGCucumberTests;

import org.junit.runner.RunWith;
import org.testng.annotations.DataProvider;
//import org.testng.annotations.Test;

@RunWith(Cucumber.class)
@CucumberOptions(
		features = {"src/test/resources/AppFeatures"},
		glue = {"stepDefinitions", "AppHooks"},
		plugin = {"summary","pretty", "html:target/report/cucumber-reports.html",
				"json:target/report/cucumber-reports.json",
				"junit:target/cucumber.xml",
				"io.qameta.allure.cucumber7jvm.AllureCucumber7Jvm",
				"com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:",
				},
		monochrome = true,
		tags = ""
		)

public class MyTestRunner extends AbstractTestNGCucumberTests {
	@DataProvider(parallel = false)
	public Object[][] scenarios() {

		return super.scenarios();
	}
}
	
/*@Test
	public class MyTestRunner extends AbstractTestNGCucumberTests {
		}	*/
