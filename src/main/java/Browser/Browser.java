package Browser;

import ScreenShot.Capture;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;
import java.time.Duration;

public class Browser {
    public static ExtentReports extentReports = new ExtentReports();
    public static ExtentSparkReporter reporter = new ExtentSparkReporter(System.getProperty("user.dir") + File.separator + "target"+ File.separator+"Reports"+File.separator+"extentReport1.html");
    public static ExtentTest logger1;

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
        extentReports.attachReporter(reporter);
        logger1 = extentReports.createTest("Opening the URL");
        logger1.log(Status.INFO,"Opening the URL ");

        try {
            driver.get(Utility.properties("url"));
            driver.manage().window().maximize();
            actions = new Actions(driver);
            wait = new WebDriverWait(driver, Duration.ofSeconds(10));

            wait.until(ExpectedConditions.titleIs(title));
            logger1.log(Status.PASS,"Opened the URL successfully " );
            Capture.screenShot("HomePageImg");
           // String path = System.getProperty("user.dir")+"/target/ScreenShots/HomePageImg.png";
            String path = "../ScreenShots/HomePageImg.png";
            logger1.addScreenCaptureFromPath(path);

        }
        catch (Exception e){
            System.out.println("Error while navigating the url");
            logger1.log(Status.FAIL, "Failed while the URL ");
        }
        extentReports.flush();
    }

    public static void closeBrowser(){
        try{
            driver.close();
        } catch (Exception e) {
            System.out.println("Error while closing the browser");
        }
    }
}
