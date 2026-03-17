package _01_selenium_sessions;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class _01_WebDriver_Basics {
	
	public static void main(String[] args) {

		String browser = "chrome";
		WebDriver driver = null;
		
		if(browser.equalsIgnoreCase("chrome")) {
			driver = new ChromeDriver();
		} else if(browser.equalsIgnoreCase("firefox")) {
			driver = new FirefoxDriver();
		} else if(browser.equalsIgnoreCase("edge")) {
			driver = new EdgeDriver();
		} else {
			System.out.println("Invalid browser");
		}

		driver.get("https://www.google.com");
		String title = driver.getTitle();
		if(title.equals("Google")) {
			System.out.println("Title correct");
		} else {
			System.out.println("Title is incorrect");
		}
	}
}