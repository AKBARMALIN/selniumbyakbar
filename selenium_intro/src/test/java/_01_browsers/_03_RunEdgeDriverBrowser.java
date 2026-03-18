package _01_browsers;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;

/**
 * This class demonstrates how to run an Edge browser using Selenium WebDriver.
 * It navigates to a website, retrieves the page title and current URL, prints them, and then quits the browser.
 */
public class _03_RunEdgeDriverBrowser {

    public static void main(String[] args) {

        // Create a new EdgeDriver instance to control the Edge browser
        WebDriver driver = new EdgeDriver();

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

        // Quit the browser, closing all associated windows
        driver.quit();
    }
}
