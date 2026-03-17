package _01_selenium_sessions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

/**
 * Demonstrates file upload functionality using Selenium WebDriver.
 * @author Akbar Shaik
 */
public class _02_File_Upload {

    public static void main(String[] args) throws InterruptedException {
        // Initialize ChromeDriver instance
        WebDriver driver = new ChromeDriver();
        
        // Navigate to the file input test website
        driver.get("https://html.com/input-type-file/");
        
        // Wait 3 seconds for the page to fully load and render
        Thread.sleep(3000);
        
        // Locate the file input element by XPath and send the file path
        // XPath explanation: //input[@name='fileupload'] finds any input element with name attribute = 'fileupload'
        // sendKeys() simulates typing the file path and automatically submits the file
        driver.findElement(By.xpath("//input[@name='fileupload']")).sendKeys("C:\\Users\\Akbar Shaik\\OneDrive\\Documents\\ebook.pdf");
        
        // NOTE: In a production environment, it's recommended to close the driver:
        driver.quit();
    }
}
