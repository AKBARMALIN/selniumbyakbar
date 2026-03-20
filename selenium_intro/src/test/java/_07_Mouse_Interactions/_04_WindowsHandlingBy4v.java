package _07_Mouse_Interactions;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.Iterator;
import java.util.Set;

/**
 * Window Handling and Screenshot Capture Test
 * 
 * This program demonstrates advanced Selenium WebDriver features:
 * 1. Opens a parent window with an Angular practice page
 * 2. Programmatically opens a new tab (child window)
 * 3. Retrieves and extracts data (course name) from the child window
 * 4. Switches back to the parent window and populates a form
 * 5. Captures a screenshot of a specific web element
 * 6. Saves the screenshot to a file
 */
public class _04_WindowsHandlingBy4v {

    public static void main(String[] args) throws IOException {
        // Initialize ChromeDriver instance
        WebDriver driver = new ChromeDriver();
        
        // Set implicit wait of 5 seconds for element visibility
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        
        // Navigate to the parent window URL (Angular practice page)
        driver.get("https://rahulshettyacademy.com/angularpractice/");

        // Programmatically open a new tab (TAB is preferred over WINDOW for modern browsers)
        // This creates a child window/tab while keeping the parent window open
        driver.switchTo().newWindow(WindowType.TAB);

        // Get all window handles (parent and newly created child)
        Set<String> window = driver.getWindowHandles();
        
        // Create an iterator to traverse through the window handles
        Iterator<String> it = window.iterator();
        
        // Get the ID of the parent window (first handle)
        String parentWindowId = it.next();
        
        // Get the ID of the child window (second handle)
        String childWindowId = it.next();
        
        // Switch focus to the child window
        driver.switchTo().window(childWindowId);
        
        // Navigate to the academy home page in the child window
        driver.get("https://rahulshettyacademy.com/");

        // Find and extract the text of the first course name from the child window
        // XPath explanation:
        //   - //div[contains(@class, 'rounded')] = finds div with 'rounded' class
        //   - //div[@class='relative']/following-sibling::div/h3[1] = navigates to h3 element
        String firstCourse = driver.findElement(By.xpath("//div[contains(@class, 'rounded')] //div[@class='relative']/following-sibling::div/h3[1]")).getText();
        
        // Switch focus back to the parent window
        driver.switchTo().window(parentWindowId);
        
        // Find the name input field (by name attribute) in the parent window form
        WebElement nameEditBox = driver.findElement(By.name("name"));
        
        // Enter the extracted course name into the name input field
        nameEditBox.sendKeys(firstCourse);

        // Capture a screenshot of the specific web element (not the entire page)
        // This returns a File object containing the element screenshot
        File file = nameEditBox.getScreenshotAs(OutputType.FILE);
        
        // Copy the screenshot file to the desired location
        // Creates "screenshots" folder if it doesn't exist and saves as "name.png"
        FileUtils.copyFile(file, new File("./screenshots/name.png"));
        
        // Close the driver and cleanup resources
        driver.quit();
    }
}
