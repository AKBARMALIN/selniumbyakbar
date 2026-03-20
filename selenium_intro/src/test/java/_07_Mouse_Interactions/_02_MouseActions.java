package _07_Mouse_Interactions;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import java.time.Duration;

/**
 * Mouse Actions Test
 * 
 * This program demonstrates Selenium WebDriver mouse interaction capabilities using the Actions class.
 * It performs the following operations on the Amazon.in website:
 * 1. Hovers over the Sign In button and performs a right-click (context click)
 * 2. Hovers over the search box, clicks it, enters text in uppercase, and double-clicks to select
 * 
 * The Actions class allows chaining multiple mouse/keyboard actions for complex interactions.
 */
public class _02_MouseActions {

    public static void main(String[] args) {
        // Initialize ChromeDriver instance
        WebDriver driver = new ChromeDriver();
        
        // Set implicit wait of 5 seconds for element visibility
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        
        // Maximize the browser window to ensure all elements are visible
        driver.manage().window().maximize();
        
        // Navigate to Amazon India homepage
        driver.get("https://www.amazon.in/");

        // Locate the Sign In button using XPath
        // XPath: Find div with id 'nav-link-accountList', then find child 'a' element with 'signin' role
        WebElement signIn = driver.findElement(By.xpath("//div[@id='nav-link-accountList']//a[@data-nav-role='signin']"));
        
        // Locate the search input box using XPath
        // XPath: Find input element with id 'twotabsearchtextbox'
        WebElement search = driver.findElement(By.xpath("//input[@id='twotabsearchtextbox']"));

        // Create Actions object to perform advanced mouse and keyboard interactions
        // Actions class allows chaining multiple actions together
        Actions actions = new Actions(driver);

        // OPERATION 1: Hover over Sign In button and perform right-click (context click)
        // moveToElement() = moves mouse to the specified element (hover effect)
        // contextClick() = performs a right-click on the element (opens context menu)
        // build() = builds the action chain
        // perform() = executes all chained actions
        actions.moveToElement(signIn).contextClick().build().perform();

        // OPERATION 2: Multiple chained actions on the search box
        // moveToElement(search) = hover over the search input field
        // click() = single click on the search box to focus it
        // keyDown(Keys.SHIFT) = press and hold the SHIFT key for uppercase input
        // sendKeys("akbar") = type the text 'akbar' while SHIFT is held (enters as 'AKBAR')
        // doubleClick() = double-click on the search box to select all the typed text
        actions.moveToElement(search).click().keyDown(Keys.SHIFT).sendKeys("akbar").doubleClick().build().perform();

        // Close the browser and cleanup all resources
        driver.quit();
    }
}
