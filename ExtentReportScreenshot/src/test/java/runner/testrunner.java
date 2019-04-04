package runner;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import cucumber.api.CucumberOptions;
import cucumber.api.testng.CucumberFeatureWrapper;
import cucumber.api.testng.TestNGCucumberRunner;

@CucumberOptions(features= {"C:\\Users\\Preety Sehrawat\\Desktop\\Testing frameworks\\TestNGFramework\\ExtentReportScreenshot\\src\\test\\java\\features\\AmazonSearchFeature.feature"},
glue= {"stepDefinitions"})  


//@CucumberOptions(features="src/test/java/features/AmazonSearch.feature",glue="src/test/java/stepDefinitions")


public class testrunner{

	private TestNGCucumberRunner testRunner;

	@BeforeClass
	public void setUP()
	{
		testRunner = new TestNGCucumberRunner(this.getClass());
		
	}

	@Test(description = "login", dataProvider = "features")
	public void login(CucumberFeatureWrapper cFeature) {
		testRunner.runCucumber(cFeature.getCucumberFeature());
	}

	@DataProvider(name = "features")
	public Object[][] getFeatures() {
		return testRunner.provideFeatures();
	}

	@AfterClass
	public void tearDown() {
		testRunner.finish();
	}
}
