package ScreenShot;

import Browser.Browser;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import java.io.File;

public class Capture extends Browser {
  static String path;
    public static void screenShot(String name) throws Exception {

        try {
            TakesScreenshot shot = (TakesScreenshot)driver;
            File source = shot.getScreenshotAs(OutputType.FILE);

             path = System.getProperty("user.dir") + File.separator+"target"+ File.separator + "ScreenShots"+ File.separator + name + ".png";
            File destination = new File(path);
            FileUtils.copyFile(source,destination);
        }
        catch (Exception e){
            System.out.println("Error while Taking Screenshot");
        }
        System.out.println(path);
       // return path;
    }
}
