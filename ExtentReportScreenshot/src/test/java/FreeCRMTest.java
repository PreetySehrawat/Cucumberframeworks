import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;


public class FreeCRMTest {

	
	public ExtentReports extent;
	public ExtentTest extentTest;
	public ExtentHtmlReporter htmlextent = null;
	public WebDriver driver;
	
	
	@BeforeTest()
	public void setExtent()
	{
		extent = new ExtentReports();
		htmlextent = new ExtentHtmlReporter(System.getProperty("user.dir") + "/test-output/ExtentReport.html");
		extent.attachReporter(htmlextent);
		extent.setSystemInfo("Host Name", "Preety Windows");
		extent.setSystemInfo("User Name", "Preety Sehrawat");
		extent.setSystemInfo("Environment", "QA");
	}
	
	
	@AfterTest()
	public void endReport()
	{
		extent.flush();
		extent.removeTest(extentTest);
		
	}
	
	public String getScreenshot(WebDriver driver, String screenshotName) throws IOException
	{
		String dateName = new SimpleDateFormat("yyyyMMddhhmmss").format(new Date());
		TakesScreenshot ts = (TakesScreenshot) driver;
		File source = ts.getScreenshotAs(OutputType.FILE);
		String destination = System.getProperty("user.dir") + "/FailedTestsScreenshots/" + screenshotName + dateName + ".png";
		
		File finalDestination = new File(destination);
		FileUtils.copyFile(source, finalDestination);
		
		return destination;
	}
	
	@BeforeMethod()
	public void setUp()
	{
		System.setProperty("webdriver.chrome.driver", "config/chromedriver.exe");
		
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		driver.manage().timeouts().pageLoadTimeout(40, TimeUnit.SECONDS);
		
		driver.get("https://www.freecrm.com");
	}
	
	@Test()
	public void freeCrmTitleTest() {
		extentTest = extent.createTest("FreeCRMTitleTest");
		String title = driver.getTitle();
		System.out.println(title);
		Assert.assertEquals(title, "Free CRM software in the cloud");
		
	}
	
	
	@AfterMethod()
	public void tearDown(ITestResult result) throws IOException
	{
		if(result.getStatus() == ITestResult.FAILURE)
		{ 
			extentTest.log(Status.FAIL, "Test Case FAILED is" + result.getName());
			extentTest.log(Status.FAIL,  "Test Case FAILED is" + result.getThrowable());
			extentTest.log(Status.FAIL, MarkupHelper.createLabel(result.getName()+" Test case FAILED due to below issues:", ExtentColor.RED));
			String screenshotpath = this.getScreenshot(driver, result.getName());
			extentTest.log(Status.FAIL , "Test Case FAIL" + extentTest.addScreencastFromPath(screenshotpath));
			extentTest.log(Status.FAIL , "Test Case FAIL 2" + extentTest.addScreenCaptureFromPath(screenshotpath));
			
		}
		else if(result.getStatus() == ITestResult.SKIP)
		{
			extentTest.log(Status.SKIP, "Test case Skip is" + result.getName());
		}
		else if(result.getStatus() == ITestResult.SUCCESS)
		{
			extentTest.log(Status.PASS, "Test Case PASSED is" + result.getName());
			
			String screenshotpath = this.getScreenshot(driver, result.getName());
			extentTest.log(Status.PASS, MarkupHelper.createLabel(result.getName()+" Test Case PASSED", ExtentColor.GREEN));
			//extentTest.log(Status.PASS , "Test Case Passed " + extentTest.addScreencastFromPath(screenshotpath));
			extentTest.log(Status.PASS , "Screenshot  " + extentTest.addScreenCaptureFromPath(screenshotpath));
			
		}
		
/*		 extent.removeTest(extentTest);
	    ExtentTest logger2=extent.createTest("Logoff Test");
	    
	    logger2.log(Status.FAIL, "Title verified");
	    logger2.fail(result.getThrowable().getMessage(), MediaEntityBuilder.createScreenCaptureFromPath("D:/HousePic.jpg").build());
	    
	    logger2.fail("Failed because of some issues", MediaEntityBuilder.createScreenCaptureFromPath("D:/HousePic.jpg").build());
        
	    logger2.pass("Failed because of some issues", MediaEntityBuilder.createScreenCaptureFromPath("D:/HousePic.jpg").build());
	    
	    extent.removeTest(logger2);*/
		driver.quit();
	}
}
