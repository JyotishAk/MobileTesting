import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.BeforeTest;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;

public class DemoTest {


	AndroidDriver driver;
	
	@BeforeTest
	public void BeforeTest() throws MalformedURLException {
		DesiredCapabilities cap = new DesiredCapabilities();
		cap.setCapability(MobileCapabilityType.DEVICE_NAME, "Jyotish");
		cap.setCapability(MobileCapabilityType.PLATFORM_NAME, "Android");
		cap.setCapability(MobileCapabilityType.BROWSER_NAME, "Chrome");
		driver = new AndroidDriver<>(new URL("http://0.0.0.0:4723/wd/hub"),cap);
		
	}
	@org.testng.annotations.Test
	public void Test() throws InterruptedException {
		driver.get("http://demowebshop.tricentis.com/login");
		driver.findElement(By.xpath("//*[@class='ico-register']")).click();
		Thread.sleep(5000);
		driver.findElement(By.xpath("//*[@id='gender-male']")).click();
		driver.findElement(By.xpath("//*[@id='FirstName']")).sendKeys("Test1234");
		driver.findElement(By.xpath("//*[@id='LastName']")).sendKeys("TEST3524");
		driver.findElement(By.xpath("//*[@id='Email']")).sendKeys("Testtsdf398tt8e0st131@gmail.com");
		driver.findElement(By.xpath("//*[@id='Password']")).sendKeys("testing");
		driver.findElement(By.xpath("//*[@id='ConfirmPassword']")).sendKeys("testing");
		driver.findElement(By.xpath("//*[@id='register-button']")).click();
		Thread.sleep(5000);
		List<WebElement> elementList = driver.findElements(By.xpath("//*[@class='validation-summary-errors']/ul/li"));
		List<WebElement> elementList1 = driver.findElements(By.xpath("//*[@class='result']"));
		if(elementList.size()>0){
			String result = driver.findElement(By.xpath("//*[@class='validation-summary-errors']/ul/li")).getText();
			System.out.println(result);
		}
		else if(elementList1.size()>0){
			String result = driver.findElement(By.xpath("//*[@class='result']")).getText();
			System.out.println(result);
			List<WebElement> elementList2 = driver.findElements(By.xpath("//*[@class='ico-logout']"));
			
			if(elementList2.size()>0){
				driver.findElement(By.xpath("//*[@class='ico-logout']")).click();
				System.out.println("Logged out Successfully");
			}
		}	
	}
}
