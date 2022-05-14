package week4.day2;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.WebDriver.Timeouts;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Assignment3Leafgrounddropdwn {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		driver.get("http://www.leafground.com/pages/Dropdown.html");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		WebElement firstdropdown = driver.findElement(By.id("dropdown1"));	
		//select by index
		Select s1 = new Select(firstdropdown);
		s1.selectByIndex(4);
		//select by visible text
		WebElement dropdown2 = driver.findElement(By.name("dropdown2"));
		Select s2 = new Select(dropdown2);
		s2.selectByVisibleText("UFT/QTP");
		//select by value
		WebElement dropdown3 = driver.findElement(By.id("dropdown3"));
		Select s3 = new Select(dropdown3);
		s3.selectByValue("3");
		//get number of drop down options
		WebElement dropdown4 = driver.findElement(By.className("dropdown"));
		Select s4 = new Select(dropdown4);
		List<WebElement> dropdown4options = s4.getOptions();
		for (WebElement eachoptions : dropdown4options)
		{
			System.out.println("The options in drop down 4 are " +eachoptions.getText());
		}
		
		//send keys to drop down5
		driver.findElement(By.xpath("(//div[@class='example']/select)[5]")).sendKeys("Appium");
		
		//selecting multiple drop down values
		
		WebElement dropdown5 = driver.findElement(By.xpath("(//div[@class='example'])[6]/select"));
		Select s5 = new Select(dropdown5);
		s5.selectByIndex(0);
		s5.selectByValue("1");
		s5.selectByVisibleText("Loadrunner");
		

	}

}
