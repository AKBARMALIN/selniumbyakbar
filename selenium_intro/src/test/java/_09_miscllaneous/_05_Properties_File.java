package _09_miscllaneous;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

/**
 * This class demonstrates how to use a properties file to configure Selenium WebDriver settings,
 * such as browser type, URL, and element locators. It reads configuration from a properties file
 * and performs basic actions like launching the browser and entering text into a field.
 */
public class _05_Properties_File {

    // Static WebDriver instance to be used across the class
    static WebDriver driver;

    public static void main(String[] args) throws IOException {

        // Create a Properties object to hold configuration data
        Properties props = new Properties();

        // Load the properties file from the current working directory
        FileInputStream fis = new FileInputStream(System.getProperty("user.dir") + "\\Files\\config.properties");
        props.load(fis);

        // Retrieve the browser type from properties
        String browser = props.getProperty("browser");

        // Initialize the WebDriver based on the browser specified in properties
        if(browser.equalsIgnoreCase("edge")) {
            driver = new EdgeDriver();
        } else if(browser.equalsIgnoreCase("chrome")) {
            driver = new ChromeDriver();
        } else if(browser.equalsIgnoreCase("firefox")) {
            driver = new FirefoxDriver();
        } else {
            System.out.println("Invalid driver name");
        }

        // Navigate to the URL specified in properties
        driver.get(props.getProperty("url"));

        // Set an implicit wait of 10 seconds for elements to load
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        // Find the element using XPath from properties and send keys (enter text)
        driver.findElement(By.xpath(props.getProperty("name_xpath"))).sendKeys(props.getProperty("name"));

    }
}
