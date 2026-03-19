package _09_miscllaneous;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.io.File;
import java.io.IOException;
import java.time.Duration;

/**
 * This class demonstrates how to capture screenshots using Selenium WebDriver.
 * It sets up a Chrome browser, navigates to a website, and takes a screenshot of the page,
 * saving it to a specified file path.
 */
public class _03_Screenshot {

    public static void main(String[] args) throws IOException {

        // Create a new ChromeDriver instance to control the Chrome browser
        WebDriver driver = new ChromeDriver();

        // Set an implicit wait of 5 seconds for elements to load
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

        // Set a page load timeout of 5 seconds
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(5));

        // Delete all cookies from the browser
        driver.manage().deleteAllCookies();

        // Maximize the browser window
        driver.manage().window().maximize();

        // Navigate to the Google homepage
        driver.get("https://www.google.com");

        // Cast the WebDriver to TakesScreenshot and capture the screenshot as a File
        File src = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);

        // Copy the screenshot file to the specified path in the project directory
        FileUtils.copyFile(src, new File("./screenshots/google.png"));
    }
}
