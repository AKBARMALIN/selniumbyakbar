package _02_mouse_interactions;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import java.time.Duration;

/**
 * Demonstrates advanced mouse interactions using Selenium WebDriver's Actions class.
 * @author Akbar Shaik
 */
public class _01_MouseActions {

    public static void main(String[] args) {
        // Initialize ChromeDriver instance
        WebDriver driver = new ChromeDriver();
        
        // Set implicit wait to 5 seconds for element loading
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        
        // Maximize the browser window for better visibility
        driver.manage().window().maximize();
        
        // Navigate to Amazon India homepage
        driver.get("https://www.amazon.in/");

        // Locate the sign-in link element using XPath
        // XPath finds the anchor tag with data-nav-role='signin' inside the account list div
        WebElement signIn = driver.findElement(By.xpath("//div[@id='nav-link-accountList']//a[@data-nav-role='signin']"));
        
        // Locate the search input box using XPath
        WebElement search = driver.findElement(By.xpath("//input[@id='twotabsearchtextbox']"));

        // Create Actions instance for performing complex user interactions
        Actions actions = new Actions(driver);

        // Perform context click (right-click) on the sign-in element
        // moveToElement() moves the mouse cursor to the element
        // contextClick() performs a right-click action
        // build().perform() builds the action sequence and executes it
        actions.moveToElement(signIn).contextClick().build().perform();
        
        // Perform a sequence of actions on the search input:
        // 1. moveToElement(search) - Move mouse to search box
        // 2. click() - Click on the search box
        // 3. keyDown(Keys.SHIFT) - Press and hold Shift key
        // 4. sendKeys("akbar") - Type "akbar" (appears as "AKBAR" due to Shift)
        // 5. doubleClick() - Perform a double-click
        // build().perform() - Execute the entire sequence
        actions.moveToElement(search).click().keyDown(Keys.SHIFT).sendKeys("akbar").doubleClick().build().perform();

        // Properly close the browser and clean up resources
        driver.quit();
    }
}
