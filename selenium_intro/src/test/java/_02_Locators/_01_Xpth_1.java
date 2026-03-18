package _02_Locators;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

/**
 * This class demonstrates the use of XPath locators in Selenium WebDriver to find and interact with web elements.
 * It navigates to Amazon India, and uses various XPath expressions to locate search input fields and links.
 * Examples include exact attribute matching, contains, starts-with, and ends-with functions.
 */
public class _01_Xpth_1 {
    public static void main(String[] args) {

        // Initialize a new ChromeDriver instance to control the Chrome browser
        WebDriver driver = new ChromeDriver();

        // Set an implicit wait of 5 seconds for elements to be available
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

        // Maximize the browser window
        driver.manage().window().maximize();

        // Navigate to Amazon India website
        driver.get("https://www.amazon.in/");

        // Find the search input by exact class attribute match and send "java" as input
        driver.findElement(By.xpath("//input[@class='actextbox']")).sendKeys("java");

        // Find the search input by exact name attribute match and send "java" as input
        driver.findElement(By.xpath("//input[@name='query']")).sendKeys("java");

        // Find the search input using contains function on class attribute and send "java" as input
        driver.findElement(By.xpath("//input[contains(@class, 'actextbox')]")).sendKeys("java");

        // Example for dynamic id: using starts-with function
        // Assuming id starts with 'test_', find the input and send "java"
        driver.findElement(By.xpath("//input[starts-with(@id, 'test_')]")).sendKeys("java");

        // Example for dynamic id: using ends-with function
        // Assuming id ends with '_test_t', find the input and send "java"
        driver.findElement(By.xpath("//input[ends-with(@id, '_test_t')]")).sendKeys("java");

        // For links: custom XPath to find a link containing 'My Account' text and click it
        // All links are represented by <a> tag in HTML
        driver.findElement(By.xpath("//a[contains(text(), 'My Account')]")).click();
    }
}
