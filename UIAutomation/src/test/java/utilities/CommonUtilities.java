package utilities;

import io.cucumber.java.Scenario;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import java.io.File;
import java.io.IOException;
import java.util.Random;

public class CommonUtilities {
    
    public static void takeScreenShot(Scenario scenario,WebDriver driver){

        byte[] screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
//        byte[] screenshot = ((TakesScreenshot) windowDriver).getScreenshotAs(OutputType.BYTES);
        String screenshotName ="ScreenShot_" + new Random().nextInt(10000);
        File screenshotFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        try {
            FileUtils.copyFile(screenshotFile,new File("target/cucumberScreenshot/"+screenshotName+".png"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        scenario.attach(screenshot,"image/png",screenshotName+".png");
//        scenario.attach(screenshot,"image/png", screenshotName+".png");
    }
}
