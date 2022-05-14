package week4.day2;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Assignment4 {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		driver.get("https://www.amazon.in/ref=nav_logo");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30)); 
		driver.findElement(By.id("twotabsearchtextbox")).sendKeys("oneplus 9 pro",Keys.ENTER);
		//get price of first product
		String firstproductprice = driver.findElement(By.xpath("//span[@class='a-price-whole']")).getText();
		System.out.println("The first product price is " + firstproductprice);
		String Ratings = driver.findElement(By.xpath("//span[@class='a-size-base s-underline-text']")).getText();
		System.out.println(" The ratings is " +Ratings);
		driver.findElement(By.xpath("//span[@class='a-size-medium a-color-base a-text-normal']")).click();
		Set<String> windowHandles = driver.getWindowHandles();
		List<String>windowhandleslist = new ArrayList<String>(windowHandles);
		driver.switchTo().window(windowhandleslist.get(1));
		System.out.println("The new window title is " + driver.getTitle());
		//taking screen shot in new window
		File srcfile = driver.getScreenshotAs(OutputType.FILE);
		File destfile = new File("./snaps/amazonscreenshot.png");
		FileUtils.copyFile(srcfile,destfile);
		//add to cart
		driver.findElement(By.id("add-to-cart-button")).click();
		String text = driver.findElement(By.xpath("//span[@class='a-price-whole']")).getText();
		if(text == "34,990")
		{
			System.out.println(" The price matching");
		}else
			System.out.println(" The prices are not matching");
		
		driver.close();

	}

}
