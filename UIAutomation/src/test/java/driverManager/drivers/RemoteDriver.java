package driverManager.drivers;

import driverManager.Configurations;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.remote.BrowserType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.MalformedURLException;
import java.net.URL;

public class RemoteDriver extends Driver{
    private String browserName= Configurations.getBrowser();
    @Override
    WebDriver getDriver(){
        DesiredCapabilities desiredCapabilities=new DesiredCapabilities();
//        ChromeOptions options=new ChromeOptions();
        FirefoxOptions firefoxOptions=new FirefoxOptions();
        switch (browserName.toLowerCase()){

            case "chrome":
                desiredCapabilities.setBrowserName(BrowserType.CHROME);

//                options.addArguments("--headless");
//                options.merge(options);
                break;

            case "firefox":
                desiredCapabilities.setBrowserName(BrowserType.FIREFOX);
//                firefoxOptions.setHeadless(true);
//                firefoxOptions.merge(desiredCapabilities);
                break;
            case "edge":
                desiredCapabilities.setBrowserName(BrowserType.EDGE);
                break;
            default:
                throw new IllegalArgumentException("Provide valid browser name in properties, currently chrome, edge and firefox are supported");
        }



//        desiredCapabilities.setBrowserName(BrowserType.EDGE);
        RemoteWebDriver driver= null;
        try {
//            driver = new RemoteWebDriver(new URL("http://localhost:4444"),desiredCapabilities);
            driver = new RemoteWebDriver(new URL("http://3.110.40.149:4444"),desiredCapabilities);

        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
        return driver;
    }
}
