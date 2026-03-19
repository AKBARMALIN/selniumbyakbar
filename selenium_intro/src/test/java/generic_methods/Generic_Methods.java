package generic_methods;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;
import java.io.IOException;
import java.time.Duration;

public class Generic_Methods {

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

    /**
     * Waits for the specified element to be visible and then sends the given text to it.
     * This method uses WebDriverWait with ExpectedConditions.visibilityOf.
     *
     * @param driver   The WebDriver instance
     * @param locator  The WebElement to send keys to
     * @param text     The text to send to the element
     * @param timeout  The maximum time to wait in seconds
     */
    public static void sendKeysOn(WebDriver driver, WebElement locator, String text, int timeout) {
        new WebDriverWait(driver, Duration.ofSeconds(timeout))
                .until(ExpectedConditions.visibilityOf(locator));

        locator.sendKeys(text);
    }

    /**
     * Waits for the specified element to be visible.
     * This method uses WebDriverWait with ExpectedConditions.visibilityOf.
     *
     * @param driver   The WebDriver instance
     * @param locator  The WebElement to wait for visibility
     * @param timeout  The maximum time to wait in seconds
     */
    public static void waitForElementVisible(WebDriver driver, WebElement locator, int timeout) {
        new WebDriverWait(driver, Duration.ofSeconds(timeout))
                .until(ExpectedConditions.visibilityOf(locator));
    }

    /**
     * Waits for the specified element to be present in the DOM.
     * This method uses WebDriverWait with ExpectedConditions.presenceOfElementLocated.
     *
     * @param driver   The WebDriver instance
     * @param locator  The By locator of the element to wait for
     * @param timeout  The maximum time to wait in seconds
     */
    public static void waitForElementPresent(WebDriver driver, By locator, int timeout) {
        new WebDriverWait(driver, Duration.ofSeconds(timeout))
                .until(ExpectedConditions.presenceOfElementLocated(locator));
    }

    /**
     * Waits for the specified element to be invisible or not present.
     * This method uses WebDriverWait with ExpectedConditions.invisibilityOf.
     *
     * @param driver   The WebDriver instance
     * @param locator  The WebElement to wait for invisibility
     * @param timeout  The maximum time to wait in seconds
     */
    public static void waitForElementInvisible(WebDriver driver, WebElement locator, int timeout) {
        new WebDriverWait(driver, Duration.ofSeconds(timeout))
                .until(ExpectedConditions.invisibilityOf(locator));
    }

    /**
     * Waits for the page title to contain the specified text.
     * This method uses WebDriverWait with ExpectedConditions.titleContains.
     *
     * @param driver   The WebDriver instance
     * @param title    The text to check in the page title
     * @param timeout  The maximum time to wait in seconds
     */
    public static void waitForTitleContains(WebDriver driver, String title, int timeout) {
        new WebDriverWait(driver, Duration.ofSeconds(timeout))
                .until(ExpectedConditions.titleContains(title));
    }

    /**
     * Waits for the URL to contain the specified text.
     * This method uses WebDriverWait with ExpectedConditions.urlContains.
     *
     * @param driver   The WebDriver instance
     * @param urlFraction The text to check in the current URL
     * @param timeout     The maximum time to wait in seconds
     */
    public static void waitForUrlContains(WebDriver driver, String urlFraction, int timeout) {
        new WebDriverWait(driver, Duration.ofSeconds(timeout))
                .until(ExpectedConditions.urlContains(urlFraction));
    }

    /**
     * Generic method to capture a screenshot of the current page and save it to a file.
     * The screenshot is saved in the "./screenshots/" directory with the given filename and ".png" extension.
     *
     * @param driver   The WebDriver instance used to capture the screenshot
     * @param fileName The name of the file to save the screenshot (without extension)
     * @throws IOException If an error occurs while saving the screenshot file
     */
    public static void takeScreenshot(WebDriver driver, String fileName) throws IOException {
        // Cast the WebDriver to TakesScreenshot and capture the screenshot as a File
        File src = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);

        // Copy the screenshot file to the specified path in the screenshots directory
        FileUtils.copyFile(src, new File("./screenshots/" + fileName + ".png"));
    }

}
