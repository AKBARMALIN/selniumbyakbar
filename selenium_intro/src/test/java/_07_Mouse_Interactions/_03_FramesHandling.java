package _07_Mouse_Interactions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import java.time.Duration;

/**
 * Demonstrates frame handling and drag-and-drop operations using Selenium WebDriver.
 * @author Akbar Shaik
 */
public class _03_FramesHandling {

    public static void main(String[] args) {
        // Initialize ChromeDriver instance
        WebDriver driver = new ChromeDriver();
        
        // Set implicit wait to 5 seconds for element loading
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        
        // Navigate to jQuery UI Droppable demo page
        driver.get("https://jqueryui.com/droppable/");

        // Frame is a part of web page which displays content independent of its container.
        // Locate the demo frame element using XPath
        WebElement frameByElement = driver.findElement(By.xpath("//iframe[@class='demo-frame']"));

        // To know how many frames present in the web page
        // Count all iframe elements on the page and print the result
        int size = driver.findElements(By.tagName("iframe")).size();
        System.out.println("The number of frames present in the webpage are: " + size);

        // Switch WebDriver context to the frame
        // Option 1: Switch by frame index (0-based) - commented out
        // driver.switchTo().frame(0);
        
        // Option 2: Switch by WebElement reference - more reliable when frame position changes
        driver.switchTo().frame(frameByElement);

        // Now we can interact with elements inside the frame
        // Locate the draggable source element
        WebElement source = driver.findElement(By.xpath("//div[@id='draggable']"));
        
        // Locate the droppable target element
        WebElement target = driver.findElement(By.xpath("//div[@id='droppable']"));

        // Create Actions instance for performing complex user interactions
        Actions actions = new Actions(driver);
        
        // Perform drag-and-drop using manual sequence:
        // 1. clickAndHold(source) - Click and hold the source element
        // 2. moveToElement(target) - Move mouse to the target element
        // 3. release() - Release the mouse button
        // build().perform() - Execute the action sequence
        actions.clickAndHold(source).moveToElement(target).release().build().perform();
        
        // Alternative: Use built-in dragAndDrop method (commented out)
        // This is simpler but may not work consistently across all browsers
        // actions.dragAndDrop(source, target).build().perform();

        // Go to out of frame - Switch back to the main page content
        // This is crucial to interact with elements outside the frame
        driver.switchTo().defaultContent();
        
        // Note: In production code, always close the driver:
        // driver.quit();
    }
}
