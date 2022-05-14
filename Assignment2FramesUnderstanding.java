package week4.day2;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Assignment2FramesUnderstanding {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		driver.get("https://chercher.tech/practice/frames-example-selenium-webdriver");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		String Pagetitle = driver.findElement(By.tagName("h1")).getText();
		System.out.println("The page title is " + Pagetitle);
		String secondtitle = driver.findElement(By.xpath("//div[@class='card mb-3']//label")).getText();
		System.out.println(" The second title is " + secondtitle);
		//switching to first frame
		WebElement firstframe = driver.findElement(By.id("frame1"));
		driver.switchTo().frame(firstframe);
		driver.findElement(By.xpath("//b[@id='topic']/following-sibling::input")).sendKeys("Nethaji");
		//driver.findElement(By.class)
		//switching to 2nd frame
		WebElement secondframe = driver.findElement(By.id("frame3"));
		driver.switchTo().frame(secondframe);
		driver.findElement(By.xpath("//input[@id='a']")).click();
		//coming back to first frame
		driver.switchTo().parentFrame();
		driver.findElement(By.xpath("//b[@id='topic']/following-sibling::input")).sendKeys(" sairam");
		
		
		//getting access back to normal page
		driver.switchTo().defaultContent();
		Thread.sleep(3000);
		//switching to lastframe
		WebElement lastframe = driver.findElement(By.id("frame2"));		
		driver.switchTo().frame(lastframe);
		WebElement dropdown = driver.findElement(By.id("animals"));
		Select s1 = new Select(dropdown);
		s1.selectByIndex(1);
		List<WebElement> options = s1.getOptions();
		//System.out.println(options);
		for (WebElement eachoptions : options)
		{
			System.out.println(eachoptions.getText());
		}

		
		
		
		
	}

}
