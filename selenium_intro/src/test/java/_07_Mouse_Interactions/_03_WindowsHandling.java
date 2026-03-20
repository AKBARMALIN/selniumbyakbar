package _07_Mouse_Interactions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;
import java.util.Iterator;
import java.util.Set;

/**
 * Window Handling Test
 * 
 * This program demonstrates how to handle multiple windows in Selenium WebDriver.
 * It performs the following operations:
 * 1. Opens a login page in Chrome browser
 * 2. Clicks on a link that opens a new window (child window)
 * 3. Extracts an email address from the child window
 * 4. Switches back to the parent window
 * 5. Enters the extracted email in the login form
 */
public class _03_WindowsHandling {

    public static void main(String[] args) {
        // Initialize ChromeDriver instance
        WebDriver driver = new ChromeDriver();
        
        // Set implicit wait of 5 seconds for element visibility
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        
        // Maximize the browser window
        driver.manage().window().maximize();
        
        // Navigate to the login page URL
        driver.get("https://rahulshettyacademy.com/loginpagePractise/");

        // Find and click on the blinking text element that opens a new window
        WebElement blinkingText = driver.findElement(By.cssSelector(".blinkingText"));
        blinkingText.click();

        // Get all window handles (both parent and child windows)
        Set<String> windows = driver.getWindowHandles();
        
        // Create an iterator to traverse through the window handles
        Iterator<String> iterator = windows.iterator();
        
        // Get the ID of the parent (original) window
        String parentWindowId = iterator.next();
        
        // Get the ID of the child (newly opened) window
        String childWindowId = iterator.next();
        
        // Switch focus to the child window
        driver.switchTo().window(childWindowId);

        // Extract email from the child window:
        // Find the text element with class "im-para red"
        // Split by "at" and get the second part, trim whitespace, then split by space and get first part
        String email = driver.findElement(By.cssSelector(".im-para.red")).getText().split("at")[1].trim().split(" ")[0];
        
        // Switch focus back to the parent window
        driver.switchTo().window(parentWindowId);
        
        // Find the username input field and enter the extracted email
        driver.findElement(By.cssSelector("input[id='username']")).sendKeys(email);
    }
}
