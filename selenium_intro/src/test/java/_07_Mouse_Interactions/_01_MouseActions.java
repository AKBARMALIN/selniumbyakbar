package _07_Mouse_Interactions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import java.time.Duration;

/**
 * This class demonstrates mouse interactions using Selenium WebDriver's Actions class.
 * It navigates to a website, performs a mouse hover action on a menu item, and clicks on a submenu item.
 */
public class _01_MouseActions {

    public static void main(String[] args) {
        // Initialize a new ChromeDriver instance to control the Chrome browser
        WebDriver driver = new ChromeDriver();

        // Set an implicit wait of 5 seconds for elements to be available
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

        // Maximize the browser window
        driver.manage().window().maximize();

        // Navigate to the specified URL
        driver.get("https://www.ebay.com/");

        // Locate the "Electronics" menu item
        WebElement electronics = driver.findElement(By.xpath("//a[text()='Electronics']"));

        // Create an Actions object to perform complex user interactions
        Actions actions = new Actions(driver);

        // Perform a mouse hover over the "Electronics" menu item
        actions.moveToElement(electronics).perform();

        // Locate the "Apple" submenu item under Electronics
        WebElement apple = driver.findElement(By.xpath("//a[text()='Apple']"));

        // Click on the "Apple" submenu item
        apple.click();
    }
}
