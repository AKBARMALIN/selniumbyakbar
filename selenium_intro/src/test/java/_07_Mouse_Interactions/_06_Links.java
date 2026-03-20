package _07_Mouse_Interactions;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

/**
 * This class demonstrates how to handle links on a webpage using Selenium WebDriver.
 * It navigates to a practice page, counts and lists all links, counts links in the footer,
 * counts links in the first column of the footer, opens each link in a new tab, and prints the titles of each opened page.
 */
public class _06_Links {

    public static void main(String[] args) {

        // Initialize a new ChromeDriver instance to control the Chrome browser
        WebDriver driver = new ChromeDriver();
        
        // Set an implicit wait of 5 seconds for elements to be available
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        
        // Navigate to the Rahul Shetty Academy Automation Practice page
        driver.get("https://rahulshettyacademy.com/AutomationPractice/");

        // Identify the number of Links on the web page
        List<WebElement> links = driver.findElements(By.tagName("a"));
        System.out.println("The number of links present on the web page are: " + links.size());

        // Print the text of each link
        for(int i = 0; i < links.size(); i++) {
            System.out.println(links.get(i).getText());
        }

        // Count the number of Links on the footer section
        WebElement footerDriver = driver.findElement(By.xpath("//div[@id='gf-BIG']"));
        List<WebElement> footerLinks = footerDriver.findElements(By.tagName("a"));
        System.out.println("The number of links present on the web page are: " + footerLinks.size());

        // Count the number of links present in first column under footer section
        WebElement firstColumnDriver = footerDriver.findElement(By.xpath("table/tbody/tr/td[1]/ul"));
        List<WebElement> firstColumnLinks = firstColumnDriver.findElements(By.tagName("a"));
        System.out.println("The number of links present on the first column are: " + firstColumnLinks.size());

        // Open the each and every link in new tab/window
        for(int i = 1; i < firstColumnLinks.size(); i++) {
            String clickLink = Keys.chord(Keys.CONTROL, Keys.ENTER);
            firstColumnLinks.get(i).sendKeys(clickLink);
        }

        // Switch to each and every window and grab the title of the page.
        Set<String> windows = driver.getWindowHandles();
        Iterator<String> it = windows.iterator();
        while(it.hasNext()) {
            driver.switchTo().window(it.next());
            System.out.println(driver.getTitle());
        }
    }
}
