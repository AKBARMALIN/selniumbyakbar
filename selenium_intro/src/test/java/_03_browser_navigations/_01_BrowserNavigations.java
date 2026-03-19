package _03_browser_navigations;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

/**
 * This class demonstrates browser navigation methods in Selenium WebDriver.
 * It provides examples of navigating to different URLs, going back and forward in browser history,
 * refreshing the current page, and other navigation-related operations.
 */
public class _01_BrowserNavigations {

    public static void main(String[] args) throws InterruptedException {

        // Create a new ChromeDriver instance to control the Chrome browser
        WebDriver driver = new ChromeDriver();

        // Navigate to the first URL
        driver.get("https://www.google.com");

        // Print the title of the current page
        System.out.println("Title after navigating to Google: " + driver.getTitle());

        // Use navigate().to() to go to another URL (similar to get() but allows more navigation methods)
        driver.navigate().to("https://www.selenium.dev");

        // Print the title after navigating to Selenium website
        System.out.println("Title after navigating to Selenium: " + driver.getTitle());

        // Go back to the previous page in browser history
        driver.navigate().back();

        // Print the title after going back
        System.out.println("Title after going back: " + driver.getTitle());

        // Go forward in browser history
        driver.navigate().forward();

        // Print the title after going forward
        System.out.println("Title after going forward: " + driver.getTitle());

        // Refresh the current page
        driver.navigate().refresh();

        // Print the title after refreshing
        System.out.println("Title after refreshing: " + driver.getTitle());

        // Pause for a moment to observe (in real scenarios, use WebDriverWait instead)
        Thread.sleep(2000);

        // Close the browser window
        driver.close();
    }
}
