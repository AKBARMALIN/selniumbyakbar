package _06_synchronization;

import org.openqa.selenium.By;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

/**
 * This class demonstrates explicit synchronization in Selenium WebDriver.
 * Explicit waits are used to wait for specific conditions to occur before proceeding with the test.
 * Unlike implicit waits, explicit waits are applied to specific elements and can wait for various conditions
 * like element visibility, clickability, presence, etc. This class shows an example of using WebDriverWait
 * to wait for an element to be clickable before clicking it.
 */
public class _02_Synch_explicit {

    public static void main(String[] args) {
        // Create a new EdgeDriver instance to control the Edge browser
        WebDriver driver = new EdgeDriver();

        // Maximize the browser window
        driver.manage().window().maximize();

        // Delete all cookies from the browser to ensure a clean session
        driver.manage().deleteAllCookies();

        // Navigate to the Facebook homepage
        driver.get("https://www.facebook.com/");

        // Find the login button element using XPath locator
        WebElement login = driver.findElement(By.xpath("//form[@id='login_form']//span[contains(text(), 'Log in')]"));

        // Use the custom clickOn method to wait for the element to be clickable and then click it
        clickOn(driver, login, 5);

    }

    /**
     * Waits for the specified element to be clickable and then clicks on it.
     * This method uses WebDriverWait with ExpectedConditions.elementToBeClickable,
     * ignoring StaleElementReferenceException.
     *
     * @param driver   The WebDriver instance
     * @param locator  The WebElement to click on
     * @param timeout  The maximum time to wait in seconds
     */
    public static void clickOn(WebDriver driver, WebElement locator, int timeout) {
        new WebDriverWait(driver, Duration.ofSeconds(timeout)).ignoring(StaleElementReferenceException.class)
                .until(ExpectedConditions.elementToBeClickable(locator));

        locator.click();
    }
}
