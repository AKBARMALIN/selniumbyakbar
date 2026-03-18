package _01_browsers;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

/**
 * This class demonstrates how to run a Chrome browser using Selenium WebDriver.
 * It navigates to a website, retrieves the page title and current URL, prints them, and then closes the browser.
 */
public class _01_RunChromeBrowser {

    public static void main(String[] args) {

        // Create a new ChromeDriver instance to control the Chrome browser
        WebDriver driver = new ChromeDriver();

        // Navigate to the specified URL
        driver.get("https://www.rahulshettyacademy.com");

        // Get the title of the current page
        String title = driver.getTitle();

        // Print the title to the console
        System.out.println(title);

        // Get the current URL of the page
        String currentUrl = driver.getCurrentUrl();

        // Print the current URL to the console
        System.out.println(currentUrl);

        // Close the browser window
        driver.close();
    }
}
