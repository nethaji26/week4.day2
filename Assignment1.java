package week4.day2;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Assignment1 {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		driver.get("http://leaftaps.com/opentaps/control/login");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		
		driver.findElement(By.id("username")).sendKeys("demosalesmanager");
		driver.findElement(By.id("password")).sendKeys("crmsfa");
		driver.findElement(By.className("decorativeSubmit")).click();
		driver.findElement(By.linkText("CRM/SFA")).click();
		driver.findElement(By.linkText("Contacts")).click();
		driver.findElement(By.linkText("Merge Contacts")).click();
		driver.findElement(By.xpath("(//img[@alt='Lookup'])[1]")).click();
		Set<String> windowHandles = driver.getWindowHandles();
		List<String>windowhandleslist = new ArrayList<String>(windowHandles);
		String newwindowhandle = windowhandleslist.get(1);
		String oldwindowhandle = windowhandleslist.get(0);
		
		//switching to new window
		driver.switchTo().window(newwindowhandle);
		System.out.println(driver.getCurrentUrl());
		System.out.println(driver.getTitle());
		driver.findElement(By.linkText("11969")).click();
		
		//switching to old window n
		driver.switchTo().window(oldwindowhandle);
		System.out.println(driver.getCurrentUrl());
		System.out.println(driver.getTitle());
		driver.findElement(By.xpath("(//img[@alt='Lookup'])[2]")).click();
		Thread.sleep(5000);
		
		//switching to new window
		Set<String> windowHandles2ndtime = driver.getWindowHandles();
		List<String>windowhandleslist2ndtime = new ArrayList<String>(windowHandles2ndtime);
		String newwindowhandle2ndtime = windowhandleslist2ndtime.get(1);
		driver.switchTo().window(newwindowhandle2ndtime);
		System.out.println(driver.getCurrentUrl());
		driver.findElement(By.linkText("11974")).click();
		
		//click on merge button in old window
		driver.switchTo().window(windowhandleslist2ndtime.get(0));
		driver.findElement(By.linkText("Merge")).click();
		
		//switch to alert
		Alert alert = driver.switchTo().alert();
		String Alerttext = alert.getText();
		alert.accept();
		System.out.println(" The text in the alert is " + Alerttext);
		String webpagemessage = driver.getTitle();
		System.out.println(webpagemessage);
		
		
		
		
		

	}

}
