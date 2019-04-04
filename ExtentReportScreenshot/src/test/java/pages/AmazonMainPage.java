package pages;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class AmazonMainPage {

	public WebDriver driver;
	
	public void launchBrowser()
	{
		System.setProperty("webdriver.chrome.driver", "config/chromedriver.exe");
		
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		driver.get("https://www.amazon.in/");
	}
	
	public void SearchFictionBooks() throws InterruptedException
	{
	
		driver.findElement(By.xpath("//span[text()='Category']")).click();
		
		WebElement category = driver.findElement(By.xpath("//span[text()='Books & Audible']"));
		Actions action = new Actions(driver);
		action.moveToElement(category).perform();
		Thread.sleep(2000);
		
		WebElement bookslink = driver.findElement(By.xpath("//span[text()='Fiction Books']"));
		action.moveToElement(bookslink);
		action.click().perform();

	}
	
	public String getPageTitle()
	{
		return driver.getTitle(); 
	}
	
	public void closedriver()
	{
		driver.quit();
	}
}
