package _06_synchronization;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;
import java.util.Arrays;
import java.util.List;

/**
 * This class demonstrates implicit synchronization in Selenium WebDriver.
 * Implicit waits tell the WebDriver to wait for a certain amount of time before throwing an exception
 * when trying to find an element that is not immediately available. This helps in handling dynamic content
 * where elements may take time to load.
 */
public class _01_Synch_implicit {

    public static void main(String[] args) throws InterruptedException {

        // Create a new ChromeDriver instance to control the Chrome browser
        WebDriver driver = new ChromeDriver();

        // Navigate to the Rahul Shetty Academy Selenium Practise website
        driver.get("https://rahulshettyacademy.com/seleniumPractise");

        // Set an implicit wait of 5 seconds for elements to load
        // This means WebDriver will wait up to 5 seconds for elements to appear before throwing NoSuchElementException
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        
        // Define the list of items to add to the cart
        String[] itemsList = {"Tomato", "Potato", "Apple", "Orange", "Pista"};

        // Call the helper method to add the specified items to the cart
        addItemsToCart(driver, itemsList);

        // Click on the cart icon to view the cart
        driver.findElement(By.cssSelector("img[alt='Cart']")).click();

        // Click the "PROCEED TO CHECKOUT" button
        driver.findElement(By.xpath("//button[contains(text(), 'PROCEED TO CHECKOUT')]")).click();

        // Enter the promo code in the input field
        driver.findElement(By.cssSelector(".promoCode")).sendKeys("rahulshettyacademy");

        // Click the promo button to apply the code
        driver.findElement(By.cssSelector(".promoBtn")).click();

        // Retrieve and print the promo information message
        String promoInfo = driver.findElement(By.cssSelector(".promoInfo")).getText();
        System.out.println(promoInfo);

        // Quit the browser and close all associated windows
        driver.quit();

    }

    /**
     * Helper method to add specified items to the shopping cart.
     * It iterates through the list of products on the page and clicks the "ADD TO CART" button
     * for items that match the provided list.
     * 
     * @param driver The WebDriver instance used to interact with the browser
     * @param itemsList Array of item names to add to the cart
     */
    public static void addItemsToCart(WebDriver driver, String[] itemsList) {
        // Initialize a counter to track how many items have been added
        int count = 0;

        // Find all product name elements on the page
        List<WebElement> products = driver.findElements(By.cssSelector("h4.product-name"));

        // Loop through each product
        for(int i = 0; i < products.size(); i++) {
            // Get the product name, split by "-" and trim to get the clean name
            String product = products.get(i).getText().split("-")[0].trim();

            // Convert the array to a list for easier checking
            List<String> items = Arrays.asList(itemsList);

            // Check if the current product is in the desired items list
            if(items.contains(product)) {
                // Click the "ADD TO CART" button for this product
                driver.findElements(By.cssSelector(".product-action button")).get(i).click();

                // Increment the count of added items
                count++;

                // If all desired items have been added, break out of the loop
                if(count == items.size()) {
                    break;
                }
            }
        }
    }
}
