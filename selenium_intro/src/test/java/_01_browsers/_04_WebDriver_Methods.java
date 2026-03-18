package _01_browsers;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.lang.reflect.Method;

/**
 * This class demonstrates how to use Java reflection to retrieve and display the methods
 * available in the WebDriver and WebElement interfaces from Selenium WebDriver.
 * It prints the method signatures for WebElement methods to the console.
 */
public class _04_WebDriver_Methods {

    public static void main(String[] args) {

        // Get all public methods of the WebDriver interface
        Method[] m = WebDriver.class.getMethods();

        for(Method m1 : m) {
            // Optionally print WebDriver method names (currently commented out)
            System.out.println(m1.getName());
        }

        // Print a header for WebElement methods
        System.out.println("Web Elements methods");

        // Get all public methods of the WebElement interface
        Method[] webElementMethods = WebElement.class.getMethods();
        for(Method m2 : webElementMethods) {
            // Print the full method signature for each WebElement method
            System.out.println(m2);
        }
    }
}
