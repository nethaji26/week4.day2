package week4.day2;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Assignment1PlayGround {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		
		//first task
		
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		driver.get("http://www.leafground.com/pages/Window.html");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30)); 
		driver.findElement(By.id("home")).click();
		String parenthandle = driver.getWindowHandle();
		Set<String> windowHandles = driver.getWindowHandles();
		List<String>multiplewindows = new ArrayList<String>(windowHandles);
		driver.switchTo().window(multiplewindows.get(1));
		System.out.println("The title in the first window is " +driver.getTitle());
		driver.close();
        driver.switchTo().window(parenthandle);
        System.out.println("parent window title is " +driver.getTitle());
        
        System.out.println("------------------------------------------------------------");
		
		//second task
		driver.findElement(By.xpath("//button[text()='Open Multiple Windows']")).click();
		
		String parenthandle1 = driver.getWindowHandle();
		Set<String> windowHandles1 = driver.getWindowHandles();
		List<String>multiplewindows1 = new ArrayList<String>(windowHandles1);
		int tabs  = multiplewindows1.size();
		System.out.println(" The number of opened tabs are " +tabs);
		driver.switchTo().window(multiplewindows1.get(1));
		System.out.println("The title in the first window is " +driver.getTitle());
		driver.close();
        driver.switchTo().window(multiplewindows1.get(2));
        System.out.println("second window title is " +driver.getTitle());
        driver.close();
        driver.switchTo().window(parenthandle1);
        System.out.println("parent window title is " +driver.getTitle());
        for (String numofopenedwindows : multiplewindows1)
        
        {
			System.out.println(" The opened windows are " + numofopenedwindows);
		}
		
        System.out.println("------------------------------------------------------------");
        
        //third task
        
        driver.findElement(By.xpath("(//button[@id='color'])[1]")).click();
        String parenthandle2 = driver.getWindowHandle();
		Set<String> windowHandles2 = driver.getWindowHandles();
		List<String>multiplewindows2 = new ArrayList<String>(windowHandles2);
		int tabs2  = multiplewindows2.size();
		System.out.println(" The number of opened tabs are " +tabs2);
		driver.switchTo().window(multiplewindows2.get(1));
		System.out.println("The title in the first window is " +driver.getTitle());
		
        driver.switchTo().window(multiplewindows2.get(2));
        System.out.println("The title in the second window is " +driver.getTitle());
        
        driver.switchTo().window(parenthandle2);
        System.out.println("The title in the parent window is " +driver.getTitle());
        
        System.out.println("------------------------------------------------------------");
        
       //fourth task
        
        driver.findElement(By.xpath("(//button[@id='color'])[2]")).click();
        Thread.sleep(5000);
        String parenthandle3 = driver.getWindowHandle();
		Set<String> windowHandles3 = driver.getWindowHandles();
		List<String>multiplewindows3 = new ArrayList<String>(windowHandles3);
		int tabs3  = multiplewindows3.size();
		System.out.println(" The number of opened tabs are " +tabs3);
		driver.switchTo().window(multiplewindows3.get(1));
		System.out.println("The title in the first window is " +driver.getTitle());
		driver.close();
		
        driver.switchTo().window(multiplewindows3.get(2));
        System.out.println("The title in the second window is " +driver.getTitle());
        driver.close();
        
        driver.switchTo().window(parenthandle3);
        System.out.println("The title in the parent window is " +driver.getTitle());
        
        
        
	}

}
