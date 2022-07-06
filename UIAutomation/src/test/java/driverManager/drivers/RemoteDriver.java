package driverManager.drivers;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.BrowserType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.MalformedURLException;
import java.net.URL;

public class RemoteDriver extends Driver{


    @Override
    WebDriver getDriver(){
        DesiredCapabilities desiredCapabilities=new DesiredCapabilities();
        desiredCapabilities.setBrowserName(BrowserType.CHROME);
//        desiredCapabilities.setBrowserName(BrowserType.EDGE);
        RemoteWebDriver driver= null;
        try {
            driver = new RemoteWebDriver(new URL("http://localhost:4444/"),desiredCapabilities);
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
        return driver;
    }
}
