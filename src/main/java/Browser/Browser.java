package Browser;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class Browser {

    public static WebDriver driver;
    public static WebDriverWait wait;
    public static Actions actions;
    public static Select select;

    public static void openBrowser(String chrome) throws Exception {
        try {
            String choice = Utility.properties("browser");
            if (choice.equalsIgnoreCase("Chrome"))
                driver = new ChromeDriver();
            else if (choice.equalsIgnoreCase("Edge"))
                driver = new EdgeDriver();
            else if (choice.equalsIgnoreCase("FireFox"))
                driver = new FirefoxDriver();
        } catch (Exception e) {
            System.out.println("Error while opening Browser" + e);
        }
    }

    public static void navigate(String title) throws Exception {

        try {
            driver.get(Utility.properties("url"));
            driver.manage().window().maximize();
            actions = new Actions(driver);
            wait = new WebDriverWait(driver, Duration.ofSeconds(10));

            wait.until(ExpectedConditions.titleIs(title));

        }
        catch (Exception e){
            System.out.println("Error while navigating the url");
        }
    }

    public static void closeBrowser(){
        try{
            driver.close();
        } catch (Exception e) {
            System.out.println("Error while closing the browser");
        }
    }
}
